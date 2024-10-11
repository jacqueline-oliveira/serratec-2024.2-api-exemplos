CREATE TABLE concessionaria_veiculo (
    concessionaria_id INT NOT NULL,
    veiculo_id INT NOT NULL,
    PRIMARY KEY (concessionaria_id, veiculo_id),
    FOREIGN KEY (concessionaria_id) REFERENCES concessionaria(id) ON DELETE CASCADE,
    FOREIGN KEY (veiculo_id) REFERENCES veiculo(id) ON DELETE CASCADE
);