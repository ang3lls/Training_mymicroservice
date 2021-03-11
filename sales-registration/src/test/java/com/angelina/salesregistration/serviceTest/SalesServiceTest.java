package com.angelina.salesregistration.serviceTest;

import com.angelina.salesregistration.dto.ClienteDTO;
import com.angelina.salesregistration.dto.PedidoDTO;
import com.angelina.salesregistration.dto.ProdutoDTO;
import com.angelina.salesregistration.dto.ProdutoPedidoDTO;
import com.angelina.salesregistration.model.Pedido;
import com.angelina.salesregistration.repository.PedidoRepository;
import com.angelina.salesregistration.repository.ProdutoPedidoRepository;
import com.angelina.salesregistration.restTemplate.RequestCustomer;
import com.angelina.salesregistration.restTemplate.RequestProduct;
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
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalesServiceTest {

    @Autowired
    private SalesService salesService;

    @MockBean
    private PedidoRepository pedidoRepository;

    @MockBean
    private ProdutoPedidoRepository produtoPedidoRepository;

    @MockBean
    private RequestCustomer requestCustomer;

    @MockBean
    private RequestProduct requestProduct;

    @Test
    public void salvarPedidoTest() throws Exception {
        Pedido pedidoComId = carregarPedidoSemId();
        pedidoComId.setIdPedido(1);

        Mockito.when(pedidoRepository.save(any())).thenReturn(pedidoComId);

        PedidoDTO pedidoDTO = carregarPedidoDTO();

        ClienteDTO clienteComId = carregarClienteSemId();
        clienteComId.setId(1);

        ProdutoDTO produtoComID = carregarProdutoSemId();
        produtoComID.setIdProduto(1);

        Mockito.when(requestCustomer.consultarClienteById(pedidoDTO.getIdCliente())).thenReturn(clienteComId);
        Mockito.when(requestProduct.consultarProdutoById(produtoComID.getIdProduto())).thenReturn(produtoComID);

        Pedido pedidoSalvo = salesService.gravarPedido(carregarPedidoDTO());

        Assert.assertNotNull(pedidoSalvo);
        Assert.assertEquals(pedidoSalvo, pedidoComId);
    }

    private ClienteDTO carregarClienteSemId() {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome("Angelina");
        clienteDTO.setIdade(19);
        clienteDTO.setEmail("angelina@cadmus.com.br");
        clienteDTO.setCpf("47397074898");
        return clienteDTO;
    }

    private ProdutoDTO carregarProdutoSemId() {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setDescricao("Café Expresso");
        produtoDTO.setQuantidade(1);
        produtoDTO.setValorUnitario(5f);
        return produtoDTO;
    }

    private PedidoDTO carregarPedidoDTO() {
        PedidoDTO pedidoDTO = new PedidoDTO();
        List<ProdutoPedidoDTO> produtoDTOS = new ArrayList<>();
        ProdutoPedidoDTO produtoPedidoDTO = new ProdutoPedidoDTO();
        produtoPedidoDTO.setIdProduto(1);
        produtoPedidoDTO.setQuantidade(1);
        produtoDTOS.add(produtoPedidoDTO);
        pedidoDTO.setProdutos(produtoDTOS);
        pedidoDTO.setTipoPagamento("AVISTA");
        pedidoDTO.setValorDesconto(15);

        return pedidoDTO;
    }

    public Pedido carregarPedidoSemId(){
        Pedido pedido = new Pedido();
        pedido.setIdCliente(1);
        List<ProdutoDTO> produtoDTOS = new ArrayList<>();
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setIdProduto(1);
        produtoDTO.setDescricao("Café Expresso");
        produtoDTO.setQuantidade(1);
        produtoDTO.setValorUnitario(5f);
        produtoDTOS.add(produtoDTO);
        pedido.setIdsProdutos(produtoDTOS);
        pedido.setValorTotal(10f);
        pedido.setTipoPagamento("AVISTA");
        pedido.setValorDesconto(15);
        pedido.getValorPagamento();
        return pedido;
    }

    //@Test
    public void testParaPedidoComClienteNulo() throws Exception {
        ClienteDTO clienteDTO = null;

        Pedido pedidoComId = carregarPedidoSemId();
        pedidoComId.setIdPedido(1);

        Mockito.when(pedidoRepository.save(any())).thenReturn(pedidoComId);

        PedidoDTO pedidoDTO = carregarPedidoDTO();

        ClienteDTO clienteComId = carregarClienteSemId();
        clienteComId.setId(1);

        ProdutoDTO produtoComID = carregarProdutoSemId();
        produtoComID.setIdProduto(1);

        Mockito.when(requestCustomer.consultarClienteById(pedidoDTO.getIdCliente())).thenReturn(clienteComId);
        Mockito.when(requestProduct.consultarProdutoById(produtoComID.getIdProduto())).thenReturn(produtoComID);

        Pedido pedidoSalvo = salesService.gravarPedido(carregarPedidoDTO());

        Assert.assertNull(clienteDTO);

    }

    @Test
    public void buscarPedidosPorIdTest(){
        Pedido pedidoComId = carregarPedidoSemId();
        pedidoComId.setIdPedido(1);

        Mockito.when(pedidoRepository.findById(any())).thenReturn(java.util.Optional.of(pedidoComId));

        Pedido buscarPedido = salesService.buscarPedidoId(1);

        Assert.assertNotNull(buscarPedido);
        Assert.assertEquals(Optional.of(1l), Optional.of(buscarPedido.getIdPedido()));
    }

    @Test
    public void buscarPedidoNuloPeloIdTest(){
        Pedido pedidoNulo = salesService.buscarPedidoId(1);

        Assert.assertNull(pedidoNulo);
    }

    @Test
    public void buscarPorTodosOsPedidosTest(){
        List<Pedido> listaPedidos = new ArrayList<>();
        Pedido pedido =  carregarPedidoSemId();
        pedido.setIdPedido(1);
        listaPedidos.add(pedido);

        Mockito.when(pedidoRepository.findAll()).thenReturn(listaPedidos);

        List<Pedido> pedidos = salesService.buscarTodosPedidos();

        Assert.assertNotNull(pedidos);
        Assert.assertEquals(listaPedidos, pedidos);
    }
}
