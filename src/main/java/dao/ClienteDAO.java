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

        String sql = "INSERT INTO Cliente(nomeCliente, nomeContato, cpfCliente, emailCliente, telefoneCliente, estadoCliente,"
                + " cidadeCliente, enderecoCliente, numCasa, disponivel, cepCliente) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;

        try {

            conn = ConnectionUtils.getConnection();

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());

            stmt.setString(2, cliente.getSobrenome());

            stmt.setString(3, cliente.getCpf());

            stmt.setString(4, cliente.getEmail());

            stmt.setString(5, cliente.getTelefone());

            stmt.setString(6, cliente.getEstado());

            stmt.setString(7, cliente.getCidade());

            stmt.setString(8, cliente.getEndereco());

            stmt.setString(9, cliente.getNumCasa());


            stmt.setBoolean(10, true);

            stmt.setString(11, cliente.getCep());

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

    public static List<Cliente> listarCliente() throws SQLException, Exception {

        String sql = "SELECT * FROM Cliente WHERE (DISPONIVEL=?)";

        List<Cliente> listaClientes = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;

        try {

            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setBoolean(1, true);

            result = preparedStatement.executeQuery();

            //     DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
            while (result.next()) {

                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }

                int idCliente = result.getInt("idCliente");
                String nomeCliente = result.getString("nomeCliente");
                String sobrenomeCliente = result.getString("sobrenomeCliente");
            
                String cpfCliente = result.getString("cpfCliente");
                String emailCliente = result.getString("emailCliente");
                String telefoneCliente = result.getString("telefoneCliente");
                String estadoCliente = result.getString("estadoCliente");
                String cidadeCliente = result.getString("cidadeCliente");
                String enderecoCliente = result.getString("enderecoCliente");
                String cepCliente = result.getString("cepCliente");
                String numCasa = Integer.toString(result.getInt("numCasa"));

                Cliente cliente = new Cliente(idCliente, nomeCliente, sobrenomeCliente,
                         cpfCliente, emailCliente,
                        telefoneCliente, estadoCliente, cidadeCliente, enderecoCliente,
                        cepCliente, numCasa);

                listaClientes.add(cliente);
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
        return listaClientes;
    }

    public static List<Cliente> procurarCliente(String nome) throws SQLException, Exception {

        //Monta a string com o comando SQL para procurar um cliente de acordo com o nome ou letra.
        //ultilizando o valor passado por parâmetro.
        //A String ira ser ultilizada pelo prepared statement
        String sql = "SELECT * FROM cliente WHERE UPPER (NOMECLIENTE) LIKE UPPER (?) AND DISPONIVEL=?";

        //Lista de clientes de resultado
        List<Cliente> listaCliente = null;

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
                if (listaCliente == null) {
                    listaCliente = new ArrayList<Cliente>();
                }

                //Cria a instância Cliente, pega os valores obtidos pela consulta ao banco,
                //e a popula.
                int idCliente = result.getInt("idCliente");
                String nomeCliente = result.getString("nomeCliente");
                String sobrenomeCliente = result.getString("sobrenomeCliente");
                String cpfCliente = result.getString("cpfCliente");
                String emailCliente = result.getString("emailCliente");
                String telefoneCliente = result.getString("telefoneCliente");
                String estadoCliente = result.getString("estadoCliente");
                String cidadeCliente = result.getString("cidadeCliente");
                String enderecoCliente = result.getString("enderecoCliente");
                String cepCliente = result.getString("cepCliente");
                String numCasa = Integer.toString(result.getInt("numCasa"));

                Cliente cliente = new Cliente(idCliente, nomeCliente, sobrenomeCliente,
                       cpfCliente, emailCliente,
                        telefoneCliente, estadoCliente, cidadeCliente, enderecoCliente,
                        cepCliente, numCasa);

                //Adiciona a instãncia na lista.
                listaCliente.add(cliente);
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

        //Retorna a lista de cliente do banco de dados.
        return listaCliente;
    }

    public static void excluirCliente(Integer id) throws SQLException, Exception {

        //Monta a string com o comando SQL para "excluir" um cliente do banco de dados.
        //ultilizando o ID passado por parâmetro.
        //A String ira ser ultilizada pelo prepared statement
        String sql = "UPDATE cliente SET DISPONIVEL=? WHERE (idCliente=?)";

        //Conexão para abertura e fechamento
        Connection connection = null;

        //PreparedStatement para os comandos SQL e fechamento do mesmo.
        PreparedStatement preparedStatement = null;

        try {

            //chama a classe criada ConnectionUtils.
            //abre a conexão com o banco de dados.
            connection = ConnectionUtils.getConnection();

            //cria um statement para execução de instruções SQL.
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do PreparedSatamente
            //cada preparedStatement ira ocupar uma interrogação na instrução SQL
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);

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

    public static void atualizarCliente(Cliente cliente) throws SQLException, Exception {

        //Monta a string com o comando SQL para atualizar dados na tabela cliente
        //ultilizando os dados do cliente passado por parâmetro.
        //A String ira ser ultilizada pelo prepared statement
        String sql = "UPDATE cliente SET nomeCliente=?, sobrenomeCliente=?,  cpfCliente=?, emailCliente=?, telefoneCliente=?, estadoCliente=?, cidadeCliente=?,"
                + "enderecoCliente=?, cepcliente=?, numCasa=?"
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
            preparedStatement.setString(1, cliente.getNome());

            preparedStatement.setString(2, cliente.getSobrenome());

         

            preparedStatement.setString(3, cliente.getCpf());

            preparedStatement.setString(4, cliente.getEmail());

            preparedStatement.setString(5, cliente.getTelefone());

            preparedStatement.setString(6, cliente.getEstado());

            preparedStatement.setString(7, cliente.getCidade());

            preparedStatement.setString(8, cliente.getEndereco());

            preparedStatement.setString(9, cliente.getCep());

            preparedStatement.setString(10, cliente.getNumCasa());


            preparedStatement.setInt(11, cliente.getId());

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
    
     public static Cliente obterCliente(Integer id) throws SQLException, Exception {

        //Monta a string com o comando SQL para procurar um cliente de acordo com o ID,
        //passado por parâmetro.
        //A String ira ser ultilizada pelo prepared statement
        String sql = "SELECT * FROM cliente WHERE (idCliente=? AND disponivel=?)";

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
                int idCliente = result.getInt("idCliente");
                String nomeCliente = result.getString("nomeCliente");
                String sobrenomeCliente = result.getString("sobrenomeCliente");
               
                String cpfCliente = result.getString("cpfCliente");
                String emailCliente = result.getString("emailCliente");
                String telefoneCliente = result.getString("telefoneCliente");
                String estadoCliente = result.getString("estadoCliente");
                String cidadeCliente = result.getString("cidadeCliente");
                String enderecoCliente = result.getString("enderecoCliente");
                String cepCliente = result.getString("cepCliente");
                String numCasa = Integer.toString(result.getInt("numCasa"));
                
                
                Cliente cliente = new Cliente(idCliente, nomeCliente, sobrenomeCliente
                 , cpfCliente, emailCliente,
                        telefoneCliente, estadoCliente, cidadeCliente, enderecoCliente,
                        cepCliente, numCasa);

                //Retorna o resultado
                return cliente;
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
