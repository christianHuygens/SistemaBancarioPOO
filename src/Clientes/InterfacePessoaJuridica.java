package Clientes;

public interface InterfacePessoaJuridica extends InterfaceCliente {
	String getCPNJ();
	void setCPNJ(String cpnj);
	String getNomeFantasia();
	void setNomeFantasia(String nomeFantasia);
}
