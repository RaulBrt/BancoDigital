package br.com.raulberto.bancodigital.repository;

import java.util.ArrayList;

import br.com.raulberto.bancodigital.entity.Conta;

public final class ContasRepository {
	private static ArrayList<Conta> contas;

	public ContasRepository() {
		contas = new ArrayList<>();
	}

	public static ArrayList<Conta> getContas() {
		return contas;
	}
	
	public static void adicionarConta(Conta conta) {
		contas.add(conta);
	}
	
	

}
