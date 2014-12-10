package DAO;

import bean.Bebida;
import bean.UsuarioBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BebidasDAO extends ConexaoDAO{

    public Bebida incluir(Bebida bebida) {
        conectar();
        
        String sql = "insert into restaurante.produto (nome, codigo, foto, preco)"
                + "values ('" + bebida.getNome() + "','" + bebida.getCodigo() + "','" + bebida.getFoto() + "','" + bebida.getPreco() + "')";
        PreparedStatement stm;
        try {
            //stm = this.execute(sql);
            stm = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.executeUpdate();
            
            ResultSet rs = stm.getGeneratedKeys();
            if(rs.next()){
                bebida.setIdProduto(rs.getInt(1));
            }
            
            
//            stm.close();

            
             
            sql = "insert into restaurante.bebida (idproduto, idfornecedor)"
                + "values ('" + bebida.getIdProduto() + "','" + bebida.getFornecedor().getId() + "')";
             
  //          stm = this.execute(sql);
              stm = this.conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stm.executeUpdate();
            rs = stm.getGeneratedKeys();
            if(rs.next()){
                bebida.setId(rs.getInt(1));
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger("Erro ao salvar bebida").log(Level.SEVERE, null, ex);
            bebida = null;
        }
        return bebida;
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
