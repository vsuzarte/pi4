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
public class ProdutoDAO {

    
    public static void inserirProduto(Produto produto) throws SQLException, Exception {

        Connection conn = null;

        String sql = "INSERT INTO Produto(c1,c2,c3,c4,c5,c6,descricao, nomeProduto, valorProduto, categoria, disponivel)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            conn = ConnectionUtils.getConnection();

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getC1());
            
            stmt.setString(2, produto.getC2());
            
            stmt.setString(3, produto.getC3());
            
            stmt.setString(4, produto.getC4());
            
            stmt.setString(5, produto.getC5());
            
            stmt.setString(6, produto.getC6());

            stmt.setString(7, produto.getDescricao());

            stmt.setString(8, produto.getNomeProduto());

            stmt.setDouble(9, produto.getValorProduto());

            stmt.setString(9, produto.getCategoria());
            
            stmt.setBoolean(11, true);

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

    public static List<Produto> listarProduto() throws SQLException, Exception {

        String sql = "SELECT * FROM produto WHERE (disponivel=?)";

        List<Produto> listaProdutos = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;

        try {

            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareCall(sql);

            preparedStatement.setBoolean(1, true);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<Produto>();
                }
               

                int idProduto = result.getInt("idProduto");
                String nomeProduto = result.getString("nomeProduto");
                String descricao = result.getString("descricao");
                String c1 = result.getString("c1");
                String c2 = result.getString("c2");
                String c3 = result.getString("c3");
                String c4 = result.getString("c4");
                String c5 = result.getString("c5");
                String c6 = result.getString("c6");
                String categoria = result.getString("categoria");
                double valorProduto = result.getDouble("valorProduto");


                Produto produto = new Produto(nomeProduto, descricao, valorProduto, c1,c2,c3,c4,c5,c6, categoria);

                listaProdutos.add(produto);
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

        return listaProdutos;
    }

    public static void excluirProduto(Integer id) throws SQLException, Exception {

        String sql = "UPDATE produto SET disponivel=? WHERE (idProduto=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareCall(sql);

            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);

            preparedStatement.execute();

        } finally {

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        }
    }

    public static List<Produto> procurarProduto(String nome) throws SQLException, Exception {

        String sql = "SELECT * FROM produto WHERE UPPER (nomeProduto) LIKE UPPER (?) AND DISPONIVEL=?";

        //Lista de clientes de resultado
        List<Produto> listaProdutos = null;

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
            //cada preparedStatement ira ocupar a interrogação na instrução SQL.
            preparedStatement.setString(1, "%" + nome + "%");
            preparedStatement.setBoolean(2, true);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //While passa por cada item (linha) do resultado
            while (result.next()) {

                //Se a lista não foi inicializada, a inicializa
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<Produto>();
                }

                
                int idProduto = result.getInt("idProduto");
                String nomeProduto = result.getString("nomeProduto");
                String descricao = result.getString("descricao");
                String c1 = result.getString("c1");
                String c2 = result.getString("c2");
                String c3 = result.getString("c3");
                String c4 = result.getString("c4");
                String c5 = result.getString("c5");
                String c6 = result.getString("c6");
                String categoria = result.getString("categoria");
                double valorProduto = result.getDouble("valorProduto");


                Produto produto = new Produto(nomeProduto, descricao, valorProduto, c1,c2,c3,c4,c5,c6, categoria);

                listaProdutos.add(produto);
            }

        } finally {

            if (result != null && !result.isClosed()) {
                result.close();
            }

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        }

        return listaProdutos;
    }

    public static void atualizarProduto(Produto produto) throws SQLException, Exception {

        String sql = "UPDATE produto SET nomeProduto=?, c1=?,c2=?,c3=?,c4=?,c5=?,c6=?,  "
                + " categoria=?, valorProduto=?"
                + " WHERE (idProduto=?)";

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
            preparedStatement.setString(1, produto.getNomeProduto());

            preparedStatement.setString(2, produto.getC1());

            preparedStatement.setString(3, produto.getC2());
            
            preparedStatement.setString(4, produto.getC3());
            
            preparedStatement.setString(5, produto.getC4());
            
            preparedStatement.setString(6, produto.getC5());
            
            preparedStatement.setString(7, produto.getC6());
            
            preparedStatement.setString(8, produto.getCategoria());

            preparedStatement.setDouble(9, produto.getValorProduto());

            preparedStatement.setInt(10, produto.getIdProduto());

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

    public static Produto obterProduto(Integer id) throws SQLException, Exception {

        //Monta a string com o comando SQL para procurar um cliente de acordo com o ID,
        //passado por parâmetro.
        //A String ira ser ultilizada pelo prepared statement
        String sql = "SELECT * FROM produto WHERE (idProduto=? AND disponivel=?)";

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
            //cada preparedStatement ira ocupar a interrogação na instrução SQL.
            preparedStatement.setInt(1, id);
            preparedStatement.setBoolean(2, true);

            //Executa a consulta SQL no banco de dados.
            result = preparedStatement.executeQuery();

            //Verifica se há pelo menos um resultado
            if (result.next()) {

                //Cria a instância Cliente, pega os valores obtidos pela consulta ao banco,
                //e a popula.
                 int idProduto = result.getInt("idProduto");
                String nomeProduto = result.getString("nomeProduto");
                String descricao = result.getString("descricao");
                String c1 = result.getString("c1");
                String c2 = result.getString("c2");
                String c3 = result.getString("c3");
                String c4 = result.getString("c4");
                String c5 = result.getString("c5");
                String c6 = result.getString("c6");
                String categoria = result.getString("categoria");
                double valorProduto = result.getDouble("valorProduto");


                Produto produto = new Produto(idProduto,nomeProduto, descricao, valorProduto, c1,c2,c3,c4,c5,c6, categoria);

                //Retorna o resultado
                return produto;
            }

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

        //Se chegamos aqui, não foi encontrado nenhum cliente porque
        //a pesquisa não teve resultados
        //Neste caso, não há um cliente a retornar, então retornamos "null"
        return null;

    }

}
