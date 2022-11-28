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
@Table(name = "tb_movimentacao")
public class Movimentacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codOperacao;

	@Column (name = "status")
	private Integer status;

	@Column (name = "dataRecebimento")
	private String dataRecebimento;

	@Column (name = "loja")
	private Loja loja;

	@Column (name = "prodForn")
	private ProdForn prodForn;

	public Movimentacao() {
	}

	public Movimentacao(Integer codOperacao, String dataRecebimento, Loja loja, ProdForn prodForn) {
		this.codOperacao = codOperacao;
		this.dataRecebimento = dataRecebimento;
		this.loja = loja;
		this.prodForn = prodForn;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCodOperacao() {
		return codOperacao;
	}

	public String getDataRecebimento() {
		return dataRecebimento;
	}

	public Loja getLoja() {
		return loja;
	}

	public ProdForn getProdForn() {
		return prodForn;
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
		Movimentacao other = (Movimentacao) obj;
		return Objects.equals(codOperacao, other.codOperacao);
	}

}
