package br.com.raulberto.bancodigital.entity;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(String cpfDono, int id) {
		super(cpfDono, id);
	}
	
	//Controller
	public void Manutencao(double manutencao) {
		this.setSaldo(this.getSaldo()*(1+manutencao));
	}

}
