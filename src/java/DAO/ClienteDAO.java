package DAO;

import bean.ClienteBean;
import bean.UsuarioBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO extends ConexaoDAO {

    public void incluir(ClienteBean cliente, UsuarioBean usuario){
        conectar();
        String sql = "insert into restaurante.cliente (cpf, endereço, telefone, email)"+
                     "values ("+cliente.getCpf()+","+cliente.getEndereco()+","+cliente.getTelefone()+","+cliente.getEmail()+")";
                     
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement(sql);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger("Não foi possível inserir").log(Level.SEVERE, null, ex);
        
    }
        String sql1 = "insert into restaurante.usuario (nome, senha, login, perfil)"+
                     "values ("+usuario.getNome()+","+usuario.getSenha()+","+usuario.getLogin()+","+usuario.getPerfil()+")";
        PreparedStatement stm1;
        try {
            stm1 = conn.prepareStatement(sql);
            stm1.executeUpdate();
            stm1.close();
        } catch (SQLException ex) {
            Logger.getLogger("Não foi possível inserir").log(Level.SEVERE, null, ex);
        
    }
        
    }
}
        
    

