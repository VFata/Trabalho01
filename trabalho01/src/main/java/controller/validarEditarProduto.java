package controller;

import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class validarEditarProduto {

    public static boolean validarEditarProduto(int id, String nome, String descricao,
            double precoVenda, double precoCompra, int categoria, String imagem, GregorianCalendar dataCriacao) {

        if (id >= 0) {
            JOptionPane.showMessageDialog(null, "Entre em contato com o suporte responsável");
            return false;
        }
        if (nome.equals(null) || nome.equals(" ")) {
            JOptionPane.showMessageDialog(null, "Favor inserir um nome");
            return false;
        }
        if (descricao.equals(null) || descricao.equals(" ")) {
            JOptionPane.showMessageDialog(null, "Favor inserir uma descrição");
            return false;
        }
        if (precoVenda == 0) {
            JOptionPane.showMessageDialog(null, "Favor inserir um preço de venda");
            return false;
        }
        if (precoCompra == 0) {
            JOptionPane.showMessageDialog(null, "Favor inserir um preço de compra");
            return false;
        }
        if (categoria == 0) {
            JOptionPane.showMessageDialog(null, "Favor inserir uma categoria");
            return false;
        }
        if (imagem.equals(null) || imagem.equals(" ")) {
            JOptionPane.showMessageDialog(null, "Favor inserir uma imagem");
            return false;
        }
        if (dataCriacao.equals(null)){
            JOptionPane.showMessageDialog(null, "Entre em contato com o suporte responsável");
            return false;
        }
        return true;

    }
}
