package com.angelina.salesregistration.templates;

import com.angelina.salesregistration.dto.PedidoDTO;
import com.angelina.salesregistration.dto.ProdutoPedidoDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalesBuilder {
    public static PedidoDTO getPedido(){
        List<ProdutoPedidoDTO> produtos = new ArrayList<>();
        ProdutoPedidoDTO produto = new ProdutoPedidoDTO();
        produto.setIdProduto(1);
        produto.setQuantidade(1);
        produtos.add(produto);
        return new PedidoDTO(1, produtos, "AVISTA", 15);
    }

    public static List<PedidoDTO> getPedidos(){
        List<ProdutoPedidoDTO> produtos = new ArrayList<>();
        ProdutoPedidoDTO produtoPedidoDTO = new ProdutoPedidoDTO();
        produtoPedidoDTO.setIdProduto(1);
        produtoPedidoDTO.setQuantidade(1);
        produtos.add(produtoPedidoDTO);
        return Arrays.asList(
                new PedidoDTO(1, produtos, "AVISTA", 15),
                new PedidoDTO(2,produtos,"CARTAO", 15));
    }
}
