/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionUtils;
import model.Produto;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guigr
 */
public class ItemVendaDAO {

    
    public static void inserirItemVenda(int idVenda, int idProduto, int quantidade) throws SQLException, Exception {

        Connection conn = null;
//idVenda INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
//        idCliente INT NOT NULL,
//        valorTotal DOUBLE NOT NULL,
//        FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
        String sql = "INSERT INTO ItemVenda(idVenda,idProduto, quantidade)"
                + "VALUES (?, ?, ?)";

        PreparedStatement stmt = null;

        try {
            conn = ConnectionUtils.getConnection();

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idVenda);
            
            stmt.setInt(2, idProduto);

            stmt.setInt(3, quantidade);
            
            stmt.execute();

        } catch (Exception E) {
            E.printStackTrace();
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
