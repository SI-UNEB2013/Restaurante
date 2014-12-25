package DAO;

import bean.Comida;
import bean.ProdutoBean;
import bean.UsuarioBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComidasDAO extends ConexaoDAO {

    public Comida incluir(Comida comida) {
        conectar();

        String sql = "insert into restaurante.produto (nome, tipo, foto, preco)"
                + "values ('" + comida.getNome() + "','" + comida.getTipo() + "','" + comida.getFoto() + "','" + comida.getPreco() + "')";
        PreparedStatement stm;
        try {
            //stm = this.execute(sql);
            stm = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.executeUpdate();

            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                comida.setIdProduto(rs.getInt(1));
            }

            sql = "insert into restaurante.comida (idproduto, ingrediente)"
                    + "values ('" + comida.getIdProduto() + "','" + comida.getIngredientes() + "')";

            stm = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.executeUpdate();
            rs = stm.getGeneratedKeys();
            if (rs.next()) {
                comida.setId(rs.getInt(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger("Erro ao salvar comida").log(Level.SEVERE, null, ex);
            comida = null;
        }
        return comida;
    }

    public Comida alterar(Comida comida) {
        ProdutoDAO produtoDao = new ProdutoDAO();

        try {

            produtoDao.alterar(comida);

            conectar();

            PreparedStatement stm;

            String sql = "UPDATE restaurante.bebida SET idfornecedor = ? WHERE idproduto = ?";

            stm = this.conn.prepareStatement(sql);

            stm.setString(1, comida.getIngredientes());
            stm.setInt(2, comida.getId());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger("Erro ao salvar bebida").log(Level.SEVERE, null, ex);
            return null;
        }
        return comida;
    }

    public void excluir() {

    }
    /*
     public <ArrayList>ProdutoBean getList()
     {
     String sql = "seletc * from produtos";
        
     }
    
     */

    public Comida getById(int id) {
        ProdutoDAO produtoDao = new ProdutoDAO();
        ProdutoBean produto = produtoDao.getById(id);

        Comida comida = new Comida();

        try {
            conectar();
            PreparedStatement preparedStatement = this.conn.prepareStatement("select * from restaurante.comida where idproduto=?");
            preparedStatement.setInt(1, produto.getId());

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                comida.setIdProduto(produto.getId());
                comida.setTipo(produto.getTipo());
                comida.setNome(produto.getNome());
                comida.setFoto(produto.getFoto());
                comida.setPreco(produto.getPreco());

                comida.setIngredientes(rs.getString("ingrediente"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return comida;
    }
}
