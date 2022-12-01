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

import com.ads.farmacia.dto.EstoqueDTO;
import com.ads.farmacia.servicos.EstoqueServico;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/estoque", produces = "application/json")
public class EstoqueRecurso {

	@Autowired
	private EstoqueServico servico;

	@GetMapping
	public ResponseEntity<List<EstoqueDTO>> findAll() {
		List<EstoqueDTO> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/estoque/{codOperacao}")
	public ResponseEntity<EstoqueDTO> findById(@PathVariable Integer codOperacao) {
		EstoqueDTO dto = servico.findById(codOperacao);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<EstoqueDTO> insert(@RequestBody EstoqueDTO dto) {
		dto = servico.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/estoque/{codOperacao}").buildAndExpand(dto.getCodOperacao())
				.toUri();

		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/estoque/{codOperacao}")
	public ResponseEntity<EstoqueDTO> update(@PathVariable Integer codOperacao, @RequestBody EstoqueDTO dto) {
		dto = servico.update(CodOperacao, dto);

		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/estoque/{codOperacao}")
	public ResponseEntity<Void> delete(@PathVariable Integer codOperacao) {
		servico.delete(CodOperacao);

		return ResponseEntity.noContent().build();
	}
}
