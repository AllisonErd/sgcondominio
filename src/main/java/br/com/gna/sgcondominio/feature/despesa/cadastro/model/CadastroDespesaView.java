package br.com.gna.sgcondominio.feature.despesa.cadastro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CadastroDespesaView implements Serializable {

    private static final long serialVersionUID = 3666010514965097413L;

    @JsonProperty("id_despesa")
    public Integer idDespesa;

    @JsonProperty("nome_despesa")
    public String nomeDespesa;
}
