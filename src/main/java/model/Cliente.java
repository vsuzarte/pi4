/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author guigr
 */
public class Cliente {
    
    private Integer idCliente;
    private String nomeCliente;
    private String emailCliente;
    private String senhaCliente;
    private String cepCliente;
    private String estadoCliente;
    private String cidadeCliente;
    private String ruaCliente;
    private String numCasa;
    private String complemento;
    private String bairro;
    private String nomeContato;
    private String telefoneCliente;

    public Cliente(String nomeCliente, String emailCliente, String senhaCliente, String cepCliente, String estadoCliente, String cidadeCliente, String ruaCliente, String numCasa, String complemento, String bairro, String nomeContato, String telefoneCliente) {
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
        this.cepCliente = cepCliente;
        this.estadoCliente = estadoCliente;
        this.cidadeCliente = cidadeCliente;
        this.ruaCliente = ruaCliente;
        this.numCasa = numCasa;
        this.complemento = complemento;
        this.bairro = bairro;
        this.nomeContato = nomeContato;
        this.telefoneCliente = telefoneCliente;
    }

    public Cliente(Integer idCliente, String nomeCliente, String emailCliente, String senhaCliente, String cepCliente, String estadoCliente, String cidadeCliente, String ruaCliente, String numCasa, String complemento, String bairro, String nomeContato, String telefoneCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
        this.cepCliente = cepCliente;
        this.estadoCliente = estadoCliente;
        this.cidadeCliente = cidadeCliente;
        this.ruaCliente = ruaCliente;
        this.numCasa = numCasa;
        this.complemento = complemento;
        this.bairro = bairro;
        this.nomeContato = nomeContato;
        this.telefoneCliente = telefoneCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public String getCidadeCliente() {
        return cidadeCliente;
    }

    public void setCidadeCliente(String cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }

    public String getRuaCliente() {
        return ruaCliente;
    }

    public void setRuaCliente(String ruaCliente) {
        this.ruaCliente = ruaCliente;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
    
    
   
    

    
}
