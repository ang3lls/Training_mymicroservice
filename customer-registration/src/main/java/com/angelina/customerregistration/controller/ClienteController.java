package com.angelina.customerregistration.controller;

import com.angelina.customerregistration.model.Cliente;
import com.angelina.customerregistration.service.ClienteService;
import com.angelina.customerregistration.service.ValidaCPF;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Customer")
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @ApiOperation(value = "Buscar cliente pelo cpf")
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ValidaCPF> validateCpf(@PathVariable @ApiParam
            (name = "CPF", value = "CPF de um cliente", example = "222222222-22") String cpf){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.validarCPF(cpf));
    }

    @ApiOperation(value = "Salvar cliente")
    @PostMapping("/save")
    public ResponseEntity<Cliente> saveCliente(@RequestBody @ApiParam
            (name = "corpo", value = "Representação de um novo cliente") Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.gravarCliente(cliente));
    }

    @ApiOperation(value = "Bucar cliente pelo id")
    @GetMapping("/id/{id}")
    public ResponseEntity<Cliente> findCliente(@PathVariable @ApiParam (value =
            "Id de um cliente", example = "1") int id){
        return ResponseEntity.status(HttpStatus.FOUND).body(clienteService.bucarClientePeloId(id));
    }

    @ApiOperation(value = "Buscar todos clientes")
    @GetMapping("/find-all")
    public List<Cliente> findAllClientes(){
        return clienteService.buscarTodosClientes();
    }
}
