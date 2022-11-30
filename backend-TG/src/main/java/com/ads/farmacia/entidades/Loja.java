package com.ads.farmacia.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tb_loja")
public class Loja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;

	@Id
	private Integer cnpj;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "IBGE")
	private Integer ibge;

	@Column(name = "numero")
	private Integer numero;

	@Column(name = "cep")
	private Integer cep;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "UF")
	private String uf;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "franquia")
	private String franquia;

	@Column(name = "usuarios")
	private ArrayList<Usuario> usuarios;

	@Column(name = "estoque")
	private ArrayList<Estoque> estoques;

	@Column(name = "movimentacoes")
	private ArrayList<Movimentacao> movimentacoes;

	@Column(name = "pedidos")
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
		usuarios = new ArrayList<>();
		estoques = new ArrayList<>();
		movimentacoes = new ArrayList<>();
		pedidos = new ArrayList<>();
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

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public void setFranquia(String franquia) {
		this.franquia = franquia;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	@PrePersist
	public void prePersist() {
		createdAt = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		updatedAt = Instant.now();
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
