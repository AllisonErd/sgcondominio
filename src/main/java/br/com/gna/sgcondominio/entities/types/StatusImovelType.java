package br.com.gna.sgcondominio.entities.types;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusImovelType {

	DISPONIVEL(1, "Disponível"), ALUGADO(2, "Alugado"), A_VENDA(3, "A Venda");

	private final Integer codigo;
	private final String descricao;

	public StatusImovelType valueOfCodigo(final Integer codigo) {
		return Arrays.stream(StatusImovelType.values()).filter(s -> s.getCodigo().equals(codigo)).findAny()
				.orElseThrow(() -> new RuntimeException("Valor não encontrado para StatusImovelType: " + codigo));
	}

}
