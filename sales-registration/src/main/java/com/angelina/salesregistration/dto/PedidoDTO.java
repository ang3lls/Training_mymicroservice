package com.angelina.salesregistration.dto;


import java.util.List;

public class PedidoDTO {
    public int idCliente;
    public List<ProdutoPedidoDTO> produtos;
    public String tipoPagamento;
    public int valorDesconto;


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public List<ProdutoPedidoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoPedidoDTO> produtos) {
        this.produtos = produtos;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public int getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(int valorDesconto) {
        this.valorDesconto = valorDesconto;
    }
}
