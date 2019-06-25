CREATE TABLE "usuario" (
  "idusuario" int PRIMARY KEY,
  "email" varchar UNIQUE NOT NULL,
  "senha" varchar NOT NULL
);

CREATE SEQUENCE seq_usuario
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

INSERT INTO usuario(
	idusuario, email, senha)
	VALUES (nextval('seq_usuario'), 'admin', '100senha');