package br.com.gna.sgcondominio.feature.despesa.cadastro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CadastroDespesaForm implements Serializable {

    private static final long serialVersionUID = -3579090128181848889L;

    @JsonProperty("nome")
    @NotBlank(message = "Campo obrigatório")
    @Size(max = 30, message = "O valor informado excede o limite de 30 caracteres.")
    public String nome;

    @JsonProperty("descricao")
    @NotBlank(message = "Campo obrigatório")
    @Size(max = 100, message = "O valor informado excede o limite de 100 caracteres.")
    public String descricao;

    @JsonProperty("valor_despesa")
    public BigDecimal valorDespesa;

    @JsonProperty("data_despesa")
    public LocalDate dataDespesa;

    @JsonProperty("data_vencimento")
    public LocalDate vencimento;

    @JsonProperty("data_pagamento")
    public LocalDate dapaPagamento;

    @JsonProperty("status")
    public String status;

    @JsonProperty("id_imovel")
    public Integer imovel;

}
