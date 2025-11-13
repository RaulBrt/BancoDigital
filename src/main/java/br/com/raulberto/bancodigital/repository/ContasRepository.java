package br.com.raulberto.bancodigital.repository;

import java.util.ArrayList;

import br.com.raulberto.bancodigital.entity.Conta;

public final class ContasRepository {
	private static ArrayList<Conta> contas = new ArrayList<>();

	/*public ContasRepository() {
		contas = new ArrayList<>();
	}*/

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
	
	public static void adicionarConta(Conta conta) {
		contas.add(conta);
	}
	

	

}
