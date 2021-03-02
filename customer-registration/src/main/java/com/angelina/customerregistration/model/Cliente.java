package com.angelina.customerregistration.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@ApiModel(description = "Representação de um cliente")
@Table(name = "TABLE_CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Id do cliente", example = "1")
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "nome")
    @ApiModelProperty(value = "Nome do cliente", example = "Angelina Cristina")
    private String nome;

    @Column(name = "idade")
    @ApiModelProperty(value = "Idade do cliente", example = "19")
    private int idade;

    @Column(name = "email")
    @ApiModelProperty(value = "Email do cliente", example = "angelina@cadmus.com.br")
    public String email;

    @Column(name = "cpf_cliente")
    @ApiModelProperty(value = "CPF do cliente", example = "222222222-22")
    public String cpf;
}
