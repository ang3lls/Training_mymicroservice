package com.angelina.productregistration.controller;

import com.angelina.productregistration.ProductRegistrationApplication;
import com.angelina.productregistration.dto.ProdutoDTO;
import com.angelina.productregistration.repository.ProdutoRepository;
import com.angelina.productregistration.serviceTest.ProdutoService;
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
import com.angelina.productregistration.templates.ProductBuilder;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ProductRegistrationApplication.class)
@WebMvcTest(ProdutoController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProdutoService produtoService;

    @MockBean
    private ProdutoRepository produtoRepository;

    @Test
    public void deveSalvarNovoProduto() throws Exception{
        ProdutoDTO produtoDTO = ProductBuilder.getProduto();
        mockMvc.perform(MockMvcRequestBuilders.post("/Produto/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(produtoDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void deveBuscarProdutoPorId() throws Exception{
        ProdutoDTO produtoDTO = ProductBuilder.getProduto();
        mockMvc.perform(MockMvcRequestBuilders.get("/Produto/id/{id}", 1)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(produtoDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void deveBuscarTodosOsProdutos() throws Exception{
        List<ProdutoDTO> clientes = ProductBuilder.getProdutos();
        mockMvc.perform(MockMvcRequestBuilders.get("/Produto/find-all")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(clientes)))
                .andExpect(status().isOk());
    }
}
