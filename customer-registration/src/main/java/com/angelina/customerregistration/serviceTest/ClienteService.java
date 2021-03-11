package com.angelina.customerregistration.serviceTest;

import com.angelina.customerregistration.model.Cliente;
import com.angelina.customerregistration.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public boolean validarCPF(String cpf){
        return ValidaCPF.ok(cpf);
    }

    public Cliente gravarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente bucarClientePeloId(int id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()){
            return null;
        }

        return cliente.get();
    }

    public List<Cliente> buscarTodosClientes(){
        return clienteRepository.findAll();
    }

}
