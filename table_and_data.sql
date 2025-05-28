-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: scm
-- ------------------------------------------------------
-- Server version	9.1.0

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Điện thoại'),(2,'Laptop'),(3,'Tai nghe');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_schedule`
--

DROP TABLE IF EXISTS `delivery_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_schedule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `shipment_id` int NOT NULL,
  `date` date DEFAULT NULL,
  `address` varchar(100) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `status` varchar(100) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `shipment_id` (`shipment_id`),
  CONSTRAINT `delivery_schedule_ibfk_1` FOREIGN KEY (`shipment_id`) REFERENCES `shipment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_schedule`
--

LOCK TABLES `delivery_schedule` WRITE;
/*!40000 ALTER TABLE `delivery_schedule` DISABLE KEYS */;
INSERT INTO `delivery_schedule` VALUES (1,1,'2025-05-29','77 Bau Cat','Chưa tới',''),(2,1,'2025-05-30','321 Dong Nai','Chưa tới',''),(3,2,'2025-05-31','368 Thanh Thai','Chưa tới',''),(4,2,'2025-06-01','98 To Ky','Chưa tới','');
/*!40000 ALTER TABLE `delivery_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_receipt_export`
--

DROP TABLE IF EXISTS `detail_receipt_export`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_receipt_export` (
  `id` int NOT NULL AUTO_INCREMENT,
  `receipt_export_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `amount` int NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `receipt_export_id` (`receipt_export_id`),
  CONSTRAINT `detail_receipt_export_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `detail_receipt_export_ibfk_2` FOREIGN KEY (`receipt_export_id`) REFERENCES `receipt_export` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_receipt_export`
--

LOCK TABLES `detail_receipt_export` WRITE;
/*!40000 ALTER TABLE `detail_receipt_export` DISABLE KEYS */;
INSERT INTO `detail_receipt_export` VALUES (70,50,3,2,2500),(71,51,4,1,2500);
/*!40000 ALTER TABLE `detail_receipt_export` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_receipt_import`
--

DROP TABLE IF EXISTS `detail_receipt_import`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_receipt_import` (
  `id` int NOT NULL AUTO_INCREMENT,
  `receipt_import_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `amount` int NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `receipt_import_id` (`receipt_import_id`),
  CONSTRAINT `detail_receipt_import_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `detail_receipt_import_ibfk_2` FOREIGN KEY (`receipt_import_id`) REFERENCES `receipt_import` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_receipt_import`
--

LOCK TABLES `detail_receipt_import` WRITE;
/*!40000 ALTER TABLE `detail_receipt_import` DISABLE KEYS */;
INSERT INTO `detail_receipt_import` VALUES (1,1,1,20,1800),(2,2,4,30,2000),(3,3,3,30,1800),(4,4,2,20,1800);
/*!40000 ALTER TABLE `detail_receipt_import` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `warehouse_id` int NOT NULL,
  `amount` int DEFAULT NULL,
  `min` int DEFAULT '100',
  `use_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_id` (`product_id`,`warehouse_id`),
  KEY `warehouse_id` (`warehouse_id`),
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `inventory_ibfk_2` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`id`),
  CONSTRAINT `inventory_chk_1` CHECK ((`amount` >= 0)),
  CONSTRAINT `inventory_chk_2` CHECK ((`min` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (1,1,1,29,NULL,NULL,'2025-05-27'),(2,4,1,7,NULL,NULL,'2025-05-27'),(3,3,1,2,NULL,NULL,'2025-05-27'),(4,2,1,11,NULL,NULL,'2025-05-27');
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_export`
--

DROP TABLE IF EXISTS `invoice_export`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_export` (
  `id` int NOT NULL AUTO_INCREMENT,
  `receipt_export_id` int DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `status` varchar(100) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `order_code` int DEFAULT NULL,
  `total` int DEFAULT NULL,
  `payment_method` varchar(100) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `receipt_export_id` (`receipt_export_id`),
  CONSTRAINT `invoice_export_ibfk_1` FOREIGN KEY (`receipt_export_id`) REFERENCES `receipt_export` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_export`
--

LOCK TABLES `invoice_export` WRITE;
/*!40000 ALTER TABLE `invoice_export` DISABLE KEYS */;
INSERT INTO `invoice_export` VALUES (49,50,'2025-05-28','success',85976648,5000,'Tiền mặt','Mua hang',NULL),(50,51,'2025-05-28','success',18815690,2500,'Tiền mặt','Mua hang',NULL);
/*!40000 ALTER TABLE `invoice_export` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_inventory`
--

DROP TABLE IF EXISTS `log_inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_inventory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `receipt_import_id` int DEFAULT NULL,
  `receipt_export_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `receipt_import_id` (`receipt_import_id`),
  KEY `receipt_export_id` (`receipt_export_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `log_inventory_ibfk_1` FOREIGN KEY (`receipt_import_id`) REFERENCES `receipt_import` (`id`),
  CONSTRAINT `log_inventory_ibfk_2` FOREIGN KEY (`receipt_export_id`) REFERENCES `receipt_export` (`id`),
  CONSTRAINT `log_inventory_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_inventory`
--

LOCK TABLES `log_inventory` WRITE;
/*!40000 ALTER TABLE `log_inventory` DISABLE KEYS */;
INSERT INTO `log_inventory` VALUES (75,NULL,50,3,2,2500,'2025-05-28'),(76,NULL,51,4,1,2500,'2025-05-28');
/*!40000 ALTER TABLE `log_inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `price` int NOT NULL DEFAULT '0',
  `is_active` tinyint(1) DEFAULT '1',
  `image` varchar(255) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `category_id` int NOT NULL,
  `supplier_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Macbook Air M1 Pro',2000,NULL,'https://res.cloudinary.com/demfjaknk/image/upload/v1748318326/nigbrwabhxagziucjxr6.png','',2,1),(2,'Samsung Galaxy S23 Ultra',2000,NULL,'https://res.cloudinary.com/demfjaknk/image/upload/v1748318346/jg08v17nu6rnispjildk.png','',1,4),(3,'Laptop Asus TUF-Gaming',2500,NULL,'https://res.cloudinary.com/demfjaknk/image/upload/v1748318366/hrxqbze5i488cdlucwe6.png','',2,3),(4,'Sony R2 Accent',2500,NULL,'https://res.cloudinary.com/demfjaknk/image/upload/v1748318441/lcyeptsmwvhienn1cqgt.png','',3,2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt_export`
--

DROP TABLE IF EXISTS `receipt_export`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receipt_export` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_date` date DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `creator_id` int DEFAULT NULL,
  `status` varchar(50) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `warehouse_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `warehouse_id` (`warehouse_id`),
  KEY `customer_id` (`customer_id`),
  KEY `creator_id` (`creator_id`),
  CONSTRAINT `receipt_export_ibfk_1` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`id`),
  CONSTRAINT `receipt_export_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `user` (`id`),
  CONSTRAINT `receipt_export_ibfk_3` FOREIGN KEY (`creator_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt_export`
--

LOCK TABLES `receipt_export` WRITE;
/*!40000 ALTER TABLE `receipt_export` DISABLE KEYS */;
INSERT INTO `receipt_export` VALUES (50,'2025-05-28',1,NULL,'ordered','BBBBBB',1),(51,'2025-05-28',1,NULL,'cancelled','BBBBBB',1);
/*!40000 ALTER TABLE `receipt_export` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt_import`
--

DROP TABLE IF EXISTS `receipt_import`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receipt_import` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_date` date DEFAULT NULL,
  `supplier_id` int DEFAULT NULL,
  `creator_id` int DEFAULT NULL,
  `status` varchar(50) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `warehouse_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `warehouse_id` (`warehouse_id`),
  KEY `supplier_id` (`supplier_id`),
  KEY `creator_id` (`creator_id`),
  CONSTRAINT `receipt_import_ibfk_1` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`id`),
  CONSTRAINT `receipt_import_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
  CONSTRAINT `receipt_import_ibfk_3` FOREIGN KEY (`creator_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt_import`
--

LOCK TABLES `receipt_import` WRITE;
/*!40000 ALTER TABLE `receipt_import` DISABLE KEYS */;
INSERT INTO `receipt_import` VALUES (1,'2025-05-27',1,1,'Đã xác nhận','',1),(2,'2025-05-27',2,1,'Đã xác nhận','',1),(3,'2025-05-27',3,1,'Đã xác nhận','',1),(4,'2025-05-27',4,1,'Đã xác nhận','',1);
/*!40000 ALTER TABLE `receipt_import` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_shipment_company`
--

DROP TABLE IF EXISTS `review_shipment_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_shipment_company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `shipment_id` int DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `performance` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `shipment_id` (`shipment_id`),
  CONSTRAINT `review_shipment_company_ibfk_1` FOREIGN KEY (`shipment_id`) REFERENCES `shipment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_shipment_company`
--

LOCK TABLES `review_shipment_company` WRITE;
/*!40000 ALTER TABLE `review_shipment_company` DISABLE KEYS */;
/*!40000 ALTER TABLE `review_shipment_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_supplier`
--

DROP TABLE IF EXISTS `review_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `receipt_import_id` int DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `price` int DEFAULT NULL,
  `quality` int DEFAULT NULL,
  `support` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `receipt_import_id` (`receipt_import_id`),
  CONSTRAINT `review_supplier_ibfk_1` FOREIGN KEY (`receipt_import_id`) REFERENCES `receipt_import` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_supplier`
--

LOCK TABLES `review_supplier` WRITE;
/*!40000 ALTER TABLE `review_supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `review_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment`
--

DROP TABLE IF EXISTS `shipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `receipt_export_id` int DEFAULT NULL,
  `shipment_company_id` int DEFAULT NULL,
  `status` varchar(100) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `shipment_company_id` (`shipment_company_id`),
  KEY `receipt_export_id` (`receipt_export_id`),
  CONSTRAINT `shipment_ibfk_1` FOREIGN KEY (`receipt_export_id`) REFERENCES `receipt_export` (`id`),
  CONSTRAINT `shipment_ibfk_2` FOREIGN KEY (`shipment_company_id`) REFERENCES `shipment_company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment`
--

LOCK TABLES `shipment` WRITE;
/*!40000 ALTER TABLE `shipment` DISABLE KEYS */;
INSERT INTO `shipment` VALUES (1,50,1,'Chưa tới',''),(2,51,2,'Chưa tới','');
/*!40000 ALTER TABLE `shipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_company`
--

DROP TABLE IF EXISTS `shipment_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment_company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `name` varchar(100) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `phone` varchar(100) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `address` varchar(100) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_company`
--

LOCK TABLES `shipment_company` WRITE;
/*!40000 ALTER TABLE `shipment_company` DISABLE KEYS */;
INSERT INTO `shipment_company` VALUES (1,'vnexpress@gmail.com','VnExpress','369852147','339 To Hien Thanh'),(2,'vietelpost@gmail.com','Vietel Post','0123456789','56 Truong Chinh');
/*!40000 ALTER TABLE `shipment_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_company_contact`
--

DROP TABLE IF EXISTS `shipment_company_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment_company_contact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `shipment_company_id` int DEFAULT NULL,
  `content` varchar(255) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `note` varchar(255) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `shipment_company_id` (`shipment_company_id`),
  CONSTRAINT `shipment_company_contact_ibfk_1` FOREIGN KEY (`shipment_company_id`) REFERENCES `shipment_company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_company_contact`
--

LOCK TABLES `shipment_company_contact` WRITE;
/*!40000 ALTER TABLE `shipment_company_contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_company_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `name` varchar(100) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `phone` varchar(100) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `address` varchar(100) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'apple@gmail.com','Apple','000000000','224 Bau Cat'),(2,'sony@gmail.com','Sony','111111111','339 To Hien Thanh'),(3,'cellphones@gmail.com','CellphoneS','333333333','251 Truong Chinh, Q.Tan Binh, TP.HCM'),(4,'samsung@gmail.com','SamSung','666666666','99 Bau Cat');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `user_role` varchar(100) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `create_date` date DEFAULT NULL,
  `email` varchar(100) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `name` varchar(100) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `phone` varchar(100) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `address` varchar(100) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'tai','$2a$10$YLyVlhbO/0u9YmTViqPy1./NosW/0CEnFSVX/dFLDmpSK7Fa7LvOu','ROLE_USER','2025-05-27','ntai3962@gmail.com','Nguyễn Tấn Tài','0789721763',NULL,'https://res.cloudinary.com/demfjaknk/image/upload/v1748318031/fgufc6njajgylr8xomel.png'),(2,'ttt','$2a$10$JwJmm8zcoturvTlPod5nQe5BsAbRT7zmoQwFK4X5iBRjXpNIgufn2','ROLE_USER','2025-05-28','taitinhte@gmail.com','Tai tinh te','0321456987',NULL,'https://res.cloudinary.com/demfjaknk/image/upload/v1748366392/s4otnsq0c6d9ymhpsxy0.png');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warehouse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `address` varchar(100) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse`
--

LOCK TABLES `warehouse` WRITE;
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
INSERT INTO `warehouse` VALUES (1,'Kho Long Bình','321 Dong Nai');
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-28 19:49:11
