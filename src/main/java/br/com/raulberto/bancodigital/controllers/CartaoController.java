package br.com.raulberto.bancodigital.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	
}
