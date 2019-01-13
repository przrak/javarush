USE test;

DROP TABLE IF EXISTS part;
CREATE TABLE `test`.`part` (
  `id` INT(8) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `quantity` INT(8) NOT NULL DEFAULT 0,
  `need` INT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('материнская плата', 7, 1);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('звуковая карта', 5, 0);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('процессор', 15, 1);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('оперативная память', 10, 1);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('подсветка корпуса', 10, 0);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('CD привод', 3, 0);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('видеокарта', 6, 1);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('корпус (без блока питания)', 8, 1);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('HDD диск', 5, 1);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('SSD диск', 4, 0);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('водяное охлаждение', 10, 0);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('TV тюнер', 1, 0);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('плата видеозахвата', 10, 0);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('блок питания', 21, 1);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('сетевая карта', 14, 0);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('термопаста', 2, 0);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('кулер для видеокарты', 7, 1);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('вентилятор', 3, 0);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('видеокарта2', 12, 0);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('процесор2', 5, 0);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('оперативная память2', 14, 0);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('материнская плата2', 11, 0);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('звуковая карта2', 6, 0);
INSERT INTO `test`.`part` (`name`,`quantity`,`need`) VALUES ('вентилятор2', 9, 0);
