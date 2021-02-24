package com.angelina.productregistration.model;

import javax.persistence.*;

@Entity
@Table(name = "TABLE_PRODUTOS")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto")
    public int idProduto;

    @Column(name = "descricao")
    public String descricao;

    @Column(name = "valor_unitario")
    public float valorUnitario;
}
