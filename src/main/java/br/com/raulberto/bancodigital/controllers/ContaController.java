package br.com.raulberto.bancodigital.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.raulberto.bancodigital.entity.Conta;
import br.com.raulberto.bancodigital.entity.ContaCorrente;
import br.com.raulberto.bancodigital.entity.ContaPoupanca;
import br.com.raulberto.bancodigital.service.ContaService;

@RestController
public class ContaController {	
	private ContaService contaService = new ContaService();
	
	@PostMapping(value = "/contas" , headers = "X-Data-Type=ContaCorrente")
	public void adicionarConta(@RequestBody ContaCorrente conta) throws Exception{
		try{
			contaService.adicionarContaCorrente(conta);
		}catch(Exception e){
			throw e;
		}
	}
	@PostMapping(value = "/contas", headers = "X-Data-Type=ContaPoupanca")
	public void adicionarConta(@RequestBody ContaPoupanca conta) throws Exception{
		try{
			contaService.adicionarContaPoupanca(conta);
		}catch(Exception e){
			throw e;
		}
	}
	
	@GetMapping("/contas/{id}")
	public Conta getContaById(@PathVariable int id) throws Exception{
		try{
			return contaService.getContaById(id);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PostMapping("/contas/{id}/deposito")
	public void depositar(@PathVariable int id, @RequestBody double valor) throws Exception{
		try {
			contaService.depositar(id,valor);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PostMapping("/contas/{id}/saque")
	public void sacar(@PathVariable int id, @RequestBody double valor) throws Exception{
		try {
			contaService.sacar(id,valor);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PostMapping("/contas/{id}/transferencia")
	public void transferencia(@PathVariable int id, @RequestBody ObjectNode json) throws Exception{
		try{
			int tgtId = json.get("tgtId").asInt();
			double valor = json.get("valor").asDouble();
			contaService.transferencia(id, tgtId, valor);
		}catch(Exception e) {
			throw e;
		}
		 
	}
}
