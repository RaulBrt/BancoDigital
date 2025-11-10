package br.com.raulberto.bancodigital.entity;

public class CartaoCredito extends Cartao{

	public CartaoCredito(int contaId, int id, int senha, double limite) {
		super(contaId, id, senha);
		this.setLimite(limite);
	}

}
