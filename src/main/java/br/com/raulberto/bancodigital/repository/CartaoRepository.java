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
	
	public static void pagamentoDebito(int index, double valor) throws Exception{
		try {
			double saldo = ContasRepository.getContaById(cartoes.get(index).getContaId()).getSaldo();
			if(((CartaoDebito) cartoes.get(index)).isTransacaoEnabled() && valor <= saldo) {
				ContasRepository.getContaById(cartoes.get(index).getContaId()).setSaldo(saldo - valor);
				((CartaoDebito) cartoes.get(index)).setNumTransacoes(((CartaoDebito) cartoes.get(index)).getNumTransacoes() + 1);
				
			}
			else if(valor > saldo) {
				throw new Exception("Saldo Insuficiente");
			}
			else {
				throw new Exception("Limite de transacoes diario atingido");
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	public static void pagamentoCredito(int index, double valor) throws Exception{
		try {
			double saldo = ContasRepository.getContaById(cartoes.get(index).getContaId()).getSaldo();
			double limite = ((CartaoCredito) cartoes.get(index)).getLimite();
		
			if(saldo - valor >= (limite * -1)) {
				ContasRepository.getContaById(cartoes.get(index).getContaId()).setSaldo(saldo - valor);
			}
			else{
				throw new Exception("Limite de credito atingido");
			}
		}catch(Exception e) {
			throw e;
		}
	}
}
