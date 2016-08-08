package br.ifrn.tads.poo.banco.agencia;
import br.ifrn.tads.poo.banco.cliente.Cliente;

public class ContaPoupanca extends Conta implements InterfaceContaPoupanca {

	
	public ContaPoupanca(int numero, double saldo, Cliente titular) {
		super(numero, saldo, titular);
	}

	public double calcularRendimento() {
		double rendimento = (this.saldo * 0.7)/100;
		return rendimento;
	}

	public void verSituacaoConta() {
	System.out.println("Conta Poupança número:" + this.numero
			+ "\nSaldo: "+ this.saldo);	
	}

}
