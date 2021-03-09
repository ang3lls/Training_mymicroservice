package com.angelina.salesregistration.model;

import com.angelina.salesregistration.dto.ClienteDTO;
import com.angelina.salesregistration.dto.ProdutoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ApiModel(description = "Representação de um pedido feito por um cliente")
@Table(name = "pedido")
public class Pedido {

    @Id
    @ApiModelProperty(value = "Id do pedido", example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    public Integer idPedido;

    @Transient
    public ClienteDTO cliente_id;

    @Column(name = "id_cliente")
    private Integer idCliente;

    @Transient
    public List<ProdutoDTO> idsProdutos;

    @ApiModelProperty(value = "Valor do pedido", example = "5,60")
    @Column(name = "valor_total")
    public float valorTotal;

    @ApiModelProperty(value = "Tipo do pagamento", example = "AVISTA, CARTAO")
    @Column(name = "tipo_pagamento")
    public String tipoPagamento;

    @ApiModelProperty(value = "Valor de desconto", example = "15")
    @Column(name = "valor_desconto")
    public float valorDesconto;

    @ApiModelProperty(value = "Valor total do pagamento", example = "20,50")
    @Column(name = "valor_pagamento")
    public float valorPagamento;
}
