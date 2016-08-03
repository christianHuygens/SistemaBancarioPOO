package br.ifrn.tads.poo.banco.cliente;
import java.util.ArrayList;
import br.ifrn.tads.poo.banco.agencia.Conta;

public class Cliente implements InterfaceCliente {

	String nome, telefone, email;
	int numContaCorrente, numContaPoupança; // Add relatório
	ArrayList <Conta> contas = new ArrayList <Conta>(2); // cada cliente só terá duas contas. Uma paupança e outra corrente
	
	public Cliente(String nome, String telefone, String email){
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
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

}
