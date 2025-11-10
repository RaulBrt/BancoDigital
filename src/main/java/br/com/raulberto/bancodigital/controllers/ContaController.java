package br.com.raulberto.bancodigital.controllers;

import java.util.ArrayList;

import br.com.raulberto.bancodigital.entity.Cartao;
import br.com.raulberto.bancodigital.entity.CartaoCredito;
import br.com.raulberto.bancodigital.entity.CartaoDebito;
import br.com.raulberto.bancodigital.repository.CartaoRepository;

public class ContaController {
	
	ArrayList<Cartao> meusCartoes;
	
	
	public ContaController() {
		meusCartoes = new ArrayList<>();
	}

	public ArrayList<Cartao> getMeusCartoes() {
		return meusCartoes;
	}
	
	public void adicionarCartaoDebito(int contaId, int id, int senha) {
		CartaoDebito buff = new CartaoDebito(contaId, id, senha);
		CartaoRepository.adicionarCartao(buff);
		meusCartoes.add(buff);
	}
	
	public void adicionarCartaoCredito(int contaId, int id, int senha, int limite) {
		CartaoCredito buff = new CartaoCredito(contaId, id, senha, limite);
		CartaoRepository.adicionarCartao(buff);
		meusCartoes.add(buff);
	}
	

}
