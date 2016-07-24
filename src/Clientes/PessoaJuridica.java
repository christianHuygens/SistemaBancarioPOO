package Clientes;

public class PessoaJuridica implements InterfacePessoaJuridica {

	String nome, telefone, email, cpnj, nomeFantasia;
	
	public PessoaJuridica(String nome, String telefone, String email, String cpnj, String nomeFantasia){
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpnj = cpnj;
		this.nomeFantasia = nomeFantasia;
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
