package com.angelina.salesregistration.model;

import javax.persistence.*;

@Entity
@Table(name = "TABLE_PEDIDO_VENDA")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pedido")
    public int idPedido;

    @OneToMany
    @JoinColumn(name = "id_cliente")
    public int idCliente;

    //@OneToMany
   // @JoinColumn(name = "lista_ids_produtos")
    //public List<Produto> idsProdutos;

    @Column(name = "valor_total")
    public float valorTotal;

    @Column(name = "tipo_pagamento")
    public boolean tipoPagamento;

    @Column(name = "valor_desconto")
    public int valorDesconto;

    @Column(name = "valor_pagamento")
    public float valorPagamento;
}
