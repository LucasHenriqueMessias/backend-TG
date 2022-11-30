package com.ads.farmacia.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numPedido;

	@Column (name = "dataCriacao")
	private String dataCriacao;

	@Column (name = "status")
	private boolean status;

	@Column (name = "itemPedido")
	ArrayList<ItemPedido> itemPedidos = new ArrayList<ItemPedido>();

	@Column (name = "loja")
	private Loja loja;

	public Pedido() {
	}

	public Pedido(Integer numPedido, String dataCriacao, Loja loja) {
		this.numPedido = numPedido;
		this.dataCriacao = dataCriacao;
		this.loja = loja;
		itemPedidos = new ArrayList<ItemPedido>();
	}

	public Integer getNumPedido() {
		return numPedido;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public Loja getLoja() {
		return loja;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(numPedido, other.numPedido);
	}

}
