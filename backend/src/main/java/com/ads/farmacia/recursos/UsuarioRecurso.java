package com.ads.farmacia.recursos;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.ads.farmacia.dto.UsuarioDTO;
import com.ads.farmacia.servicos.UsuarioServico;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/usuarios", produces = "application/json")
public class UsuarioRecurso {

	@Autowired
	private UsuarioServico servico;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<UsuarioDTO> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);
	}
	

	@PostMapping("/usuarios/{cpf}")
	public ResponseEntity<UsuarioDTO> insert(@RequestBody UsuarioDTO dto) {
		dto = servico.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}").buildAndExpand(dto.getCpf())
				.toUri();

		return ResponseEntity.created(uri).body(dto);
	}

	// get Usuario by cpf rest api
	@GetMapping("/usuarios/{cpf}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer cnpj) {
		UsuarioDTO dto = servico.findById(cnpj);
		return ResponseEntity.ok().body(dto);
	}




	@PutMapping("/usuarios/{id}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable Integer cpf, @RequestBody UsuarioDTO dto) {
		dto = servico.update(cpf, dto);

		return ResponseEntity.ok().body(dto);
	}
	


	@DeleteMapping("/usuarios/{cpf}")
	public ResponseEntity<Void> delete(@PathVariable Integer cpf) {
		servico.delete(cpf);

		return ResponseEntity.noContent().build();
	}

	
}
