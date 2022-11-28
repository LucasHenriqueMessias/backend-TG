package com.ads.farmacia.dto;
import java.io.Serializable;
import java.util.ArrayList;
import com.ads.farmacia.entidades.ProdForn;
import com.ads.farmacia.entidades.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer sku;
	private String receita;
	private String generico;
	private String molecula;
	private String linkBula;
	private String recomendacao;
	private String nomeComercial;
	private String unidMedida;
	private String descricao;
	private String tarja;
	private String restricao;
	private double miligrama;
	private String direcionamento;
	private ArrayList<ProdForn> prodForn;

	public ProdutoDTO() {
	}

	public ProdutoDTO(Integer sku, String receita, String generico, String molecula, String linkBula, String recomendacao,
			String nomeComercial, String unidMedida, String descricao, String tarja, String restricao, double miligrama,
			String direcionamento) {
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
	}
	
	public ProdutoDTO(Produto entidade) {
		this.descricao = entidade.getDescricao();
		this.direcionamento = entidade.getDirecionamento();
		this.generico = entidade.getGenerico();
		this.linkBula = entidade.getLinkBula();
		this.miligrama = entidade.getMiligrama();
		this.molecula = entidade.getMolecula();
		this.nomeComercial = entidade.getNomeComercial();
		this.prodForn = entidade.getProdForn();
		this.receita = entidade.getReceita();
		this.recomendacao = entidade.getRecomendacao();
		this.restricao = entidade.getRestricao();
		this.sku = entidade.getSku();
		this.tarja = entidade.getTarja();
		this.unidMedida = entidade.getUnidMedida();
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

	public ArrayList<ProdForn> getProdForn() {
		return prodForn;
	}

	public void setProdForn(ArrayList<ProdForn> prodForn) {
		this.prodForn = prodForn;
	}
}