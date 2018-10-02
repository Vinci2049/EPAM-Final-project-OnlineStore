-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema OnlineStore
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `OnlineStore` ;

-- -----------------------------------------------------
-- Schema OnlineStore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `OnlineStore` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
USE `OnlineStore` ;

-- -----------------------------------------------------
-- Table `OnlineStore`.`Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OnlineStore`.`Product` ;

CREATE TABLE IF NOT EXISTS `OnlineStore`.`Product` (
  `ProductId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  `image` MEDIUMBLOB NULL,
  `description` MEDIUMTEXT NULL,
  PRIMARY KEY (`ProductId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OnlineStore`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OnlineStore`.`User` ;

CREATE TABLE IF NOT EXISTS `OnlineStore`.`User` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `isAdmin` TINYINT NULL,
  `inBlackList` TINYINT NULL,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OnlineStore`.`ClientOrder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OnlineStore`.`ClientOrder` ;

CREATE TABLE IF NOT EXISTS `OnlineStore`.`ClientOrder` (
  `ClientOrderId` INT NOT NULL AUTO_INCREMENT,
  `User_id` INT NOT NULL,
  `date` DATETIME NULL,
  `cost` DOUBLE NULL,
  `isPaid` TINYINT NULL,
  PRIMARY KEY (`ClientOrderId`),
  CONSTRAINT `fk_Order_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `OnlineStore`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idOrder_UNIQUE` ON `OnlineStore`.`ClientOrder` (`ClientOrderId` ASC) VISIBLE;

CREATE INDEX `fk_Order_User1_idx` ON `OnlineStore`.`ClientOrder` (`User_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `OnlineStore`.`ClientOrderProductList`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OnlineStore`.`ClientOrderProductList` ;

CREATE TABLE IF NOT EXISTS `OnlineStore`.`ClientOrderProductList` (
  `ClientOrder_ClientOrderId` INT NOT NULL,
  `Product_idProduct` INT NOT NULL,
  `Quantity` INT NULL,
  PRIMARY KEY (`ClientOrder_ClientOrderId`, `Product_idProduct`),
  CONSTRAINT `fk_OrderProductList_Order`
    FOREIGN KEY (`ClientOrder_ClientOrderId`)
    REFERENCES `OnlineStore`.`ClientOrder` (`ClientOrderId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrderProductList_Product1`
    FOREIGN KEY (`Product_idProduct`)
    REFERENCES `OnlineStore`.`Product` (`ProductId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_OrderProductList_Order_idx` ON `OnlineStore`.`ClientOrderProductList` (`ClientOrder_ClientOrderId` ASC) VISIBLE;

CREATE INDEX `fk_OrderProductList_Product1_idx` ON `OnlineStore`.`ClientOrderProductList` (`Product_idProduct` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `OnlineStore`.`Client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OnlineStore`.`Client` ;

CREATE TABLE IF NOT EXISTS `OnlineStore`.`Client` (
  `id` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Surname` VARCHAR(45) NULL,
  `InBlackList` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OnlineStore`.`OrderStatus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OnlineStore`.`OrderStatus` ;

CREATE TABLE IF NOT EXISTS `OnlineStore`.`OrderStatus` (
  `id` INT NOT NULL,
  `name` VARCHAR(30) NULL,
  `isDelivered` TINYINT NULL,
  `isPaid` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OnlineStore`.`Cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OnlineStore`.`Cart` ;

CREATE TABLE IF NOT EXISTS `OnlineStore`.`Cart` (
  `User_id` INT NOT NULL,
  `date` DATETIME NULL,
  PRIMARY KEY (`User_id`),
  CONSTRAINT `fk_Cart_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `OnlineStore`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Cart_User1_idx` ON `OnlineStore`.`Cart` (`User_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `OnlineStore`.`CartProductList`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OnlineStore`.`CartProductList` ;

CREATE TABLE IF NOT EXISTS `OnlineStore`.`CartProductList` (
  `Cart_User_id` INT NOT NULL,
  `Product_idProduct` INT NOT NULL,
  `Quantity` INT NULL,
  PRIMARY KEY (`Cart_User_id`, `Product_idProduct`),
  CONSTRAINT `fk_CartProductList_Product1`
    FOREIGN KEY (`Product_idProduct`)
    REFERENCES `OnlineStore`.`Product` (`ProductId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CartProductList_Cart2`
    FOREIGN KEY (`Cart_User_id`)
    REFERENCES `OnlineStore`.`Cart` (`User_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_CartProductList_Product1_idx` ON `OnlineStore`.`CartProductList` (`Product_idProduct` ASC) VISIBLE;

CREATE INDEX `fk_CartProductList_Cart2_idx` ON `OnlineStore`.`CartProductList` (`Cart_User_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `OnlineStore`.`ProductQuantity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OnlineStore`.`ProductQuantity` ;

CREATE TABLE IF NOT EXISTS `OnlineStore`.`ProductQuantity` (
  `Product_idProduct` INT NOT NULL,
  `Quantity` DOUBLE NULL,
  PRIMARY KEY (`Product_idProduct`),
  CONSTRAINT `fk_ProductQuantity_Product1`
    FOREIGN KEY (`Product_idProduct`)
    REFERENCES `OnlineStore`.`Product` (`ProductId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `OnlineStore`.`Product`
-- -----------------------------------------------------
START TRANSACTION;
USE `OnlineStore`;
INSERT INTO `OnlineStore`.`Product` (`ProductId`, `name`, `price`, `image`, `description`) VALUES (1, 'Робот-пылесос iRobot Roomba 616', 19999, NULL, 'Новая модель Roomba 616. Для запуска нужно всего лишь нажать кнопку \"Clean\" на роботе, и Roomba 616 самостоятельно очистит до 60 квадратных метров без подзарядки. Укомплектован контейнером AeroVac Bin. Новый контейнер не только имеет повышенную емкость, предназначенную для сбора шерсти, но также оснащен всасывающим устройством и имеет компактный отсек для сбора пыли. Таким образом, теперь нет необходимости в дополнительной чистке помещения базовым контейнером. Еще одна особенность новинки — AeroVac Bin работает в 2 раза тише, чем базовая версия. Roomba 616 — представитель 600-ой серии (6-ого поколения) роботов, которые выпускает компания iRobot, в нем использованы новейшие разработки в области робототехники, навигации в помещении, вакуумной уборки. ');
INSERT INTO `OnlineStore`.`Product` (`ProductId`, `name`, `price`, `image`, `description`) VALUES (2, 'Ноутбук Apple MacBook Pro 13, Space Grey', 133429, NULL, 'Apple MacBook Pro стал ещё быстрее и мощнее.');
INSERT INTO `OnlineStore`.`Product` (`ProductId`, `name`, `price`, `image`, `description`) VALUES (3, 'Игровая мышь Razer Naga Trinity, Black', 6690, NULL, 'Оцените мощные возможности тотального контроля, в какую бы игру вы ни играли. Мышь Razer Naga Trinity, призванная обеспечить преимущество в MOBA/многопользовательских онлайн-играх, позволяет вам настраивать все: от вооружений до индивидуальных конфигураций, чтобы постоянно опережать соперников. Razer Naga Trinity оснащена тремя сменными боковыми панелями, что позволяет переключаться между 2-, 7- и 12-кнопочными конфигурациями в зависимости от ваших потребностей в игре. ');
INSERT INTO `OnlineStore`.`Product` (`ProductId`, `name`, `price`, `image`, `description`) VALUES (4, 'Canon Pixma iP2840 принтер', 1990, NULL, 'Canon PIXMA iP2840 - легкая и доступная повседневная печать. ');

COMMIT;


-- -----------------------------------------------------
-- Data for table `OnlineStore`.`User`
-- -----------------------------------------------------
START TRANSACTION;
USE `OnlineStore`;
INSERT INTO `OnlineStore`.`User` (`userId`, `login`, `password`, `name`, `email`, `isAdmin`, `inBlackList`) VALUES (1, 'admin', '123', NULL, NULL, 1, 0);
INSERT INTO `OnlineStore`.`User` (`userId`, `login`, `password`, `name`, `email`, `isAdmin`, `inBlackList`) VALUES (2, 'user', '123', NULL, NULL, 0, 0);
INSERT INTO `OnlineStore`.`User` (`userId`, `login`, `password`, `name`, `email`, `isAdmin`, `inBlackList`) VALUES (3, 'Negodyaev', '123', NULL, NULL, 0, 1);
INSERT INTO `OnlineStore`.`User` (`userId`, `login`, `password`, `name`, `email`, `isAdmin`, `inBlackList`) VALUES (4, 'Lyubimov', '123', NULL, NULL, 0, 0);
INSERT INTO `OnlineStore`.`User` (`userId`, `login`, `password`, `name`, `email`, `isAdmin`, `inBlackList`) VALUES (5, 'Patrikeeva', '123', NULL, NULL, 0, 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `OnlineStore`.`ClientOrder`
-- -----------------------------------------------------
START TRANSACTION;
USE `OnlineStore`;
INSERT INTO `OnlineStore`.`ClientOrder` (`ClientOrderId`, `User_id`, `date`, `cost`, `isPaid`) VALUES (1, 1, '01.08.18', NULL, NULL);
INSERT INTO `OnlineStore`.`ClientOrder` (`ClientOrderId`, `User_id`, `date`, `cost`, `isPaid`) VALUES (2, 2, '05.08.18', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `OnlineStore`.`ClientOrderProductList`
-- -----------------------------------------------------
START TRANSACTION;
USE `OnlineStore`;
INSERT INTO `OnlineStore`.`ClientOrderProductList` (`ClientOrder_ClientOrderId`, `Product_idProduct`, `Quantity`) VALUES (1, 2, 1);
INSERT INTO `OnlineStore`.`ClientOrderProductList` (`ClientOrder_ClientOrderId`, `Product_idProduct`, `Quantity`) VALUES (1, 3, 1);
INSERT INTO `OnlineStore`.`ClientOrderProductList` (`ClientOrder_ClientOrderId`, `Product_idProduct`, `Quantity`) VALUES (2, 4, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `OnlineStore`.`Client`
-- -----------------------------------------------------
START TRANSACTION;
USE `OnlineStore`;
INSERT INTO `OnlineStore`.`Client` (`id`, `Name`, `Surname`, `InBlackList`) VALUES (1, 'Себястьян', 'Негодяев', NULL);
INSERT INTO `OnlineStore`.`Client` (`id`, `Name`, `Surname`, `InBlackList`) VALUES (2, 'Иван', 'Алхимов', NULL);
INSERT INTO `OnlineStore`.`Client` (`id`, `Name`, `Surname`, `InBlackList`) VALUES (3, 'Евгений', 'Любимов', NULL);
INSERT INTO `OnlineStore`.`Client` (`id`, `Name`, `Surname`, `InBlackList`) VALUES (4, 'Аграфена', 'Патрикеева', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `OnlineStore`.`OrderStatus`
-- -----------------------------------------------------
START TRANSACTION;
USE `OnlineStore`;
INSERT INTO `OnlineStore`.`OrderStatus` (`id`, `name`, `isDelivered`, `isPaid`) VALUES (1, 'Оформлен', NULL, NULL);
INSERT INTO `OnlineStore`.`OrderStatus` (`id`, `name`, `isDelivered`, `isPaid`) VALUES (2, 'Оплачен', NULL, 1);
INSERT INTO `OnlineStore`.`OrderStatus` (`id`, `name`, `isDelivered`, `isPaid`) VALUES (3, 'Доставлен', 1, 1);
INSERT INTO `OnlineStore`.`OrderStatus` (`id`, `name`, `isDelivered`, `isPaid`) VALUES (4, 'Аннулирован', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `OnlineStore`.`ProductQuantity`
-- -----------------------------------------------------
START TRANSACTION;
USE `OnlineStore`;
INSERT INTO `OnlineStore`.`ProductQuantity` (`Product_idProduct`, `Quantity`) VALUES (1, 3);
INSERT INTO `OnlineStore`.`ProductQuantity` (`Product_idProduct`, `Quantity`) VALUES (2, 2);
INSERT INTO `OnlineStore`.`ProductQuantity` (`Product_idProduct`, `Quantity`) VALUES (3, 10);
INSERT INTO `OnlineStore`.`ProductQuantity` (`Product_idProduct`, `Quantity`) VALUES (4, 5);

COMMIT;

