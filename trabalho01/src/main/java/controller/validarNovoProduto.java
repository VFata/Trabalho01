package controller;

import javax.swing.JOptionPane;

public class validarNovoProduto {

    public static boolean validarNovoProduto(String nome, String descricao,
            double precoVenda, double precoCompra, int categoria, String imagem) {

        if (nome.equals(null) || nome.equals(" ")) {
            JOptionPane.showMessageDialog(null, "Favor inserir um nome");
        }
        if (descricao.equals(null) || descricao.equals(" ")) {
            JOptionPane.showMessageDialog(null, "Favor inserir uma descrição");
        }
        if (precoVenda == 0) {
            JOptionPane.showMessageDialog(null, "Favor inserir um preço de venda");
        }
        if (precoCompra == 0) {
            JOptionPane.showMessageDialog(null, "Favor inserir um preço de compra");
        }
        if (categoria == 0) {
            JOptionPane.showMessageDialog(null, "Favor inserir uma categoria");
        }
        if (imagem.equals(null) || imagem.equals(" ")) {
            JOptionPane.showMessageDialog(null, "Favor inserir uma imagem");

        }
        return true;

    }
}
