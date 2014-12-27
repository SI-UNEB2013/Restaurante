package DAO;

import bean.ProdutoBean;
import bean.UsuarioBean;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO extends ConexaoDAO{

    public void incluir(UsuarioBean usuario) {
        conectar();
        String sql = "insert into restaurante.usuario (nome, senha, login, perfil)"+
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

    public void conectar() {
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost", "root", "root");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println(c.getMessage());
        } catch (InstantiationException i) {
            System.out.println(i.getMessage());
        } catch (IllegalAccessException il) {
            System.out.println(il.getMessage());
        }
    }

}
