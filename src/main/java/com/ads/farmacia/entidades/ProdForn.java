package com.ads.farmacia.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_prod_forn")
public class ProdForn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codBarras;

	@Column (name = "preco")
	private double preco;
	
	@Column (name = "produto")
	private Produto produto;

	@Column (name = "fornecedor")
	private Fornecedor fornecedor;

	public ProdForn() {
	}

	public ProdForn(Integer codBarras, Produto produto, Fornecedor fornecedor) {
		this.codBarras = codBarras;
		this.produto = produto;
		this.fornecedor = fornecedor;
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

	@Override
	public int hashCode() {
		return Objects.hash(codBarras);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdForn other = (ProdForn) obj;
		return Objects.equals(codBarras, other.codBarras);
	}

}
