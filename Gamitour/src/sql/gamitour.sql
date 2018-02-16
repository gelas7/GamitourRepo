-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema gamitour
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gamitour
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gamitour` DEFAULT CHARACTER SET utf8 ;
USE `gamitour` ;

-- -----------------------------------------------------
-- Table `gamitour`.`itinerario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamitour`.`itinerario` (
  `iditinerario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NULL,
  `categoria` VARCHAR(45) NULL,
  `duracion` VARCHAR(15) NULL,
  `ubicacion` VARCHAR(45) NULL,
  PRIMARY KEY (`iditinerario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamitour`.`parada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamitour`.`parada` (
  `idparada` INT NOT NULL AUTO_INCREMENT  ,
  `nombre` VARCHAR(60) NULL,
  `numeroParada` INT NULL,
  `ubicacion` VARCHAR(45) NULL,
  `historia` VARCHAR(200) NULL,
  `anecdotario` VARCHAR(200) NULL,
  `gastronomia` VARCHAR(200) NULL,
  `imagen` VARCHAR(45) NULL,
  `itinerario_iditinerario` INT NOT NULL,
  PRIMARY KEY (`idparada`),
  INDEX `fk_parada_itinerario_idx` (`itinerario_iditinerario` ASC),
  CONSTRAINT `fk_parada_itinerario`
    FOREIGN KEY (`itinerario_iditinerario`)
    REFERENCES `gamitour`.`itinerario` (`iditinerario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamitour`.`actividad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamitour`.`actividad` (
  `idactividad` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NULL,
  `fechainicio` DATE NULL,
  `fechafin` DATE NULL,
  `ubicacion` VARCHAR(60) NULL,
  `numparticipantes` INT NULL,
  `precio` FLOAT NULL,
  `imagen` VARCHAR(60) NULL,
  `puntos` INT NULL,
  PRIMARY KEY (`idactividad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamitour`.`pruebaCultural`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamitour`.`pruebaCultural` (
  `idpruebacultural` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NULL,
  `pregunta` VARCHAR(200) NULL,
  `respuesta` VARCHAR(45) NULL,
  `puntos` INT NULL,
  `parada_idparada` INT NOT NULL,
  PRIMARY KEY (`idpruebacultural`),
  INDEX `fk_pruebaCultural_parada1_idx` (`parada_idparada` ASC),
  CONSTRAINT `fk_pruebaCultural_parada1`
    FOREIGN KEY (`parada_idparada`)
    REFERENCES `gamitour`.`parada` (`idparada`)
    ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamitour`.`pruebaDeportiva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamitour`.`pruebaDeportiva` (
  `idpruebadeportiva` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NULL,
  `fechainicio` DATE NULL,
  `fechafin` DATE NULL,
  `explicacion` VARCHAR(200) NULL,
  `puntos` INT NULL,
  `parada_idparada` INT NOT NULL,
  PRIMARY KEY (`idpruebadeportiva`),
  INDEX `fk_pruebaDeportiva_parada1_idx` (`parada_idparada` ASC),
  CONSTRAINT `fk_pruebaDeportiva_parada1`
    FOREIGN KEY (`parada_idparada`)
    REFERENCES `gamitour`.`parada` (`idparada`)
    ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamitour`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamitour`.`rol` (
  `idrol` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NULL,
  PRIMARY KEY (`idrol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamitour`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamitour`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NULL,
  `apellidos` VARCHAR(60) NULL,
  `fechanacimiento` DATE NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `direccion` VARCHAR(60) NULL,
  `codigopostal` VARCHAR(10) NULL,
  `avatar` VARCHAR(45) NULL,
  `puntosacumulados` INT NULL,
  `fecharegistro` DATE NULL,
  `rol_idrol` INT NOT NULL,
  PRIMARY KEY (`idcliente`),
  INDEX `fk_cliente_rol1_idx` (`rol_idrol` ASC),
  CONSTRAINT `fk_cliente_rol1`
    FOREIGN KEY (`rol_idrol`)
    REFERENCES `gamitour`.`rol` (`idrol`)
    ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamitour`.`cliente_has_actividad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamitour`.`cliente_has_actividad` (
  `cliente_idcliente` INT NOT NULL,
  `actividad_idactividad` INT NOT NULL,
  PRIMARY KEY (`cliente_idcliente`, `actividad_idactividad`),
  INDEX `fk_cliente_has_actividad_actividad1_idx` (`actividad_idactividad` ASC),
  INDEX `fk_cliente_has_actividad_cliente1_idx` (`cliente_idcliente` ASC),
  CONSTRAINT `fk_cliente_has_actividad_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `gamitour`.`cliente` (`idcliente`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cliente_has_actividad_actividad1`
    FOREIGN KEY (`actividad_idactividad`)
    REFERENCES `gamitour`.`actividad` (`idactividad`)
    ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamitour`.`multimedia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamitour`.`multimedia` (
  `idmultimedia` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL,
  `comentario` VARCHAR(60) NULL,
  `imagen` VARCHAR(60) NULL,
  `video` VARCHAR(60) NULL,
  `cliente_idcliente` INT NOT NULL,
  `pruebaDeportiva_idpruebadeportiva` INT NOT NULL,
  `puntosacumulados` INT NULL,
  PRIMARY KEY (`idmultimedia`),
  INDEX `fk_multimedia_cliente1_idx` (`cliente_idcliente` ASC),
  INDEX `fk_multimedia_pruebaDeportiva1_idx` (`pruebaDeportiva_idpruebadeportiva` ASC),
  CONSTRAINT `fk_multimedia_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `gamitour`.`cliente` (`idcliente`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_multimedia_pruebaDeportiva1`
    FOREIGN KEY (`pruebaDeportiva_idpruebadeportiva`)
    REFERENCES `gamitour`.`pruebaDeportiva` (`idpruebadeportiva`)
    ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamitour`.`comentario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamitour`.`comentario` (
  `idcomentario` INT NOT NULL AUTO_INCREMENT,
  `texto` VARCHAR(200) NULL,
  `cliente_idcliente` INT NOT NULL,
  `multimedia_idmultimedia` INT NOT NULL,
  PRIMARY KEY (`idcomentario`),
  INDEX `fk_comentario_cliente1_idx` (`cliente_idcliente` ASC),
  INDEX `fk_comentario_multimedia1_idx` (`multimedia_idmultimedia` ASC),
  CONSTRAINT `fk_comentario_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `gamitour`.`cliente` (`idcliente`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_comentario_multimedia1`
    FOREIGN KEY (`multimedia_idmultimedia`)
    REFERENCES `gamitour`.`multimedia` (`idmultimedia`)
    ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamitour`.`voto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamitour`.`voto` (
  `idvoto` INT NOT NULL AUTO_INCREMENT,
  `puntos` INT NULL,
  `cliente_idcliente` INT NOT NULL,
  `multimedia_idmultimedia` INT NOT NULL,
  PRIMARY KEY (`idvoto`),
  INDEX `fk_voto_cliente1_idx` (`cliente_idcliente` ASC),
  INDEX `fk_voto_multimedia1_idx` (`multimedia_idmultimedia` ASC),
  CONSTRAINT `fk_voto_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `gamitour`.`cliente` (`idcliente`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_voto_multimedia1`
    FOREIGN KEY (`multimedia_idmultimedia`)
    REFERENCES `gamitour`.`multimedia` (`idmultimedia`)
    ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamitour`.`premio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamitour`.`premio` (
  `idpremio` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NULL,
  `descripcion` VARCHAR(200) NULL,
  `imagen` VARCHAR(45) NULL,
  `fechaactivacion` DATE NULL,
  `fechaconsumo` DATE NULL,
  `puntos` INT NULL,
  `cliente_idcliente` INT NOT NULL,
  PRIMARY KEY (`idpremio`),
  INDEX `fk_premio_cliente1_idx` (`cliente_idcliente` ASC),
  CONSTRAINT `fk_premio_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `gamitour`.`cliente` (`idcliente`)
    ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamitour`.`noticia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamitour`.`noticia` (
  `idnoticia` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NULL,
  `texto` VARCHAR(200) NULL,
  `fechaalta` DATE NULL,
  `fechacaducidad` DATE NULL,
  `imagen` VARCHAR(45) NULL,
  PRIMARY KEY (`idnoticia`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
