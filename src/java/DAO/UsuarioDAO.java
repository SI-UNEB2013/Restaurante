package DAO;

import bean.ProdutoBean;
import bean.UsuarioBean;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO extends ConexaoDAO{

    public UsuarioBean incluir(UsuarioBean usuario) {
    
        String sql = "insert into restaurante.usuario (nome, senha, login, perfil)"+
                     "values ("+usuario.getNome()+","+usuario.getSenha()+","+usuario.getLogin()+","+usuario.getPerfil()+")";
        PreparedStatement stm;
        try {
            conectar();
            stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.executeUpdate();
            
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                usuario.setId(rs.getInt(1));
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger("Não foi possível inserir").log(Level.SEVERE, null, ex);
        
    }
            return usuario;
    }
    
    public UsuarioBean getByLogin(String username, String senha) {
        try {
            conectar();
            PreparedStatement preparedStatement = this.conn.prepareStatement("select * from restaurante.usario where usuario.login=? and usuario.senha=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, senha);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                UsuarioBean usuario = new UsuarioBean();
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setNome(rs.getString("nome"));
                usuario.setPerfil(rs.getString("perfil"));
                usuario.setSenha(rs.getString("senha"));
                return usuario;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
