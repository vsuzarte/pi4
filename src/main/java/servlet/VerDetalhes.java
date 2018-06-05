/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import model.Cliente;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Produto;


@WebServlet(name = "VerDetalhes", urlPatterns = {"/ver-detalhes"})
public class VerDetalhes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        
     String nome = request.getParameter("nome");
        try {
            Produto produto = ProdutoDAO.procurarProdutoPorNome(nome);
            sessao.setAttribute("detalhe", produto);
        } catch (Exception ex) {
        }
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("detalhe.jsp");
        dispatcher.forward(request, response);
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
