package com.angelina.productregistration.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TABLE_PRODUTOS")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto")
    public Integer idProduto;

    @Column(name = "descricao")
    public String descricao;

    @Column(name = "valor_unitario")
    public float valorUnitario;
}
