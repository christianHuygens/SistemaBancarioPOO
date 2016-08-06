package br.ifrn.tads.poo.banco.main;
import br.ifrn.tads.poo.banco.app.APP;
import br.ifrn.tads.poo.banco.banco.Banco;
import br.ifrn.tads.poo.banco.exceptions.SaldoInsuficienteException;

public class Main {

	public static void main(String[] args) throws SaldoInsuficienteException {
		APP app = new APP();
		app.iniciar();
	}

}
