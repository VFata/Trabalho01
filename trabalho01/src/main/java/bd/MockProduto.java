/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import model.Produto;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author diego
 */
public class MockProduto {
    private static int totalProdutos = 0;
    private static List<Produto> listaProdutos = new ArrayList<>();
    
    //Insere um produto no mock "produto"
    public static void inserir(Produto produto) throws Exception {
        produto.setId(++totalProdutos);
        produto.setDataCriacao(new GregorianCalendar());
        listaProdutos.add(produto);
    }

    //Realiza a atualização dos dados de um produto, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "Produto"
    public static void atualizar(Produto produtoBusca) throws Exception {
        if (produtoBusca != null && produtoBusca.getId() != null && !listaProdutos.isEmpty()) {
            for (Produto produto : listaProdutos) {
                if (produto != null && produto.getId().equals(produtoBusca.getId())) {
                    produto = produtoBusca;
                    break;
                }
            }
        }
    }

    //Realiza a exclusão de um produto no mock, com ID fornecido
    //como parâmetro.
    public static void excluir(Integer id) throws Exception {
        if (id != null && !listaProdutos.isEmpty()) {
            for (int i = 0; i < listaProdutos.size(); i++) {
                Produto produto = listaProdutos.get(i);
                if (produto != null && produto.getId().equals(id)) {
                    listaProdutos.remove(i);
                    break;
                }
            }
        }
    }

    //Lista todos os produtos
    public static List<Produto> listar() throws Exception {
        return listaProdutos.stream()
            .collect(Collectors.toList());
    }

    //Procura um produto no mock, de acordo com o nome
    //ou com o sobrenome, passado como parâmetro
    public static List<Produto> procurar(String valor)
            throws Exception {
        List<Produto> listaResultado = new ArrayList<>();
        
        if (valor != null && !listaProdutos.isEmpty()) {
            listaResultado = listaProdutos.stream()
                    .filter((Produto p) -> p.getNome() != null && p.getNome().toLowerCase().contains(valor.toLowerCase()))
                    .collect(Collectors.toList());
            
        }
        //Retorna a lista de produtos encontrados
        return listaResultado;
    }

    //Obtém um produto da lista
    public static Produto obter(Integer id) throws Exception {
        if (id != null && !listaProdutos.isEmpty()) {
            return listaProdutos.stream()
                    .filter((Produto p) -> p.getId().equals(id))
                    .findFirst()
                    .get();
        }
        return null;
    }
}
