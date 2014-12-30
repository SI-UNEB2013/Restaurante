/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;

public class Pedido {
    
    public static String STATUS_AGUARDANDO = "Aguardando atendimento";
    public static String STATUS_PRODUCAO = "Em produção";
    public  static String STATUS_CONCLUIDO = "Concluído";
    public static String  STATUS_CANCELADO = "Cancelado";
    
    private int id;
    private ClienteBean cliente;
    private String status;
    private float total;
    private List<ItemPedidoBean> itens;
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteBean getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBean cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
     public List<ItemPedidoBean> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoBean> itens) {
        this.itens = itens;
    }
}
