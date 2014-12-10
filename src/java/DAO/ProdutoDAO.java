package DAO;

import bean.ProdutoBean;
import bean.UsuarioBean;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProdutoDAO extends ConexaoDAO{

    public int incluir(ProdutoBean usuario) {
        conectar();
        
        String sql = "insert into coelba.solicitacao (Nome, Cpf, Telefone, Email, Cep, Numero)"
                + "values ('" + usuario.getNome() + "','" + usuario.getCpf() + "','" + usuario.getTelefone() + "','" + usuario.getEmail() + "','" + usuario.getCep() + "','" + usuario.getNumero() + "')";
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
