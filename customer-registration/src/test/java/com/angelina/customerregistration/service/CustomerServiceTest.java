package com.angelina.customerregistration.service;

import com.angelina.customerregistration.model.Cliente;
import com.angelina.customerregistration.repository.ClienteRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private ClienteService clienteService;

    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    public void salvarClienteTest(){
        //Preparar o retorno do test - clienteComId
        Cliente clienteComId = carregarClienteSemId();
        clienteComId.setIdCliente(1);

        //Dizer para ele o que precisar ser retornado no metodo mockado
        Mockito.when(clienteRepository.save(carregarClienteSemId())).thenReturn(clienteComId);

        //Executar o metodo a ser testado e capturar o retorno - cliente salvo
        Cliente clienteSalvo = clienteService.gravarCliente(carregarClienteSemId());

        //Testar o retorno obtido
        //se ele não é nulo
        Assert.assertNotNull(clienteSalvo.getIdCliente());
        //se o id do cliente é 1
        Assert.assertEquals(1l, Long.parseLong(clienteSalvo.getIdCliente().toString()));
        //se a idade do cliente é 19
        Assert.assertEquals(19, clienteSalvo.getIdade());
        //se o nome do cliente é o esperado
        Assert.assertEquals("Angelina", clienteSalvo.getNome());
    }

    //Método para instanciar um objeto Cliente, criando um cliente para testar
    public Cliente carregarClienteSemId(){
        Cliente cliente = new Cliente();
        cliente.setNome("Angelina");
        cliente.setIdade(19);
        cliente.setEmail("angelina@cadmus.com.br");
        cliente.setCpf("47397074898");
        return cliente;
    }

    @Test
    public void buscarClientePeloIdTest(){
        //Preparar o retorno do test - clienteComId
        Cliente clienteComId = carregarClienteSemId();
        clienteComId.setIdCliente(1);

        //Dizer para ele que precisar retornar o cliente com id 1 no metodo mockado
        Mockito.when(clienteRepository.findById(1)).thenReturn(java.util.Optional.of(clienteComId));

        //Executar o metodo a ser testado(clienteService) e capturar o retorno(1) - no cliente
        Cliente cliente = clienteService.bucarClientePeloId(1);

        //Testar o retorno - se ele não é nulo
        Assert.assertNotNull(cliente);
        Assert.assertEquals(1l, Long.parseLong(cliente.getIdCliente().toString()));
    }

    @Test
    public void buscarClienteNuloPeloId(){
        //Executar o método a ser testado e buscar pelo id 1
        Cliente cliente = clienteService.bucarClientePeloId(1);
        //no casso não foi dado nenhum retorno, então ele é nulo
        Assert.assertNull(cliente);
    }

    @Test
    public void buscarTodosOsClientes(){
        //Criação de lista para o retorno
        List<Cliente> listaClientes = new ArrayList<>();
        Cliente cliente = carregarClienteSemId();
        cliente.setIdCliente(1);
        listaClientes.add(cliente);

        //Dizer para ele que precisa retornar a lista de clientes no metodo mockado
        Mockito.when(clienteRepository.findAll()).thenReturn(listaClientes);

        //Executar o método a ser testado e pegar o seu retorno em forma de lista
        List<Cliente> clientes = clienteService.buscarTodosClientes();

        //testar os retornos
        Assert.assertNotNull(clientes);
        Assert.assertEquals(listaClientes, clientes);
    }

    @Test
    public void validaCpfClienteTest(){
        Cliente clienteComId = carregarClienteSemId();
        clienteComId.setIdCliente(1);

        Mockito.when(clienteRepository.save(carregarClienteSemId())).thenReturn(clienteComId);

        boolean clienteValidaCpf = clienteService.validarCPF("47397074898");

        Assert.assertTrue(clienteValidaCpf);
        Assert.assertEquals("47397074898", clienteComId.getCpf());
    }
}
