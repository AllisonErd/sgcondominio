package br.com.gna.sgcondominio.feature.despesa.cadastro;

import br.com.gna.sgcondominio.entities.DespesaEntity;
import br.com.gna.sgcondominio.feature.despesa.cadastro.model.CadastroDespesaForm;
import br.com.gna.sgcondominio.feature.despesa.cadastro.model.CadastroDespesaView;
import br.com.gna.sgcondominio.repository.DespesaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroDespesaService {

    private final DespesaRepository despesaRepository;

    private final CadastroDespesaConverter cadastroDespesaConverter;

    public CadastroDespesaView postCadastroDespesa(CadastroDespesaForm form) {
        DespesaEntity despesaEntity = cadastroDespesaConverter.toDespesaEntity(form);
        despesaEntity = despesaRepository.save(despesaEntity);
        return cadastroDespesaConverter.toCadastroDespesaView(despesaEntity);
    }

}
