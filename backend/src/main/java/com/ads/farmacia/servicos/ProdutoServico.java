package com.ads.farmacia.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ads.farmacia.entidades.Produto;
import com.ads.farmacia.repositorios.ProdutoRepositorio;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio repositorio;
	
	public List<Produto> findAll() {
		return repositorio.findAll();
	}
}
