/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ProdutoDAO;
import model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "AdicionarProduto", urlPatterns = {"/add-produto-carrinho"})
public class AdicionarProduto extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
//        if (sessao == null || sessao.getAttribute("usuario") == null) {
//            request.setAttribute("mensagemErro", "Você precisa logar ! ");
//            RequestDispatcher dispatcher
//                    = request.getRequestDispatcher("/index.jsp");
//            dispatcher.forward(request, response);
//
//        }

        try {
          
            Produto produto = ProdutoDAO.procurarProdutoPorNome(request.getParameter("produto"));
            
            if (sessao.getAttribute("carrinho") == null){
                List<Produto> carrinho = new ArrayList();
                carrinho.add(produto);
                sessao.setAttribute("carrinho", carrinho);
            }else{

            List<Produto> carrinho = (List<Produto>) sessao.getAttribute("carrinho");
            
            carrinho.add(produto);
            
            sessao.setAttribute("carrinho", carrinho);
            }
           
            
            
            response.sendRedirect(request.getContextPath() + "/index.jsp");

            //RequestDispatcher dispatcher = request.getRequestDispatcher("clienteConsultado.jsp");
            //dispatcher.forward(request, response);
        } catch (Exception e) {
//             response.sendRedirect(request.getContextPath() + "/index.jsp");
            
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
