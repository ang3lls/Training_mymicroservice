package com.angelina.customerregistration.jmx;

import com.angelina.customerregistration.model.Cliente;
import com.angelina.customerregistration.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ManagedResource
public class ClienteServiceJmx {

    @Autowired
    private ClienteService clienteService;

    @ManagedOperation(description = "Consulta do cliente pelo id")
    @ManagedOperationParameter(
            name = "Id", description = "Id identificador do cliente. Ex.: 1")
    public String buscarClientePeloId(Integer id){
        Cliente cliente = clienteService.bucarClientePeloId(id);
        if(cliente == null){
            return "Cliente não existe";
        }
        return cliente.getNome();
    }

    @ManagedOperation(description = "Salvar cliente")
    @ManagedOperationParameter(
            name = "nome", description = "Nome completo do cliente. Ex.: Angelina Cristina")
    @ManagedOperationParameter(
            name = "idade", description = "Idade do cliente. Ex.: 19")
    @ManagedOperationParameter(
            name = "email", description = "Email do cliente. Ex.: angelina@cadmus.com.br")
    @ManagedOperationParameter(
            name = "cpf", description = "CPF do cliente. Ex.: 222222222-22")
    public String salvarCliente(String nome, int idade, String email, String cpf){
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setIdade(idade);
        cliente.setEmail(email);
        cliente.setCpf(cpf);

        try {
            Cliente clienteSalvo = clienteService.gravarCliente(cliente);
            return "Cliente salvo com sucesso! " + clienteSalvo.getNome();
        }catch (Exception ex){
            return "Não foi possivel gravar o cliente! " + ex.getMessage();
        }
    }

    @ManagedOperation(description = "Buscar todos os clientes")
    public List<Cliente> buscarTodosOsClientes(){
        return (List<Cliente>) clienteService.buscarTodosClientes();
    }

}
