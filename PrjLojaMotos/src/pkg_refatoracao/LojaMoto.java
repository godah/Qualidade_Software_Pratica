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
					"Somente disponíveis na loja: Honda, Yamaha e Suzuki",
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

QUESTÕES (PRÁTICA):
(1) Há algum problema na definição das classes: Honda, Yamaha e Suzuki? Caso verdade, descreva (apenas
descreva, não implemente) uma solução para o mesmo.

Resposta: As classes Honda, Yamaha e Suzuki possuem os mesmos campos com alteração somente no construtor, 
deveria haver uma superclasse (Moto.class por exemplo) de forma que seja possível a adoção do uso de polimorfismo.

(8) Definir refatoração.
Refatoração é a prática de revisar e modificar um código pronto com a finalidade de tornálo mais coeso e limpo 
visando assim obter uma melhor legibilidade e manutenibilidade do mesmo. É importante citar que a prática da 
refatoração não visa o desempenho final da execução do programa podendo assim as vezes obter perdas.


*/