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
public class Venda {

    private int id;
    private int idCliente;
    private double valor;
    private float total;
    private String cartao;
    private String status;

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Venda(int idCliente, double valor, String cartao ,String status) {
        this.idCliente = idCliente;
        this.cartao = cartao;
        this.valor = valor;
        this.status = status;
    }
    
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
