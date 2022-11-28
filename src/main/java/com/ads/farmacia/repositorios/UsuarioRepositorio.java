package com.ads.farmacia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ads.farmacia.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

	
}
