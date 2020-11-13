package br.com.gna.sgcondominio.feature.proprietario.cadastro;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gna.sgcondominio.feature.proprietario.cadastro.model.CadastroProprietarioForm;
import br.com.gna.sgcondominio.feature.proprietario.cadastro.model.CadastroProprietarioView;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sg_condominio/v1/proprietarios")
@RequiredArgsConstructor
public class CadastroProprietarioController {

	private final CadastroProprietarioService service;
	
	@PostMapping
	public ResponseEntity<CadastroProprietarioView> postCadastroProprietario(@RequestBody @Valid CadastroProprietarioForm form) {
		return ResponseEntity.ok(service.postCadastroProprietario(form));
	}
	
}
