package br.com.raulberto.bancodigital.service;

import br.com.raulberto.bancodigital.entity.Conta;
import br.com.raulberto.bancodigital.entity.ContaCorrente;
import br.com.raulberto.bancodigital.entity.ContaPoupanca;
import br.com.raulberto.bancodigital.repository.ClienteRepository;
import br.com.raulberto.bancodigital.repository.ContasRepository;

public class ContaService {
	
	public void adicionarContaCorrente(ContaCorrente conta) throws Exception{
		try {
			if(this.validarConta(conta)) {
				ContasRepository.adicionarContaCorrente(conta);
			}
			else {
				if (ClienteRepository.getClienteIndexByCPF(conta.getCpfDono()) < 0){
					throw new Exception("Cliente dono nao existe");
				}
				else if(ContasRepository.getContaIndexById(conta.getId()) >= 0) {
					throw new Exception("Conta ja existe");
				}
			}
			
		}catch(Exception e){
			throw e;
		}
		
	}
	
	public void adicionarContaPoupanca(ContaPoupanca conta) throws Exception{
		try {
			if(this.validarConta(conta)) {
				ContasRepository.adicionarContaPoupanca(conta);
			}
			else {
				if (ClienteRepository.getClienteIndexByCPF(conta.getCpfDono()) < 0){
					throw new Exception("Cliente dono nao existe");
				}
				else if(ContasRepository.getContaIndexById(conta.getId()) >= 0) {
					throw new Exception("Conta ja existe");
				}
			}
			
		}catch(Exception e){
			throw e;
		}
		
	}
	
	public boolean validarConta(Conta conta){
		int clienteExiste = ClienteRepository.getClienteIndexByCPF(conta.getCpfDono());
		if(clienteExiste >= 0 && ContasRepository.getContaIndexById(conta.getId()) < 0) {
			return true;
		}
		else{
			return false;
		}
	}
	
	public Conta getContaById(int id) throws Exception{
		try {
			return ContasRepository.getContaById(id);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void depositar(int id, double valor) throws Exception{
		try {
			ContasRepository.depositar(id,valor);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void sacar(int id, double valor) throws Exception{
		try {
			ContasRepository.sacar(id,valor);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void transferencia(int id, int tgtId, double valor) throws Exception{
		try {
			ContasRepository.transferencia(id, tgtId, valor);
		}catch(Exception e) {
			throw e;
		}
		
		
	}
	
	public double consultaSaldo(int id) throws Exception{
		try {
			return ContasRepository.consultaSaldo(id);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void manutencao(int id) throws Exception{
		try {
			ContasRepository.manutencao(id);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void rendimento(int id) throws Exception{
		try {
			ContasRepository.rendimento(id);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void pix(int id, String cpf, double valor) throws Exception{
		try {
			ContasRepository.pix(id,cpf,valor);
		}catch(Exception e) {
			throw e;
		}
	}
	
}
