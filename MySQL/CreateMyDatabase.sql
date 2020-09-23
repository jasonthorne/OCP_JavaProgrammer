CREATE DATABASE  IF NOT EXISTS `mydatabase` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mydatabase`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydatabase
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.30-MariaDB

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
-- Table structure for table `custireland`
--

DROP TABLE IF EXISTS `custireland`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `custireland` (
  `cust_id` char(10) NOT NULL,
  `cust_name` char(50) NOT NULL,
  `cust_address` char(50) DEFAULT NULL,
  `cust_city` char(50) DEFAULT NULL,
  `cust_state` char(5) DEFAULT NULL,
  `cust_zip` char(10) DEFAULT NULL,
  `cust_country` char(50) DEFAULT NULL,
  `cust_contact` char(50) DEFAULT NULL,
  `cust_email` char(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `custireland`
--

LOCK TABLES `custireland` WRITE;
/*!40000 ALTER TABLE `custireland` DISABLE KEYS */;
INSERT INTO `custireland` VALUES ('1000000012','Mighty Toys','muckross alley','Roscommon','rn','898000','Ireland',NULL,NULL),('100000009','ToyMaster','12 Acacia drive','Offaly','oy','777777','Ireland',NULL,NULL),('100000010','greatToys','muckross alley','Roscommon','rn','898000','ireland',NULL,NULL);
/*!40000 ALTER TABLE `custireland` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `custmessing`
--

DROP TABLE IF EXISTS `custmessing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `custmessing` (
  `cust_id` char(10) NOT NULL,
  `cust_name` char(50) NOT NULL,
  `cust_address` char(50) DEFAULT NULL,
  `cust_city` char(50) DEFAULT NULL,
  `cust_state` char(5) DEFAULT NULL,
  `cust_country` char(50) DEFAULT NULL,
  `cust_contact` char(50) DEFAULT NULL,
  `cust_email` char(255) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `custmessing`
--

LOCK TABLES `custmessing` WRITE;
/*!40000 ALTER TABLE `custmessing` DISABLE KEYS */;
INSERT INTO `custmessing` VALUES ('1000000001','Village Toys','200 Maple Lane','Detroit','MI','USA','John Smith','sales@villagetoys.com'),('1000000002','Kids Place','333 South Lake Drive','Columbus','OH','USA','Michelle Green',NULL),('1000000003','Fun4All','1 Sunny Place','Muncie','IN','USA','Jim Jones','jjones@fun4all.com'),('1000000004','Fun4All','829 Riverside Drive','Phoenix','AZ','USA','Denise L. Stephens','dstephens@fun4all.com'),('1000000005','The Toy Store','4545 53rd Street','Chicago','IL','USA','Kim Howard','kim@thetoystore.com'),('1000000007','Smyths','Headford Road','Galway','Galwa','irl','Kathleen Lally','Kathleen@smyths.ie'),('1000000008','Hanly\'s','2 chelsea lane','London','Londo','Uk','Bridget Cosgrove','Bridget@Hanlys.co.uk'),('1000000012','Mighty Toys','muckross alley','Roscommon','rn','Ireland',NULL,NULL),('100000009','ToyMaster','12 Acacia drive','Offaly','oy','Ireland',NULL,NULL),('100000010','greatToys','muckross alley','Roscommon','rn','ireland',NULL,NULL);
/*!40000 ALTER TABLE `custmessing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `customeremaillist`
--

DROP TABLE IF EXISTS `customeremaillist`;
/*!50001 DROP VIEW IF EXISTS `customeremaillist`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `customeremaillist` AS SELECT 
 1 AS `cust_id`,
 1 AS `cust_name`,
 1 AS `cust_email`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `cust_id` char(10) NOT NULL,
  `cust_name` char(50) NOT NULL,
  `cust_address` char(50) DEFAULT NULL,
  `cust_city` char(50) DEFAULT NULL,
  `cust_state` char(5) DEFAULT NULL,
  `cust_zip` char(10) DEFAULT NULL,
  `cust_country` char(50) DEFAULT NULL,
  `cust_contact` char(50) DEFAULT NULL,
  `cust_email` char(255) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES ('1000000001','Village Toys','200 Maple Lane','Detroit','MI','44444','USA','John Smith','sales@villagetoys.com'),('1000000002','Kids Place','333 South Lake Drive','Columbus','OH','43333','USA','Michelle Green',NULL),('1000000003','Fun4All','1 Sunny Place','Muncie','IN','42222','USA','Jim Jones','jjones@fun4all.com'),('1000000004','Fun4All','829 Riverside Drive','Phoenix','AZ','88888','USA','Denise L. Stephens','dstephens@fun4all.com'),('1000000005','The Toy Store','4545 53rd Street','Chicago','IL','54545','USA','Kim Howard',NULL),('1000000006','Toys r us','789 Fianna Lane','Loughrea','Galwa','ie234','Irl','Tony Costello','tony@toysrus.ie'),('1000000007','Smyths','Headford Road','Galway','Galwa','ie567','irl','Kathleen Lally','Kathleen@smyths.ie'),('1000000008','Hanly\'s','2 chelsea lane','London','Londo','uk7865','Uk','Bridget Cosgrove','Bridget@Hanlys.co.uk'),('1000000012','Mighty Toys','muckross alley','Roscommon','rn','898000','Ireland',NULL,NULL),('100000009','ToyMaster','12 Acacia drive','Offaly','oy','777777','Ireland',NULL,NULL),('100000010','greatToys','muckross alley','Roscommon','rn','898000','ireland',NULL,NULL);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitems`
--

DROP TABLE IF EXISTS `orderitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderitems` (
  `order_num` int(11) NOT NULL,
  `order_item` int(11) NOT NULL,
  `prod_id` char(10) NOT NULL,
  `quantity` int(11) NOT NULL,
  `item_price` decimal(8,2) NOT NULL,
  PRIMARY KEY (`order_num`,`order_item`),
  KEY `FK_OrderItems_Products` (`prod_id`),
  CONSTRAINT `FK_OrderItems_Orders` FOREIGN KEY (`order_num`) REFERENCES `orders` (`order_num`),
  CONSTRAINT `FK_OrderItems_Products` FOREIGN KEY (`prod_id`) REFERENCES `products` (`prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitems`
--

LOCK TABLES `orderitems` WRITE;
/*!40000 ALTER TABLE `orderitems` DISABLE KEYS */;
INSERT INTO `orderitems` VALUES (20005,1,'BR01',100,5.49),(20005,2,'BR03',100,10.99),(20006,1,'BR01',20,5.99),(20006,2,'BR02',10,8.99),(20006,3,'BR03',10,11.99),(20007,1,'BR03',50,11.49),(20007,2,'BNBG01',100,2.99),(20007,3,'BNBG02',100,2.99),(20007,4,'BNBG03',100,2.99),(20007,5,'RGAN01',50,4.49),(20008,1,'RGAN01',5,4.99),(20008,2,'BR03',5,11.99),(20008,3,'BNBG01',10,3.49),(20008,4,'BNBG02',10,3.49),(20008,5,'BNBG03',10,3.49),(20009,1,'BNBG01',250,2.49),(20009,2,'BNBG02',250,2.49),(20009,3,'BNBG03',250,2.49);
/*!40000 ALTER TABLE `orderitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitems2`
--

DROP TABLE IF EXISTS `orderitems2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderitems2` (
  `order_num` int(11) NOT NULL,
  `order_item` int(11) NOT NULL,
  `prod_id` char(10) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '1',
  `item_price` decimal(8,2) NOT NULL,
  `dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_id` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_just` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitems2`
--

LOCK TABLES `orderitems2` WRITE;
/*!40000 ALTER TABLE `orderitems2` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderitems2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `orderitemsexpanded`
--

DROP TABLE IF EXISTS `orderitemsexpanded`;
/*!50001 DROP VIEW IF EXISTS `orderitemsexpanded`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `orderitemsexpanded` AS SELECT 
 1 AS `order_num`,
 1 AS `prod_id`,
 1 AS `quantity`,
 1 AS `item_price`,
 1 AS `total_price`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `order_num` int(11) NOT NULL,
  `order_date` datetime NOT NULL,
  `cust_id` char(10) NOT NULL,
  PRIMARY KEY (`order_num`),
  KEY `FK_Orders_Customers` (`cust_id`),
  CONSTRAINT `FK_Orders_Customers` FOREIGN KEY (`cust_id`) REFERENCES `customers` (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (20005,'2012-05-01 00:00:00','1000000001'),(20006,'2012-01-12 00:00:00','1000000003'),(20007,'2012-01-30 00:00:00','1000000004'),(20008,'2012-02-03 00:00:00','1000000005'),(20009,'2012-02-08 00:00:00','1000000001');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders2`
--

DROP TABLE IF EXISTS `orders2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders2` (
  `order_num` int(11) NOT NULL,
  `order_date` datetime NOT NULL,
  `cust_id` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders2`
--

LOCK TABLES `orders2` WRITE;
/*!40000 ALTER TABLE `orders2` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `productcustomers`
--

DROP TABLE IF EXISTS `productcustomers`;
/*!50001 DROP VIEW IF EXISTS `productcustomers`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `productcustomers` AS SELECT 
 1 AS `cust_name`,
 1 AS `cust_contact`,
 1 AS `prod_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `prod_id` char(10) NOT NULL,
  `vend_id` char(10) NOT NULL,
  `prod_name` char(255) NOT NULL,
  `prod_price` decimal(8,2) NOT NULL,
  `prod_desc` text,
  PRIMARY KEY (`prod_id`),
  KEY `FK_Products_Vendors` (`vend_id`),
  CONSTRAINT `FK_Products_Vendors` FOREIGN KEY (`vend_id`) REFERENCES `vendors` (`vend_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('BNBG01','DLL01','Fish bean bag toy',3.49,'Fish bean bag toy, complete with bean bag worms with which to feed it'),('BNBG02','DLL01','Bird bean bag toy',3.49,'Bird bean bag toy, eggs are not included'),('BNBG03','DLL01','Rabbit bean bag toy',3.49,'Rabbit bean bag toy, comes with bean bag carrots'),('BR01','BRS01','8 inch teddy bear',5.99,'8 inch teddy bear, comes with cap and jacket'),('BR02','BRS01','12 inch teddy bear',8.99,'12 inch teddy bear, comes with cap and jacket'),('BR03','BRS01','18 inch teddy bear',11.99,'18 inch teddy bear, comes with cap and jacket'),('RGAN01','DLL01','Raggedy Ann',4.99,'18 inch Raggedy Ann doll'),('RYL01','FNG01','King doll',100.00,'12 inch king doll with royal garments and crown'),('RYL02','FNG01','Queen doll',9.49,'12 inch queen doll with royal garments and crown'),('yyu90','FNG01','King doll',100.00,'great doll');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registration` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `wage` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES (1,'mary','50000',45),(2,'John','25000',23);
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shorcust`
--

DROP TABLE IF EXISTS `shorcust`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shorcust` (
  `cust_name` char(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shorcust`
--

LOCK TABLES `shorcust` WRITE;
/*!40000 ALTER TABLE `shorcust` DISABLE KEYS */;
INSERT INTO `shorcust` VALUES ('Mighty Toys'),('ToyMaster');
/*!40000 ALTER TABLE `shorcust` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t1`
--

DROP TABLE IF EXISTS `t1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` char(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t1`
--

LOCK TABLES `t1` WRITE;
/*!40000 ALTER TABLE `t1` DISABLE KEYS */;
INSERT INTO `t1` VALUES (1,'sun'),(197,'venus'),(199,'uranus'),(201,'pluto'),(202,'mars'),(203,'westeros'),(204,'hurdy'),(205,'gurdy');
/*!40000 ALTER TABLE `t1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `veiwview`
--

DROP TABLE IF EXISTS `veiwview`;
/*!50001 DROP VIEW IF EXISTS `veiwview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `veiwview` AS SELECT 
 1 AS `vend_title`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vendorlocations`
--

DROP TABLE IF EXISTS `vendorlocations`;
/*!50001 DROP VIEW IF EXISTS `vendorlocations`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vendorlocations` AS SELECT 
 1 AS `vend_title`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `vendors`
--

DROP TABLE IF EXISTS `vendors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendors` (
  `vend_id` char(10) NOT NULL,
  `vend_name` char(50) NOT NULL,
  `vend_address` char(50) DEFAULT NULL,
  `vend_city` char(50) DEFAULT NULL,
  `vend_state` char(5) DEFAULT NULL,
  `vend_zip` char(10) DEFAULT NULL,
  `vend_country` char(50) DEFAULT NULL,
  PRIMARY KEY (`vend_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendors`
--

LOCK TABLES `vendors` WRITE;
/*!40000 ALTER TABLE `vendors` DISABLE KEYS */;
INSERT INTO `vendors` VALUES ('BRE02','           Bear Emporium','500 Park Street','Anytown','OH','44333','USA'),('BRS01','Bears R Us','123 Main Street','Bear Town','MI','44444','USA'),('DLL01','Doll House Inc.','555 High Street','Dollsville','CA','99999','USA'),('FNG01','Fun and Games','42 Galaxy Road','London',NULL,'N16 6PS','England'),('FRB01','Furball Inc.','1000 5th Avenue','New York','NY','11111','USA'),('JTS01','Jouets et ours','1 Rue Amusement','Paris',NULL,'45678','France');
/*!40000 ALTER TABLE `vendors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendors2`
--

DROP TABLE IF EXISTS `vendors2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendors2` (
  `vend_id` char(10) NOT NULL,
  `vend_name` char(50) NOT NULL,
  `vend_address` char(50) DEFAULT NULL,
  `vend_city` char(50) DEFAULT NULL,
  `vend_state` char(5) DEFAULT NULL,
  `vend_zip` char(10) DEFAULT NULL,
  `vend_country` char(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendors2`
--

LOCK TABLES `vendors2` WRITE;
/*!40000 ALTER TABLE `vendors2` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendors2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mydatabase'
--

--
-- Dumping routines for database 'mydatabase'
--
/*!50003 DROP FUNCTION IF EXISTS `circle_area` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `circle_area`(radius float) RETURNS float
return pi()*radius*radius ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `allChange` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `allChange`(in name1 CHAR(255),in name2 char(255),
out place1 char(255),out place2 char(255),
inout inoutVar char (255))
BEGIN
 #you can select the initial value of a inout variable
 select inoutVar;
 select name1 as insideName;#print out mary
 #cannot select the initial value of a out variable
 select place1 as insideOutPlace;
 set name1='pat';
 set name2='harry';
 set place1='new york';
 set place2='chicago';
 select name1,name2,place1,place2;

 END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `calculate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calculate`(in num1 int,in num2 int)
BEGIN
# declare sum int;
select num1+num2 as added;
select num1*num2 as product;
 END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `caseCountryTax` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `caseCountryTax`(in p_cust_id int)
begin
declare customerCountry char(50);
declare taxRate double(6,2);

select cust_country into customerCountry
from customers
where cust_id=p_cust_id;

case customerCountry
	when 'usa' then
		set taxRate=12;
	when ('irl' or 'ireland') then
		set taxRate=25;
#	when 'ireland' then
#		set taxRate=25;
	when 'uk' then
		set taxRate=8;
	else
		set taxRate=0;
end case;
select customerCountry,taxRate;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `caseCountryTax2` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `caseCountryTax2`(in p_cust_id int)
begin
declare customerCountry char(50);
declare taxRate double(6,2);

SELECT 
    cust_country
INTO customerCountry FROM
    customers
WHERE
    cust_id = p_cust_id;

CASE
    WHEN customerCountry='usa'
    THEN 
		set taxRate=12;
    WHEN (customerCountry='irl'
		or customerCountry='ireland') 
    THEN 
		set taxRate=25;
	when customerCountry='uk' 
    then
		set taxRate=8;
    ELSE 
		set taxRate=0;
END CASE;
SELECT taxRate, customerCountry;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetCustomerShipping` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetCustomerShipping`(
 in  p_cust_id int(11))
BEGIN
    DECLARE customerCountry varchar(50);
    declare p_shiping varchar(50);
  #  declare p_shiping varchar(50);
 
    SELECT cust_country INTO customerCountry
 FROM customers
 WHERE cust_id = p_cust_id;
 #set customerCountry:='irl';
CASE customerCountry
 WHEN  'USA' THEN
    SET p_shiping = '2-day Shipping';
 WHEN 'irl' or 'ireland' THEN
    SET p_shiping = '3-day Shipping';
when 'uk' then
	set p_shiping = '4 day Shipping'; 
 ELSE
    SET p_shiping = '5-day Shipping';
 END CASE;
 select p_shiping;
 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `intoProc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `intoProc`()
BEGIN
 declare count_cust int;
 #this will not display until you select count_cust
 select count(*)into count_cust
 from customers;
 select count_cust;
 END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pricequantity` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pricequantity`(in amount int(6),in cost decimal(10,2))
begin
select * 
from orderitems
where quantity>=amount
and item_price>=cost;
 END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `procVariables` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `procVariables`()
begin
#use the keyword declare when creating a variable
DECLARE total_sale INT DEFAULT 0;
DECLARE x,y int;
#seission variable is available during the seission
set @seissionNum:=45;
#set when assigning a value
set total_sale=456;
#can declare more than one variable at a time
#declare num,num2 int;
#select @country;
select total_sale;

 END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `selectAllCust` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectAllCust`()
begin
select *
FROM customers; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `selectif3` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectif3`(in age int)
begin
#declare age int;
#declare message char(100);
#declare price double(6,2);
declare message char(150);
#set age:=19;
if age<=18 then
	set message:='you are under 18';
ELSEIF age<=25 then 
	SET message:= 'you are over 18 and under 25';
else
	set message:='you are over 25';
END IF;
SELECT message;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `select_country_customer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `select_country_customer`(IN country CHAR(255))
BEGIN
select cust_name,cust_contact 
from customers
where cust_country=country;
 END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `simpleif` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `simpleif`()
begin
declare age int;
#declare message char(100);
declare price double(6,2);
set age:=19;
if age<=18 then
	set price:=5;
ELSE
      SET price:= 10;
END IF;
select price;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `simpleif2` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `simpleif2`(in age int)
begin
#declare age int;
#declare message char(100);
declare price double(6,2);
#set age:=19;
if age<=18 then
	set price:=5;
ELSE
	SET price:= 10;
END IF;
SELECT price;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `customeremaillist`
--

/*!50001 DROP VIEW IF EXISTS `customeremaillist`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `customeremaillist` AS select `customers`.`cust_id` AS `cust_id`,`customers`.`cust_name` AS `cust_name`,`customers`.`cust_email` AS `cust_email` from `customers` where (`customers`.`cust_email` is not null) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `orderitemsexpanded`
--

/*!50001 DROP VIEW IF EXISTS `orderitemsexpanded`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `orderitemsexpanded` AS select `orderitems`.`order_num` AS `order_num`,`orderitems`.`prod_id` AS `prod_id`,`orderitems`.`quantity` AS `quantity`,`orderitems`.`item_price` AS `item_price`,(`orderitems`.`quantity` * `orderitems`.`item_price`) AS `total_price` from `orderitems` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `productcustomers`
--

/*!50001 DROP VIEW IF EXISTS `productcustomers`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `productcustomers` AS select `customers`.`cust_name` AS `cust_name`,`customers`.`cust_contact` AS `cust_contact`,`orderitems`.`prod_id` AS `prod_id` from ((`customers` join `orders`) join `orderitems`) where ((`customers`.`cust_id` = `orders`.`cust_id`) and (`orderitems`.`order_num` = `orders`.`order_num`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `veiwview`
--

/*!50001 DROP VIEW IF EXISTS `veiwview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `veiwview` AS select `vendorlocations`.`vend_title` AS `vend_title` from `vendorlocations` where (`vendorlocations`.`vend_title` like 'bear%') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vendorlocations`
--

/*!50001 DROP VIEW IF EXISTS `vendorlocations`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vendorlocations` AS select rtrim(concat(`vendors`.`vend_name`,'(',`vendors`.`vend_country`,')')) AS `vend_title` from `vendors` order by `vendors`.`vend_name` */;
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

-- Dump completed on 2018-08-09 19:36:35
