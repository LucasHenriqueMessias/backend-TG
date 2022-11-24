package com.ads.farmacia.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ads.farmacia.entidades.Usuario;
import com.ads.farmacia.servicos.UsuarioServico;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/usuarios", produces = "application/json")
public class UsuarioRecurso {

	@Autowired
	private UsuarioServico servico;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);
	}
	

	@PostMapping("/usuarios")
	public	Usuario criaUsuario(@RequestBody Usuario usuario) {
		return UsuarioRecurso.save(usuario);
	}

	// get Usuario by id rest api
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getEmployeeById(@PathVariable Long id) {
		Usuario usuario = UsuarioRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(usuario);
	}

	// update Usuario rest api

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> atualizaUsuario(@PathVariable Long id, @RequestBody Usuario detalhesUsuario) {
		final Usuario usuario = UsuarioRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

		Usuario.setSenha(detalhesUsuario.getSenha());
		Usuario.setNome(detalhesUsuario.getNome());
		Usuario.setEmail(detalhesUsuario.getEmail());
		Usuario.setCargo(detalhesUsuario.getCargo());
		Usuario.setTelefone(detalhesUsuario.getTelefone());
		Usuario.setSituacao(detalhesUsuario.getSituacao());
		Usuario.setLoja(detalhesUsuario.getLoja());


		Produto atualizaUsuario = UsuarioRepositorio.save(usuario);
		return ResponseEntity.ok(atualizaUsuario);
	}

	// delete Usuario rest api
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Map<String, Boolean>> deletaUsuEntity(@PathVariable Long id) {
		Optional<Usuario> usuario = UsuarioRepositorio.findById(id);

		UsuarioRepositorio.deleteById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	
}
