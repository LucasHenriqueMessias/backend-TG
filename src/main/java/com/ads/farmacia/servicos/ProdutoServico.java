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

import com.ads.farmacia.dto.ProdutoDTO;
import com.ads.farmacia.entidades.Produto;
import com.ads.farmacia.repositorios.ProdutoRepositorio;
import com.ads.farmacia.servicos.execoes.EntidadeNaoEncontrada;
import com.ads.farmacia.servicos.execoes.IntegridadeDatabase;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio repositorio;

	@Transactional(readOnly = true)
	public List<ProdutoDTO> findAll() {
		List<Produto> lista = repositorio.findAll();
		return lista.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ProdutoDTO findById(Integer sku) {
		Optional<Produto> obj = repositorio.findById(sku);
		Produto entidade = obj.orElseThrow(() -> new EntidadeNaoEncontrada("Produto não encontrado"));
		return new ProdutoDTO(entidade);
	}

	@Transactional
	public ProdutoDTO insert(ProdutoDTO dto) {
		Produto entidade = new Produto();
		entidade.setSku(dto.getSku());
		entidade.setReceita(dto.getReceita());
		entidade.setGenerico(dto.getGenerico());
		entidade.setMolecula(dto.getMolecula());
		entidade.setLinkBula(dto.getLinkBula());
		entidade.setRecomendacao(dto.getRecomendacao());
		entidade.setNomeComercial(dto.getNomeComercial());
		entidade.setUnidMedida(dto.getUnidMedida());
		entidade.setDescricao(dto.getDescricao());
		entidade.setTarja(dto.getTarja());
		entidade.setRestricao(dto.getRestricao());
		entidade.setMiligrama(dto.getMiligrama());
		entidade.setDirecionamento(dto.getDescricao());
		entidade.setProdForn(dto.getProdForn());

		entidade = repositorio.save(entidade);
		return new ProdutoDTO(entidade);
	}

	@Transactional
	public ProdutoDTO update(Integer sku, ProdutoDTO dto) {
		try {
			Produto entidade = repositorio.getOne(sku);
			entidade.setSku(dto.getSku());
			entidade.setReceita(dto.getReceita());
			entidade.setGenerico(dto.getGenerico());
			entidade.setMolecula(dto.getMolecula());
			entidade.setLinkBula(dto.getLinkBula());
			entidade.setRecomendacao(dto.getRecomendacao());
			entidade.setNomeComercial(dto.getNomeComercial());
			entidade.setUnidMedida(dto.getUnidMedida());
			entidade.setDescricao(dto.getDescricao());
			entidade.setTarja(dto.getTarja());
			entidade.setRestricao(dto.getRestricao());
			entidade.setMiligrama(dto.getMiligrama());
			entidade.setDirecionamento(dto.getDescricao());
			entidade.setProdForn(dto.getProdForn());

			entidade = repositorio.save(entidade);
			return new ProdutoDTO(entidade);
		} catch (EntityNotFoundException e) {
			throw new EntidadeNaoEncontrada("SKU não encontrado" + sku);
		}
	}

	public void delete(Integer sku) {
		try {
			repositorio.deleteById(sku);
		}
		catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontrada("SKU não encontrado" + sku);
		}
		catch (DataIntegrityViolationException e) {
			throw new IntegridadeDatabase("Integridade violada");
		}
	}

}
