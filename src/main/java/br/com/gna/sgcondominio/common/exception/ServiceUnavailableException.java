package br.com.gna.sgcondominio.common.exception;

public class ServiceUnavailableException extends RuntimeException {

	private static final long serialVersionUID = 7019868466566771252L;

	public ServiceUnavailableException() {
		super("Ops! Parece que um serviço está temporariamente indisponível, tente novamente mais tarde.");
	}

}
