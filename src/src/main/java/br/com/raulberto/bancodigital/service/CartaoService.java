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
	
	
	public void setLimite(int id,double valor) throws Exception{
		try {
			if(valor >= 0 && CartaoRepository.getCartaoById(id) instanceof CartaoCredito) {
				CartaoRepository.setLimite(id,valor);
			}
			else if(valor < 0) {
				throw new Exception("Limite deve ser maior que 0");
			}
			else {
				throw new Exception("Cartao nao e cartao de credito");
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void setStatus(int id) throws Exception{
		try {
			CartaoRepository.setStatus(id);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void changeSenha(int id, int senha, int newSenha) throws Exception{
		try {
			if(senha == CartaoRepository.getCartaoById(id).getSenha()) {
				CartaoRepository.changeSenha(id,newSenha);
			}
			else {
				throw new Exception("Senha incorreta");
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void setLimiteDiario(int id, int valor) throws Exception{
		try {
			if(CartaoRepository.getCartaoById(id) instanceof CartaoDebito && valor >= 0) {
				CartaoRepository.setLimiteDiario(id,valor);
			}
			else if(valor < 0){
				throw new Exception("O novo limite deve ser maior ou igual a 0");
			}
			else {
				throw new Exception("Cartao nao e cartao de debito");
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	public double getFatura(int id) throws Exception{
		try {
			if(CartaoRepository.getCartaoById(id) instanceof CartaoCredito) {
				return CartaoRepository.getFatura(id);
			}
			else {
				throw new Exception("Cartao nao e cartao de credito");
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void payFatura(int id) throws Exception{
		try {
			if(CartaoRepository.getCartaoById(id) instanceof CartaoCredito) {
				CartaoRepository.payFatura(id);
			}
			else {
				throw new Exception("Cartao nao e cartao de credito");
			}
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
