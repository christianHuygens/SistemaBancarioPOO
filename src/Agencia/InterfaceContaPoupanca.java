package Agencia;
import java.util.Date;

import Clientes.Cliente; // Está correto?

public interface InterfaceContaPoupanca extends InterfaceConta {
	Date getAniversario();
	void setAniversario();
	void calcularRendimento();
	
}
