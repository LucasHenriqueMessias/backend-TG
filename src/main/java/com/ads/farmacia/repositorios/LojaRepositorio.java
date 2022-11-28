package com.ads.farmacia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ads.farmacia.entidades.Loja;

@Repository
public interface LojaRepositorio extends JpaRepository<Loja, Integer> {

	
}
