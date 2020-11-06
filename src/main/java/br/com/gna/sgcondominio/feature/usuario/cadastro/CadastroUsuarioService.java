package br.com.gna.sgcondominio.feature.usuario.cadastro;

import org.springframework.stereotype.Service;

import br.com.gna.sgcondominio.entities.UsuarioEntity;
import br.com.gna.sgcondominio.feature.usuario.cadastro.model.CadastroUsuarioForm;
import br.com.gna.sgcondominio.feature.usuario.cadastro.model.CadastroUsuarioView;
import br.com.gna.sgcondominio.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastroUsuarioService {

	private final UsuarioRepository usuarioRepository;

	private final CadastroUsuarioConverter converter;

	public CadastroUsuarioView postCadastroUsuario(CadastroUsuarioForm form) {
		UsuarioEntity usuarioEntity = converter.toUsuarioEntity(form);
		usuarioEntity = usuarioRepository.save(usuarioEntity);
		return converter.toCadastroUsuarioView(usuarioEntity);
	}

}
