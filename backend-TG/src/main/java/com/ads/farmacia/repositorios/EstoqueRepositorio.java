package com.ads.farmacia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ads.farmacia.entidades.Estoque;

@Repository
public interface EstoqueRepositorio extends JpaRepository<Estoque, Integer> {

	
}
