package br.com.raulberto.bancodigital.entity;

public class Cartao {
	
	int contaId,senha,id;
	boolean ativo;
	
	public Cartao(int id, int contaId, int senha) {
		this.id = id;
		this.senha = senha;
		this.contaId = contaId;
		this.ativo = true;
	}
	
	//Getters e Setters
	public int getContaId() {
		return contaId;
	}
	public void setContaId(int contaId) {
		this.contaId = contaId;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
		
}
