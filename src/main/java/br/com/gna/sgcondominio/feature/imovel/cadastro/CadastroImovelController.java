package br.com.gna.sgcondominio.feature.imovel.cadastro;

import br.com.gna.sgcondominio.feature.imovel.cadastro.model.CadastroImovelForm;
import br.com.gna.sgcondominio.feature.imovel.cadastro.model.CadastroImovelView;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sg_condominio/v1/imoveis")
@RequiredArgsConstructor
public class CadastroImovelController {

    private final CadastroImovelService cadastroImovelService;

    @PostMapping
    public ResponseEntity<CadastroImovelView> postCadastroImovel(@RequestBody CadastroImovelForm form) {
        return ResponseEntity.ok(cadastroImovelService.postCadastroImovel(form));
    }

}
