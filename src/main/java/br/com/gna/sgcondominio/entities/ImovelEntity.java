package br.com.gna.sgcondominio.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "imovel")
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class ImovelEntity implements Serializable{

	private static final long serialVersionUID = -3495044238835977958L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "imv_id", nullable = false, unique = true, updatable = false)
	private Integer idImovel;
	
	@Column(name = "imv_numero")
	private String numero;
	
	@Column(name = "imv_vagas_garagem")
	private String numeroVagasGaragem;
	
	@Column(name = "imv_num_quartos")
	private String numeroQuartos;
	
	@Column(name = "imv_obs")
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name = "imv_prop_id")
	private ProprietarioEntity proprietario;
	
	@OneToOne
	@JoinColumn(name = "imv_cond_id")
	private CondominioEntity condominio;
	
	@OneToMany(mappedBy = "idDespesa", fetch = FetchType.EAGER)
	private List<DespesaEntity> despesas;
	
}
