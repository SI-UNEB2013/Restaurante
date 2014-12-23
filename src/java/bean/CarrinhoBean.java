package bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tarsis
 */
public class CarrinhoBean {

    private List<ItemPedidoBean> itens;
    private Integer qtd;
    private ClienteBean cliente;
    private float total;
    
    public void addNovoItem(ItemPedidoBean item){
        if(this.itens == null){
            this.itens = new ArrayList<ItemPedidoBean>();
        }
        this.itens.add(item);
    }
    
    public void removeItem(ItemPedidoBean item){
           for(Iterator i = itens.iterator(); i.hasNext();){
               i.remove();
           }
    }
    
    public float calculaTotal()
    {
        float vTotal =0;
        for(ItemPedidoBean item: this.itens){
            vTotal += item.getTotal();
        }
        this.total = vTotal;
        return total;
    }
    
    public List<ItemPedidoBean> getItens()
    {
        return this.itens;
    }
    
    public float getTotal()
    {
        return this.total;
    }
}
