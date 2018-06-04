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

/**
 *
 * @author guigr
 */
public class ClienteDAO {

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

     public static void cadastrarEndereco(Cliente cliente) throws SQLException, Exception {

        //Monta a string com o comando SQL para atualizar dados na tabela cliente
        //ultilizando os dados do cliente passado por parâmetro.
        //A String ira ser ultilizada pelo prepared statement
        String sql = "UPDATE cliente SET  cepCliente=?, estadoCliente=?, cidadeCliente=?, ruaCliente=?, numCasa=?, complemento=?, bairro=? "
                + "WHERE (idCliente=?)";

        //connection para abertura e fechamento.
        Connection connection = null;

        //PreparedStatement para os comandos SQL e fechamento do mesmo.
        PreparedStatement preparedStatement = null;

        try {

            ////chama a classe criada ConnectionUtils.
            //abre a conexão com o banco de dados.
            connection = ConnectionUtils.getConnection();

            //cria um statement para execução de instruções SQL.
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do PreparedSatamente
            //cada preparedStatement ira ocupar uma interrogação na instrução SQL
            //que foi digitada acima, trocando seus valores pelo obtido do Cliente.
            preparedStatement.setString(1, cliente.getCepCliente());

            preparedStatement.setString(2, cliente.getEstadoCliente());

         

            preparedStatement.setString(3, cliente.getCidadeCliente());

            preparedStatement.setString(4, cliente.getRuaCliente());

            preparedStatement.setString(5, cliente.getNumCasa());

            preparedStatement.setString(6, cliente.getComplemento());

            preparedStatement.setString(7, cliente.getBairro());
            
            preparedStatement.setInt(8, cliente.getIdCliente());

            //Exucuta o comando do banco de dados.
            preparedStatement.execute();

        } finally {

            //Se o statement ainda estiver aberto, realiza seu fechamento. 
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            //Se a conexão ainda estiver aberta, realiza seu fechamento.
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        }

    }
    
}
