package br.com.gna.sgcondominio.feature.condominio.cadastro.model;

import br.com.gna.sgcondominio.entities.CondominioEntity;
import org.springframework.stereotype.Component;

@Component
public class CadastroCondominioConverter {

    public CondominioEntity toCondominioEntity(CadastroCondominioForm form){
        return CondominioEntity.builder()
                .nome(form.getNome())
                .telefone(form.getTelefone())
                .cep(form.getCep())
                .rua(form.getRua())
                .numero(form.getNumero())
                .bairro(form.getBairro())
                .complemento(form.getComplemento())
                .cidade(form.getCidade())
                .uf(form.getUf())
                .build();
    }

    public CadastroCondominioView toCadastroCondominioView(CondominioEntity entity) {
        return CadastroCondominioView.builder()
                .idCondominio(entity.getIdCondominio())
                .nome(entity.getNome())
                .telefone(entity.getTelefone())
                .cep(entity.getCep())
                .rua(entity.getRua())
                .numero(entity.getNumero())
                .bairro(entity.getBairro())
                .complemento(entity.getComplemento())
                .cidade(entity.getCidade())
                .uf(entity.getUf())
                .build();
    }

}
