package Clientes;

public class PessoaFisica extends Cliente implements InterfacePessoaFisica {

	public PessoaFisica(String nome, String telefone, String email, String cpf) {
		super(nome, telefone, email);
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
