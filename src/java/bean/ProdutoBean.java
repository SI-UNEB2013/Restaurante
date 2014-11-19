package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tarsis
 */
public class ProdutoBean {

    private String codigo;
    private String n_produto;
    private String ingredientes;
    private String foto_produto;

    public void ProdutoBean() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getN_produto() {
        return n_produto;
    }

    public void setN_produto(String n_produto) {
        this.n_produto = n_produto;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getFoto_produto() {
        return foto_produto;
    }

    public void setFoto_produto(String foto_produto) {
        this.foto_produto = foto_produto;
    }
}
