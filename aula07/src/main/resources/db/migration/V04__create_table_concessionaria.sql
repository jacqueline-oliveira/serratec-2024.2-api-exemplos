CREATE TABLE concessionaria
(
    id serial primary key,
    nome varchar(20),
    logradouro varchar(50),
    numero varchar(10),
    complemento varchar(30),
    bairro varchar(30),
    cidade varchar(30),
    cep varchar(10)
)