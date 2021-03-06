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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import model.Venda;

/**
 *
 * @author guigr
 */
public class UsuarioDAO {

    public static void inserirCliente(Cliente cliente) throws SQLException, Exception {

        Connection conn = null;

        String sql = "INSERT INTO Cliente(nomeCliente,"
                + " emailCliente,senhaCliente, disponivel) "
                + "VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = null;

        try {

            conn = ConnectionUtils.getConnection();

            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, cliente.getNomeCliente());

            stmt.setString(2, cliente.getEmailCliente());

            stmt.setString(3, cliente.getSenhaCliente());

            stmt.setBoolean(4, true);

            stmt.execute();
            
            final ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                final int lastId = rs.getInt(1);
                cliente.setIdCliente(lastId);
                
            }

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

    public static Usuario procurarUsername(String email) throws SQLException, Exception {
        String sql = "SELECT * FROM usuario WHERE username = (?) AND Disponivel = true ";
        //connection para abertura e fechamento.
        Connection connection = null;

        //PreparedStatement para os comandos SQL e fechamento do mesmo.
        PreparedStatement preparedStatement = null;

        //Armazenará os resultados do banco de dados
        ResultSet result = null;

        try {

            //chama a classe criada ConnectionUtils.
            //abre a conexão com o banco de dados.
            connection = ConnectionUtils.getConnection();

            //cria um statement para execução de instruções SQL.
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do PreparedSatamente.
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, email);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            if (result.next()) {

               

                String nomeUsuario = result.getString("nomeUsuario");
                String funcao = result.getString("funcao");
                String username = result.getString("username");
                String senha = result.getString("senha");
                
                int idUsuario = result.getInt("idUsuario");
              
               Usuario usuario = new Usuario(  idUsuario,  nomeUsuario,  funcao,  username,  senha,  true);
                
                
                
             

                return usuario;

            }

        } catch (Exception E) {
            E.printStackTrace();
        } finally {

            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }

            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        }

        return null;
    }

}
