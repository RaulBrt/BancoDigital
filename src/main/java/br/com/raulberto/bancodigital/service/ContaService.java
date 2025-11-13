package br.com.raulberto.bancodigital.service;

import br.com.raulberto.bancodigital.entity.Conta;
import br.com.raulberto.bancodigital.repository.ClienteRepository;
import br.com.raulberto.bancodigital.repository.ContasRepository;

public class ContaService {
	
	public void adicionarConta(Conta conta) throws Exception{
		try {
			if(this.validarConta(conta)) {
				ContasRepository.adicionarConta(conta);
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

}
