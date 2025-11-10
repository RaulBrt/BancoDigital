package br.com.raulberto.bancodigital.service;

import java.util.ArrayList;

import br.com.raulberto.bancodigital.entity.Cliente;
import br.com.raulberto.bancodigital.repository.ClienteRepository;

public class ClienteService {
	
	private ClienteRepository clienteRepository = new ClienteRepository();
	
	public void adicionarCliente(Cliente cliente) {
		
		clienteRepository.adicionarCliente(cliente);
	}
	
	public ArrayList<Cliente> getClientes() {
		return clienteRepository.getClientes();
	}
	
	public Cliente getClienteByCPF(String cpf) throws Exception{
		try {
			return clienteRepository.getClienteByCPF(cpf);
		}catch(Exception e) {
			throw e;
		}
	}
	 
	public void atualizarCliente(String cpf, Cliente cliente) throws Exception{
		try {
			clienteRepository.atualizarCliente(cpf, cliente);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void deletarCliente(String cpf) throws Exception{
		try {
			clienteRepository.deletarCliente(cpf);
		}catch(Exception e) {
			throw e;
		}
	}
	

}
