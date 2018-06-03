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
@WebServlet(name = "DiminuirQuantidade", urlPatterns = {"/diminuir-quantidade"})
public class DiminuirQuantidade extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();

        try {
          
            Produto produto = ProdutoDAO.procurarProdutoPorNome(request.getParameter("produto"));
   
            List<ItemVenda> carrinho = (List<ItemVenda>) sessao.getAttribute("carrinho");
            
            
            
            for(int i = 0; i < carrinho.size(); i++){
                String nome1= produto.getNomeProduto();
                String nome2 = carrinho.get(i).getNome();
                if( nome1.equals(nome2)){
                    if(carrinho.get(i).getQtde() > 1){
                    carrinho.get(i).setQtde(carrinho.get(i).getQtde() - 1);
                    }
                    break;
                }
            
            }
            
            
            
            sessao.setAttribute("carrinho", carrinho);
            
           
            
            
            response.sendRedirect(request.getContextPath() + "/mostrar-carrinho");

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
