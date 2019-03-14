package pkg_refatoracao;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Voo {
	public String dadosVoo;
	static int voo[] = new int[3];
	static String origem[] = new String[3];
	static String destino[] = new String[3];
	static int lugares[] =new int[3];
	
	public Voo() {
		voo[0] = 1;
		origem[0] = "BHTE";
		destino[0] = "SÃO PAULO";
		lugares[0] = 20;
		dadosVoo = dadosVoo + "\n" + voo[0] + "\t" + origem[0] + "\t" + destino[0] + "\t" + lugares[0];
		voo[1] = 2;
		origem[1] = "SÃO PAULO";
		destino[1] = "CURITIBA";
		lugares[1] = 25;
		dadosVoo = dadosVoo + "\n" + voo[1] + "\t" + origem[1] + "\t" + destino[1] + "\t" + lugares[1];
		voo[2] = 3;
		origem[2] = "CURITIBA";
		destino[2] = "JOINVILLE";
		lugares[2] = 15;
		dadosVoo = dadosVoo + "\n" + voo[2] + "\t" + origem[2] + "\t" + destino[2] + "\t" + lugares[2];
	}
	
	public String ListarDadosVoo() {
		return dadosVoo;
	}
	
	public Boolean verOrigemVoo(String args) {
		for(int i = 0; i <= 2; i++) {
			if (origem[i].equalsIgnoreCase(args))
				return true;
		}
		return false;
	}
	
	public Boolean verDestinoVoo(String args) {
		for(int i = 0; i <= 2; i++) {
			if (destino[i].equalsIgnoreCase(args))
				return true;
		}
		return false;
	}
	
	public void listagemGeralVoo() {
			JTextArea saida = new JTextArea(10, 40);
			saida.setText("Nro\tOrigem\tDestino\tPassageiros");
			saida.append(dadosVoo);
			JScrollPane scroll = new JScrollPane(saida);
			JOptionPane.showMessageDialog(null, scroll, "Dados dos vôos: ", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarDadosVoo(Voo objVoo, int i) {
		String resultado = "Vôo: " + voo[i] + "\n" + "Origem: "
				+ origem[i] + "\n" + "Destino: " + destino[i]
				+ "\n" + "Lugares: " + lugares[i];
		JOptionPane.showMessageDialog(null, resultado);
	}
	
}
