/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bd.MockProduto;
import java.util.List;
import model.Produto;

/**
 *
 * @author Igor
 */
public class ControleProduto {

    public static void criarNovo(Produto produto) throws Exception {
        String erro = validarNovoProduto.validarNovoProduto(produto);
        if (erro == null) {
            MockProduto.inserir(produto);
        } else {
            throw new Exception(erro);
            // JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void atualizarProduto(Produto produto) throws Exception {
        String erro = validarEditarProduto.validarEditarProduto(produto);
        if (erro == null) {
            MockProduto.atualizar(produto);
        } else {
            throw new Exception(erro);
            // JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void excluir(int id) throws Exception {
        MockProduto.excluir(id);
    }

    public static List<Produto> listar(String nomeProduto) throws Exception {
        if (nomeProduto == null || nomeProduto.isEmpty()) {
            return MockProduto.listar();
        } else {
            return MockProduto.procurar(nomeProduto);
        }
    }

    public static Produto obterProduto(Integer id) throws Exception {
        return MockProduto.obter(id);
    }
}
