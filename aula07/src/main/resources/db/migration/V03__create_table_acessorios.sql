CREATE TABLE acessorio
(
    id serial primary key,
    descricao varchar(20),
    informacao varchar(20),
    veiculo_id bigint,
    constraint fk_acessorio_veiculo foreign key (veiculo_id)
    references veiculo (id)
)