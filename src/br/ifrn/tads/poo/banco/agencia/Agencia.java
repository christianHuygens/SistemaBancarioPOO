package br.ifrn.tads.poo.banco.agencia;
import br.ifrn.tads.poo.banco.cliente.Cliente;
import java.util.ArrayList;

public class Agencia implements InterfaceAgencia {

	int numeroAgencia;
	String nomeAgencia;
	int numConta = 00000001;
	double limiteInicial = 100; // Limite inicial de qqr conta será R$100
	double saldoInicial = 0;// Saldo inicial de qqr conta será R$0
	ArrayList <Conta> contas = new ArrayList <Conta>();
	ArrayList <Cliente> clientes = new ArrayList <Cliente>();
	
	public Agencia(int numeroAgencia, String nomeAgencia){
		this.numeroAgencia = numeroAgencia;
		this.nomeAgencia = nomeAgencia;
	}

	public boolean criarConta(int numConta, Cliente titular, String tipoConta) {
		if(tipoConta == "poupanca"){
			Conta nova = new ContaPoupanca(numConta, this.saldoInicial, titular);
			contas.add(nova);
		}else{
			Conta nova = new ContaCorrente(numConta, saldoInicial, titular, limiteInicial);
			contas.add(nova);
		}
		this.numConta++;
		return true;
	}

	public void cadastrarCliente(Cliente novoCliente) {
		this.clientes.add(novoCliente);
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

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNomeAgencia() {
		return nomeAgencia;
	}

	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

	public int getNumConta() {
		return numConta;
	}

	

}
