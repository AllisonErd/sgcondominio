package br.com.gna.sgcondominio.feature.condominio.cadastro.model;

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
public class CadastroCondominioView implements Serializable {

    private static final long serialVersionUID = -93130469271834308L;

    @JsonProperty("id_condominio")
    private Integer idCondominio;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("rua")
    private String rua;

    @JsonProperty("numero")
    private String numero;

    @JsonProperty("bairro")
    private String bairro;

    @JsonProperty("complemento")
    private String complemento;

    @JsonProperty("cidade")
    private String cidade;

    @JsonProperty("uf")
    private String uf;
}
