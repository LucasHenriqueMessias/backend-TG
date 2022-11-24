package com.ads.farmacia.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ads.farmacia.entidades.Loja;
import com.ads.farmacia.repositorios.LojaRepositorio;

@Service
public class LojaServico {

	@Autowired
	private LojaRepositorio repositorio;
	
	public List<Loja> findAll() {
		return repositorio.findAll();
	}
}
