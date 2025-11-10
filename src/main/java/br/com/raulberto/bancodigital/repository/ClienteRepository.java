package br.com.raulberto.bancodigital.repository;

import java.util.ArrayList;

import br.com.raulberto.bancodigital.entity.Cliente;

public class ClienteRepository {
		
	private ArrayList<Cliente> clientes = new ArrayList<>();;

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public Cliente getClienteByCPF(String cpf) throws Exception{
		for(Cliente cliente : clientes) {
			if(cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		throw new Exception("Cliente nao encontrado");
	}
	
	public int getClienteIndexByCPF(String cpf) throws Exception{
		int i = 0;
		for(Cliente cliente : clientes) {
			if(cliente.getCpf().equals(cpf)) {
				return i;
			}
			i++;
		}
		throw new Exception("Cliente nao encontrado");
	}
	
	
	public void adicionarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void atualizarCliente(String cpf, Cliente cliente) throws Exception{
		try {
			int buff = this.getClienteIndexByCPF(cpf);
			this.clientes.set(buff, cliente);
			
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void deletarCliente(String cpf) throws Exception{
		try {
			clientes.remove(this.getClienteIndexByCPF(cpf));
			
		}catch(Exception e) {
			throw e;
		}
	}
	

}
