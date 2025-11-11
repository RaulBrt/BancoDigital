package br.com.raulberto.bancodigital.service;

import java.util.ArrayList;
import java.util.regex.Pattern;

import br.com.raulberto.bancodigital.entity.Cliente;
import br.com.raulberto.bancodigital.repository.ClienteRepository;

public class ClienteService {
	
	private ClienteRepository clienteRepository = new ClienteRepository();
	
	public void adicionarCliente(Cliente cliente) throws Exception{
		int buffIndex = clienteRepository.getClienteIndexByCPF(cliente.getCpf());
		boolean boolBuff = this.validarCpf(cliente.getCpf());
		if(boolBuff && buffIndex < 0){
			clienteRepository.adicionarCliente(cliente);
		}
		else {
			if(!boolBuff) {
				throw new Exception("Cpf Invalido");
			}
			else {
				throw new Exception("Ja existe um cliente com este CPF");
			}
		}
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
	
	
	
	private boolean validarCpf(String cpf) {
		String cpfMask = "\\d{3}.\\d{3}.\\d{3}-\\d{2}";
		if(!Pattern.matches(cpfMask,cpf)) {
			return false;
		}
		else {
			return this.validarPrimeiroDigito(cpf) && this.validarSegundoDigito(cpf);
 		}
	}
	
	private boolean validarPrimeiroDigito(String cpf) {
		int buffNumber = 0;
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		for(int i = 0; i < 9; i++) {
			buffNumber += Character.getNumericValue(cpf.charAt(i)) * (10-i);
		}
		buffNumber *= 10; 
		if(
			(buffNumber % 11) == Character.getNumericValue(cpf.charAt(9)) || 
			(buffNumber % 11 == 10 && Character.getNumericValue(cpf.charAt(9)) == 0 )
		){
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean validarSegundoDigito(String cpf) {
		int buffNumber = 0;
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		for(int i = 0; i < 10; i++) {
			buffNumber += Character.getNumericValue(cpf.charAt(i)) * (11-i);
		}
		buffNumber *= 10;
		if(
			(buffNumber % 11) == Character.getNumericValue(cpf.charAt(10)) || 
			(buffNumber % 11 == 10 && Character.getNumericValue(cpf.charAt(10)) == 0 )
		){
			return true;
		}
		else {
			return false;
		}
	}

}
