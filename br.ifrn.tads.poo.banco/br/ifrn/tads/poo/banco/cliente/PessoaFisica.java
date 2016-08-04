package br.ifrn.tads.poo.banco.cliente;

public class PessoaFisica extends Cliente implements InterfacePessoaFisica {

	public PessoaFisica(String nome, String telefone, String email, int numDeCadastro, String cpf) {
		super(nome, telefone, email, numDeCadastro);
		this.cpf = cpf;
	}

	String cpf;
	
	public String getCPF() {
		return this.cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}


}
