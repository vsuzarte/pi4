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
    private String imgV1;
    private String imgV2;
    private String imgV3;
    private String imgC1;
    private String imgC2;
    private String imgC3;


    public ItemVenda(int qtde, String descricao, int idProduto, String nome, double preco, double valor, String img, String imgV1, String imgV2, String imgV3, String imgC1, String imgC2, String imgC3) {
        this.qtde = qtde;
        this.descricao = descricao;
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.valor = valor;
        this.img = img;
        this.imgV1 = imgV1;
        this.imgV2 = imgV2;
        this.imgV3 = imgV3;
        this.imgC1 = imgC1;
        this.imgC2 = imgC2;
        this.imgC3 = imgC3;
    }

    public ItemVenda(int id, int qtde, int idProduto) {
        this.id = id;
        this.qtde = qtde;
        this.idProduto = idProduto;
    }
    
    

    public String getImgV1() {
        return imgV1;
    }

    public void setImgV1(String imgV1) {
        this.imgV1 = imgV1;
    }

    public String getImgV2() {
        return imgV2;
    }

    public void setImgV2(String imgV2) {
        this.imgV2 = imgV2;
    }

    public String getImgV3() {
        return imgV3;
    }

    public void setImgV3(String imgV3) {
        this.imgV3 = imgV3;
    }

    public String getImgC1() {
        return imgC1;
    }

    public void setImgC1(String imgC1) {
        this.imgC1 = imgC1;
    }

    public String getImgC2() {
        return imgC2;
    }

    public void setImgC2(String imgC2) {
        this.imgC2 = imgC2;
    }

    public String getImgC3() {
        return imgC3;
    }

    public void setImgC3(String imgC3) {
        this.imgC3 = imgC3;
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
