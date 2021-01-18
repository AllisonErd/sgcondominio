package br.com.gna.sgcondominio.feature.despesa.cadastro;

import br.com.gna.sgcondominio.feature.despesa.cadastro.model.CadastroDespesaForm;
import br.com.gna.sgcondominio.feature.despesa.cadastro.model.CadastroDespesaView;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Service
@Log4j
@RequiredArgsConstructor
public class CadastroDespesaService {

    private final CadastroDespesaConverter cadastroDespesaConverter;

    public CadastroDespesaView postCadastroDespesa (CadastroDespesaForm form) {

    }

}
