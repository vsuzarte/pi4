/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import model.Produto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;

/**
 *
 * @author guilherme.gcosta6
 */
@WebServlet(name = "CadastroEndereco", urlPatterns = {"/cadastro-endereco"})
public class CadastroEndereco extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String destino;

        HttpSession sessao = request.getSession();

        if (sessao.getAttribute("cliente") != null) {

            request.setAttribute("mensagem", "Cliente cadastrado ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/CadastroCliente.jsp");
            dispatcher.forward(request, response);

            destino = "cadastroCliente.jsp";

        } else {

            destino = "CadastroCliente.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rua = request.getParameter("rua");
        String cep = request.getParameter("cep");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        
                HttpSession sessao = request.getSession();

        Cliente cliente = (Cliente) sessao.getAttribute("cliente");
        
        cliente.setBairro(bairro);
        cliente.setCepCliente(complemento);
        cliente.setNumCasa(numero);
        cliente.setCidadeCliente(cidade);
        cliente.setEstadoCliente(estado);
        cliente.setCepCliente(cep);
        cliente.setRuaCliente(rua);

            try {
                ClienteDAO.cadastrarEndereco(cliente);
            } catch (Exception e) {
                e.printStackTrace();
            }

           
            sessao.setAttribute("cliente", cliente);

            request.setAttribute("mensagem", "Cadastrado ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/pagamento.jsp");
            dispatcher.forward(request, response);
        

    }
}
