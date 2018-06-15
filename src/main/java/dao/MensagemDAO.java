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
import model.Mensagem;
import model.Venda;

/**
 *
 * @author guigr
 */
public class MensagemDAO {

    public static Mensagem enviarMensagem(int idCliente, Mensagem mensagem) throws SQLException, Exception {
        
        Connection conn = null;

        String sql = "INSERT INTO Mensagens(idCliente, Mensagem, Assunto, Status)"
                + "VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = null;

        try {
            conn = ConnectionUtils.getConnection();

            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, idCliente);

            stmt.setString(2, mensagem.getMensagem());
            
            stmt.setString(3, mensagem.getAssunto());
            
             stmt.setString(4, mensagem.getStatus());

            stmt.execute();
            
             final ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                final int lastId = rs.getInt(1);
                mensagem.setIdMensagem(lastId);
                
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
        return mensagem;

    }
       public static List<Mensagem> consultarMensagens(int idCliente) throws SQLException, Exception {

        String sql = "SELECT * FROM mensagens WHERE IDCLIENTE=?";

        List<Mensagem> listaMensagens = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;

        try {

            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareCall(sql);

            preparedStatement.setInt(1,idCliente );

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (listaMensagens == null) {
                    listaMensagens = new ArrayList<Mensagem>();
                }
               

                int idMensagem = result.getInt("idMensagem");
             
                 String mensagem = result.getString("mensagem");
              
                   
               
                String status = result.getString("status");
                String resposta = result.getString("resposta");
                String assunto = result.getString("assunto");
                Mensagem msg = new Mensagem( idCliente, mensagem, assunto);
                msg.setIdMensagem(idMensagem);
                msg.setStatus(status);
                msg.setResposta(resposta);
                
               
                listaMensagens.add(msg);
                
                
            }
            

        } finally {

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            //Se a conexão ainda estiver aberta, realiza seu fechamento.
            if (connection != null && !connection.isClosed()) {
                connection.isClosed();
            }

        }
        
        List<Mensagem> troca = new ArrayList<Mensagem>();
             if(listaMensagens!=null){
                int j = listaMensagens.size();
 
                for(int i = 0; i < listaMensagens.size() ;i++ ){
                    troca.add(listaMensagens.get(j - 1));
                    j--;
                   
                }
             }

        return troca;
    }
        public static List<Mensagem> listarMensagens() throws SQLException, Exception {

        String sql = "SELECT * FROM Mensagens WHERE Status = ?";

        List<Mensagem> listaMensagens = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;

        try {

            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareCall(sql);

             preparedStatement.setString(1, "aguardando");

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (listaMensagens == null) {
                    listaMensagens = new ArrayList<Mensagem>();
                }
               

                  int idMensagem = result.getInt("idMensagem");
              
               int idCliente = result.getInt("idCliente");
                String mensagem = result.getString("cartao");
                String status = result.getString("status");
                String resposta = result.getString("resposta");
                String assunto = result.getString("assunto");
                Mensagem msg = new Mensagem( idCliente, mensagem, assunto);
                msg.setIdMensagem(idMensagem);
                msg.setStatus(status);
                msg.setResposta(resposta);
                
               
                listaMensagens.add(msg);
                
            }
            

        } finally {

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            //Se a conexão ainda estiver aberta, realiza seu fechamento.
            if (connection != null && !connection.isClosed()) {
                connection.isClosed();
            }

        }

        return listaMensagens;
    }
        
     public static void responderMensagem(int idMensagem, String resposta) throws SQLException, Exception {

        //Monta a string com o comando SQL para atualizar dados na tabela cliente
        //ultilizando os dados do cliente passado por parâmetro.
        //A String ira ser ultilizada pelo prepared statement
        String sql = "UPDATE Mensagens SET  Status=?, Resposta=? "
                + "WHERE (idMensagem=?)";

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
            preparedStatement.setString(1, "respondida");

            preparedStatement.setString(2, resposta);
            
            preparedStatement.setInt(3, idMensagem);


         

           

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
