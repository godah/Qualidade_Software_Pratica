package pkgRefatoracaoParte1;

import java.util.Calendar;
import java.util.*;

public class Refatoracao {
	private static final int QUANTIDADE = 3;
	static Calendar calendario;
	static Scanner entrada;

	public static void main(String[] args) {
		double mensalidade = 0;
		double novaMensalidade = 0;
		int mes = 0;
		int mesAtual = 0;
		entrada = new Scanner(System.in);
		int contador = 1;
		while (contador <= QUANTIDADE) {
			System.out.println("\nValor da mensalidade: ");
			mensalidade = entrada.nextInt();
			System.out.println("\nMês de referência: ");
			mes = entrada.nextInt();
			calendario = Calendar.getInstance();
			mesAtual = calendario.get(Calendar.MONTH) + 1;
			novaMensalidade = verificarValor(mensalidade, novaMensalidade, mes, mesAtual);
			imprimirResultados(mensalidade, novaMensalidade, mes, mesAtual);
			contador++;
		} // while
		System.out.println("PROGRAMA FINALIZADO!");
	}// main

	private static void imprimirResultados(double mensalidade, double novaMensalidade, int mes, int mesAtual) {
		System.out.println("RESULTADO");
		System.out.println("Mês atual: " + mesAtual);
		System.out.println("Referencia: " + mes);
		System.out.println("Mensalidade: " + mensalidade);
		System.out.println("Novo valor: " + novaMensalidade);
	}

	private static double verificarValor(double mensalidade, double novaMensalidade, int mes, int mesAtual) {
		if (mes < mesAtual) {
			double valorCalculadoMensalidade = mensalidade * 1.10;
			novaMensalidade = valorCalculadoMensalidade;
		} else if (mes >= mesAtual)
			novaMensalidade = mensalidade;
		return novaMensalidade;
	}
}
