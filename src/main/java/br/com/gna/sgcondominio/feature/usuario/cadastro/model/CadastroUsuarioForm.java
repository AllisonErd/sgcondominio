package br.com.gna.sgcondominio.feature.usuario.cadastro.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gna.sgcondominio.common.util.RegexUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class CadastroUsuarioForm implements Serializable {

	private static final long serialVersionUID = -5278371126228296027L;

	@JsonProperty("nome_usuario")
	@NotBlank(message = "Campo obrigatório")
	@Size(max = 20, message = "O valor informado excede o limite de 20 caracteres.")
	private String nomeUsuario;

	@JsonProperty("email")
	@NotBlank(message = "Campo obrigatório")
	@Size(max = 50, message = "O valor informado excede o limite de 50 caracteres.")
	@Email(message = "E-mail informado é inválido.")
	private String email;

	@JsonProperty("senha")
	@NotBlank(message = "Campo obrigatório")
	@Size(max = 20, message = "O valor informado excede o limite de 20 caracteres.")
	private String senha;

	@JsonProperty("tipo_usuario")
	@Valid
	@Pattern(regexp = RegexUtil.VALIDA_TIPO_USUARIO, message = "O valor informado deve ser 1, 2, 3 ou 4.")
	@NotNull(message = "Campo obrigatório")
	private String tipoUsuario;

}
