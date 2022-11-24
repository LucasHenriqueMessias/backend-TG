package com.ads.farmacia.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ads.farmacia.entidades.Fornecedor;
import com.ads.farmacia.servicos.FornecedorServico;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/fornecedores", produces = "application/json")
public class FornecedorRecurso {

	@Autowired
	private FornecedorServico servico;
	
	@GetMapping
	public ResponseEntity<List<Fornecedor>> findAll() {
		List<Fornecedor> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@PostMapping("/fornecedores")
	public Fornecedor criaFornecedor(@RequestBody Fornecedor fornecedor) {
		return FornecedorRepositorio.save(fornecedor);
	}

	// get Fornecedor by id rest api
	@GetMapping("/fornecedores/{id}")
	public ResponseEntity<Fornecedor> getEmployeeById(@PathVariable Long id) {
		Fornecedor fornecedor = FornecedorRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(fornecedor);
	}

	// update Fornecedor rest api

	@PutMapping("/fornecedores/{id}")
	public ResponseEntity<Fornecedor> atualizaFornecedor(@PathVariable Long id, @RequestBody Fornecedor detalhesFornecedor) {
		final Fornecedor fornecedor = FornecedorRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

		produto.setDescricao(detalhesProduto.getDescricao());
		

		Fornecedor atualizaFornecedor = FornecedorRepositorio.save(fornecedor);
		return ResponseEntity.ok(FornecedorRepositorio);
	}

	// delete Fornecedor rest api
	@DeleteMapping("/fornecedores/{id}")
	public ResponseEntity<Map<String, Boolean>> deletaFornEntity(@PathVariable Long id) {
		Optional<Fornecedor> fornecedor = FornecedorRepositorio.findById(id);

		FornecedorRepositorio.deleteById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
