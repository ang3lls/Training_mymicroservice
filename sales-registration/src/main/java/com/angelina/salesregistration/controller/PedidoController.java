package com.angelina.salesregistration.controller;

import com.angelina.salesregistration.dto.PedidoDTO;
import com.angelina.salesregistration.model.Pedido;
import com.angelina.salesregistration.service.SalesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Sales")
@RequestMapping("/Pedido")
public class PedidoController {

    @Autowired
    private SalesService salesService;

    @ApiOperation(value = "Salvar pedido feito por Cliente")
    @PostMapping("/save")
    public ResponseEntity<Pedido> savePedido(@RequestBody @ApiParam(name = "Corpo", value =
            "Representação de um novo pedido") PedidoDTO pedido) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(salesService.gravarPedido(pedido));
    }

    @ApiOperation(value = "Buscar pedido feito por Cliente")
    @GetMapping("/id/{id}")
    public ResponseEntity<Pedido> findPedido(@PathVariable @ApiParam (value =
            "Id de um pedido", example = "1") int id){
        return ResponseEntity.status(HttpStatus.OK).body(salesService.buscarPedidoId(id));
    }

    @ApiOperation(value = "Buscar todos os pedidos")
    @GetMapping("/find-all")
    public List<Pedido> findAllPedidos(){
        return salesService.buscarTodosPedidos();
    }
}
