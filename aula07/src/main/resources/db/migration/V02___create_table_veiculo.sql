CREATE TABLE veiculo
(
    id serial primary key,
    marca varchar(20),
    modelo varchar(20),
    tipo_combustivel varchar(10),
    cor varchar(10),
    ano_fabricacao int,
    proprietario_id bigint,
    constraint fk_proprietario_id foreign key (proprietario_id)
    references proprietario (id)
)