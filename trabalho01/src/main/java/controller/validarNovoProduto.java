package controller;

import javax.swing.JOptionPane;
import model.Produto;

public class validarNovoProduto {

    public static boolean validarNovoProduto(Produto produto) {

        if (produto.getNome() == null || produto.getNome().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Favor inserir um nome");
        }
        if (produto.getDescricao() == null || produto.getDescricao().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Favor inserir uma descrição");
        }
        if (produto.getPrecoVenda() == 0) {
            JOptionPane.showMessageDialog(null, "Favor inserir um preço de venda");
        }
        if (produto.getPrecoCompra() == 0) {
            JOptionPane.showMessageDialog(null, "Favor inserir um preço de compra");
        }
        if (produto.getCategoria() == 0) {
            JOptionPane.showMessageDialog(null, "Favor inserir uma categoria");
        }
        if (produto.getImagem() == null || produto.getImagem().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Favor inserir uma imagem");
        }
        return true;

    }
}
