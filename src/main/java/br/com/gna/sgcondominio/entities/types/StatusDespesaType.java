package br.com.gna.sgcondominio.entities.types;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusDespesaType {

	EM_ABERTO(1, "Em Aberto"), PAGA(2, "Paga");

	private final Integer codigo;
	private final String descricao;

	public StatusDespesaType valueOfCodigo(final Integer codigo) {
		return Arrays.stream(StatusDespesaType.values()).filter(s -> s.getCodigo().equals(codigo)).findAny()
				.orElseThrow(() -> new RuntimeException("Valor não encontrado para StatusDespesaType: " + codigo));
	}

}
