package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class ClienteBean {

    private static final String TYPE = "C";
    
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;
    private UsuarioBean Usuario;
    
    public void ClienteBean () {
        
    }
    
    public void setUsuario(UsuarioBean usuario) {
        this.Usuario = usuario;
    }
    
    public UsuarioBean getUsuario(){
        return this.Usuario;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
