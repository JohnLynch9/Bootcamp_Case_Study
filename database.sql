-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for test_case_study
CREATE DATABASE IF NOT EXISTS `test_case_study` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test_case_study`;

-- Dumping structure for table test_case_study.art
CREATE TABLE IF NOT EXISTS `art` (
  `artname` varchar(50) NOT NULL,
  `artistname` varchar(50) NOT NULL,
  `imageaddress` varchar(250) NOT NULL DEFAULT '',
  `useremail` varchar(50) NOT NULL,
  PRIMARY KEY (`artname`),
  KEY `useremail` (`useremail`),
  CONSTRAINT `art_ibfk_1` FOREIGN KEY (`useremail`) REFERENCES `user` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table test_case_study.message
CREATE TABLE IF NOT EXISTS `message` (
  `messageid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `content` varchar(50) NOT NULL,
  `useremail` varchar(50) NOT NULL,
  PRIMARY KEY (`messageid`),
  KEY `useremail` (`useremail`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`useremail`) REFERENCES `user` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table test_case_study.user
CREATE TABLE IF NOT EXISTS `user` (
  `email` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
