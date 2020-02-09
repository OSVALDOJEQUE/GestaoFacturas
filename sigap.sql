-- MySQL Script generated by MySQL Workbench
-- Wed Feb  5 09:52:28 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sigap
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sigap
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sigap` DEFAULT CHARACTER SET utf8 ;
USE `sigap` ;

-- -----------------------------------------------------
-- Table `sigap`.`Cargo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sigap`.`Cargo` ;

CREATE TABLE IF NOT EXISTS `sigap`.`Cargo` (
  `idCargo` INT NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCargo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sigap`.`Patente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sigap`.`Patente` ;

CREATE TABLE IF NOT EXISTS `sigap`.`Patente` (
  `idPatente` INT NOT NULL AUTO_INCREMENT,
  `patente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPatente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sigap`.`Direccao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sigap`.`Direccao` ;

CREATE TABLE IF NOT EXISTS `sigap`.`Direccao` (
  `idDireccao` INT NOT NULL AUTO_INCREMENT,
  `Direccao` VARCHAR(45) NULL,
  PRIMARY KEY (`idDireccao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sigap`.`Departamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sigap`.`Departamento` ;

CREATE TABLE IF NOT EXISTS `sigap`.`Departamento` (
  `idDepartamento` INT NOT NULL AUTO_INCREMENT,
  `departamento` VARCHAR(45) NOT NULL,
  `Direccao_idDireccao` INT NOT NULL,
  PRIMARY KEY (`idDepartamento`, `Direccao_idDireccao`),
  INDEX `fk_Departamento_Direccao1_idx` (`Direccao_idDireccao` ASC),
  CONSTRAINT `fk_Departamento_Direccao1`
    FOREIGN KEY (`Direccao_idDireccao`)
    REFERENCES `sigap`.`Direccao` (`idDireccao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sigap`.`Sector`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sigap`.`Sector` ;

CREATE TABLE IF NOT EXISTS `sigap`.`Sector` (
  `idSector` INT NOT NULL AUTO_INCREMENT,
  `Sector` VARCHAR(45) NOT NULL,
  `Departamento_idDepartamento` INT NOT NULL,
  `Departamento_Direccao_idDireccao` INT NOT NULL,
  PRIMARY KEY (`idSector`, `Departamento_idDepartamento`, `Departamento_Direccao_idDireccao`),
  INDEX `fk_Sector_Departamento1_idx` (`Departamento_idDepartamento` ASC, `Departamento_Direccao_idDireccao` ASC),
  CONSTRAINT `fk_Sector_Departamento1`
    FOREIGN KEY (`Departamento_idDepartamento` , `Departamento_Direccao_idDireccao`)
    REFERENCES `sigap`.`Departamento` (`idDepartamento` , `Direccao_idDireccao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sigap`.`Agente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sigap`.`Agente` ;

CREATE TABLE IF NOT EXISTS `sigap`.`Agente` (
  `idAgente` INT NOT NULL AUTO_INCREMENT,
  `Nip` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `DataNasc` DATE NOT NULL,
  `NomePai` VARCHAR(45) NULL,
  `NomeMae` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `Provincia` INT NULL,
  `Sexo` ENUM('M', 'F') NOT NULL,
  `EstadoCivil` ENUM('S', 'C') NOT NULL,
  `BI` VARCHAR(13) NOT NULL,
  `NivelAcademico` VARCHAR(45) NOT NULL,
  `GrupoSanguineo` ENUM('O-', 'O+', 'A-', 'A+', 'B-', 'B+', 'AB-', 'AB+') NULL,
  `Altura` DECIMAL(3,2) NULL,
  `Cintura` INT(3) NULL,
  `NrSapato` INT(2) NULL,
  `ProcessoDisciplinar` VARCHAR(45) NULL,
  `Celular` INT(9) NULL,
  `pReferencias` VARCHAR(45) NULL,
  `AnoEntrada` DATETIME NULL,
  `Esquadra` VARCHAR(45) NULL,
  `Distrito` VARCHAR(45) NULL,
  `Provincias` VARCHAR(45) NULL,
  `Foto` VARCHAR(45) NULL,
  `Agentecol` VARCHAR(45) NULL,
  `Direccao_Departamento_idDepartamento` INT NOT NULL,
  `Cargo_idCargo` INT NOT NULL,
  `Patente_idPatente` INT NOT NULL,
  `Sector_idSector` INT NOT NULL,
  PRIMARY KEY (`idAgente`, `Direccao_Departamento_idDepartamento`, `Cargo_idCargo`, `Patente_idPatente`, `Sector_idSector`),
  INDEX `fk_Agente_Cargo1_idx` (`Cargo_idCargo` ASC),
  INDEX `fk_Agente_Patente1_idx` (`Patente_idPatente` ASC),
  INDEX `fk_Agente_Sector1_idx` (`Sector_idSector` ASC),
  CONSTRAINT `fk_Agente_Cargo1`
    FOREIGN KEY (`Cargo_idCargo`)
    REFERENCES `sigap`.`Cargo` (`idCargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Agente_Patente1`
    FOREIGN KEY (`Patente_idPatente`)
    REFERENCES `sigap`.`Patente` (`idPatente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Agente_Sector1`
    FOREIGN KEY (`Sector_idSector`)
    REFERENCES `sigap`.`Sector` (`idSector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;