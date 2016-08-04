package br.ifrn.tads.poo.banco.app;
import java.util.Scanner;

import br.ifrn.tads.poo.banco.agencia.Agencia;
import br.ifrn.tads.poo.banco.agencia.Conta;
import br.ifrn.tads.poo.banco.agencia.ContaCorrente;
import br.ifrn.tads.poo.banco.agencia.ContaPoupanca;
import br.ifrn.tads.poo.banco.banco.Banco;
import br.ifrn.tads.poo.banco.cliente.Cliente;
import br.ifrn.tads.poo.banco.cliente.PessoaFisica;
import br.ifrn.tads.poo.banco.cliente.PessoaJuridica;

public class APP {
	Scanner ler = new Scanner(System.in);
	Banco b = new Banco(01, "BancoPOO");
	public void iniciar() {
		System.out.println("Bem vindo ao Banco "+this.b.getNome()+".");
		this.identicacao();
	}

	//////////INTERFACE ADMINISTRADOR//////////
	
	private void identicacao() {
		while(true){
			System.out.println("Por favor, identifique-se."
					+ "\nDigite o seu numero de cadastro:");
			int numeroAut = ler.nextInt();
			System.out.println("Digite o sua senha:");
			int senhaAut = ler.nextInt();
			if(this.b.autenticarAdm(numeroAut, senhaAut)){
				this.iniciarAppAdmin();
			}else{
				System.out.println("Administrador não encontrado ou senha errada. Tente novamente.");
			}
		}
	}

