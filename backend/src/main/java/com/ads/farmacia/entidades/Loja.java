package com.ads.farmacia.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_loja")
public class Loja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer cnpj;

	@column (name = "logradouro")
	private String logradouro;

	@column (name = "IBGE")
	private Integer ibge;

	@column (name = "numero")
	private Integer numero;

	@column (name = "cep")
	private Integer cep;

	@column (name = "complemento")
	private String complemento;

	@column (name = "cidade")
	private String cidade;

	@column (name = "UF")
	private String uf;

	@column (name = "telefone")
	private String telefone;

	@column (name = "franquia")
	private String franquia;

	@column (name = "usuarios")
	private ArrayList<Usuario> usuarios;

	@column (name = "estoque")
	private ArrayList<Estoque> estoques;

	@column (name = "movimentacoes")
	private ArrayList<Movimentacao> movimentacoes;

	@column (name = "pedidos")
	private ArrayList<Pedido> pedidos;

	public Loja() {
	}

	public Loja(Integer cnpj, String logradouro, Integer ibge, Integer cep, String telefone, String franquia) {
		this.cnpj = cnpj;
		this.logradouro = logradouro;
		this.ibge = ibge;
		this.cep = cep;
		this.telefone = telefone;
		this.franquia = franquia;
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

	public ArrayList<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

}
