package br.com.gna.sgcondominio.feature.proprietario.cadastro;

import org.springframework.stereotype.Service;

import br.com.gna.sgcondominio.entities.ProprietarioEntity;
import br.com.gna.sgcondominio.feature.proprietario.cadastro.model.CadastroProprietarioForm;
import br.com.gna.sgcondominio.feature.proprietario.cadastro.model.CadastroProprietarioView;
import br.com.gna.sgcondominio.repository.ProprietarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastroProprietarioService {

	private final ProprietarioRepository proprietarioRepository;

	private final CadastroProprietarioConverter converter;

	public CadastroProprietarioView postCadastroProprietario(CadastroProprietarioForm form) {
		ProprietarioEntity proprietarioEntity = converter.toProprietarioEntity(form);
		proprietarioEntity = proprietarioRepository.save(proprietarioEntity);
		return converter.toCadastroProprietarioView(proprietarioEntity);
	}
}
