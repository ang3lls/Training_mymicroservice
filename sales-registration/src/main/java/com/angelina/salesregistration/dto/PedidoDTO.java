package com.angelina.salesregistration.dto;

import java.util.List;

public class PedidoDTO {
    public int id;
    public int idCliente;
    public List idsProdutos;
    public float valorTotal;
    public boolean tipoPagamento;
    public int valorDesconto;
    public float valorPagamento;

    public PedidoDTO(int id, int idCliente, List idsProdutos, float valorTotal,
                     boolean tipoPagamento, int valorDesconto, float valorPagamento) {
        this.id = id;
        this.idCliente = idCliente;
        this.idsProdutos = idsProdutos;
        this.valorTotal = valorTotal;
        this.tipoPagamento = tipoPagamento;
        this.valorDesconto = valorDesconto;
        this.valorPagamento = valorPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public List getIdsProdutos() {
        return idsProdutos;
    }

    public void setIdsProdutos(List idsProdutos) {
        this.idsProdutos = idsProdutos;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(boolean tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public int getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(int valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public float getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(float valorPagamento) {
        this.valorPagamento = valorPagamento;
    }
}
