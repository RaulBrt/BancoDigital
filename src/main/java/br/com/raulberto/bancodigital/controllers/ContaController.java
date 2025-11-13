package br.com.raulberto.bancodigital.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.raulberto.bancodigital.entity.Conta;
import br.com.raulberto.bancodigital.service.ContaService;

public class ContaController {	
	private ContaService contaService = new ContaService();
	
	@PostMapping("/contass")
	public void adicionarConta(@RequestBody Conta conta) throws Exception{
		try {
			contaService.adicionarConta(conta);	
		}
		catch(Exception e){
			throw e;
		}
	}
}
