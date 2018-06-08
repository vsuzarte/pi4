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
@WebServlet(name = "ResponderMensagem", urlPatterns = {"/responder-mensagem"})
public class ResponderMensagem extends HttpServlet {

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

        if (sessao.getAttribute("usuario") == null) {
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/loginBack.jsp");
            dispatcher.forward(request, response);
        } else {

            
            String resposta = request.getParameter("resposta");
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            try {
                MensagemDAO.responderMensagem(idCliente,resposta);
            } catch (Exception e) {
                e.printStackTrace();
            }
           
            request.setAttribute("mensagem", "Cadastrado ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/consultar-mensagens-back.jsp");
            dispatcher.forward(request, response);
        }

    }
}
