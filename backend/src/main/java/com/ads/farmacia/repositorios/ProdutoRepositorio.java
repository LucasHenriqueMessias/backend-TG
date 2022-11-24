package com.ads.farmacia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ads.farmacia.entidades.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

	
}
