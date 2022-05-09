drop database banco;

create database banco;

grant all privileges on banco .* to 'root' @'localhost';

use banco;

create table enderecos(
    id int AUTO_INCREMENT,
    cidade varchar(100) not null,
    rua varchar(100) not null,
    bairro varchar(100) not null,
    numero int not null,
    cep varchar(8) not null,
    uf varchar(2) not null,
    primary key (id)
);

use banco;

create table clientes(
    id int auto_increment,
    cpf varchar(11) not null,
    nome varchar(50) not null,
    sexo varchar(1) not null,
    dataNascimento date not null default current_time,
    endereco int,
    primary key (id),
    FOREIGN KEY (endereco) REFERENCES Enderecos(id)
);

