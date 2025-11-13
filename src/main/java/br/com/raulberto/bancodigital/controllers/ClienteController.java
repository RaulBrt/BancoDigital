package br.com.raulberto.bancodigital.controllers;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.raulberto.bancodigital.entity.Cliente;
import br.com.raulberto.bancodigital.service.ClienteService;

@RestController
public class ClienteController {
	
	private ClienteService clienteService = new ClienteService();
	
	
	
	@PostMapping("/clientes")
	public void adicionarCliente(@RequestBody Cliente cliente) throws Exception{
		try {
			clienteService.adicionarCliente(cliente);	
		}
		catch(Exception e){
			throw e;
		}
	}
	
	@GetMapping("/clientes")
	public ArrayList<Cliente> getClientes(){
		return clienteService.getClientes();
	}
	
	@GetMapping("/clientes/{cpf}")
	public Cliente getClienteByCPF(@PathVariable String cpf) throws Exception{
		try {
			return clienteService.getClienteByCPF(cpf);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PutMapping("/clientes/{cpf}")
	public void atualizarCliente(@PathVariable String cpf, @RequestBody Cliente cliente) throws Exception{
		try {
			clienteService.atualizarCliente(cpf, cliente);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping("/clientes/{cpf}")
	public void deletarCliente(@PathVariable String cpf){	
		clienteService.deletarCliente(cpf);
	}
	

}
