package Agencia;
import Clientes.Cliente; // Está correto?

public class Agencia implements InterfaceAgencia {

	int numConta = 00000001;
	double limiteInicial = 100; // Limite inicial de qqr conta será R$100
	double saldoInicial = 0;// Saldo inicial de qqr conta será R$0

	public boolean criarConta(Cliente C, int numConta, int limiteConta, String tipoConta) {
		if(tipoConta == "poupanca"){
			ContaPoupanca nova = new ContaPoupanca(numConta, saldoInicial);
			//adicionar novo a lista
		}else{
			ContaCorrente nova = new ContaCorrente(numConta, saldoInicial, this.limiteInicial);
			//adicionar novo a lista
		}
		this.numConta++;
		return true;
	}

	@Override
	public Conta buscarConta(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarCliente(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
