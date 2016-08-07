package br.ifrn.tads.poo.banco.agencia;
import br.ifrn.tads.poo.banco.cliente.Cliente;
import br.ifrn.tads.poo.banco.exceptions.SaldoInsuficienteException;



public interface InterfaceConta {
	boolean sacar(double valor) throws SaldoInsuficienteException;
	void depositar(double valor);
	double verSaldo();
	void cancelarConta() throws SaldoInsuficienteException;
	void verSituacaoConta(); // explicar mucança para void

}
