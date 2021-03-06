CREATE TABLE PRODUTOS (
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT pk_produto PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    descricao VARCHAR(500) NOT NULL,
    precoVenda DECIMAL(11,2) NOT NULL,
    precoCompra DECIMAL(11,2) NOT NULL,
    categoria BIGINT NOT NULL,
    imagem VARCHAR(500) NOT NULL,
    dataCriacao TIMESTAMP NOT NULL );

