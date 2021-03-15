package com.angelina.customerregistration.controller;

import com.angelina.customerregistration.CustomerRegistrationApplication;
import org.junit.jupiter.api.Test;
import com.angelina.customerregistration.dto.ClienteDTO;
import com.angelina.customerregistration.repository.ClienteRepository;
import com.angelina.customerregistration.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.angelina.customerregistration.templates.CustomerBuilder;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes= CustomerRegistrationApplication.class)
@WebMvcTest(ClienteController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClienteService clienteService;

    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    public void deveCriarUmNovoCliente() throws Exception {
        ClienteDTO clienteDTO = CustomerBuilder.getCliente();
        mockMvc.perform(MockMvcRequestBuilders.post("/cliente/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void deveBuscarClientePorId() throws Exception{
        ClienteDTO clienteDTO = CustomerBuilder.getCliente();
        mockMvc.perform(MockMvcRequestBuilders.get("/cliente/id/{id}", 1)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void deveBuscarTodosOsClientes() throws Exception {
        List<ClienteDTO> clientes = CustomerBuilder.getClientes();
        mockMvc.perform(MockMvcRequestBuilders.get("/cliente/find-all")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(clientes)))
                .andExpect(status().isOk());

    }

    @Test
    public void deveBuscarClientePeloCPF() throws Exception {
        ClienteDTO clienteDTO = CustomerBuilder.getCliente();
        mockMvc.perform(MockMvcRequestBuilders.get("/cliente/cpf/{cpf}", "47397074898")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(status().isOk());
    }

}
