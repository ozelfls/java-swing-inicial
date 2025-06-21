package app;

import model.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<Veiculo> veiculos = new ArrayList<>();

    public static void main(String[] args) {
        String[] opcoesMenu = {"Cadastrar novo veículo", "Listar veículos", "Excluir veículo", "Sair"};
        int opcao;

        do {
            opcao = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção:",
                    "Sistema de Cadastro de Veículos",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoesMenu,
                    opcoesMenu[0]
            );

            switch (opcao) {
                case 0 -> cadastrarVeiculo();
                case 1 -> listarVeiculos();
                case 2 -> excluirVeiculo();
                case 3 -> JOptionPane.showMessageDialog(null, "Encerrando...");
                default -> {} // Ignora quando o usuário fecha a janela
            }
        } while (opcao != 3 && opcao != JOptionPane.CLOSED_OPTION);
    }

    private static void cadastrarVeiculo() {
        String[] tipos = {"Carro", "Moto", "Caminhão"};
        int tipo = JOptionPane.showOptionDialog(
                null,
                "Escolha o tipo de veículo:",
                "Tipo de Veículo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipos,
                tipos[0]
        );

        if (tipo == JOptionPane.CLOSED_OPTION) return;

        String modelo = JOptionPane.showInputDialog("Modelo:");
        String placa = JOptionPane.showInputDialog("Placa:");
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano:"));

        switch (tipo) {
            case 0 -> {
                int portas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de portas:"));
                veiculos.add(new Carro(placa, modelo, ano, portas));
            }
            case 1 -> {
                int cilindrada = Integer.parseInt(JOptionPane.showInputDialog("Cilindrada:"));
                veiculos.add(new Moto(placa, modelo, ano, cilindrada));
            }
            case 2 -> {
                double carga = Double.parseDouble(JOptionPane.showInputDialog("Capacidade de carga (toneladas):"));
                veiculos.add(new Caminhao(placa, modelo, ano, carga));
            }
        }

        JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!");
    }

    private static void listarVeiculos() {
        if (veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo cadastrado.");
            return;
        }

        StringBuilder lista = new StringBuilder("==== Lista de Veículos ====\n\n");
        int index = 1;
        for (Veiculo v : veiculos) {
            lista.append(index).append(" - ").append(v.toString()).append("\n\n");
            index++;
        }

        JTextArea textArea = new JTextArea(lista.toString());
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));

        JOptionPane.showMessageDialog(null, scrollPane, "Lista de Veículos", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void excluirVeiculo() {
        if (veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo para excluir.");
            return;
        }

        StringBuilder lista = new StringBuilder("Escolha o número do veículo para excluir:\n\n");
        int index = 1;
        for (Veiculo v : veiculos) {
            lista.append(index).append(" - ").append(v.toString()).append("\n\n");
            index++;
        }

        JTextArea textArea = new JTextArea(lista.toString());
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));

        JOptionPane.showMessageDialog(null, scrollPane, "Veículos Cadastrados", JOptionPane.INFORMATION_MESSAGE);

        String input = JOptionPane.showInputDialog("Digite o número do veículo que deseja excluir:");
        if (input == null) return;  // Caso o usuário cancele

        try {
            int escolha = Integer.parseInt(input);
            if (escolha >= 1 && escolha <= veiculos.size()) {
                Veiculo removido = veiculos.remove(escolha - 1);
                JOptionPane.showMessageDialog(null, "Veículo removido:\n" + removido.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Número inválido!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida! Digite um número válido.");
        }
    }
}
