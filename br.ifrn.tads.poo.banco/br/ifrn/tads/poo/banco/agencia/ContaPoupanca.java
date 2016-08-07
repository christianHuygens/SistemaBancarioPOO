package br.ifrn.tads.poo.banco.agencia;
import br.ifrn.tads.poo.banco.cliente.Cliente;
import br.ifrn.tads.poo.banco.exceptions.SaldoInsuficienteException;

public class ContaPoupanca extends Conta implements InterfaceContaPoupanca {

	
	public ContaPoupanca(int numero, double saldo, Cliente titular) {
		super(numero, saldo, titular);
	}

	public boolean sacar(double valor) throws SaldoInsuficienteException{
		if (this.saldo<valor && this.isAtiva())
			throw new SaldoInsuficienteException();
		else{
			this.saldo = this.saldo - valor;
		}
		return true;
	}

	public double calcularRendimento() {
		double rendimento = (this.saldo * 0.7)/100;
		return rendimento;
	}

//	public boolean transferirValor(int numConta, int NumAgencia, double valor) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	public void verSituacaoConta() {
	System.out.println("Conta Poupança número:" + this.numero
			+ "\nSaldo: "+ this.saldo);	
	}

}
