package DAO;

import bean.Comida;
import bean.Pedido;
import bean.ProdutoBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidosDAO extends ConexaoDAO {

    public Pedido incluir(Pedido pedido) {
        try {
            conectar();
            
            String sql = "insert into restaurante.pedido (idcliente, status, total) values (?, ?, ?)";
            PreparedStatement stm;
            
            stm = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, pedido.getCliente().getUsuario().getId());
            stm.setString(2, pedido.getStatus());
            stm.setFloat(3, pedido.getTotal());
            
            stm.executeUpdate();

            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                pedido.setId(rs.getInt(1));
            }
            ItensPedidoDAO itensDao = new ItensPedidoDAO();
            itensDao.incluir(pedido);

        } catch (SQLException e) {
            System.out.println (e.getMessage());
            pedido = null;
        }
        return pedido;
    }

    public void alterarStatus(Pedido pedido) {
        
        String sql = "UPDATE restaurante.pedido SET status = ? WHERE id = ?";
        try {
            conectar();

            PreparedStatement stm;

            stm = this.conn.prepareStatement(sql);

            stm.setString(1, pedido.getStatus());
            stm.setInt(2, pedido.getId());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println (e.getMessage());
        }
    }

    public void excluir() {

    }
    /*
     public <ArrayList>ProdutoBean getList()
     {
     String sql = "seletc * from produtos";
        
     }
    
     */

    public Pedido getById(int id) {
        
        try {
            conectar();
            PreparedStatement preparedStatement = this.conn.prepareStatement("select * from restaurante.pedido where id=?");
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            
            Pedido pedido = new Pedido();
            if (rs.next()) {
                pedido.setId(rs.getInt("id"));
                pedido.setStatus(rs.getString("status"));
                pedido.setTotal(rs.getFloat("total"));
            }
            return pedido;
            
        } catch (SQLException e) {
                System.out.println (e.getMessage());
            return null;
        }
    }
    
    public Pedido getByStatus(String status) {
        
        try {
            conectar();
            PreparedStatement preparedStatement = this.conn.prepareStatement("select * from restaurante.pedido where status=?");
            preparedStatement.setString(1, status);

            ResultSet rs = preparedStatement.executeQuery();
            
            Pedido pedido = new Pedido();
            if (rs.next()) {
                pedido.setId(rs.getInt("id"));
                pedido.setStatus(rs.getString("status"));
                pedido.setTotal(rs.getFloat("total"));
            }
            return pedido;
            
        } catch (SQLException e) {
                System.out.println (e.getMessage());
            return null;
        }
    }
}
