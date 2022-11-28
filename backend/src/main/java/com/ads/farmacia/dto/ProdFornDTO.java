package com.ads.farmacia.dto;

import java.io.Serializable;

import com.ads.farmacia.entidades.Fornecedor;
import com.ads.farmacia.entidades.ProdForn;
import com.ads.farmacia.entidades.Produto;

public class ProdFornDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer codBarras;
	private double preco;
	private Produto produto;
	private Fornecedor fornecedor;

	public ProdFornDTO() {
	}

	public ProdFornDTO(Integer codBarras, Produto produto, Fornecedor fornecedor) {
		this.codBarras = codBarras;
		this.produto = produto;
		this.fornecedor = fornecedor;
	}
	public ProdFornDTO(ProdForn entidade) {
		this.codBarras = entidade.getCodBarras();
		this.fornecedor = entidade.getFornecedor();
		this.preco = entidade.getPreco();
		this.produto = entidade.getProduto();
	}
	public Integer getCodBarras() {
		return codBarras;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
