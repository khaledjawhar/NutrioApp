-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: nutriodb
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Current Database: `nutriodb`
--

/*!40000 DROP DATABASE IF EXISTS `nutriodb`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `nutriodb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `nutriodb`;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `patient_name` varchar(45) NOT NULL,
  `patient_address` varchar(45) DEFAULT NULL,
  `patient_phone` varchar(45) DEFAULT NULL,
  `patient_medicalhistory` text,
  `patient_workoccupation` varchar(100) DEFAULT NULL,
  `patient_allergies` varchar(20) DEFAULT NULL,
  `patient_previousdiets` varchar(20) DEFAULT NULL,
  `patient_medications` varchar(100) DEFAULT NULL,
  `patient_supplements` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`patient_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES ('ali jawhar','2270 cotters crescent','6138900596','none','engineer','No','No','none','none'),('ali zika','george street','244917490078','none','auditor','No','Yes','none','Vitamin A'),('khola','33 aldercrest drive','6138900596','blood pressure','IT','Yes','Yes','tylynol	','vitaminC'),('khosta','33 aldercrest dr','6138900596','I have no medical history','','Yes','Yes','anti inflammatory','vitamin C');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_foodrecall`
--

DROP TABLE IF EXISTS `patient_foodrecall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_foodrecall` (
  `patient_name` varchar(45) NOT NULL,
  `foodrecall_number` int(11) NOT NULL,
  `foodrecall_id` int(11) NOT NULL AUTO_INCREMENT,
  `food_type` varchar(100) DEFAULT NULL,
  `meal_serving` varchar(45) DEFAULT NULL,
  `food_calories` varchar(45) DEFAULT NULL,
  `food_protein` varchar(45) DEFAULT NULL,
  `food_carbohydrate` varchar(45) DEFAULT NULL,
  `food_fat` varchar(45) DEFAULT NULL,
  `meal_type` varchar(45) DEFAULT NULL,
  `visit_date` date DEFAULT NULL,
  `foodrecall_date` date DEFAULT NULL,
  `food_cholesterol` varchar(45) DEFAULT NULL,
  `food_sodium` varchar(45) DEFAULT NULL,
  `food_fiber` varchar(45) DEFAULT NULL,
  `food_sugars` varchar(45) DEFAULT NULL,
  `food_vitamin_a` varchar(45) DEFAULT NULL,
  `food_vitamin_c` varchar(45) DEFAULT NULL,
  `food_calcium` varchar(45) NOT NULL,
  `food_iron` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`foodrecall_id`,`food_calcium`),
  KEY `patient_name_idx` (`patient_name`),
  CONSTRAINT `patient_foodrecall_name` FOREIGN KEY (`patient_name`) REFERENCES `patient` (`patient_name`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_foodrecall`
--

LOCK TABLES `patient_foodrecall` WRITE;
/*!40000 ALTER TABLE `patient_foodrecall` DISABLE KEYS */;
INSERT INTO `patient_foodrecall` VALUES ('khola',1,1,'Coke','1','150.47','0.0','37.0','0.0','BreakFast','2017-12-12','2017-12-12','0.0','0.0','0.0','37.0','0.0','0.0','0.0','0.0'),('khola',2,3,'Apple - 1 cup, quartered or chopped','1','65.0','0.33','17.26','0.21','BreakFast','2017-12-10','2017-12-11','0.0','1.25','3.0','12.99','1.35','9.58','0.75','0.83'),('khosta',1,12,'Peaches, yellow, raw - 1 NLEA serving','1','57.33','1.34','14.02','0.37','BreakFast','2017-01-12','2017-01-12','0.0','0.0','2.21','12.33','9.58','16.17','0.88','2.04'),('khosta',1,13,'Peaches, yellow, raw - 1 large (2-3/4\" dia)','1','68.25','1.59','16.7','0.44','BreakFast','2017-01-12','2017-01-12','0.0','0.0','2.63','14.68','11.41','19.25','1.05','2.43'),('khosta',1,14,'Peaches, yellow, raw - 1 cup slices','1','60.06','1.4','14.69','0.39','BreakFast','2017-01-12','2017-01-12','0.0','0.0','2.31','12.92','10.04','16.94','0.92','2.14'),('khosta',1,15,'Peaches, yellow, raw - 1 extra large (3\" dia)','1','87.36','2.04','21.37','0.56','BreakFast','2017-01-12','2017-01-12','0.0','0.0','3.36','18.79','14.6','24.64','1.34','3.11'),('khosta',1,16,'Peaches, yellow, raw - 1 medium (2-2/3\" dia)','1','58.5','1.37','14.31','0.38','BreakFast','2017-01-12','2017-01-12','0.0','0.0','2.25','12.59','9.78','16.5','0.9','2.08'),('khosta',1,17,'Peaches, yellow, raw - 1 small (2-1/2\" dia)','1','50.7','1.18','12.4','0.33','BreakFast','2017-01-12','2017-01-12','0.0','0.0','1.95','10.91','8.48','14.3','0.78','1.81'),('khosta',1,18,'Peach','1','250.0','4.0','38.0','9.0','BreakFast','2017-01-12','2017-01-12','0.0','300.0','1.0','16.0','0.0','0.0','0.0','0.0'),('khosta',1,19,'Peach','1','260.0','0.0','71.0','0.0','BreakFast','2017-01-12','2017-01-12','0.0','60.0','0.0','71.0','0.0','0.0','0.0','0.0'),('khosta',1,20,'Peach','1','170.0','6.0','35.0','2.0','BreakFast','2017-01-12','2017-01-12','10.0','105.0','0.0','30.0','0.0','2.0','20.0','0.0'),('khosta',1,21,'Peach','1','90.0','1.0','14.0','4.0','BreakFast','2017-01-12','2017-01-12','0.0','80.0','0.0','8.0','0.0','0.0','0.0','0.0'),('khosta',1,22,'Cheese, cheddar - 1 cup, melted','1','985.76','55.8','7.54','81.28','Dinner','2017-01-12','2017-01-12','241.56','1593.32','0.0','1.17','60.61','0.0','173.24','1.9'),('khosta',1,23,'Cheese, cheddar - 1 cup, diced','1','533.28','30.19','4.08','43.97','Dinner','2017-01-12','2017-01-12','130.68','861.96','0.0','0.63','32.79','0.0','93.72','1.03'),('khosta',1,24,'Cheese, cheddar - 1 cubic inch','1','68.68','3.89','0.53','5.66','Dinner','2017-01-12','2017-01-12','16.83','111.01','0.0','0.08','4.22','0.0','12.07','0.13'),('khosta',1,25,'Cheese, cheddar - 1 cup, shredded','1','456.52','25.84','3.49','37.64','Dinner','2017-01-12','2017-01-12','111.87','737.89','0.0','0.54','28.07','0.0','80.23','0.88'),('khosta',1,26,'Cheese, cheddar - 1 oz','1','114.53','6.48','0.88','9.44','Dinner','2017-01-12','2017-01-12','28.07','185.13','0.0','0.14','7.04','0.0','20.13','0.22'),('khosta',1,27,'Cheese, cheddar - 1 slice (1 oz)','1','113.12','6.4','0.87','9.33','Dinner','2017-01-12','2017-01-12','27.72','182.84','0.0','0.13','6.96','0.0','19.88','0.22'),('khosta',1,28,'Strings Original 8 Pack','1','60.43','4.6','0.5','4.5','Dinner','2017-01-12','2017-01-12','0.0','160.0','0.0','0.2','0.0','0.0','0.0','0.0'),('khosta',1,29,'Strings Original 4 Pack','1','60.43','4.6','0.5','4.5','Dinner','2017-01-12','2017-01-12','0.0','160.0','0.0','0.2','0.0','0.0','0.0','0.0'),('khosta',1,30,'Cheese','1','72.85','1.7','0.9','7.0','Dinner','2017-01-12','2017-01-12','0.0','120.0','0.1','0.9','0.0','0.0','0.0','0.0'),('khosta',1,31,'Cheese','1','82.0','5.0','0.0','6.0','Dinner','2017-01-12','2017-01-12','20.0','182.0','0.0','0.0','0.0','0.0','0.0','0.0'),('khosta',2,32,'Bananas, raw - 1 medium (7\" to 7-7/8\" long)','1','105.02','1.29','26.95','0.39','Dinner','2017-01-13','2017-01-13','0.0','1.18','3.07','14.43','1.51','17.11','0.59','1.7'),('khosta',2,33,'Bananas, raw - 1 small (6\" to 6-7/8\" long)','1','89.89','1.1','23.07','0.33','Dinner','2017-01-13','2017-01-13','0.0','1.01','2.63','12.35','1.29','14.65','0.51','1.46'),('khosta',2,34,'Bananas, raw - 1 cup, mashed','1','200.25','2.45','51.39','0.74','Dinner','2017-01-13','2017-01-13','0.0','2.25','5.85','27.52','2.88','32.63','1.13','3.25'),('khosta',2,35,'Bananas, raw - 1 NLEA serving','1','112.14','1.37','28.78','0.42','Dinner','2017-01-13','2017-01-13','0.0','1.26','3.28','15.41','1.61','18.27','0.63','1.82'),('khosta',2,36,'Bananas, raw - 1 cup, sliced','1','133.5','1.64','34.26','0.5','Dinner','2017-01-13','2017-01-13','0.0','1.5','3.9','18.35','1.92','21.75','0.75','2.17'),('khosta',2,37,'Bananas, raw - 1 small (6\" to 6-7/8\" long)','1','89.89','1.1','23.07','0.33','BreakFast','2017-01-13','2017-01-13','0.0','1.01','2.63','12.35','1.29','14.65','0.51','1.46'),('khosta',2,38,'Bananas, raw - 1 medium (7\" to 7-7/8\" long)','1','105.02','1.29','26.95','0.39','BreakFast','2017-01-13','2017-01-13','0.0','1.18','3.07','14.43','1.51','17.11','0.59','1.7'),('khosta',2,39,'Bananas, raw - 1 cup, sliced','1','133.5','1.64','34.26','0.5','BreakFast','2017-01-13','2017-01-13','0.0','1.5','3.9','18.35','1.92','21.75','0.75','2.17'),('khosta',2,40,'Bananas, raw - 1 NLEA serving','1','112.14','1.37','28.78','0.42','BreakFast','2017-01-13','2017-01-13','0.0','1.26','3.28','15.41','1.61','18.27','0.63','1.82'),('khosta',2,41,'Bananas, raw - 1 extra large (9\" or longer)','1','135.28','1.66','34.72','0.5','BreakFast','2017-01-13','2017-01-13','0.0','1.52','3.95','18.59','1.95','22.04','0.76','2.2'),('khosta',3,47,'Bananas, raw - 1 cup, mashedUSDA','1','200.25','2.45','51.39','0.74','BreakFast','1983-10-21','1983-10-21','0.0','2.25','5.85','27.52','2.88','32.63','1.13','3.25'),('khosta',3,48,'Bananas, raw - 1 cup, mashedUSDA','1','200.25','2.45','51.39','0.74','BreakFast','1983-10-21','1983-10-21','0.0','2.25','5.85','27.52','2.88','32.63','1.13','3.25'),('khosta',3,49,'Bananas, raw - 1 cup, mashedUSDA','1','200.25','2.45','51.39','0.74','BreakFast','1983-10-21','1983-10-21','0.0','2.25','5.85','27.52','2.88','32.63','1.13','3.25'),('khosta',3,50,'Bananas, raw - 1 extra large (9\" or longer)USDA','2','270.56','3.32','69.44','1.0','BreakFast','1983-10-21','1983-10-21','0.0','3.04','7.9','37.18','3.9','44.08','1.52','4.4'),('khosta',3,51,'Bananas, raw - 1 extra large (9\" or longer)USDA','1','135.28','1.66','34.72','0.5','BreakFast','1983-10-21','1983-10-21','0.0','1.52','3.95','18.59','1.95','22.04','0.76','2.2'),('khosta',3,52,'BananaFreshBerry','1','25.0','0.0','7.0','0.0','BreakFast','1983-10-21','1983-10-21','0.0','0.0','1.0','3.0','0.0','0.0','0.0','0.0'),('khosta',3,53,'BananaFreshBerry','1','25.0','0.0','7.0','0.0','BreakFast','1983-10-21','1983-10-21','0.0','0.0','1.0','3.0','0.0','0.0','0.0','0.0'),('khosta',3,54,'BananaChiquita','1','105.0','1.29','26.95','0.0','BreakFast','1983-10-21','1983-10-21','0.0','1.0','3.1','14.43','1.52','17.17','0.6','0.0'),('khosta',4,55,'Banana,brand: Yogurtland','1','25.0','0.0','6.0','0.0','BreakFast','2017-01-16','2017-01-16','0.0','0.0','1.0','3.0','0.0','4.0','0.0','0.0'),('khosta',4,56,'Banana,brand: Yogurtland','2','50.0','0.0','12.0','0.0','BreakFast','2017-01-16','2017-01-16','0.0','0.0','2.0','6.0','0.0','8.0','0.0','0.0'),('khosta',4,57,'Bananas, raw - 1 cup, sliced,brand: USDA','2','267.0','3.28','68.52','1.0','BreakFast','2017-01-16','2017-01-16','0.0','3.0','7.8','36.7','3.84','43.5','1.5','4.34'),('khosta',4,58,'Bananas, raw - 1 cup, sliced,brand: USDA','1','133.5','1.64','34.26','0.5','BreakFast','2017-01-16','2017-01-16','0.0','1.5','3.9','18.35','1.92','21.75','0.75','2.17'),('khosta',1,59,'Cherries, sweet, raw - 1 cup, without pits,brand: USDA','1','97.02','1.63','24.66','0.31','BreakFast','2017-01-17','2017-01-17','0.0','0.0','3.23','19.74','1.97','17.97','2.0','3.08'),('khosta',1,60,'Cherries, sweet, raw - 1 cup, without pits,brand: USDA','2','194.04','3.26','49.32','0.62','BreakFast','2017-01-17','2017-01-17','0.0','0.0','6.46','39.48','3.94','35.94','4.0','6.16'),('khosta',1,61,'Chicken Shawarma - 1 Serving,brand: Nutritionix','2','904.08','77.54','79.32','29.68','BreakFast','2017-01-17','2017-01-17','172.94','2029.52','5.38','5.84','54.0','28.0','26.0','42.0');
/*!40000 ALTER TABLE `patient_foodrecall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_visit`
--

DROP TABLE IF EXISTS `patient_visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_visit` (
  `patient_name` varchar(45) NOT NULL,
  `visit_number` int(11) DEFAULT NULL,
  `visit_note` text,
  `visit_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`visit_id`),
  KEY `patient_name_idx` (`patient_name`),
  CONSTRAINT `patient_name` FOREIGN KEY (`patient_name`) REFERENCES `patient` (`patient_name`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_visit`
--

LOCK TABLES `patient_visit` WRITE;
/*!40000 ALTER TABLE `patient_visit` DISABLE KEYS */;
INSERT INTO `patient_visit` VALUES ('khosta',2,'Saw client today \nSpoke about changes\nAgreed to changes\n\nSarah Hamdna RD',1),('khosta',1,'dslkjhflsaflajsd',2);
/*!40000 ALTER TABLE `patient_visit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registration` (
  `name` varchar(25) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `contact` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES ('ali','aaa','6138900596','ali_1976'),('khaled','khaled_jawaher@hotmail.com','6138900596','Khaled83'),('mohammed','kkk','6138900596','Mujtaba83'),('sara','shamd058@gmail.com','6138900596','Sousicsou1');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-20 15:44:43
