package com.qualidade.metrica;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestePilha {
	private static class Pilha {
		public Pilha(Pilha topo, int numero2) {
			numero = numero2;
			valor = Double.parseDouble(JOptionPane.showInputDialog("VALOR DA CHAPA", "0"));
			pedido = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DO PEDIDO", "0"));
			prox = topo;
		}
		public int numero;
		public double valor;
		public int pedido;
		public Pilha prox;
	}

	public static void main(String[] args) {
		Pilha topo = null;
		int op = 0;
		do {
			try {
				op = Integer.parseInt(JOptionPane.showInputDialog(opcoesMenu(), "1"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			if (op < 1 || op > 8) {
				mensagem("Opção Inválida!");
			}
			if (op == 1) {
				topo = inserirEmpilharChapas(topo);
			}
			if (op == 2) {
				consultarChapasCadastradas(topo);
			}
			if (op == 3) {
				topo = desempilharChapas(topo);
			}
			if (op == 4) {
				topo = esvaziarPatio(topo);
			}
			if (op == 5) {
				quantidadeEChapas(topo);
			}
			if (op == 6) {
				filtrarChapasCadastradas(topo);
			}
		} while (op != 7);
		System.out.println(">>> PROGRAMA FINALIZADO!");
	}

	private static Pilha inserirEmpilharChapas(Pilha topo) {
		Pilha aux;
		int numero = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DA CHAPA", "0"));
		aux = topo;
		if (!verificaSeChapaExiste(aux, numero)) {
			topo = new Pilha(aux, numero);
		}
		return topo;
	}

	private static boolean verificaSeChapaExiste(Pilha aux, int numero) {
		boolean achou = false;
		while (aux != null) {
			if (aux.numero == numero) {
				achou = true;
				mensagem("Esse número de chapa já foi empilhado.\nFavor verificar!");
				break;
			}
			aux = aux.prox;
		}
		return achou;
	}

	private static void consultarChapasCadastradas(Pilha topo) {
		Pilha aux;
		if (topo == null) {
			mensagem("A PILHA está vazia!");
		} else {
			JTextArea saida = new JTextArea(6, 35); // HEIGHT X WIDTH
			JScrollPane scroll = new JScrollPane(saida);
			saida.append("NÚMERO\t" + "VALOR\t" + "PEDIDO\n");
			saida.append("===============================\n");
			aux = topo;
			while (aux != null) {
				verificaEnderEProx(aux);
				saida.append(aux.numero + "\t" + aux.valor + "\t" + aux.pedido + "\n");
				aux = aux.prox;
			}
			mensagemConsChapasCad(scroll);
		}
	}

	private static void verificaEnderEProx(Pilha aux) {
		if (aux.prox != null) {
			System.out.println("Num: " + aux.numero + ", endereço: " + aux.hashCode() + " => "
					+ " Prox => " + aux.prox.hashCode() + "\n");
		}
	}

	private static Pilha desempilharChapas(Pilha topo) {
		if (topo == null) {
			mensagem("A PILHA está vazia!");
		} else {
			mensagem("Número: " + topo.numero + ", foi removido.");
			topo = topo.prox;
		}
		return topo;
	}

	private static void filtrarChapasCadastradas(Pilha topo) {
		if (topo == null) {
			mensagem("A PILHA está vazia!");
		} else {
			int npedido = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DO PEDIDO", "0"));
			JTextArea saida = new JTextArea(6, 35);
			JScrollPane scroll = new JScrollPane(saida);
			adicionaLinhas(topo, npedido, saida);
			mensagemConsChapasCad(scroll);
		}
	}

	private static void adicionaLinhas(Pilha topo, int npedido, JTextArea saida) {
		Pilha aux;
		saida.append("FILTRO, CHAPAS PARA O PEDIDO NRO: " + npedido + "\n");
		saida.append("NÚMERO\t" + "VALOR\t" + "PEDIDO\n");
		saida.append("================================\n");
		aux = topo;
		while (aux != null) {
			if (aux.pedido == npedido) {
				saida.append(aux.numero + "\t" + aux.valor + "\t" + aux.pedido + "\n");
			}
			aux = aux.prox;
		}
	}

	private static void mensagemConsChapasCad(JScrollPane scroll) {
		JOptionPane.showMessageDialog(null, scroll, "CONSULTAR CHAPAS CADASTRADAS",
				JOptionPane.INFORMATION_MESSAGE);
	}

	private static void quantidadeEChapas(Pilha topo) {
		Pilha aux;
		aux = topo;
		int n = 0;
		while (aux != null) {
			aux = aux.prox;
			n++;
		}
		mensagem("A Pilha contém: " + n + " elementos.");
	}

	private static Pilha esvaziarPatio(Pilha topo) {
		if (topo == null) {
			mensagem("A Pilha está vazia!");
		} else {
			topo = null;
			mensagem("A Pilha foi esvaziada!");
		}
		return topo;
	}

	private static String opcoesMenu() {
		String menu = "\nMENU DE OPÇÕES\n" 
				+ "\n1 - Empilhar Chapas." 
				+ "\n2 - Consultar Todas as Chapas."
				+ "\n3 - Desempilhar Chapas." 
				+ "\n4 - Remover Todas as Chapas Da Pilha."
				+ "\n5 - Verificar Quantidade de Chapas." 
				+ "\n6 - Filtrar Chapas Por Pedido." 
				+ "\n7 - Sair";
		return menu;
	}

	private static void mensagem(String a) {
		JOptionPane.showMessageDialog(null, a, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
	}
}