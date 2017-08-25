/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.GregorianCalendar;

public class Produto {
    public static final String[] CATEGORIAS = {"sem categoria", "categoria 1"};
    
    private Integer id; 
    private String nome;
    private String descricao;
    private double precoVenda;
    private double precoCompra;
    private int categoria;
    private String imagem;
    private GregorianCalendar dataCriacao;

    public Produto() {
        this.id = -1;
    }
    
    public Produto(String nome, String descricao, double precoVenda, 
            double precoCompra, int categoria, String imagem) {
        this.id = -1;
        this.nome = nome;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.precoCompra = precoCompra;
        this.categoria = categoria;
        this.imagem = imagem;
    }
    
    public Produto(Integer id, String nome, String descricao, double precoVenda,
            double precoCompra, int categoria, String imagem, 
            GregorianCalendar dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.precoCompra = precoCompra;
        this.categoria = categoria;
        this.imagem = imagem;
        this.dataCriacao = dataCriacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public GregorianCalendar getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(GregorianCalendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + '}';
    }
}
