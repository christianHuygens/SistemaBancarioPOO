package br.ifrn.tads.poo.banco.exceptions;

public class SaldoInsuficienteException extends Exception{
	
	public SaldoInsuficienteException() {
		super("Seu saldo é insuficiênte para esta transaçao");
	}

}
