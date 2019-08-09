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
-- Table structure for table `transaction_details`
--

DROP TABLE IF EXISTS `transaction_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_details` (
  `transaction_id` varchar(36) NOT NULL,
  `product_name` varchar(45) DEFAULT NULL,
  `quantity` int(4) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  KEY `transaction_id_idx` (`transaction_id`),
  CONSTRAINT `transaction_id` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_details`
--

LOCK TABLES `transaction_details` WRITE;
/*!40000 ALTER TABLE `transaction_details` DISABLE KEYS */;
INSERT INTO `transaction_details` VALUES ('85e59bdf-d947-4267-9b91-20d7c771f3b8','SIM Card',100,1058),('85e59bdf-d947-4267-9b91-20d7c771f3b8','E-Recharge',1000,1),('85e59bdf-d947-4267-9b91-20d7c771f3b8','Coupon 50',500,50),('d5f6863c-12b3-4ccf-880f-76820f84e726','SIM Card',55,1058),('d5f6863c-12b3-4ccf-880f-76820f84e726','E-Recharge',10,1),('d5f6863c-12b3-4ccf-880f-76820f84e726','Coupon 50',20,50),('4f994789-d07d-42d4-8149-e63a1a8e065b','SIM Card',2,1058),('6dac9a29-5012-4422-a4d5-1a34be718791','SIM Card',3,1058),('b14e109c-3934-4cd5-961c-920f48514471','SIM Card',1,1058),('3e7a20d1-f3c5-4cca-8622-5bd136e753ce','SIM Card',1,1058),('d9657016-3ad3-43ce-9e96-f195492280b1','SIM Card',1,1058),('1c6aa42b-4048-4a36-83ea-b33ac0ee7080','SIM Card',1,1058),('b60a438c-eb58-469c-bcd1-275202d92d82','SIM Card',50,1058),('68c18007-522b-48c0-a7be-ce4d6f960c02','SIM Card',1,1058),('df81acb5-1983-4719-af93-55e3880fdf5a','SIM Card',1,1058),('5a101f05-6b19-4308-8596-d85e930e2501','SIM Card',100,1058),('4b316238-89d1-4e26-b646-6dca11b4114f','SIM Card',10000,1058),('6df7af1d-3388-4f41-81f4-26ffd1d0e098','SIM Card',1,1000),('2bff160f-8623-4682-88aa-607d670e91e9','SIM Card',10,1000),('f87487ac-c2e9-475c-8c92-563a0f0672b8','E-Recharge',10,1),('ea88ef8e-7f71-41a1-bc69-f9281d786bbb','E-Recharge',100,1),('4fde163b-0359-4080-b273-6acbb585d813','SIM Card',8,1000),('a9a5754f-5a1c-4f55-8dc8-983098fd6473','SIM Card',9,1000),('868261cb-4367-4734-8de2-5f0089ecec7e','SIM Card',9,1000),('9b01af6f-24ed-4988-b6eb-9ccdb69b5006','SIM Card',9,1000),('2ebd1414-6116-4867-90da-b3258b4782bd','SIM Card',1,1000),('627d8864-d108-4a50-bf99-36c718237f03','E-Recharge',25,1),('bb79649e-cd57-4200-9474-a7d582ec30bb','SIM Card',45,1000),('bb79649e-cd57-4200-9474-a7d582ec30bb','E-Recharge',1000,1);
/*!40000 ALTER TABLE `transaction_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-08 20:35:06
