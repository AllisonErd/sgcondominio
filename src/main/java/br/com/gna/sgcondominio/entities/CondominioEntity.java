package br.com.gna.sgcondominio.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "condominio")
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class CondominioEntity implements Serializable {

	private static final long serialVersionUID = 8816972924742855774L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cond_id", nullable = false, unique = true, updatable = false)
	private Integer idCondominio;

	@Column(name = "cond_nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "cond_telefone")
	private String telefone;

	@Column(name = "cond", nullable = false, length = 8)
	private String cep;

	@Column(name = "cond_rua")
	private String rua;

	@Column(name = "cond_numero")
	private String numero;

	@Column(name = "cond_bairro")
	private String bairro;

	@Column(name = "cond_complemento")
	private String complemento;

	@Column(name = "cond_cidade")
	private String cidade;

	@Column(name = "cond_estado")
	private String estado;

	@OneToMany(mappedBy = "idImovel")
	private List<ImovelEntity> imoveis;

}
