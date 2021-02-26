package com.angelina.salesregistration.service;

import com.angelina.salesregistration.model.Pedido;
import com.angelina.salesregistration.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
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
