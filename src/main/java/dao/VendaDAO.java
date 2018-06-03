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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Venda;

/**
 *
 * @author guigr
 */
public class VendaDAO {

    public static Venda realizarVenda(int idCliente, double valor) throws SQLException, Exception {
        Venda venda = new Venda(idCliente, valor);
        Connection conn = null;
//idVenda INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
//        idCliente INT NOT NULL,
//        valorTotal DOUBLE NOT NULL,
//        FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
        String sql = "INSERT INTO Venda(idCliente,ValorTotal)"
                + "VALUES (?, ?)";

        PreparedStatement stmt = null;

        try {
            conn = ConnectionUtils.getConnection();

            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, idCliente);

            stmt.setDouble(2, valor);

            stmt.execute();
            
             final ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                final int lastId = rs.getInt(1);
                venda.setId(lastId);
                
            }

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
        return venda;

    }

}
