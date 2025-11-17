package br.com.raulberto.bancodigital.entity;

import br.com.raulberto.bancodigital.repository.ClienteRepository;

public class ContaCorrente extends Conta{
	
	private double manutencao;
	
	public ContaCorrente( int id, String cpfDono){
		super(id, cpfDono);
		this.manutencao = this.checkManutencao(cpfDono);
	}
	
	public double getManutencao() {
		return manutencao;
	}

	public void setManutencao(double manutencao) {
		this.manutencao = manutencao;
	}
	
	private double checkManutencao(String cpf) {
		try {
			int tipo = ClienteRepository.getClienteByCPF(cpf).getTipo();
			return (tipo == 3 ? 0 : tipo == 2 ? 8 : 12);
		}
		catch(Exception e) {
			return 12;
		}
	}
	
	public void doManutencao() {
		this.saldo -= this.manutencao;
	}

}
