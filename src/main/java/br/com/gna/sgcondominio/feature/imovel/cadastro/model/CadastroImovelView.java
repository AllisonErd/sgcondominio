package br.com.gna.sgcondominio.feature.imovel.cadastro.model;

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
public class CadastroImovelView implements Serializable {

    private static final long serialVersionUID = 4942483733811982917L;

    @JsonProperty("id_imovel")
    private Integer idImovel;

    @JsonProperty("numero")
    private String numero;

    @JsonProperty("vagas_garagem")
    private String vagasGaragem;

    @JsonProperty("numero_quartos")
    private String numeroQuartos;

    @JsonProperty("observacoes")
    private String observacoes;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("id_proprietario")
    private Integer idProprietario;

    @JsonProperty("id_condominio")
    private Integer idCondominio;

}
