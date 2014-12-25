package DAO;

import bean.Bebida;
import bean.Fornecedor;
import bean.ProdutoBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BebidasDAO extends ConexaoDAO {

    public Bebida incluir(Bebida bebida) {
        conectar();

        String sql = "insert into restaurante.produto (nome, tipo, foto, preco)"
                + "values ('" + bebida.getNome() + "','" + bebida.getTipo() + "','" + bebida.getFoto() + "','" + bebida.getPreco() + "')";
        PreparedStatement stm;
        try {
            //stm = this.execute(sql);
            stm = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.executeUpdate();

            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                bebida.setIdProduto(rs.getInt(1));
            }

            sql = "insert into restaurante.bebida (idproduto, idfornecedor)"
                    + "values ('" + bebida.getIdProduto() + "','" + bebida.getFornecedor().getId() + "')";

            //          stm = this.execute(sql);
            stm = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.executeUpdate();
            rs = stm.getGeneratedKeys();
            if (rs.next()) {
                bebida.setId(rs.getInt(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger("Erro ao salvar bebida").log(Level.SEVERE, null, ex);
            bebida = null;
        }
        return bebida;
    }

    public Bebida alterar(Bebida bebida) {
        ProdutoDAO produtoDao = new ProdutoDAO();

        try {

        produtoDao.alterar(bebida);
        
        conectar();
        PreparedStatement stm;
        String sql = "UPDATE restaurante.bebida SET idfornecedor = ? WHERE idproduto = ?";

        stm = this.conn.prepareStatement(sql);

        stm.setInt(1, bebida.getFornecedor().getId());
        stm.setInt(2, bebida.getId());

        stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger("Erro ao salvar bebida").log(Level.SEVERE, null, ex);
            bebida = null;
        }
        return bebida;
    }

    public void excluir(int idproduto) {

    }
    /*
     public <ArrayList>ProdutoBean getList()
     {
     String sql = "seletc * from produtos";
        
     }
     */

    public Bebida getById(int id) {
        ProdutoDAO produtoDao = new ProdutoDAO();
        ProdutoBean produto = produtoDao.getById(id);

        Bebida bebida = new Bebida();

        try {
            conectar();
            PreparedStatement preparedStatement = this.conn.prepareStatement("select * from restaurante.bebida where idproduto=?");
            preparedStatement.setInt(1, produto.getId());

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                bebida.setId(produto.getId());
                bebida.setTipo(produto.getTipo());
                bebida.setNome(produto.getNome());
                bebida.setFoto(produto.getFoto());
                bebida.setPreco(produto.getPreco());

                Fornecedor fornecedor = new Fornecedor(rs.getInt("idfornecedor"));
                bebida.setFornecedor(fornecedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return bebida;
    }

}
