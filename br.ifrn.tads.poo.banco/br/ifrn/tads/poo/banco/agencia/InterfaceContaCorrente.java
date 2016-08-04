package br.ifrn.tads.poo.banco.agencia;
import br.ifrn.tads.poo.banco.cliente.Cliente;

public interface InterfaceContaCorrente extends InterfaceConta {
	double getLimite();
	void setLimite(double limite);
	void mudarLimieteConta(double limite);
	
}
