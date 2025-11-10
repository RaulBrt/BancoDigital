package br.com.raulberto.bancodigital.entity;

public class ContaCorrente extends Conta{

	private double manutencao;
	
	public ContaCorrente(String cpfDono, int id) {
		super(cpfDono, id);
	}

	//Controller
	public void Manutencao() {
		this.setSaldo(this.getSaldo());
	}
	
	

}
