package com.angelina.productregistration.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@ApiModel(description = "Representação de um produto")
@Table(name = "TABLE_PRODUTOS")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Id do produto", example = "1")
    @Column(name = "id_produto")
    public Integer idProduto;

    @ApiModelProperty(value = "Descrição do produto", example = "Mouse Dell Conexão Wireless - WM126")
    @Column(name = "descricao")
    public String descricao;

    @ApiModelProperty(value = "Valor unitario do produto", example = "99,00")
    @Column(name = "valor_unitario")
    public float valorUnitario;
}
