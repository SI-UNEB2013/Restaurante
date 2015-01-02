/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ClienteDAO;
import DAO.PedidosDAO;
import bean.CarrinhoBean;
import bean.Pedido;
import bean.UsuarioBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tarsis
 */
@WebServlet(name = "PagamentoController", urlPatterns = {"/Pagamento"})
public class PagamentoController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             try {

                HttpSession sessao = request.getSession();

                CarrinhoBean carrinho = (CarrinhoBean) sessao.getAttribute("carrinho");
                UsuarioBean usuario = (UsuarioBean) sessao.getAttribute("usuario");

                if (usuario == null) {
                     throw new ServletException("Usuario não logado");
                }
                
                //verifica se já exista um carrinho na sessao
                if (carrinho == null || carrinho.getItens() == null) {
                      request.getRequestDispatcher("/cliente/carrinho.jsp").forward(request, response);
                }
                
                
                ClienteDAO clienteDao = new ClienteDAO();
                Pedido pedido = new Pedido();
                pedido.setCliente(clienteDao.getByUsuario(usuario));
                pedido.setItens(carrinho.getItens());
                pedido.setStatus(Pedido.STATUS_AGUARDANDO);
                pedido.setTotal(carrinho.getTotal());
                
                PedidosDAO pedidosDao =  new PedidosDAO();
                if(pedidosDao.incluir(pedido) == null) {
                    throw new ServletException("Não foi possível salvar o pedido.");
                }
                //remove o carrinho da sessão
                sessao.removeAttribute("carrinho");
                //carrega a pagina do carrinho de compras
                request.getRequestDispatcher("/cliente/carrinho.jsp").forward(request, response);

        } catch (Exception erro) {

            request.setAttribute("erro", erro);
            request.getRequestDispatcher("/erro.jsp").forward(request, response);

        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
