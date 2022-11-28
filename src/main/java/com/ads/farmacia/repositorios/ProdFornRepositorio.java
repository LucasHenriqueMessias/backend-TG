package com.ads.farmacia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ads.farmacia.entidades.ProdForn;

@Repository
public interface ProdFornRepositorio extends JpaRepository<ProdForn, Integer> {

	
}
