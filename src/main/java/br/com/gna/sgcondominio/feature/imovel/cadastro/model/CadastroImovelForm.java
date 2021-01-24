package br.com.gna.sgcondominio.feature.imovel.cadastro.model;

import br.com.gna.sgcondominio.common.util.RegexUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CadastroImovelForm implements Serializable {

    private static final long serialVersionUID = 8365943986067554774L;

    @JsonProperty("numero")
    @NotBlank(message = "Campo obrigatório")
    private String numero;

    @JsonProperty("vagas_garagem")
    private String vagasGaragem;

    @JsonProperty("numero_quartos")
    @NotBlank(message = "Campo obrigatório")
    private String numeroQuartos;

    @JsonProperty("observacoes")
    private String observacoes;

    @JsonProperty("status")
    @Valid
    @Pattern(regexp = RegexUtil.VALIDA_STATUS_IMOVEL, message = "O valor informado deve ser 1 ou 3")
    @NotBlank(message = "Campo obrigatório")
    private String status;

    @JsonProperty("id_proprietario")
    @Valid
    @Pattern(regexp = RegexUtil.VALIDA_SOMENTE_NUMEROS, message = "Este campo aceita somente números")
    @NotBlank(message = "Campo obrigatório")
    private String idProprietario;

    @JsonProperty("id_condominio")
    @Valid
    @Pattern(regexp = RegexUtil.VALIDA_SOMENTE_NUMEROS, message = "Este campo aceita somente números")
    @NotBlank(message = "Campo obrigatório")
    private String idCondominio;
}
