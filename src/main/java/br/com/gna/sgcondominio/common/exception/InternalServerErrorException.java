package br.com.gna.sgcondominio.common.exception;

public class InternalServerErrorException extends RuntimeException {

	private static final long serialVersionUID = 5536381340850327532L;

	public InternalServerErrorException() {
		super("Ocorreu um erro inesperado, tente novamente mais tarde.");
	}

}
