/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gabrielsousa
 */
public class Usuario {
      private int idUsuario;
    private String nomeUsuario;
    private String funcao;
    private String userName;
    private String senha;
    private boolean disponivel;

    public Usuario(String nomeUsuario, String funcao, String userName, String senha, boolean disponivel) {
        this.nomeUsuario = nomeUsuario;
        this.funcao = funcao;
        this.userName = userName;
        this.senha = senha;
        this.disponivel = disponivel;
    }

    public Usuario(int idUsuario, String nomeUsuario, String funcao, String userName, String senha, boolean disponivel) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.funcao = funcao;
        this.userName = userName;
        this.senha = senha;
        this.disponivel = disponivel;
    }

 

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
