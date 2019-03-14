package pkg_refatoracao;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReservaPassagemAerea {
	static int opcao, opMenuGeral, opMenuConsulta;
	static String sopcao;

	public static void main(String[] args) {
		int resposta = JOptionPane.showConfirmDialog(null, "Deseja verificar dados?", "Confirmação do programa",
				JOptionPane.YES_NO_OPTION);
		if (resposta == JOptionPane.YES_OPTION) {
			Voo objVooListagem = new Voo();
			objVooListagem.listagemGeralVoo();
		}
		while (true) {
			try {
				mostrarMenuGeral();
				if (opMenuGeral == 1) {
					while (true) {
						Voo objVoo = new Voo();
						try {
							mostrarMenuConsulta();
							if (opMenuConsulta == 1) {
								opcao = Integer.parseInt(JOptionPane.showInputDialog(
										"CONSULTAR VÔO POR NÚMERO DO VÔO\n\n" + "Informe o número do vôo"));
								if (opcao < 1 || opcao > 3) {
									JOptionPane.showMessageDialog(null, "Número do vôo Inexistente");
								} else {
									for (int i = 0; i <= 2; i++) {
										if (objVoo.voo[i] == (opcao)) {
											objVoo.mostrarDadosVoo(objVoo, i);
										}
									}
								}
							}
							if (opMenuConsulta == 2) {
								sopcao = JOptionPane.showInputDialog("CONSULTAR VÔO POR ORIGEM DO VÔO\n\n" + "Informe a origem");
								Boolean verOrigem = true;
								verOrigem = objVoo.verOrigemVoo(sopcao);
								if (verOrigem == false) {
									JOptionPane.showMessageDialog(null, "Origem não cadastrada no programa. Verifique",
											"Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
								} else {
									for (int i = 0; i <= 2; i++) {
										if (objVoo.origem[i].equalsIgnoreCase(sopcao)) {
											objVoo.mostrarDadosVoo(objVoo, i);
										}
									}
								}
							}
							if (opMenuConsulta == 3) {
								sopcao = JOptionPane.showInputDialog("CONSULTAR VÔO POR DESTINO DO VÔO\n\n" + "Informe a origem");
								Boolean verDestino = true;
								verDestino = objVoo.verDestinoVoo(sopcao);
								if (verDestino == false) {
									JOptionPane.showMessageDialog(null, "Origem não cadastrada no programa. Verifique",
											"Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
								} else {
									for (int i = 0; i <= 2; i++) {
										if (objVoo.destino[i].equalsIgnoreCase(sopcao)) {
											objVoo.mostrarDadosVoo(objVoo, i);
										}
									}
								}
							}
							if (opMenuConsulta == 4) {
								objVoo.ListarDadosVoo();
							}
							if (opMenuConsulta == 5) {
								break;
							}
						} catch (Exception e) {
							mensagemCancelarErro();
							break;
						}
					}
				}
				if (opMenuGeral == 2) {
					JOptionPane.showMessageDialog(null, "OPÇÃO 2 - RESERVA \nOpção em desenvolvimento ...");
				}
				if (opMenuGeral == 3) {
					break;
				}
			} catch (Exception e) {
				mensagemCancelarErro();
				break;
			}
		}
		System.out.println("\n\nPROGRAMA FINALIZADO!");
	}

	private static void mensagemCancelarErro() {
		JOptionPane.showMessageDialog(null,"\nTecla cancelar foi acionada\nou um erro inesperado ocorreu. \nO programa será finalizado");
	}

	private static void mostrarMenuConsulta() {
		opMenuConsulta = Integer.parseInt(JOptionPane.showInputDialog("CONSULTAR VÔOS \n\n"
				+ "1 - Por  número  do  vôo\n"
				+ "2 - Por  Origem\n"
				+ "3 - Por Destino\n"
				+ "4 - Consulta Geral\n"
				+ "5 - Voltar\n\n"));
	}

	private static void mostrarMenuGeral() {
		opMenuGeral = Integer.parseInt(
				JOptionPane.showInputDialog("OPÇÕES\n\n" + ""
						+ "1 - Consulta\n"
						+ "2 - Reservar\n"
						+ "3 - Finalizar\n\n"));
	}

}
