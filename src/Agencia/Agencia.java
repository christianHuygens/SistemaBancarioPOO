package Agencia;
import Clientes.Cliente; // Está correto?

public class Agencia implements InterfaceAgencia {

	@Override
	public boolean criarConta(Cliente C, int numConta, int limiteConta, String tipoConta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Conta buscarConta(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarCliente(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
