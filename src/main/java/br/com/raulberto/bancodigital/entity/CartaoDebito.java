package br.com.raulberto.bancodigital.entity;

public class CartaoDebito extends Cartao{

	public CartaoDebito(int contaId, int id, int senha) {
		super(contaId, id, senha);
		this.setLimite(0);
	}

}
