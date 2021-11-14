-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: ManagerDocuments
-- ------------------------------------------------------
-- Server version	5.5.5-10.6.5-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `creationdoc`
--

DROP TABLE IF EXISTS `creationdoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creationdoc` (
  `Id_CreationDoc` int(11) NOT NULL AUTO_INCREMENT,
  `DateCreation` datetime DEFAULT NULL,
  `Id_Utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`Id_CreationDoc`),
  KEY `Id_Utilisateur` (`Id_Utilisateur`),
  CONSTRAINT `creationdoc_ibfk_1` FOREIGN KEY (`Id_Utilisateur`) REFERENCES `utilisateur` (`Id_Utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creationdoc`
--

LOCK TABLES `creationdoc` WRITE;
/*!40000 ALTER TABLE `creationdoc` DISABLE KEYS */;
/*!40000 ALTER TABLE `creationdoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document` (
  `Id_Document` int(11) NOT NULL AUTO_INCREMENT,
  `Nom_Document` varchar(50) DEFAULT NULL,
  `DateDocument` datetime DEFAULT NULL,
  `DateScan` datetime DEFAULT NULL,
  `Flag_Document` tinyint(1) DEFAULT NULL,
  `Id_CreationDoc` int(11) NOT NULL,
  `Id_Type_De_Document` int(11) NOT NULL,
  PRIMARY KEY (`Id_Document`),
  KEY `Id_CreationDoc` (`Id_CreationDoc`),
  KEY `Id_Type_De_Document` (`Id_Type_De_Document`),
  CONSTRAINT `document_ibfk_1` FOREIGN KEY (`Id_CreationDoc`) REFERENCES `creationdoc` (`Id_CreationDoc`),
  CONSTRAINT `document_ibfk_2` FOREIGN KEY (`Id_Type_De_Document`) REFERENCES `type_de_document` (`Id_Type_De_Document`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_temp`
--

DROP TABLE IF EXISTS `document_temp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document_temp` (
  `Id_Document_Temp` int(11) NOT NULL AUTO_INCREMENT,
  `Nom_Document_Temp` varchar(50) DEFAULT NULL,
  `Date_Document_Temp` datetime DEFAULT NULL,
  PRIMARY KEY (`Id_Document_Temp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_temp`
--

LOCK TABLES `document_temp` WRITE;
/*!40000 ALTER TABLE `document_temp` DISABLE KEYS */;
/*!40000 ALTER TABLE `document_temp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dossier`
--

DROP TABLE IF EXISTS `dossier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dossier` (
  `Id_Dossier` int(11) NOT NULL AUTO_INCREMENT,
  `Nom_Dossier` varchar(50) DEFAULT NULL,
  `Flag_Dossier` tinyint(1) DEFAULT NULL,
  `Id_Type_Dossier` int(11) NOT NULL,
  PRIMARY KEY (`Id_Dossier`),
  KEY `Id_Type_Dossier` (`Id_Type_Dossier`),
  CONSTRAINT `dossier_ibfk_1` FOREIGN KEY (`Id_Type_Dossier`) REFERENCES `type_dossier` (`Id_Type_Dossier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dossier`
--

LOCK TABLES `dossier` WRITE;
/*!40000 ALTER TABLE `dossier` DISABLE KEYS */;
/*!40000 ALTER TABLE `dossier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `niv_scan`
--

DROP TABLE IF EXISTS `niv_scan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `niv_scan` (
  `Id_Niveau` int(11) NOT NULL,
  `Id_Scan` int(11) NOT NULL,
  PRIMARY KEY (`Id_Niveau`,`Id_Scan`),
  KEY `Id_Scan` (`Id_Scan`),
  CONSTRAINT `niv_scan_ibfk_1` FOREIGN KEY (`Id_Niveau`) REFERENCES `niveau` (`Id_Niveau`),
  CONSTRAINT `niv_scan_ibfk_2` FOREIGN KEY (`Id_Scan`) REFERENCES `scan` (`Id_Scan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `niv_scan`
--

LOCK TABLES `niv_scan` WRITE;
/*!40000 ALTER TABLE `niv_scan` DISABLE KEYS */;
/*!40000 ALTER TABLE `niv_scan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `niveau` (
  `Id_Niveau` int(11) NOT NULL AUTO_INCREMENT,
  `Nom_Niveau` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id_Niveau`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `niveau`
--

LOCK TABLES `niveau` WRITE;
/*!40000 ALTER TABLE `niveau` DISABLE KEYS */;
/*!40000 ALTER TABLE `niveau` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametre`
--

DROP TABLE IF EXISTS `parametre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametre` (
  `Id_Parametre` int(11) NOT NULL AUTO_INCREMENT,
  `Path_Stock` varchar(300) DEFAULT NULL,
  `Path_Backup` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`Id_Parametre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametre`
--

LOCK TABLES `parametre` WRITE;
/*!40000 ALTER TABLE `parametre` DISABLE KEYS */;
/*!40000 ALTER TABLE `parametre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reference`
--

DROP TABLE IF EXISTS `reference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reference` (
  `Id_Reference` int(11) NOT NULL AUTO_INCREMENT,
  `Nom_Reference` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id_Reference`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reference`
--

LOCK TABLES `reference` WRITE;
/*!40000 ALTER TABLE `reference` DISABLE KEYS */;
/*!40000 ALTER TABLE `reference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scan`
--

DROP TABLE IF EXISTS `scan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scan` (
  `Id_Scan` int(11) NOT NULL AUTO_INCREMENT,
  `Nom_Scan` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`Id_Scan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scan`
--

LOCK TABLES `scan` WRITE;
/*!40000 ALTER TABLE `scan` DISABLE KEYS */;
/*!40000 ALTER TABLE `scan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_de_document`
--

DROP TABLE IF EXISTS `type_de_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_de_document` (
  `Id_Type_De_Document` int(11) NOT NULL AUTO_INCREMENT,
  `Nom_TypeDoc` varchar(50) DEFAULT NULL,
  `Flag_TypeDoc` tinyint(1) DEFAULT NULL,
  `Id_Dossier` int(11) NOT NULL,
  PRIMARY KEY (`Id_Type_De_Document`),
  KEY `Id_Dossier` (`Id_Dossier`),
  CONSTRAINT `type_de_document_ibfk_1` FOREIGN KEY (`Id_Dossier`) REFERENCES `dossier` (`Id_Dossier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_de_document`
--

LOCK TABLES `type_de_document` WRITE;
/*!40000 ALTER TABLE `type_de_document` DISABLE KEYS */;
/*!40000 ALTER TABLE `type_de_document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_dossier`
--

DROP TABLE IF EXISTS `type_dossier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_dossier` (
  `Id_Type_Dossier` int(11) NOT NULL AUTO_INCREMENT,
  `Nom_TypeDossier` varchar(50) DEFAULT NULL,
  `Flag_TypeDossier` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Id_Type_Dossier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_dossier`
--

LOCK TABLES `type_dossier` WRITE;
/*!40000 ALTER TABLE `type_dossier` DISABLE KEYS */;
/*!40000 ALTER TABLE `type_dossier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typer`
--

DROP TABLE IF EXISTS `typer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `typer` (
  `Id_Document` int(11) NOT NULL,
  `Id_Reference` int(11) NOT NULL,
  PRIMARY KEY (`Id_Document`,`Id_Reference`),
  KEY `Id_Reference` (`Id_Reference`),
  CONSTRAINT `typer_ibfk_1` FOREIGN KEY (`Id_Document`) REFERENCES `document` (`Id_Document`),
  CONSTRAINT `typer_ibfk_2` FOREIGN KEY (`Id_Reference`) REFERENCES `reference` (`Id_Reference`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typer`
--

LOCK TABLES `typer` WRITE;
/*!40000 ALTER TABLE `typer` DISABLE KEYS */;
/*!40000 ALTER TABLE `typer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utilisateur` (
  `Id_Utilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) DEFAULT NULL,
  `Prenom` varchar(50) DEFAULT NULL,
  `Login` varchar(50) DEFAULT NULL,
  `Mdp` varchar(50) DEFAULT NULL,
  `Flag_Utilisateur` tinyint(1) DEFAULT NULL,
  `Id_Niveau` int(11) NOT NULL,
  PRIMARY KEY (`Id_Utilisateur`),
  KEY `Id_Niveau` (`Id_Niveau`),
  CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`Id_Niveau`) REFERENCES `niveau` (`Id_Niveau`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ManagerDocuments'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-14 18:27:25
