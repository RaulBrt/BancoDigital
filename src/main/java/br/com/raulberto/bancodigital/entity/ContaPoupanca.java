package br.com.raulberto.bancodigital.entity;

import br.com.raulberto.bancodigital.repository.ClienteRepository;

public class ContaPoupanca extends Conta{

	private double rendimento;
	public ContaPoupanca(int id, String cpfDono) {
		super(id, cpfDono);
		this.rendimento = this.checkRendimento(cpfDono);
	}
	public double getRendimento() {
		return rendimento;
	}
	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}
	private double checkRendimento(String cpf) {
		try {
			int tipo = ClienteRepository.getClienteByCPF(cpf).getTipo();
			return (tipo == 3 ? 0.9 : tipo == 2 ? 0.7 : 0.5);
		}
		catch(Exception e) {
			return 0.5;
		}
	}
	
}
