package DAO;

import bean.UsuarioBean;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO extends ConexaoDAO{

    public void incluir(UsuarioBean usuario) {
        conectar();
        String sql = "insert into coelba.solicitacao (Nome, Cpf, Telefone, Email, Cep, Numero)"
                + "values ('" + usuario.getNome() + "','" + usuario.getCpf() + "','" + usuario.getTelefone() + "','" + usuario.getEmail() + "','" + usuario.getCep() + "','" + usuario.getNumero() + "')";
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement(sql);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

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
