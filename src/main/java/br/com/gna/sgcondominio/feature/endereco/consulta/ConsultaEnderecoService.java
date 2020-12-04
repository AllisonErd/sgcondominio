package br.com.gna.sgcondominio.feature.endereco.consulta;

import br.com.gna.sgcondominio.feature.endereco.EnderecoClient;
import br.com.gna.sgcondominio.feature.endereco.consulta.model.EnderecoView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaEnderecoService {

    private final EnderecoClient enderecoClient;

    public ResponseEntity<EnderecoView> getEnderecoByCep(String cep) {
        return enderecoClient.getEnderecoByCep(cep);
    }

}
