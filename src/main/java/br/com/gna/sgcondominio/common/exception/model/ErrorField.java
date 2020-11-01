package br.com.gna.sgcondominio.common.exception.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ErrorField {

	private String campo;
	private String mensagem;
	
}
