package br.com.gna.sgcondominio.feature.imovel.cadastro;

import br.com.gna.sgcondominio.entities.CondominioEntity;
import br.com.gna.sgcondominio.entities.ImovelEntity;
import br.com.gna.sgcondominio.entities.ProprietarioEntity;
import br.com.gna.sgcondominio.entities.types.StatusImovelType;
import br.com.gna.sgcondominio.feature.imovel.cadastro.model.CadastroImovelForm;
import br.com.gna.sgcondominio.feature.imovel.cadastro.model.CadastroImovelView;
import org.springframework.stereotype.Component;

@Component
public class CadastroImovelConverter {

    public ImovelEntity toImovelEntity(CadastroImovelForm form) {
        return ImovelEntity.builder()
                .numero(form.getNumero())
                .numeroVagasGaragem(form.getVagasGaragem())
                .numeroQuartos(form.getNumeroQuartos())
                .observacao(form.getObservacoes())
                .status(Integer.parseInt(form.getStatus()))
                .proprietario(ProprietarioEntity.builder().idProprietario(Integer.parseInt(form.getIdProprietario())).build())
                .condominio(CondominioEntity.builder().idCondominio(Integer.parseInt(form.getIdCondominio())).build())
                .build();
    }

    public CadastroImovelView toCadastroImovelView(ImovelEntity entity) {
        return CadastroImovelView.builder()
                .idImovel(entity.getIdImovel())
                .numero(entity.getNumero())
                .vagasGaragem(entity.getNumeroVagasGaragem())
                .numeroQuartos(entity.getNumeroQuartos())
                .observacoes(entity.getObservacao())
                .status(entity.getStatus())
                .idProprietario(entity.getProprietario().getIdProprietario())
                .idCondominio(entity.getCondominio().getIdCondominio())
                .build();
    }
}
