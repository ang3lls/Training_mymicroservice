package com.angelina.customerregistration.model;

import javax.persistence.*;

@Entity
@Table(name = "TABLE_CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    public int idCliente;

    @Column(name = "nome")
    public String nome;

    @Column(name = "idade")
    public int idade;

    @Column(name = "email")
    public String email;

    @Column(name = "cpf_cliente")
    public String cpf;
}
