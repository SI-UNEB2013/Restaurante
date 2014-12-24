package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.BebidasDAO;
import DAO.ComidasDAO;
import bean.Bebida;
import bean.Comida;
import bean.Fornecedor;
import bean.ProdutoBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tarsis
 */
@WebServlet(urlPatterns = {"/CadastraProduto"})
public class CadastraProduto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastraProduto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastraProduto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
        String codigo = request.getParameter("codigo");
        String n_produto = request.getParameter("n_produto");
        String tipo = request.getParameter("tipo");
        String fornecedor_id = request.getParameter("fornecedor_id");
        String ingredientes = request.getParameter("ingredientes");
        String foto_produto = request.getParameter("foto_produto");
        Float preco = Float.parseFloat(request.getParameter("preco"));
        ProdutoBean produto;
        
        //se for comida
  
        if(tipo.equals("C")) {
            
            Comida comida = new Comida();
            comida.setCodigo(codigo);
            comida.setNome(n_produto);
            comida.setIngredientes(ingredientes);
            comida.setFoto(foto_produto);
            comida.setPreco(preco);
            ComidasDAO comidasDao = new ComidasDAO();
        
            produto = comidasDao.incluir(comida);
            
        } else {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(1);
        
            Bebida bebida = new Bebida();
            bebida.setCodigo(codigo);
            bebida.setNome(n_produto);
            bebida.setFornecedor(fornecedor);
            bebida.setFoto(foto_produto);
            bebida.setPreco(preco);
            BebidasDAO bebidaDao = new BebidasDAO();
        
            produto = bebidaDao.incluir(bebida);
        }
        
        // store bean in session
        if(produto == null) {
            request.getSession().setAttribute("result", "Não foi possível cadastrar.");
        } else {
            request.getSession().setAttribute("produto", produto);
            request.getSession().setAttribute("result", "Produto cadastrado com sucesso.");
        }
        
        

        PrintWriter out = response.getWriter();
        out.println(foto_produto);
        out.println("<h1>Cadastro realizado com sucesso</h1><br><br><hr>");
        // you now can forward to some view, for example some results.jsp
        //request.getRequestDispatcher("/cadastrarProduto.jsp").forward(request, response);
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
