package com.ads.farmacia.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ads.farmacia.entidades.ProdForn;
import com.ads.farmacia.servicos.ProdFornServico;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/prodforns", produces = "application/json")
public class ProdFornRecurso {

	@Autowired
	private ProdFornServico servico;
	
	@GetMapping
	public ResponseEntity<List<ProdForn>> findAll() {
		List<ProdForn> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping("/prodforns")
	public prodForn criaProdforn(@RequestBody ProdForn prodforns) {
		return ProdFornRepositorio.save(ProdForn);
	}

	// get prodForn by id rest api
	@GetMapping("/prodforns/{id}")
	public ResponseEntity<ProdForn> getEmployeeById(@PathVariable Long id) {
		ProdForn prodforns = ProdFornRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(ProdForn);
	}

	// update ProdForn rest api

	@PutMapping("/prodforns/{id}")
	public ResponseEntity<ProdForn> atualizaProduto(@PathVariable Long id, @RequestBody ProdForn detalhesProdForn) {
		final ProdForn prodForn = produtoRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		
		
		ProdForn.setPreco(detalhesProdForn.getPreco());
		ProdForn.setProduto(detalhesProdForn.getProduto());
		ProdForn.setFornecedor(detalhesProdForn.getFornecedor());

		ProdForn atualizaProdForn = ProdFornRepositorio.save(prodForn);
		return ResponseEntity.ok(atualizaProdForn);
	}

	// delete ProdForn rest api
	@DeleteMapping("/prodforns/{id}")
	public ResponseEntity<Map<String, Boolean>> deletaProdForn(@PathVariable Long id) {
		Optional<ProdForn> prodforns = ProdFornRepositorio.findById(id);

		ProdFornRepositorio.deleteById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
