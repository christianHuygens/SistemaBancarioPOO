package br.ifrn.tads.poo.banco.exceptions;

public class UsuarioNaoEncontradoException extends Exception{
	
	public UsuarioNaoEncontradoException() {
		super("Usuário não encontrado.");
	}

}
