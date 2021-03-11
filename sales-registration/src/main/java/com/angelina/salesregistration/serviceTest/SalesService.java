package com.angelina.salesregistration.serviceTest;

import com.angelina.salesregistration.dto.ClienteDTO;
import com.angelina.salesregistration.dto.PedidoDTO;
import com.angelina.salesregistration.dto.ProdutoDTO;
import com.angelina.salesregistration.dto.ProdutoPedidoDTO;
import com.angelina.salesregistration.model.Pedido;
import com.angelina.salesregistration.model.ProdutoPedido;
import com.angelina.salesregistration.model.enums.TipoPagamentoEnum;
import com.angelina.salesregistration.repository.PedidoRepository;
import com.angelina.salesregistration.repository.ProdutoPedidoRepository;
import com.angelina.salesregistration.restTemplate.RequestCustomer;
import com.angelina.salesregistration.restTemplate.RequestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalesService {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoPedidoRepository produtoPedidoRepository;

    @Autowired
    private RequestCustomer requestCustomer;

    @Autowired
    private RequestProduct requestProduct;
    
    public Pedido gravarPedido(PedidoDTO pedidoDTO) throws Exception {
        //Validar se o cliente existe
        ClienteDTO clienteDTO = requestCustomer.consultarClienteById(pedidoDTO.getIdCliente());
        if(clienteDTO == null && clienteDTO.getId() < 1){
            throw new Exception("Usuário não encontrado");
        }

        //Validar se ids dos produtos existem


        //Aplicar o lucro de 30% sob cada produto
        List<ProdutoDTO> produtos = new ArrayList<>();
        float valorTotal = 0f;
        float valorDoPagamento = 0f;
        float valorDoDesconto = 0f;

        Pedido pedido = new Pedido();
        pedido.setCliente_id(clienteDTO);

        for (ProdutoPedidoDTO produto:pedidoDTO.getProdutos()) {
            ProdutoDTO produtoDTO = requestProduct.consultarProdutoById(produto.getIdProduto());
            if(produtoDTO.getIdProduto() == null){
                throw new Exception("Produto não encontrado");
            }
            produtoDTO.setValorUnitario(ajustarValordeVenda(produtoDTO.getValorUnitario()));
            produtoDTO.setQuantidade(produto.getQuantidade());
            produtos.add(produtoDTO);
            valorTotal += (produtoDTO.getValorUnitario()*produto.getQuantidade());
        }
        pedido.setIdsProdutos(produtos);
        //Validar o tipo de pagamento para poder aplicar o desconto
        if(TipoPagamentoEnum.AVISTA.name().equals(pedidoDTO.tipoPagamento)){
            //calcular o valor do desconto do produto (ex: R$10,00 e 10% desconto, total = R$1,00)
            valorDoDesconto = calcularValorDoDesconto(pedidoDTO.getValorDesconto(),valorTotal);
            //calcular o valor do pagamento (ex: R$10,00 - R$1,00 = R$9,00)
            valorDoPagamento = calcularValorDoPagamento(valorTotal, valorDoDesconto);
        }else{
            valorDoPagamento = valorTotal;
        }
        pedido.setIdCliente(pedidoDTO.getIdCliente());
        pedido.setTipoPagamento(pedidoDTO.getTipoPagamento());
        pedido.setValorTotal(valorTotal);
        pedido.setValorDesconto(valorDoDesconto);
        pedido.setValorPagamento(valorDoPagamento);

        Pedido savePedido = pedidoRepository.save(pedido);
        for (ProdutoDTO produto:produtos) {
            ProdutoPedido produtoPedido = new ProdutoPedido();
            produtoPedido.setIdPedido(savePedido.getIdPedido());
            produtoPedido.setIdProduto(produto.getIdProduto());
            produtoPedido.setQuantidade(produto.getQuantidade());
            produtoPedidoRepository.save(produtoPedido);
        }

        return savePedido;
    }

    private float calcularValorDoPagamento(float valorTotal, float valorDoDesconto) {
        return valorTotal-valorDoDesconto;
    }

    private float calcularValorDoDesconto(float valorDesconto, float valorTotal) {
        return valorTotal*(valorDesconto/100);
    }

    public Pedido buscarPedidoId(int id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if(pedido.isEmpty()){
            return null;
        }

        return pedido.get();
    }
    
    public List<Pedido> buscarTodosPedidos(){
        return pedidoRepository.findAll();
    }

    public float ajustarValordeVenda(float valorProduto){
        return (valorProduto*0.3f) + valorProduto;
    }

    public int valorDoDesconto(PedidoDTO pedido){
        return pedido.getValorDesconto()/100;
    }

}
