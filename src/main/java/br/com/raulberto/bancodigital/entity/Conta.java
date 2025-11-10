package br.com.raulberto.bancodigital.entity;

import java.util.ArrayList;

public class Conta {
	
	private String cpfDono;
	private double saldo;
	private int id;
	ArrayList<Cartao> cartoes;
	
	public Conta(String cpfDono, int id) {
		this.cpfDono = cpfDono;
		this.saldo = 0;
		this.id = id;
		this.cartoes = new ArrayList<>();
	}
	
	//Getters e Setters
	public String getCpfDono() {
		return cpfDono;
	}
	public void setCpfDono(String cpfDono) {
		this.cpfDono = cpfDono;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public ArrayList<Cartao> getCartoes() {
		return cartoes;
	}
}
