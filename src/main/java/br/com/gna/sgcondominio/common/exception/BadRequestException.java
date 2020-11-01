package br.com.gna.sgcondominio.common.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1705289675212645787L;

	public BadRequestException(String mensagem) {
		super(mensagem);
	}

}
