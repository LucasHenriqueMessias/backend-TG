package com.ads.farmacia.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.ads.farmacia.entidades.Estoque;
import com.ads.farmacia.entidades.Estoque;
import com.ads.farmacia.entidades.Movimentacao;
import com.ads.farmacia.entidades.Pedido;
import com.ads.farmacia.entidades.Usuario;

public class EstoqueDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer codOperacao;
	private String dataValidade;
	private Long lote;
	private Integer qtdeCaixa;
	private Loja loja;
	private ProdForn produto;


	public EstoqueDTO() {
	}

	public EstoqueDTO(Integer codOperacao,
	 String dataValidade, Long lote, Integer qtdeCaixa,	Loja loja, ProdForn produto) {
        this.codOperacao = codOperacao;
        this.dataValidade = dataValidade;
        this.lote = lote;
        this.qtdeCaixa = qtdeCaixa;
        this.loja = loja;
        this.produto = produto;
	}
	
	public EstoqueDTO(Estoque entidade) {
        this.codOperacao = entidade.getCodOperacao();
		this.dataValidade = entidade.getDataValidade();
        this.lote = entidade.getLote();
        this.qtdeCaixa = entidade.getQtdeCaixa();
        this.loja = entidade.getLoja();
        this.produto = entidde.getProduto();
	}

    public Integer getCodOperacao() {
		return CodOperacao;
	}

	public void setCodOperacao(Integer CodOperacao) {
		this.CodOperacao = CodOperacao;
	}


	public String getDataValidade(){
        return dataValidade;
    }
	public Long getLote(){
        return lote;
    }
	public Integer getQtdeCaixa(){
        return qtdeCaixa;
    }
	public Loja getLoja(){
        return loja;
    }
	public ProdForn getProduto(){
        return produto;
    }

    public String setDataValidade(){
        this.dataValidade =dataValidade;
    }
	public Long setLote(){
        this.lote = lote;
    }
	public Integer setQtdeCaixa(){
        this.qtdeCaixa = qtdeCaixa;
    }
	public Loja setLoja(){
        this.loja = loja;
    }
	public ProdForn setProduto(){
        this.produto = produto;
    }
