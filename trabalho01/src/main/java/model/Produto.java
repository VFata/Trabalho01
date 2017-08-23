/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tron
 */
public class Produto {
    
    private Integer id; 
    private String nome;
    private String descricao;
    private double precovenda;
    private double precocompra;

    public Produto(Integer id, String nome, String descricao, double precovenda, double precocompra) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precovenda = precovenda;
        this.precocompra = precocompra;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecovenda() {
        return precovenda;
    }

    public double getPrecocompra() {
        return precocompra;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrecovenda(double precovenda) {
        this.precovenda = precovenda;
    }

    public void setPrecocompra(double precocompra) {
        this.precocompra = precocompra;
    }
    
    
    
    
    
}
