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
import com.ads.farmacia.dto.ProdFornDTO;
import com.ads.farmacia.servicos.ProdFornServico;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/prodforns", produces = "application/json")
public class ProdFornRecurso {

	@Autowired
	private ProdFornServico servico;
	
	@GetMapping
	public ResponseEntity<List<ProdFornDTO>> findAll() {
		List<ProdFornDTO> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping("/prodforns/{codBarras}")
	public ResponseEntity<ProdFornDTO> insert(@RequestBody ProdFornDTO dto) {
		dto = servico.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codBarras}").buildAndExpand(dto.getCodBarras())
				.toUri();

		return ResponseEntity.created(uri).body(dto);
	}

	// get prodForn by id rest api
	@GetMapping(value = "/{codBarras}")
	public ResponseEntity<ProdFornDTO> findById(@PathVariable Integer codBarras) {
		ProdFornDTO dto = servico.findById(codBarras);
		return ResponseEntity.ok().body(dto);
	}

	// update ProdForn rest api

	@PutMapping("/prodforns/{codBarras}")
	public ResponseEntity<ProdFornDTO> update(@PathVariable Integer codBarras, @RequestBody ProdFornDTO dto) {
		dto = servico.update(codBarras, dto);

		return ResponseEntity.ok().body(dto);
	}
	
	// delete ProdForn rest api
	@DeleteMapping("/prodforns/{codBarras}")
	public ResponseEntity<Void> delete(@PathVariable Integer cnpj) {
		servico.delete(cnpj);

		return ResponseEntity.noContent().build();
	}

}
