-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema partio
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `partio` ;

-- -----------------------------------------------------
-- Schema partio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `partio` DEFAULT CHARACTER SET utf8mb4 ;
USE `partio` ;

-- -----------------------------------------------------
-- Table `partio`.`kategoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `partio`.`kategoria` ;

CREATE TABLE IF NOT EXISTS `partio`.`kategoria` (
  `kategoria` VARCHAR(30) NOT NULL,
  `kategoria_kuvaus` VARCHAR(60) NULL,
  PRIMARY KEY (`kategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `partio`.`ikakausi`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `partio`.`ikakausi` ;

CREATE TABLE IF NOT EXISTS `partio`.`ikakausi` (
  `ikakausi` VARCHAR(15) NOT NULL,
  `ikakausi_kuvaus` VARCHAR(60) NULL,
  PRIMARY KEY (`ikakausi`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `partio`.`partiomerkki`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `partio`.`partiomerkki` ;

CREATE TABLE IF NOT EXISTS `partio`.`partiomerkki` (
  `partiomerkki` VARCHAR(30) NOT NULL,
  `kategoria` VARCHAR(30) NULL,
  `ikakausi` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`partiomerkki`),
  INDEX `fk_partiomerkki_kategoria_idx` (`kategoria` ASC) VISIBLE,
  INDEX `fk_partiomerkki_ikakausi1_idx` (`ikakausi` ASC) VISIBLE,
  CONSTRAINT `fk_partiomerkki_kategoria`
    FOREIGN KEY (`kategoria`)
    REFERENCES `partio`.`kategoria` (`kategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_partiomerkki_ikakausi1`
    FOREIGN KEY (`ikakausi`)
    REFERENCES `partio`.`ikakausi` (`ikakausi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `partio`.`suoritus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `partio`.`suoritus` ;

CREATE TABLE IF NOT EXISTS `partio`.`suoritus` (
  `suoritus_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `suoritusnimi` VARCHAR(100) NOT NULL,
  `partiomerkki` VARCHAR(30) NOT NULL,
  `sisa_ulko` CHAR(4) NULL,
  `kesto_min` INT UNSIGNED NULL,
  `kuvaus` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`suoritus_id`),
  UNIQUE INDEX `suoritusnimi_UNIQUE` (`suoritusnimi` ASC) VISIBLE,
  INDEX `fk_table1_partiomerkki1_idx` (`partiomerkki` ASC) VISIBLE,
  INDEX `idx_suoritusnimi` (`suoritusnimi` ASC) VISIBLE,
  CONSTRAINT `fk_table1_partiomerkki1`
    FOREIGN KEY (`partiomerkki`)
    REFERENCES `partio`.`partiomerkki` (`partiomerkki`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `partio`.`partioryhma`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `partio`.`partioryhma` ;

CREATE TABLE IF NOT EXISTS `partio`.`partioryhma` (
  `ryhma_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `ryhman_nimi` VARCHAR(45) NOT NULL,
  `ikakausi` VARCHAR(15) NOT NULL,
  `kokouspaiva` VARCHAR(11) NULL,
  `kokous_alkaa` TIME NULL,
  `kokous_loppuu` TIME NULL,
  PRIMARY KEY (`ryhma_id`),
  INDEX `fk_partioryhma_ikakausi1_idx` (`ikakausi` ASC) VISIBLE,
  INDEX `idx_ryhman_nimi` (`ryhman_nimi` ASC) VISIBLE,
  CONSTRAINT `fk_partioryhma_ikakausi1`
    FOREIGN KEY (`ikakausi`)
    REFERENCES `partio`.`ikakausi` (`ikakausi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `partio`.`kokous`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `partio`.`kokous` ;

CREATE TABLE IF NOT EXISTS `partio`.`kokous` (
  `kokous_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `ryhma_id` INT UNSIGNED NOT NULL,
  `pvm` DATE NULL,
  PRIMARY KEY (`kokous_id`),
  INDEX `fk_kokous_partioryhma1_idx` (`ryhma_id` ASC) VISIBLE,
  INDEX `idx_pvm` (`pvm` ASC) VISIBLE,
  CONSTRAINT `fk_kokous_partioryhma1`
    FOREIGN KEY (`ryhma_id`)
    REFERENCES `partio`.`partioryhma` (`ryhma_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `partio`.`kokous_suoritus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `partio`.`kokous_suoritus` ;

CREATE TABLE IF NOT EXISTS `partio`.`kokous_suoritus` (
  `kokous_id` INT UNSIGNED NOT NULL,
  `suoritus_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`kokous_id`, `suoritus_id`),
  INDEX `fk_kokous_suoritus_suoritus1_idx` (`suoritus_id` ASC) VISIBLE,
  CONSTRAINT `fk_kokous_suoritus_kokous1`
    FOREIGN KEY (`kokous_id`)
    REFERENCES `partio`.`kokous` (`kokous_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_kokous_suoritus_suoritus1`
    FOREIGN KEY (`suoritus_id`)
    REFERENCES `partio`.`suoritus` (`suoritus_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `partio`.`partiolainen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `partio`.`partiolainen` ;

CREATE TABLE IF NOT EXISTS `partio`.`partiolainen` (
  `partiolainen_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `etunimi` VARCHAR(45) NULL,
  `sukunimi` VARCHAR(45) NULL,
  `syntymavuosi` CHAR(4) NULL,
  `puhelinnumero` VARCHAR(15) NULL,
  `katuosoite` VARCHAR(45) NULL,
  `postinumero` CHAR(5) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`partiolainen_id`),
  INDEX `idx_synt.vuosi` (`syntymavuosi` ASC) VISIBLE,
  INDEX `idx_etunimi` (`etunimi` ASC) VISIBLE,
  INDEX `idx_sukunimi` (`sukunimi` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `partio`.`ryhmarooli`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `partio`.`ryhmarooli` ;

CREATE TABLE IF NOT EXISTS `partio`.`ryhmarooli` (
  `partiolainen_id` INT UNSIGNED NOT NULL,
  `ryhma_id` INT UNSIGNED NOT NULL,
  `rooli` VARCHAR(10) NOT NULL DEFAULT 'jäsen',
  PRIMARY KEY (`partiolainen_id`, `ryhma_id`),
  INDEX `fk_ryhmarooli_partioryhma1_idx` (`ryhma_id` ASC) VISIBLE,
  CONSTRAINT `fk_ryhmarooli_partiolainen1`
    FOREIGN KEY (`partiolainen_id`)
    REFERENCES `partio`.`partiolainen` (`partiolainen_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ryhmarooli_partioryhma1`
    FOREIGN KEY (`ryhma_id`)
    REFERENCES `partio`.`partioryhma` (`ryhma_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `partio`.`kokous_osallistuja`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `partio`.`kokous_osallistuja` ;

CREATE TABLE IF NOT EXISTS `partio`.`kokous_osallistuja` (
  `partiolainen_id` INT UNSIGNED NOT NULL,
  `kokous_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`partiolainen_id`, `kokous_id`),
  INDEX `fk_kokous_osallistuja_kokous1_idx` (`kokous_id` ASC) VISIBLE,
  CONSTRAINT `fk_kokous_osallistuja_partiolainen1`
    FOREIGN KEY (`partiolainen_id`)
    REFERENCES `partio`.`partiolainen` (`partiolainen_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_kokous_osallistuja_kokous1`
    FOREIGN KEY (`kokous_id`)
    REFERENCES `partio`.`kokous` (`kokous_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `partio` ;

-- -----------------------------------------------------
-- Placeholder table for view `partio`.`ryhmien_jasenet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `partio`.`ryhmien_jasenet` (`"Ikäkausi"` INT, `"Ryhmä"` INT, `"Nimi"` INT, `"Syntymävuosi"` INT, `"Rooli ryhmässä"` INT);

-- -----------------------------------------------------
-- Placeholder table for view `partio`.`ryhmien_kokoukset`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `partio`.`ryhmien_kokoukset` (`Ryhmä` INT, `"Ryhmän kokouksia yhteensä"` INT);

-- -----------------------------------------------------
-- View `partio`.`ryhmien_jasenet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `partio`.`ryhmien_jasenet`;
DROP VIEW IF EXISTS `partio`.`ryhmien_jasenet` ;
USE `partio`;
CREATE  OR REPLACE VIEW `ryhmien_jasenet` AS
SELECT 	
	pr.ikakausi AS "Ikäkausi", 
	pr.ryhman_nimi AS "Ryhmä",
	concat(p.etunimi, " ", p.sukunimi) AS "Nimi", 
	p.syntymavuosi AS "Syntymävuosi", 
    rr.rooli AS "Rooli ryhmässä"
FROM partiolainen p 
	JOIN ryhmarooli rr ON p.partiolainen_id = rr.partiolainen_id
	JOIN partioryhma pr ON pr.ryhma_id = rr.ryhma_id
ORDER BY Ikäkausi, Ryhmä, rr.rooli DESC, Nimi;

-- -----------------------------------------------------
-- View `partio`.`ryhmien_kokoukset`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `partio`.`ryhmien_kokoukset`;
DROP VIEW IF EXISTS `partio`.`ryhmien_kokoukset` ;
USE `partio`;
CREATE  OR REPLACE VIEW `ryhmien_kokoukset` AS
SELECT
	pr.ryhman_nimi AS Ryhmä,
    COUNT(ks.suoritus_id) AS "Ryhmän kokouksia yhteensä"
FROM partioryhma pr 
	JOIN kokous k ON pr.ryhma_id = k.ryhma_id
	JOIN kokous_suoritus ks ON k.kokous_id = ks.kokous_id
GROUP BY Ryhmä
ORDER BY Ryhmä;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `partio`.`kategoria`
-- -----------------------------------------------------
START TRANSACTION;
USE `partio`;
INSERT INTO `partio`.`kategoria` (`kategoria`, `kategoria_kuvaus`) VALUES ('suhde ympäristöön', NULL);
INSERT INTO `partio`.`kategoria` (`kategoria`, `kategoria_kuvaus`) VALUES ('suhde itseen', NULL);
INSERT INTO `partio`.`kategoria` (`kategoria`, `kategoria_kuvaus`) VALUES ('suhde toiseen', NULL);
INSERT INTO `partio`.`kategoria` (`kategoria`, `kategoria_kuvaus`) VALUES ('haaste', NULL);
INSERT INTO `partio`.`kategoria` (`kategoria`, `kategoria_kuvaus`) VALUES ('suhde yhteiskuntaan', NULL);
INSERT INTO `partio`.`kategoria` (`kategoria`, `kategoria_kuvaus`) VALUES ('ilmansuunta', NULL);
INSERT INTO `partio`.`kategoria` (`kategoria`, `kategoria_kuvaus`) VALUES ('väli-ilmansuunta', NULL);
INSERT INTO `partio`.`kategoria` (`kategoria`, `kategoria_kuvaus`) VALUES ('tarppo', NULL);
INSERT INTO `partio`.`kategoria` (`kategoria`, `kategoria_kuvaus`) VALUES ('tasku', NULL);
INSERT INTO `partio`.`kategoria` (`kategoria`, `kategoria_kuvaus`) VALUES ('toimintamerkki', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `partio`.`ikakausi`
-- -----------------------------------------------------
START TRANSACTION;
USE `partio`;
INSERT INTO `partio`.`ikakausi` (`ikakausi`, `ikakausi_kuvaus`) VALUES ('sudenpennut', '7-9 vuotiaat');
INSERT INTO `partio`.`ikakausi` (`ikakausi`, `ikakausi_kuvaus`) VALUES ('seikkailijat', '10-11/12 vuotiaat (siirtymä tarpojiin vaihtelee)');
INSERT INTO `partio`.`ikakausi` (`ikakausi`, `ikakausi_kuvaus`) VALUES ('tarpojat', '12/13-14 vuotiaat');
INSERT INTO `partio`.`ikakausi` (`ikakausi`, `ikakausi_kuvaus`) VALUES ('samoajat', '15-17 vuotiaat');
INSERT INTO `partio`.`ikakausi` (`ikakausi`, `ikakausi_kuvaus`) VALUES ('vaeltajat', '18-22 vuotiaat');
INSERT INTO `partio`.`ikakausi` (`ikakausi`, `ikakausi_kuvaus`) VALUES ('perhepartio', '0-6 vuotiaat');

COMMIT;


-- -----------------------------------------------------
-- Data for table `partio`.`partiomerkki`
-- -----------------------------------------------------
START TRANSACTION;
USE `partio`;
INSERT INTO `partio`.`partiomerkki` (`partiomerkki`, `kategoria`, `ikakausi`) VALUES ('nuotio', 'suhde ympäristöön', 'sudenpennut');
INSERT INTO `partio`.`partiomerkki` (`partiomerkki`, `kategoria`, `ikakausi`) VALUES ('suunnistus', 'suhde ympäristöön', 'sudenpennut');
INSERT INTO `partio`.`partiomerkki` (`partiomerkki`, `kategoria`, `ikakausi`) VALUES ('liikenne', 'suhde yhteiskuntaan', 'sudenpennut');
INSERT INTO `partio`.`partiomerkki` (`partiomerkki`, `kategoria`, `ikakausi`) VALUES ('toimittaja', 'suhde yhteiskuntaan', 'sudenpennut');
INSERT INTO `partio`.`partiomerkki` (`partiomerkki`, `kategoria`, `ikakausi`) VALUES ('ensiapu', 'suhde toiseen', 'sudenpennut');
INSERT INTO `partio`.`partiomerkki` (`partiomerkki`, `kategoria`, `ikakausi`) VALUES ('partiotaitokilpailu', 'suhde toiseen', 'sudenpennut');
INSERT INTO `partio`.`partiomerkki` (`partiomerkki`, `kategoria`, `ikakausi`) VALUES ('askartelu', 'suhde itseen', 'sudenpennut');
INSERT INTO `partio`.`partiomerkki` (`partiomerkki`, `kategoria`, `ikakausi`) VALUES ('rakentelu', 'suhde itseen', 'sudenpennut');
INSERT INTO `partio`.`partiomerkki` (`partiomerkki`, `kategoria`, `ikakausi`) VALUES ('taiteilija', 'suhde itseen', 'sudenpennut');
INSERT INTO `partio`.`partiomerkki` (`partiomerkki`, `kategoria`, `ikakausi`) VALUES ('tulentekijä', 'haaste', 'seikkailijat');

COMMIT;


-- -----------------------------------------------------
-- Data for table `partio`.`suoritus`
-- -----------------------------------------------------
START TRANSACTION;
USE `partio`;
INSERT INTO `partio`.`suoritus` (`suoritus_id`, `suoritusnimi`, `partiomerkki`, `sisa_ulko`, `kesto_min`, `kuvaus`) VALUES (DEFAULT, 'Tiedän miten auttaa pyörtynyttä', 'ensiapu', 'sisä', 30, 'Sudenpentu opettelee tunnistamaan pyörtyneen ja antamaan hänelle ensiapua.');
INSERT INTO `partio`.`suoritus` (`suoritus_id`, `suoritusnimi`, `partiomerkki`, `sisa_ulko`, `kesto_min`, `kuvaus`) VALUES (DEFAULT, 'Osaan hoitaa pieniä haavoja', 'ensiapu', 'sisä', 30, 'Sudenpentu harjoittelee puhdistamaan haavan ja laittamaan laastarin. Hän harjoittelee tunnistamaan, millaisia pieniä haavoja sudenpennut voivat itse hoitaa ja mistä pitää aina kertoa aikuiselle.');
INSERT INTO `partio`.`suoritus` (`suoritus_id`, `suoritusnimi`, `partiomerkki`, `sisa_ulko`, `kesto_min`, `kuvaus`) VALUES (DEFAULT, 'Tutustun ensiapulaukun sisältöön', 'ensiapu', 'sisä', 30, 'Sudenpentu tutustuu ensiapulaukun sisältöön. Hän tietää, mistä se kololta löytyy.');
INSERT INTO `partio`.`suoritus` (`suoritus_id`, `suoritusnimi`, `partiomerkki`, `sisa_ulko`, `kesto_min`, `kuvaus`) VALUES (DEFAULT, 'Tutustun kompassiin', 'suunnistus', 'ulko', 60, 'Sudenpentu tutustuu kompassiin ja harjoittelee pohjoisen löytämistä kartalta ja maastosta.');
INSERT INTO `partio`.`suoritus` (`suoritus_id`, `suoritusnimi`, `partiomerkki`, `sisa_ulko`, `kesto_min`, `kuvaus`) VALUES (DEFAULT, 'Opin pää- ja väli-ilmansuunnat', 'suunnistus', 'ulko', 60, 'Sudenpennut opettelevat pää- ja väli-ilmansuunnat.');
INSERT INTO `partio`.`suoritus` (`suoritus_id`, `suoritusnimi`, `partiomerkki`, `sisa_ulko`, `kesto_min`, `kuvaus`) VALUES (DEFAULT, 'Tiedän, kuinka toimin eksymistilanteessa', 'suunnistus', 'ulko', 60, 'Lauma pohtii, mihin voi eksyä. Voiko metsän lisäksi eksyä kauppakeskukseen, kaupunkiin tai huvipuistoon? Kuinka silloin toimitaan? Lauma miettii hyviä toimintakeinoja eri eksymistilanteisiin.');
INSERT INTO `partio`.`suoritus` (`suoritus_id`, `suoritusnimi`, `partiomerkki`, `sisa_ulko`, `kesto_min`, `kuvaus`) VALUES (DEFAULT, 'Piirrän kartan kolosta tai sen lähialueelta ja järjestän aarteenmetsästyksen ystävälle', 'suunnistus', 'ulko', 120, 'Sudenpennut piirtävät kolosta/kämpästä/leirialueesta yksinkertaiset kartat. Jokainen sudenpentu piilottaa pienen aarteen ja merkitsee sen karttaansa tähdellä. Karttoja vaihdetaan toisen sudenpennun kanssa ja etsitään aarteet.');
INSERT INTO `partio`.`suoritus` (`suoritus_id`, `suoritusnimi`, `partiomerkki`, `sisa_ulko`, `kesto_min`, `kuvaus`) VALUES (DEFAULT, 'Tutustun poliisin tai ammattiautoilijan työhön', 'liikenne', 'ulko', 120, 'Sudenpentu saa tietoa turvallisesta liikenteessä toimimisesta alan ammattilaiselta. Tutustuminen voidaan toteuttaa vierailemalla poliisilaitoksella tai kutsumalla poliisi tai ammattiautoilija vierailemaan koloillassa. Tutustuminen ammattiautoilijan työhön voidaan toteuttaa myös katsomalla verkosta löytyviä videoita tai muita aineistoja. Vieraaksi voidaan kutsua myös ammattiautoilija. ');
INSERT INTO `partio`.`suoritus` (`suoritus_id`, `suoritusnimi`, `partiomerkki`, `sisa_ulko`, `kesto_min`, `kuvaus`) VALUES (DEFAULT, 'Huollan pyörän', 'liikenne', 'ulko', 120, 'Sudenpentu harjoittelee tekemään pyörälleen perushuollon yhdessä aikuisen kanssa.');
INSERT INTO `partio`.`suoritus` (`suoritus_id`, `suoritusnimi`, `partiomerkki`, `sisa_ulko`, `kesto_min`, `kuvaus`) VALUES (DEFAULT, 'Käytän heijastinta ', 'liikenne', 'ulko', 30, 'Sudenpentu tutustuu heijastimen käyttöön ja testaa sen toimivuutta.');

COMMIT;


-- -----------------------------------------------------
-- Data for table `partio`.`partioryhma`
-- -----------------------------------------------------
START TRANSACTION;
USE `partio`;
INSERT INTO `partio`.`partioryhma` (`ryhma_id`, `ryhman_nimi`, `ikakausi`, `kokouspaiva`, `kokous_alkaa`, `kokous_loppuu`) VALUES (DEFAULT, 'Kokkopojat', 'sudenpennut', 'maanantai', '1800', '1900');
INSERT INTO `partio`.`partioryhma` (`ryhma_id`, `ryhman_nimi`, `ikakausi`, `kokouspaiva`, `kokous_alkaa`, `kokous_loppuu`) VALUES (DEFAULT, 'Kissankorvat', 'sudenpennut', 'torstai', '1830', '1930');
INSERT INTO `partio`.`partioryhma` (`ryhma_id`, `ryhman_nimi`, `ikakausi`, `kokouspaiva`, `kokous_alkaa`, `kokous_loppuu`) VALUES (DEFAULT, 'Juoksumattojen ulkoiluttajat', 'tarpojat', 'tiistai', '1800', '1930');
INSERT INTO `partio`.`partioryhma` (`ryhma_id`, `ryhman_nimi`, `ikakausi`, `kokouspaiva`, `kokous_alkaa`, `kokous_loppuu`) VALUES (DEFAULT, 'Johtoryhmä', 'samoajat', NULL, NULL, NULL);
INSERT INTO `partio`.`partioryhma` (`ryhma_id`, `ryhman_nimi`, `ikakausi`, `kokouspaiva`, `kokous_alkaa`, `kokous_loppuu`) VALUES (DEFAULT, 'Ketut', 'sudenpennut', 'keskiviikko', '1700', '1830');
INSERT INTO `partio`.`partioryhma` (`ryhma_id`, `ryhman_nimi`, `ikakausi`, `kokouspaiva`, `kokous_alkaa`, `kokous_loppuu`) VALUES (DEFAULT, 'Saukkoryhmä', 'seikkailijat', 'tiistai', '1700', '1800');
INSERT INTO `partio`.`partioryhma` (`ryhma_id`, `ryhman_nimi`, `ikakausi`, `kokouspaiva`, `kokous_alkaa`, `kokous_loppuu`) VALUES (DEFAULT, 'Vaeltajat', 'vaeltajat', NULL, NULL, NULL);
INSERT INTO `partio`.`partioryhma` (`ryhma_id`, `ryhman_nimi`, `ikakausi`, `kokouspaiva`, `kokous_alkaa`, `kokous_loppuu`) VALUES (DEFAULT, 'Kilikellot', 'sudenpennut', 'perjantai', '1700', '1800');
INSERT INTO `partio`.`partioryhma` (`ryhma_id`, `ryhman_nimi`, `ikakausi`, `kokouspaiva`, `kokous_alkaa`, `kokous_loppuu`) VALUES (DEFAULT, 'Porokoirat', 'sudenpennut', 'maanantai', '1715', '1830');
INSERT INTO `partio`.`partioryhma` (`ryhma_id`, `ryhman_nimi`, `ikakausi`, `kokouspaiva`, `kokous_alkaa`, `kokous_loppuu`) VALUES (DEFAULT, 'Hiihtohullut', 'seikkailijat', 'torstai', '1800', '1915');

COMMIT;


-- -----------------------------------------------------
-- Data for table `partio`.`kokous`
-- -----------------------------------------------------
START TRANSACTION;
USE `partio`;
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 1, '2023-10-1');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 1, '2023-11-1');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 1, '2023-12-1');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 1, '2024-1-15');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 1, '2024-2-1');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 1, '2024-3-1');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 2, '2020-9-1');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 2, '2020-10-1');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 2, '2020-11-1');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 2, '2020-12-1');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 2, '2021-2-1');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 2, '2021-3-1');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 2, '2021-4-1');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 2, '2021-5-1');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 3, '2020-11-11');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 3, '2021-11-11');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 3, '2021-12-12');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 3, '2022-11-11');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 3, '2022-12-12');
INSERT INTO `partio`.`kokous` (`kokous_id`, `ryhma_id`, `pvm`) VALUES (DEFAULT, 4, '2019-3-3');

COMMIT;


-- -----------------------------------------------------
-- Data for table `partio`.`kokous_suoritus`
-- -----------------------------------------------------
START TRANSACTION;
USE `partio`;
INSERT INTO `partio`.`kokous_suoritus` (`kokous_id`, `suoritus_id`) VALUES (1, 1);
INSERT INTO `partio`.`kokous_suoritus` (`kokous_id`, `suoritus_id`) VALUES (2, 2);
INSERT INTO `partio`.`kokous_suoritus` (`kokous_id`, `suoritus_id`) VALUES (3, 3);
INSERT INTO `partio`.`kokous_suoritus` (`kokous_id`, `suoritus_id`) VALUES (4, 4);
INSERT INTO `partio`.`kokous_suoritus` (`kokous_id`, `suoritus_id`) VALUES (5, 5);
INSERT INTO `partio`.`kokous_suoritus` (`kokous_id`, `suoritus_id`) VALUES (6, 6);
INSERT INTO `partio`.`kokous_suoritus` (`kokous_id`, `suoritus_id`) VALUES (7, 10);
INSERT INTO `partio`.`kokous_suoritus` (`kokous_id`, `suoritus_id`) VALUES (8, 9);
INSERT INTO `partio`.`kokous_suoritus` (`kokous_id`, `suoritus_id`) VALUES (9, 8);
INSERT INTO `partio`.`kokous_suoritus` (`kokous_id`, `suoritus_id`) VALUES (10, 7);
INSERT INTO `partio`.`kokous_suoritus` (`kokous_id`, `suoritus_id`) VALUES (11, 6);
INSERT INTO `partio`.`kokous_suoritus` (`kokous_id`, `suoritus_id`) VALUES (12, 5);
INSERT INTO `partio`.`kokous_suoritus` (`kokous_id`, `suoritus_id`) VALUES (13, 4);
INSERT INTO `partio`.`kokous_suoritus` (`kokous_id`, `suoritus_id`) VALUES (14, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `partio`.`partiolainen`
-- -----------------------------------------------------
START TRANSACTION;
USE `partio`;
INSERT INTO `partio`.`partiolainen` (`partiolainen_id`, `etunimi`, `sukunimi`, `syntymavuosi`, `puhelinnumero`, `katuosoite`, `postinumero`, `email`) VALUES (DEFAULT, 'Matti', 'Meikäläinen', '2004', '0401234567', 'Kattikuja 3 as 3', '70100', '');
INSERT INTO `partio`.`partiolainen` (`partiolainen_id`, `etunimi`, `sukunimi`, `syntymavuosi`, `puhelinnumero`, `katuosoite`, `postinumero`, `email`) VALUES (DEFAULT, 'Mikko', 'Makkinen', '2016', '0506830256', 'Jumakatu 5', '71800', 'mm@outlook.com');
INSERT INTO `partio`.`partiolainen` (`partiolainen_id`, `etunimi`, `sukunimi`, `syntymavuosi`, `puhelinnumero`, `katuosoite`, `postinumero`, `email`) VALUES (DEFAULT, 'Maija', 'Nuottanen', NULL, NULL, 'Huopatie 472', '70200', NULL);
INSERT INTO `partio`.`partiolainen` (`partiolainen_id`, `etunimi`, `sukunimi`, `syntymavuosi`, `puhelinnumero`, `katuosoite`, `postinumero`, `email`) VALUES (DEFAULT, 'Kaija', 'Lohinen', NULL, '04006516841', 'Nappitie 1', '70100', 'aeoirnga@gmail.com');
INSERT INTO `partio`.`partiolainen` (`partiolainen_id`, `etunimi`, `sukunimi`, `syntymavuosi`, `puhelinnumero`, `katuosoite`, `postinumero`, `email`) VALUES (DEFAULT, 'Janne', 'Vaikkunen', NULL, '0446531478', 'Kallenkuja 50 B 6', '71700', 'aerinioanmeptohm@hotmail.com');
INSERT INTO `partio`.`partiolainen` (`partiolainen_id`, `etunimi`, `sukunimi`, `syntymavuosi`, `puhelinnumero`, `katuosoite`, `postinumero`, `email`) VALUES (DEFAULT, 'Henna', 'Hallinen', NULL, NULL, 'Peikkopolku 46 as 1', '72900', NULL);
INSERT INTO `partio`.`partiolainen` (`partiolainen_id`, `etunimi`, `sukunimi`, `syntymavuosi`, `puhelinnumero`, `katuosoite`, `postinumero`, `email`) VALUES (DEFAULT, 'Hanne', 'Rauhanen', '2013', '0415684651', 'Kellokatu 92', '71800', NULL);
INSERT INTO `partio`.`partiolainen` (`partiolainen_id`, `etunimi`, `sukunimi`, `syntymavuosi`, `puhelinnumero`, `katuosoite`, `postinumero`, `email`) VALUES (DEFAULT, 'Olli', 'Venäläinen', NULL, '04035416844', 'Paitalantie 3', '69300', 'aoeinrpaiemr@gmail.com');
INSERT INTO `partio`.`partiolainen` (`partiolainen_id`, `etunimi`, `sukunimi`, `syntymavuosi`, `puhelinnumero`, `katuosoite`, `postinumero`, `email`) VALUES (DEFAULT, 'Elsa', 'Hiihtonen', '2015', NULL, 'Liikennetie 500', '70300', NULL);
INSERT INTO `partio`.`partiolainen` (`partiolainen_id`, `etunimi`, `sukunimi`, `syntymavuosi`, `puhelinnumero`, `katuosoite`, `postinumero`, `email`) VALUES (DEFAULT, 'Samu', 'Koivunen', NULL, NULL, 'Korukuja 8', '71300', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `partio`.`ryhmarooli`
-- -----------------------------------------------------
START TRANSACTION;
USE `partio`;
INSERT INTO `partio`.`ryhmarooli` (`partiolainen_id`, `ryhma_id`, `rooli`) VALUES (1, 2, 'johtaja');
INSERT INTO `partio`.`ryhmarooli` (`partiolainen_id`, `ryhma_id`, `rooli`) VALUES (1, 3, 'johtaja');
INSERT INTO `partio`.`ryhmarooli` (`partiolainen_id`, `ryhma_id`, `rooli`) VALUES (1, 7, DEFAULT);
INSERT INTO `partio`.`ryhmarooli` (`partiolainen_id`, `ryhma_id`, `rooli`) VALUES (2, 3, DEFAULT);
INSERT INTO `partio`.`ryhmarooli` (`partiolainen_id`, `ryhma_id`, `rooli`) VALUES (3, 3, DEFAULT);
INSERT INTO `partio`.`ryhmarooli` (`partiolainen_id`, `ryhma_id`, `rooli`) VALUES (4, 3, DEFAULT);
INSERT INTO `partio`.`ryhmarooli` (`partiolainen_id`, `ryhma_id`, `rooli`) VALUES (5, 3, DEFAULT);
INSERT INTO `partio`.`ryhmarooli` (`partiolainen_id`, `ryhma_id`, `rooli`) VALUES (6, 1, DEFAULT);
INSERT INTO `partio`.`ryhmarooli` (`partiolainen_id`, `ryhma_id`, `rooli`) VALUES (7, 1, DEFAULT);
INSERT INTO `partio`.`ryhmarooli` (`partiolainen_id`, `ryhma_id`, `rooli`) VALUES (8, 1, DEFAULT);
INSERT INTO `partio`.`ryhmarooli` (`partiolainen_id`, `ryhma_id`, `rooli`) VALUES (9, 1, DEFAULT);
INSERT INTO `partio`.`ryhmarooli` (`partiolainen_id`, `ryhma_id`, `rooli`) VALUES (10, 2, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `partio`.`kokous_osallistuja`
-- -----------------------------------------------------
START TRANSACTION;
USE `partio`;
INSERT INTO `partio`.`kokous_osallistuja` (`partiolainen_id`, `kokous_id`) VALUES (6, 1);
INSERT INTO `partio`.`kokous_osallistuja` (`partiolainen_id`, `kokous_id`) VALUES (6, 2);
INSERT INTO `partio`.`kokous_osallistuja` (`partiolainen_id`, `kokous_id`) VALUES (6, 3);
INSERT INTO `partio`.`kokous_osallistuja` (`partiolainen_id`, `kokous_id`) VALUES (6, 4);
INSERT INTO `partio`.`kokous_osallistuja` (`partiolainen_id`, `kokous_id`) VALUES (6, 5);
INSERT INTO `partio`.`kokous_osallistuja` (`partiolainen_id`, `kokous_id`) VALUES (6, 6);
INSERT INTO `partio`.`kokous_osallistuja` (`partiolainen_id`, `kokous_id`) VALUES (10, 7);
INSERT INTO `partio`.`kokous_osallistuja` (`partiolainen_id`, `kokous_id`) VALUES (10, 8);
INSERT INTO `partio`.`kokous_osallistuja` (`partiolainen_id`, `kokous_id`) VALUES (10, 9);
INSERT INTO `partio`.`kokous_osallistuja` (`partiolainen_id`, `kokous_id`) VALUES (10, 10);
INSERT INTO `partio`.`kokous_osallistuja` (`partiolainen_id`, `kokous_id`) VALUES (10, 11);
INSERT INTO `partio`.`kokous_osallistuja` (`partiolainen_id`, `kokous_id`) VALUES (10, 12);
INSERT INTO `partio`.`kokous_osallistuja` (`partiolainen_id`, `kokous_id`) VALUES (10, 13);
INSERT INTO `partio`.`kokous_osallistuja` (`partiolainen_id`, `kokous_id`) VALUES (10, 14);

COMMIT;
