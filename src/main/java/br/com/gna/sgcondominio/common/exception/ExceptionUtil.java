package br.com.gna.sgcondominio.common.exception;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.Path.Node;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class ExceptionUtil {

	private ExceptionUtil() {
	}

	public static synchronized String getFieldNameError(ConstraintViolation<?> violation) {
		String campo = "";
		List<Field> fields = new ArrayList<>();

		Class clazz = violation.getLeafBean().getClass();
		while (clazz != Object.class) {
			fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		}
		for (Node propertyPath : violation.getPropertyPath()) {
			for (Field field : fields) {
				if (field.isAnnotationPresent(JsonProperty.class)
						&& propertyPath.getName() != null
						&& propertyPath.getName().equals(field.getName())) {
					JsonProperty annotation = field.getAnnotation(JsonProperty.class);
					campo = annotation.value();
					break;
				}
			}
		}
		return campo;
	}
}
