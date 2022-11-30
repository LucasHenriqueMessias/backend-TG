package com.ads.farmacia.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.ads.farmacia.entidades.Fornecedor;
import com.ads.farmacia.entidades.ProdForn;

public class FornecedorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cnpj;
	private String logradouro;
	private Integer ibge;
	private Integer numero;
	private Integer cep;
	private String complemento;
	private String cidade;
	private String uf;
	private String telefone;
	private String razaoSocial;
	private ArrayList<ProdForn> prodForn;

	public FornecedorDTO() {
	}

	public FornecedorDTO(Integer cnpj, String logradouro, Integer ibge, Integer cep, String razaoSocial) {
		this.cnpj = cnpj;
		this.logradouro = logradouro;
		this.ibge = ibge;
		this.cep = cep;
		this.razaoSocial = razaoSocial;
		prodForn = new ArrayList<>();
	}

	public FornecedorDTO(Fornecedor entidade) {
		this.cnpj = entidade.getCnpj();
		this.logradouro = entidade.getLogradouro();
		this.ibge = entidade.getIbge();
		this.cep = entidade.getCep();
		this.telefone = entidade.getTelefone();

	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Integer getIbge() {
		return ibge;
	}

	public Integer getNumero() {
		return numero;
	}

	public Integer getCep() {
		return cep;
	}

	public String getUf() {
		return uf;
	}

	public ArrayList<ProdForn> getProdForn() {
		return prodForn;
	}

	public void setProdForn(ArrayList<ProdForn> prodForn) {
		this.prodForn = prodForn;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
