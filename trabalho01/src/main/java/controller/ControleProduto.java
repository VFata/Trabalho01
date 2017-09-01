/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Produto;
import bd.DAOProduto;
import java.io.File;

/**
 *
 * @author Igor
 */
public class ControleProduto {

    public static void criarNovo(Produto produto) throws Exception {
        String erro = ValidarProduto.validarNovoProduto(produto);
        if (erro == null) {
            DAOProduto.inserir(produto);      
        } else {
            throw new Exception(erro);
            // JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void atualizarProduto(Produto produto) throws Exception {
        String erro = ValidarProduto.validarEditarProduto(produto);
        if (erro == null) {
            DAOProduto.atualizar(produto);
        } else {
            throw new Exception(erro);
            // JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void excluir(int id) throws Exception {
        String imgPath = obterProduto(id).getImagem();
        DAOProduto.excluir(id);
        (new File(imgPath)).delete();
    }

    public static List<Produto> listar(String nomeProduto) throws Exception {
        if (nomeProduto == null || nomeProduto.isEmpty()) {
            return DAOProduto.listar();
        } else {
            return DAOProduto.procurar(nomeProduto);
        }
    }

    public static Produto obterProduto(Integer id) throws Exception {
        return DAOProduto.obter(id);
    }
}
