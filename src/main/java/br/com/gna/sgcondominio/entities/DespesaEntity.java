package br.com.gna.sgcondominio.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import br.com.gna.sgcondominio.entities.types.StatusDespesaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "despesa")
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class DespesaEntity implements Serializable{

	private static final long serialVersionUID = 4969508974626652287L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "des_id", nullable = false, unique = true, updatable = false)
	private Integer idDespesa;
	
	@Column(name = "des_nome", nullable = false, length = 30)
	private String nome;
	
	@Column(name = "des_descricao", nullable = false, length = 100)
	private String descricao;
	
	@Column(name = "des_valor", nullable = false, scale = 2)
	private BigDecimal valorDespesa;
	
	@Column(name = "des_data")
	@CreationTimestamp
	private LocalDate dataDespesa;
	
	@Column(name = "des_vencimento", nullable = false)
	private LocalDate dataVencimento;
	
	@Column(name = "des_pagamento")
	private LocalDate dataPagamento;
	
	@Column(name = "des_status", nullable = false)
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "des_imv_id", nullable = false)
	private ImovelEntity imovel;
	
	
	
	
	
	
}
