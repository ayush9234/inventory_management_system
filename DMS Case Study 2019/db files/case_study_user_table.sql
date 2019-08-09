CREATE DATABASE  IF NOT EXISTS `case_study` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `case_study`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: case_study
-- ------------------------------------------------------
-- Server version	5.5.24

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
-- Table structure for table `user_table`
--

DROP TABLE IF EXISTS `user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_table` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) NOT NULL,
  `password` varchar(60) NOT NULL,
  `email` varchar(256) NOT NULL,
  `personal_address` varchar(100) DEFAULT NULL,
  `contact_no` varchar(13) DEFAULT NULL,
  `status` varchar(8) DEFAULT NULL,
  `role_type` int(4) DEFAULT NULL,
  `area` varchar(30) NOT NULL,
  `creation_time` datetime DEFAULT NULL,
  `updation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `contact_no_UNIQUE` (`contact_no`),
  KEY `role_type_idx` (`role_type`),
  CONSTRAINT `role_type` FOREIGN KEY (`role_type`) REFERENCES `role_table` (`role_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_table`
--

LOCK TABLES `user_table` WRITE;
/*!40000 ALTER TABLE `user_table` DISABLE KEYS */;
INSERT INTO `user_table` VALUES (1,'Admin','$2a$10$1s/L9ZAN1//nMj9pwPwvoOQshkDFbB5u/ufoGmDiHTkaz/ILbPKLK','akshay.mahajan@gmail.com','245, Captown','8871838785',NULL,1,'indore','2019-07-25 17:12:18','2019-08-08 18:12:35'),(73,'Harsh Patidar','$2a$10$N/ucITUCx5Yp7T6ADWSMMeJghqQwmyU8zNKllopE6MCQ8ozL.gXpC','harsh.patidar99@gmail.com','1478 NEW DWARKAPURI BEHIND MAHALAXMI PARISAR','8458824577','active',2,'Indore','2019-08-08 16:43:36','2019-08-08 16:43:36'),(74,'Aman Malviya','$2a$10$rg91g0pH8Cxu.05e3eIUhuytVXkpcl3dLp1M9zcESmVyd7fUy2yWG','aman.malviya@impetus.co.in','45 Sudama Nagar','9876541253','active',3,'Indore','2019-08-08 16:46:07','2019-08-08 16:46:07'),(75,'Pravin','$2a$10$wnvijbp1VWErb1GLG89J2uUUgnpVZ4kJYQ4NU5LladvjqhxrkfztS','pravin.agrawal@impetus.co.in','245 madurai','9898988989','active',2,'Madurai','2019-08-08 18:18:49','2019-08-08 18:18:49'),(76,'Akshay','$2a$10$m6OSwyB.TeEW7j2Zwomrwe/Yr0DpjgjDQTit8/Ur/iSjmijV94cbG','akshay.mahajan@impetus.co.in','401 ','9090909090','active',2,'Madurai','2019-08-08 18:19:48','2019-08-08 18:19:48');
/*!40000 ALTER TABLE `user_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-08 20:35:11
