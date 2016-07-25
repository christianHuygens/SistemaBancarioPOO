package Agencia;
import Clientes.Cliente; // Está correto?

public class ContaCorrente extends Conta implements InterfaceContaCorrente {

	double limite;

	public ContaCorrente(int numero, double saldo, double limite) {
		super(numero, saldo);
		this.limite = limite;	
		}

	public boolean sacar(double valor){
		if (this.saldo+this.limite>valor && this.isAtiva())
			this.saldo = this.saldo - valor;
		else{
			return false;
		}
		return true;
	}
	
	
	@Override
	public boolean transferirValor(int numConta, int NumAgencia, double valor) {
		// TODO Auto-generated method stub
		return false;
	}

	public void mudarLimieteConta(double limite){
		if(this.isAtiva()){
			this.limite = limite;
		}
	}

	public String verSituacaoConta() {
		return null;
	}

	// Retorna o limite atual da conta
	public double getLimite() {
		return this.limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

}
