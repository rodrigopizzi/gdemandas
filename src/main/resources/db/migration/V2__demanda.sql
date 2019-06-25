CREATE TABLE "demanda" (
  "iddemanda" int PRIMARY KEY,
  "titulo" varchar NOT NULL,
  "descr" text,
  "status" int NOT NULL,
  "idcliente" int
);

CREATE SEQUENCE seq_demanda
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE TABLE "cliente" (
  "idcliente" int PRIMARY KEY,
  "nome" varchar UNIQUE NOT NULL
);

ALTER TABLE "demanda" ADD FOREIGN KEY ("idcliente") REFERENCES "cliente" ("idcliente");

CREATE SEQUENCE seq_cliente
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;