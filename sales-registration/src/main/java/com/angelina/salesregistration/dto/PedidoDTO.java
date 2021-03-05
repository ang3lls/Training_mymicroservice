package com.angelina.salesregistration.dto;

import com.angelina.salesregistration.model.enums.TipoPagamentoEnum;

import java.util.List;

public class PedidoDTO {
    public int idCliente;
    public List<ProdutoDTO> idsProdutos;
    public String tipoPagamento;
    public int valorDesconto;

    public PedidoDTO(int idCliente, List<ProdutoDTO> idsProdutos, String tipoPagamento, int valorDesconto) {
        this.idCliente = idCliente;
        this.idsProdutos = idsProdutos;
        this.tipoPagamento = tipoPagamento;
        this.valorDesconto = valorDesconto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public List<ProdutoDTO> getIdsProdutos() {
        return idsProdutos;
    }

    public void setIdsProdutos(List<ProdutoDTO> idsProdutos) {
        this.idsProdutos = idsProdutos;
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
