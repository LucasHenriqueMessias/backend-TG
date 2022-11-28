package com.ads.farmacia.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.ads.farmacia.entidades.Estoque;
import com.ads.farmacia.entidades.Loja;
import com.ads.farmacia.entidades.Movimentacao;
import com.ads.farmacia.entidades.Pedido;
import com.ads.farmacia.entidades.Usuario;

public class LojaDTO implements Serializable {
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
	private String franquia;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Estoque> estoques;
	private ArrayList<Movimentacao> movimentacoes;
	private ArrayList<Pedido> pedidos;

	public LojaDTO() {
	}

	public LojaDTO(Integer cnpj, String logradouro, Integer ibge, Integer cep, String telefone, String franquia) {
		this.cnpj = cnpj;
		this.logradouro = logradouro;
		this.ibge = ibge;
		this.cep = cep;
		this.telefone = telefone;
		this.franquia = franquia;
		usuarios = new ArrayList<>();
		estoques = new ArrayList<>();
		movimentacoes = new ArrayList<>();
		pedidos = new ArrayList<>();
	}
	
	public LojaDTO(Loja entidade) {
		this.cnpj = entidade.getCnpj();
		this.logradouro = entidade.getLogradouro();
		this.ibge = entidade.getIbge();
		this.cep = entidade.getCep();
		this.telefone = entidade.getTelefone();
		this.franquia = entidade.getFranquia();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public Integer getIbge() {
		return ibge;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Integer getCep() {
		return cep;
	}

	public String getFranquia() {
		return franquia;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(ArrayList<Estoque> estoques) {
		this.estoques = estoques;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public ArrayList<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

}
