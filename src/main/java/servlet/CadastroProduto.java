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
import java.sql.Date;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilherme.gcosta6
 */
@WebServlet(name = "CadastroProduto", urlPatterns = {"/cadastro-produto"})
public class CadastroProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String destino;

        HttpSession sessao = request.getSession();
        
        if(sessao.getAttribute("usuario") == null){
             RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/loginBack.jsp");
            dispatcher.forward(request, response);
        }

        if (sessao.getAttribute("produto") != null) {

            request.setAttribute("mensagem", "Produto cadastrado ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/CadastroProduto.jsp");
            dispatcher.forward(request, response);

            destino = "cadastro.jsp";

        } else {

            destino = "CadastroProduto.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      HttpSession sessao = request.getSession();
       if(sessao.getAttribute("usuario") == null){
             RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/loginBack.jsp");
            dispatcher.forward(request, response);
        }
      if(sessao.getAttribute("usuario") != null){
        String nomeProduto = request.getParameter("nomeProduto");
        String descricao = request.getParameter("descricao");
        String c1 = request.getParameter("c1");
        String c2 = request.getParameter("c2");
        String c3 = request.getParameter("c3");
        String c4 = request.getParameter("c4");
        String c5 = request.getParameter("c5");
        String c6 = request.getParameter("c6");
        String categoria = request.getParameter("categoria");
        double valorProduto = Double.parseDouble(request.getParameter("valorProduto"));
        String img = request.getParameter("img");
        String imgV1 = request.getParameter("imgV1");
        String imgV2 = request.getParameter("imgV2");
        String imgV3 = request.getParameter("imgV3");
        String imgC1 = request.getParameter("imgC1");
        String imgC2 = request.getParameter("imgC2");
        String imgC3 = request.getParameter("imgC3");

        Produto produto = new Produto(nomeProduto, descricao, valorProduto, c1, c2, c3, c4, c5, c6, categoria, img, imgV1,imgV2,imgV3,imgC1,imgC2,imgC3);

            try {
                ProdutoDAO.inserirProduto(produto);
            } catch (Exception e) {
                e.printStackTrace();
            }

            request.setAttribute("mensagem", "Produto cadastrado ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/cadastro.jsp");
            dispatcher.forward(request, response);
      }else{
          RequestDispatcher dispatcher
                = request.getRequestDispatcher("loginBack.jsp");
        dispatcher.forward(request, response);
      }

    }
}
