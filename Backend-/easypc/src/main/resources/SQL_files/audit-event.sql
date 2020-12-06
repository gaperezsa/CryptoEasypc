-- -----------------------------------------------------
-- Table `mydb`.`auditevent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `easypc`.`auditevent` ;

CREATE TABLE IF NOT EXISTS `easypc`.`auditevent` (
  `id_event` INT NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_event`));


-- -----------------------------------------------------
-- Table `mydb`.`auditeventlog`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `easypc`.`auditeventlog` ;

CREATE TABLE IF NOT EXISTS `easypc`.`auditeventlog` (
  `id_log` INT NOT NULL,
  `date` DATE NOT NULL,
  `detail` VARCHAR(200) NOT NULL,
  `client_ip` VARCHAR(45) NOT NULL,
  `id_event` INT NOT NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id_log`, `id_event`, `id_user`),
  INDEX `fk_auditeventlog_auditevent1_idx` (`id_event` ASC) VISIBLE,
  INDEX `fk_auditeventlog_User1_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `fk_auditeventlog_auditevent1`
    FOREIGN KEY (`id_event`)
    REFERENCES `easypc`.`auditevent` (`id_event`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_auditeventlog_User1`
    FOREIGN KEY (`id_user`)
    REFERENCES `easypc`.`User` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);