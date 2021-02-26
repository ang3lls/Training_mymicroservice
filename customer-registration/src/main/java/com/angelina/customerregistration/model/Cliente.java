package com.angelina.customerregistration.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TABLE_CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(name = "email")
    public String email;

    @Column(name = "cpf_cliente")
    public String cpf;
}
