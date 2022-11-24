package com.ads.farmacia.entidades;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@column (name = "quantidade")
	private Integer quantidade;

	@column (name = "produto")
	private ProdForn produto;

	@column (name = "pedido")
	private Pedido pedido;

	public ItemPedido() {
	}

	public ItemPedido(Integer id, Integer quantidade, ProdForn produto) {
		this.id = id;
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Integer getId() {
		return id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public ProdForn getProduto() {
		return produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}

}
