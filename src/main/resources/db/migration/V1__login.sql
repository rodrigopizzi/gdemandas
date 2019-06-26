CREATE TABLE "usuario" (
  "idusuario" int PRIMARY KEY,
  "email" varchar UNIQUE NOT NULL,
  "senha" varchar NOT NULL,
  "ativo" boolean NOT NULL
);

CREATE SEQUENCE seq_usuario
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

INSERT INTO usuario(
	idusuario, email, senha, ativo)
	VALUES (nextval('seq_usuario'), 'admin', '$2a$10$5YpHaJH7x89gpk5npEzYXeWGNimKE5mGt20k2UqB7626P2sTPzzbG', 1);

CREATE TABLE "permissao" (
  "idpermissao" int PRIMARY KEY,
  "idusuario" int,
  "regra" varchar NOT NULL
);

CREATE SEQUENCE seq_permissao
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER TABLE "permissao" ADD FOREIGN KEY ("idusuario") REFERENCES "usuario" ("idusuario");

INSERT INTO permissao(
	idpermissao, idusuario, regra)
	VALUES (nextval('seq_permissao'), 1, 'ADMIN');

CREATE TABLE "demanda" (
  "iddemanda" int PRIMARY KEY,
  "titulo" varchar NOT NULL,
  "descr" varchar,
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
    
CREATE SEQUENCE seq_cliente
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
    
ALTER TABLE "demanda" ADD FOREIGN KEY ("idcliente") REFERENCES "cliente" ("idcliente");
	
