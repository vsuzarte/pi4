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
import java.util.List;
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
@WebServlet(name = "ConsultarVendaBack", urlPatterns = {"/consultar-venda-back"})
public class ConsultarVendaBack extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         HttpSession sessao = request.getSession();
        try {

            String nome = request.getParameter("nome");

            

            if (nome == null || nome.equals("")) {
                List<Venda> listaVenda = VendaDAO.listarVendas();
                sessao.setAttribute("listaVendaBack", listaVenda);
                response.sendRedirect(request.getContextPath() + "/consultarVenda.jsp");
            }else{
                
            Cliente cliente = ClienteDAO.procurarCliente(nome);
            List<Venda> listaVenda = VendaDAO.consultarVenda(cliente.getIdCliente());
      

            sessao.setAttribute("listaVendaBack", listaVenda);
            response.sendRedirect(request.getContextPath() + "/consultarVenda.jsp");
            }

        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        try {

            String nome = request.getParameter("nome");

            

            if (nome == null || nome.equals("")) {
                List<Venda> listaVenda = VendaDAO.listarVendas();
                sessao.setAttribute("listaVendaBack", listaVenda);
                response.sendRedirect(request.getContextPath() + "/consultarVenda.jsp");
            }else{
                
            Cliente cliente = ClienteDAO.procurarCliente(nome);
            List<Venda> listaVenda = VendaDAO.consultarVenda(cliente.getIdCliente());
      

            sessao.setAttribute("listaVendaBack", listaVenda);
            response.sendRedirect(request.getContextPath() + "/consultarVenda.jsp");
            }

        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");

        }

    }

}
