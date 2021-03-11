drop database if exists microservico_cliente;
create database microservico_cliente;
use microservico_cliente;

create table cliente(
	id_cliente int not null auto_increment,
    nome varchar(30),
    idade int,
    email varchar(30),
    cpf varchar(15),
    primary key(id_cliente)
);

SELECT * FROM cliente;

drop database if exists microservico_produto;
create database microservico_produto;
use microservico_produto;

create table produto(
	id_produto int not null auto_increment,
    descricao varchar(100),
    valor_unitario float,
    primary key(id_produto)
);

SELECT * from produto;

drop database if exists microservico_pedido;
create database microservico_pedido;
use microservico_pedido;

create table pedido(
	id_pedido int not null auto_increment,
    id_cliente int,
    valor_total float,
    tipo_pagamento varchar(10),
    valor_desconto float,
    valor_pagamento float,
    primary key(id_pedido)
);

SELECT * from pedido;
SELECT * from produtopedido where id_pedido = 2;

drop database if exists microservico_produtopedido;
create database microservico_produtopedido.produto;
use microservico_produtopedido.produto;

create table produtopedido(
	id_pedido int not null,
    id_produto int not null,
    quantidade int,
    primary key(id_pedido, id_produto)
);