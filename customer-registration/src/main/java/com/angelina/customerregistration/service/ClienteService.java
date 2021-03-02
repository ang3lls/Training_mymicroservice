package com.angelina.customerregistration.service;

import com.angelina.customerregistration.model.Cliente;
import com.angelina.customerregistration.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ValidaCPF validaCPF;


    public ValidaCPF validarCPF(String cpf){
        return validaCPF;
    }

    public Cliente gravarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente bucarClientePeloId(int id){
        return clienteRepository.getOne(id);
    }

    public List<Cliente> buscarTodosClientes(){
        return clienteRepository.findAll();
    }

}
