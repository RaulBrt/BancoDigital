package br.com.raulberto.bancodigital.service;

import java.util.ArrayList;
import java.util.regex.Pattern;

import br.com.raulberto.bancodigital.entity.Cliente;
import br.com.raulberto.bancodigital.repository.ClienteRepository;

public class ClienteService {
	
	//private ClienteRepository clienteRepository = new ClienteRepository();
	
	public void adicionarCliente(Cliente cliente) throws Exception{
		int  clienteExiste= ClienteRepository.getClienteIndexByCPF(cliente.getCpf());
		boolean isCpfValido = this.validarCpf(cliente.getCpf());
		boolean isNomeValido = this.validarNome(cliente.getNome());
		boolean isDataNascimentoValida = this.validarDataNascimento(cliente.getDataDeNascimento());
		
		if(clienteExiste < 0 && isCpfValido && isNomeValido && isDataNascimentoValida){
			ClienteRepository.adicionarCliente(cliente);
		}
		else {
			if(!isCpfValido) {
				throw new Exception("Cpf Invalido");
			}
			else if(!isNomeValido) {
				throw new Exception("Nome Invalido");
			}
			else if(!isDataNascimentoValida) {
				throw new Exception("Data de Nascimento Invalida");
			}
			else {
				throw new Exception("Ja existe um cliente com este CPF");
			}
		}
	}
	
	public ArrayList<Cliente> getClientes() {
		return ClienteRepository.getClientes();
	}
	
	public Cliente getClienteByCPF(String cpf) throws Exception{
		try {
			return ClienteRepository.getClienteByCPF(cpf);
		}catch(Exception e) {
			throw e;
		}
	}
	 
	public void atualizarCliente(String cpf, Cliente cliente) throws Exception{
		try {
			if(ClienteRepository.getClienteIndexByCPF(cpf) >= 0) {
				if(this.validarCliente(cliente)) {
					ClienteRepository.atualizarCliente(cpf, cliente);
				}
				else {
					throw new Exception("Os novos dados sao invalidos");
				}
			}
			else {
				throw new Exception("Cliente Não Encontrado");
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void deletarCliente(String cpf){
		ClienteRepository.deletarCliente(cpf);
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
	
	private boolean validarNome(String nome) {
		String nomeRegex = "^[\\p{L} .'-]+$";
		return (nome.length() > 1 && nome.length() <= 100 && Pattern.matches(nomeRegex, nome));
	}
	
	public boolean validarDataNascimento(String data) throws Exception{
		int date[] = new int[3];
		try {
			date[0] = Integer.parseInt(data.substring(0, 2));
			date[1] = Integer.parseInt(data.substring(3, 5));
			date[2] = Integer.parseInt(data.substring(6, 10));
			return (date[0] > 0 && date[0] <= 31) && 
					(date[1] > 0 && date[1] <= 12) &&
					(date[2] >= 0 && date[2] <= 9999) &&
					(data.length() == 10);
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean validarCliente(Cliente cliente) throws Exception{
		try {
			return (this.validarCpf(cliente.getCpf()) && 
				this.validarNome(cliente.getNome()) &&
				this.validarDataNascimento(cliente.getDataDeNascimento()));
		}catch(Exception e) {
			throw e;
		}
	}

}
