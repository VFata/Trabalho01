/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bd.MockProduto;
import model.Produto;

/**
 *
 * @author Igor
 */
public class ControleProduto {

    public static void criarNovo(Produto produto) throws Exception {
        //VALIDADOR

        MockProduto.inserir(produto);
    }

    public static void atualizarProduto(Produto produto) throws Exception {
        //VALIDADOR

        MockProduto.atualizar(produto);
    }

    public static void excluir(Produto produto) throws Exception {
        //VALIDADOR

        MockProduto.excluir(produto.getId());
    }

}
