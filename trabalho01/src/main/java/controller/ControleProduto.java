/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author Igor
 */
public class ControleProduto {
    
    public ArrayList <Object> produtos = new ArrayList<>();
    
    public void criarNovo (Produto produto) {
        // validar novo
        produtos.add(produto);
    }
    
    public void deletar (int index) {
        produtos.remove(index);
    }
    
    public void modificar (Produto produto, int index) {
        // validar alteracao
        produtos.set(index, produto);        
    }
    
    public Object listarTodos () {
        return produtos;
    }        
            
    public  Object buscar(int index) {
        // busca por nome
        return produtos.get(index);
    }            
}
