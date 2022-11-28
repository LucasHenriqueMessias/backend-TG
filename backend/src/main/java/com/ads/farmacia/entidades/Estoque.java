package com.ads.farmacia.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estoque")
public class Estoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codOperacao;

	@Column(name = "validade")
	private String dataValidade;

	@Column(name = "lote")
	private Long lote;

	@Column(name = "quantidade")
	private Integer qtdeCaixa;

	@Column(name = "loja")
	private Loja loja;

	@Column(name = "produto")
	private ProdForn produto;

	public Estoque() {
	}

	public Estoque(Integer codOperacao, String dataValidade, Long lote, Integer qtdeCaixa, Loja loja,
			ProdForn produto) {
		this.codOperacao = codOperacao;
		this.dataValidade = dataValidade;
		this.lote = lote;
		this.qtdeCaixa = qtdeCaixa;
		this.loja = loja;
		this.produto = produto;
	}

	public Integer getCodOperacao() {
		return codOperacao;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public Long getLote() {
		return lote;
	}

	public Integer getQtdeCaixa() {
		return qtdeCaixa;
	}

	public Loja getLoja() {
		return loja;
	}

	public ProdForn getProduto() {
		return produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codOperacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		return Objects.equals(codOperacao, other.codOperacao);
	}

}
