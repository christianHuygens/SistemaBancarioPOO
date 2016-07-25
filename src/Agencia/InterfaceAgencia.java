package Agencia;
import Clientes.Cliente; // Está correto?

public interface InterfaceAgencia {
	boolean criarConta(Cliente C, int numConta, int limiteConta, String tipoConta);
	Conta buscarConta(int numero);
	Cliente buscarCliente(String nome);
}
