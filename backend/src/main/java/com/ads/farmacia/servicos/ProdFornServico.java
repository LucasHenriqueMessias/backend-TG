package com.ads.farmacia.servicos;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ads.farmacia.dto.ProdFornDTO;
import com.ads.farmacia.entidades.ProdForn;
import com.ads.farmacia.repositorios.ProdFornRepositorio;
import com.ads.farmacia.servicos.execoes.EntidadeNaoEncontrada;
import com.ads.farmacia.servicos.execoes.IntegridadeDatabase;

@Service
public class ProdFornServico {

	@Autowired
	private ProdFornRepositorio repositorio;

	@Transactional(readOnly = true)
	public List<ProdFornDTO> findAll() {
		List<ProdForn> lista = repositorio.findAll();
		return lista.stream().map(x -> new ProdFornDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ProdFornDTO findById(Integer codBarras) {
		Optional<ProdForn> obj = repositorio.findById(codBarras);
		ProdForn entidade = obj.orElseThrow(() -> new EntidadeNaoEncontrada("Produto não encontrado"));
		return new ProdFornDTO(entidade);
	}

	@Transactional
	public ProdFornDTO insert(ProdFornDTO dto) {
		ProdForn entidade = new ProdForn();
		entidade.setFornecedor(dto.getFornecedor());
		entidade.setPreco(dto.getPreco());
		entidade.setProduto(dto.getProduto());
		
		entidade = repositorio.save(entidade);
		return new ProdFornDTO(entidade);
	}

	@Transactional
	public ProdFornDTO update(Integer codBarras, ProdFornDTO dto) {
		try {
			ProdForn entidade = repositorio.getOne(codBarras);
			entidade.setProduto(dto.getProduto());
			entidade.setFornecedor(dto.getFornecedor());
			entidade.setPreco(dto.getPreco());
			
			
			entidade = repositorio.save(entidade);
			return new ProdFornDTO(entidade);
		} catch (EntityNotFoundException e) {
			throw new EntidadeNaoEncontrada("Código de Barras não encontrado: " + codBarras);
		}
	}

	public void delete(Integer codBarras) {
		try {
			repositorio.deleteById(codBarras);
		}
		catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontrada("Código de Barras não encontrado: " + codBarras);
		}
		catch (DataIntegrityViolationException e) {
			throw new IntegridadeDatabase("Integridade violada");
		}
	}
}
