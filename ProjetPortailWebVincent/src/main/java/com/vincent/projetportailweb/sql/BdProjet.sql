CREATE DATABASE  IF NOT EXISTS `projetsession` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `projetsession`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: projetsession
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(150) NOT NULL,
  `nom` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bbxiq3fbrr32wfkco6ichxaly` (`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_acces`
--

DROP TABLE IF EXISTS `tbl_acces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_acces` (
  `acces_id` int NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`acces_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_acces`
--

LOCK TABLES `tbl_acces` WRITE;
/*!40000 ALTER TABLE `tbl_acces` DISABLE KEYS */;
INSERT INTO `tbl_acces` VALUES (1,'Guest'),(2,'Reporter'),(3,'Developer'),(4,'Maintainer'),(5,'Owner');
/*!40000 ALTER TABLE `tbl_acces` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_accounttype`
--

DROP TABLE IF EXISTS `tbl_accounttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_accounttype` (
  `accountType_id` int NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `account_type_id` int NOT NULL,
  PRIMARY KEY (`accountType_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_accounttype`
--

LOCK TABLES `tbl_accounttype` WRITE;
/*!40000 ALTER TABLE `tbl_accounttype` DISABLE KEYS */;
INSERT INTO `tbl_accounttype` VALUES (0,'administrator',0),(1,'invite',0),(2,'etudiant',0),(3,'professeur',0),(4,'ancienEtudiant',0);
/*!40000 ALTER TABLE `tbl_accounttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_evaluation`
--

DROP TABLE IF EXISTS `tbl_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_evaluation` (
  `user_id` int NOT NULL,
  `projet_id` int NOT NULL,
  `note` int DEFAULT NULL,
  `commentaire` text,
  PRIMARY KEY (`user_id`,`projet_id`),
  KEY `projet_id` (`projet_id`),
  CONSTRAINT `tbl_evaluation_ibfk_1` FOREIGN KEY (`projet_id`) REFERENCES `tbl_projet` (`projet_id`),
  CONSTRAINT `tbl_evaluation_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_evaluation`
--

LOCK TABLES `tbl_evaluation` WRITE;
/*!40000 ALTER TABLE `tbl_evaluation` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_fichier`
--

DROP TABLE IF EXISTS `tbl_fichier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_fichier` (
  `fichier_id` int NOT NULL,
  `fichier_nom` varchar(30) DEFAULT NULL,
  `contenu` varchar(100) DEFAULT NULL,
  `id` int NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fichier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_fichier`
--

LOCK TABLES `tbl_fichier` WRITE;
/*!40000 ALTER TABLE `tbl_fichier` DISABLE KEYS */;
INSERT INTO `tbl_fichier` VALUES (1,'chat.png','TestTestTestTest',0,NULL),(2,'rigolo.docx','hahahahahah',0,NULL),(3,'betaDasa.sql','Jesaispasquoimettre',0,NULL);
/*!40000 ALTER TABLE `tbl_fichier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_fichierpost`
--

DROP TABLE IF EXISTS `tbl_fichierpost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_fichierpost` (
  `fichier_id` int NOT NULL,
  `post_id` int NOT NULL,
  PRIMARY KEY (`fichier_id`,`post_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `tbl_fichierpost_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `tbl_post` (`post_id`),
  CONSTRAINT `tbl_fichierpost_ibfk_2` FOREIGN KEY (`fichier_id`) REFERENCES `tbl_fichier` (`fichier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_fichierpost`
--

LOCK TABLES `tbl_fichierpost` WRITE;
/*!40000 ALTER TABLE `tbl_fichierpost` DISABLE KEYS */;
INSERT INTO `tbl_fichierpost` VALUES (1,1),(2,1),(3,2);
/*!40000 ALTER TABLE `tbl_fichierpost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_invite`
--

DROP TABLE IF EXISTS `tbl_invite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_invite` (
  `user_id` int NOT NULL,
  `projet_id` int NOT NULL,
  `acces_id` int DEFAULT NULL,
  PRIMARY KEY (`user_id`,`projet_id`),
  KEY `projet_id` (`projet_id`),
  KEY `acces_id` (`acces_id`),
  CONSTRAINT `tbl_invite_ibfk_1` FOREIGN KEY (`projet_id`) REFERENCES `tbl_projet` (`projet_id`),
  CONSTRAINT `tbl_invite_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`),
  CONSTRAINT `tbl_invite_ibfk_3` FOREIGN KEY (`acces_id`) REFERENCES `tbl_acces` (`acces_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_invite`
--

LOCK TABLES `tbl_invite` WRITE;
/*!40000 ALTER TABLE `tbl_invite` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_invite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_post`
--

DROP TABLE IF EXISTS `tbl_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_post` (
  `post_id` int NOT NULL,
  `projet_id` int NOT NULL,
  `caption` varchar(50) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `moment` datetime DEFAULT NULL,
  PRIMARY KEY (`post_id`,`projet_id`),
  KEY `projet_id` (`projet_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tbl_post_ibfk_1` FOREIGN KEY (`projet_id`) REFERENCES `tbl_projet` (`projet_id`),
  CONSTRAINT `tbl_post_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_post`
--

LOCK TABLES `tbl_post` WRITE;
/*!40000 ALTER TABLE `tbl_post` DISABLE KEYS */;
INSERT INTO `tbl_post` VALUES (1,1,'Premier post du projet pour daddy dini',3,'2012-06-18 10:34:09'),(2,1,'Ajout dans le projet',4,'2012-06-12 15:34:09');
/*!40000 ALTER TABLE `tbl_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_projet`
--

DROP TABLE IF EXISTS `tbl_projet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_projet` (
  `projet_id` int NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `statut` tinyint(1) DEFAULT NULL,
  `id` int NOT NULL,
  `annee_session` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `profil` varchar(255) DEFAULT NULL,
  `url_video_presentation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`projet_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tbl_projet_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_projet`
--

LOCK TABLES `tbl_projet` WRITE;
/*!40000 ALTER TABLE `tbl_projet` DISABLE KEYS */;
INSERT INTO `tbl_projet` VALUES (1,'test',3,0,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_projet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_user` (
  `user_id` int NOT NULL,
  `nom` varchar(35) DEFAULT NULL,
  `prenom` varchar(35) DEFAULT NULL,
  `accountType_id` int DEFAULT NULL,
  `passwd` varchar(99) DEFAULT NULL,
  `tuteur` tinyint(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `account_type_id` int DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `accountType_id` (`accountType_id`),
  CONSTRAINT `tbl_user_ibfk_1` FOREIGN KEY (`accountType_id`) REFERENCES `tbl_accounttype` (`accountType_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (1,'Admin','Admin',0,'root',0,NULL,NULL),(2,'Invité','Invité',1,'',0,NULL,NULL),(3,'Cormier','Jérémy',2,'RalphBisou',0,NULL,NULL),(4,'Gabriel','Ralph Christian',2,'Qwerty123$',1,NULL,NULL),(5,'Dini','Daddy',3,'Qwerty123$',0,NULL,NULL);
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-22 11:56:24
