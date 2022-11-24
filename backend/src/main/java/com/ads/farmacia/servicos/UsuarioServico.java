package com.ads.farmacia.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ads.farmacia.entidades.Usuario;
import com.ads.farmacia.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> findAll() {
		return repositorio.findAll();
	}
}
