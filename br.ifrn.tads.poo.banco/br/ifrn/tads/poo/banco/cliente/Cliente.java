package br.ifrn.tads.poo.banco.cliente;
import java.util.ArrayList;
import br.ifrn.tads.poo.banco.agencia.Conta;
import br.ifrn.tads.poo.banco.agencia.ContaCorrente;
import br.ifrn.tads.poo.banco.agencia.ContaPoupanca;

public class Cliente implements InterfaceCliente {

	String nome, telefone, email;
	int senha = 123456;
	int cadastro;
	boolean poupanca = false, corrente = false; // para não ser possivel criar mais de uma conta de cada tipo
	int numContaCorrente, numContaPoupança; // Add relatório
	ArrayList <Conta> contas = new ArrayList <Conta>(2); // cada cliente só terá duas contas. Uma paupança e outra corrente
	
	public Cliente(String nome, String telefone, String email, int numDeCadastro){
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cadastro = numDeCadastro;
	}
	
	public void adicionarConta(Conta nova){
		contas.add(nova);
	}
	
	public boolean removerConta(int numDeConta){
		boolean estatus = false;
		Conta remover = this.buscarConta(numDeConta);
		if(remover!=null){
			estatus = contas.remove(remover);
		}
		if(remover instanceof ContaPoupanca){
			this.poupanca = false;
		}else if(remover instanceof ContaCorrente){
			this.corrente = false;
		}
		return estatus;
	}
	
	public Conta buscarConta(int numDeConta) {
		Conta achada = null;
		for (Conta ct: contas){ // como parar se acabar a lista de administradores?  
			if (ct.getNumero()==numDeConta){ 
				achada = ct;
			}
		}
		return achada;
	}

	public Conta buscarContaCorrente() {
		Conta achada = null;
		for (Conta ct: contas){ // como parar se acabar a lista de administradores?  
			if (ct instanceof ContaCorrente){ 
				achada = ct;
			}
		}
		return achada;
	}

	public Conta buscarContaPoupanca() {
		Conta achada = null;
		for (Conta ct: contas){ // como parar se acabar a lista de administradores?  
			if (ct instanceof ContaPoupanca){ 
				achada = ct;
			}
		}
		return achada;
	}
	
	public void imprimirContas() {
		for(Conta ct : contas){
			if(ct instanceof ContaPoupanca){
				System.out.println("Conta Poupança numero: " + ct.getNumero());
			}else if(ct instanceof ContaCorrente){
				System.out.println("Conta Corrente numero: " + ct.getNumero());
			}
		}
		
	}
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isPoupanca() {
		return poupanca;
	}

	public void setPoupanca(boolean poupanca) {
		this.poupanca = poupanca;
	}

	public boolean isCorrente() {
		return corrente;
	}

	public void setCorrente(boolean corrente) {
		this.corrente = corrente;
	}

	public int getCadastro() {
		return cadastro;
	}

	public int getSenha() {
		return this.senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	
	
	
}
