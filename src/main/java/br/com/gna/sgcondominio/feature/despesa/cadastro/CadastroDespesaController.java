package br.com.gna.sgcondominio.feature.despesa.cadastro;

import br.com.gna.sgcondominio.feature.despesa.cadastro.model.CadastroDespesaForm;
import br.com.gna.sgcondominio.feature.despesa.cadastro.model.CadastroDespesaView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sg_condominio/v1/despesas")
@RequiredArgsConstructor
public class CadastroDespesaController {

    private final CadastroDespesaService cadastroDespesaService;

    @PostMapping
    public ResponseEntity<CadastroDespesaView> postCadastroDespesaForm(@RequestBody CadastroDespesaForm form) {
        return ResponseEntity.ok(cadastroDespesaService.postCadastroDespesa(form));
    }

}
