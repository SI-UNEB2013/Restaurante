package DAO;

import bean.Bebida;
import bean.ProdutoBean;
import bean.UsuarioBean;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BebidasDAO extends ConexaoDAO{

    public int incluir(Bebida bebida) {
        conectar();
        
        String sql = "insert into produto (nome, codigo, foto, preco)"
                + "values ('" + bebida.getNome() + "','" + bebida.getCodigo() + "','" + bebida.getFoto() + "','" + usuario.getPreco() + "')";
        PreparedStatement stm;
        try {
            stm = this.execute(sql);
           
        } catch (SQLException ex) {
           // Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return stm.getGeneratedKeys().getInt("id");
    }
    
    public void alterar(UsuarioBean usuario)
    {
        
    }
    
    public void excluir(){
        
    }
    
    public <ArrayList>ProdutoBean getList()
    {
        String sql = "seletc * from produtos";
    }
    
    public ProdutoBean getById(int id)
    {
        String sql = "seletc * from produtos";
        PreparedStatement stm;
    }
}
