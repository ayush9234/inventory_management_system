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
-- Table structure for table `inventory_table`
--

DROP TABLE IF EXISTS `inventory_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory_table` (
  `user_id` int(11) NOT NULL,
  `product_id` int(4) NOT NULL,
  `product_quantity` int(4) DEFAULT NULL,
  `monetary_value` double DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  `updation_time` datetime DEFAULT NULL,
  `product_name` varchar(45) DEFAULT NULL,
  KEY `sf_idx` (`user_id`),
  KEY `ss_idx` (`product_id`),
  CONSTRAINT `sf` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ss` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory_table`
--

LOCK TABLES `inventory_table` WRITE;
/*!40000 ALTER TABLE `inventory_table` DISABLE KEYS */;
INSERT INTO `inventory_table` VALUES (73,1,10118,0,'2019-08-08 16:43:36','2019-08-08 19:15:19','SIM Card'),(73,2,890,0,'2019-08-08 16:43:36','2019-08-08 19:15:11','E-Recharge'),(73,3,480,0,'2019-08-08 16:43:36','2019-08-08 16:53:38','Coupon 50'),(74,1,56,0,'2019-08-08 16:46:07','2019-08-08 19:15:19','SIM Card'),(74,2,100,0,'2019-08-08 16:46:07','2019-08-08 19:15:11','E-Recharge'),(74,3,20,0,'2019-08-08 16:46:07','2019-08-08 16:53:38','Coupon 50'),(75,1,0,0,'2019-08-08 18:18:49','2019-08-08 18:18:49','SIM Card'),(75,2,0,0,'2019-08-08 18:18:49','2019-08-08 18:18:49','E-Recharge'),(75,3,0,0,'2019-08-08 18:18:49','2019-08-08 18:18:49','Coupon 50'),(76,1,0,0,'2019-08-08 18:19:48','2019-08-08 18:19:48','SIM Card'),(76,2,0,0,'2019-08-08 18:19:48','2019-08-08 18:19:48','E-Recharge'),(76,3,0,0,'2019-08-08 18:19:48','2019-08-08 18:19:48','Coupon 50');
/*!40000 ALTER TABLE `inventory_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-08 20:35:08
