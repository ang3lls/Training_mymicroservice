package com.angelina.salesregistration.service;

import com.angelina.salesregistration.dto.PedidoDTO;
import com.angelina.salesregistration.dto.ProdutoDTO;
import com.angelina.salesregistration.model.Pedido;
import com.angelina.salesregistration.model.ProdutoPedido;
import com.angelina.salesregistration.model.enums.TipoPagamentoEnum;
import com.angelina.salesregistration.repository.PedidoRepository;
import com.angelina.salesregistration.repository.ProdutoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesService {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoPedidoRepository produtoPedidoRepository;
    
    public Pedido gravarPedido(PedidoDTO pedidoDTO){
        //Validar se o cliente existe

        //Validar se ids dos produtos existem

        //Aplicar o lucro de 30% sob cada produto
        List<ProdutoDTO> produtos = new ArrayList<>();
        float valorTotal = 0f;
        float valorComDesconto = 0f;

        Pedido pedido = new Pedido();

        for (ProdutoDTO produto:pedidoDTO.getIdsProdutos()) {
            produto.setValoUnitario(ajustarValordeVenda(produto.getValoUnitario()));
            produtos.add(produto);
            valorTotal += produto.getValoUnitario();
        }
        pedido.setIdsProdutos(produtos);
        //Validar o tipo de pagamento para poder aplicar o desconto
        if(TipoPagamentoEnum.Avista.name().equals(pedidoDTO.tipoPagamento)){
            valorComDesconto = valorTotal-(valorTotal*valorDoDesconto(pedidoDTO));
        }else{
            valorComDesconto = valorTotal;
        }
        pedido.setIdCliente(pedidoDTO.getIdCliente());
        pedido.setTipoPagamento(pedidoDTO.getTipoPagamento());
        pedido.setValorTotal(valorComDesconto);

        Pedido savePedido = pedidoRepository.save(pedido);
        for (ProdutoDTO produto:produtos) {
            ProdutoPedido produtoPedido = new ProdutoPedido();
            produtoPedido.setIdPedido(savePedido.getIdPedido());
            produtoPedido.setIdProduto(produto.getId());
            produtoPedido.setQuantidade(produto.getQuantidade());
            produtoPedidoRepository.save(produtoPedido);
        }

        return savePedido;
    }
    
    public Pedido buscarPedidoId(int id){
        return pedidoRepository.getOne(id);
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
