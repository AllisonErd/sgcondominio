package br.com.gna.sgcondominio.feature.usuario.cadastro;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gna.sgcondominio.feature.usuario.cadastro.model.CadastroUsuarioForm;
import br.com.gna.sgcondominio.feature.usuario.cadastro.model.CadastroUsuarioView;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sg_condominio/v1/usuarios")
@RequiredArgsConstructor
public class CadastroUsuarioController {

	private final CadastroUsuarioService service;

	@PostMapping
	public ResponseEntity<CadastroUsuarioView> postCadastroUsuario(@RequestBody @Valid CadastroUsuarioForm form) {
		return ResponseEntity.ok(service.postCadastroUsuario(form));
	}

}
