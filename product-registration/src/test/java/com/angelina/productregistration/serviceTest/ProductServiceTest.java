package com.angelina.productregistration.serviceTest;

import com.angelina.productregistration.model.Produto;
import com.angelina.productregistration.repository.ProdutoRepository;
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
public class ProductServiceTest {
    
    @Autowired
    private ProdutoService produtoService;
    
    @MockBean
    private ProdutoRepository produtoRepository;

    @Test
    public void salvarProdutoTest(){
        Produto produtoComId = carregarProdutoSemId();
        produtoComId.setIdProduto(1);

        Mockito.when(produtoRepository.save(carregarProdutoSemId())).thenReturn(produtoComId);
        
        Produto produtoSalvo = produtoService.gravarProduto(carregarProdutoSemId());

        Assert.assertNotNull(produtoSalvo);
        Assert.assertEquals(1l, Long.parseLong(produtoSalvo.getIdProduto().toString()));
        Assert.assertEquals(5.80f,produtoSalvo.getValorUnitario(), 0.01);
    }
    
    public Produto carregarProdutoSemId(){
        Produto produto = new Produto();
        produto.setDescricao("Café Extraforte");
        produto.setValorUnitario(5.80f);
        return produto;
    }

    @Test
    public void buscarProdutoPeloIdTest(){
        Produto produtoComId = carregarProdutoSemId();
        produtoComId.setIdProduto(1);

        Mockito.when(produtoRepository.findById(1)).thenReturn(java.util.Optional.of(produtoComId));

        Produto produto = produtoService.buscarProdutoPeloID(1);

        Assert.assertNotNull(produtoComId);
        Assert.assertEquals(1l, Long.parseLong(produto.getIdProduto().toString()));
    }

    @Test
    public void buscarProdutoNuloPeloIdTest(){
        Produto produto = produtoService.buscarProdutoPeloID(1);

        Assert.assertNull(produto);
    }

    @Test
    public void buscarPorTodosOsProdutosTest(){
        List<Produto> listaProdutos = new ArrayList<>();
        Produto produto = carregarProdutoSemId();
        produto.setIdProduto(1);
        listaProdutos.add(produto);

        Mockito.when(produtoRepository.findAll()).thenReturn(listaProdutos);

        List<Produto> produtos = produtoService.buscarTodosProdutos();

        Assert.assertNotNull(produtos);
        Assert.assertEquals(listaProdutos, produtos);
    }
}
