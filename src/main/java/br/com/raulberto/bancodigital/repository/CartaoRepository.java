package br.com.raulberto.bancodigital.repository;

import java.util.ArrayList;

import br.com.raulberto.bancodigital.entity.Cartao;

public final class CartaoRepository {

	private static ArrayList<Cartao> cartoes;
	
	public CartaoRepository() {
		cartoes = new ArrayList<>();
	}
	
	public static ArrayList<Cartao> getCartoes(){
		return cartoes;
	}
	
	public static void adicionarCartao(Cartao cartao) {
		cartoes.add(cartao);
	}

}
