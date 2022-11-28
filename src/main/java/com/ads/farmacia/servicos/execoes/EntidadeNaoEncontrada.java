package com.ads.farmacia.servicos.execoes;

public class EntidadeNaoEncontrada extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontrada(String msg) {
		super(msg);
	}
}
