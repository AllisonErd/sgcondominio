package br.com.gna.sgcondominio.feature.usuario.cadastro;

import org.springframework.stereotype.Component;

import br.com.gna.sgcondominio.entities.UsuarioEntity;
import br.com.gna.sgcondominio.entities.types.UsuarioType;
import br.com.gna.sgcondominio.feature.usuario.cadastro.model.CadastroUsuarioForm;
import br.com.gna.sgcondominio.feature.usuario.cadastro.model.CadastroUsuarioView;

@Component
public class CadastroUsuarioConverter {

	public UsuarioEntity toUsuarioEntity(CadastroUsuarioForm form) {
		return UsuarioEntity.builder()
				.nome(form.getNomeUsuario())
				.email(form.getEmail())
				.senha(form.getSenha())
				.tipoUsuario(Integer.parseInt(form.getTipoUsuario()))
				.build();
	}
	
	public CadastroUsuarioView toCadastroUsuarioView(UsuarioEntity entity) {
		return CadastroUsuarioView.builder()
				.idUsuario(entity.getIdUsuario())
				.nomeUsuario(entity.getNome())
				.email(entity.getEmail())
				.senha(entity.getSenha())
				.tipoUsuatio(UsuarioType.valueOfCodigo(entity.getTipoUsuario()).toString())
				.build();
	}
	
}
