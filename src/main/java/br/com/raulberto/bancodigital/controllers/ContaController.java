package br.com.raulberto.bancodigital.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.raulberto.bancodigital.entity.Conta;
import br.com.raulberto.bancodigital.entity.ContaCorrente;
import br.com.raulberto.bancodigital.entity.ContaPoupanca;
import br.com.raulberto.bancodigital.service.ContaService;

@RestController
public class ContaController {	
	private ContaService contaService = new ContaService();
	
	@PostMapping("/contas")
	public void adicionarContaCorrente(@RequestBody ContaCorrente conta) throws Exception{
		try {
			contaService.adicionarConta(conta);	
		}
		catch(Exception e){
			throw e;
		}
	}
	
	/*@PostMapping("/contas")
	public void adicionarContaPoupanca(@RequestBody ContaPoupanca conta) throws Exception{
		try {
			contaService.adicionarConta(conta);	
		}
		catch(Exception e){
			throw e;
		}
	}*/
}
