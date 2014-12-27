package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDAO {

    Connection conn;
    protected String database = "restaurante";
    protected String user = "root";
    protected String password = "12345678";

    public void conectar() {
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost", this.user, this.password);
            
            //this.conn.setSchema(this.database);
            //ver se funciona

            
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

    public PreparedStatement execute(String sql) throws SQLException {
        PreparedStatement stm;

        stm = this.conn.prepareStatement(sql);
        stm.executeUpdate();
        stm.close();
        return stm;
    }
}
