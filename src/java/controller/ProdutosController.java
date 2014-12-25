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


@WebServlet(urlPatterns = {"/Produtos"})
public class ProdutosController extends HttpServlet {

    private static String EDIT = "/funcionario/cadastrarProduto.jsp";
    private static String LIST = "/funcionario/produtos.jsp";
    
    private ProdutoDAO produtoDao;
 
    public ProdutosController() {
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
            
            // Página de destino
            String forward="";
              
            String acao = request.getParameter("acao");

            if (acao == null || acao.equals("")) {

                //verifica o tipo de produto
                String id = request.getParameter("tipo");
                
                request.setAttribute("produtos", produtoDao.getList());
                //carrega a pagina do carrinho de compras
                request.getRequestDispatcher("/funcionario/produtos.jsp").forward(request, response);
            }
            else if (acao.equals("novoProduto")) {
                forward = EDIT;
            } 
            else if (acao.equals("editarProduto")) {
                int id = Integer.parseInt(request.getParameter("id"));
                
                ProdutoBean produto = produtoDao.getById(id);
                request.setAttribute("produto", produto);
                forward = EDIT;
                
            } else if (acao.equals("excluir")) {

            }

         RequestDispatcher view = request.getRequestDispatcher(forward);
         view.forward(request, response);
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
        ProdutoBean produto = new ProdutoBean();

        String id = request.getParameter("codigo");
        if(id == null || id.isEmpty())
        {
            this.inserirProduto(request);
        }
        else
        {
            this.alterarProduto(request);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST);
        //request.setAttribute("produto", produtoDao.getList());
        view.forward(request, response);
    }

    /**
     * Insere um produto de acordo com seu tipo
     * 
     * @param request
     * @return  ProdutoBean
     */
    public ProdutoBean inserirProduto(HttpServletRequest request) {
        
        String codigo = request.getParameter("codigo");
        String n_produto = request.getParameter("n_produto");
        String tipo = request.getParameter("tipo");
        String foto_produto = request.getParameter("foto_produto");
        Float preco = Float.parseFloat(request.getParameter("preco"));
        
        String fornecedor_id = request.getParameter("fornecedor_id");
        String ingredientes = request.getParameter("ingredientes");
        
        ProdutoBean produto;
        
        //se for comida
  
        if(tipo.equals("C")) {
            
            Comida comida = new Comida();
            //comida.setCodigo(codigo);
            comida.setTipo(tipo);
            comida.setNome(n_produto);
            comida.setFoto(foto_produto);
            comida.setPreco(preco);
            
            //especifico de comida
            comida.setIngredientes(ingredientes);
            
            ComidasDAO comidasDao = new ComidasDAO();
            produto = comidasDao.incluir(comida);
            
        } else {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(1);
        
            Bebida bebida = new Bebida();
            //bebida.setCodigo(codigo);
            bebida.setTipo(tipo);
            bebida.setNome(n_produto);
            bebida.setFoto(foto_produto);
            bebida.setPreco(preco);
            
            //especifico de bebida
            bebida.setFornecedor(fornecedor);
            
            BebidasDAO bebidaDao = new BebidasDAO();
            produto = bebidaDao.incluir(bebida);
        }
           
        return produto;
    }
   
     /**
     * altera um produto de acordo com seu tipo
     * 
     * @param request
     * @return  ProdutoBean
     */
    public void alterarProduto(HttpServletRequest request) {
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String n_produto = request.getParameter("n_produto");
        String tipo = request.getParameter("tipo");
        String foto_produto = request.getParameter("foto_produto");
        Float preco = Float.parseFloat(request.getParameter("preco"));
        
        String fornecedor_id = request.getParameter("fornecedor_id");
        String ingredientes = request.getParameter("ingredientes");
        
        if(tipo.equals(Comida.TIPO)) {
            
            ComidasDAO comidasDao = new ComidasDAO();
            Comida comida = comidasDao.getById(codigo);
            
            comida.setTipo(tipo);
            comida.setNome(n_produto);
            comida.setPreco(preco);
            if(foto_produto != null){
                comida.setFoto(foto_produto);    
            }
            //especifico de comida
            comida.setIngredientes(ingredientes);
            comidasDao.alterar(comida);
            return;
        } 
            
            BebidasDAO bebidaDao = new BebidasDAO();
            Bebida bebida = bebidaDao.getById(codigo);
            
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(1);
            
            bebida.setTipo(tipo);
            bebida.setNome(n_produto);
            bebida.setPreco(preco);
            if(foto_produto != null){
                bebida.setFoto(foto_produto);    
            }
            
            //especifico de bebida
            bebida.setFornecedor(fornecedor);
            
            bebidaDao.alterar(bebida);
            
    }
}
