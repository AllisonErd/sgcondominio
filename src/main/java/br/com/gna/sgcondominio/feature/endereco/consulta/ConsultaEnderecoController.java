package br.com.gna.sgcondominio.feature.endereco.consulta;

import br.com.gna.sgcondominio.feature.endereco.consulta.model.EnderecoView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/sg_condominio/v1/enderecos")
@RequiredArgsConstructor
public class ConsultaEnderecoController {

    private final ConsultaEnderecoService consultaEnderecoService;

    @GetMapping(value = "/{cep}")
    public ResponseEntity<EnderecoView> getEnderecoByCep(@PathVariable("cep") String cep) {
        return ResponseEntity.ok(consultaEnderecoService.getEnderecoByCep(cep)).getBody();
    }
}
