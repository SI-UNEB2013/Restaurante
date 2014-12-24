package DAO;

import bean.Comida;
import bean.UsuarioBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ComidasDAO extends ConexaoDAO{

    public Comida incluir(Comida comida) {
        conectar();
        
        String sql = "insert into restaurante.produto (nome, codigo, foto, preco)"
                + "values ('" + comida.getNome() + "','" + comida.getCodigo() + "','" + comida.getFoto() + "','" + comida.getPreco() + "')";
        PreparedStatement stm;
        try {
            //stm = this.execute(sql);
            stm = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.executeUpdate();
            
            ResultSet rs = stm.getGeneratedKeys();
            if(rs.next()){
                comida.setIdProduto(rs.getInt(1));
            }
            
            
            sql = "insert into restaurante.comida (idproduto, ingrediente)"
                + "values ('" + comida.getIdProduto() + "','" + comida.getIngredientes() + "')";
             
            stm = this.conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stm.executeUpdate();
            rs = stm.getGeneratedKeys();
            if(rs.next()){
                comida.setId(rs.getInt(1));
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger("Erro ao salvar comida").log(Level.SEVERE, null, ex);
            comida = null;
        }
        return comida;
    }
    
    public void alterar(UsuarioBean usuario)
    {
        
    }
    
    public void excluir(){
        
    }
    /*
    public <ArrayList>ProdutoBean getList()
    {
        String sql = "seletc * from produtos";
        
    }
    
    public ProdutoBean getById(int id)
    {
        String sql = "seletc * from produtos";
        PreparedStatement stm;
    }
    */
}
