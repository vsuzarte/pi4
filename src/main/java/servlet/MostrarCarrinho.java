/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import model.ItemVenda;
import dao.ProdutoDAO;
import model.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vitor
 */
@WebServlet(name = "MostrarCarrinho", urlPatterns = {"/mostrar-carrinho"})
public class MostrarCarrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           HttpSession sessao = request.getSession();
           
           
        try {

            List<ItemVenda> carrinho = (List<ItemVenda>) sessao.getAttribute("carrinho");
            
            double total = 0;
            for(int i = 0; i < carrinho.size(); i++){
                total += carrinho.get(i).getValor();
            }
            
            sessao.setAttribute("totalCarrinho", total);
            
            response.sendRedirect(request.getContextPath() + "/carrinho.jsp");
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/carrinho.jsp");
            
        }

     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
HttpSession sessao = request.getSession();
           
           
        try {

            List<Produto> carrinho = (List<Produto>) sessao.getAttribute("carrinho");
            
            response.sendRedirect(request.getContextPath() + "/carrinho.jsp");
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/carrinho.jsp");
            
        }

    }

}
