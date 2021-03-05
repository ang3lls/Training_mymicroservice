package com.angelina.salesregistration.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ProdutoVendas")
@Data
@IdClass(ProdutoPedidoId.class)
public class ProdutoPedido {
    @Id
    @Column(name = "id_produto")
    private Integer idProduto;

    @Id
    @Column(name = "id_pedido")
    private Integer idPedido;

    @Column(name = "quantidade")
    private Integer quantidade;

}
