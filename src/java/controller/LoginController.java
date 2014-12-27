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


@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");
        
        UsuarioDAO usuarioDao = new UsuarioDAO();
        UsuarioBean usuario = usuarioDao.getByLogin(username, senha);
        
        String forward = "";
        
        if (usuario.getPerfil()=="C"){
            
        }
       RequestDispatcher view = request.getRequestDispatcher(forward);
         view.forward(request, response);
    }

}