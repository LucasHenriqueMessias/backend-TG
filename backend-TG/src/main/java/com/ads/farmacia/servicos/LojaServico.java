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

import com.ads.farmacia.dto.LojaDTO;
import com.ads.farmacia.entidades.Loja;
import com.ads.farmacia.repositorios.LojaRepositorio;
import com.ads.farmacia.servicos.execoes.EntidadeNaoEncontrada;
import com.ads.farmacia.servicos.execoes.IntegridadeDatabase;

@Service
public class LojaServico {

	@Autowired
	private LojaRepositorio repositorio;

	@Transactional(readOnly = true)
	public List<LojaDTO> findAll() {
		List<Loja> lista = repositorio.findAll();
		return lista.stream().map(x -> new LojaDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public LojaDTO findById(Integer cnpj) {
		Optional<Loja> obj = repositorio.findById(cnpj);
		Loja entidade = obj.orElseThrow(() -> new EntidadeNaoEncontrada("Loja não encontrada"));
		return new LojaDTO(entidade);
	}

	@Transactional
	public LojaDTO insert(LojaDTO dto) {
		Loja entidade = new Loja();
		entidade.setCnpj(dto.getCnpj());
		entidade.setComplemento(dto.getComplemento());
		entidade.setCidade(dto.getCidade());
		entidade.setEstoques(dto.getEstoques());
		entidade.setFranquia(dto.getFranquia());
		entidade.setLogradouro(dto.getLogradouro());
		entidade.setNumero(dto.getNumero());
		entidade.setIbge(dto.getIbge());
		entidade.setUf(dto.getUf());
		entidade.setMovimentacoes(dto.getMovimentacoes());
		entidade.setUsuarios(dto.getUsuarios());
		entidade.setPedidos(dto.getPedidos());
		entidade.setTelefone(dto.getTelefone());
		entidade.setCep(dto.getCep());

		entidade = repositorio.save(entidade);
		return new LojaDTO(entidade);
	}

	@Transactional
	public LojaDTO update(Integer cnpj, LojaDTO dto) {
		try {
			Loja entidade = repositorio.getOne(cnpj);
			entidade.setCnpj(dto.getCnpj());
			entidade.setComplemento(dto.getComplemento());
			entidade.setCidade(dto.getCidade());
			entidade.setEstoques(dto.getEstoques());
			entidade.setFranquia(dto.getFranquia());
			entidade.setCidade(dto.getLogradouro());
			entidade.setNumero(dto.getNumero());
			entidade.setIbge(dto.getIbge());
			entidade.setUf(dto.getUf());
			entidade.setMovimentacoes(dto.getMovimentacoes());
			entidade.setUsuarios(dto.getUsuarios());
			entidade.setPedidos(dto.getPedidos());
			entidade.setTelefone(dto.getTelefone());
			entidade.setCep(dto.getCep());

			entidade = repositorio.save(entidade);
			return new LojaDTO(entidade);
		} catch (EntityNotFoundException e) {
			throw new EntidadeNaoEncontrada("CNPJ não encontrada" + cnpj);
		}
	}

	public void delete(Integer cnpj) {
		try {
			repositorio.deleteById(cnpj);
		}
		catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontrada("CNPJ não encontrada" + cnpj);
		}
		catch (DataIntegrityViolationException e) {
			throw new IntegridadeDatabase("Integridade violada");
		}
	}

}
