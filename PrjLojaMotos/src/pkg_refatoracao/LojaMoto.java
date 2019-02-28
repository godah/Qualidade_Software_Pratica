package pkg_refatoracao;

import javax.swing.JOptionPane;

public class LojaMoto {
	public static void main(String... argvs) {
		while (true) {
			try {
				String nome = JOptionPane.showInputDialog("Informe a marca (acione [CANCELAR] para sair):");
				Moto moto = fabricaMoto(nome);
				mostrarDadosMoto(moto);
			} catch (Exception e) {
				break;
			}
		}// while
		System.out.println("\nPROGRAMA FINALIZADO\n");
	}// main

	private static Moto fabricaMoto(String nome) {
		if (nome.equalsIgnoreCase("Honda")) {
			//Moto moto = new Honda();
			//mostrarDadosMoto(moto);
			return new Honda();
		}else if(nome.equalsIgnoreCase("Yamaha")) {
			//Moto moto = new Yamaha();
			//mostrarDadosMoto(moto);
			return new Yamaha();
		}else if(nome.equalsIgnoreCase("Suzuki")) {
			//Moto moto = new Suzuki();
			//mostrarDadosMoto(moto);
			return new Suzuki();
		}else {
			JOptionPane.showMessageDialog(null,
					"Somente dispon�veis na loja: Honda, Yamaha e Suzuki",
					"Messagem do programa",
					JOptionPane.CLOSED_OPTION);
			return null;
		}// if
	}

	private static void mostrarDadosMoto(Moto moto) {
		if(moto != null) {
			JOptionPane.showMessageDialog(null, 
					"\nNome: "+moto.nome+
					"\nCilindrada: "+moto.cilindrada+
					"\nCor: "+moto.cor, "Dados da moto",
					JOptionPane.CLOSED_OPTION);
		}
	}
}// class

/**

QUEST�ES (PR�TICA):
(1) H� algum problema na defini��o das classes: Honda, Yamaha e Suzuki? Caso verdade, descreva (apenas
descreva, n�o implemente) uma solu��o para o mesmo.

Resposta: As classes Honda, Yamaha e Suzuki possuem os mesmos campos com altera��o somente no construtor, 
deveria haver uma superclasse (Moto.class por exemplo) de forma que seja poss�vel a ado��o do uso de polimorfismo.

(8) Definir refatora��o.
Refatora��o � a pr�tica de revisar e modificar um c�digo pronto com a finalidade de torn�lo mais coeso e limpo 
visando assim obter uma melhor legibilidade e manutenibilidade do mesmo. � importante citar que a pr�tica da 
refatora��o n�o visa o desempenho final da execu��o do programa podendo assim as vezes obter perdas.


*/