package br.com.gna.sgcondominio.feature.despesa.cadastro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CadastroDespesaView implements Serializable {

    private static final long serialVersionUID = 3666010514965097413L;

    @JsonProperty("id_despesa")
    private Integer idDespesa;

    @JsonProperty("nome_despesa")
    private String nomeDespesa;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("valor_despesa")
    private BigDecimal valorDespesa;

    @JsonProperty("data_vencimento")
    private String dataVencimento;

    @JsonProperty("status")
    private Integer status;
}
