-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: testdm
-- ------------------------------------------------------
-- Server version	5.5.5-10.6.0-MariaDB

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creationdoc`
--

LOCK TABLES `creationdoc` WRITE;
/*!40000 ALTER TABLE `creationdoc` DISABLE KEYS */;
INSERT INTO `creationdoc` VALUES (1,'2003-01-11 00:00:00',1),(2,'2004-02-12 00:00:00',2),(3,'2005-01-06 00:00:00',3),(4,'2006-02-04 00:00:00',4),(5,'2006-06-06 00:00:00',1);
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
  `Nom_Document` varchar(200) DEFAULT NULL,
  `DateDocument` datetime DEFAULT NULL,
  `DateScan` datetime DEFAULT NULL,
  `Flag_document` tinyint(1) DEFAULT NULL,
  `Id_CreationDoc` int(11) DEFAULT NULL,
  `Id_Type_De_Document` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_Document`),
  KEY `Id_CreationDoc` (`Id_CreationDoc`),
  KEY `Id_Type_De_Document` (`Id_Type_De_Document`),
  CONSTRAINT `document_ibfk_1` FOREIGN KEY (`Id_CreationDoc`) REFERENCES `creationdoc` (`Id_CreationDoc`),
  CONSTRAINT `document_ibfk_2` FOREIGN KEY (`Id_Type_De_Document`) REFERENCES `type_de_document` (`Id_Type_De_Document`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` VALUES (1,'All MATLAB Books Collection','2008-04-06 00:00:00','2019-03-05 00:00:00',0,4,3),(2,'Cisco','2014-09-12 00:00:00','2019-02-08 00:00:00',0,2,1),(3,'DiaNeil','2001-12-12 00:00:00','2008-12-02 00:00:00',1,2,3),(4,'GameDev PDF','2013-12-09 00:00:00','2006-06-10 00:00:00',0,1,3),(5,'Hack Ressources','2013-06-11 00:00:00','2001-05-08 00:00:00',0,3,3),(6,'Math_Phys','2019-03-01 00:00:00','2013-05-03 00:00:00',0,5,3),(7,'OS pdf','2003-03-03 00:00:00','2021-05-06 00:00:00',0,4,2),(8,'PowerShell','2015-02-08 00:00:00','2001-11-07 00:00:00',0,5,3),(9,'Progra&Web','2003-01-07 00:00:00','2014-08-11 00:00:00',0,1,1),(10,'Remédiation','2018-04-08 00:00:00','2022-05-11 00:00:00',0,4,1),(11,'reseau','2006-10-12 00:00:00','2002-01-09 00:00:00',0,5,3),(12,'0123706173-physical_chemistry__third_edition.pdf','2011-06-09 00:00:00','2009-03-07 00:00:00',0,3,3),(13,'0201704315.pdf','2020-01-03 00:00:00','2007-05-04 00:00:00',0,1,2),(14,'0201704315_TOC.pdf','2001-01-02 00:00:00','2012-04-03 00:00:00',0,2,2),(15,'0409_E10589_N552VX_C.pdf','2011-07-01 00:00:00','2007-06-10 00:00:00',1,1,1),(16,'040C_F10589_N552VX_A.pdf','2021-02-07 00:00:00','2023-01-07 00:00:00',0,2,2),(17,'11406-programmez-avec-le-langage-c.pdf','2013-03-12 00:00:00','2013-06-01 00:00:00',1,5,2),(18,'1300_math_formulas.pdf','2007-04-03 00:00:00','2020-10-12 00:00:00',1,3,3),(19,'14-c++-STL.pdf','2018-04-01 00:00:00','2018-04-01 00:00:00',0,4,1),(20,'2014_09_13-motor-uk.pdf','2017-08-03 00:00:00','2001-08-09 00:00:00',0,5,1),(21,'4 Basic SQL.pdf','2012-03-01 00:00:00','2021-07-04 00:00:00',0,3,2),(22,'4-Tour-Algo-draft.pdf','2017-06-08 00:00:00','2016-05-05 00:00:00',0,2,1),(23,'9780321227256_TOC.pdf','2018-02-02 00:00:00','2011-12-03 00:00:00',0,3,3),(24,'9780321992789.pdf','2015-04-04 00:00:00','2017-10-11 00:00:00',0,4,1),(25,'9780735652163.pdf','2012-09-11 00:00:00','2020-07-01 00:00:00',0,2,2),(26,'9780735675117.pdf','2012-03-08 00:00:00','2019-09-10 00:00:00',0,5,1),(27,'9782409013287.pdf','2012-06-06 00:00:00','2018-04-09 00:00:00',0,4,3),(28,'A Handbook of Agile Software Craftsmanship By Robert C Martin.pdf ( PDFDrive ).pdf','2010-06-11 00:00:00','2011-12-12 00:00:00',0,5,3),(29,'Accelerated C++ - Andrew Koenig, Barbara E. Moo.pdf ( PDFDrive ).epub','2008-04-12 00:00:00','2007-07-07 00:00:00',0,5,3),(30,'Accelerated C++ - Andrew Koenig, Barbara E. Moo.pdf ( PDFDrive ).pdf','2019-06-12 00:00:00','2019-05-05 00:00:00',0,5,1),(31,'Accelerated C++ Practical Programming by Example ( PDFDrive ).pdf','2018-01-02 00:00:00','2009-08-05 00:00:00',0,5,1),(32,'Active Directory Cookbook, 4th Edition.pdf','2002-06-05 00:00:00','2019-01-12 00:00:00',1,1,1),(33,'Active Directory Designing, Deploying, and Running Active Directory ( PDFDrive )(1).epub','2003-06-09 00:00:00','2015-02-02 00:00:00',0,3,1),(34,'Active Directory Designing, Deploying, and Running Active Directory ( PDFDrive ).epub','2015-02-03 00:00:00','2002-07-06 00:00:00',0,4,1),(35,'Active Directory Designing, Deploying, and Running Active Directory ( PDFDrive ).pdf','2015-08-03 00:00:00','2012-02-08 00:00:00',0,3,2),(36,'Active Directory Infrastructure Self-Study Training Kit ( PDFDrive ).pdf','2023-01-06 00:00:00','2012-10-12 00:00:00',0,2,1),(37,'adams-sig07.pdf','2016-01-01 00:00:00','2013-03-09 00:00:00',0,1,2),(38,'ADTs Data Structure.pdf','2002-01-12 00:00:00','2015-01-11 00:00:00',0,3,1),(39,'A Handbook of Agile Software Craftsmanship By Robert C Martin.pdf ( PDFDrive ).pdf','2010-06-11 00:00:00','2011-12-12 00:00:00',0,5,3),(40,'Accelerated C++ - Andrew Koenig, Barbara E. Moo.pdf ( PDFDrive ).epub','2008-04-12 00:00:00','2007-07-07 00:00:00',0,5,3),(41,'Accelerated C++ - Andrew Koenig, Barbara E. Moo.pdf ( PDFDrive ).pdf','2019-06-12 00:00:00','2019-05-05 00:00:00',0,5,1),(42,'Accelerated C++ Practical Programming by Example ( PDFDrive ).pdf','2018-01-02 00:00:00','2009-08-05 00:00:00',0,5,1),(43,'Active Directory Cookbook, 4th Edition.pdf','2002-06-05 00:00:00','2019-01-12 00:00:00',1,1,1),(44,'Active Directory Designing, Deploying, and Running Active Directory ( PDFDrive )(1).epub','2003-06-09 00:00:00','2015-02-02 00:00:00',0,3,1),(45,'Active Directory Designing, Deploying, and Running Active Directory ( PDFDrive ).epub','2015-02-03 00:00:00','2002-07-06 00:00:00',0,4,1),(46,'Active Directory Designing, Deploying, and Running Active Directory ( PDFDrive ).pdf','2015-08-03 00:00:00','2012-02-08 00:00:00',0,3,2),(47,'Active Directory Infrastructure Self-Study Training Kit ( PDFDrive ).pdf','2023-01-06 00:00:00','2012-10-12 00:00:00',0,2,1),(48,'adams-sig07.pdf','2016-01-01 00:00:00','2013-03-09 00:00:00',0,1,2),(49,'ADTs Data Structure.pdf','2002-01-12 00:00:00','2015-01-11 00:00:00',0,3,1),(50,'Advanced Automotive Fault Diagnosis. Automotive Technology. Vehicle Maintenance and Repair ( PDFDrive ).pdf','2013-06-10 00:00:00','2015-12-05 00:00:00',0,3,1),(51,'Advanced book on Mathematics Olympiad ( PDFDrive ).epub','2008-05-01 00:00:00','2004-04-04 00:00:00',0,1,3),(52,'Advanced book on Mathematics Olympiad ( PDFDrive ).pdf','2005-03-12 00:00:00','2011-02-02 00:00:00',0,4,1),(53,'Advanced engineering mathematics ( PDFDrive ).epub','2005-04-04 00:00:00','2012-06-04 00:00:00',0,4,2),(54,'Advanced engineering mathematics ( PDFDrive ).mobi','2005-05-11 00:00:00','2013-09-10 00:00:00',0,3,2),(55,'Advanced engineering mathematics ( PDFDrive ).pdf','2011-02-03 00:00:00','2013-07-02 00:00:00',0,5,2),(56,'Alain_Jenotte-Linux-Notesdecours.pdf','2011-09-04 00:00:00','2007-12-04 00:00:00',0,2,2),(57,'Algorithms and Data Structures - csPrinceton.pdf','2022-11-11 00:00:00','2003-02-08 00:00:00',0,4,2),(58,'AlgorithmsNotesForProfessionals.pdf','2010-06-09 00:00:00','2001-05-08 00:00:00',0,2,1),(59,'Angular2NotesForProfessionals.pdf','2001-06-03 00:00:00','2022-04-01 00:00:00',0,3,1),(60,'AngularJSNotesForProfessionals.pdf','2003-05-02 00:00:00','2005-01-12 00:00:00',0,1,3),(61,'Applying Uml And Patterns An Introduction To Object-Oriented Analysis And Design And The Unified Process ( PDFDrive ).epub','2018-01-12 00:00:00','2007-06-09 00:00:00',0,3,1),(62,'Applying Uml And Patterns An Introduction To Object-Oriented Analysis And Design And The Unified Process ( PDFDrive ).pdf','2015-10-07 00:00:00','2001-10-04 00:00:00',0,4,1),(63,'Aptitude Test Problems in Physics Science for Everyone by S Krotov ( PDFDrive ).epub','2016-01-07 00:00:00','2004-08-12 00:00:00',0,1,1),(64,'Aptitude Test Problems in Physics Science for Everyone by S Krotov ( PDFDrive ).pdf','2003-06-04 00:00:00','2004-11-08 00:00:00',0,5,1),(65,'arrays-ds-English.pdf','2010-02-07 00:00:00','2018-03-11 00:00:00',0,5,3),(66,'Asbl.pdf','2019-12-07 00:00:00','2007-02-11 00:00:00',1,4,3),(67,'Attacking Network Protocols A Hacker’s Guide to Capture, Analysis, and Exploitation ( PDFDrive ).pdf','2008-03-05 00:00:00','2021-09-08 00:00:00',0,2,2),(68,'Auto Repair For Dummies ( PDFDrive ).epub','2010-04-01 00:00:00','2002-05-07 00:00:00',0,3,2),(69,'Auto Repair For Dummies ( PDFDrive ).pdf','2014-12-07 00:00:00','2002-03-05 00:00:00',0,4,1),(70,'Automobile Mechanical and Electrical Systems Automotive Technology Vehicle Maintenance and Repair (Vehicle Maintenance & Repr Nv2) ( PDFDrive ).pdf','2020-01-10 00:00:00','2013-09-02 00:00:00',0,5,3),(71,'Automotive Engines Diagnosis, Repair, Rebuilding ( PDFDrive ).pdf','2008-10-07 00:00:00','2017-09-07 00:00:00',0,2,1),(72,'Automotive Technology Principles, Diagnosis, and Service (4th Edition) ( PDFDrive ).pdf','2016-01-08 00:00:00','2008-11-04 00:00:00',0,5,3),(73,'list2.txt','2022-01-11 00:00:00','2022-01-25 12:50:24',0,1,2),(75,'merise.pdf','2020-12-01 00:00:00','2022-01-25 14:14:08',0,1,1),(76,'RAPPORT - Copie.odt','2021-01-17 00:00:00','2022-01-25 14:36:13',0,1,3),(77,'RAPPORT - Copie.odt','2021-01-17 00:00:00','2022-01-25 14:47:57',0,1,4),(78,'MMORPG.mcd','2021-01-17 00:00:00','2022-01-25 15:34:07',0,1,7),(79,'MMORPG.mcd','2021-01-17 00:00:00','2022-01-25 15:36:53',0,1,4),(80,'MMORPG.mcd','2021-01-17 00:00:00','2022-01-25 15:37:59',0,1,4),(81,'Novel_MLD.mcd','2021-01-17 00:00:00','2022-01-25 15:38:11',0,1,4),(82,'subway.mcd','2021-01-17 00:00:00','2022-01-25 15:44:14',0,1,7),(83,'subway.mcd','2021-01-17 00:00:00','2022-01-25 15:44:16',0,1,7),(84,'subway.mcd','2021-01-17 00:00:00','2022-01-25 15:46:23',0,1,7),(85,'merise.pdf','2020-12-01 00:00:00','2022-01-25 15:55:16',0,1,2),(86,'merise.pdf','2020-12-01 00:00:00','2022-01-25 18:05:39',0,1,3),(87,'Novel_MLD','2021-01-10 00:00:00','2022-01-25 18:06:52',0,1,3),(88,'merise.pdf','2020-12-01 00:00:00','2022-01-25 19:52:55',0,1,2),(89,'Alerts-CISA.png','2021-11-21 00:00:00','2022-01-25 20:45:29',0,1,2),(90,'addFeedly.png','2021-11-21 00:00:00','2022-01-25 21:03:13',0,1,3),(91,'CompanyHRExcel.zip','2021-03-15 00:00:00','2022-01-26 21:25:24',0,1,2),(92,'Capture d’écran (725).png','2021-11-22 00:00:00','2022-01-26 21:34:41',0,1,4),(93,'bountyHunters.PNG','2021-11-20 00:00:00','2022-01-26 21:35:16',0,1,4),(94,'bountyHunters3.png','2021-11-22 00:00:00','2022-01-26 21:35:21',0,1,4),(95,'addFeedly.png','2021-11-21 00:00:00','2022-01-26 21:35:24',0,1,4),(96,'Capture d’écran (737).png','2021-11-22 00:00:00','2022-01-26 21:35:26',0,1,4),(97,'list2.txt','2022-01-11 00:00:00','2022-01-28 11:10:36',0,1,7),(98,'APM02.pdf','2019-09-26 00:00:00','2022-01-28 14:13:06',0,1,21),(99,'icon.png','2018-10-09 00:00:00','2022-01-29 18:30:44',0,1,17),(100,'focus.odt','2020-11-29 00:00:00','2022-02-03 19:35:31',0,1,17),(101,'desktop.ini','2021-03-10 00:00:00','2022-02-03 19:54:26',0,1,17);
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 */ /*!50003 TRIGGER  T_dateScanDocument before insert 

ON document FOR EACH row

set new.DateScan = current_timestamp() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `Nom_dossier` varchar(50) DEFAULT NULL,
  `Flag_dossier` tinyint(1) DEFAULT NULL,
  `Id_Type_Dossier` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_Dossier`),
  KEY `Id_Type_Dossier` (`Id_Type_Dossier`),
  CONSTRAINT `dossier_ibfk_1` FOREIGN KEY (`Id_Type_Dossier`) REFERENCES `type_dossier` (`Id_Type_Dossier`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dossier`
--

LOCK TABLES `dossier` WRITE;
/*!40000 ALTER TABLE `dossier` DISABLE KEYS */;
INSERT INTO `dossier` VALUES (1,'premiere',0,4),(2,'deuxieme',0,4),(3,'troisieme',0,4),(5,'deuxieme',0,2),(6,'deuxieme',0,3),(7,'deuxieme',0,3),(8,'deuxieme',0,3),(9,'deuxieme',0,3),(10,'deuxieme',0,3),(11,'deuxieme',0,3),(12,'deuxieme',0,3),(13,'deuxieme',0,3),(14,'troisieme',0,2),(15,'troisieme',0,2),(16,'troisieme',0,2),(17,'troisieme',0,1),(18,'premiere',0,3),(19,'troisieme',0,1),(20,'troisieme',0,2),(21,'troisieme',0,1),(22,'troisieme',0,1),(23,'troisieme',0,1),(24,'troisieme',0,1),(25,'troisieme',0,1),(26,'troisieme',0,2),(27,'deuxieme',0,4),(28,'troisieme',0,2),(29,'troisieme',0,2),(30,'troisieme',0,2);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `niv_scan`
--

LOCK TABLES `niv_scan` WRITE;
/*!40000 ALTER TABLE `niv_scan` DISABLE KEYS */;
INSERT INTO `niv_scan` VALUES (1,4),(1,5),(1,6),(1,9),(1,18),(1,24),(1,40),(1,45),(1,57),(1,59),(1,64),(1,66),(1,75),(1,80),(1,81),(1,97),(1,100),(1,105),(1,111),(1,112),(1,113),(1,115),(1,136),(1,141),(1,150),(1,156),(1,161),(1,163),(1,181),(1,186),(1,202),(1,203),(1,204),(1,215),(1,217),(1,221),(1,233),(1,235),(1,236),(1,242),(1,250),(1,254),(1,260),(1,267),(1,273),(1,277),(1,282),(1,286),(1,295),(1,296),(1,315),(1,323),(1,324),(1,325),(1,331),(1,335),(1,338),(1,340),(1,343),(1,350),(1,352),(1,362),(1,375),(1,377),(1,378),(1,385),(1,390),(1,391),(1,394),(1,395),(1,398),(1,404),(1,406),(1,410),(1,413),(1,431),(1,434),(1,435),(1,438),(1,439),(1,447),(1,451),(1,457),(1,461),(1,464),(1,467),(1,481),(1,485),(1,492),(1,498),(1,499),(1,502),(1,519),(1,523),(1,525),(1,531),(1,533),(1,534),(1,538),(1,540),(1,551),(1,552),(1,553),(1,556),(1,558),(1,560),(1,563),(1,575),(1,579),(1,590),(1,593),(1,595),(1,601),(1,607),(1,610),(1,623),(1,630),(1,645),(1,655),(1,656),(1,658),(1,659),(1,660),(1,664),(1,669),(1,673),(1,677),(1,680),(1,682),(1,684),(1,685),(1,689),(1,693),(1,695),(1,702),(1,703),(1,708),(1,711),(1,713),(1,714),(1,721),(1,723),(1,725),(1,735),(1,744),(1,748),(1,763),(1,767),(1,772),(1,773),(1,774),(1,790),(1,792),(1,798),(1,803),(1,813),(1,818),(1,829),(1,852),(1,853),(1,855),(1,867),(1,869),(1,881),(1,888),(1,890),(1,891),(1,897),(1,933),(1,939),(1,967),(1,968),(1,970),(1,971),(1,973),(1,987),(1,998),(1,999),(2,7),(2,10),(2,17),(2,19),(2,21),(2,26),(2,29),(2,38),(2,40),(2,47),(2,49),(2,62),(2,67),(2,75),(2,77),(2,80),(2,95),(2,96),(2,116),(2,117),(2,118),(2,127),(2,129),(2,139),(2,146),(2,173),(2,190),(2,198),(2,207),(2,208),(2,217),(2,224),(2,229),(2,231),(2,234),(2,235),(2,239),(2,244),(2,247),(2,258),(2,261),(2,275),(2,277),(2,292),(2,300),(2,301),(2,303),(2,304),(2,306),(2,310),(2,312),(2,313),(2,319),(2,330),(2,358),(2,361),(2,363),(2,364),(2,365),(2,369),(2,370),(2,377),(2,380),(2,391),(2,401),(2,403),(2,408),(2,409),(2,410),(2,433),(2,435),(2,439),(2,450),(2,451),(2,453),(2,471),(2,472),(2,473),(2,480),(2,485),(2,486),(2,493),(2,495),(2,496),(2,502),(2,505),(2,508),(2,509),(2,524),(2,540),(2,543),(2,545),(2,563),(2,566),(2,572),(2,577),(2,578),(2,581),(2,589),(2,592),(2,595),(2,609),(2,610),(2,615),(2,623),(2,626),(2,629),(2,640),(2,645),(2,646),(2,651),(2,657),(2,665),(2,679),(2,687),(2,688),(2,705),(2,719),(2,725),(2,732),(2,734),(2,735),(2,741),(2,742),(2,749),(2,759),(2,772),(2,775),(2,778),(2,788),(2,789),(2,795),(2,798),(2,803),(2,808),(2,809),(2,820),(2,821),(2,830),(2,835),(2,839),(2,841),(2,854),(2,863),(2,865),(2,876),(2,877),(2,883),(2,885),(2,893),(2,895),(2,901),(2,909),(2,913),(2,914),(2,917),(2,920),(2,923),(2,931),(2,935),(2,939),(2,940),(2,943),(2,952),(2,957),(2,960),(2,965),(2,966),(2,969),(2,973),(2,975),(2,982),(2,990),(2,993),(2,994),(2,999),(3,6),(3,8),(3,9),(3,11),(3,12),(3,16),(3,32),(3,33),(3,40),(3,42),(3,45),(3,49),(3,66),(3,69),(3,79),(3,80),(3,81),(3,96),(3,97),(3,106),(3,112),(3,114),(3,122),(3,124),(3,133),(3,137),(3,139),(3,145),(3,164),(3,169),(3,189),(3,196),(3,198),(3,200),(3,223),(3,225),(3,226),(3,232),(3,234),(3,242),(3,243),(3,245),(3,249),(3,254),(3,261),(3,265),(3,269),(3,271),(3,273),(3,275),(3,279),(3,288),(3,294),(3,295),(3,296),(3,302),(3,311),(3,312),(3,320),(3,341),(3,344),(3,351),(3,353),(3,356),(3,358),(3,366),(3,367),(3,368),(3,370),(3,375),(3,394),(3,395),(3,402),(3,411),(3,412),(3,416),(3,417),(3,419),(3,422),(3,433),(3,440),(3,442),(3,445),(3,447),(3,459),(3,462),(3,464),(3,465),(3,477),(3,481),(3,487),(3,490),(3,492),(3,499),(3,510),(3,515),(3,517),(3,518),(3,526),(3,532),(3,534),(3,539),(3,542),(3,543),(3,544),(3,546),(3,556),(3,557),(3,569),(3,573),(3,577),(3,581),(3,584),(3,588),(3,589),(3,591),(3,613),(3,627),(3,635),(3,640),(3,643),(3,650),(3,656),(3,670),(3,674),(3,676),(3,677),(3,683),(3,695),(3,697),(3,706),(3,715),(3,716),(3,717),(3,729),(3,730),(3,737),(3,740),(3,741),(3,742),(3,755),(3,759),(3,760),(3,761),(3,778),(3,780),(3,797),(3,807),(3,809),(3,810),(3,832),(3,841),(3,845),(3,852),(3,855),(3,864),(3,871),(3,873),(3,884),(3,892),(3,895),(3,901),(3,903),(3,908),(3,911),(3,916),(3,923),(3,927),(3,938),(3,941),(3,942),(3,945),(3,953),(3,954),(3,964),(3,967),(3,971),(3,985),(3,991),(3,995),(4,9),(4,21),(4,25),(4,31),(4,32),(4,33),(4,37),(4,40),(4,51),(4,57),(4,59),(4,61),(4,65),(4,80),(4,81),(4,85),(4,87),(4,93),(4,101),(4,104),(4,111),(4,112),(4,118),(4,119),(4,123),(4,124),(4,131),(4,138),(4,143),(4,154),(4,158),(4,159),(4,167),(4,169),(4,176),(4,181),(4,185),(4,187),(4,190),(4,194),(4,196),(4,208),(4,210),(4,212),(4,216),(4,228),(4,234),(4,236),(4,242),(4,252),(4,255),(4,256),(4,260),(4,264),(4,266),(4,277),(4,283),(4,295),(4,300),(4,306),(4,307),(4,313),(4,319),(4,329),(4,331),(4,335),(4,339),(4,341),(4,362),(4,371),(4,372),(4,374),(4,378),(4,383),(4,384),(4,387),(4,402),(4,407),(4,438),(4,445),(4,452),(4,455),(4,463),(4,477),(4,484),(4,485),(4,488),(4,501),(4,505),(4,515),(4,519),(4,532),(4,533),(4,550),(4,551),(4,553),(4,557),(4,563),(4,564),(4,565),(4,567),(4,569),(4,580),(4,583),(4,585),(4,586),(4,593),(4,596),(4,600),(4,613),(4,622),(4,627),(4,630),(4,632),(4,633),(4,642),(4,647),(4,651),(4,658),(4,663),(4,672),(4,677),(4,678),(4,683),(4,689),(4,692),(4,697),(4,703),(4,704),(4,707),(4,708),(4,709),(4,718),(4,746),(4,750),(4,756),(4,760),(4,762),(4,768),(4,776),(4,778),(4,782),(4,783),(4,796),(4,801),(4,804),(4,808),(4,818),(4,826),(4,836),(4,837),(4,838),(4,840),(4,841),(4,851),(4,854),(4,857),(4,867),(4,891),(4,893),(4,902),(4,911),(4,917),(4,920),(4,928),(4,933),(4,954),(4,956),(4,960),(5,2),(5,6),(5,15),(5,17),(5,20),(5,21),(5,23),(5,34),(5,37),(5,40),(5,47),(5,58),(5,63),(5,64),(5,94),(5,97),(5,102),(5,107),(5,111),(5,126),(5,138),(5,139),(5,140),(5,150),(5,151),(5,158),(5,163),(5,164),(5,170),(5,188),(5,196),(5,199),(5,203),(5,207),(5,214),(5,218),(5,221),(5,229),(5,236),(5,237),(5,238),(5,241),(5,244),(5,246),(5,250),(5,252),(5,259),(5,264),(5,265),(5,272),(5,274),(5,276),(5,277),(5,286),(5,287),(5,292),(5,304),(5,306),(5,313),(5,323),(5,330),(5,333),(5,334),(5,335),(5,336),(5,343),(5,349),(5,360),(5,365),(5,366),(5,373),(5,387),(5,389),(5,391),(5,395),(5,396),(5,400),(5,404),(5,406),(5,408),(5,417),(5,426),(5,433),(5,454),(5,455),(5,462),(5,463),(5,467),(5,470),(5,479),(5,501),(5,502),(5,514),(5,515),(5,517),(5,519),(5,521),(5,525),(5,529),(5,536),(5,543),(5,547),(5,548),(5,551),(5,553),(5,560),(5,561),(5,562),(5,569),(5,571),(5,572),(5,575),(5,581),(5,595),(5,603),(5,607),(5,615),(5,622),(5,624),(5,642),(5,648),(5,659),(5,664),(5,665),(5,668),(5,675),(5,677),(5,681),(5,684),(5,686),(5,694),(5,698),(5,700),(5,719),(5,725),(5,729),(5,733),(5,738),(5,742),(5,743),(5,748),(5,749),(5,752),(5,753),(5,755),(5,757),(5,765),(5,766),(5,770),(5,775),(5,776),(5,778),(5,779),(5,786),(5,793),(5,794),(5,795),(5,798),(5,801),(5,809),(5,810),(5,812),(5,819),(5,824),(5,829),(5,831),(5,832),(5,837),(5,841),(5,845),(5,853),(5,859),(5,864),(5,868),(5,872),(5,877),(5,878),(5,891),(5,900),(5,940),(5,941),(5,947),(5,949),(5,951),(5,957),(5,959),(5,964),(5,983),(5,987),(5,991),(5,995),(5,997),(5,998),(5,1000);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `niveau`
--

LOCK TABLES `niveau` WRITE;
/*!40000 ALTER TABLE `niveau` DISABLE KEYS */;
INSERT INTO `niveau` VALUES (1,'employe'),(2,'compta'),(3,'RH'),(4,'directeur'),(5,'Admin'),(6,'TETETETE');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reference`
--

LOCK TABLES `reference` WRITE;
/*!40000 ALTER TABLE `reference` DISABLE KEYS */;
INSERT INTO `reference` VALUES (1,'Neil'),(2,'Eli'),(3,'Meriem'),(4,'Julien'),(5,'Ilir'),(6,'Martin'),(7,'facture'),(8,'C++'),(9,'Java'),(10,'fleurs'),(11,'paysage'),(12,'loop'),(13,'psychedelique'),(14,'voiture'),(15,'dessin'),(16,'programmation'),(17,'wesh'),(24,'hacking'),(25,'Neilllllllllll'),(26,'hsdbfkhsdfhk'),(27,'oooooooo'),(28,'jjjddjdjdjd'),(29,'NNENENENENE'),(30,'EEEEERRRR'),(31,'HFJFJFJFLDSL'),(32,'EEEEERRRR'),(33,'HFJFJFJFLDSL'),(34,'EEEEERRRR'),(35,'HFJFJFJFLDSL'),(36,'EEEEERRRR'),(37,'HFJFJFJFLDSL'),(38,'EEEEERRRR'),(39,'HFJFJFJFLDSL'),(40,'gyvygv'),(41,'gtyyg'),(42,'DIMITRY'),(43,'YEROM'),(44,'ergef'),(45,'egreger'),(46,''),(47,''),(48,''),(49,''),(50,'gfhg'),(51,'hghjg');
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
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scan`
--

LOCK TABLES `scan` WRITE;
/*!40000 ALTER TABLE `scan` DISABLE KEYS */;
INSERT INTO `scan` VALUES (1,'scan-8m0i5yl89u1f2y'),(2,'scan-2s4n5xp64u3r9p'),(3,'scan-8k4i4sl02y7l2r'),(4,'scan-8l2z6vj73i0z4d'),(5,'scan-4k3h9qk28u9l9a'),(6,'scan-4i1l0dg40n1m9o'),(7,'scan-4g7z0rc37p0e8c'),(8,'scan-3x8y5fk17j5e6f'),(9,'scan-0i2n4yq65k9s7q'),(10,'scan-0f9r6us97w2y5b'),(11,'scan-2m1g3qd43b4q0g'),(12,'scan-0y7y4rl16c1x0s'),(13,'scan-3i9f6mc45o7l4n'),(14,'scan-8r9n1jd56z3e9u'),(15,'scan-4o8e6aj49u7r4o'),(16,'scan-8q9y7wy99u4w3q'),(17,'scan-5r3h7wq22w4i4i'),(18,'scan-2c6m8hb17l5e0u'),(19,'scan-0p6z1ik88r0j4d'),(20,'scan-7f8e8oq97k2e2p'),(21,'scan-4d7a4nb76u0t5t'),(22,'scan-3t3l8ae41r5q3r'),(23,'scan-2v1g8pm10r8a9r'),(24,'scan-3x3b8xy01u8x2c'),(25,'scan-2x4m2na55i3k8d'),(26,'scan-3r1i3vz75h2w8b'),(27,'scan-4n2l6lc57m3v0q'),(28,'scan-3h3u1bn99u8u4q'),(29,'scan-7b7n6mq55l7w3g'),(30,'scan-9p3v0mh66u3f4q'),(31,'scan-7l0r7ko16e8d9r'),(32,'scan-9l3f7tg10n9w4x'),(33,'scan-4n7k7jv54y5s8s'),(34,'scan-2w8n8nq50s4y5m'),(35,'scan-5j8u2dq59z0p5k'),(36,'scan-6j4v1kj27z4e3v'),(37,'scan-8s6b2vt97m0z6c'),(38,'scan-2f5h6nq82c4y3j'),(39,'scan-8x0u1jn31k1i1o'),(40,'scan-5j4d4lw25k2q0w'),(41,'scan-3v4e9qf03u7c0r'),(42,'scan-5g9s9xt20o9q0p'),(43,'scan-3z4w7ao90a1x2z'),(44,'scan-2q9f9qo44h0i0c'),(45,'scan-6k4j9dd29u9d1y'),(46,'scan-3z7l0xp24z2s1o'),(47,'scan-3q8l0jt17c2x5v'),(48,'scan-6n6e9oh11o3t7g'),(49,'scan-1y7q0rj84i6e9j'),(50,'scan-2c9z5lw01m0g2b'),(51,'scan-2m9c2ml52n7z1c'),(52,'scan-2e1e4ua18d4e4r'),(53,'scan-3q0x3hd92w0k6b'),(54,'scan-1z7q5dw28v0u4m'),(55,'scan-7d5k0xn77x9c1o'),(56,'scan-1j6k4cw42r6d2y'),(57,'scan-0v1r7uv59p2d4z'),(58,'scan-3n9p8ts80g2x7d'),(59,'scan-3l6k5ac12y4f9d'),(60,'scan-8r8w6fm34n9r5b'),(61,'scan-6f6l3el14d2v9s'),(62,'scan-9y8g1cb39w4w3d'),(63,'scan-4e3x6ek20p4l8z'),(64,'scan-2s3w2rh46a8m3w'),(65,'scan-4y6v7ed50a7i8c'),(66,'scan-2g9d4de89i6s1q'),(67,'scan-8w4r7ug98j3u6i'),(68,'scan-0e4m0jh87v5v8u'),(69,'scan-3j8j3vd47p9c8y'),(70,'scan-4r0t6yu31w4f9t'),(71,'scan-7x5u1yk22w8m9z'),(72,'scan-3e6n7ov56q8l9f'),(73,'scan-3w3s8hd21n5q4r'),(74,'scan-9m6a3wc48n7g5k'),(75,'scan-0s5h0th67q0d7l'),(76,'scan-7u8e0zj42j9x6t'),(77,'scan-8o6l3by51r8p2c'),(78,'scan-5z9f5os07k2a6m'),(79,'scan-1u8a7el20n0o3r'),(80,'scan-4m3m3mq00a2i3f'),(81,'scan-7j1j8uq40t0n7n'),(82,'scan-8s3w3zf53k6b0k'),(83,'scan-8o6l4cr55l0f6h'),(84,'scan-8w1v5uo06f9k5n'),(85,'scan-9h6o5yp46q3n4s'),(86,'scan-3w9t4vd99u9u3l'),(87,'scan-3h5n9hd34p2r9o'),(88,'scan-0b9x1pg62x9p4x'),(89,'scan-6d9a1yu49x4h5g'),(90,'scan-1p8u6ot93l5p8s'),(91,'scan-5b7c8gq73u1l1o'),(92,'scan-4u5p4sq82g4x5g'),(93,'scan-6m3t6yn88g7a9i'),(94,'scan-8a4m7fz36y0c7m'),(95,'scan-8y3a2jq73x1s5i'),(96,'scan-3o1a1do93e1p6o'),(97,'scan-1f1k0qr05f6m9h'),(98,'scan-5b8m6hk06z5p0w'),(99,'scan-1s6g5mm96c4a8s'),(100,'scan-0u7i3jx35r7u4o'),(101,'scan-8v4o2yo00n8n6i'),(102,'scan-7a0g8rw23t3j4z'),(103,'scan-5n4w0cz14s3v8z'),(104,'scan-4g4e5zt33m8m1h'),(105,'scan-9h3d7ym29w7s9r'),(106,'scan-1d4f2cd12y5d7a'),(107,'scan-5f8e2eb50z1c3b'),(108,'scan-2i7i7as33r3n0z'),(109,'scan-0b5q6ee26a3u8h'),(110,'scan-1v9p2yq42l4o9y'),(111,'scan-9k7q7wv27c2p7i'),(112,'scan-4x9d0tl77j1m6l'),(113,'scan-7o9g9ir37q9f1n'),(114,'scan-9o5v6le20x8f7y'),(115,'scan-2j4y0ts43w4v9r'),(116,'scan-6e9t4ww94u2w3e'),(117,'scan-6w4x1tk12q6r8n'),(118,'scan-6o2q1sj97g0m0g'),(119,'scan-7n2z1uv77h1v4s'),(120,'scan-6u2w7bq45u8e5k'),(121,'scan-1v1y9ua38h0v9c'),(122,'scan-4o0z1vh86b6j4a'),(123,'scan-4d6m2xk60i0r4t'),(124,'scan-4q7j7ud58h4r7p'),(125,'scan-3d7b4ld13u9x7e'),(126,'scan-9x6p6jp38n2e4r'),(127,'scan-0g9n4cp26f0v6p'),(128,'scan-2j2d0es66k0v6w'),(129,'scan-4p1j6eu95x7r0k'),(130,'scan-8d5r7ja77m1r0c'),(131,'scan-8j1j9zc48j7s6y'),(132,'scan-2j9t2es24a5e7u'),(133,'scan-5r9z7jl88r2d2m'),(134,'scan-9e8s2lf44m0m4m'),(135,'scan-8b8d9ph19g1k6n'),(136,'scan-5g3a2kn84v9r5x'),(137,'scan-3d2d2jm56v3r8z'),(138,'scan-0g3q2qq39h0p8e'),(139,'scan-7n3c6lc40d9e4i'),(140,'scan-8j0p4lg98d9y3c'),(141,'scan-2z8e2vj64r2p7n'),(142,'scan-2q6k9tz92g5p6c'),(143,'scan-0p1l9oo89j5c5b'),(144,'scan-0c8z2xj31o3t6b'),(145,'scan-7u8q4de28e6y3e'),(146,'scan-2t2t1vm99r0k6n'),(147,'scan-7r2q3zk92e3x8l'),(148,'scan-0k4n4jf94z1f7j'),(149,'scan-2v6o1wv26b6p8a'),(150,'scan-9z0j8wy35l6t5p'),(151,'scan-7a1d7ky14k1f3d'),(152,'scan-9a2g9bj68x7y3o'),(153,'scan-3d0m3kq20c5f9c'),(154,'scan-5x0n7yw14f4j0f'),(155,'scan-6t1f3vm30h0p2o'),(156,'scan-4k6l8xc16y4k6b'),(157,'scan-1w1g6pb50s6n1i'),(158,'scan-8k1g2cc89a2b3l'),(159,'scan-0f4g7mg71i0n7j'),(160,'scan-9a6g0ix13n5p7c'),(161,'scan-8m8b4ct61n4o0b'),(162,'scan-4e4n6xo82r1b8o'),(163,'scan-3g1w6qi53a4j1q'),(164,'scan-4l3o1dq70h9a8b'),(165,'scan-2a4l0gb93c5y2l'),(166,'scan-9h4d4ut23d9p1j'),(167,'scan-0p8j0ge86f7d6d'),(168,'scan-7c3y1ob01x3y7f'),(169,'scan-0s3t2ow83s5t1w'),(170,'scan-1w4x6ym38m9g7l'),(171,'scan-7w6j2lq73h0t8v'),(172,'scan-5s4p8lk85g9x6p'),(173,'scan-0i5r2nf55a5g5r'),(174,'scan-6e8v7at72u4j0p'),(175,'scan-6m8o4qg64k4o2s'),(176,'scan-9y4j2jr54s9r1j'),(177,'scan-5j6w1ho69e5z2b'),(178,'scan-2o7d9fq02z8f6g'),(179,'scan-8a8o1ch69f9w0k'),(180,'scan-0c6r5kq87d5x5c'),(181,'scan-5l4m3pf85k2d3x'),(182,'scan-9e0f3vr80c8e9l'),(183,'scan-6e0v9mk46r5q5i'),(184,'scan-6r0t3wq88v3b4u'),(185,'scan-7l1r7ig01c6s6m'),(186,'scan-0f3t7ve08g3g8z'),(187,'scan-0w2s4ef45q9p2o'),(188,'scan-6d8f6lw91z6i3k'),(189,'scan-3g1d3fr04o0w9y'),(190,'scan-1j5z2ub83f5z2w'),(191,'scan-1f5f4wk88d0v0w'),(192,'scan-2l7f9pu64d9i2m'),(193,'scan-6t4c8vh68z8u3f'),(194,'scan-9s3y0vy76e6y7t'),(195,'scan-5b3s2ry62r5q7a'),(196,'scan-1d4b5tx43r6a4z'),(197,'scan-0s3o5pe59k8q4a'),(198,'scan-4l2i4ue99y1i1p'),(199,'scan-2x5h8my57b7d5s'),(200,'scan-7f0m8zw96f8d9w'),(201,'scan-3c0c9rj74d6o1a'),(202,'scan-1a4d0ix63u6r4z'),(203,'scan-6x7l6wd83v2l6w'),(204,'scan-7w5v9hf96r0y8h'),(205,'scan-1t6m9nf46k8r3c'),(206,'scan-7x6q3hm17m0l0i'),(207,'scan-8v1o0mt76u8w4c'),(208,'scan-7d3n7bg78m5c6o'),(209,'scan-0i4y7dl79i1x1m'),(210,'scan-5c8w0ku42d9k9q'),(211,'scan-0y2b0pd21n5q8s'),(212,'scan-8c8r4av07q1j4w'),(213,'scan-1a2t9st21f8c1e'),(214,'scan-3r2u5ze31j3o7i'),(215,'scan-1u0h8au55t2o9q'),(216,'scan-0s6k8iq86q5a4b'),(217,'scan-5u3q8rn91w8m2x'),(218,'scan-9l0x7sc95t8f2h'),(219,'scan-1p8t0af72k8v8p'),(220,'scan-9g2c5qa60h4x7s'),(221,'scan-3r8d1re61g3v2b'),(222,'scan-1s9k6vn63g9y8s'),(223,'scan-1q4y3ep79r6x8y'),(224,'scan-5g7q1jn55v3k5n'),(225,'scan-9m6v6at98q5m3k'),(226,'scan-6r0j0ns28y9v3b'),(227,'scan-2l4f1jg17t6v8b'),(228,'scan-6w7h7el29x7l7s'),(229,'scan-4l3m5ip53i5d0u'),(230,'scan-9o6j9za31i1a4r'),(231,'scan-5j9v3nc60g3t6o'),(232,'scan-3e7r2rj84j0q5v'),(233,'scan-5k1m2kf02i4l7n'),(234,'scan-5v9n8ix51t6a2r'),(235,'scan-6d0s8dm39s6j9w'),(236,'scan-9h4z1wz92t5y3j'),(237,'scan-1i3u8ed99i8l5f'),(238,'scan-2i5j2kh53g6b7r'),(239,'scan-0t9m6vj19f6s6i'),(240,'scan-7n7y8fg93m4j9j'),(241,'scan-5j6x0sk34y9d0l'),(242,'scan-5h1b0sh21i3p3v'),(243,'scan-1l5i3br29h0u4m'),(244,'scan-9a6f9iy72c4u1a'),(245,'scan-2f9z1qi60a9z0t'),(246,'scan-5v8a8xb93t8u6y'),(247,'scan-1c2t5rv23g5y7x'),(248,'scan-4q7w6do35l4r2r'),(249,'scan-9d6a2ut92g1t5k'),(250,'scan-4p0g9lx01q7h0i'),(251,'scan-2d8m9ox90e2f1v'),(252,'scan-3e0j8ig82b5p9t'),(253,'scan-8h4w3vb21r1p0e'),(254,'scan-9n7i8jd50i3k6p'),(255,'scan-2c0r9jb27s8k0b'),(256,'scan-5v3a6hj62k5h8k'),(257,'scan-3x4o9xc45l0j9j'),(258,'scan-1n9i6ry62l4x9l'),(259,'scan-1e9j0xa29p2u4w'),(260,'scan-1v4t9nb17v8j5h'),(261,'scan-9v9m0mn71y4l6v'),(262,'scan-5g8w4tb37t4e0f'),(263,'scan-4d3o7jm94q8y7l'),(264,'scan-9b2b0nb56h6e0z'),(265,'scan-8l0m9ds97z1n1f'),(266,'scan-7x7l5vw53s2p7v'),(267,'scan-5b0h7tj24r3p1r'),(268,'scan-7a0r2hy13c2w5p'),(269,'scan-1s8r0zs70o9l9o'),(270,'scan-1p0s6hs26p0m3z'),(271,'scan-9j5d5ml85n1a8a'),(272,'scan-6z4c0ra13u7p0g'),(273,'scan-1o3q4ql61m7b1e'),(274,'scan-2k1s9fv53g3m8t'),(275,'scan-6r8j4dr97p7k9m'),(276,'scan-0s6e3kf79t4e0q'),(277,'scan-9y3e0wk50v7q5c'),(278,'scan-7s8c8rt78l7h5c'),(279,'scan-9s4g7kt46c9f6n'),(280,'scan-5r9d5mo20w4e6b'),(281,'scan-0x1w5eu02e6x7p'),(282,'scan-6i9l4wb12c6l9y'),(283,'scan-6l5s5tq32p9h9n'),(284,'scan-6s5v6wq12l7q9f'),(285,'scan-5k5l9ql82o6c4i'),(286,'scan-6k8g7nu52o5u9g'),(287,'scan-2q4a5ie07r3u0k'),(288,'scan-9g7r9zr05v3u3z'),(289,'scan-3o5p0gc55q9v4z'),(290,'scan-5p7i6bm59m5v7l'),(291,'scan-1w6u5pi75q6z4d'),(292,'scan-8i2x2io45z2u1u'),(293,'scan-9s6i0be51a2r7q'),(294,'scan-9n0b6pu20k5q6d'),(295,'scan-2p9z2iy11f2b6d'),(296,'scan-2h8c0jc34g7y0j'),(297,'scan-0h5v5tq13t0f3h'),(298,'scan-8l3z1mi39v2h4b'),(299,'scan-6m5q4qp44r4u9m'),(300,'scan-6l5l2sl67a3j1u'),(301,'scan-6a3c7dv75q8u6o'),(302,'scan-6q3o9mt11a3o4y'),(303,'scan-3a6y4bt69i9w9r'),(304,'scan-3d8a3zq34l2e0l'),(305,'scan-7p9o0hl72k7g8w'),(306,'scan-8o3j1ck63l1g2t'),(307,'scan-0n5y1ex97h9a2j'),(308,'scan-9a8l5hz17f4y6m'),(309,'scan-4b6s9st17k7h9t'),(310,'scan-0f8w6br72s6j3l'),(311,'scan-0k8t8hp01o2k8x'),(312,'scan-7c7j4hc46p8j9q'),(313,'scan-2v2v6yh67o7v0f'),(314,'scan-7a1n1ki72b4g2m'),(315,'scan-7q7j5dt56b5l7f'),(316,'scan-8v4x4vr86v5t4x'),(317,'scan-0h2u3dg42r8z6r'),(318,'scan-8h7p4qr44o4z2s'),(319,'scan-5z6k7lx84j8e1b'),(320,'scan-8j1a1fk37k1d3c'),(321,'scan-6e8l2cc28h8d4u'),(322,'scan-0k2w7ph91l0e7z'),(323,'scan-1k2y9rc27c1b3m'),(324,'scan-2b9v0zq58z2c8r'),(325,'scan-9v3u0rw72g0j7f'),(326,'scan-3w7c3qb77t6g9m'),(327,'scan-2a8h5qo90j7q3e'),(328,'scan-9b7a0jf76v2x3j'),(329,'scan-3s9t0np91r9u2v'),(330,'scan-4n6n3zc42e1s3r'),(331,'scan-5b8g8gc63f9y2l'),(332,'scan-6z1t6ta12h8l1g'),(333,'scan-6h5b4tw16w4e9h'),(334,'scan-6n4q7sf59m3i7q'),(335,'scan-5g7p8hp28g6i9a'),(336,'scan-8q2l8qj02b7x3s'),(337,'scan-0n5m9rj98r8a0s'),(338,'scan-7d9z5ls13t3c6x'),(339,'scan-7s1m6ma14u4j8m'),(340,'scan-1z6k8bl02n6b2i'),(341,'scan-9g7h9pz31k4t4q'),(342,'scan-3h5n5rx24d7x8b'),(343,'scan-8c9p0ij29p2u0y'),(344,'scan-1p2t3zp11p7x0q'),(345,'scan-2l9v9mn34p3n2d'),(346,'scan-8k1c0qo51p8u8o'),(347,'scan-6t1s6re54o5g3d'),(348,'scan-7u3x0fa41b2a9d'),(349,'scan-6d7d6dp08j2o0f'),(350,'scan-8f3c7kk47u3g2r'),(351,'scan-0l7z4pz45e5d4e'),(352,'scan-5z3d5bf30u9s6c'),(353,'scan-1k7r6pn07y1y4r'),(354,'scan-6e4d8ur76m2i0a'),(355,'scan-3d7q0en12b5j4n'),(356,'scan-8z7a8im89c0x3l'),(357,'scan-0h7r5yr21h1h5v'),(358,'scan-6w5f7mb60i4n1s'),(359,'scan-1e5p7ep58r1a6r'),(360,'scan-9s5k4ea57w0m3v'),(361,'scan-8r4w5td38i6t1d'),(362,'scan-3x4u7fi30n9c3d'),(363,'scan-2x8s3dx71b8e1q'),(364,'scan-7j0l7ol30d9s0p'),(365,'scan-1m4u6cb60b4u4f'),(366,'scan-6o8b5tx05f5q3y'),(367,'scan-6p1g0js87j8i3f'),(368,'scan-8j2i9ep15i8x8m'),(369,'scan-3h3k8sy38p6j3s'),(370,'scan-6j0m4lf96q8i3o'),(371,'scan-4k3k1ur85y0n2d'),(372,'scan-7f6c1sx07u3z6p'),(373,'scan-2v6j8qv10p9s1z'),(374,'scan-6e4d2oq56j0b5v'),(375,'scan-6z0p8vi49u0f2z'),(376,'scan-8l0i3kq64q2s7l'),(377,'scan-2r0q6me91f5s0w'),(378,'scan-9k8g6vr79v0k9u'),(379,'scan-4m3j3ib97h6s8p'),(380,'scan-6m5y1rr10v8l5g'),(381,'scan-0m8j3lm08w3h9i'),(382,'scan-7i6l5zj44y5b5y'),(383,'scan-4h0u8sh10p7b8h'),(384,'scan-9k9f5jz91f7u6w'),(385,'scan-0l7r7wb46d9j0u'),(386,'scan-4y5o3ht78a0k1j'),(387,'scan-4o4j9xw74s9h1o'),(388,'scan-6k3v7fi17e5o3y'),(389,'scan-5v0h9cy91o1n8l'),(390,'scan-7v8d1pq85r8g2q'),(391,'scan-0w1c0zi78u0q2w'),(392,'scan-2r8s0kj04h4r6q'),(393,'scan-2i5a3xi34o8h7x'),(394,'scan-8x7y0iq27i9h0x'),(395,'scan-4j8s4hp80r8x5w'),(396,'scan-2a4k5sl43f3m0y'),(397,'scan-1d0m1oq01l5u1i'),(398,'scan-0i2f7zu11d5z2b'),(399,'scan-6c8d5no59f4q3w'),(400,'scan-3v7r3cz59q6d3m'),(401,'scan-1r5v2dy20n0n1l'),(402,'scan-2o4b4cd10o8y2r'),(403,'scan-6m3p0rx40u0e4w'),(404,'scan-5i0f7bd98c4h6a'),(405,'scan-4s3s2ck80e8v2w'),(406,'scan-7u0w3ki89w8v7l'),(407,'scan-9s6e7ys70m0p2y'),(408,'scan-5x5r2rd15m4n2z'),(409,'scan-5y2k5bk07r3t9c'),(410,'scan-8f6p1dh63g7o4y'),(411,'scan-6o3y3ud66a9a6f'),(412,'scan-3x9w5bu15g4i7v'),(413,'scan-7c2b7ol60b9n7s'),(414,'scan-7c4o5ux55u0q3k'),(415,'scan-5h9q2ed68q0v5s'),(416,'scan-7w7l7zs72b0h5e'),(417,'scan-1f9t9zh86u8m2h'),(418,'scan-6q1y8sv89t3g8f'),(419,'scan-3e8g7dw61i2q4w'),(420,'scan-8f9e2ud99i1j6j'),(421,'scan-6v5z8lk11j8b2e'),(422,'scan-9u2a6cf28d6k5g'),(423,'scan-5m0k8re03g9e8n'),(424,'scan-2b4a4kt08z8n2u'),(425,'scan-4c7a6oa58p0v2s'),(426,'scan-8s1u4hb69g9e4o'),(427,'scan-0v3i2fs18a1n3i'),(428,'scan-9x4b1cg79e4c4n'),(429,'scan-7x2p7un56h3c4v'),(430,'scan-6l5l0gk85l4z7e'),(431,'scan-4q1s7gq90k5i9g'),(432,'scan-9w5i1kn61r8h8h'),(433,'scan-5t3r0fg38h8n1b'),(434,'scan-1e8i2ag68h2n3h'),(435,'scan-2o7d1vl33t5u6m'),(436,'scan-7z1h8xv73z6n2t'),(437,'scan-1j1w7nl00v1p6w'),(438,'scan-9h4r0ew18k4h3i'),(439,'scan-1v1v0av31b6d5v'),(440,'scan-3g0e0kn92s3l9g'),(441,'scan-6n6t6fj00q6s9g'),(442,'scan-6w1l1ef02d4k3f'),(443,'scan-1i2h0sj19q0w9t'),(444,'scan-2a2d6vx52u1e1z'),(445,'scan-4v0q5wj24v8l1o'),(446,'scan-9d6d7wg99l0w7m'),(447,'scan-8k4e5eq65y1f0h'),(448,'scan-0t9g9db94i4u9b'),(449,'scan-4h1h2nl84n2s6z'),(450,'scan-4f6m8zg42b5p1r'),(451,'scan-0b2g4fe91c3n4m'),(452,'scan-6y9x2yo47b5i4p'),(453,'scan-9n3t1ln23w8d6m'),(454,'scan-2q3d6hj43y2z0u'),(455,'scan-0e9d8xt17d8l3l'),(456,'scan-2x9z8uf20w9z4e'),(457,'scan-8v7a9ts80z7z9s'),(458,'scan-3h3p3eg08i7r8v'),(459,'scan-5p2o4yr38g0p0s'),(460,'scan-9u1r7uf68x9p9r'),(461,'scan-0y9q4li88t9y6f'),(462,'scan-2t6d2qa08k3j4u'),(463,'scan-8n7h6mp33w4n1b'),(464,'scan-8y4m1jz43x2f5r'),(465,'scan-9l3x9ce32o0x7v'),(466,'scan-9f4j1uq08k5w8y'),(467,'scan-4h0l6kw71c2f0c'),(468,'scan-4u0u8ir63k4u2p'),(469,'scan-6q9q0ol44v9v5b'),(470,'scan-2z1h7oi13r6r1b'),(471,'scan-2a0h6ey65z6p9h'),(472,'scan-2o1r0bn32a1m1p'),(473,'scan-5h8d8om44e6x7x'),(474,'scan-8w4p7ry70g5y5o'),(475,'scan-6d9d5kb45g4l5u'),(476,'scan-3t1y7tl05r9j3v'),(477,'scan-9t9d4nx35m6q5o'),(478,'scan-7y4j5gg26m8h8d'),(479,'scan-5q9k2ih62g7c1v'),(480,'scan-3f5z8cu35r2h1u'),(481,'scan-8o6l2fw95l8a4x'),(482,'scan-1r0w4cf96q2s2u'),(483,'scan-9e1d0ki32x1q7a'),(484,'scan-0r7g2yp13z2u0h'),(485,'scan-1c5e3nf41q4f0p'),(486,'scan-9i9t0da44j5s6x'),(487,'scan-6z1b8ds54s6b4j'),(488,'scan-5a3h9yc97o5g6m'),(489,'scan-4o1d4sg32l6k3i'),(490,'scan-0z4t4hu62z5b7p'),(491,'scan-7z2l5dc60v3k4b'),(492,'scan-7e4w3yv31c5t0z'),(493,'scan-9f5k7ig96p3m5i'),(494,'scan-8g7w1cu98u7i2o'),(495,'scan-7c7o2eh05p5z3k'),(496,'scan-0d7k0ii51w7a1g'),(497,'scan-6y0m0eu03b8s7d'),(498,'scan-4i9i3xo54o8w1j'),(499,'scan-7z7p5gk55g3s7p'),(500,'scan-6z0m6sx21r4a1h'),(501,'scan-0f5b8on71r6p4k'),(502,'scan-9s9k6gm68i8n7m'),(503,'scan-5v9r4ax46l0z3w'),(504,'scan-3r2v0sd32z1n0s'),(505,'scan-0r6k2lq85b0y6p'),(506,'scan-8c9n9qw57k0e9n'),(507,'scan-5z3h5em28s2m2i'),(508,'scan-0y6b5py52b5o7q'),(509,'scan-7s8f8ps90x3x1f'),(510,'scan-5r4i6ie90y9h3j'),(511,'scan-9n5x5cn26r4n6c'),(512,'scan-6u0b7wk42u8t3s'),(513,'scan-0m5l8ea90i4r8j'),(514,'scan-8w8e5ix26x4v2c'),(515,'scan-0h4r0bq13h0k2r'),(516,'scan-1e5w6tb94t5l9m'),(517,'scan-9p9o8js96v8t2h'),(518,'scan-6g4e0gf41j7j2a'),(519,'scan-3h9t5gb07u0g1l'),(520,'scan-7x5c2fk69y6q2j'),(521,'scan-3c4t9eh83y9i5u'),(522,'scan-0m9g1if73m4c2g'),(523,'scan-6s0j5hr17o8y7n'),(524,'scan-4y5r1eo21c6f2g'),(525,'scan-3u3q8vc99z3g6g'),(526,'scan-9i9h1zt82d5m9g'),(527,'scan-0i2t8qb28w6z5h'),(528,'scan-0b9w2or62g2x6m'),(529,'scan-0u4f4zl15q7w7g'),(530,'scan-7o5e5sc96d3a8g'),(531,'scan-2t6r0yo65a0x7i'),(532,'scan-1t9e6iw98h4h3x'),(533,'scan-0d3a1sp65o3e4j'),(534,'scan-7z4k4wq49t1c5y'),(535,'scan-0b1v2ml86l1y8f'),(536,'scan-8l1y8ji98n6c3q'),(537,'scan-6b0j4pi05h3b8v'),(538,'scan-3f8a1gk11n1z5q'),(539,'scan-3h4y0zh60f9j8t'),(540,'scan-1p9u2en54y4w4l'),(541,'scan-0c4b2id06s3f0v'),(542,'scan-1i3i2gj26x7m6w'),(543,'scan-3t4g8dv20f7d5j'),(544,'scan-8k2x0ni63v3k5z'),(545,'scan-3b2j8ep37k1s5h'),(546,'scan-3r6t7tu98u2a8d'),(547,'scan-6v0g8ez56d8k2u'),(548,'scan-4m6x3ix85p9o1f'),(549,'scan-4q2o3jq77i9k5h'),(550,'scan-2l3i3jh18n7n4s'),(551,'scan-9q2b9kw97o8r4h'),(552,'scan-2u1l0kj46v6w1q'),(553,'scan-6f8r7hj27l6f5m'),(554,'scan-8a9u9te52o8x7p'),(555,'scan-8p5b3ab62k1h2k'),(556,'scan-9g8s6xn19x4w9r'),(557,'scan-1p9g5ms85h3m4z'),(558,'scan-1n0b5hi77i4l9n'),(559,'scan-8m4v6ck20e8d5x'),(560,'scan-4d0i9qm58z7d7k'),(561,'scan-6t5z2kv00b0v8g'),(562,'scan-7i2h0yz99o2f5v'),(563,'scan-8z6g8dc25t7g9a'),(564,'scan-8i7c8fy15u7a8d'),(565,'scan-5t2i0ya49j7y1b'),(566,'scan-1m8j9kz21h1l1c'),(567,'scan-1v4z3hu55i5x6v'),(568,'scan-1r6h4ij95e0x2g'),(569,'scan-3z0c0lw57e5e2k'),(570,'scan-6j1h6li52y1f9f'),(571,'scan-6k7h1tv39m9u4g'),(572,'scan-2c2k9su14g1m2q'),(573,'scan-7u1f0fc28n5r0m'),(574,'scan-0d5x6ny10z2c9n'),(575,'scan-7e9p1pk98u4p1k'),(576,'scan-3t0i1nh11v1v4r'),(577,'scan-8g2f7me92j4i8n'),(578,'scan-4u8t1xf87l2u9w'),(579,'scan-1f8g3db46l3w8m'),(580,'scan-4v3k8rl22l0u6g'),(581,'scan-3a7v5uk57l9u0w'),(582,'scan-7f7c6le03c8d0m'),(583,'scan-8x7a4yu88q9y5c'),(584,'scan-8g5g2ke89q6i0d'),(585,'scan-9g8c1bo41j7k8v'),(586,'scan-8s4o3fb60o3m7g'),(587,'scan-9r7x4ee26n0h1m'),(588,'scan-2l2q2rs72s3r2c'),(589,'scan-0v8n2dz06o2s2w'),(590,'scan-7v0a3mh85v0b8d'),(591,'scan-7k9a1cb52w5i1v'),(592,'scan-9i1l6da96h8l0j'),(593,'scan-8u7q8oi31k8n6u'),(594,'scan-5s1o0wq04z2f3r'),(595,'scan-9i9y6gl20o6f5e'),(596,'scan-4f5u5if13m4b4q'),(597,'scan-5i9n5gf28w8f4k'),(598,'scan-5k5l8iz11x6i4s'),(599,'scan-1w5d5qq97x5d2h'),(600,'scan-0i2y8vy32a2p1q'),(601,'scan-7g7n3vf15b9c5q'),(602,'scan-2k8e4sh98k8i7q'),(603,'scan-9t9f8eo46e4g6q'),(604,'scan-1j5l3ze19x3r7y'),(605,'scan-6y8f3fp02d9e1o'),(606,'scan-1z6h8pa34j0h4k'),(607,'scan-0z4j0cu37o3i2i'),(608,'scan-2i3h1oo95g5c4m'),(609,'scan-8s4z4lh25z9w2s'),(610,'scan-1s4v9de15d2h2q'),(611,'scan-4b1i0sf66r7i6f'),(612,'scan-6f8v2to29g0k3u'),(613,'scan-1w4h4kw02w3r5g'),(614,'scan-0s2d6fs50d6x9q'),(615,'scan-3l8j4xu69g3u3l'),(616,'scan-4r1u3lk64s7x8z'),(617,'scan-6m7a6cw60h0i5f'),(618,'scan-9x7u9ln14w2f3s'),(619,'scan-8y4n1cy62h5h6q'),(620,'scan-2i4a3vp92z1f2d'),(621,'scan-8t1j4rp08w0e6v'),(622,'scan-6v3m3ik70s6c8k'),(623,'scan-6w7m8fe69l2q9k'),(624,'scan-7f8g9ec44n6f8u'),(625,'scan-1b6v1ec41l2v8b'),(626,'scan-4t8o0hk54g7i6j'),(627,'scan-7t3v9rf24d4o1o'),(628,'scan-5h5f1qz33m3z4l'),(629,'scan-1t8s9lc23f6y5x'),(630,'scan-5x1e0sg36q0n1i'),(631,'scan-3k8a0ze88k8x9i'),(632,'scan-8w5a3ex87w8j0x'),(633,'scan-1g9b5ug08j9n7v'),(634,'scan-5l5i9na28p0n0a'),(635,'scan-3o0n9rb03q4a2z'),(636,'scan-4f2x1sw77h5f1y'),(637,'scan-1w4f2ag26z2n9h'),(638,'scan-0o2n0th47n4l3a'),(639,'scan-1i9b4td09k5m9q'),(640,'scan-8t9p9ps29w0l4q'),(641,'scan-0x4g9pn37d7f5v'),(642,'scan-4m9n3ao08d3x2k'),(643,'scan-2g7z3fy09f9a6b'),(644,'scan-9y5d8rv68m0o2h'),(645,'scan-4m1u9fn87w4r1y'),(646,'scan-2i0c4uh97d8b5w'),(647,'scan-5s7h3qj27l5j6c'),(648,'scan-9j2j9zy29a5l5z'),(649,'scan-3h7j5fa65i3v2n'),(650,'scan-3w3d5tl29x8c1d'),(651,'scan-5m3u2iy31e6h8d'),(652,'scan-3d0g5xp91d0e6x'),(653,'scan-8s3t7iy48v5o2t'),(654,'scan-0u8h2gp26s0q5o'),(655,'scan-6a0r6vi49x4z1g'),(656,'scan-1i4y4fw19m7a2i'),(657,'scan-3h8b7vn49r9g4x'),(658,'scan-6a4s6ml73f5h8q'),(659,'scan-9v0w2ay18e6q1x'),(660,'scan-3j8p1gx24v1w1d'),(661,'scan-0r9t4qw32w8t3m'),(662,'scan-0p2k1fw90f1s4h'),(663,'scan-8x0r9pn65q0b6v'),(664,'scan-5t4r9wp07v0l1z'),(665,'scan-6f8m8is88m1t6x'),(666,'scan-8h1x5xr38p5f3j'),(667,'scan-0b4q1hz62s0w5v'),(668,'scan-9a6t2fi54x0v7k'),(669,'scan-4x0k2qj58t8k9o'),(670,'scan-1c1z2lu88p6t9u'),(671,'scan-6h8p7bj55w8m0d'),(672,'scan-8r4n0gi45q7z8k'),(673,'scan-4y3c9nq44v6m8c'),(674,'scan-7t1o6lf90o6r0d'),(675,'scan-3n3u6jw18j1m5t'),(676,'scan-7a7p8mk33y9j5w'),(677,'scan-0x8u3km80p4s6u'),(678,'scan-9i7b2we58o6p4x'),(679,'scan-6d6t1gb00n4y3g'),(680,'scan-0k0t7yc30p5j8j'),(681,'scan-1c0g3jv01l0n5z'),(682,'scan-9n2r8zo34b5b8b'),(683,'scan-2k9k6av66z3k2v'),(684,'scan-3f8n4pq48k8f2g'),(685,'scan-2s4h2lt94d6u4l'),(686,'scan-3l3r6pd62v0b9q'),(687,'scan-4f5f6th26r4n2g'),(688,'scan-8t0u1ka78g1u1l'),(689,'scan-9d1a6ih16u5t2m'),(690,'scan-1x7p1ly33b7f2a'),(691,'scan-1u7e6hu22m2m1b'),(692,'scan-2h5m1jz61p6f8s'),(693,'scan-6a0t7io17z2v5j'),(694,'scan-5j4b9re26w4s4t'),(695,'scan-2n5o3ym77v2k4e'),(696,'scan-8h4j6vg23k4r0d'),(697,'scan-7u3m1nq84o5f4f'),(698,'scan-5t1u9jm28u8w5u'),(699,'scan-4c4z5ud81e1c4w'),(700,'scan-1z5r6vh86c5i8n'),(701,'scan-6v9x0yj16k8r7l'),(702,'scan-3r2h8ww62p9t8t'),(703,'scan-1u0s6uy60v1v3k'),(704,'scan-4o9g4zw56t7n0x'),(705,'scan-5c1k2zi20u3e7u'),(706,'scan-1d2g9kg51k5v6i'),(707,'scan-1c6e0ek37h8l4m'),(708,'scan-2v4s7cz52l7w8m'),(709,'scan-3u1a6tv08w0h4d'),(710,'scan-0q6m6tw40q7k6t'),(711,'scan-2m6b4ps66n8p8q'),(712,'scan-5r3g3be89k6c6n'),(713,'scan-7m8i0ez96p5k5a'),(714,'scan-4e5t7st39m5j2p'),(715,'scan-0t4b5op63n6w2b'),(716,'scan-5b8q0py88o2i9h'),(717,'scan-9f2y8om61s3f1p'),(718,'scan-6c4f1xl69t6m4h'),(719,'scan-4y3l3jz22h8k4l'),(720,'scan-8j6m8wa81e8k3j'),(721,'scan-0p7s0qo34x5n4z'),(722,'scan-3i4n3jw32m9n5f'),(723,'scan-6p8v2qc88t6z9p'),(724,'scan-7b2l9ah67e8t4g'),(725,'scan-2m9o1xf57p9w5o'),(726,'scan-8z5l5tr23a0z6q'),(727,'scan-5d1e5fl92b7b1k'),(728,'scan-9l5h6jp47g7s3t'),(729,'scan-9o4q8js62i9p7m'),(730,'scan-9c7i7ur53r2b3j'),(731,'scan-6u6r2ij46z4l5x'),(732,'scan-7b5y1dd46k1d7k'),(733,'scan-6q6q1qr10v7a6j'),(734,'scan-7b6e9zp80q5z6c'),(735,'scan-2i5r8mn89c0y7w'),(736,'scan-7t6x6wx48i3g3k'),(737,'scan-3q9y7li41z0m8l'),(738,'scan-9x5m6ra76v3z2a'),(739,'scan-4p0t0hm85v6n9p'),(740,'scan-1b7t8kj37v0i2d'),(741,'scan-3q8y9qg70i3d8r'),(742,'scan-9f8p4uc72w0o8z'),(743,'scan-3b0d9gy55j6v3o'),(744,'scan-4n3u6cq96z0d7j'),(745,'scan-4z7j9up53z2a7h'),(746,'scan-2n7w6sg03i2z6v'),(747,'scan-6w4x4vs87d4d1s'),(748,'scan-7b1l7ym48y7i3u'),(749,'scan-3l4n4pr39c0i4a'),(750,'scan-8f7m4qo70u1o7a'),(751,'scan-1o2w9bj75q2n0m'),(752,'scan-2i6r7nf01j5n7k'),(753,'scan-9y3x6es63h9h1d'),(754,'scan-9b4c5uf37t1q3l'),(755,'scan-9j0c8tu07p7f1f'),(756,'scan-3i9q9cs47r8x1k'),(757,'scan-7o0e0sr07m8m5p'),(758,'scan-7p5o2pz71c7b7c'),(759,'scan-9g7g5pt82z4n2g'),(760,'scan-1k1o1ao62p3a5o'),(761,'scan-4d3v4mc77c3l4h'),(762,'scan-9i0l1of75s4q1u'),(763,'scan-2e9b6km54m9m6t'),(764,'scan-3y9x6wj30y4g9c'),(765,'scan-1w5r9ur47r9o8c'),(766,'scan-6h5t0sd23m0o1i'),(767,'scan-4y1j7bk64g9e7v'),(768,'scan-7y8g0ck53y8t9l'),(769,'scan-1z9p1oj87y9l6s'),(770,'scan-3b4q9wj13z6g1v'),(771,'scan-9f8c6ue14f6w0o'),(772,'scan-0c3w6de74v5y1h'),(773,'scan-5h5e3jr91m9b8d'),(774,'scan-8h6e9uq74g2r2m'),(775,'scan-5y3p1ty51e9g5u'),(776,'scan-6k5z8iv04q1w6z'),(777,'scan-6a6e9pg70k5p5m'),(778,'scan-5d3r1ts15p4i2s'),(779,'scan-0z2w8ws29n7x9d'),(780,'scan-3v0o4jt98d0l4y'),(781,'scan-7x2z9ru89s5h5c'),(782,'scan-6d4w1ds65g7m5a'),(783,'scan-1s3o5tf11g5g1t'),(784,'scan-7e2e6qr28q6p9k'),(785,'scan-6p9x9qs78j9c5c'),(786,'scan-1o9e1ow02k2t7v'),(787,'scan-1u6d8sj76o3l9x'),(788,'scan-6m0e5ob23k8b5k'),(789,'scan-3w0n4hp97g3h8m'),(790,'scan-5v3p6xa91e0y4y'),(791,'scan-1u7p4mg32k9z2q'),(792,'scan-4c4e6ss42b3s8n'),(793,'scan-1o0t5ut13j2i2g'),(794,'scan-9j8i3ak09a9m8k'),(795,'scan-6i1k7gs03e7g1g'),(796,'scan-5h7a7rv66y4u6k'),(797,'scan-5t2n7ri21v7z9q'),(798,'scan-5a0g9eh61j6n7c'),(799,'scan-1g0p9lh92u2x4f'),(800,'scan-6a7j6iq17j3p1y'),(801,'scan-5w1y4lx25g2q6d'),(802,'scan-5r6j3hd44s9m8k'),(803,'scan-4u7r7zb01c4z0x'),(804,'scan-2u7x8sj04p5x5t'),(805,'scan-0s1k8dm13p1u7r'),(806,'scan-6b1a4aq05x0l6r'),(807,'scan-2e9g2sp41q4l0q'),(808,'scan-3c2b1qv84n0i3j'),(809,'scan-8d0p7ff58n7u8u'),(810,'scan-2r6j2rd46c7v8x'),(811,'scan-6x0c0by21w8f5l'),(812,'scan-0u9t7fq21v6y7x'),(813,'scan-1a5x8ap33g2r0g'),(814,'scan-6x1y0od53s8n7w'),(815,'scan-7b2e1lm81f3w8n'),(816,'scan-7f7e5ju63f3u3c'),(817,'scan-0y1k0hs38k3t7k'),(818,'scan-7t3p2iw13g1p9d'),(819,'scan-1r4d9qf80g1y4u'),(820,'scan-7o0h7ub11k1o4a'),(821,'scan-4t4d2ya95w9p8z'),(822,'scan-1u7e9xe04v8a6b'),(823,'scan-1h2l2ky47r4b8g'),(824,'scan-0r0i0cb73o2b6h'),(825,'scan-3l8i4mh58q4l3n'),(826,'scan-0u7j1ro21t2v2d'),(827,'scan-4q5b0qf24h7c9y'),(828,'scan-1a9q2he57m5l8x'),(829,'scan-2o2i7xr79v2h8d'),(830,'scan-6c5u3jb83u2h1d'),(831,'scan-5e3n6vx93v4h6y'),(832,'scan-2f7f2hk91p0h8t'),(833,'scan-7o4w5bq35t5y9y'),(834,'scan-6q9q0fr18c1c0x'),(835,'scan-7p3o8cj21h0s1j'),(836,'scan-8p7k8na71s1u9b'),(837,'scan-1v4f3pg21x9r9w'),(838,'scan-3p9t0rd16q3k7c'),(839,'scan-5i8s2rm61u0f0z'),(840,'scan-4b6w4lx31x8t1n'),(841,'scan-7c5p0kw81k2v1j'),(842,'scan-4v0h9fr51t6o8t'),(843,'scan-0e5o3vy22v1b4r'),(844,'scan-6g9q0nt09g6c5l'),(845,'scan-6r9k7jr97k8e5j'),(846,'scan-8k2m1jb25g4f8y'),(847,'scan-2v4y3kf15w5c5h'),(848,'scan-4j6e8lv49z5a1d'),(849,'scan-6m0u9tt52b0f9e'),(850,'scan-6r7s6lc36s1d1q'),(851,'scan-1h9o7ci80x6e9b'),(852,'scan-2a8j1ay63x9e8j'),(853,'scan-7t1d9fw67n6g3j'),(854,'scan-9g7l2ag19a2b5p'),(855,'scan-5v1f0xh23h7c6d'),(856,'scan-5k6n2jk81y0j3q'),(857,'scan-2s5u1wr37a8f1a'),(858,'scan-7c2f4gu84b4d4f'),(859,'scan-7m6z5we68y8j9z'),(860,'scan-9j4p3ot85g2b3i'),(861,'scan-6x3a7aa95w2e2n'),(862,'scan-7o8x9oz28x2r0y'),(863,'scan-6x8w3qu86v2q7o'),(864,'scan-0k0s4rb91s3n2r'),(865,'scan-9u7h9un02a0s4d'),(866,'scan-6c1n9bo81t9v5f'),(867,'scan-8t7t2at51z8n4f'),(868,'scan-9e9d1mr05u7c1s'),(869,'scan-6r3i5mo53j8g1q'),(870,'scan-7u9w9ut27t2f1p'),(871,'scan-1a0n3rj89p7r6h'),(872,'scan-9t9r9ya44m9l9k'),(873,'scan-1b7h4jj42d1s6b'),(874,'scan-9z2c3nn14w4h3y'),(875,'scan-6f9d2oh11d6d3e'),(876,'scan-8z8a6fd83r5v2p'),(877,'scan-0h6h9au27s2m1r'),(878,'scan-7n8k0iq24o4g6r'),(879,'scan-9e6u0wp21d6v0z'),(880,'scan-8v4j9rc04w2e8q'),(881,'scan-6x3e4jh41j0f0q'),(882,'scan-3x1k9qe46g0m4y'),(883,'scan-1t5r1tx95m3j7l'),(884,'scan-1u4k8ve20x9l2c'),(885,'scan-6q3l1vm16m0t4p'),(886,'scan-2x8u3qq66i3m4m'),(887,'scan-0c0i5bs62n1o8d'),(888,'scan-7y8l9rw60m7l2u'),(889,'scan-0i1j1rx15v0s3e'),(890,'scan-3t8c0cs56f4t9l'),(891,'scan-1w4t7wy34x7t8l'),(892,'scan-8f7h1cr96m4m6r'),(893,'scan-9k8d0dg71w3x7b'),(894,'scan-4p5d6xr06y7l4q'),(895,'scan-3y4f6qm52y9j5e'),(896,'scan-6b9v7uf62o7o7z'),(897,'scan-7z1d5ie82f7e2b'),(898,'scan-5r4s0nk55b3n5f'),(899,'scan-2n7r0pq39f5t2x'),(900,'scan-5h4b8mx65y2x8g'),(901,'scan-6y9c4ss70i9e7c'),(902,'scan-4b7a9xc52c2e0d'),(903,'scan-8b8i9dk40a2f1n'),(904,'scan-5y0h6cm77u5b1i'),(905,'scan-0p9k2ne08d0j6z'),(906,'scan-1t1l2gu26n2l9c'),(907,'scan-2u6a2ho67p8j7a'),(908,'scan-2s8u2nd71g1w6t'),(909,'scan-9f7u4oj58c3a0s'),(910,'scan-1y9z6bl03f7s3a'),(911,'scan-0n4y2ag35w6i8i'),(912,'scan-4p7e2vl75o9s6v'),(913,'scan-1u3z5sc65j1k5b'),(914,'scan-4k8a0xg95t9x9f'),(915,'scan-7e4v9cp64d7q7r'),(916,'scan-2r0v7od60f5q8u'),(917,'scan-4s1y9rx14i1r4f'),(918,'scan-4u3j5kt85i4a1i'),(919,'scan-9g3s1mu29l0q1g'),(920,'scan-2u0g0mh30f3u5p'),(921,'scan-0b6v3bv13r4d9v'),(922,'scan-1d0y7fr32d5f3e'),(923,'scan-4h4c8em34k5b7k'),(924,'scan-1d2n7kr37a0l2z'),(925,'scan-8r9l5iw68i6b3e'),(926,'scan-0a9k4rn61s7r5g'),(927,'scan-8x3l6pr37b0e1i'),(928,'scan-1w1k4ee00q7w4f'),(929,'scan-7w0g3zv16v5b0i'),(930,'scan-4m8l7lf58z0i2j'),(931,'scan-0d7q0dm59b4x5g'),(932,'scan-9c9x4cd64m5p6o'),(933,'scan-3p7o7oc24o2u1f'),(934,'scan-7j7k0se84z2h9k'),(935,'scan-3a2z1qm50u8y5t'),(936,'scan-1h4v4ck18u7p5k'),(937,'scan-5p8i6so45l4k2k'),(938,'scan-7l8y3nk79l9t6o'),(939,'scan-6j7z8ng53f8v7o'),(940,'scan-5z9x8gr66b9g2e'),(941,'scan-0g5j8lt94f2s7b'),(942,'scan-3x7j3pj49d0i2y'),(943,'scan-8x2m1co41n5m2v'),(944,'scan-2m6c4bk06w0r4y'),(945,'scan-3t2v4no65j1g2x'),(946,'scan-5c5r7of26s9x5l'),(947,'scan-4a5f0iy34c5i1y'),(948,'scan-9p3n3yl42z9e6i'),(949,'scan-9x4p9vv42x5f9g'),(950,'scan-2y0o4gl96z4g8u'),(951,'scan-1x9m4js51x5i6v'),(952,'scan-5n8x9vt40f9p0f'),(953,'scan-1o4b3gy45o6i5b'),(954,'scan-4p0d6vp85o4c4j'),(955,'scan-9d9a1rs63u3a6p'),(956,'scan-0k7z1qx72c7y6u'),(957,'scan-8k5z3uz62f1b6n'),(958,'scan-8x6r3bt95y5m4t'),(959,'scan-4s2p5gb33c8p8q'),(960,'scan-7d4g8ge46t3l4g'),(961,'scan-7j0x8uk40n2x1y'),(962,'scan-1n2o1al11i7k6k'),(963,'scan-9x5d9yy07y5z6q'),(964,'scan-5f2w2kv10v1x0w'),(965,'scan-9y3q1up08h1v8q'),(966,'scan-5q4u2eb02e8x4k'),(967,'scan-4f0y5pz36c8f4g'),(968,'scan-0b9e2vt03q6y7x'),(969,'scan-7z7a7fq20u8s8w'),(970,'scan-8g4k7eh09m4l1w'),(971,'scan-3u0d7te27b5b9j'),(972,'scan-0b2f0zz28w1i1t'),(973,'scan-9r4p3ey95u5m9w'),(974,'scan-1i6p5fz69p4e4y'),(975,'scan-9u3u9kc34x0e1i'),(976,'scan-4q3a5oo26l1m9k'),(977,'scan-4s7n1hb10w5b6o'),(978,'scan-1c5r3le28d6d9u'),(979,'scan-1i6n7id93x1q2l'),(980,'scan-8m9h5zn32k1e6y'),(981,'scan-5h7w7xj74o2g8x'),(982,'scan-4v3e4fo74j9t7x'),(983,'scan-7q8p8cy48t4q7x'),(984,'scan-3t2c5tg89c4h1i'),(985,'scan-2r1r5oa29e6w4y'),(986,'scan-3m4y8gw30d2j6q'),(987,'scan-7s3m7sw77w7q6y'),(988,'scan-5p0m2al52c2a7i'),(989,'scan-9n9c9un67t6w5w'),(990,'scan-0m4e5fi29d9d5g'),(991,'scan-9t6h3wa05b0m0f'),(992,'scan-3k2c1gt17o7f8g'),(993,'scan-1q3h0uv28i7t8a'),(994,'scan-0u2l6tx73c3v5r'),(995,'scan-9r4q5yx85c1h4o'),(996,'scan-8d0v4gc94u9k8f'),(997,'scan-5j3r6az21n6u7u'),(998,'scan-8v6h1xv63h3g8v'),(999,'scan-1g0j5jf97g7x2k'),(1000,'scan-7g3e0hc62x0z7d');
/*!40000 ALTER TABLE `scan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `tags_documents`
--

DROP TABLE IF EXISTS `tags_documents`;
/*!50001 DROP VIEW IF EXISTS `tags_documents`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `tags_documents` (
  `Id_Document` tinyint NOT NULL,
  `Nom_Document` tinyint NOT NULL,
  `DateDocument` tinyint NOT NULL,
  `DateScan` tinyint NOT NULL,
  `Flag_document` tinyint NOT NULL,
  `Id_Reference` tinyint NOT NULL,
  `Nom_reference` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `type_de_document`
--

DROP TABLE IF EXISTS `type_de_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_de_document` (
  `Id_Type_De_Document` int(11) NOT NULL AUTO_INCREMENT,
  `Nom_type_de_document` varchar(50) DEFAULT NULL,
  `Flag_type_de_document` tinyint(1) DEFAULT NULL,
  `Id_Dossier` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_Type_De_Document`),
  KEY `Id_Dossier` (`Id_Dossier`),
  CONSTRAINT `type_de_document_ibfk_1` FOREIGN KEY (`Id_Dossier`) REFERENCES `dossier` (`Id_Dossier`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_de_document`
--

LOCK TABLES `type_de_document` WRITE;
/*!40000 ALTER TABLE `type_de_document` DISABLE KEYS */;
INSERT INTO `type_de_document` VALUES (1,'photo',0,3),(2,'document',0,3),(3,'mail',0,3),(4,'manga',0,3),(7,'manga',0,5),(8,'manga',0,6),(9,'manga',0,6),(10,'manga',0,6),(11,'manga',0,6),(12,'manga',0,7),(13,'manga',0,7),(14,'manga',0,7),(15,'document',0,3),(16,'mail',0,3),(17,'mail',0,3),(18,'document',0,3),(19,'document',0,1),(20,'mail',0,3),(21,'document',0,3),(22,'manga',0,3),(23,'manga',0,3),(24,'manga',0,3),(25,'manga',0,3),(26,'manga',0,3),(27,'manga',0,17),(28,'document',0,11),(29,'mail',0,14),(30,'mail',0,20),(31,'mail',0,17);
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
  `Nom_type_dossier` varchar(50) DEFAULT NULL,
  `Flag_type_dossier` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Id_Type_Dossier`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_dossier`
--

LOCK TABLES `type_dossier` WRITE;
/*!40000 ALTER TABLE `type_dossier` DISABLE KEYS */;
INSERT INTO `type_dossier` VALUES (1,'Comptabilite',0),(2,'Dev',0),(3,'Web',0),(4,'Projet',0);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typer`
--

LOCK TABLES `typer` WRITE;
/*!40000 ALTER TABLE `typer` DISABLE KEYS */;
INSERT INTO `typer` VALUES (1,6),(1,12),(2,1),(2,2),(2,5),(2,10),(2,13),(2,15),(3,2),(3,4),(3,16),(4,12),(4,14),(4,17),(5,9),(5,14),(6,1),(6,4),(6,6),(6,7),(6,8),(6,10),(6,13),(7,1),(7,17),(8,9),(8,13),(8,17),(9,5),(10,14),(11,4),(11,6),(11,8),(11,12),(12,4),(12,8),(12,14),(13,5),(14,1),(14,2),(14,16),(15,13),(16,14),(17,1),(17,6),(17,9),(18,3),(18,5),(18,10),(18,17),(19,2),(19,9),(19,16),(19,17),(20,9),(20,10),(21,4),(21,7),(22,12),(23,1),(23,2),(23,5),(23,15),(23,17),(24,9),(25,3),(25,10),(25,17),(26,1),(26,3),(27,1),(27,5),(27,7),(27,14),(27,17),(28,2),(28,7),(28,11),(28,12),(29,2),(29,5),(29,6),(29,8),(29,15),(30,6),(30,11),(30,12),(31,5),(31,7),(32,15),(33,17),(33,27),(34,8),(34,12),(34,26),(35,5),(35,10),(35,14),(35,15),(36,4),(37,5),(37,8),(37,12),(37,14),(39,4),(39,9),(39,13),(40,6),(40,17),(41,14),(42,2),(42,4),(42,11),(42,14),(44,2),(44,3),(44,4),(44,10),(45,4),(45,10),(45,16),(46,7),(46,11),(46,12),(46,14),(47,14),(48,1),(48,9),(48,14),(50,10),(50,13),(50,17),(51,11),(51,15),(51,17),(52,1),(52,2),(52,6),(53,2),(53,17),(54,3),(54,6),(55,1),(55,8),(56,3),(56,4),(56,14),(57,1),(57,6),(58,1),(58,15),(59,8),(59,11),(59,14),(60,1),(61,3),(61,12),(61,13),(63,1),(63,16),(63,17),(64,5),(64,15),(65,13),(65,14),(66,11),(66,12),(67,2),(67,4),(67,9),(67,12),(68,6),(70,8),(70,9),(70,13),(71,2),(71,4),(71,10),(71,12),(71,14),(72,1),(72,6),(72,7),(72,12),(91,28),(91,29),(92,30),(92,31),(93,32),(93,33),(94,34),(94,35),(95,36),(95,37),(96,38),(96,39),(97,40),(97,41),(98,42),(98,43),(99,44),(99,45),(100,48),(100,49),(101,50),(101,51);
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
  `Flag_utilisateur` tinyint(1) DEFAULT NULL,
  `Id_Niveau` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_Utilisateur`),
  KEY `Id_Niveau` (`Id_Niveau`),
  CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`Id_Niveau`) REFERENCES `niveau` (`Id_Niveau`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES (1,'Didi','Neil','neil','test1',1,1),(2,'Cauwenbergh','Eli','eli','test2',1,2),(3,'I','Ilir','ilir','test3',0,3),(4,'Dethioux','Julien','julien','test4',1,4),(5,'Delforge','Laquement','b1@gmail.com','Secret123',0,1),(6,'Browser','Meriem','uht uht','5ebe2294ecd0e0f08eab7690d2a6ee69',0,2),(7,'Nom','Prenom','A','0cc175b9c0f1b6a831c399e269772661',0,1),(8,'dsf','sfg','fsgs','27d779cba60f2b5d48debdd970c8e732',0,1),(9,'Neil','Neil','drnd','020d04ebf72039a093942a6850e56077',0,1),(10,'Franklin','Benjamin','ggg','202cb962ac59075b964b07152d234b70',0,1),(11,'Bebe','Tortue','tortue','c92e5ffb0d3cd851b0609410147692f6',0,1),(12,'','','','d41d8cd98f00b204e9800998ecf8427e',0,1),(13,'Sylvain','Durif','Durif','dcf78929f7ced085219636858ac29c8e',0,1),(14,'z','z','z','fbade9e36a3f36d3d676c1b808451dd7',0,4),(15,'r','r','r','4b43b0aee35624cd95b910189b3dc231',0,6),(16,'Yeromin','Dimitry','Dim','8ed64ce6e8032ddb62a463ffa78881d9',0,5);
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'testdm'
--
/*!50003 DROP PROCEDURE IF EXISTS `delete_document` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `delete_document`(in p_attribut varchar(50), in p_valeur_attribut varchar(50))
begin
	set @condition1 = p_valeur_attribut;
	SET @requete =CONCAT('update document set Flag_Document = true where ',p_attribut, ' =?');
 	PREPARE stmt3 FROM @requete;
 	EXECUTE stmt3 using @condition1;
 	DEALLOCATE PREPARE stmt3;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_from_table` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `delete_from_table`(in p_table varchar(50), in p_attribut varchar(50), in p_valeur_attribut varchar(50))
begin

	set @condition1 = p_valeur_attribut;

	set @table1 = p_table;

	SET @requete =CONCAT('update ',  p_table, ' set Flag_', p_table,' = true where ',p_attribut, ' =?');

 	PREPARE stmt3 FROM @requete;

 	EXECUTE stmt3 using @condition1;

 	DEALLOCATE PREPARE stmt3;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_creationdoc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `insert_creationdoc`(in p_id_utilisateur int)
begin

	insert into creationdoc (DateCreation, Id_Utilisateur)

	values (Current_timestamp(), p_id_utilisateur);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_document` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `insert_document`(in p_nom_document varchar(200), in p_dateDocument datetime, in p_id_creationdoc int, in p_id_type_de_document int, out lastID int )
begin

	insert into document (Nom_Document, DateDocument, Flag_document, Id_CreationDoc, Id_Type_De_Document)

	values (p_nom_document, p_dateDocument, false, p_id_creationdoc, p_id_type_de_document);

	set lastID = last_insert_id(); 

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_document_temp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `insert_document_temp`(in p_nom_document_temp varchar(50), in p_date_document_temp datetime)
begin

	insert into document_temp (Nom_Document_Temp, Date_Document_Temp)

	values (p_nom_document_temp, p_date_document_temp);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_dossier` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `insert_dossier`(in p_nom_dossier varchar(50), in p_id_type_dossier int)
begin

	insert into dossier(Nom_dossier, Flag_dossier, Id_Type_Dossier)

	values (p_nom_dossier, false, p_id_type_dossier);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_niveau` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `insert_niveau`(in p_nom_niveau varchar(50))
begin

	insert into niveau (Nom_Niveau)

	values (p_nom_niveau);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_niv_scan` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `insert_niv_scan`(in p_id_niveau int, in p_id_scan int)
begin

	insert into niv_scan (Id_Niveau, Id_Scan)

	values (p_id_niveau, p_id_scan);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_parametre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `insert_parametre`(in p_path_stock varchar(300), in p_path_backup varchar(300))
begin

	insert into parametre (Path_Stock, Path_Backup)

	values (p_path_stock, p_path_backup);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_reference` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `insert_reference`(in p_nom_ref varchar(50),out lastID int)
begin

	insert into reference(Nom_Reference)

	values(p_nom_ref);
	SET lastID = LAST_INSERT_ID();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_scan_path` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `insert_scan_path`(in p_path varchar(300))
begin

	insert into scan (Nom_Scan)

	values (p_path);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_typer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `insert_typer`(in p_id_document int, in p_id_reference int)
begin

	insert into typer(Id_Document, Id_Reference)

	values (p_id_document, p_id_reference);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_type_de_document` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `insert_type_de_document`(in p_nom_typeDoc varchar(50), in p_id_dossier int)
begin

	insert into type_de_document (Nom_type_de_document, Flag_type_de_document, Id_Dossier)

	values (p_nom_typeDoc, false, p_id_dossier);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_type_dossier` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `insert_type_dossier`(in p_nom_typeDossier varchar(50))
begin

	insert into type_dossier (Nom_type_dossier, Flag_type_dossier)

	values (p_nom_typeDossier, false);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_utilisateur` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `insert_utilisateur`(in p_nom varchar(50), in p_prenom varchar(50), in p_login varchar(50), in p_mdp varchar(50), in id_niveau int(11))
begin

	insert into utilisateur(Nom, Prenom, Login, Mdp, Flag_utilisateur, Id_Niveau)

	values(p_nom, p_prenom, p_login, MD5(p_mdp), false, id_niveau);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `select_document` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `select_document`()
begin

	select * from testdm.document ;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `select_dossier` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `select_dossier`()
begin

	select * from dossier;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `select_niveau` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `select_niveau`()
begin

	select * from niveau;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `select_reference` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `select_reference`()
begin

	select * from reference;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `select_tags_documents` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `select_tags_documents`(in p_tag1 varchar(50), in p_tag2 varchar(50))
begin

	if ((p_tag1 is not null) and (p_tag2 is not null)) then

		select * from tags_documents where Nom_reference = p_tag1 or Nom_reference = p_tag2 group by Id_Document having count(Id_Document) = 2;

	
	elseif (p_tag1 is not null && p_tag2 is null) then

		select * from tags_documents where Nom_reference = p_tag1;

	
	elseif (p_tag2 is not null && p_tag1 is null) then

		select * from tags_documents where Nom_reference = p_tag2;

	END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `select_type_de_document` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `select_type_de_document`()
begin

	select * from type_de_document;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `select_type_dossier` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `select_type_dossier`()
begin

	select * from type_dossier;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_document` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `update_document`(in p_id_document int, in p_nom_document varchar(200), in p_dateDocument datetime, in p_flag_document bool, in p_id_creationdoc int, in p_id_type_de_document int )
begin

	update document 

	set Nom_Document = p_nom_document, DateDocument = p_dateDocument, Flag_document = p_flag_document, Id_CreationDoc = p_id_creationdoc, Id_Type_De_Document = p_id_type_de_document

	where Id_Document = p_id_document; 

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_dossier` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `update_dossier`(in p_id_dossier int, in p_nom_dossier varchar(50), in p_flag_dossier bool, in p_id_type_dossier int )
begin

	update dossier 

	set Nom_dossier = p_nom_dossier, Flag_dossier = p_flag_dossier, Id_Type_Dossier = p_id_type_dossier

	where Id_Dossier = p_id_dossier;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_dossiers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `update_dossiers`(in p_table varchar(50),in p_flag bool, in p_nom varchar(50), in p_condition varchar(50), in p_valeur_attribut varchar(50))
begin

	set @condition1 = p_valeur_attribut;

	SET @requete =CONCAT('update ',  p_table, ' set Flag_', p_table,' = ',p_flag , ', Nom_',p_table, ' = ',p_nom, ' where ',p_condition, ' =?');

 	PREPARE stmt FROM @requete;

 	EXECUTE stmt using @condition1;

 	DEALLOCATE PREPARE stmt;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_niveau` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `update_niveau`(in p_id_niveau int, in p_nom_niveau varchar(50))
begin

	update niveau 

	set Nom_Niveau = p_nom_niveau

	where Id_Niveau = p_id_niveau;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_parametre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `update_parametre`(in p_id_param int, in p_path_stock varchar(300), in p_path_backup varchar(300))
begin

	update parametre 

	set Path_Stock = p_path_stock, Path_Backup = p_path_backup

	where Id_Parametre = p_id_parametre;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_reference` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `update_reference`(in p_id_reference int, in p_nom_reference varchar(50))
begin

	update reference

	set Nom_Reference = p_nom_reference

	where Id_Reference = p_id_reference;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_scan` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `update_scan`(in p_id_scan int, in p_nom_scan varchar(300))
begin

	update scan 

	set Nom_Scan = p_nom_scan

	where Id_Scan = p_id_scan;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_type_de_document` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `update_type_de_document`(in p_id_type_de_document int, in p_nom_type_de_document varchar(50), in p_flag_type_de_document bool, in p_dossier int )
begin

	update type_de_document 

	set Nom_type_de_document = p_nom_type_de_document, Flag_type_de_document = p_flag_type_de_document, Id_Dossier = p_id_dossier

	where Id_Type_De_Document = p_id_type_de_document;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_type_dossier` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `update_type_dossier`(in p_id_type_dossier int, in p_nom_type_dossier varchar(50), in p_flag_type_dossier bool)
begin

	update type_dossier 

	set Nom_type_dossier = p_nom_type_dossier, Flag_type_dossier = p_flag_type_dossier

	where Id_Type_Dossier = p_id_type_dossier;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_utilisateur` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `update_utilisateur`(in p_id_utilisateur int, in p_nom varchar(50), in p_prenom varchar(50), in p_login varchar(50), in p_mdp varchar(50), in p_flag_utilisateur bool, in p_id_niveau int)
begin

	update utilisateur 

	set Nom = p_nom, Prenom = p_prenom, Login = p_login, Mdp = MD5(p_mdp), Flag_utilisateur = p_flag_utilisateur, Id_Niveau = p_id_niveau

	where Id_Utilisateur = p_id_utilisateur;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `user_identification` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `user_identification`(in p_login varchar(50), in p_mdp varchar(50))
begin

	select count(1) 

	from utilisateur

	where Login = p_login  and Mdp = MD5(p_mdp) ;	

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `tags_documents`
--

/*!50001 DROP TABLE IF EXISTS `tags_documents`*/;
/*!50001 DROP VIEW IF EXISTS `tags_documents`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_unicode_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013  SQL SECURITY DEFINER */
/*!50001 VIEW `tags_documents` AS select `document`.`Id_Document` AS `Id_Document`,`document`.`Nom_Document` AS `Nom_Document`,`document`.`DateDocument` AS `DateDocument`,`document`.`DateScan` AS `DateScan`,`document`.`Flag_document` AS `Flag_document`,`typer`.`Id_Reference` AS `Id_Reference`,`reference`.`Nom_Reference` AS `Nom_reference` from ((`document` join `typer` on(`document`.`Id_Document` = `typer`.`Id_Document`)) join `reference` on(`typer`.`Id_Reference` = `reference`.`Id_Reference`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-06  2:27:49
