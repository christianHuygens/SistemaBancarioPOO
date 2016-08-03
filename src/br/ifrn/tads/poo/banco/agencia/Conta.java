package br.ifrn.tads.poo.banco.agencia;
import br.ifrn.tads.poo.banco.cliente.Cliente;

public abstract class Conta implements InterfaceConta {

	final int numero;
	boolean ativa;
	double saldo;
	Cliente titular; // Add relatório
	
	public Conta(int numero, double saldo, Cliente titular){
		this.numero = numero;
		this.saldo = saldo;
		this.titular = titular;
		this.ativa = true;
	}
	
	public abstract boolean sacar(double valor);

	//adiciona valor ao saldo
	public void depositar(double valor){
		if(this.isAtiva())
			this.saldo = this.saldo+valor;
	}

	// retorna saldo
	public double verSaldo(double valor){
		return this.saldo;
	}

	//saca saldo disponível e muda boolean ativa para false
	public void cancelarConta(){
		if(this.isAtiva()){
			if(this.saldo>0){
				this.sacar(this.saldo);
			}else{
				//tratar erro: realizar deposito
			}
			this.setAtiva(false);
		}else{
			// tratar erro: imprimir que conta já está encerrada
		}
	}

	public abstract boolean transferirValor(int numConta, int NumAgencia, double valor);

	public abstract String verSituacaoConta();

	public Cliente VerInformaçõesCliente(){
		//implementar aqui
		return null;
	}

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

}
