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

import com.ads.farmacia.dto.LojaDTO;
import com.ads.farmacia.servicos.LojaServico;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/lojas", produces = "application/json")
public class LojaRecurso {

	@Autowired
	private LojaServico servico;

	@GetMapping
	public ResponseEntity<List<LojaDTO>> findAll() {
		List<LojaDTO> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{cnpj}")
	public ResponseEntity<LojaDTO> findById(@PathVariable Integer cnpj) {
		LojaDTO dto = servico.findById(cnpj);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<LojaDTO> insert(@RequestBody LojaDTO dto) {
		dto = servico.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cnpj}").buildAndExpand(dto.getCnpj())
				.toUri();

		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{cnpj}")
	public ResponseEntity<LojaDTO> update(@PathVariable Integer cnpj, @RequestBody LojaDTO dto) {
		dto = servico.update(cnpj, dto);

		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{cnpj}")
	public ResponseEntity<Void> delete(@PathVariable Integer cnpj) {
		servico.delete(cnpj);

		return ResponseEntity.noContent().build();
	}
}
