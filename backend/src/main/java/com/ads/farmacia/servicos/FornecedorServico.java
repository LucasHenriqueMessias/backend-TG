package com.ads.farmacia.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ads.farmacia.entidades.Fornecedor;
import com.ads.farmacia.repositorios.FornecedorRepositorio;

@Service
public class FornecedorServico {

	@Autowired
	private FornecedorRepositorio repositorio;
	
	public List<Fornecedor> findAll() {
		return repositorio.findAll();
	}
}
