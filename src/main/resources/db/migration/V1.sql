-- Script para criar a tabela PhotoBlob
CREATE TABLE PHOTO_BLOB (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    hash VARCHAR(255)
);

-- Script para criar a tabela PhotoSap
CREATE TABLE PHOTO_SAP (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    hash INTEGER
);

INSERT INTO PHOTO_BLOB (id, hash) VALUES (1, '123');
INSERT INTO PHOTO_BLOB (id, hash) VALUES (2, '456');
INSERT INTO PHOTO_BLOB (id, hash) VALUES (3, '789');
INSERT INTO PHOTO_BLOB (id, hash) VALUES (4, '101112');
INSERT INTO PHOTO_BLOB (id, hash) VALUES (5, '131415');
INSERT INTO PHOTO_BLOB (id, hash) VALUES (6, '161718');
INSERT INTO PHOTO_BLOB (id, hash) VALUES (7, '192021');
INSERT INTO PHOTO_BLOB (id, hash) VALUES (8, '222324');
