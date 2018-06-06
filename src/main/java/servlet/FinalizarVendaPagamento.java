/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;



import dao.ItemVendaDAO;
import dao.VendaDAO;
import model.Venda;
import java.io.IOException;
import java.io.PrintWriter;
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
import model.ItemVenda;

/**
 *
 * @author gabriel.sleal1
 */
@WebServlet(name = "FinalizarVendaPagamento", urlPatterns = {"/finalizar-venda-pagamento"})
public class FinalizarVendaPagamento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        String cartao = request.getParameter("cartao");
        Cliente cliente = (Cliente) sessao.getAttribute("cliente");
        if(sessao.getAttribute("cliente") == null){
             RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/login.jsp");
             dispatcher.forward(request, response);
        }else{
            
            if(cliente.getRuaCliente() == null){
               RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/cadastrarEndereco.jsp");
             dispatcher.forward(request, response);
            }
            
           
           
           List<ItemVenda> carrinho = (List<ItemVenda>) sessao.getAttribute("carrinho");
           double total = 0;
            for(int i = 0; i < carrinho.size(); i++){
                total += carrinho.get(i).getValor();
            }
   
            try {
                Venda venda = VendaDAO.realizarVenda(cliente.getIdCliente(), total, cartao);
                venda.setStatus("pendente");
                           

                for(int i = 0; i < carrinho.size(); i++){
                    
                    ItemVendaDAO.inserirItemVenda(venda.getId(), carrinho.get(i).getIdProduto(), carrinho.get(i).getQtde());
                    
                }
                
                
            } catch (Exception ex) {
                Logger.getLogger(FinalizarVendaPagamento.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            carrinho = null;
            sessao.setAttribute("carrinho", carrinho);
             RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/mostrar-compras");
             dispatcher.forward(request, response);
          
        }

        
       

       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

}
}
