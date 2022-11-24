package com.ads.farmacia.recursos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ads.farmacia.entidades.Produto;
import com.ads.farmacia.exception.ResourceNotFoundException;
import com.ads.farmacia.repositorios.ProdutoRepositorio;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/produtos", 
	produces = "application/json")
public class ProdutoRecurso {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> lista = produtoRepositorio.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@PostMapping("/produtos")
	public Produto criaProduto(@RequestBody Produto produto) {
		return produtoRepositorio.save(produto);
	}

	// get produtos by id rest api
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> getEmployeeById(@PathVariable Long id) {
		Produto produto = produtoRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(produto);
	}

	// update product rest api

	@PutMapping("/produtos/{id}")
	public ResponseEntity<Produto> atualizaProduto(@PathVariable Long id, @RequestBody Produto detalhesProduto) {
		final Produto produto = produtoRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

		produto.setDescricao(detalhesProduto.getDescricao());
		produto.setDirecionamento(detalhesProduto.getDirecionamento());
		produto.setGenerico(detalhesProduto.getGenerico());
		produto.setLinkBula(detalhesProduto.getLinkBula());
		produto.setMiligrama(detalhesProduto.getMiligrama());
		produto.setMolecula(detalhesProduto.getMolecula());
		produto.setNomeComercial(detalhesProduto.getNomeComercial());
		produto.setProdForn(detalhesProduto.getProdForn());
		produto.setReceita(detalhesProduto.getReceita());
		produto.setRecomendacao(detalhesProduto.getRecomendacao());
		produto.setRestricao(detalhesProduto.getRestricao());
		produto.setSku(detalhesProduto.getSku());
		produto.setTarja(detalhesProduto.getTarja());
		produto.setUnidMedida(detalhesProduto.getUnidMedida());

		Produto atualizaProduto = produtoRepositorio.save(produto);
		return ResponseEntity.ok(atualizaProduto);
	}

	// delete produto rest api
	@DeleteMapping("/produtos/{id}")
	public ResponseEntity<Map<String, Boolean>> deletaProduEntity(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepositorio.findById(id);

		produtoRepositorio.deleteById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
