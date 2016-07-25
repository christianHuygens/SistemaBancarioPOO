package Agencia;
import Clientes.Cliente; // Está correto?
import java.util.Date;

public class ContaPoupanca extends Conta implements InterfaceContaPoupanca {

	public ContaPoupanca(int numero, int saldo) {
		super(numero, saldo);
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
	public void calcularRendimento() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean transferirValor(int numConta, int NumAgencia, double valor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String verSituacaoConta() {
		// TODO Auto-generated method stub
		return null;
	}

}
