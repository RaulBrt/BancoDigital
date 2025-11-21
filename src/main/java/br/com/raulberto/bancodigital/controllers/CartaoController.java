package br.com.raulberto.bancodigital.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.raulberto.bancodigital.entity.Cartao;
import br.com.raulberto.bancodigital.entity.CartaoCredito;
import br.com.raulberto.bancodigital.entity.CartaoDebito;
import br.com.raulberto.bancodigital.service.CartaoService;

@RestController
public class CartaoController {
	
	CartaoService cartaoService = new CartaoService();
	
	@PostMapping(value = "/cartoes" , headers = "X-Data-Type=CartaoDebito")
	public void emitirCartao(@RequestBody CartaoDebito cartao) throws Exception{
		try {
			cartaoService.emitirCartaoDebito(cartao);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PostMapping(value = "/cartoes" , headers = "X-Data-Type=CartaoCredito")
	public void emitirCartao(@RequestBody CartaoCredito cartao) throws Exception{
		try {
			cartaoService.emitirCartaoCredito(cartao);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PostMapping("/cartoes/{id}/pagamento")
	public void pagamento(@PathVariable int id, @RequestBody double valor) throws Exception{
		try {
			cartaoService.pagamento(id,valor);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/cartoes")
	public ArrayList<Cartao> getCartoes() throws Exception{
		return cartaoService.getCartoes();
	}
	
	@GetMapping("/cartoes/{id}")
	public Cartao getCartao(@PathVariable int id) throws Exception{
		try {
			return cartaoService.getCartao(id);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PutMapping("/cartoes/{id}/limite")
	public void setLimite(@PathVariable int id, @RequestBody double valor) throws Exception{
		try {
			cartaoService.setLimite(id,valor);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PutMapping("/cartoes/{id}/status")
	public void setStatus(@PathVariable int id) throws Exception{
		try {
			cartaoService.setStatus(id);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PutMapping("/cartoes/{id}/senha")
	public void changeSenha(@PathVariable int id, @RequestBody ObjectNode json) throws Exception{
		try {
			int senha = json.get("senha").asInt();
			int newSenha = json.get("newSenha").asInt();
			cartaoService.changeSenha(id,senha,newSenha);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PutMapping("/cartoes/{id}/limite-diario")
	public void setLimiteDiario(@PathVariable int id, @RequestBody int valor) throws Exception{
		try {
			cartaoService.setLimiteDiario(id,valor);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/cartoes/{id}/fatura")
	public double getFatura(@PathVariable int id) throws Exception{
		try {
			return cartaoService.getFatura(id);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PostMapping("/cartoes/{id}/fatura/pagamento")
	public void payFatura(@PathVariable int id) throws Exception{
		try {
			cartaoService.payFatura(id);
		}catch(Exception e) {
			throw e;
		}
	}
} 
