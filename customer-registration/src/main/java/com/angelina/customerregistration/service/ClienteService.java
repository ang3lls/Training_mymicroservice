package com.angelina.customerregistration.service;

import com.angelina.customerregistration.dto.ClienteDTO;
import com.angelina.customerregistration.model.Cliente;
import com.angelina.customerregistration.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private Cliente Cliente;


    public Cliente validarCPF(String cpf){
        if(cpf.equals(cpf)){
            return Cliente;
        }
        return null;
    }

    public Cliente gravarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente bucarClientePeloId(int id){
        Cliente cliente = clienteRepository.getOne(id);
        return Cliente;
    }

    public List<Cliente> buscarTodosClientes(){
        return clienteRepository.findAll();
    }

}
