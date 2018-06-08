/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ClienteDAO;
import dao.MensagemDAO;
import model.ItemVenda;
import dao.ProdutoDAO;
import model.Produto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;
import model.Mensagem;
import model.Usuario;
import model.Venda;

/**
 *
 * @author Vitor
 */
@WebServlet(name = "MensagensBack", urlPatterns = {"/consultar-mensagens-back"})
public class MensagensBack extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           HttpSession sessao = request.getSession();
          
         if(sessao.getAttribute("usuario") == null){
             response.sendRedirect(request.getContextPath() + "/loginBack.jsp");
         }
           
        try {
            List<Mensagem> listaMensagens = MensagemDAO.listarMensagens();
            sessao.setAttribute("listaMensagens", listaMensagens);
              response.sendRedirect(request.getContextPath() + "/mensagensBack.jsp");
        } catch (Exception ex) {

        }
 
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
HttpSession sessao = request.getSession();
           
     

    }

}
