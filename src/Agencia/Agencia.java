package Agencia;

public interface Agencia {
	boolean criarConta(Cliente C, int numConta, int limiteConta, String tipoConta);
	Conta buscarConta(int numero);
	Cliente buscarCliente(String nome);
}
