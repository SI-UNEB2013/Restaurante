package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.ClienteDAO;
import DAO.UsuarioDAO;
import DAO.ComidasDAO;
import bean.ClienteBean;
import bean.UsuarioBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

    public ClienteBean inserirCliente(HttpServletRequest request) {
        
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String perfil = request.getParameter("perfil");
        
        UsuarioBean usuario = new UsuarioBean();
        
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setPerfil(perfil);
        
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereço");
        String telefone = request.getParameter("telefone");
       
        ClienteBean cliente = new ClienteBean();
        
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);
        cliente.setUsuario(usuario);
        
        ClienteDAO clienteDao = new ClienteDAO();
            clienteDao.incluir(cliente);
        UsuarioDAO usuarioDao = new UsuarioDAO();
            usuarioDao.incluir(usuario);
            
            
        return cliente;
    }

}