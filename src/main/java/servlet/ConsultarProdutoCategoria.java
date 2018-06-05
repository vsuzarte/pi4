/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

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
@WebServlet(name = "ConsultarProdutoCategoria", urlPatterns = {"/consultar-produto-categoria"})
public class ConsultarProdutoCategoria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           HttpSession sessao = request.getSession();
        try {

            String categoria = request.getParameter("categoria");

            List<Produto> listaProduto = ProdutoDAO.procurarProdutoCategoria(categoria);
            request.setAttribute("listaProduto", listaProduto);

            if (categoria == null || categoria.equals("")) {
                listaProduto = ProdutoDAO.listarProduto();
                request.setAttribute("listaProduto", listaProduto);
            }

            sessao.setAttribute("listaProduto", listaProduto);
            response.sendRedirect(request.getContextPath() + "/index.jsp");

            
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            
        }

     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


           HttpSession sessao = request.getSession();
        try {

            String categoria = request.getParameter("categoria");

            List<Produto> listaProduto = ProdutoDAO.procurarProdutoCategoria(categoria);
            request.setAttribute("listaProduto", listaProduto);

            if (categoria == null || categoria.equals("")) {
                listaProduto = ProdutoDAO.listarProduto();
                request.setAttribute("listaProduto", listaProduto);
            }

            sessao.setAttribute("listaProduto", listaProduto);
            response.sendRedirect(request.getContextPath() + "/index.jsp");

            
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            
        }
       

    }

}
