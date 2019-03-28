package com.qualidade.metrica;

import javax.swing.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Atendimento {

	private static class Atende {
		public int cartao;
		public String nome;
		public String sobreNome;
		double valor;
		public Atende prox;
	}

	public static void main(String[] args) {
		Atende inicio = null;
		Atende fim = null;
		Atende aux = null;
		int op = 0;
		menu: while(true) {
			op = mostrarMenu();
			switch (op) {
			case 1:
				int numero = 0;
				try {
					numero = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DO CARTÃO: ", "0"));
				} catch (NumberFormatException e) {
					agenteDeErro(e);
					continue;
				}
				aux = inicio;
				boolean achou = false;
				while (aux != null) {
					if (aux.cartao == numero) {
						achou = true;
						JOptionPane.showMessageDialog(null, "Esse número do cartão já foi usado.\nFavor verificar!");
						break;
					}
					aux = aux.prox;
				}
				if (achou == false) {
					Atende novo = new Atende();
					novo.cartao = numero;
					
					try {
						novo.nome = JOptionPane.showInputDialog("NOME: ", "");
						novo.sobreNome = JOptionPane.showInputDialog("SOBRENOME: ", "");
						novo.valor = Double.parseDouble(JOptionPane.showInputDialog("VALOR: ", "0"));
					} catch (NumberFormatException e) {
						agenteDeErro(e);
						continue;
					}
					if (inicio == null) {
						inicio = novo;
						fim = novo;
					} else {
						fim.prox = novo;
						fim = novo;
						System.out.println("IF APENAS PARA TESTE DA OPÇÃO: há elementos na lista ...");
					}
					JOptionPane.showMessageDialog(null,
							"O cartão número " + novo.cartao + ", foi inserido para atendimento: ",
							"MENSAGEM DO PROGRAMA", JOptionPane.CLOSED_OPTION);
				}
				break;
			case 2:
				aux = consultarDadosAtendimento(inicio, aux);				
				break;
			case 3:
				inicio = verificaAtendimento(inicio);
				break;
			case 4:
				inicio = liberaAtendimento(inicio);
				break;
			case 5:
				aux = coneudoDoAtendimento(inicio);
				break;
			case 6:
				aux = dadosDoCliente(inicio);
				break;
			case 7:
				aux = dadosDoCartao(inicio);
				break;
			case 8:
				aux = gravarArquivo(inicio, aux);
				break;
			case 9:
				verArquivo();
				break;
			case 10:
				aux = filtrarAtendimento(inicio);
				break;
			case 11:
				aux = consultarAtendimento(inicio, aux);
				break;
			case 12:
				exibirSobre();
				break;
			case 13:
				JOptionPane.showMessageDialog(null, " * PROGRAMA FINALIZADO * ");
				break menu;
			default:
				System.out.println("Opção Inválida!!");
				break;
			}
		} 
	}

	private static void exibirSobre() {
		JTextArea saida = new JTextArea(8, 30); // HEIGHT X WIDTH
		saida.append("\n");
		saida.append("PROGRAMA DE ATENDIMENTO AO CLIENTE\n-------------------------------------------------------------\nCopyright (c) Byta Bug Informática Ltda\nProgramadores: Asdrubal, Indalécio e Quelé\nVersão 1.0\n-------------------------------------------------------------\nData: Fevereiro de 2019\n-------------------------------------------------------------\n\n");
		JOptionPane.showMessageDialog(null, saida, "SOBRE O PROGRAMA", JOptionPane.CLOSED_OPTION);
	}

	private static Atende consultarAtendimento(Atende inicio, Atende aux) {
		if (inicio == null) {
			atendimentoVazio();
		} else {
			JTextArea saida = new JTextArea(7, 45); // HEIGHT X WIDTH
			JScrollPane scroll = new JScrollPane(saida);
			saida.append("NOME\t" + "ENDEREÇO\tPROX\t\n");
			saida.append("-------------------------------------------------------------\n");
			aux = inicio;
			while (aux != null) {
				if (aux.prox != null)
					saida.append(aux.nome + "\t" + aux.hashCode() + "\t" + aux.prox.hashCode() + "\n");
				else
					saida.append(aux.nome + "\t" + aux.hashCode() + "\tfim\n");

				aux = aux.prox;
			}
			saida.append("\n");
			mensagemConsultarDados(scroll);
		}
		return aux;
	}

	private static Atende filtrarAtendimento(Atende inicio) {
		Atende aux;
		double filtro = Double.parseDouble(
				JOptionPane.showInputDialog("FILTRAR ATENDIMENTOS PARA VALORES SUPERIORES A: ", ""));
		JTextArea saida = new JTextArea(6, 45); // HEIGHT X WIDTH
		JScrollPane scroll = new JScrollPane(saida);
		saida.append("CARTÃO\t" + "NOME\t" + "SOBRENOME\t" + "VALOR\n");
		saida.append("----------------------------------------------------------------------------\n");
		aux = inicio;
		while (aux != null) {
			if (aux.valor > filtro) {
				saida.append(aux.cartao + "\t" + aux.nome + "\t" + aux.sobreNome + "\t" + aux.valor + "\n");
			}
			if (aux.valor < filtro) {
				System.out.println("IF APENAS PARA TESTE DA OPÇÃO: valor Inferior a filtro ...");
			}
			aux = aux.prox;
		}
		saida.append("\n");
		JOptionPane.showMessageDialog(null, scroll, "ATENDIMENTOS COM VALORES SUPERIORES A: " + filtro,
				JOptionPane.CLOSED_OPTION);
		return aux;
	}

	private static void verArquivo() {
		int resposta = JOptionPane.showConfirmDialog(null, "DESEJA VER ARQUIVO?", "MENSAGEM",
				JOptionPane.YES_NO_OPTION);
		if (resposta == JOptionPane.YES_OPTION) {
			try {
				Process pro = Runtime.getRuntime().exec("cmd.exe /c  Atendimento.txt");
				pro.waitFor();
			} catch (Exception e) {
				System.out.println("Erro . . . ");
			}
		} else {
			System.out.println("IF APENAS PARA TESTE DA OPÇÃO: verificação JOptionPane ...");
		}
	}

	private static Atende gravarArquivo(Atende inicio, Atende aux) {
		if (inicio == null) {
			atendimentoVazio();
		} else {
			aux = inicio;
			try {
				FileWriter arq = new FileWriter("Atendimento.txt");
				PrintWriter gravar = new PrintWriter(arq);
				while (aux != null) {

					gravar.printf("%d, %s, %s, %.2f %n", aux.cartao, aux.nome, aux.sobreNome, +aux.valor);
					aux = aux.prox;
				}
				gravar.printf("%s %n", "--------------------------");
				gravar.printf("%s %n", "copyright (c) by: Fulano de Tal, Sicrano de Tal");
				arq.close();
			} catch (IOException e) {
				System.out.println("MENSAGEM / CLASS ArquivoTexto:\nErro ao tentar gravar no arquivo");
			}
			JOptionPane.showMessageDialog(null,
					"ARQUIVO GRAVADO COM SUCESSO" + "\n(Na própria pasta do projeto)...", "MENSAGEM DO SISTEMA",
					JOptionPane.CLOSED_OPTION);
			System.out.println("Arquivo gravado com sucesso na própria pasta do projeto ...");
		}
		return aux;
	}

	private static Atende dadosDoCartao(Atende inicio) {
		Atende aux;
		String nome = JOptionPane.showInputDialog("Nome do cliente", "");
		aux = inicio;
		int posicao = 1;
		while (aux != null) {
			if (aux.nome.equals(nome)) {
				String texto = "CARTÃO: " + aux.cartao + "\n" + "NOME: " + aux.nome + "\n" + "SOBRENOME: "
						+ aux.sobreNome + "\n" + "VALOR: " + aux.valor + "\n" + "POSIÇÃO: " + posicao
						+ "a. POSIÇÃO";
				mensagemDoPrograma(texto);
			} else {
				System.out.println("IF APENAS PARA TESTE DA OPÇÃO: nome diferente do nome informado ...");
			}
			posicao++;
			aux = aux.prox;
		}
		return aux;
	}

	private static Atende dadosDoCliente(Atende inicio) {
		Atende aux;
		int cartao = Integer.parseInt(JOptionPane.showInputDialog("Informe o número do cartão", "0"));
		aux = inicio;
		int posicao = 1;
		while (aux != null) {
			if (cartao == aux.cartao) {
				String texto = "CARTÃO: " + aux.cartao + "\n" + "NOME: " + aux.nome + "\n" + "SOBRENOME: "
						+ aux.sobreNome + "\n" + "VALOR: " + aux.valor + "\n" + "POSIÇÃO: " + posicao
						+ "a. POSIÇÃO";
				mensagemDoPrograma(texto);
			}
			if (cartao != aux.cartao) {
				System.out.println(
						"IF APENAS PARA TESTE DA OPÇÃO: cartão NÃO recebe endereço auxiliar do cartão ...");
			}
			posicao++;
			aux = aux.prox;
		}
		return aux;
	}

	private static void mensagemDoPrograma(String texto) {
		JOptionPane.showMessageDialog(null, "DADOS DO CLIENTE: \n\n" + texto, "MENSAGEM DO PROGRAMA",
				JOptionPane.CLOSED_OPTION);
	}

	private static Atende coneudoDoAtendimento(Atende inicio) {
		Atende aux;
		aux = inicio;
		int n = 0;
		double soma = 0;
		while (aux != null) {
			soma = soma + aux.valor;
			aux = aux.prox;
			n++;
		}
		JOptionPane.showMessageDialog(null,
				"O ATENDIMENTO CONTÉM: " + n + " ELEMENTOS.\nVALOR TOTAL: " + soma + "\n",
				"MENSAGEM DO PROGRAMA", JOptionPane.CLOSED_OPTION);
		return aux;
	}

	private static Atende liberaAtendimento(Atende inicio) {
		if (inicio == null) {
			atendimentoVazio();
		} else {
			inicio = null;
			JOptionPane.showMessageDialog(null, " * * O ATENDIMENTO FOI LIBERADO * *", "MENSAGEM DO PROGRAMA",
					JOptionPane.CLOSED_OPTION);
		}
		return inicio;
	}

	private static Atende verificaAtendimento(Atende inicio) {
		if (inicio == null) {
			atendimentoVazio();
		} else {
			JOptionPane.showMessageDialog(null,
					"CARTÃO:  " + inicio.cartao + ", NOME: " + inicio.nome + " foi atendido(a)!",
					"MENSAGEM DO PROGRAMA", JOptionPane.CLOSED_OPTION);
			inicio = inicio.prox;
		}
		if (inicio != null) {
			System.out.println("IF APENAS PARA TESTE DA OPÇÃO: há elementos na lista ...");
		}
		return inicio;
	}

	private static Atende consultarDadosAtendimento(Atende inicio, Atende aux) {
		if (inicio == null) {
			atendimentoVazio();
		} else {
			JTextArea saida = new JTextArea(6, 45); // HEIGHT X WIDTH
			JScrollPane scroll = new JScrollPane(saida);
			saida.append("CARTÃO\t" + "NOME\t" + "SOBRENOME\t" + "VALOR\n");
			saida.append("-------------------------------------------------------------------------\n");
			aux = inicio;
			while (aux != null) {
				saida.append(aux.cartao + "\t" + aux.nome + "\t" + aux.sobreNome + "\t" + aux.valor + "\n");
				aux = aux.prox;
			}
			System.out.println("IF APENAS PARA TESTE DA OPÇÃO: há elementos na lista ...");
			saida.append("\n");
			mensagemConsultarDados(scroll);
		}
		return aux;
	}

	private static void mensagemConsultarDados(JScrollPane scroll) {
		JOptionPane.showMessageDialog(null, scroll, "CONSULTAR DADOS DO ATENDIMENTO",
				JOptionPane.CLOSED_OPTION);
	}

	private static void agenteDeErro(NumberFormatException e) {
		JOptionPane.showMessageDialog(null,
				"ERRO AO TENTAR CONVERTER UM VALOR\nFAVOR VERIRIFICAR\nMENSAGEM ORIGINAL: " + e.getMessage(),
				"AGENTE DE ERRO", JOptionPane.CLOSED_OPTION);
	}

	private static void atendimentoVazio() {
		JOptionPane.showMessageDialog(null, "NÃO HÁ ATENDIMENTOS", "MENSAGEM DO PROGRAMA", JOptionPane.CLOSED_OPTION);
	}

	private static int mostrarMenu() {
		String texto = "\nMENU DE OPÇÕES\n" + "\n1  - Recepcionar cliente"
				+ "\n2  - Consultar clientes a serem atendidos" + "\n3  - Atender cliente"
				+ "\n4  - Liberar todos os clientes" + "\n5  - Verificar quantidade de clientes a atender"
				+ "\n6  - Localizar cliente por número" + "\n7  - Localizar cliente por nome"
				+ "\n8  - Emitir relatório de clientes" + "\n9  - Ver relatório de clientes"
				+ "\n10 - Filtrar clientes por valor" + "\n11 - Ver endereços hash" + "\n12 - Sobre" + "\n13 - Sair\n";
		return Integer.parseInt(JOptionPane.showInputDialog(texto, "1"));
	}

}
