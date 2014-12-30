package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.ClienteDAO;
import DAO.UsuarioDAO;
import DAO.UsuarioDAO;
import bean.ClienteBean;
import bean.ProdutoBean;
import bean.UsuarioBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginController", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");
        
        UsuarioDAO usuarioDao = new UsuarioDAO();
        UsuarioBean usuario = usuarioDao.getByLogin(username, senha);
        if(usuario == null) {
            request.setAttribute("error", "Usuário ou senha incorretos.");
            request.getRequestDispatcher("/cliente/logincliente.jsp").forward(request, response);
            return;
        }
        HttpSession sessao = request.getSession();
        String forward = "";
        
        if (usuario.getPerfil().equals("C")) {
            ClienteDAO clienteDao = new ClienteDAO();
             
             ClienteBean cliente = clienteDao.getByUsuario(usuario);
             sessao.setAttribute("usuario", usuario);
             sessao.setAttribute("cliente", cliente);
             forward = "/cliente/telaPagamento.jsp";
             response.sendRedirect(request.getContextPath()+"/cliente/telaPagamento.jsp");
             return;
        } else {
            request.setAttribute("error", "Perfil incorreto " + usuario.getPerfil());
            request.getRequestDispatcher("/cliente/logincliente.jsp").forward(request, response);
            forward = "/cliente/telaPagamento.jsp";
            request.getRequestDispatcher(forward).forward(request, response);
            //return ;
        }
    }

}