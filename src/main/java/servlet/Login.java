/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import model.Cliente;
import dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("email");
        String senha = request.getParameter("senha");

        Cliente cliente = null;
        try {
            cliente = ClienteDAO.procurarUsername(username);
        } catch (Exception E) {
            E.printStackTrace();
        }
        
        

        if (cliente == null || !senha.equals(cliente.getSenhaCliente())) {
            request.setAttribute("mensagem", "Usuário ou senha inválido");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }

        if (senha.equals(cliente.getSenhaCliente())) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("cliente", cliente);
           
            
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            

        }
    }
}
