package br.ifrn.tads.poo.banco.agencia;
import br.ifrn.tads.poo.banco.cliente.Cliente;
import br.ifrn.tads.poo.banco.cliente.PessoaFisica;
import br.ifrn.tads.poo.banco.cliente.PessoaJuridica;
import br.ifrn.tads.poo.banco.exceptions.SaldoInsuficienteException;

public class ContaCorrente extends Conta implements InterfaceContaCorrente {

	double limite;
	
	public ContaCorrente(int numero, double saldo, Cliente titular, double limite) {
		super(numero, saldo, titular);
		this.limite = limite;	
		}

	public boolean sacar(double valor) throws SaldoInsuficienteException{
		if (this.saldo+this.limite<valor)
			throw new SaldoInsuficienteException();
		else{
			this.saldo = this.saldo - valor;
		}
		return true;
	}

	public void mudarLimieteConta(double limite){
		if(this.isAtiva()){
			this.limite = limite;
		}
	}

	public void verSituacaoConta() {
		System.out.println("Conta Poupança número:" + this.numero
				+ "\nSaldo: "+ this.saldo
				+ "\nLimite: "+this.limite);	
	}

	// Retorna o limite atual da conta
	public double getLimite() {
		return this.limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public void imprimirHistorico(){ //sobre escrita de método
		double saldoDisponivel = this.verSaldo() + this.getLimite();
		System.out.println(this.historicoTran);
		System.out.println("---------------------------------"
				+ "\nSaldo atual: R$"+this.verSaldo()
				+"\nSaldo disponível: R$"+saldoDisponivel+"\n");
	}
}
