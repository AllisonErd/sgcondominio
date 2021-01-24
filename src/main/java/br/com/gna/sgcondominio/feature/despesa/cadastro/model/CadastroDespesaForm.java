package br.com.gna.sgcondominio.feature.despesa.cadastro.model;

import br.com.gna.sgcondominio.common.util.RegexUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

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
    private String nome;

    @JsonProperty("descricao")
    @NotBlank(message = "Campo obrigatório")
    @Size(max = 100, message = "O valor informado excede o limite de 100 caracteres.")
    private String descricao;

    @Valid
    @DecimalMax(value = "1000.0", message = "Valor informado deve ser menor ou igual a R$1.000,00")
    @Min(value = 0, message = "Campo obrigatório")
    @JsonProperty("valor_despesa")
    private BigDecimal valorDespesa;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Recife")
    @JsonProperty("data_vencimento")
    private LocalDate vencimento;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Recife")
    @JsonProperty("data_pagamento")
    private LocalDate dapaPagamento;

    @JsonProperty("status")
    @Valid
    @Pattern(regexp = RegexUtil.VALIDA_STATUS_DESPESA, message = "O valor informado deve ser 1 ou 2")
    @NotNull(message = "Campo obrigatório")
    private String status;

    @JsonProperty("id_imovel")
    @NotNull(message = "Campo obrigatório")
    private Integer imovel;

}
