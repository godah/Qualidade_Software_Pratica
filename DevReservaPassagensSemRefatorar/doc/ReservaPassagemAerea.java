package br.com.borba.luiz.gilmar.prof;
import javax.swing.*;
public class ReservaPassagemAerea {
static int opcao, opcao1, opcao2;
static String sopcao;
static int voo[];
static String origem[];
static String destino[];
static int lugares[];
static String dadosDeEntradaDosVoosCadastradosNoPrograma = "";
public static void main(String[] args) {
    // Cria os vetores (NÃO CONSIDERE ESSA PARTE DO CÓDIGO)
    voo = new int[3];
    origem = new String[3];
    destino = new String[3];
    lugares = new int[3];
    // Carrega vetores (NÃO CONSIDERE ESSA PARTE DO CÓDIGO)
    voo[0] = 1;
    origem[0] = "BHTE";
    destino[0] = "SÃO PAULO";
    lugares[0] = 20;
    dadosDeEntradaDosVoosCadastradosNoPrograma = dadosDeEntradaDosVoosCadastradosNoPrograma + "\n" + voo[0] + "\t"
    + origem[0] + "\t" + destino[0] + "\t" + lugares[0];
    voo[1] = 2;
    origem[1] = "SÃO PAULO";
    destino[1] = "CURITIBA";
    lugares[1] = 25;
    dadosDeEntradaDosVoosCadastradosNoPrograma = dadosDeEntradaDosVoosCadastradosNoPrograma + "\n" + voo[1] + "\t"
    + origem[1] + "\t" + destino[1] + "\t" + lugares[1];
    voo[2] = 3;
    origem[2] = "CURITIBA";
    destino[2] = "JOINVILLE";
    lugares[2] = 15;
    dadosDeEntradaDosVoosCadastradosNoPrograma = dadosDeEntradaDosVoosCadastradosNoPrograma + "\n" + voo[2] + "\t"
    + origem[2] + "\t" + destino[2] + "\t" + lugares[2];
    int resposta = JOptionPane.showConfirmDialog(null, "Deseja verificar dados?", "Confirmação do programa",
    JOptionPane.YES_NO_OPTION);
    if (resposta == JOptionPane.YES_OPTION) {
    JTextArea saida = new JTextArea(10, 40);
    saida.setText("Nro\tOrigem\tDestino\tPassageiros");
    saida.append(dadosDeEntradaDosVoosCadastradosNoPrograma);
    JScrollPane scroll = new JScrollPane(saida);
    JOptionPane.showMessageDialog(null, scroll, "Dados dos vôos: ", JOptionPane.INFORMATION_MESSAGE);
    }
    // MENU GERAL
    while (true) {
    try {
    // MENU GERAL
    opcao1 = Integer.parseInt(
    JOptionPane.showInputDialog("OPÇÕES\n\n" + "1 - Consulta\n2 - Reservar\n3 - Finalizar\n\n"));
    if (opcao1 == 1) {
    // MENU CONSULTAR
    while (true) {
    try {
    // MENU CONSULTAR
    opcao2 = Integer.parseInt(JOptionPane.showInputDialog("CONSULTAR VÔOS \n\n"
    + "1 - Por  número  do  vôo\n2 - Por  Origem\n3 - Por Destino\n4 - Consulta Geral\n5 - Voltar\n\n"));
    if (opcao2 == 1) {
    opcao = Integer.parseInt(JOptionPane.showInputDialog(
    "CONSULTAR VÔO POR NÚMERO DO VÔO\n\n" + "Informe o número do vôo"));
    if (opcao < 1 || opcao > 3) {
    JOptionPane.showMessageDialog(null, "Número do vôo Inexistente");
    } else {
    for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
    if (voo[variavelFor] == (opcao)) {
    String resultado = "Vôo: " + voo[variavelFor] + "\n" + "Origem: "
    + origem[variavelFor] + "\n" + "Destino: " + destino[variavelFor]
    + "\n" + "Lugares: " + lugares[variavelFor];
    JOptionPane.showMessageDialog(null, resultado);
    } // FIM DO IF
    // Não excluir esse código -
    // verificação origem
    // Autor: Pangrácio - 12/11/2015
    // if (voo[variavelFor] ==
    // (opcao-1)) {
    // String resultado = "Vôo:
    // "+voo[variavelFor] + "\n" +
    // "Origem: "+origem[variavelFor] +
    // "\n" + "Destino:
    // "+destino[variavelFor] + "\n" +
    // "Lugares: "+lugares[variavelFor];
    // JOptionPane.showMessageDialog(null,
    // resultado);
    // } // FIM DO IF
    } // FIM DA ITERAÇÃO FOR VARIAVELFOR
    } // FIM DO ELSE
    } // FIM DA OPÇÃO 1
    if (opcao2 == 2) {
    sopcao = JOptionPane
    .showInputDialog("CONSULTAR VÔO POR ORIGEM DO VÔO\n\n" + "Informe a origem");
    Boolean verOrigem = true;
    verOrigem = verVPO(sopcao);
    if (verOrigem == false) {
    JOptionPane.showMessageDialog(null, "Origem não cadastrada no programa. Verifique",
    "Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
    } else {
    for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
    if (origem[variavelFor].equalsIgnoreCase(sopcao)) {
    String resultado = "Vôo: " + voo[variavelFor] + "\n" + "Origem: "
    + origem[variavelFor] + "\n" + "Destino: " + destino[variavelFor]
    + "\n" + "Lugares: " + lugares[variavelFor];
    JOptionPane.showMessageDialog(null, resultado);
    } // FIM DO IF
    } // FIM DA ITERAÇÃO FOR VARIAVELFOR
    } // FIM DO ELSE IF
    }
    if (opcao2 == 3) {
    sopcao = JOptionPane
    .showInputDialog("CONSULTAR VÔO POR DESTINO DO VÔO\n\n" + "Informe a origem");
    Boolean verDestino = true;
    verDestino = verVPD(sopcao);
    if (verDestino == false) {
    JOptionPane.showMessageDialog(null, "Origem não cadastrada no programa. Verifique",
    "Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
    } else {
    for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
    if (destino[variavelFor].equalsIgnoreCase(sopcao)) {
    String resultado = "Vôo: " + voo[variavelFor] + "\n" + "Origem: "
    + origem[variavelFor] + "\n" + "Destino: " + destino[variavelFor]
    + "\n" + "Lugares: " + lugares[variavelFor];
    JOptionPane.showMessageDialog(null, resultado);
    } // FIM DO IF
    } // FIM DA ITERAÇÃO FOR VARIAVELFOR
    } // FIM DO ELSE IF
    }
    if (opcao2 == 4) {
    JTextArea saida = new JTextArea(10, 40);
    saida.setText("Nro\tOrigem\tDestino\tPassageiros");
    saida.append(dadosDeEntradaDosVoosCadastradosNoPrograma);
    JScrollPane scroll = new JScrollPane(saida);
    JOptionPane.showMessageDialog(null, scroll, "Dados dos vôos: ", JOptionPane.INFORMATION_MESSAGE);
    }
    if (opcao2 == 5) {
    break;
    }
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null,
    "\nTecla cancelar foi acionada\nou um erro inesperado ocorreu. \nO programa será finalizado");
    break;
    }
    } // while Consultar
    } // fim opcao 1
    if (opcao1 == 2) {
    JOptionPane.showMessageDialog(null, "OPÇÃO 2 - RESERVA \nOpção em desenvolvimento ...");
    }
    if (opcao1 == 3) {
    break;
    }
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null,
    "\nTecla cancelar foi acionada\nou um erro inesperado ocorreu. \nO programa será finalizado");
    break;
    }
    } // while geral
    System.out.println("\n\nPROGRAMA FINALIZADO!");
    }
    // main
    // VERIFICA SE HÁ VÔO PARA A ORIGEM INFORMADA PELO USUÁRIO
    // OU SEJA: VERVPO (VERIFICA VÔO POR ORIGEM) O PARÂMETRO
    // ARGS É O NOME DA CIDADE DE ORIGEM. ENTENDEU?

    private static Boolean verVPO(String args) {
    for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
    if (origem[variavelFor].equalsIgnoreCase(sopcao)) {
    return true;
    }
    }
    return false;
    }
    // VERIFICA SE HÁ VÔO PARA O DESTINO INFORMADO PELO USUÁRIO
    // OU SEJA: VERVPD (VERIFICA VÔO POR DESTINO) O PARÂMETRO
    // ARGS É O NOME DA CIDADE DE DESTINO. ENTENDEU?

    private static Boolean verVPD(String args) {
    for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
    if (destino[variavelFor].equalsIgnoreCase(sopcao)) {
    return true;
    }
    }
    return false;
    }
} // class