	private void iniciarAppAdmin() {
		boolean adminAcessando = true;
		while(adminAcessando){
			System.out.println("////////ÁREA DE ADMINISTRADOR////////"
					+ "\nO que deseja fazer?"
					+ "\n1 - Adicionar Agencia;"
					+ "\n2 - Remover Agencia;"
					+ "\n3 - Acessar Agencia;"
					+ "\n4 - Imprimir lista de Agencias;"
					+ "\n5 - Liberar acesso ao cliente;"
					+ "\n6 - Fazer Logout;");
			int acaoEscolhida = ler.nextInt();
			switch(acaoEscolhida){
			case 1:
				System.out.println("Digite o nome da Agencia que deseja criar:");
				String nomeAgencia = ler.next();
				Agencia novaAgencia = new Agencia(this.b.getNumAgencia(), nomeAgencia);
				if(this.b.adicionarAgencia(novaAgencia))
					System.out.println("Agencia "+novaAgencia.getNomeAgencia()+" (de numero "+novaAgencia.getNumeroAgencia()+") criada com sucesso.");
				else
					System.out.println("Agencia não criada. Tente novamente.");
				break;
			case 2:
				System.out.println("Digite o numero da Agencia que deseja REMOVER:");
				this.b.imprimirListaAgencias();
				int agenciaRemover = ler.nextInt();
				boolean estatus = this.b.removerAgencia(agenciaRemover);
				if (estatus==true){
					System.out.println("Agencia removida com sucesso.");
				}else{
					System.out.println("Agencia NÃO removida.");
				}
				break;
			case 3:
				System.out.println("Digite o numero da Agencia que deseja ACESSAR:");
				this.b.imprimirListaAgencias();
				int agenciaBuscada = ler.nextInt();
				Agencia agenciaAchada = this.b.buscarAgencia(agenciaBuscada);
				if(agenciaAchada != null){
					this.acessarAgencia(agenciaAchada);
				}
				break;
			case 4:
				this.b.imprimirListaAgencias();
				break;
			case 5:
				this.interfaceCliente();
				break;
			case 6:
				adminAcessando = false;
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		}
	}

	private void acessarAgencia(Agencia agenciaAchada) {
		boolean agenciaEmAcesso = true;
		while(agenciaEmAcesso){
			System.out.println("////////ÁREA DE ACESSO A AGÊNCIA: "+agenciaAchada.getNomeAgencia()+" de número: "
					+ agenciaAchada.getNumeroAgencia()+"////////"
					+ "\nO que deseja fazer?"
					+ "\n1 - Cadastrar novo Cliente;"
					+ "\n2 - Remover Cliente;"
					+ "\n3 - Acessar Cliente;"
					+ "\n4 - Ver lista de Clientes;"
					+ "\n5 - Sair de Agencia;");
			int acaoEscolhida = ler.nextInt();
			switch(acaoEscolhida){
			case 1:
				this.cadastrarNovoCliente(agenciaAchada);
				break;
			case 2:
				System.out.println("Digite o número do cliente que deseja REMOVER:");
				agenciaAchada.imprimirListaClientes();
				int clienteRemover = ler.nextInt();
				boolean estatus = agenciaAchada.removerCliente(clienteRemover);
				if (estatus==true){
					System.out.println("Cliente removido com sucesso.");
				}else{
					System.out.println("Cliente NÃO removido.");
				}
				break;
			case 3:
				System.out.println("Digite o numero do cadastro do Cliente que deseja acessar:");
				agenciaAchada.imprimirListaClientes();
				int clienteBuscado = ler.nextInt();
				Cliente clienteAchado = agenciaAchada.buscarCliente(clienteBuscado);
				if(clienteAchado != null){
					this.acessarCliente(clienteAchado, agenciaAchada);
				}else{
					System.out.println("Cliente não encontrado. Tente novamente.");
				}
				break;
			case 4:
				agenciaAchada.imprimirListaClientes();
				break;
			case 5:
				agenciaEmAcesso = false;
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		}
	}

	
	private void cadastrarNovoCliente(Agencia agenciaAchada){
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
			Cliente novoCliente1 = new PessoaFisica(nomeCliente1, telefoneCliente1, emailCliente1, b.getNumDeCadastroCliente(), cpfCliente);
			agenciaAchada.cadastrarCliente(novoCliente1);
			b.addNumDeCadastroCliente();
			System.out.println("Cliente "+novoCliente1.getNome()+" de numero "+novoCliente1.getCadastro()+" cadastrado com sucesso.");
			System.out.println("Deseja cadastrar conta para cliente "+novoCliente1.getNome()+"?"
					+ "\n1 - Sim;"
					+ "\n2 - Não;");
			int acaoEscolhida = ler.nextInt();
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
			Cliente novoCliente2 = new PessoaJuridica(nomeCliente2, telefoneCliente2, emailCliente2, b.getNumDeCadastroCliente(), cpnjCliente, nomeFatasiaCliente);
			agenciaAchada.cadastrarCliente(novoCliente2);
			b.addNumDeCadastroCliente();
			System.out.println("Cliente "+novoCliente2.getNome()+" de numero "+novoCliente2.getCadastro()+" cadastrado com sucesso.");
			System.out.println("Deseja cadastrar conta para cliente "+novoCliente2.getNome()+"?"
					+ "\n1 - Sim;"
					+ "\n2 - Não;");
			acaoEscolhida = ler.nextInt();
			if(acaoEscolhida == 1)
				this.criarConta(novoCliente2, agenciaAchada);
			break;
		default:
			System.out.println("Entrada inválida.");
		}
	}
	
	
	private void acessarCliente(Cliente clienteAchado, Agencia agenciaAchada) {
		boolean clienteEmAcesso = true;
		while(clienteEmAcesso){
			System.out.println("////////ÁREA DE ACESSO AO CLIENTE: " + clienteAchado.getNome() + " ////////"
					+ "\nO que deseja fazer?"
					+ "\n1 - Acessar dados do cliente;"
					+ "\n2 - Atualizar dados do Cliente;"
					+ "\n3 - Criar nova conta;"
					+ "\n4 - Desativar conta de cliente;"
					+ "\n5 - Acessar detalhes de conta de cliente;"
					+ "\n6 - Calcular rencimento de Conta Poupança;"
					+ "\n7 - Mudar limite de Conta Corrente;"
					+ "\n8 - Sair;");
			int acaoEscolhida = ler.nextInt();
			switch(acaoEscolhida){
			
			case 1:
				System.out.println("Nome: "+clienteAchado.getNome()+";"
						+ "\nTelefone: "+clienteAchado.getTelefone()+";"
						+ "\nE-mail: "+clienteAchado.getEmail()+";");
				if(clienteAchado instanceof PessoaFisica){
					System.out.println("CFP: "+((PessoaFisica)clienteAchado).getCPF()+".");
				}else if(clienteAchado instanceof PessoaJuridica){
					System.out.println("CFNJ: "+((PessoaJuridica)clienteAchado).getCPNJ()+";"
							+ "\nNome Fantasia: "+((PessoaJuridica)clienteAchado).getNomeFantasia()+".");
				}
				System.out.println("Contas:");
				if(clienteAchado.isPoupanca() || clienteAchado.isCorrente()){
					clienteAchado.imprimirContas();
				}
				break;
			case 2:
				this.mudarDadosCliente(clienteAchado);
				break;
			case 3:
				this.criarConta(clienteAchado, agenciaAchada);
				break;
			case 4:
				if(clienteAchado.isPoupanca() || clienteAchado.isCorrente()){
					System.out.println("Digite o número da conta que deseja DESATIVAR");
					clienteAchado.imprimirContas();
				}else{
					System.out.println("O cliente "+clienteAchado.getNome()+" ainda não possui conta cadastrada.");
				}
				int contaRemover = ler.nextInt();
				boolean estatus = clienteAchado.removerConta(contaRemover);
				if (estatus==true){
					System.out.println("Conta removida com sucesso.");
				}else{
					System.out.println("Conta NÃO removida.");
				}
				break;
			case 5:
				if(clienteAchado.isPoupanca() || clienteAchado.isCorrente()){
					System.out.println("Digite o número da conta que deseja ACESSAR");
					clienteAchado.imprimirContas();
				}else{
					System.out.println("O cliente "+clienteAchado.getNome()+" ainda não possui conta cadastrada.");
				}
				int contaAcessar = ler.nextInt();
				Conta conta = clienteAchado.buscarConta(contaAcessar);
				conta.verSituacaoConta();
				break;
			case 6:
				if(clienteAchado.isPoupanca()){
					System.out.println("DIGITE o novo limite da conta corrente:");
					ContaPoupanca contaPoupanca = (ContaPoupanca) clienteAchado.buscarContaPoupanca();
					System.out.println("Rendimento da Poupança é de : "+ contaPoupanca.calcularRendimento());
				}else{
					System.out.println("O cliente "+clienteAchado.getNome()+" ainda não possui conta corrente.");
				}
				break;
			case 7:
				if(clienteAchado.isCorrente()){
					System.out.println("DIGITE o novo limite da conta corrente:");
				}else{
					System.out.println("O cliente "+clienteAchado.getNome()+" ainda não possui conta corrente.");
				}
				ContaCorrente contaCorrente = (ContaCorrente) clienteAchado.buscarContaCorrente();
				System.out.println("Limite Atual: "+contaCorrente.getLimite());
				double novoLimite = ler.nextDouble();
				contaCorrente.setLimite(novoLimite);
				System.out.println("Limite atualizado para "+contaCorrente.getLimite()+".");
				break;
			case 8:
				clienteEmAcesso = false;
			default:
				System.out.println("Opção inválida. Tente novamente.");	
				break;
			}
		}
	}

	private void mudarDadosCliente(Cliente clienteAchado) {
		boolean dadosEmAcesso = true;
		while(dadosEmAcesso){
			System.out.println("////////ÁREA DE ACESSO AOS DADOS DO CLIENTE: "+clienteAchado.getNome()+"////////"
					+ "\nDigite o dado que deseja MODIFICAR:"
					+ "\n1 - Nome;"
					+ "\n2 - Telefone;"
					+ "\n3 - E-mail;");
			if(clienteAchado instanceof PessoaFisica){
			System.out.println("4 - CPF;");	
			}else{
				System.out.println("4 - CPNJ;"
						+ "\n5 - Nome Fantasia;");	
			}
			System.out.println("6 - Sair");
			int dadoModificar = ler.nextInt();
			if(clienteAchado instanceof PessoaFisica){
				switch(dadoModificar){
				case 1:
					System.out.println("Digite o novo NOME do Cliente:");
					String dadoNome = ler.next();
					clienteAchado.setNome(dadoNome);
					break;
				case 2:
					System.out.println("Digite o novo TELEFONE do Cliente:");
					String dadoTelefone = ler.next();
					clienteAchado.setTelefone(dadoTelefone);
					break;
				case 3:
					System.out.println("Digite o novo E-MAIL do Cliente:");
					String dadoEmail = ler.next();
					clienteAchado.setEmail(dadoEmail);
					break;
				case 4:
					System.out.println("Digite o novo CPF do Cliente:");
					String dadoCpf = ler.next();
					((PessoaFisica) clienteAchado).setCPF(dadoCpf);
					break;
				case 6:
					dadosEmAcesso = false;
					break;
				default:
					System.out.println("Entrada inválida.");
				}
			}else{
				switch(dadoModificar){
				case 1:
					System.out.println("Digite o novo NOME do Cliente:");
					String dadoNome = ler.next();
					clienteAchado.setNome(dadoNome);
					break;
				case 2:
					System.out.println("Digite o novo TELEFONE do Cliente:");
					String dadoTelefone = ler.next();
					clienteAchado.setTelefone(dadoTelefone);
					break;
				case 3:
					System.out.println("Digite o novo E-MAIL do Cliente:");
					String dadoEmail = ler.next();
					clienteAchado.setEmail(dadoEmail);
					break;
				case 4:
					System.out.println("Digite o novo CPNJ do Cliente:");
					String dadoCPNJ = ler.next();
					((PessoaJuridica) clienteAchado).setCPNJ(dadoCPNJ);
					break;
				case 5:
					System.out.println("Digite o novo NOME FANTASIA do Cliente:");
					String dadoNomeF = ler.next();
					((PessoaJuridica) clienteAchado).setNomeFantasia(dadoNomeF);;
					break;
				case 6:
					dadosEmAcesso = false;
					break;
				default:
					System.out.println("Entrada inválida.");
				}
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
			if(!cliente.isPoupanca()){
				agenciaAchada.criarConta(agenciaAchada.getNumConta(), cliente, "poupanca");
				cliente.setPoupanca(true);
				System.out.println("Conta Poupança do cliente "+cliente.getNome()+" criada com sucesso.");
			}else{
				System.out.println("O cliente já possui conta poupança.");
			}
			break;
		case 2:
			if(!cliente.isCorrente()){
				agenciaAchada.criarConta(agenciaAchada.getNumConta(), cliente, "corrente");
				cliente.setCorrente(true);
				System.out.println("Conta Corrente do cliente "+cliente.getNome()+" criada com sucesso.");

			}else{
				System.out.println("O cliente já possui conta corrente.");
			}
			break;

		default:
			System.out.println("Opção inválida. Tente novamente.");
			break;
		}

	}
	
	///////////INTERFACE CLIENTE/////////
	
	private void interfaceCliente() {
		// TODO Auto-generated method stub
		
	}

}
