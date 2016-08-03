package br.ifrn.tads.poo.banco.app;
import java.util.Scanner;
import br.ifrn.tads.poo.banco.Banco;
import br.ifrn.tads.poo.banco.agencia.Agencia;
import br.ifrn.tads.poo.banco.cliente.Cliente;
import br.ifrn.tads.poo.banco.cliente.PessoaFisica;
import br.ifrn.tads.poo.banco.cliente.PessoaJuridica;

public class APP {
	Scanner ler = new Scanner(System.in);
	Banco b = new Banco(01, "BancoPOO");
	public void iniciar() {
		System.out.println("Bem vindo ao Banco "+b.getNome()+".");
		this.identicacao();
	}

	private void identicacao() {
		while(true){
			System.out.println("Por favor, identifique-se."
					+ "\nDigite o seu numero de cadastro:");
			int numeroAut = ler.nextInt();
			System.out.println("Digite o sua senha:");
			int senhaAut = ler.nextInt();
			if(b.autenticarAdm(numeroAut, senhaAut)){
				this.iniciarAppAdmin();
			}else{
				System.out.println("Administrador não encontrado ou senha errada. Tente novamente.");
			}
		}
	}

	private void iniciarAppAdmin() {
		boolean adminAcessando = true;
		while(adminAcessando){
			System.out.println("Seja bem vindo, Administrador."
					+ "\nO que deseja fazer?"
					+ "\n1 - Adicionar Agencia;"
					+ "\n2 - Acessar Agencia;"
					+ "\n3 - Fazer Logout;");
			int acaoEscolhida = ler.nextInt();
			switch(acaoEscolhida){
			case 1:
				System.out.println("Digite o nome da Agencia que deseja criar:");
				String nomeAgencia = ler.next();
				Agencia novaAgencia = new Agencia(b.getNumAgencia(), nomeAgencia);
				if(b.adicionarAgencia(novaAgencia))
					System.out.println("Agencia "+novaAgencia.getNumeroAgencia()+" criada com sucesso.");
				else
					System.out.println("Agencia não criada. Tente novamente.");
				break;
			case 2:
				System.out.println("Digite o numero da Agencia que deseja acessar:");
				int agenciaBuscada = ler.nextInt();
				Agencia agenciaAchada = b.buscarAgencia(agenciaBuscada);
				if(agenciaAchada != null){
					this.acessarAgencia(agenciaAchada);
				}
				break;
			case 3:
				adminAcessando = false;
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		}
	}

	private void acessarAgencia(Agencia agenciaAchada) {
		boolean agenciaAcessada = true;
		while(agenciaAcessada){
			System.out.println("Bem vindo a agencia "+agenciaAchada.getNomeAgencia()+" de numero "
					+ agenciaAchada.getNumeroAgencia()+"."
					+ "\nO que deseja fazer?"
					+ "\n1 - Cadastrar novo Cliente;"
					+ "\n2 - Acessar Cliente;"
					+ "\n3 - Sair de Agencia;");
			int acaoEscolhida = ler.nextInt();
			switch(acaoEscolhida){
			case 1:
				System.out.println("Digite o tipo de Cliente que deseja cadastrar:"
						+ "\n1 - Pessoa Física;"
						+ "\n2 - Pessoa Jurídica;"
						+ "\n3 - Cancelar Ação;");
				int tipoCliente = ler.nextInt();
				switch(tipoCliente){
				case 1:
					System.out.println("Digite o NOME do Cliente que deseja cadastrar:");
					String nomeCliente1 = ler.next();

					System.out.println("Digite o TELEFONE do Cliente que deseja cadastrar:");
					String telefoneCliente1 = ler.next();

					System.out.println("Digite o EMAIL do Cliente que deseja cadastrar:");
					String emailCliente1 = ler.next();

					System.out.println("Digite o CPF do Cliente que deseja cadastrar:");
					String cpfCliente = ler.next();
					Cliente novoCliente1 = new PessoaFisica(nomeCliente1, telefoneCliente1, emailCliente1, cpfCliente);
					agenciaAchada.cadastrarCliente(novoCliente1);
					System.out.println("Deseja cadastrar conta para cliente "+novoCliente1.getNome()+"?"
							+ "\n1 - Sim;"
							+ "\n2 - Não;");
					acaoEscolhida = ler.nextInt();
					if(acaoEscolhida == 1)
						this.criarConta(novoCliente1, agenciaAchada);
					break;
				case 2:
					System.out.println("Digite o NOME do Cliente que deseja cadastrar:");
					String nomeCliente2 = ler.next();

					System.out.println("Digite o TELEFONE do Cliente que deseja cadastrar:");
					String telefoneCliente2 = ler.next();

					System.out.println("Digite o EMAIL do Cliente que deseja cadastrar:");
					String emailCliente2 = ler.next();

					System.out.println("Digite o CPNJ do Cliente que deseja cadastrar:");
					String cpnjCliente = ler.next();
					System.out.println("Digite o NOME FANTASIA da empresa que deseja cadastrar:");
					String nomeFatasiaCliente = ler.next();
					Cliente novoCliente2 = new PessoaJuridica(nomeCliente2, telefoneCliente2, emailCliente2, cpnjCliente, nomeFatasiaCliente);
					agenciaAchada.cadastrarCliente(novoCliente2);
					System.out.println("Deseja cadastrar conta para cliente "+novoCliente2.getNome()+"?"
							+ "\n1 - Sim;"
							+ "\n2 - Não;");
					acaoEscolhida = ler.nextInt();
					if(acaoEscolhida == 1)
						this.criarConta(novoCliente2, agenciaAchada);
					break;

				case 3:
					agenciaAcessada = false;
					break;
				default:
					break;
				}
				break;
			case 2:
				//					System.out.println("Digite o numero da Agencia que deseja acessar:");
				//					int agenciaBuscada = ler.nextInt();
				//					Agencia agenciaAchada = b.buscarAgencia(agenciaBuscada);
				//					if(agenciaAchada != null){
				//						this.acessarAgencia(agenciaAchada);
				//					}
				break;
			case 3:
				agenciaAcessada = false;
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		}
	}

	private void criarConta(Cliente cliente, Agencia agenciaAchada) {
		System.out.println("Digite o tipo de Conta que deseja criar para o cliente "+cliente.getNome()+":"
				+ "\n1 - Conta Poupança;"
				+ "\n2 - Conta Corrente;");
		int acaoEscolhida = ler.nextInt();
		switch(acaoEscolhida){
		case 1:
			agenciaAchada.criarConta(agenciaAchada.getNumConta(), cliente, "poupanca");
			break;
		case 2:
			agenciaAchada.criarConta(agenciaAchada.getNumConta(), cliente, "corrente");
			break;
			
		default:
			System.out.println("Opção inválida. Tente novamente.");
			break;
		}

	}

}
