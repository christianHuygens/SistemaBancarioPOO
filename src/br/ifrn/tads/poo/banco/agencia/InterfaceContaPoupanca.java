package br.ifrn.tads.poo.banco.agencia;
import java.util.Date;

import br.ifrn.tads.poo.banco.cliente.Cliente;

public interface InterfaceContaPoupanca extends InterfaceConta {
	Date getAniversario();
	void setAniversario();
	void calcularRendimento();
	
}
