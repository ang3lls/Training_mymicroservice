drop database if exists microservico_cliente;
create database microservico_cliente;
use microservico_cliente;

create table Cliente(
	id_cliente int not null auto_increment,
    nome varchar(30),
    idade int,
    email varchar(30),
    primary key(id_cliente)
);

SELECT * FROM Cliente;

drop database if exists microservico_produto;
create database microservico_produto;
use microservico_produto;

create table Produto(
	id_produto int not null auto_increment,
    descricao varchar(100),
    valor_unitario bigint(20),
    primary key(id_produto)
);

drop database if exists microservico_vendas;
create database microservico_vendas;
use microservico_vendas;

create table Vendas(
	id_venda int not null auto_increment,
    id_cliente int,
    valor_total float,
    tipo_pagamento boolean,
    valor_desconto int,
    valor_pagamento float,
    primary key(id_venda)
);

create table ProdutoVendas(
	id_venda int not null,
    id_produto int not null,
    quantidade int,
    primary key(id_venda, id_produto)
);