package br.com.gna.sgcondominio.common.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2838631120650176947L;

	public NotFoundException(String mensagem) {
		super(mensagem);
	}

}
