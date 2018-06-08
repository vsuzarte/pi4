/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ClienteDAO;
import dao.MensagemDAO;
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
import model.Mensagem;

/**
 *
 * @author guilherme.gcosta6
 */
@WebServlet(name = "MandarMensagem", urlPatterns = {"/mandar-mensagem"})
public class MandarMensagem extends HttpServlet {

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

        HttpSession sessao = request.getSession();

        if (sessao.getAttribute("cliente") == null) {
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {

            String mensagem = request.getParameter("mensagem");
            String assunto = request.getParameter("assunto");
            Cliente cliente = (Cliente) sessao.getAttribute("cliente");
            int idCliente = cliente.getIdCliente();
            Mensagem msg = new Mensagem(idCliente, mensagem, assunto);

            try {
                MensagemDAO.enviarMensagem(idCliente, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
            sessao.setAttribute("cliente", cliente);
            request.setAttribute("mensagem", "Cadastrado ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/consultar-mensagem.jsp");
            dispatcher.forward(request, response);
        }

    }
}
