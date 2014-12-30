    package DAO;

import bean.Comida;
import bean.ItemPedidoBean;
import bean.Pedido;
import bean.ProdutoBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItensPedidoDAO extends ConexaoDAO {

    public void incluir(Pedido pedido) {

        try {
            conectar();

            String sql = "insert into restaurante.itempedido (idpedido, idproduto, valorUnitario, quantidade, valorTotal) "
                    + "values (?, ?, ?, ?, ?)";
            PreparedStatement stm;

            stm = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            List<ItemPedidoBean> itens = pedido.getItens();

            for (ItemPedidoBean item : itens) {
                stm.setInt(1, pedido.getId());
                stm.setInt(2, item.getProduto().getId());
                stm.setFloat(3, item.getProduto().getPreco());
                stm.setInt(4, item.getQtd());
                stm.setFloat(5, item.getTotal());
                stm.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println (e.getMessage());
        }
    }
}
