package DAO;

import bean.Bebida;
import bean.Comida;
import bean.ProdutoBean;
import bean.UsuarioBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO extends ConexaoDAO {

    public void alterar(ProdutoBean produto) {

        try {
            conectar();

            String sql = "UPDATE restaurante.produto SET nome = ?, tipo=?, foto =?, preco= ? WHERE produto.id = ?";

            PreparedStatement stm;
            stm = this.conn.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setString(2, produto.getTipo());
            stm.setString(3, produto.getFoto());
            stm.setFloat(4, produto.getPreco());
            stm.setInt(5, produto.getId());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger("Erro ao salvar bebida").log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public void excluir() {

    }

    public List<ProdutoBean> getList() {
        List<ProdutoBean> produtos;
        produtos = new ArrayList<ProdutoBean>();
        try {
            conectar();
            Statement statement = this.conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from restaurante.produto");
            while (rs.next()) {
                ProdutoBean produto = new ProdutoBean();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setFoto(rs.getString("foto"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }

    public ProdutoBean getById(int id) {
        try {
            conectar();
            PreparedStatement preparedStatement = this.conn.prepareStatement("select * from restaurante.produto where produto.id=?");
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                ProdutoBean produto = new ProdutoBean();
                produto.setId(rs.getInt("id"));
                produto.setTipo(rs.getString("tipo"));
                produto.setNome(rs.getString("nome"));
                produto.setFoto(rs.getString("foto"));
                produto.setPreco(rs.getFloat("preco"));
                return produto;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
