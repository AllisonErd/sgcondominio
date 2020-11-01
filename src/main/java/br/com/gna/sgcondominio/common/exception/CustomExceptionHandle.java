package br.com.gna.sgcondominio.common.exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import br.com.gna.sgcondominio.common.exception.model.Error;
import br.com.gna.sgcondominio.common.exception.model.Error400;
import br.com.gna.sgcondominio.common.exception.model.Error404;
import br.com.gna.sgcondominio.common.exception.model.Error422;
import br.com.gna.sgcondominio.common.exception.model.ErrorField;
import feign.FeignException;

@ControllerAdvice
public class CustomExceptionHandle extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UnauthorizedUserException.class)
	public final ResponseEntity<Error> exceptionUnauthorizedUser(UnauthorizedUserException ex) {
		return new ResponseEntity<>(new Error(HttpStatus.UNAUTHORIZED.toString(), ex.getMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(ServiceUnavailableException.class)
	public final ResponseEntity<Error> exceptionServiceUnavailable(ServiceUnavailableException ex) {
		return new ResponseEntity<>(new Error(HttpStatus.SERVICE_UNAVAILABLE.toString(), ex.getMessage()),
				HttpStatus.SERVICE_UNAVAILABLE);
	}

	@ExceptionHandler(InternalServerErrorException.class)
	public final ResponseEntity<Error> exceptionInternalServerError(InternalServerErrorException ex) {
		return new ResponseEntity<>(new Error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Error400> exceptionBadRequest(BadRequestException ex) {
		return new ResponseEntity<>(new Error400(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Error404> exceptionNotFound(NotFoundException ex) {
		return new ResponseEntity<>(new Error404(ex.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FunctionalException.class)
	public ResponseEntity<Error422> exceptionFunctional(FunctionalException ex) {
		return new ResponseEntity<>(new Error422(ex.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ExceptionHandler(FeignException.class)
	public ResponseEntity<Object> handleFeignException(FeignException ex, WebRequest request) throws IOException {
		if (ex.status() == 400 && ex.getMessage().contains("content")) {
			String[] content = ex.getMessage().split("content");
			String erroBody = content[content.length - 1];
			// remover colchete inicial
			String erroBodySemConchetInicial = erroBody.substring(2);
			// remover colchet final
			String erroBodyFormatado = erroBodySemConchetInicial.substring(0, erroBodySemConchetInicial.length() - 1);
			ObjectMapper mapper = new ObjectMapper();
			return new ResponseEntity<>(mapper.readTree(erroBodyFormatado), new HttpHeaders(),
					HttpStatus.valueOf(ex.status()));
		} else {
			return new ResponseEntity<>(new Error(Integer.toString(ex.status()), ex.getMessage()),
					HttpStatus.valueOf(ex.status()));
		}
	}

	@ExceptionHandler(value = { ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		Error400 erro = new Error400();
		erro.setCampos(new ArrayList<>());
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			if (violation instanceof FieldError) {
				final FieldError fieldError = (FieldError) violation;
				String fieldErrorName = "";
				try {
					fieldErrorName = ExceptionUtil.getFieldNameError(fieldError.unwrap(ConstraintViolationImpl.class));
				} catch (Exception e) {
					fieldErrorName = fieldError.getField();
				} finally {
					if (fieldErrorName.isEmpty()) {
						fieldErrorName = fieldError.getField();
					}
				}
				erro.getCampos().add(new ErrorField(fieldErrorName, fieldError.getDefaultMessage()));
			} else {
				Set<ConstraintViolation<?>> set = ex.getConstraintViolations();
				for (ConstraintViolation<?> next : set) {
					ErrorField campoErro = new ErrorField(((PathImpl) next.getPropertyPath()).getLeafNode().getName(),
							violation.getMessage());
					erro.getCampos().add(campoErro);
				}
			}
		}
		return handleExceptionInternal(ex, erro, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Error400 erro = new Error400();
		List<ErrorField> errorFields = ex.getBindingResult().getFieldErrors().stream()
				.map(e -> new ErrorField(e.getField(),
						e.getDefaultMessage() != null ? e.getDefaultMessage()
								: String.format("O valor '%s não é válildo para esse campo.", (e.getRejectedValue()))))
				.collect(Collectors.toList());
		erro.setCampos(errorFields);
		return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Error400 erro = new Error400();
		erro.setCampos(Collections.singletonList(new ErrorField(
				((InvalidFormatException) Objects.requireNonNull(ex.getRootCause())).getPath().get(0).getFieldName(),
				String.format("O valor '%s não é do tipo correto.",
						((InvalidFormatException) Objects.requireNonNull(ex.getRootCause())).getValue()))));
		return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		Error400 erro = new Error400();
		erro.setCampos(Collections.singletonList(new ErrorField(((MethodArgumentTypeMismatchException) ex).getName(),
				String.format("O valor '%s não é do tipo correto.", ex.getValue()))));
		return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
	}
}
