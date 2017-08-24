package controller;

import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class validarEditarProduto {

    public static boolean validarEditarProduto(int id, String nome, String descricao,
            double precoVenda, double precoCompra, int categoria, String imagem, GregorianCalendar dataCriacao) {

        if (id >= 0) {
            JOptionPane.showMessageDialog(null, "Entre em contato com o suporte responsável");
        }
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
        if (dataCriacao.equals(null)){
            JOptionPane.showMessageDialog(null, "Entre em contato com o suporte responsável");
        }
        return true;

    }
}
