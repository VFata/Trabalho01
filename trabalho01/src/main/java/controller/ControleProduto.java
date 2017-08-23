/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author Igor
 */
public class ControleProduto {
    
    public ArrayList <Object> produtos = new ArrayList<>();
    
    public void criarNovo (Object produto) {
        produtos.add(produto);
    }
    
    public void deletar (int index){
        produtos.remove(index);
    }
    
    public void modificar (Object produto, int index){
        produtos.set(index, produto);
        
    }
    
    public Object listarTodos (){
        return produtos;
    }
    
    
    
}
