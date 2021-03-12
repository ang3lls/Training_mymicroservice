package com.angelina.salesregistration.controller;

import com.angelina.salesregistration.SalesRegistrationApplication;
import com.angelina.salesregistration.dto.PedidoDTO;
import com.angelina.salesregistration.repository.PedidoRepository;
import com.angelina.salesregistration.service.SalesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.angelina.salesregistration.templates.SalesBuilder;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= SalesRegistrationApplication.class)
@WebMvcTest(PedidoController.class)
public class SalesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SalesService salesService;

    @MockBean
    private PedidoRepository pedidoRepository;

    @Test
    public void deveCriarNovoPedido() throws Exception {
        PedidoDTO pedidoDTO = SalesBuilder.getPedido();
        mockMvc.perform(MockMvcRequestBuilders.post("/Pedido/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(pedidoDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void deveBuscarPedidoPorId() throws Exception {
        PedidoDTO pedidoDTO = SalesBuilder.getPedido();
        mockMvc.perform(MockMvcRequestBuilders.get("/Pedido/id/{id}", 1)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(pedidoDTO)))
                .andExpect(status().isOk());

    }

    @Test
    public void deveBuscarTodosOsPedidos() throws Exception{
        List<PedidoDTO> pedidosDTO = SalesBuilder.getPedidos();
        mockMvc.perform(MockMvcRequestBuilders.get("/Pedido/find-all")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(pedidosDTO)))
                .andExpect(status().isOk());
    }

}
