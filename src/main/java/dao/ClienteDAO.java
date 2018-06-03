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

    public static Cliente procurarUsername(String email) throws SQLException, Exception {
        String sql = "SELECT * FROM Cliente WHERE emailCliente = (?) AND Disponivel = true ";
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

                Cliente cliente = new Cliente();

                String nomeCliente = result.getString("nomeCliente");
                String emailCliente = result.getString("emailCliente");
                String telefoneCliente = result.getString("telefoneCliente");
                String senhaCliente = result.getString("senhaCliente");
                String cepCliente = result.getString("cepCliente");
                String estadoCliente = result.getString("estadoCliente");
                String cidadeCliente = result.getString("cidadeCliente");
                String ruaCliente = result.getString("ruaCliente");
                String numCasa = result.getString("numCasa");
                String complemento = result.getString("complemento");
                String bairro = result.getString("bairro");
                String nomeContato = result.getString("nomeContato");
                int idCliente = result.getInt("idCliente");
              
                cliente.setBairro(bairro);
                cliente.setCepCliente(cepCliente);
                cliente.setCidadeCliente(cidadeCliente);
                cliente.setComplemento(complemento);
                cliente.setEmailCliente(emailCliente);
                cliente.setEstadoCliente(estadoCliente);
                cliente.setNomeCliente(nomeCliente);
                cliente.setNomeContato(nomeContato);
                cliente.setNumCasa(numCasa);
                cliente.setRuaCliente(ruaCliente);
                cliente.setSenhaCliente(senhaCliente);
                cliente.setTelefoneCliente(telefoneCliente);
                cliente.setIdCliente(idCliente);
                
                
             

                return cliente;

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
