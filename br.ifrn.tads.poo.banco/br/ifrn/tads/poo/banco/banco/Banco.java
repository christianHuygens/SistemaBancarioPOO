package br.ifrn.tads.poo.banco.banco;
import br.ifrn.tads.poo.banco.agencia.Agencia;
import br.ifrn.tads.poo.banco.exceptions.SaldoInsuficienteException;
import br.ifrn.tads.poo.banco.exceptions.UsuarioNaoEncontradoException;

import java.util.ArrayList;
import java.util.Iterator;


public class Banco {
	String nome;
	final int numero; 
	int numAgencia = 0001, numAdm = 1, codDeAcessoCliente = 1; // Cada cliente tem um numero único
	ArrayList <Agencia> agencias = new ArrayList <Agencia>();
	ArrayList <Administrador> administradores = new ArrayList <Administrador>();
	
	// Construtor. Adiciona primeiro administrador.
	public Banco(int numero, String nome){
		this.nome = nome;
		this.numero = numero;
		Administrador primeiroAdm = new Administrador("Admin", this.numAdm, 1234);
		this.administradores.add(primeiroAdm);
		this.numAdm++;
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
		this.numAgencia++;
		return true;
	}
	
	
	public Agencia buscarAgencia(int numeroAgencia){
		Agencia achado = null;
		if(!agencias.isEmpty()){
			for (Agencia agc: agencias)  {  
				if (agc.getNumeroAgencia()==numeroAgencia){ 
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
				System.out.println(agc.getNomeAgencia()+": "+agc.getNumeroAgencia());
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

	public int getNumero() {
		return numero;
	}

	public int getNumAgencia() {
		return numAgencia;
	}

	public int getNumDeCadastroCliente() {
		return this.codDeAcessoCliente;
	}
	
	public int addNumDeCadastroCliente() {
		return this.codDeAcessoCliente++;
	}
}
