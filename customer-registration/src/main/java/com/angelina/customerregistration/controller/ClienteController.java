package com.angelina.customerregistration.controller;

import com.angelina.customerregistration.model.Cliente;
import com.angelina.customerregistration.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Cliente> validateCpf(@PathVariable String cpf){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.validarCPF(cpf));
    }

    @PostMapping("/save")
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.gravarCliente(cliente));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Cliente> findCliente(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.FOUND).body(clienteService.bucarClientePeloId(id));
    }

    @GetMapping("/find-all")
    public List<Cliente> findAllClientes(){
        return clienteService.buscarTodosClientes();
    }
}
