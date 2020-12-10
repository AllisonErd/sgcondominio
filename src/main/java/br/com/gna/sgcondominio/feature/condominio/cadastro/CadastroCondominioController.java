package br.com.gna.sgcondominio.feature.condominio.cadastro;

import br.com.gna.sgcondominio.feature.condominio.cadastro.model.CadastroCondominioForm;
import br.com.gna.sgcondominio.feature.condominio.cadastro.model.CadastroCondominioView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sg_condominio/v1/condominios")
@RequiredArgsConstructor
public class CadastroCondominioController {

    private final CadastroCondominioService service;

    @PostMapping
    public ResponseEntity<CadastroCondominioView> postCadastroCondominio(@RequestBody CadastroCondominioForm form) {
        return ResponseEntity.ok(service.postCadastroCondominio(form));
    }
}
