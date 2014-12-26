package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.BebidasDAO;
import DAO.ProdutoDAO;
import bean.Bebida;
import bean.CarrinhoBean;
import bean.Fornecedor;
import bean.ItemPedidoBean;
import bean.ProdutoBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/ControlaCarrinho"})
public class ControlaCarrinho extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {

            String acao = request.getParameter("acao");

            if (acao.equals("addProduto")) {

                //recupera o id do produto que deve ser add no carrinho
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));

                //flag para controle de inserção de novos produtos no carrinho
                boolean existe = false;

                //recupera a sessão pertencente ao request
                HttpSession sessao = request.getSession();

                //recupera um carrinho de produtos da sessão
                //se não exite um carrinho na sessão o valor será igual a null
                CarrinhoBean carrinho = (CarrinhoBean) sessao.getAttribute("carrinho");

                //verifica se já exista um carrinho na sessao
                if (carrinho == null) {

                    //cria um carrinho 
                    carrinho = new CarrinhoBean();

                    sessao.setAttribute("carrinho", carrinho);
                }

                //verifica se o produto existe no carrinho
                if (carrinho.getItens() != null) {

                    for (ItemPedidoBean item : carrinho.getItens()) {

                        if (item.getProduto().getId() == idProduto) {

                            //incrementa a quantidade
                            item.setQtd(item.getQtd()+ 1);
                            carrinho.calculaTotal();
                            existe = true;

                        }
                    }
                }

                //se não existe o item ou produto, cria um novo
                if (existe == false) {

                    //encontra o produto no banco
                    ProdutoBean produto = new ProdutoDAO().getById(idProduto);

                    //cria um novo item
                    ItemPedidoBean novoItem = new ItemPedidoBean();

                    novoItem.setProduto(produto);

                    novoItem.setQtd(1);
                    //adiciona novo item
                    carrinho.addNovoItem(novoItem);
                    carrinho.calculaTotal();    
                }

                //carrega a pagina do carrinho de compras
                request.getRequestDispatcher("/cliente/carrinho.jsp").forward(request, response);

            }//fim addProduto
            else if (acao.equals("removeProduto")) {

                //recupera a sessão pertencente ao request
                HttpSession sessao = request.getSession();

                //recupera um carrinho de produtos da sessão
                CarrinhoBean carrinho = (CarrinhoBean) sessao.getAttribute("carrinho");

                //recupera o id do produto  
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));

                ItemPedidoBean itemRemove = new ItemPedidoBean();

                ProdutoBean prodRemove = new ProdutoBean();

                prodRemove.setId(idProduto);

                itemRemove.setProduto(prodRemove);

                carrinho.removeItem(itemRemove);

                //carrega a pagina do carrinho de compras
                request.getRequestDispatcher("carrinho.jsp").forward(request, response);

            } else if (acao.equals("cancelaCompra")) {

                //recupera a sessão pertencente ao request
                HttpSession sessao = request.getSession();

                //remove o carrinho da sessão
                sessao.removeAttribute("carrinho");

                //redireciona para pagina principal
                response.sendRedirect("index.jsp");
            }

        } catch (Exception erro) {

            request.setAttribute("erro", erro);

            request.getRequestDispatcher("/erro.jsp").forward(request, response);

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
        if (tipo == "C") {

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
        if (produto == null) {
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
