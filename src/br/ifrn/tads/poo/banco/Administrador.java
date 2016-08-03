package br.ifrn.tads.poo.banco;

public class Administrador {
	String nome;
	int numero, senha;
	
	public Administrador(String nome, int numero, int senha){
		this.nome = nome;
		this.numero = numero;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	
}
