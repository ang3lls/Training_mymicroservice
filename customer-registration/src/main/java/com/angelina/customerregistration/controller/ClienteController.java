package com.angelina.customerregistration.controller;

import com.angelina.customerregistration.dto.ClienteDTO;
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
    private ClienteService clienteService;

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Boolean> validateCpf(@PathVariable String cpf){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.validarCPF(cpf));
    }

    @PostMapping("/save")
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.gravarCliente(cliente));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ClienteDTO> findCliente(@PathVariable int id){
        Cliente cliente = clienteService.bucarClientePeloId(id);

        ClienteDTO dto = null;
        if(cliente == null){
            dto = new ClienteDTO();
        }
        else{
            dto = new ClienteDTO(cliente.getIdCliente(), cliente.getNome(), cliente.getIdade(),
                    cliente.getEmail(), cliente.getCpf());
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/find-all")
    public List<Cliente> findAllClientes(){
        return clienteService.buscarTodosClientes();
    }
}
