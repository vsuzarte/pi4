/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package model;

/**
 *
 * @author guilherme.gcosta6
 */
public class Produto {

    private Integer idProduto;
    private String nomeProduto;
    private String descricao;
    private double valorProduto;
    private String c1;
    private String c2;
    private String c3;
    private String c4;
    private String c5;
    private String c6;
    private String categoria;
    private String img;
    private String imgV1;
    private String imgV2;
    private String imgV3;
    private String imgC1;
    private String imgC2;
    private String imgC3;

    public Produto(String nomeProduto, String descricao, double valorProduto, String c1, String c2, String c3, String c4, String c5, String c6, String categoria, String img, String imgV1, String imgV2, String imgV3, String imgC1, String imgC2, String imgC3) {
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.valorProduto = valorProduto;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
        this.c6 = c6;
        this.categoria = categoria;
        this.img = img;
        this.imgV1 = imgV1;
        this.imgV2 = imgV2;
        this.imgV3 = imgV3;
        this.imgC1 = imgC1;
        this.imgC2 = imgC2;
        this.imgC3 = imgC3;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4;
    }

    public String getC5() {
        return c5;
    }

    public void setC5(String c5) {
        this.c5 = c5;
    }

    public String getC6() {
        return c6;
    }

    public void setC6(String c6) {
        this.c6 = c6;
    }

}
