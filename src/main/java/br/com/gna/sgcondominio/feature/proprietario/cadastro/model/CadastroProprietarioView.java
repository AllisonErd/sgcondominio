package br.com.gna.sgcondominio.feature.proprietario.cadastro.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CadastroProprietarioView implements Serializable{

	private static final long serialVersionUID = 3151395607176106320L;

	@JsonProperty("id_proprietario")
	private Integer idProprietario;
	
	@JsonProperty("nome")
	private String nome;

	@JsonProperty("email")
	private String email;

	@JsonProperty("cpf")
	private String cpf;

	@JsonProperty("telefone")
	private String telefone;
	
}
