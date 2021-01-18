package br.com.gna.sgcondominio.feature.despesa.cadastro.model;

import br.com.gna.sgcondominio.common.util.RegexUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
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

    @DecimalMax(value = "1000.0", message = "Valor informado deve ser menor ou igual a R$1.000,00")
    @DecimalMin("0.0")
    @NotNull(message = "Campo obrigatório")
    @JsonProperty("valor_despesa")
    public BigDecimal valorDespesa;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Recife")
    @JsonProperty("data_vencimento")
    public LocalDate vencimento;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Recife")
    @JsonProperty("data_pagamento")
    public LocalDate dapaPagamento;

    @JsonProperty("status")
    @Valid
    @Pattern(regexp = RegexUtil.VALIDA_STATUS_DESPESA, message = "O valor informado deve ser 1 ou 2")
    @NotNull(message = "Campo obrigatório")
    public String status;

    @JsonProperty("id_imovel")
    @NotNull(message = "Campo obrigatório")
    public Integer imovel;

}
