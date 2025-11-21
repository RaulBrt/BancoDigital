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
			if(cartoes.get(index).isAtivo()) {
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
			}
			else {
				throw new Exception("Cartao desativado");
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	public static void pagamentoCredito(int index, double valor) throws Exception{
		try {
			if(cartoes.get(index).isAtivo()) {
				double limite = ((CartaoCredito) cartoes.get(index)).getLimite();
				double fatura = ((CartaoCredito) cartoes.get(index)).getFatura();
				if((fatura - valor) <= limite) {
					((CartaoCredito) cartoes.get(index)).setFatura(fatura - valor);
				}
				else{
					throw new Exception("Limite de credito atingido");
				}
			}else {
				throw new Exception("Cartao desativado");
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	public static void setLimite(int id, double valor) throws Exception {
		try {
			((CartaoCredito)cartoes.get(getCartaoIndexById(id))).setLimite(valor);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public static void setStatus(int id) throws Exception{
		try {
			cartoes.get(getCartaoIndexById(id)).setAtivo(!(cartoes.get(getCartaoIndexById(id)).isAtivo()));
		}catch(Exception e) {
			throw e;
		}
	}
	
	public static void changeSenha(int id, int senha) throws Exception{
		try {
			cartoes.get(getCartaoIndexById(id)).setSenha(senha);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public static void setLimiteDiario(int id, int valor) throws Exception{
		try {
			((CartaoDebito)cartoes.get(getCartaoIndexById(id))).setLimiteTransacoes(valor);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public static double getFatura(int id) throws Exception{
		try {
			return ((CartaoCredito) getCartaoById(id)).getFatura();
		}catch(Exception e) {
			throw e;
		}
	}
	
	public static void payFatura(int id) throws Exception{
		try {
			double fatura = ((CartaoCredito) getCartaoById(id)).getFatura();
			double limite = ((CartaoCredito) getCartaoById(id)).getLimite();
			double saldo = ContasRepository.getContaById(getCartaoById(id).getContaId()).getSaldo();
			if(fatura >= (limite*0.8)) {
				fatura *= 1.05;
			}
			ContasRepository.getContaById(getCartaoById(id).getContaId()).setSaldo(saldo - fatura);
		}catch(Exception e) {
			throw e;
		}
	}
}
