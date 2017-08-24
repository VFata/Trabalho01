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
        validarNovoProduto.validarNovoProduto(produto);
        MockProduto.inserir(produto);
    }

    public static void atualizarProduto(Produto produto) throws Exception {
        validarEditarProduto.validarEditarProduto(produto);
        MockProduto.atualizar(produto);
    }

    public static void excluir(Produto produto) throws Exception {
        validarNovoProduto.validarNovoProduto(produto);

        MockProduto.excluir(produto.getId());
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
