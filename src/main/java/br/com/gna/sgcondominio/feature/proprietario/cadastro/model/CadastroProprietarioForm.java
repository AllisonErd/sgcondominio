package br.com.gna.sgcondominio.feature.proprietario.cadastro.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
public class CadastroProprietarioForm implements Serializable {

	private static final long serialVersionUID = 6552806894166353283L;

	@JsonProperty("nome")
	@NotBlank(message = "Campo obrigatório")
	@Size(max = 20, message = "O valor informado excede o limite de 50 caracteres.")
	private String nome;

	@JsonProperty("email")
	@NotBlank(message = "Campo obrigatório")
	@Email(message = "E-mail inválido")
	@Size(max = 20, message = "O valor informado excede o limite de 30 caracteres.")
	private String email;

	@JsonProperty("cpf")
	@NotBlank(message = "Campo obrigatório")
	@Size(max = 20, message = "O valor informado excede o limite de 11 caracteres.")
	@Valid
	@Pattern(regexp = RegexUtil.VALIDA_SOMENTE_NUMEROS, message = "Campo numérico, não permite, pontos, traços, letras ou caracteres especiais.")
	private String cpf;

	@JsonProperty("telefone")
	@NotBlank(message = "Campo obrigatório")
	@Size(max = 20, message = "O valor informado excede o limite de 11 caracteres.")
	@Valid
	@Pattern(regexp = RegexUtil.VALIDA_SOMENTE_NUMEROS, message = "Campo numérico, não permite, pontos, traços, letras ou caracteres especiais.")
	private String telefone;

}
