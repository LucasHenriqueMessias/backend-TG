package com.ads.farmacia.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ads.farmacia.entidades.Loja;
import com.ads.farmacia.servicos.LojaServico;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/lojas", produces = "application/json")
public class LojaRecurso {

	@Autowired
	private LojaServico servico;
	
	@GetMapping
	public ResponseEntity<List<Loja>> findAll() {
		List<Loja> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);
	}
		
	@PostMapping("/lojas")
	public Loja criaLojas(@RequestBody Loja loja) {
		return LojaRepositorio.save(loja);
	}

	// get produtos by id rest api
	@GetMapping("/lojas/{id}")
	public ResponseEntity<Loja> getEmployeeById(@PathVariable Long id) {
		Loja loja = LojaRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(loja);
	}

	// update product rest api

	@PutMapping("/lojas/{id}")
	public ResponseEntity<Loja> atualizaLoja(@PathVariable Long id, @RequestBody Loja detalhesLoja) {
		final Loja loja = produtoRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

		produto.setDescricao(detalhesProduto.getDescricao());
		

		Loja atualizaLoja = LojaRepositorio.save(loja);
		return ResponseEntity.ok(atualizaLoja);
	}

	// delete produto rest api
	@DeleteMapping("/lojas/{id}")
	public ResponseEntity<Map<String, Boolean>> deletaLojaEntity(@PathVariable Long id) {
		Optional<Loja> loja = lojaRepositorio.findById(id);

		lojaRepositorio.deleteById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
