package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.BebidasDAO;
import DAO.ComidasDAO;
import DAO.ProdutoDAO;
import bean.Bebida;
import bean.Comida;
import bean.Fornecedor;
import bean.ProdutoBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Cardapio"})
public class CardapioController extends HttpServlet {

    //páginas 
    private static String LIST = "/cliente/produtos.jsp";

    private ProdutoDAO produtoDao;

    public CardapioController() {
        super();
        this.produtoDao = new ProdutoDAO();
    }

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

        response.setContentType("text/html;charset=UTF-8");

        //verifica o tipo de produto
        String id = request.getParameter("tipo");
        request.setAttribute("produtos", produtoDao.getList());
        request.getRequestDispatcher(this.LIST).forward(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
