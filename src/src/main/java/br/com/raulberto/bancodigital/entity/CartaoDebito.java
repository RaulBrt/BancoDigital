package br.com.raulberto.bancodigital.entity;

public class CartaoDebito extends Cartao{

	int limiteTransacoes;
	int numTransacoes;
	
	public CartaoDebito(int id, int contaId, int senha, int limiteTransacoes) {
		super(id, contaId, senha);
		this.limiteTransacoes = limiteTransacoes;
		this.numTransacoes = 0;
	}

	public int getLimiteTransacoes() {
		return limiteTransacoes;
	}

	public void setLimiteTransacoes(int limiteTransacoes) {
		this.limiteTransacoes = limiteTransacoes;
	}
	
	
	
	public int getNumTransacoes() {
		return numTransacoes;
	}

	public void setNumTransacoes(int numTransacoes) {
		this.numTransacoes = numTransacoes;
	}

	public void resetTransacoes() {
		this.numTransacoes = 0;
	}
	
	public boolean isTransacaoEnabled() {
		return (numTransacoes <= limiteTransacoes);
	}

}
