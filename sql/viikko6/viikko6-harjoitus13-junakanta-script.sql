-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema viikko6-harjoitus13-lippukanta
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `viikko6-harjoitus13-lippukanta` ;

-- -----------------------------------------------------
-- Schema viikko6-harjoitus13-lippukanta
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `viikko6-harjoitus13-lippukanta` DEFAULT CHARACTER SET utf8mb4 ;
USE `viikko6-harjoitus13-lippukanta` ;

-- -----------------------------------------------------
-- Table `viikko6-harjoitus13-lippukanta`.`asiakas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viikko6-harjoitus13-lippukanta`.`asiakas` ;

CREATE TABLE IF NOT EXISTS `viikko6-harjoitus13-lippukanta`.`asiakas` (
  `asiakas_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nimi` VARCHAR(45) NULL,
  `puhelin` VARCHAR(45) NULL,
  PRIMARY KEY (`asiakas_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viikko6-harjoitus13-lippukanta`.`lippu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viikko6-harjoitus13-lippukanta`.`lippu` ;

CREATE TABLE IF NOT EXISTS `viikko6-harjoitus13-lippukanta`.`lippu` (
  `lippu_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `lkm_aikuisia` INT NULL,
  `lkm_lapsia` INT NULL,
  `lkm_opiskelijoita` INT NULL,
  `lkm_elakelaisia` INT NULL,
  `hinta` DECIMAL(10,2) NULL,
  `asiakasnro` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`lippu_id`),
  INDEX `fk_lippu_asiakas_idx` (`asiakasnro` ASC) VISIBLE,
  CONSTRAINT `fk_lippu_asiakas`
    FOREIGN KEY (`asiakasnro`)
    REFERENCES `viikko6-harjoitus13-lippukanta`.`asiakas` (`asiakas_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viikko6-harjoitus13-lippukanta`.`paikkatyyppi`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viikko6-harjoitus13-lippukanta`.`paikkatyyppi` ;

CREATE TABLE IF NOT EXISTS `viikko6-harjoitus13-lippukanta`.`paikkatyyppi` (
  `paikkatyyppi_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `paikkatyyppi` VARCHAR(45) NULL,
  PRIMARY KEY (`paikkatyyppi_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viikko6-harjoitus13-lippukanta`.`junatyyppi`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viikko6-harjoitus13-lippukanta`.`junatyyppi` ;

CREATE TABLE IF NOT EXISTS `viikko6-harjoitus13-lippukanta`.`junatyyppi` (
  `junatyyppi_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `tyyppinimi` VARCHAR(45) NULL,
  PRIMARY KEY (`junatyyppi_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viikko6-harjoitus13-lippukanta`.`asema`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viikko6-harjoitus13-lippukanta`.`asema` ;

CREATE TABLE IF NOT EXISTS `viikko6-harjoitus13-lippukanta`.`asema` (
  `asema_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `asemanimi` VARCHAR(45) NULL,
  PRIMARY KEY (`asema_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viikko6-harjoitus13-lippukanta`.`juna`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viikko6-harjoitus13-lippukanta`.`juna` ;

CREATE TABLE IF NOT EXISTS `viikko6-harjoitus13-lippukanta`.`juna` (
  `juna_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `junanimi` VARCHAR(45) NOT NULL,
  `lahtoasema_id` INT UNSIGNED NOT NULL,
  `loppuasema_id` INT UNSIGNED NULL,
  `lahtoaika` DATETIME NOT NULL,
  `tuloaika` DATETIME NULL,
  `viikonpaiva` VARCHAR(10) NOT NULL,
  `junatyyppi_junatyyppi_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`juna_id`),
  INDEX `fk_juna_junatyyppi1_idx` (`junatyyppi_junatyyppi_id` ASC) VISIBLE,
  INDEX `fk_juna_asema1_idx` (`lahtoasema_id` ASC) VISIBLE,
  INDEX `fk_juna_asema2_idx` (`loppuasema_id` ASC) VISIBLE,
  CONSTRAINT `fk_juna_junatyyppi1`
    FOREIGN KEY (`junatyyppi_junatyyppi_id`)
    REFERENCES `viikko6-harjoitus13-lippukanta`.`junatyyppi` (`junatyyppi_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_juna_asema1`
    FOREIGN KEY (`lahtoasema_id`)
    REFERENCES `viikko6-harjoitus13-lippukanta`.`asema` (`asema_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_juna_asema2`
    FOREIGN KEY (`loppuasema_id`)
    REFERENCES `viikko6-harjoitus13-lippukanta`.`asema` (`asema_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viikko6-harjoitus13-lippukanta`.`aikataulu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viikko6-harjoitus13-lippukanta`.`aikataulu` ;

CREATE TABLE IF NOT EXISTS `viikko6-harjoitus13-lippukanta`.`aikataulu` (
  `aikataulu_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `lahtopvm` DATETIME NOT NULL,
  `tulopvm` DATETIME NULL,
  PRIMARY KEY (`aikataulu_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viikko6-harjoitus13-lippukanta`.`stoppi`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viikko6-harjoitus13-lippukanta`.`stoppi` ;

CREATE TABLE IF NOT EXISTS `viikko6-harjoitus13-lippukanta`.`stoppi` (
  `tuloaika` DATETIME NOT NULL,
  `lahtoaika` DATETIME NOT NULL,
  `asema_asema_id` INT UNSIGNED NOT NULL,
  `aikataulu_aikataulu_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`tuloaika`, `lahtoaika`),
  INDEX `fk_stoppi_asema1_idx` (`asema_asema_id` ASC) VISIBLE,
  INDEX `fk_stoppi_aikataulu1_idx` (`aikataulu_aikataulu_id` ASC) VISIBLE,
  CONSTRAINT `fk_stoppi_asema1`
    FOREIGN KEY (`asema_asema_id`)
    REFERENCES `viikko6-harjoitus13-lippukanta`.`asema` (`asema_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_stoppi_aikataulu1`
    FOREIGN KEY (`aikataulu_aikataulu_id`)
    REFERENCES `viikko6-harjoitus13-lippukanta`.`aikataulu` (`aikataulu_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viikko6-harjoitus13-lippukanta`.`vaunu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viikko6-harjoitus13-lippukanta`.`vaunu` ;

CREATE TABLE IF NOT EXISTS `viikko6-harjoitus13-lippukanta`.`vaunu` (
  `vaunu_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `onallergiavapaa` TINYINT NOT NULL,
  `onelainvaunu` TINYINT NOT NULL,
  `aikataulu_aikataulu_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`vaunu_id`),
  INDEX `fk_vaunu_aikataulu1_idx` (`aikataulu_aikataulu_id` ASC) VISIBLE,
  CONSTRAINT `fk_vaunu_aikataulu1`
    FOREIGN KEY (`aikataulu_aikataulu_id`)
    REFERENCES `viikko6-harjoitus13-lippukanta`.`aikataulu` (`aikataulu_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viikko6-harjoitus13-lippukanta`.`paikka`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viikko6-harjoitus13-lippukanta`.`paikka` ;

CREATE TABLE IF NOT EXISTS `viikko6-harjoitus13-lippukanta`.`paikka` (
  `paikkanro` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `onvapaa` TINYINT NOT NULL,
  `paikkatyyppi_paikkatyyppi_id` INT UNSIGNED NOT NULL,
  `vaunu_vaunu_id` INT UNSIGNED NOT NULL,
  `lippu_lippu_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`paikkanro`),
  INDEX `fk_paikka_paikkatyyppi1_idx` (`paikkatyyppi_paikkatyyppi_id` ASC) VISIBLE,
  INDEX `fk_paikka_vaunu1_idx` (`vaunu_vaunu_id` ASC) VISIBLE,
  INDEX `fk_paikka_lippu1_idx` (`lippu_lippu_id` ASC) VISIBLE,
  CONSTRAINT `fk_paikka_paikkatyyppi1`
    FOREIGN KEY (`paikkatyyppi_paikkatyyppi_id`)
    REFERENCES `viikko6-harjoitus13-lippukanta`.`paikkatyyppi` (`paikkatyyppi_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_paikka_vaunu1`
    FOREIGN KEY (`vaunu_vaunu_id`)
    REFERENCES `viikko6-harjoitus13-lippukanta`.`vaunu` (`vaunu_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_paikka_lippu1`
    FOREIGN KEY (`lippu_lippu_id`)
    REFERENCES `viikko6-harjoitus13-lippukanta`.`lippu` (`lippu_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
