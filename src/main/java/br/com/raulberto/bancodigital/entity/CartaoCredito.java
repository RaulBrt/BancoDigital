package br.com.raulberto.bancodigital.entity;

import br.com.raulberto.bancodigital.repository.ClienteRepository;
import br.com.raulberto.bancodigital.repository.ContasRepository;

public class CartaoCredito extends Cartao{

	private double limite;
	private double fatura;
	
	public CartaoCredito(int id, int contaId, int senha) {
		super(id, contaId, senha);
		this.limite = this.checkLimite(contaId);
		this.fatura = 0;
	}
	
	
	public double getFatura() {
		return fatura;
	}


	public void setFatura(double fatura) {
		this.fatura = fatura;
	}


	public double getLimite() {
		return limite;
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	private double checkLimite(int contaId){
		try {
			String cpfCliente = ContasRepository.getContaById(contaId).getCpfDono();
			int tipo = ClienteRepository.getClienteByCPF(cpfCliente).getTipo();
			return (tipo == 3 ? 10000 : tipo == 2 ? 5000 : 1000);
		}catch(Exception e) {
			return 1000;
		}
	}

}
