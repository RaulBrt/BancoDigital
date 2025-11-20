package br.com.raulberto.bancodigital.entity;

public class CartaoDebito extends Cartao{

	int limiteTransacoes;
	
	public CartaoDebito(int id, int contaId, int senha, int limiteTransacoes) {
		super(id, contaId, senha);
		this.limiteTransacoes = limiteTransacoes;
	}

	public int getLimiteTransacoes() {
		return limiteTransacoes;
	}

	public void setLimiteTransacoes(int limiteTransacoes) {
		this.limiteTransacoes = limiteTransacoes;
	}
	
	public void resetTransacoes() {
		this.limiteTransacoes = 0;
	}
	

}
