package br.com.gna.sgcondominio.feature.condominio.cadastro.model;

import br.com.gna.sgcondominio.common.util.RegexUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class CadastroCondominioForm implements Serializable {

    private static final long serialVersionUID = 7157380114822462937L;

    @JsonProperty("nome")
    @NotBlank(message = "Campo obrigatório")
    @Size(max = 50, message = "O valor informado excede o limite de 50 caracteres.")
    private String nome;

    @JsonProperty("telefone")
    @NotNull(message = "Campo obrigatório")
    @Size(max = 11, message = "O valor informado excede o limite de 11 caracteres.")
    @Valid
    @Pattern(regexp = RegexUtil.VALIDA_SOMENTE_NUMEROS, message = "Este campo permite apenas números.")
    private String telefone;

    @JsonProperty("cep")
    @NotNull(message = "Campo obrigatório")
    @Size(max = 8, message = "O valor informado excede o limite de 8 caracteres.")
    @Valid
    @Pattern(regexp = RegexUtil.VALIDA_SOMENTE_NUMEROS, message = "Este campo permite apenas números.")
    private String cep;

    @JsonProperty("rua")
    @NotBlank(message = "Campo obrigatório")
    @Size(max = 50, message = "O valor informado excede o limite de 50 caracteres.")
    private String rua;

    @JsonProperty("numero")
    @NotNull(message = "Campo obrigatório")
    @Size(max = 2, message = "O valor informado excede o limite de 2 caracteres.")
    @Valid
    @Pattern(regexp = RegexUtil.VALIDA_SOMENTE_NUMEROS, message = "Este campo permite apenas números.")
    private String numero;

    @JsonProperty("bairro")
    @NotBlank(message = "Campo obrigatório")
    @Size(max = 30, message = "O valor informado excede o limite de 30 caracteres.")
    private String bairro;

    @JsonProperty("complemento")
    @NotBlank(message = "Campo obrigatório")
    @Size(max = 30, message = "O valor informado excede o limite de 30 caracteres.")
    private String complemento;

    @JsonProperty("cidade")
    @NotBlank(message = "Campo obrigatório")
    @Size(max = 50, message = "O valor informado excede o limite de 50 caracteres.")
    private String cidade;

    @JsonProperty("uf")
    @NotBlank(message = "Campo obrigatório")
    @Size(max = 2, message = "O valor informado excede o limite de 2 caracteres.")
    private String uf;
}
