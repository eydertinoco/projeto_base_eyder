INSERT INTO impact.usuario (usuario,senha,email,nome, genero, dataNasc)
VALUES ('teste','123','adm@teste.com','ADM', 'M', '10/01/2000');

INSERT INTO impact.historia (titulo,idadeIndicativa,id_usuario) VALUES
('O grande TESTE!','10',1)
('Piramide Teste','18',1);

INSERT INTO impact.capitulo (numero, nome, campoHistoria, id_historia) VALUE
(1, 'Incio da Jornada', 'Era uma vez um garoto que morreu.', 1)
(1, 'Incio da Piramide', 'Escravos montam a Piramide.', 2)
(2, 'Meio da Piramide', 'A piramide está quase pronta.', 2)
(3, 'Fim da Piramide', 'Jogaram o Faraó lá dentro.', 2);