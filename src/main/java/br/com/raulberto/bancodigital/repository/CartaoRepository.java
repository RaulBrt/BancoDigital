package br.com.raulberto.bancodigital.repository;

import java.util.ArrayList;

import br.com.raulberto.bancodigital.entity.Cartao;
import br.com.raulberto.bancodigital.entity.CartaoCredito;
import br.com.raulberto.bancodigital.entity.CartaoDebito;

public final class CartaoRepository {

	private static ArrayList<Cartao> cartoes = new ArrayList<>();;
	
	public static ArrayList<Cartao> getCartoes(){
		return cartoes;
	}
	
	public static void emitirCartaoDebito(CartaoDebito cartao) {
		cartoes.add(cartao);
	}
	
	public static void emitirCartaoCredito(CartaoCredito cartao) {
		cartoes.add(cartao);
	}
	
	public static Cartao getCartaoById(int id) throws Exception{
		for(Cartao cartao : cartoes) {
			if(cartao.getId() == id) {
				return cartao;
			}
		}
		throw new Exception("Cartao nao encontrado");
	}
	
	public static int getCartaoIndexById(int id) {
		int buffIndex = 0;
		for(Cartao cartao : cartoes) {
			if(cartao.getId() == id) {
				return buffIndex;
			}
			buffIndex++;
		}
		return -1;
	}
}
