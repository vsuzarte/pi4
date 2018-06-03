/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionUtils;
import model.Cliente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guigr
 */
public class ClienteDAO {

    public static void inserirCliente(Cliente cliente) throws SQLException, Exception {

        Connection conn = null;

        String sql = "INSERT INTO Cliente(nomeCliente, nomeContato, bairro, cepCliente, cidadeCliente, complemento,"
                + " emailCliente, estadoCliente, numCasa, ruaCliente, senhaCliente, telefoneCLiente, disponivel) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";

        PreparedStatement stmt = null;

        try {

            conn = ConnectionUtils.getConnection();

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, cliente.getNomeCliente());

            stmt.setString(2, cliente.getNomeContato());

            stmt.setString(3, cliente.getBairro());

            stmt.setString(4, cliente.getCepCliente());

            stmt.setString(5, cliente.getCidadeCliente());

            stmt.setString(6, cliente.getComplemento());

            stmt.setString(7, cliente.getEmailCliente());

            stmt.setString(8, cliente.getEstadoCliente());

            stmt.setString(9, cliente.getNumCasa());

            stmt.setString(10, cliente.getRuaCliente());
            
            stmt.setString(11, cliente.getSenhaCliente());
            
            stmt.setString(12, cliente.getTelefoneCliente());

            stmt.setBoolean(13, true);


            stmt.execute();

        } finally {

            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }

            //Se a conexão ainda estiver aberta, realiza seu fechamento.
            if (conn != null && !conn.isClosed()) {
                conn.isClosed();
            }

        }

    }

}
