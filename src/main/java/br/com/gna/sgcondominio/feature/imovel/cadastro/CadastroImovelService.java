package br.com.gna.sgcondominio.feature.imovel.cadastro;

import br.com.gna.sgcondominio.entities.ImovelEntity;
import br.com.gna.sgcondominio.feature.imovel.cadastro.model.CadastroImovelForm;
import br.com.gna.sgcondominio.feature.imovel.cadastro.model.CadastroImovelView;
import br.com.gna.sgcondominio.repository.ImovelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroImovelService {

    private final ImovelRepository imovelRepository;

    private final CadastroImovelConverter converter;

    public CadastroImovelView postCadastroImovel(CadastroImovelForm form) {
        ImovelEntity imovelEntity = converter.toImovelEntity(form);
        imovelEntity = imovelRepository.save(imovelEntity);
        return converter.toCadastroImovelView(imovelEntity);
    }

}
