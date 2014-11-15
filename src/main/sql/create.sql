CREATE DATABASE IF NOT EXISTS `restdemo`;
use `restdemo`;

CREATE TABLE IF NOT EXISTS `Person` (
  `id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NULL,
  `age` INT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE IF NOT EXISTS `Puppy` (
  `id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NULL,
  `number` VARCHAR(45) NULL,
  `personId` VARCHAR(36) NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_Puppy_Person_idx` (`personId` ASC),
  CONSTRAINT `FK_Puppy_Person`
    FOREIGN KEY (`personId`)
    REFERENCES `Person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
