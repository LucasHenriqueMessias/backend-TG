package com.ads.farmacia.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sku;

	@Column(name = "receita")
	private String receita;

	@Column(name = "generico")
	private String generico;

	@Column(name = "molecula")
	private String molecula;

	@Column(name = "link_bula")
	private String linkBula;

	@Column(name = "recomendacao")
	private String recomendacao;

	@Column(name = "nome_comercial")
	private String nomeComercial;

	@Column(name = "unid_medida")
	private String unidMedida;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "tarja")
	private String tarja;

	@Column(name = "restricao")
	private String restricao;

	@Column(name = "miligrama")
	private double miligrama;

	@Column(name = "direcionamento")
	private String direcionamento;

	@Column(name = "prodForn")
	private String prodForn;

	public Produto() {
	}

	public Produto(Integer sku, String receita, String generico, String molecula, String linkBula, String recomendacao,
			String nomeComercial, String unidMedida, String descricao, String tarja, String restricao, double miligrama,
			String direcionamento, String prodForn) {
		this.sku = sku;
		this.receita = receita;
		this.generico = generico;
		this.molecula = molecula;
		this.linkBula = linkBula;
		this.recomendacao = recomendacao;
		this.nomeComercial = nomeComercial;
		this.unidMedida = unidMedida;
		this.descricao = descricao;
		this.tarja = tarja;
		this.restricao = restricao;
		this.miligrama = miligrama;
		this.direcionamento = direcionamento;
	    this.prodForn = prodForn;
	}

	public Integer getSku() {
		return sku;
	}

	public void setSku(Integer sku) {
		this.sku = sku;
	}

	public String getReceita() {
		return receita;
	}

	public void setReceita(String receita) {
		this.receita = receita;
	}

	public String getGenerico() {
		return generico;
	}

	public void setGenerico(String generico) {
		this.generico = generico;
	}

	public String getMolecula() {
		return molecula;
	}

	public void setMolecula(String molecula) {
		this.molecula = molecula;
	}

	public String getLinkBula() {
		return linkBula;
	}

	public void setLinkBula(String linkBula) {
		this.linkBula = linkBula;
	}

	public String getRecomendacao() {
		return recomendacao;
	}

	public void setRecomendacao(String recomendacao) {
		this.recomendacao = recomendacao;
	}

	public String getNomeComercial() {
		return nomeComercial;
	}

	public void setNomeComercial(String nomeComercial) {
		this.nomeComercial = nomeComercial;
	}

	public String getUnidMedida() {
		return unidMedida;
	}

	public void setUnidMedida(String unidMedida) {
		this.unidMedida = unidMedida;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTarja() {
		return tarja;
	}

	public void setTarja(String tarja) {
		this.tarja = tarja;
	}

	public String getRestricao() {
		return restricao;
	}

	public void setRestricao(String restricao) {
		this.restricao = restricao;
	}

	public double getMiligrama() {
		return miligrama;
	}

	public void setMiligrama(double miligrama) {
		this.miligrama = miligrama;
	}

	public String getDirecionamento() {
		return direcionamento;
	}

	public void setDirecionamento(String direcionamento) {
		this.direcionamento = direcionamento;
	}

	public String getProdForn() {
		return prodForn;
	}

	public void setProdForn(String prodForn) {
		this.prodForn = prodForn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sku);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(sku, other.sku);
	}

}
