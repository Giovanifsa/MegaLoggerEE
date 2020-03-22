CREATE TABLE IF NOT EXISTS `Player` (
  `idPlayer` BIGINT NOT NULL,
  `steamID64` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`idPlayer`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Server` (
  `idServer` BIGINT NOT NULL,
  `idUser` BIGINT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `lastIp` VARCHAR(16) NULL,
  `port` INT NULL,
  PRIMARY KEY (`idServer`),
  INDEX `fk_Server_User1_idx` (`idUser` ASC) VISIBLE,
  CONSTRAINT `fk_Server_User1`
    FOREIGN KEY (`idUser`)
    REFERENCES `User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `PlayerConnection` (
  `idPlayerConnection` BIGINT NOT NULL,
  `dateTime` TIMESTAMP NOT NULL,
  `idPlayer` BIGINT NOT NULL,
  `idServer` BIGINT NOT NULL,
  `ip` VARCHAR(16) NOT NULL,
  `port` INT NOT NULL,
  PRIMARY KEY (`idPlayerConnection`),
  INDEX `fk_PlayerConnection_Player1_idx` (`idPlayer` ASC) VISIBLE,
  INDEX `fk_PlayerConnection_Server1_idx` (`idServer` ASC) VISIBLE,
  CONSTRAINT `fk_PlayerConnection_Player1`
    FOREIGN KEY (`idPlayer`)
    REFERENCES `Player` (`idPlayer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PlayerConnection_Server1`
    FOREIGN KEY (`idServer`)
    REFERENCES `Server` (`idServer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `PlayerName` (
  `idPlayerName` BIGINT NOT NULL,
  `dateTime` TIMESTAMP NOT NULL,
  `idPlayerConnection` BIGINT NOT NULL,
  `name` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`idPlayerName`),
  INDEX `fk_PlayerName_PlayerConnection1_idx` (`idPlayerConnection` ASC) VISIBLE,
  CONSTRAINT `fk_PlayerName_PlayerConnection1`
    FOREIGN KEY (`idPlayerConnection`)
    REFERENCES `PlayerConnection` (`idPlayerConnection`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `PlayerMessage` (
  `idPlayerMessage` BIGINT NOT NULL,
  `idPlayerConnection` BIGINT NOT NULL,
  `message` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`idPlayerMessage`),
  INDEX `fk_PlayerMessage_PlayerConnection1_idx` (`idPlayerConnection` ASC) VISIBLE,
  CONSTRAINT `fk_PlayerMessage_PlayerConnection1`
    FOREIGN KEY (`idPlayerConnection`)
    REFERENCES `PlayerConnection` (`idPlayerConnection`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `PlayerNetSettings` (
  `idPlayerNetSettings` BIGINT NOT NULL,
  `idPlayerConnection` BIGINT NOT NULL,
  `cl_interp` DECIMAL(10,9) NOT NULL,
  `cl_interp_ratio` DECIMAL(12,6) NOT NULL,
  `cl_cmdrate` BIGINT NOT NULL,
  `cl_updaterate` BIGINT NOT NULL,
  `rate` BIGINT NOT NULL,
  PRIMARY KEY (`idPlayerNetSettings`),
  INDEX `fk_PlayerNetSettings_PlayerConnection1_idx` (`idPlayerConnection` ASC) VISIBLE,
  CONSTRAINT `fk_PlayerNetSettings_PlayerConnection1`
    FOREIGN KEY (`idPlayerConnection`)
    REFERENCES `PlayerConnection` (`idPlayerConnection`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `PlayerGameSettings` (
  `idPlayerGameSettings` BIGINT NOT NULL,
  `idPlayerConnection` BIGINT NOT NULL,
  `sensitivity` DECIMAL(12,6) NOT NULL,
  PRIMARY KEY (`idPlayerGameSettings`),
  INDEX `fk_PlayerGameSettings_PlayerConnection1_idx` (`idPlayerConnection` ASC) VISIBLE,
  CONSTRAINT `fk_PlayerGameSettings_PlayerConnection1`
    FOREIGN KEY (`idPlayerConnection`)
    REFERENCES `PlayerConnection` (`idPlayerConnection`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;