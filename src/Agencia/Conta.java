package Agencia;

public interface Conta {
	boolean sacar(double valor);
	void depositar(double valor);
	double verSaldo(double valor);
	void cancelarConta();
	Cliente VerInformaçõesCliente();
	boolean transferirValor(int numConta, int NumAgencia, double valor);
	void mudarLimieteConta(double limite);
	String verSituacaoConta();
	double getNumero();
	void setNumero();
	double getAtiva();
	void setAtiva();
	double getSaldo();
	void setSaldo();
}
