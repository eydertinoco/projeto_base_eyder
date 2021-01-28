-- DROP SCHEMA impact;

CREATE SCHEMA impact AUTHORIZATION postgres;

-- impact.usuario definition

-- Drop table

-- DROP TABLE impact.usuario;

CREATE TABLE impact.usuario (
	id serial NOT NULL,
    email varchar(60) unique not null,
	senha varchar(30) not null,
	nome varchar(80) NOT NULL,
	genero varchar(1) not null,
	dataNasc date not null,
	dataCriacao date not null DEFAULT now(),
	dataEdicao date not null DEFAULT now(),
	CONSTRAINT usuario_pk PRIMARY KEY (id)
);

-- impact.historia definition

-- Drop table

-- DROP TABLE impact.historia;

CREATE TABLE impact.historia (
	id serial NOT NULL,
	titulo varchar(5000) NOT NULL,
	idadeIndicativa varchar(2) NOT NULL,
	id_usuario int4 NOT NULL,
	CONSTRAINT historia_pk PRIMARY KEY (id),
	CONSTRAINT usuario_fk FOREIGN KEY (id_usuario) REFERENCES impact.usuario(id)
);

CREATE TABLE impact.capitulo (
    id serial not null,
    numero int not null,
    nome varchar(100) not null,
    campoHistoria varchar not null,
    id_historia int4 nor null,
    CONSTRAINT capitulo_pk PRIMARY KEY (id),
    CONSTRAINT historia_fk foreign key (id_historia) references impact.historia(id)
);