package br.com.gna.sgcondominio.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.gna.sgcondominio.entities.types.UsuarioType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity implements Serializable {

	private static final long serialVersionUID = -7510916034611992088L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id", nullable = false, unique = true, updatable = false)
	private Integer idUsuario;

	@Column(name = "usu_nome", nullable = false, length = 20)
	private String nome;

	@Column(name = "usu_email", nullable = false, length = 50)
	private String email;

	@Column(name = "usu_senha", nullable = false, length = 20)
	private String senha;

	@Column(name = "usu_tipo", nullable = false)
	private UsuarioType tipoUsuario;

}
