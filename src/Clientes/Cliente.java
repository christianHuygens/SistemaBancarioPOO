package Clientes;

public abstract class Cliente implements InterfaceCliente {

	String nome, telefone, email;
	
	public abstract String getNome();

	public abstract void setNome(String nome);

	public abstract String getTelefone();

	public abstract void setTelefone(String telefone);

	public abstract String getEmail();

	public abstract void setEmail(String email);

}
