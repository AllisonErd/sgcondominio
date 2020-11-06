package br.com.gna.sgcondominio.feature.usuario.cadastro.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder
@JsonInclude(Include.NON_NULL)
public class CadastroUsuarioView implements Serializable {

	private static final long serialVersionUID = -7207236410749522979L;

	@JsonProperty("id_usuario")
	private Integer idUsuario;

	@JsonProperty("nome_usuario")
	private String nomeUsuario;

	@JsonProperty("email")
	private String email;

	@JsonProperty("senha")
	private String senha;

	@JsonProperty("tipo_usuario")
	private String tipoUsuatio;

}
