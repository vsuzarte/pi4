/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
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
import model.Cliente;
import model.Venda;

/**
 *
 * @author guilherme.gcosta6
 */
@WebServlet(name = "AlterarStatusVenda", urlPatterns = {"/alterar-status-venda"})
public class AlterarStatusVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
  int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");
        
        
        
                
              
        
            try {
                VendaDAO.alterarStatus(id,status);
            } catch (Exception e) {
                e.printStackTrace();
            }

           
            

            request.setAttribute("mensagem", "Cadastrado ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/consultar-venda-back");
            dispatcher.forward(request, response);
        

    }
}
