package com.angelina.salesregistration.model;

import com.angelina.salesregistration.dto.ClienteDTO;
import com.angelina.salesregistration.dto.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "TABLE_PEDIDO_VENDA")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pedido")
    public Integer idPedido;

    @Transient
    public ClienteDTO cliente_id;

    @Transient
    public List<ProdutoDTO> idsProdutos;

    @Column(name = "valor_total")
    public float valorTotal;

    @Column(name = "tipo_pagamento")
    public boolean tipoPagamento;

    @Column(name = "valor_desconto")
    public int valorDesconto;

    @Column(name = "valor_pagamento")
    public float valorPagamento;
}
