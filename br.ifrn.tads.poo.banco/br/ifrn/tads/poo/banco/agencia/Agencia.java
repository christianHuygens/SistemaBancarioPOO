package br.ifrn.tads.poo.banco.agencia;
import br.ifrn.tads.poo.banco.cliente.Cliente;
import java.util.ArrayList;

public class Agencia implements InterfaceAgencia {

	final int codigoAgencia;
	String nomeAgencia;
	int numConta = 1;
	double limiteInicial = 100;
	double saldoInicial = 0;
	ArrayList <Cliente> clientes = new ArrayList <Cliente>();
	
	public Agencia(int numeroAgencia, String nomeAgencia){
		this.codigoAgencia = numeroAgencia;
		this.nomeAgencia = nomeAgencia;
	}

	public boolean criarConta(int numConta, Cliente titular, String tipoConta) {
		if(tipoConta == "poupanca"){
			Conta nova = new ContaPoupanca(numConta, this.saldoInicial, titular);
			titular.adicionarConta(nova);
		}else{
			Conta nova = new ContaCorrente(numConta, saldoInicial, titular, limiteInicial);
			titular.adicionarConta(nova);
		}
		this.numConta++;
		return true;
	}

	public void cadastrarCliente(Cliente novoCliente) {
		this.clientes.add(novoCliente);
	}
	
	public Cliente buscarCliente(int cadastro) {
		Cliente achado = null;
		for (Cliente clt: clientes){ 
			if (clt.getCadastro()==cadastro){ 
				achado = clt;
			}
		}
		return achado;
	}

	public boolean removerCliente(int numDeCadastro){
		boolean estatus = false;
		Cliente remover = this.buscarCliente(numDeCadastro);
		if(remover!=null){
			estatus = clientes.remove(remover);
		}
		return estatus;
	}
	
	public void imprimirListaClientes() {
		if(!this.clientes.isEmpty()){
			for (Cliente clt: clientes){
				System.out.println("Nome: "+clt.getNome()+" - "+clt.getCadastro());
			}
		}else{
			System.out.println("Lista vazia.");
		}
	}
	
	public int getCodAgencia() {
		return codigoAgencia;
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
