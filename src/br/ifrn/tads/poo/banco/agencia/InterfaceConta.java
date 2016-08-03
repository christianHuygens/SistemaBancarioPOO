package br.ifrn.tads.poo.banco.agencia;
import br.ifrn.tads.poo.banco.cliente.Cliente;



public interface InterfaceConta {
	boolean sacar(double valor);
	void depositar(double valor);
	double verSaldo(double valor);
	void cancelarConta();
	Cliente VerInformaçõesCliente();
	boolean transferirValor(int numConta, int NumAgencia, double valor);
	String verSituacaoConta();

}
