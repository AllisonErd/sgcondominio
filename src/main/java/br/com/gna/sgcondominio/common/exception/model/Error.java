package br.com.gna.sgcondominio.common.exception.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Error {

	private final String codigo;
	private final String mensagem;
	
}
