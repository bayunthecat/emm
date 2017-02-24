-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema emm
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema emm
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `emm` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `emm` ;

-- -----------------------------------------------------
-- Table `emm`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `emm`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `surname` VARCHAR(45) NOT NULL COMMENT '',
  `email` VARCHAR(254) NULL COMMENT '',
  `birthDate` DATE NULL COMMENT '',
  `gender` VARCHAR(6) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
