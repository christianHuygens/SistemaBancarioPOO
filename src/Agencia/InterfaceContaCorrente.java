package Agencia;
import Clientes.Cliente; // Está correto?

public interface InterfaceContaCorrente extends InterfaceConta {
	double getLimite();
	void setLimite(double limite);
	void mudarLimieteConta(double limite);
	
}
