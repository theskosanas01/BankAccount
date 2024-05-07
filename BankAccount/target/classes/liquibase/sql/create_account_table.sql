CREATE DATABASE IF NOT EXISTS `bank`;
USE `bank`;

CREATE TABLE `bank`.`accounts` (
                                   `accountid` INT NOT NULL,
                                   `balance` DECIMAL NULL,
                                   `active`  tinyint(1),
                                   PRIMARY KEY (`accountid`),
                                   UNIQUE INDEX `accountid_UNIQUE` (`accountid` ASC) VISIBLE);