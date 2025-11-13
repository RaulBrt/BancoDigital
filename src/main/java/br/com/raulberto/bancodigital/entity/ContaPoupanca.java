package br.com.raulberto.bancodigital.entity;

public class ContaPoupanca extends Conta{

	double rendimento;
	
	public ContaPoupanca(String cpfDono, int id, double rendimento) {
		super(cpfDono, id);
		this.rendimento = rendimento;
	}
}
