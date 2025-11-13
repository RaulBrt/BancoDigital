package br.com.raulberto.bancodigital.entity;

public class ContaCorrente extends Conta{
	
	double manutencao;
	
	public ContaCorrente(String cpfDono, int id, double manutencao) {
		super(cpfDono, id);
		this.manutencao = manutencao;
	}

}
