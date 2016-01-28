INSERT INTO `grupo`(`id`,`descricao`,`nome`)VALUES('1', 'Administradores', 'Administradores');
INSERT INTO `grupo`(`id`,`descricao`,`nome`)VALUES('2', 'Vendedores', 'Vendedores');
INSERT INTO `grupo`(`id`,`descricao`,`nome`)VALUES('3', 'Auxiliares', 'Auxiliares');
INSERT INTO `grupo`(`id`,`descricao`,`nome`)VALUES('999999', '', '');

INSERT INTO `empresa` (`id`, `cnpj`, `nomeFantasia`, `razaoSocial`) VALUES ('', '11.111.111/111-11', 'Creiare Infromática Ltd.', 'Edeserson de Souza Selvati');
INSERT INTO `endereco` (`cep`, `cidade`, `complemento`, `logradouro`, `numero`, `uf`) VALUES ('37.200-000', 'LAVRAS', 'casa', ' R. FRANCISCO JOSÉ DE LIMA', '86', 'MG');
INSERT INTO `empresa` (`id`, `nomeFantasia`, `razaoSocial`) VALUES ('999999', 'Master', 'Master');

INSERT INTO `pessoa`(`doc_receita_federal`,`email`,`fisica_juridica`,`nome`)VALUES('263.828.398-33', 'eber.slasso@gmail.com','FISICA', 'Eber Spulveda Lasso');
INSERT INTO `endereco` (`cep`, `cidade`, `complemento`, `logradouro`, `numero`, `uf`) VALUES ('37260000', 'Perdões', 'casa', 'R. laura Toledo de Vilela', '98', 'MG');


INSERT INTO `usuario`(`id`,`email`,`nome`,`senha`,`username`,`empresa_id`) VALUES ('1', 'elenice@uol.com.br', 'Elenice Pimenta Fidelis Lasso', '789', 'elenice','1');
INSERT INTO `usuario`(`id`,`email`,`nome`,`senha`,`username`,`empresa_id`) VALUES('2', 'eber.lasso@gmail.com', 'Eber Spulveda Lasso', 'b59c67bf196a4758191e42f76670ceba', 'eber','1');
INSERT INTO `usuario`(`id`,`email`,`nome`,`senha`,`username`,`empresa_id`) VALUES('3', 'isabel@yahoo.com.br', 'Isabel Fidelis Lasso', '456', 'isabel','1');
INSERT INTO `usuario`(`id`,`email`,`nome`,`senha`,`username`,`empresa_id`) VALUES('999999', '', 'Master', '', 'master','999999');
UPDATE `usuario` SET `senha`='202cb962ac59075b964b07152d234b70' WHERE `id`='1';
UPDATE `usuario` SET `senha`='202cb962ac59075b964b07152d234b70' WHERE `id`='3';


INSERT INTO `categoria` (`descricao`) VALUES ('Software');
INSERT INTO `categoria` (`descricao`) VALUES ('Hardware');

INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Computador', '2');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Impressora Fiscal', '2');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Gaveta', '2');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Sia', '1');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('PDV', '1');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Pedidos', '1');

