package br.ifrn.tads.poo.banco.agencia;
import br.ifrn.tads.poo.banco.cliente.Cliente;
import br.ifrn.tads.poo.banco.cliente.PessoaFisica;
import br.ifrn.tads.poo.banco.cliente.PessoaJuridica;
import br.ifrn.tads.poo.banco.exceptions.SaldoInsuficienteException;

public abstract class Conta implements InterfaceConta {

	final int numero;
	boolean ativa;
	double saldo;
	String historicoTran = "Extrato Bancário:\n";
	Cliente titular; // Add relatório
	
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

	//adiciona valor ao saldo
	public void depositar(double valor){
		if(this.isAtiva())
			this.saldo = this.saldo+valor;
	}

	// retorna saldo
	public double verSaldo(){
		return this.saldo;
	}

	//saca saldo disponível e muda boolean ativa para false
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

	// retorna numero de conta
	public int getNumero() {
		return numero;
	}
	
	//retorna se conta está ativa
	public boolean isAtiva() {
		return ativa;
	}
	
	// muda status da conta
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
