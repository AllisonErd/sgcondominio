package br.com.gna.sgcondominio.feature.condominio.cadastro;

import br.com.gna.sgcondominio.entities.CondominioEntity;
import br.com.gna.sgcondominio.feature.condominio.cadastro.model.CadastroCondominioForm;
import br.com.gna.sgcondominio.feature.condominio.cadastro.model.CadastroCondominioView;
import br.com.gna.sgcondominio.repository.CondominioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroCondominioService {

    private final CondominioRepository repository;

    private final CadastroCondominioConverter converter;

    public CadastroCondominioView postCadastroCondominio(CadastroCondominioForm form) {
        CondominioEntity entity = converter.toCondominioEntity(form);
        entity = repository.save(entity);
        return converter.toCadastroCondominioView(entity);
    }
}
