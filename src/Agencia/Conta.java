package Agencia;

public abstract class Conta implements InterfaceConta {

	public abstract boolean sacar(double valor);

	public abstract void depositar(double valor);

	public abstract double verSaldo(double valor);

	public abstract void cancelarConta();

	public abstract boolean transferirValor(int numConta, int NumAgencia, double valor);

	public abstract void mudarLimieteConta(double limite);

	public abstract String verSituacaoConta();

	public abstract double getNumero();

	public abstract void setNumero();

	public abstract double getAtiva();

	public abstract void setAtiva();

	public abstract double getSaldo();

	public abstract void setSaldo();

	public abstract Cliente VerInformaçõesCliente();

}
