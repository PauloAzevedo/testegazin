-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.31-0ubuntu0.18.04.1


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema prova_gazin
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ prova_gazin;
USE prova_gazin;

--
-- Table structure for table `prova_gazin`.`Developer`
--

DROP TABLE IF EXISTS `Developer`;
CREATE TABLE `Developer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataNascimento` datetime DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `idade` int(11) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `sexo` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prova_gazin`.`Developer`
--

/*!40000 ALTER TABLE `Developer` DISABLE KEYS */;
INSERT INTO `Developer` (`id`,`dataNascimento`,`hobby`,`idade`,`nome`,`sexo`) VALUES 
 (9,'1990-10-20 00:00:00','Contabilidade ',30,'ANA CELIA GONÇALVES','F'),
 (10,'2010-02-24 00:00:00','Assistir desenho e cozinhar',10,'Maria Beatriz','F'),
 (11,'1988-05-22 00:00:00','Testede cadastro.',32,'Paulo Azevedo','M');
/*!40000 ALTER TABLE `Developer` ENABLE KEYS */;


--
-- Table structure for table `prova_gazin`.`Perfil`
--

DROP TABLE IF EXISTS `Perfil`;
CREATE TABLE `Perfil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prova_gazin`.`Perfil`
--

/*!40000 ALTER TABLE `Perfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `Perfil` ENABLE KEYS */;


--
-- Table structure for table `prova_gazin`.`UsuarioApi`
--

DROP TABLE IF EXISTS `UsuarioApi`;
CREATE TABLE `UsuarioApi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prova_gazin`.`UsuarioApi`
--

/*!40000 ALTER TABLE `UsuarioApi` DISABLE KEYS */;
/*!40000 ALTER TABLE `UsuarioApi` ENABLE KEYS */;


--
-- Table structure for table `prova_gazin`.`UsuarioApi_Perfil`
--

DROP TABLE IF EXISTS `UsuarioApi_Perfil`;
CREATE TABLE `UsuarioApi_Perfil` (
  `UsuarioApi_id` bigint(20) NOT NULL,
  `perfil_id` bigint(20) NOT NULL,
  KEY `FKciad9us863csrfhv692pjlngq` (`perfil_id`),
  KEY `FKot44xnjrqfctk6e4wlsa2yvaq` (`UsuarioApi_id`),
  CONSTRAINT `FKciad9us863csrfhv692pjlngq` FOREIGN KEY (`perfil_id`) REFERENCES `Perfil` (`id`),
  CONSTRAINT `FKot44xnjrqfctk6e4wlsa2yvaq` FOREIGN KEY (`UsuarioApi_id`) REFERENCES `UsuarioApi` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prova_gazin`.`UsuarioApi_Perfil`
--

/*!40000 ALTER TABLE `UsuarioApi_Perfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `UsuarioApi_Perfil` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
