package br.ifrn.tads.poo.banco.agencia;
import java.util.Date;

import br.ifrn.tads.poo.banco.cliente.Cliente;

public class ContaPoupanca extends Conta implements InterfaceContaPoupanca {

	
	public ContaPoupanca(int numero, double saldo, Cliente titular) {
		super(numero, saldo, titular);
	}

	public boolean sacar(double valor){
		if (this.saldo>valor && this.isAtiva()) // poupança não tem limite
			this.saldo = this.saldo - valor;
		else{
			return false;
		}
		return true;
	}
	
	@Override
	public Date getAniversario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAniversario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calcularRendimento() {
		double rendimento = (this.saldo * 0.7)/100;
		return rendimento;
	}

	@Override
	public boolean transferirValor(int numConta, int NumAgencia, double valor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void verSituacaoConta() {
	System.out.println("Conta Poupança número:" + this.numero
			+ "\nSaldo: "+ this.saldo);	
	}

}
