package br.com.gna.sgcondominio.common.exception;

public class UnauthorizedUserException extends RuntimeException {

	private static final long serialVersionUID = 205873291938304026L;

	public UnauthorizedUserException() {
		super("Acesso não autorizado.");
	}

}
