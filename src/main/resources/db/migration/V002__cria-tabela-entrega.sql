CREATE TABLE entrega (
    id BIGINT AUTO_INCREMENT NOT NULL,
    cliente_id BIGINT NOT NULL,
    taxa DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    data_pedido datetime NOT NULL,
    data_finalizacao datetime,

    destinatario_nome VARCHAR(60) NOT NULL,
    destinatario_logradouro VARCHAR(255) NOT NULL,
    destinatario_numero VARCHAR(30) NOT NULL,
    destinatario_complemento VARCHAR(60) NOT NULL,
    destinatario_bairro VARCHAR(255) NOT NULL,

    CONSTRAINT pk_entrega PRIMARY KEY (id)
);

ALTER TABLE entrega ADD CONSTRAINT FK_ENTREGA_CLIENTE FOREIGN KEY (cliente_id) REFERENCES cliente (id);
