package br.com.gna.sgcondominio.feature.proprietario.cadastro.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CadastroProprietarioForm implements Serializable{
	
	private static final long serialVersionUID = 6552806894166353283L;

	
	private String nomeProprietario;
	
}
