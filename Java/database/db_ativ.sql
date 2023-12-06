CREATE DATABASE db_ativ;

USE db_ativ;

CREATE TABLE produtos (
    codigo INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    quantidade_estoque INT NOT NULL,
    preco_unitario DOUBLE NOT NULL,
    fornecedor VARCHAR(255) NOT NULL,
    marca VARCHAR(255)
);

CREATE TABLE clientes (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL
);