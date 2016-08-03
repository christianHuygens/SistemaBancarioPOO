package br.ifrn.tads.poo.banco;
import br.ifrn.tads.poo.banco.agencia.Agencia;
import java.util.ArrayList;
import java.util.Iterator;


public class Banco {
	String nome;
	int numero, numAgencia = 0001, numAdm = 001;
	ArrayList <Agencia> agencias = new ArrayList <Agencia>();
	ArrayList <Administrador> administradores = new ArrayList <Administrador>();
	
	// Construtor. Adiciona primeiro administrador.
	public Banco(int numero, String nome){
		this.nome = nome;
		this.numero = numero;
		Administrador primeiroAdm = new Administrador("Admin", this.numAdm, 1234);
		this.administradores.add(primeiroAdm);
		this.numAdm++;
//		Administrador segundoAdm = new Administrador("Admin2", this.numAdm, 4321);
//		this.administradores.add(segundoAdm);
//		this.numAdm++;
	}
	
	public void adicionarAdministrador(String nome, int numero, int senha){
		Administrador novoAdm = new Administrador(nome, numero, senha);
		this.administradores.add(novoAdm);
	}
	
	// verifica senha de administrador
	public boolean autenticarAdm(int numero, int senha){
		boolean autenticado = false;
		Administrador achado = this.getAdm(numero);
		if(achado.getSenha()==senha)
			autenticado = true;
		return autenticado;
	}
	
	// procura numero de administrador no arraylist administradores e o retorna. Caso não encontre, retorna null.
	public Administrador getAdm(int numero){
		Administrador achado = null;
		for (Administrador adm: administradores){ // como parar se acabar a lista de administradores?  
			if (adm.getNumero()==numero){ 
				achado = adm;
			}
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
		for (Agencia agc: agencias)  {  
			if (agc.getNumeroAgencia()==numeroAgencia){ 
				achado = agc;
			}
		}
		return achado;
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

	public int getNumAgencia() {
		return numAgencia;
	}
	
}