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

import com.ads.farmacia.dto.FornecedorDTO;
import com.ads.farmacia.entidades.Fornecedor;
import com.ads.farmacia.repositorios.FornecedorRepositorio;
import com.ads.farmacia.servicos.execoes.EntidadeNaoEncontrada;
import com.ads.farmacia.servicos.execoes.IntegridadeDatabase;

@Service
public class FornecedorServico {

	@Autowired
	private FornecedorRepositorio repositorio;

	@Transactional(readOnly = true)
	public List<FornecedorDTO> findAll() {
		List<Fornecedor> lista = repositorio.findAll();
		return lista.stream().map(x -> new FornecedorDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public FornecedorDTO findById(Integer cnpj) {
		Optional<Fornecedor> obj = repositorio.findById(cnpj);
		Fornecedor entidade = obj.orElseThrow(() -> new EntidadeNaoEncontrada("Fornecedor não encontrado"));
		return new FornecedorDTO(entidade);
	}

	@Transactional
	public FornecedorDTO insert(FornecedorDTO dto) {
		Fornecedor entidade = new Fornecedor();
		entidade.setCidade(dto.getCidade());
		entidade.setComplemento(dto.getComplemento());
		entidade.setProdForn(dto.getProdForn());
		entidade.setRazaoSocial(dto.getRazaoSocial());
		entidade.setTelefone(dto.getTelefone());
		entidade.setCnpj(dto.getCnpj());
		entidade.setLogradouro(dto.getLogradouro());
		entidade.setNumero(dto.getNumero());
		entidade.setIbge(dto.getIbge());
		entidade.setUf(dto.getUf());
		entidade.setCep(dto.getCep());

		entidade = repositorio.save(entidade);
		return new FornecedorDTO(entidade);
	}

	public void delete(Integer cnpj) {
		try {
			repositorio.deleteById(cnpj);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontrada("CNPJ não encontrado" + cnpj);
		} catch (DataIntegrityViolationException e) {
			throw new IntegridadeDatabase("Integridade violada");
		}
	}

	public FornecedorDTO update(Integer cnpj, FornecedorDTO dto) {
		try {
			Fornecedor entidade = repositorio.getOne(cnpj);
			entidade.setCidade(dto.getCidade());
			entidade.setComplemento(dto.getComplemento());
			entidade.setProdForn(dto.getProdForn());
			entidade.setRazaoSocial(dto.getRazaoSocial());
			entidade.setTelefone(dto.getTelefone());
			entidade.setCnpj(dto.getCnpj());
			entidade.setLogradouro(dto.getLogradouro());
			entidade.setNumero(dto.getNumero());
			entidade.setIbge(dto.getIbge());
			entidade.setUf(dto.getUf());
			entidade.setCep(dto.getCep());

			entidade = repositorio.save(entidade);
			return new FornecedorDTO(entidade);
		} catch (EntityNotFoundException e) {
			throw new EntidadeNaoEncontrada("CNPJ do fornecedor não encontrado" + cnpj);
		}
	}
}
