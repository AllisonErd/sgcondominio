package br.com.gna.sgcondominio.common.exception.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error400 extends Error {

	public Error400() {
		super("400", "Solicitação Imprópria");
	}

	public Error400(String mensagem) {
		super("400", mensagem);
	}

	private List<ErrorField> campos = new ArrayList<>();

}
