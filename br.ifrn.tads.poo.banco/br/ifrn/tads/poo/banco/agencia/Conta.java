package br.ifrn.tads.poo.banco.agencia;
import br.ifrn.tads.poo.banco.cliente.Cliente;
import br.ifrn.tads.poo.banco.exceptions.SaldoInsuficienteException;

public abstract class Conta implements InterfaceConta {

	final int numero;
	boolean ativa;
	double saldo;
	String historicoTran = "Extrato Bancário:\n";
	Cliente titular;
	
	public Conta(int numero, double saldo, Cliente titular){
		this.numero = numero;
		this.saldo = saldo;
		this.titular = titular;
		this.ativa = true;
	}
	
	public boolean sacar(double valor) throws SaldoInsuficienteException{
		if (this.saldo<valor)
			throw new SaldoInsuficienteException();
		else{
			this.saldo = this.saldo - valor;
		}
		return true;
	}

	public void depositar(double valor){
		if(this.isAtiva())
			this.saldo = this.saldo+valor;
	}

	public double verSaldo(){
		return this.saldo;
	}

	public void cancelarConta() throws SaldoInsuficienteException{
		if(this.isAtiva()){
			if(this.saldo>0){
				this.sacar(this.saldo);
				this.setAtiva(false);
			}else{
				System.out.println("O cliente possui um débito. Conta não cancelada.");
			}
		}else{
			System.out.println("Conta já está inativa.");
		}
	}
	
	public abstract void verSituacaoConta();

	public int getNumero() {
		return numero;
	}
	
	public boolean isAtiva() {
		return ativa;
	}
	
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}	

	public String getNomeTitular(){
	return this.titular.getNome();
	}
	
	public void imprimirHistorico(){
		System.out.println(this.historicoTran);
		System.out.println("---------------------------------"
				+ "\nSaldo atual: R$"+this.verSaldo());
	}
	
	public void escreverHistotico(String nova){
		this.historicoTran += nova;
	}
	
}
