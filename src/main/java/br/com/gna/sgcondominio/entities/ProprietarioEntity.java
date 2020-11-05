package br.com.gna.sgcondominio.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "proprietario")
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProprietarioEntity implements Serializable{

	private static final long serialVersionUID = -895101738163866842L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prop_id", nullable = false, unique = true, updatable = false)
	@EqualsAndHashCode.Include
	private Integer idProprietario;
	
	@Column(name = "prop_nome", nullable = false, length = 50)
	private String nomeProprietario;
	
	@Column(name = "prop_cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "prop_telefone", nullable = false, length = 11)
	private String telefone;
	
	@Column(name = "prop_email", nullable = false, length = 30)
	private String email;
	
	@OneToMany(mappedBy = "idImovel", fetch = FetchType.EAGER)
	private List<ImovelEntity> imoveis;
	
}
