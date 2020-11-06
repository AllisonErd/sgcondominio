package br.com.gna.sgcondominio.entities.types;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UsuarioType {

	ADMIN(1, "Administrador"), SINDICO(2, "Síndico"), USUARIO(3, "Usuário"), DEMO(4, "Demostração");

	private final Integer codigo;
	private final String descricao;

	public static UsuarioType valueOfCodigo(final Integer codigo) {
		return Arrays.stream(UsuarioType.values()).filter(s -> s.getCodigo().equals(codigo)).findFirst()
				.orElse(null);
	}

	
	@Override
	public String toString() {
		return this.codigo + " - " + this.descricao;
	}
	
}
