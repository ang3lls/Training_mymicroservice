package com.angelina.salesregistration.controller;

import com.angelina.salesregistration.model.Pedido;
import com.angelina.salesregistration.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pedido")
public class PedidoController {

    @Autowired
    SalesService salesService;

    @PostMapping("/save")
    public ResponseEntity<Pedido> savePedido(@RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.CREATED).body(salesService.gravarPedido(pedido));
    }

    @GetMapping()
    public ResponseEntity<Pedido> findPedido(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.FOUND).body(salesService.buscarPedidoId(id));
    }

    @GetMapping()
    public List<Pedido> findAllPedidos(){
        return salesService.buscarTodosPedidos();
    }
}
