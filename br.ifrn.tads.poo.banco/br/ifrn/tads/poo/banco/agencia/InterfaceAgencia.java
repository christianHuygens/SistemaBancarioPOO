package br.ifrn.tads.poo.banco.agencia;
import br.ifrn.tads.poo.banco.cliente.Cliente;

public interface InterfaceAgencia {
	boolean criarConta(int numConta, Cliente titular, String tipoConta);
	Cliente buscarCliente(int cadastro);
}
