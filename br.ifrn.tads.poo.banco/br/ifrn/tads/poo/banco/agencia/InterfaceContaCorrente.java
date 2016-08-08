package br.ifrn.tads.poo.banco.agencia;

public interface InterfaceContaCorrente extends InterfaceConta {
	double getLimite();
	void setLimite(double limite);
	void mudarLimieteConta(double limite);
	
}
