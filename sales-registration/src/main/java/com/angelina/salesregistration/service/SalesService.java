package com.angelina.salesregistration.service;

import com.angelina.salesregistration.model.Pedido;
import com.angelina.salesregistration.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SalesService {
    
    @Autowired
    PedidoRepository pedidoRepository;
    
    public Pedido gravarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    
    public Pedido buscarPedidoId(int id){
        return pedidoRepository.getOne(id);
    }
    
    public List<Pedido> buscarTodosPedidos(){
        return pedidoRepository.findAll();
    }
}
