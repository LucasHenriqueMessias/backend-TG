package com.ads.farmacia.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ads.farmacia.entidades.ProdForn;
import com.ads.farmacia.repositorios.ProdFornRepositorio;

@Service
public class ProdFornServico {

	@Autowired
	private ProdFornRepositorio repositorio;
	
	public List<ProdForn> findAll() {
		return repositorio.findAll();
	}
}
