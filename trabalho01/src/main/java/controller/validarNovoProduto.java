package controller;

import javax.swing.JOptionPane;
import model.Produto;

public class validarNovoProduto {

    public static boolean validarNovoProduto(Produto produto) {        
        if (produto.getNome() == null || produto.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor inserir um nome");
            return false;
        }
        if (produto.getDescricao() == null || produto.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor inserir uma descrição");
            return false;
        }
        if (produto.getPrecoVenda() <= 0) {
            JOptionPane.showMessageDialog(null, "Favor inserir um preço de venda");
            return false;
        }
        if (produto.getPrecoCompra() <= 0) {
            JOptionPane.showMessageDialog(null, "Favor inserir um preço de compra");
            return false;
        }
        if (produto.getCategoria() <= 0) {
            JOptionPane.showMessageDialog(null, "Favor inserir uma categoria");
            return false;
        }
        if (produto.getImagem() == null || produto.getImagem().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor inserir uma imagem");
            return false;
        }
        return true;

    }
}
