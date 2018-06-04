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
@WebServlet(name = "CadastroCliente", urlPatterns = {"/cadastro-cliente"})
public class CadastroCliente extends HttpServlet {

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

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String senha2 = request.getParameter("senha2");
        
        if(senha.equals(senha2)){

        Cliente cliente = new Cliente(nome, email, senha);

        try {
            ClienteDAO.inserirCliente(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpSession sessao = request.getSession();
            sessao.setAttribute("cliente", cliente);
           
        request.setAttribute("mensagem", "Cadastrado ! ");
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
        }else{
            request.setAttribute("mensagem", "Senhas não iguais ! ");
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/cadastroCliente.jsp");
        dispatcher.forward(request, response);
        }

    }
}
