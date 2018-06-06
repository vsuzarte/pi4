/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import model.Cliente;
import dao.ClienteDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;


@WebServlet(name = "LoginBack", urlPatterns = {"/login-back"})
public class LoginBack extends HttpServlet {

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
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");

        Usuario usuario = null;
        try {
            usuario = UsuarioDAO.procurarUsername(username);
        } catch (Exception E) {
            E.printStackTrace();
        }
        
        

        if (usuario == null || !senha.equals(usuario.getSenha())) {
            request.setAttribute("mensagem", "Usuário ou senha inválido");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/loginBack.jsp");
            dispatcher.forward(request, response);
        }

        if (senha.equals(usuario.getSenha())) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario);
           
            
            response.sendRedirect(request.getContextPath() + "/homeBack.jsp");
            

        }
    }
}
