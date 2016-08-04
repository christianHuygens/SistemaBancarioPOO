package br.ifrn.tads.poo.banco.cliente;

public class PessoaJuridica extends Cliente implements InterfacePessoaJuridica {

	public PessoaJuridica(String nome, String telefone, String email, int numDeCadastro, String cpnj, String nomeFantasia) {
		super(nome, telefone, email, numDeCadastro);
		this.cpnj = cpnj;
		this.nomeFantasia = nomeFantasia;
	}

	String cpnj, nomeFantasia;
	
	

	public String getCPNJ() {
		return this.cpnj;
	}

	public void setCPNJ(String cpnj) {
		this.cpnj = cpnj;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

}
