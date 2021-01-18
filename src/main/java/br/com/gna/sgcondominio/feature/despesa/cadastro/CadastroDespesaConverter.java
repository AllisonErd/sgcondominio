package br.com.gna.sgcondominio.feature.despesa.cadastro;

import br.com.gna.sgcondominio.entities.DespesaEntity;
import br.com.gna.sgcondominio.entities.ImovelEntity;
import br.com.gna.sgcondominio.entities.types.StatusDespesaType;
import br.com.gna.sgcondominio.feature.despesa.cadastro.model.CadastroDespesaForm;
import br.com.gna.sgcondominio.feature.despesa.cadastro.model.CadastroDespesaView;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CadastroDespesaConverter {

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public DespesaEntity toDespesaEntity (CadastroDespesaForm form) {
        return DespesaEntity.builder()
                .nome(form.getNome())
                .descricao(form.getDescricao())
                .valorDespesa(form.getValorDespesa())
                .dataDespesa(LocalDate.now())
                .dataVencimento(LocalDate.parse(form.getVencimento().format(dateFormatter)))
                .dataPagamento(LocalDate.parse(form.getDapaPagamento().format(dateFormatter)))
                .status(StatusDespesaType.EM_ABERTO)
                .imovel(ImovelEntity.builder().idImovel(form.getImovel()).build())
                .build();
    }

    public CadastroDespesaView toCadastroDespesaView (DespesaEntity entity) {
        return CadastroDespesaView.builder()
                .idDespesa(entity.getIdDespesa())
                
                .build();
    }

}
