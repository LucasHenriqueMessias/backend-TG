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

import com.ads.farmacia.dto.EstoqueDTO;
import com.ads.farmacia.entidades.Estoque;
import com.ads.farmacia.repositorios.EstoqueRepositorio;
import com.ads.farmacia.servicos.execoes.EntidadeNaoEncontrada;
import com.ads.farmacia.servicos.execoes.IntegridadeDatabase;

@Service
public class EstoqueServico {

	@Autowired
	private EstoqueRepositorio repositorio;

	@Transactional(readOnly = true)
	public List<EstoqueDTO> findAll() {
		List<Estoque> lista = repositorio.findAll();
		return lista.stream().map(x -> new EstoqueDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public EstoqueDTO findById(Integer codOperacao) {
		Optional<Estoque> obj = repositorio.findById(codOperacao);
		Estoque entidade = obj.orElseThrow(() -> new EntidadeNaoEncontrada("Estoque não encontrado"));
		return new EstoqueDTO(entidade);
	}

	@Transactional
	public EstoqueDTO insert(EstoqueDTO dto) {
		Estoque entidade = new Estoque();

        entidade.setCodOperacao(dto.getCodOperacao());
        entidade.setLote(dto.getLote());
        entidade.setQtdeCaixa(dto.getQtdeCaixa());
        entidade.setLoja(dto.getLoja());
        entidade.setProduto(dto.getProduto());

		entidade = repositorio.save(entidade);
		return new EstoqueDTO(entidade);
	}

	@Transactional
	public EstoqueDTO update(Integer codOperacao, EstoqueDTO dto) {
		try {
			Estoque entidade = repositorio.getOne(codOperacao);

            entidade.setCodOperacao(dto.getCodOperacao());
            entidade.setLote(dto.getLote());
            entidade.setQtdeCaixa(dto.getQtdeCaixa());
            entidade.setLoja(dto.getLoja());
            entidade.setProduto(dto.getProduto());


			entidade = repositorio.save(entidade);
			return new EstoqueDTO(entidade);
		} catch (EntityNotFoundException e) {
			throw new EntidadeNaoEncontrada("codOperacao não encontrado" + codOperacao);
		}
	}

	public void delete(Integer codOperacao) {
		try {
			repositorio.deleteById(codOperacao);
		}
		catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontrada("codOperacao não encontrado" + codOperacao);
		}
		catch (DataIntegrityViolationException e) {
			throw new IntegridadeDatabase("Integridade violada");
		}
	}

}
