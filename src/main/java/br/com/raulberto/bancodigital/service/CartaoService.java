package br.com.raulberto.bancodigital.service;

import java.util.ArrayList;

import br.com.raulberto.bancodigital.entity.Cartao;
import br.com.raulberto.bancodigital.entity.CartaoCredito;
import br.com.raulberto.bancodigital.entity.CartaoDebito;
import br.com.raulberto.bancodigital.repository.CartaoRepository;
import br.com.raulberto.bancodigital.repository.ContasRepository;

public class CartaoService {
	
	public void emitirCartaoDebito(CartaoDebito cartao) throws Exception{
		try {
			if(this.validarCartao(cartao)) {
				CartaoRepository.emitirCartaoDebito(cartao);	
			}
			else if(ContasRepository.getContaIndexById(cartao.getContaId()) < 0) {
				throw new Exception("Conta nao existe");
			}
			else if(CartaoRepository.getCartaoIndexById(cartao.getId()) >= 0) {
				throw new Exception("Cartao ja Existe");
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void emitirCartaoCredito(CartaoCredito cartao) throws Exception{
		try {
			if(this.validarCartao(cartao)) {
				CartaoRepository.emitirCartaoCredito(cartao);	
			}
			else if(ContasRepository.getContaIndexById(cartao.getContaId()) < 0) {
				throw new Exception("Conta nao existe");
			}
			else if(CartaoRepository.getCartaoIndexById(cartao.getId()) >= 0) {
				throw new Exception("Cartao ja Existe");
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void pagamento(int id, double valor) throws Exception{
		try {
			int buffIndex = CartaoRepository.getCartaoIndexById(id);
			if(buffIndex < 0){
				throw new Exception("Cartao nao existe");
			}
			else {
				if(CartaoRepository.getCartoes().get(buffIndex) instanceof CartaoDebito) {
					CartaoRepository.pagamentoDebito(buffIndex,valor);
				}
				else if(CartaoRepository.getCartoes().get(buffIndex) instanceof CartaoCredito) {
					CartaoRepository.pagamentoCredito(buffIndex,valor);
				}
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	public ArrayList<Cartao> getCartoes(){
		return CartaoRepository.getCartoes();
	}
	
	public Cartao getCartao(int id) throws Exception{
		try {
			return CartaoRepository.getCartaoById(id);
		}catch(Exception e) {
			throw e;
		}
	}
	
	private boolean validarCartao(Cartao cartao) throws Exception{
		int contaExiste = ContasRepository.getContaIndexById(cartao.getContaId());
		int cartaoExiste = CartaoRepository.getCartaoIndexById(cartao.getId());
		if(contaExiste >= 0 && cartaoExiste < 0) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
