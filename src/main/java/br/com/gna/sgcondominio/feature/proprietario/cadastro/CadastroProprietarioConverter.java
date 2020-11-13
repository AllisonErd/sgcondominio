package br.com.gna.sgcondominio.feature.proprietario.cadastro;

import org.springframework.stereotype.Component;

import br.com.gna.sgcondominio.entities.ProprietarioEntity;
import br.com.gna.sgcondominio.feature.proprietario.cadastro.model.CadastroProprietarioForm;
import br.com.gna.sgcondominio.feature.proprietario.cadastro.model.CadastroProprietarioView;

@Component
public class CadastroProprietarioConverter {

	public ProprietarioEntity toProprietarioEntity(CadastroProprietarioForm form) {
		return ProprietarioEntity.builder()
				.nomeProprietario(form.getNome().trim())
				.cpf(form.getCpf().trim())
				.email(form.getEmail().trim())
				.telefone(form.getTelefone().trim())
				.build();
	}

	public CadastroProprietarioView toCadastroProprietarioView(ProprietarioEntity entity) {
		return CadastroProprietarioView.builder()
				.idProprietario(entity.getIdProprietario())
				.nome(entity.getNomeProprietario())
				.email(entity.getEmail())
				.cpf(entity.getCpf())
				.telefone(entity.getTelefone())
				.build();
	}
}
