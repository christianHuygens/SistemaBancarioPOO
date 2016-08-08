package br.ifrn.tads.poo.banco.main;
import br.ifrn.tads.poo.banco.app.APP;
import br.ifrn.tads.poo.banco.exceptions.SaldoInsuficienteException;
import br.ifrn.tads.poo.banco.exceptions.UsuarioNaoEncontradoException;

public class Main {

	public static void main(String[] args) throws SaldoInsuficienteException, UsuarioNaoEncontradoException {
		APP app = new APP();
		app.iniciar();
	}

}
