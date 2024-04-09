import javax.swing.*;
import java.text.Format;

public class Main {
    public static void main(String[] args) {

        double openingBalance = 2500;
        boolean exit = false;


        do{
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, String.format(
                    "                    *******************************************************\n" +
                    "                                          Dados do Cliente:\n" +
                    "                    \n" +
                    "                    Nome:                           Daniel Soares de Queiroz\n" +
                    "                    Tipo da Conta:            Corrente\n" +
                    "                    Saldo Inicial:               R$%.2f\n" +
                    "                    \n" +
                    "                    *******************************************************\n" +
                    "                    \n" +
                    "                    Operações\n" +
                    "                    \n" +
                    "                    1 - Consultar Saldo\n" +
                    "                    2 - Depositar Valor\n" +
                    "                    3 - Transferir Valor\n" +
                    "                    4 - Sair\n" +
                    "                    \n" +
                    "                    Digite a Opção Desejada", openingBalance)));

            switch (opcao){
                case 1:
                    JOptionPane.showMessageDialog(null, String.format("Seu Saldo é R$%.2f", openingBalance));
                    break;
                case 2:
                    double depositAmount = Double.parseDouble(JOptionPane.showInputDialog("Digite o Valor a Ser Depositado"));
                    openingBalance += depositAmount;
                    JOptionPane.showMessageDialog(null, String.format("""
                            Depósito Realizado com Sucesso!!
                            
                            Saldo Atualizado de R$%.2f""", openingBalance));
                    break;
                case 3:
                    double amountTransfer = Double.parseDouble(JOptionPane.showInputDialog("Digite o Valor que Deseja Transferir"));
                    if (amountTransfer > openingBalance) {
                        JOptionPane.showMessageDialog(null, String.format("""
                                Saldo Insuficiente para Transferências
                                
                                Seu saldo é R$%.2f""", openingBalance));
                    } else {
                        openingBalance -= amountTransfer;
                        JOptionPane.showMessageDialog(null, String.format("""
                                Transferência Realizada com Sucesso!
                                
                                Saldo Atualizado de R$%.2f""", openingBalance));
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");

            }

        } while (!exit);

    }
}