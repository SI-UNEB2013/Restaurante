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

    public void incluir(ClienteBean cliente){
        conectar();
        //String sql = "insert into restaurante.cliente (cpf, endereço, telefone, email, idusuario)"+
        //             "values ("+cliente.getCpf()+","+cliente.getEndereco()+","+cliente.getTelefone()+","+cliente.getEmail()+","+cliente.getUsuario().getUsuarioId()+")";
        
        String sql = "insert into restaurante.cliente (cpf, endereco, telefone, email, idusuario) values ( ?, ?, ?, ?, ?)";
                     
        PreparedStatement stm;
            
        try {
            stm = conn.prepareStatement(sql);
            
            stm.setString(1, cliente.getCpf());
            stm.setString(2, cliente.getEndereco());
            stm.setString(3, cliente.getTelefone());
            stm.setString(4, cliente.getEmail());
            stm.setInt(5, cliente.getUsuario().getId());
            
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            System.out.println (e.getMessage());    
      }
    }
    
    
       public ClienteBean getByUsuario(UsuarioBean usuario) {
        
        try {
            conectar();
            PreparedStatement preparedStatement = this.conn.prepareStatement("select * from restaurante.cliente where idusuario=?");
            preparedStatement.setInt(1, usuario.getId());

            ResultSet rs = preparedStatement.executeQuery();
            
            ClienteBean cliente = new ClienteBean();
            if (rs.next()) {
                cliente.setUsuario(usuario);
                
            }
            return cliente;
            
        } catch (SQLException e) {
                System.out.println (e.getMessage());
            return null;
        }
    }
}
        
    

