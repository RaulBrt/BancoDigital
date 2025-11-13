package br.com.raulberto.bancodigital.repository;

import java.util.ArrayList;

import br.com.raulberto.bancodigital.entity.Cliente;

public final class ClienteRepository {
		
	private static ArrayList<Cliente> clientes = new ArrayList<>();;

	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public static Cliente getClienteByCPF(String cpf) throws Exception{
		for(Cliente cliente : clientes) {
			if(cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		throw new Exception("Cliente nao encontrado");
	}
	
	public static int getClienteIndexByCPF(String cpf){
		int i = 0;
		for(Cliente cliente : clientes) {
			if(cliente.getCpf().equals(cpf)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	
	public static void adicionarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public static void atualizarCliente(String cpf, Cliente cliente) throws Exception{
		int buff = getClienteIndexByCPF(cpf);
		if(buff >= 0) {
			clientes.set(buff, cliente);
		}
		else {
			throw new Exception("Cliente nao encontrado");
		}
	}
	
	public static void deletarCliente(String cpf){
		clientes.remove(getClienteIndexByCPF(cpf));
	}
	

}
