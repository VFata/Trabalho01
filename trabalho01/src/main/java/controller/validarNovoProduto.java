package controller;

// import javax.swing.JOptionPane;
import model.Produto;

public class validarNovoProduto {

    public static String validarNovoProduto(Produto produto) {
        boolean valido = true;
        String mensagemDeErro = "Erro(s):\n";
        
        if (produto.getNome() == null || produto.getNome().equals("")) {
            mensagemDeErro += "Favor inserir um nome.\n";
            // JOptionPane.showMessageDialog(null, "Favor inserir um nome");
            valido = false;
        }
        if (produto.getDescricao() == null || produto.getDescricao().equals("")) {
            mensagemDeErro += "Favor inserir uma descrição.\n";
            // JOptionPane.showMessageDialog(null, "Favor inserir uma descrição");
            valido = false;
        }
        if (produto.getPrecoVenda() <= 0) {
            mensagemDeErro += "Favor inserir um preço de venda.\n";
            // JOptionPane.showMessageDialog(null, "Favor inserir um preço de venda");
            valido = false;
        }
        if (produto.getPrecoCompra() <= 0) {
            mensagemDeErro += "Favor inserir um preço de compra.\n";
            // JOptionPane.showMessageDialog(null, "Favor inserir um preço de compra");
            valido = false;
        }
        if (produto.getCategoria() < 0 || produto.getCategoria() >= Produto.CATEGORIAS.length) {
            mensagemDeErro += "Favor inserir uma categoria.\n";
            // JOptionPane.showMessageDialog(null, "Favor inserir uma categoria");
            valido = false;
        }
        if (produto.getImagem() == null || produto.getImagem().equals("")) {
            mensagemDeErro += "Favor inserir uma imagem.";
            // JOptionPane.showMessageDialog(null, "Favor inserir uma imagem");
            valido = false;
        }
        
        if (valido) {
            return null;
        } else {
            return mensagemDeErro;
        }
    }
}
