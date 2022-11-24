package com.ads.farmacia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ads.farmacia.entidades.Fornecedor;

@Repository
public interface FornecedorRepositorio extends JpaRepository<Fornecedor, Integer> {

	
}
