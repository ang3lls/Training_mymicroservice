package com.angelina.salesregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoPedidoId implements Serializable {
    private Integer idProduto;
    private Integer idPedido;
}
