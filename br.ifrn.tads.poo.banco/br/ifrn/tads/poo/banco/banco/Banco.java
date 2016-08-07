package br.ifrn.tads.poo.banco.banco;
import br.ifrn.tads.poo.banco.agencia.Agencia;
import br.ifrn.tads.poo.banco.exceptions.SaldoInsuficienteException;
import br.ifrn.tads.poo.banco.exceptions.UsuarioNaoEncontradoException;

import java.util.ArrayList;
import java.util.Iterator;


public class Banco {
	String nome;
	final int codigoBanco; 
	int codAgencia = 0001, codAdm = 1, codDeAcessoCliente = 1; // Cada cliente tem um numero único
	ArrayList <Agencia> agencias = new ArrayList <Agencia>();
	ArrayList <Administrador> administradores = new ArrayList <Administrador>();
	
	// Construtor. Adiciona primeiro administrador.
	public Banco(int numero, String nome){
		this.nome = nome;
		this.codigoBanco = numero;
		Administrador primeiroAdm = new Administrador("Admin", this.codAdm, 1234);
		this.administradores.add(primeiroAdm);
		this.codAdm++;
	}
	
	public void adicionarAdministrador(String nome, int numero, int senha){
		Administrador novoAdm = new Administrador(nome, numero, senha);
		this.administradores.add(novoAdm);
	}
	
	// verifica senha de administrador
	public boolean autenticarAdm(int numero, int senha) throws UsuarioNaoEncontradoException{
		Administrador achado = this.getAdm(numero);
		if(achado.getSenha()==senha){
			return true;
			}
			return false;
		

	}
	
	// procura numero de administrador no arraylist administradores e o retorna. Caso não encontre, retorna null.
	public Administrador getAdm(int numero) throws UsuarioNaoEncontradoException{
		Administrador achado = null;
		for (Administrador adm: administradores){ // como parar se acabar a lista de administradores?  
			if (adm.getNumero()==numero){ 
				achado = adm;
			}
		}
		if(achado == null){
			throw new UsuarioNaoEncontradoException();
		}
		return achado;
	}
	
	public boolean adicionarAgencia(Agencia novaAgencia){
		agencias.add(novaAgencia);
		this.codAgencia++;
		return true;
	}
	
	
	public Agencia buscarAgencia(int codAgencia){
		Agencia achado = null;
		if(!agencias.isEmpty()){
			for (Agencia agc: agencias)  {  
				if (agc.getCodAgencia()==codAgencia){ 
					achado = agc;
				}
			}
		}else{
			System.out.println("Não há agencias cadastradas.");
		}
		return achado;
	}
	
	public boolean removerAgencia(int numAgencia){
		boolean estatus = false;
		Agencia remover = this.buscarAgencia(numAgencia);
		if(remover!=null){
			estatus = agencias.remove(remover);
		}
		return estatus;
	}
	
	public void imprimirListaAgencias(){
		if(!agencias.isEmpty()){
			for (Agencia agc: agencias)  {  
				System.out.println(agc.getNomeAgencia()+": "+agc.getCodAgencia());
			}
		}else{
			System.out.println("Não há agencias cadastradas.");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigoBanco() {
		return codigoBanco;
	}

	public int getCodAgencia() {
		return codAgencia;
	}

	public int getCodDeCadastroCliente() {
		return this.codDeAcessoCliente;
	}
	
	public int addCodDeCadastroCliente() {
		return this.codDeAcessoCliente++;
	}
}
