/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gabriel
 */
public class ItemVenda {

    private int id;
    private int qtde;
    private String descricao; //INSERIR NO BANCO !!!!!!!!!
    private int idProduto;
    private String nome;
    private double preco;
    private double valor;
    private String img;

    public ItemVenda(int qtde, String descricao, String nome, double preco, double valor, String img) {
        this.qtde = qtde;
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.valor = valor;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

   
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getnomeProduto() {
        return nome;
    }

    public double getpreco() {
        return preco;
    }

    public double getValor() {
        valor = preco * qtde;
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    

    public void setId(int novo) {
        this.id = novo;
    }

    public int getId() {
        return id;
    }

    public void calcPreco() {
        this.preco = preco * qtde;

    }

    public double getPreco() {
        return preco;
    }

    public void aumentarQtde() {
        this.qtde++;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int n) {
        qtde = n;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setIdProduto(int id) {
        idProduto = id;
    }

    public int getIdProduto() {
        return idProduto;
    }
}
