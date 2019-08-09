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
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `transaction_id` varchar(36) NOT NULL,
  `buyer_id` int(11) DEFAULT NULL,
  `buyer_name` varchar(30) NOT NULL,
  `seller_id` int(11) DEFAULT NULL,
  `seller_name` varchar(30) NOT NULL,
  `total_price` double DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  CONSTRAINT `` FOREIGN KEY (`transaction_id`) REFERENCES `order_tracking` (`transaction_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES ('1c6aa42b-4048-4a36-83ea-b33ac0ee7080',74,'Aman Malviya',73,'Harsh Patidar',1058,'2019-08-08 17:17:25'),('2bff160f-8623-4682-88aa-607d670e91e9',74,'Aman Malviya',73,'Harsh Patidar',10000,'2019-08-08 18:35:19'),('2ebd1414-6116-4867-90da-b3258b4782bd',74,'Aman Malviya',73,'Harsh Patidar',1000,'2019-08-08 19:59:26'),('3e7a20d1-f3c5-4cca-8622-5bd136e753ce',74,'Aman Malviya',73,'Harsh Patidar',1058,'2019-08-08 17:16:23'),('4b316238-89d1-4e26-b646-6dca11b4114f',73,'Harsh Patidar',1,'admin',10580000,'2019-08-08 17:52:20'),('4f994789-d07d-42d4-8149-e63a1a8e065b',74,'Aman Malviya',73,'Harsh Patidar',2116,'2019-08-08 17:12:51'),('4fde163b-0359-4080-b273-6acbb585d813',74,'Aman Malviya',73,'Harsh Patidar',8000,'2019-08-08 19:12:14'),('5a101f05-6b19-4308-8596-d85e930e2501',73,'Harsh Patidar',1,'admin',105800,'2019-08-08 17:51:45'),('627d8864-d108-4a50-bf99-36c718237f03',74,'Aman Malviya',73,'Harsh Patidar',25,'2019-08-08 20:03:51'),('68c18007-522b-48c0-a7be-ce4d6f960c02',74,'Aman Malviya',73,'Harsh Patidar',1058,'2019-08-08 17:20:13'),('6dac9a29-5012-4422-a4d5-1a34be718791',74,'Aman Malviya',73,'Harsh Patidar',3174,'2019-08-08 17:13:23'),('6df7af1d-3388-4f41-81f4-26ffd1d0e098',73,'Harsh Patidar',1,'Admin',1000,'2019-08-08 18:26:43'),('85e59bdf-d947-4267-9b91-20d7c771f3b8',73,'Harsh Patidar',1,'admin',131800,'2019-08-08 16:48:58'),('868261cb-4367-4734-8de2-5f0089ecec7e',74,'Aman Malviya',73,'Harsh Patidar',9000,'2019-08-08 19:13:05'),('9b01af6f-24ed-4988-b6eb-9ccdb69b5006',74,'Aman Malviya',73,'Harsh Patidar',9000,'2019-08-08 19:13:13'),('a9a5754f-5a1c-4f55-8dc8-983098fd6473',74,'Aman Malviya',73,'Harsh Patidar',9000,'2019-08-08 19:12:24'),('b14e109c-3934-4cd5-961c-920f48514471',74,'Aman Malviya',73,'Harsh Patidar',1058,'2019-08-08 17:16:10'),('b60a438c-eb58-469c-bcd1-275202d92d82',74,'Aman Malviya',73,'Harsh Patidar',52900,'2019-08-08 17:19:00'),('bb79649e-cd57-4200-9474-a7d582ec30bb',73,'Harsh Patidar',1,'Admin',46000,'2019-08-08 20:25:41'),('d5f6863c-12b3-4ccf-880f-76820f84e726',74,'Aman Malviya',73,'Harsh Patidar',59200,'2019-08-08 16:53:23'),('d9657016-3ad3-43ce-9e96-f195492280b1',74,'Aman Malviya',73,'Harsh Patidar',1058,'2019-08-08 17:16:32'),('df81acb5-1983-4719-af93-55e3880fdf5a',74,'Aman Malviya',73,'Harsh Patidar',1058,'2019-08-08 17:20:22'),('ea88ef8e-7f71-41a1-bc69-f9281d786bbb',74,'Aman Malviya',73,'Harsh Patidar',100,'2019-08-08 18:38:38'),('f87487ac-c2e9-475c-8c92-563a0f0672b8',74,'Aman Malviya',73,'Harsh Patidar',10,'2019-08-08 18:38:17');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-08 20:35:05
