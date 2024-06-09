SELECT * FROM livraria;

CREATE TABLE Multas(
    id_multa INT NOT NULL AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    valor INT NOT NULL,
    descricao VARCHAR(455),
    PRIMARY KEY (id_multa),
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
)