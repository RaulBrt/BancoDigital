package br.com.raulberto.bancodigital.repository;

import java.util.ArrayList;

import br.com.raulberto.bancodigital.entity.Conta;
import br.com.raulberto.bancodigital.entity.ContaCorrente;
import br.com.raulberto.bancodigital.entity.ContaPoupanca;

public final class ContasRepository {
	private static ArrayList<Conta> contas = new ArrayList<>();

	public static ArrayList<Conta> getContas() {
		return contas;
	}
	
	public static int getContaIndexById(int id) {
		int i = 0;
		for(Conta conta: contas) {
			if(conta.getId() == id) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public static Conta getContaById(int id) throws Exception{
		for(Conta conta : contas) {
			if(conta.getId() == id) {
				return conta;
			}
		}
		throw new Exception("Conta não encontrada: " + id);
	}
	
	public static void adicionarContaCorrente(ContaCorrente conta) {
		contas.add(conta);
	}
	
	public static void adicionarContaPoupanca(ContaPoupanca conta) {
		contas.add(conta);
	}
	
	public static void depositar(int id, double valor) throws Exception{
		try {
			double buff = contas.get(getContaIndexById(id)).getSaldo() + valor;
			contas.get(getContaIndexById(id)).setSaldo(buff);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public static void sacar(int id, double valor) throws Exception{
		try {
			double buff = contas.get(getContaIndexById(id)).getSaldo() - valor;
			if(buff >= 0) {
				contas.get(getContaIndexById(id)).setSaldo(buff);
			}
			else {
				throw new Exception("Saldo insuficiente: " + contas.get(getContaIndexById(id)).getSaldo());
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	public static void transferencia(int id, int idTgt, double valor) throws Exception{
		try{
			int indexContaOrigem = getContaIndexById(id);
			if(contas.get(indexContaOrigem).getSaldo() - valor >= 0) {
				sacar(id,valor);
				depositar(idTgt,valor);
			}
			else {
				throw new Exception ("Saldo insuficiente: " + contas.get(getContaIndexById(id)).getSaldo());
			}
		}catch(Exception e) {
			throw e;
		}
		
	}
	
	public static double consultaSaldo(int id) throws Exception{
		try {
			return contas.get(getContaIndexById(id)).getSaldo();
		}catch(Exception e) {
			throw e;
		}
	}
	
	public static void manutencao(int id) throws Exception{
		try {
			
			if(contas.get(getContaIndexById(id)) instanceof ContaCorrente) {
				((ContaCorrente) contas.get(getContaIndexById(id))).doManutencao();
			}
			else {
				throw new Exception("Conta selecionada nao e conta corrente: " + id);
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	public static void rendimento(int id) throws Exception{
		try {
			
			if(contas.get(getContaIndexById(id)) instanceof ContaPoupanca) {
				((ContaPoupanca) contas.get(getContaIndexById(id))).doRendimento();
			}
			else {
				throw new Exception("Conta selecionada nao e conta poupanca: " + id);
			}
		}catch(Exception e) {
			throw e;
		}
	}
	

}
