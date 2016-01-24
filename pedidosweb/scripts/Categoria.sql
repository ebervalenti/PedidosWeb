INSERT INTO `categoria` (`descricao`) VALUES ('Informatica');
INSERT INTO `categoria` (`descricao`) VALUES ('Eletrodomésticos');
INSERT INTO `categoria` (`descricao`) VALUES ('Móveis');


INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Computadores', '1');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Notebooks', '1');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Tablets', '1');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Impressoras', '1');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Acessórios', '1');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Ar Condicionado', '2');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Fogões', '2');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Fornos Elétricos', '2');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Microondas', '2');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Refrigeradores', '2');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Cadeiras', '3');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Mesas', '3');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Racks', '3');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Sofás', '3');

INSERT INTO `grupo`(`id`,`descricao`,`nome`)VALUES('1', 'Administradores', 'Administradores');
INSERT INTO `grupo`(`id`,`descricao`,`nome`)VALUES('2', 'Vendedores', 'Vendedores');
INSERT INTO `grupo`(`id`,`descricao`,`nome`)VALUES('3', 'Auxiliares', 'Auxiliares');
INSERT INTO `grupo`(`id`,`descricao`,`nome`)VALUES('999999', '', '');
INSERT INTO `usuario_grupo` (`usuario_id`, `grupo_id`) VALUES ('1', '1');
INSERT INTO `usuario_grupo` (`usuario_id`, `grupo_id`) VALUES ('2', '2');
INSERT INTO `usuario_grupo` (`usuario_id`, `grupo_id`) VALUES ('3', '3');
INSERT INTO `usuario_grupo` (`usuario_id`, `grupo_id`) VALUES ('4', '4');


INSERT INTO `usuario`(`id`,`email`,`nome`,`senha`,`username`) VALUES ('1', 'elenice@uol.com.br', 'Elenice Pimenta Fidelis Lasso', '789', 'elenice');
INSERT INTO `usuario`(`id`,`email`,`nome`,`senha`,`username`) VALUES('2', 'eber.lasso@gmail.com', 'Eber Spulveda Lasso', 'b59c67bf196a4758191e42f76670ceba', 'eber');
INSERT INTO `usuario`(`id`,`email`,`nome`,`senha`,`username`) VALUES('3', 'isabel@yahoo.com.br', 'Isabel Fidelis Lasso', '456', 'isabel');
INSERT INTO `usuario`(`id`,`email`,`nome`,`senha`,`username`) VALUES('999999', '', 'Master', '', 'master');
UPDATE `usuario` SET `senha`='202cb962ac59075b964b07152d234b70' WHERE `id`='1';
UPDATE `usuario` SET `senha`='202cb962ac59075b964b07152d234b70' WHERE `id`='3';
UPDATE `usuario` SET `empresa_id`='1' WHERE `id`='1';
UPDATE `usuario` SET `empresa_id`='1' WHERE `id`='2';
UPDATE `usuario` SET `empresa_id`='1' WHERE `id`='3';
UPDATE `usuario` SET `empresa_id`='999999' WHERE `id`='999999';


INSERT INTO `empresa` (`id`, `cnpj`, `nomeFantasia`, `razaoSocial`) VALUES ('', '11.111.111/111-11', 'Creiare Infromática Ltd.', 'Edeserson de Souza Selvati');
INSERT INTO `endereco` (`cep`, `cidade`, `complemento`, `logradouro`, `numero`, `uf`) VALUES ('37.200-000', 'LAVRAS', 'casa', ' R. FRANCISCO JOSÉ DE LIMA', '86', 'MG');
INSERT INTO `empresa` (`id`, `nomeFantasia`, `razaoSocial`) VALUES ('999999', 'Master', 'Master');

INSERT INTO `pessoa`(`doc_receita_federal`,`email`,`fisica_juridica`,`nome`)VALUES('263.828.398-33', 'eber.slasso@gmail.com','FISICA', 'Eber Spulveda Lasso');
INSERT INTO `endereco` (`cep`, `cidade`, `complemento`, `logradouro`, `numero`, `uf`) VALUES ('37260000', 'Perdões', 'casa', 'R. laura Toledo de Vilela', '98', 'MG');

INSERT INTO `produto`(`id`,`nome`,`qtd_estoque`,`sku`,`valor_unitario`,`categoria_id`)VALUES('2', 'Notebook ItauTec', '10', 'NOT1234', '3000.00', '5');
INSERT INTO `produto`(`id`,`nome`,`qtd_estoque`,`sku`,`valor_unitario`,`categoria_id`)VALUES('3', 'TV LG 42\" Smart', '1', 'TLG1235', '100.00', '5');
INSERT INTO `produto`(`id`,`nome`,`qtd_estoque`,`sku`,`valor_unitario`,`categoria_id`)VALUES('4', 'Celular Samsung 2', '440', 'CSS1236', '800.00', '5');
INSERT INTO `produto`(`id`,`nome`,`qtd_estoque`,`sku`,`valor_unitario`,`categoria_id`)VALUES('5', 'Sofá Bartira', '99', 'SBT1237', '100.00', '5');

INSERT INTO `categoria` (`descricao`) VALUES ('Software');
INSERT INTO `categoria` (`descricao`) VALUES ('Hardware');
INSERT INTO `categoria` (`descricao`) VALUES ('Móveis');


INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Computador', '2');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Impressora Fiscal', '2');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Gaveta', '2');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Sia', '2');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('PDV', '2');
INSERT INTO `categoria` (`descricao`, `categoria_pai_id`) VALUES ('Pedidos', '2');






