/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ClienteDAO;
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
import model.Venda;

/**
 *
 * @author Vitor
 */
@WebServlet(name = "Compras", urlPatterns = {"/mostrar-compras"})
public class Compras extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           HttpSession sessao = request.getSession();
           Cliente cliente = (Cliente) sessao.getAttribute("cliente");
        try {
            List<Venda> listaCompras = ClienteDAO.listarVendas(cliente);
            sessao.setAttribute("listaCompras", listaCompras);
              response.sendRedirect(request.getContextPath() + "/vendas.jsp");
        } catch (Exception ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
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
