-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema kirkonkirjat
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `kirkonkirjat` ;

-- -----------------------------------------------------
-- Schema kirkonkirjat
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kirkonkirjat` DEFAULT CHARACTER SET utf8mb4 ;
USE `kirkonkirjat` ;

-- -----------------------------------------------------
-- Table `kirkonkirjat`.`paikkakunta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kirkonkirjat`.`paikkakunta` ;

CREATE TABLE IF NOT EXISTS `kirkonkirjat`.`paikkakunta` (
  `paikkakunta` VARCHAR(45) NOT NULL,
  `valtio` VARCHAR(45) NULL,
  PRIMARY KEY (`paikkakunta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kirkonkirjat`.`henkilo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kirkonkirjat`.`henkilo` ;

CREATE TABLE IF NOT EXISTS `kirkonkirjat`.`henkilo` (
  `henkilo_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `etunimet` VARCHAR(45) NULL,
  `sukunimet` VARCHAR(45) NULL,
  `syntymapaikkakunta` VARCHAR(45) NULL,
  `isa` INT UNSIGNED NULL,
  `aiti` INT UNSIGNED NULL,
  `sukupuoli (biologinen)` VARCHAR(45) NULL,
  `kuvaus` VARCHAR(45) NULL,
  `syntymaaika` DATE NULL,
  `kuolinaika` DATE NULL,
  PRIMARY KEY (`henkilo_id`),
  INDEX `fk_henkilo_paikkakunta1_idx` (`syntymapaikkakunta` ASC) VISIBLE,
  INDEX `fk_henkilo_henkilo1_idx` (`isa` ASC) VISIBLE,
  INDEX `fk_henkilo_henkilo2_idx` (`aiti` ASC) VISIBLE,
  CONSTRAINT `fk_henkilo_paikkakunta1`
    FOREIGN KEY (`syntymapaikkakunta`)
    REFERENCES `kirkonkirjat`.`paikkakunta` (`paikkakunta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_henkilo_henkilo1`
    FOREIGN KEY (`isa`)
    REFERENCES `kirkonkirjat`.`henkilo` (`henkilo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_henkilo_henkilo2`
    FOREIGN KEY (`aiti`)
    REFERENCES `kirkonkirjat`.`henkilo` (`henkilo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'etunimet, sukunimet, syntymäaika, kuolinpäivä, kuvausteksti, syntymäpaikkakunta, (biologinen) sukupuoli, avioliittojen solmimis- ja eroamispäivät, kenen kanssa on vihitty, lapset, lasten vanhemmat';


-- -----------------------------------------------------
-- Table `kirkonkirjat`.`avioliitto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kirkonkirjat`.`avioliitto` ;

CREATE TABLE IF NOT EXISTS `kirkonkirjat`.`avioliitto` (
  `henkilo1_id` INT UNSIGNED NOT NULL,
  `henkilo2_id` INT UNSIGNED NOT NULL,
  `alkamispaiva` DATE NOT NULL,
  `loppumispaiva` DATE NULL,
  PRIMARY KEY (`henkilo1_id`, `henkilo2_id`, `alkamispaiva`),
  INDEX `fk_avioliitto_henkilo2_idx` (`henkilo2_id` ASC) VISIBLE,
  CONSTRAINT `fk_avioliitto_henkilo1`
    FOREIGN KEY (`henkilo1_id`)
    REFERENCES `kirkonkirjat`.`henkilo` (`henkilo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avioliitto_henkilo2`
    FOREIGN KEY (`henkilo2_id`)
    REFERENCES `kirkonkirjat`.`henkilo` (`henkilo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
