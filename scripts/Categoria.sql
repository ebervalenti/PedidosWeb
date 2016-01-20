INSERT INTO `valentidb`.`categoria` (`descricao`) VALUES ('Informatica');
INSERT INTO `valentidb`.`categoria` (`descricao`) VALUES ('Eletrodomésticos');
INSERT INTO `valentidb`.`categoria` (`descricao`) VALUES ('Móveis');


INSERT INTO `valentidb`.`categoria` (`descricao`, `categoria_pai_id`) VALUES ('Computadores', '1');
INSERT INTO `valentidb`.`categoria` (`descricao`, `categoria_pai_id`) VALUES ('Notebooks', '1');
INSERT INTO `valentidb`.`categoria` (`descricao`, `categoria_pai_id`) VALUES ('Tablets', '1');
INSERT INTO `valentidb`.`categoria` (`descricao`, `categoria_pai_id`) VALUES ('Impressoras', '1');
INSERT INTO `valentidb`.`categoria` (`descricao`, `categoria_pai_id`) VALUES ('Acessórios', '1');
INSERT INTO `valentidb`.`categoria` (`descricao`, `categoria_pai_id`) VALUES ('Ar Condicionado', '2');
INSERT INTO `valentidb`.`categoria` (`descricao`, `categoria_pai_id`) VALUES ('Fogões', '2');
INSERT INTO `valentidb`.`categoria` (`descricao`, `categoria_pai_id`) VALUES ('Fornos Elétricos', '2');
INSERT INTO `valentidb`.`categoria` (`descricao`, `categoria_pai_id`) VALUES ('Microondas', '2');
INSERT INTO `valentidb`.`categoria` (`descricao`, `categoria_pai_id`) VALUES ('Refrigeradores', '2');
INSERT INTO `valentidb`.`categoria` (`descricao`, `categoria_pai_id`) VALUES ('Cadeiras', '3');
INSERT INTO `valentidb`.`categoria` (`descricao`, `categoria_pai_id`) VALUES ('Mesas', '3');
INSERT INTO `valentidb`.`categoria` (`descricao`, `categoria_pai_id`) VALUES ('Racks', '3');
INSERT INTO `valentidb`.`categoria` (`descricao`, `categoria_pai_id`) VALUES ('Sofás', '3');



INSERT INTO `valentidb`.`usuario`(`id`,`email`,`nome`,`senha`,`username`) VALUES ('1', 'elenice@uol.com.br', 'Elenice Pimenta Fidelis Lasso', '789', 'elenice');
INSERT INTO `valentidb`.`usuario`('2', 'eber.lasso@gmail.com', 'Eber Spulveda Lasso', 'b59c67bf196a4758191e42f76670ceba', 'eber');
INSERT INTO `valentidb`.`usuario`('3', 'isabel@yahoo.com.br', 'Isabel Fidelis Lasso', '456', 'isabel');
INSERT INTO `valentidb`.`usuario`('999999', '', 'Master', '', 'master');


INSERT INTO `valentidb`.`produto`(`id`,`nome`,`qtd_estoque`,`sku`,`valor_unitario`,`categoria_id`)VALUES('2', 'Notebook ItauTec', '10', 'NOT1234', '3000.00', '5');
INSERT INTO `valentidb`.`produto`(`id`,`nome`,`qtd_estoque`,`sku`,`valor_unitario`,`categoria_id`)VALUES('3', 'TV LG 42\" Smart', '1', 'TLG1235', '100.00', '5');
INSERT INTO `valentidb`.`produto`(`id`,`nome`,`qtd_estoque`,`sku`,`valor_unitario`,`categoria_id`)VALUES('4', 'Celular Samsung 2', '440', 'CSS1236', '800.00', '5');
INSERT INTO `valentidb`.`produto`(`id`,`nome`,`qtd_estoque`,`sku`,`valor_unitario`,`categoria_id`)VALUES('5', 'Sofá Bartira', '99', 'SBT1237', '100.00', '5');

INSERT INTO `valentidb`.`grupo`(`id`,`descricao`,`nome`)VALUES('1', 'Administradores', 'Administradores');
INSERT INTO `valentidb`.`grupo`(`id`,`descricao`,`nome`)VALUES('2', 'Vendedores', 'Vendedores');
INSERT INTO `valentidb`.`grupo`(`id`,`descricao`,`nome`)VALUES('3', 'Auxiliares', 'Auxiliares');
INSERT INTO `valentidb`.`grupo`(`id`,`descricao`,`nome`)VALUES('999999', '', '');









