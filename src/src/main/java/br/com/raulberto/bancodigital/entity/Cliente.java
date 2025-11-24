package br.com.raulberto.bancodigital.entity;


public class Cliente {

	private String cpf;
	
	private String nome, endereco, dataDeNascimento;
	
	/*Tipo de Clientes
	 * 
	 * 1 - Comum
	 * 2 - Super
	 * 3 - Premium
	 * */
	private int tipo;
	
	public Cliente(String cpf, String nome, String endereco, String dataDeNascimento, int tipo) {
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.dataDeNascimento = dataDeNascimento;
		this.tipo = tipo;
	}
		
	//Getters e Setters
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
}

