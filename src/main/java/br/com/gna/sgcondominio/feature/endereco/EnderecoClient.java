package br.com.gna.sgcondominio.feature.endereco;

import br.com.gna.sgcondominio.feature.endereco.consulta.model.EnderecoView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url = "https://viacep.com.br/ws", name = "api-consulta-cep")
public interface EnderecoClient {

    @GetMapping(value = "/{cep}/json/", headers = "{ Content-Type: application/json }")
    ResponseEntity<EnderecoView> getEnderecoByCep (@PathVariable("cep") String cep);
}
