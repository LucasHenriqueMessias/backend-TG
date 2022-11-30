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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ads.farmacia.dto.ProdutoDTO;
import com.ads.farmacia.servicos.ProdutoServico;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/produtos", produces = "application/json")
public class ProdutoRecurso {

	@Autowired
	private ProdutoServico servico;

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		List<ProdutoDTO> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{sku}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Integer sku) {
		ProdutoDTO dto = servico.findById(sku);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<ProdutoDTO> insert(@RequestBody ProdutoDTO dto) {
		dto = servico.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{sku}").buildAndExpand(dto.getSku()).toUri();

		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{sku}")
	public ResponseEntity<ProdutoDTO> update(@PathVariable Integer sku, @RequestBody ProdutoDTO dto) {
		dto = servico.update(sku, dto);

		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{sku}")
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable Integer sku) {
		servico.delete(sku);

		return ResponseEntity.noContent().build();
	}

}
