-- MySQL dump 10.13  Distrib 5.7.22, for Win64 (x86_64)
--
-- Host: localhost    Database: art
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `artist`
--

DROP TABLE IF EXISTS `artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artist` (
                          `user_id` int(11) NOT NULL,
                          `nation` varchar(32) DEFAULT NULL,
                          `birthday` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          `profession` varchar(32) DEFAULT NULL,
                          `info` text,
                          `review` int(11) NOT NULL DEFAULT '0',
                          `avatar` varchar(255) DEFAULT NULL,
                          `state` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`user_id`),
                          UNIQUE KEY `artist_user_id_uindex` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist`
--

LOCK TABLES `artist` WRITE;
/*!40000 ALTER TABLE `artist` DISABLE KEYS */;
INSERT INTO `artist` VALUES (2,'中国-重庆','2019-03-22 07:42:13','艺术家','我是简介啦啦啦。我是简介啦啦啦。我是简介啦啦啦。我是简介啦啦啦。我是简介啦啦啦。我是简介啦啦啦。我是简介啦啦啦。我是简介啦啦啦。我是简介啦啦啦。',1,'20.31258881750007483.jpg','创作中'),(3,'中国-重庆','2019-03-21 16:00:00','艺术家','简介。\r\n我是简介，我是简介，我是简介，我是简介，我是简介，我是简介，我是简介，我是简介，我是简介，我是简介，我是简介，我是简介。',1,'30.4240185826390984.jpg','创作中'),(4,'中国-广东','2019-03-22 07:48:40','艺术家','简介：\r\n我是简介，我是简介，我是简介，我是简介，我是简介，我是简介，我是简介，我是简介，我是简介，我是简介，我是简介，',1,'40.6681098279677605.jpg','创作中'),(5,'中国-广西','2019-03-22 07:40:56','艺术家','简介：\r\n我是简介。我是简介。我是简介。我是简介。我是简介。我是简介。我是简介。我是简介。我是简介。\r\n我是简介。我是简介。我是简介。我是简介。我是简介。我是简介。我是简介。',1,'50.6412380627251086.jpg','创作中'),(6,'中国-湖南','2019-03-22 07:41:14','艺术家','华南接：\n我是简介。我是简介。我是简介。我是简介。我是简介。我是简介。\n我是简介。我是简介。我是简介。我是简介。我是简介。我是简介。',1,'60.5801808443255136.jpg',NULL),(7,NULL,'2019-03-22 05:23:37',NULL,NULL,-1,NULL,NULL),(8,NULL,'2019-04-06 09:26:45',NULL,NULL,-1,NULL,NULL),(11,NULL,'2019-04-11 05:17:52',NULL,NULL,-1,NULL,NULL);
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artwork`
--

DROP TABLE IF EXISTS `artwork`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artwork` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `name` varchar(32) NOT NULL,
                           `artist` int(11) DEFAULT NULL,
                           `info` longtext,
                           `review` int(11) NOT NULL DEFAULT '0',
                           `score` int(11) NOT NULL DEFAULT '0',
                           `type` int(11) DEFAULT '0',
                           `time` datetime DEFAULT CURRENT_TIMESTAMP,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artwork`
--

LOCK TABLES `artwork` WRITE;
/*!40000 ALTER TABLE `artwork` DISABLE KEYS */;
INSERT INTO `artwork` VALUES (3,'桃花',2,'桃花。桃花。桃花。桃花。',1,6,1,'2019-03-21 21:00:55'),(5,'美美的',2,'简介简介简介简介简介。简介简介简介简介简介。简介简介简介简介简介。简介简介简介简介简介。简介简介简介简介简介。简介简介简介简介简介。简介简介简介简介简介。',1,3,5,'2019-03-21 21:08:19'),(6,'桃花慢慢',3,'你好',1,7,3,'2019-03-22 13:26:06'),(7,'话花',3,'你好',1,1,5,'2019-03-22 13:26:49'),(8,'大海',3,'你好',1,0,5,'2019-03-22 13:27:17'),(9,'星海',3,'你好',1,0,1,'2019-03-22 13:27:43'),(10,'而发',4,'你好',1,0,0,'2019-03-22 13:28:45'),(11,'春花易',5,'你好',1,0,0,'2019-03-22 13:30:00'),(12,'韩庚易',6,'你好',1,0,0,'2019-03-22 13:30:43'),(13,'1234',6,'123',1,0,3,'2019-03-22 13:33:19');
/*!40000 ALTER TABLE `artwork` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artwork_comment`
--

DROP TABLE IF EXISTS `artwork_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artwork_comment` (
                                   `id` int(11) NOT NULL AUTO_INCREMENT,
                                   `reply` int(11) DEFAULT NULL,
                                   `user_id` int(11) NOT NULL,
                                   `content` text,
                                   `timestamp` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                   `art_id` int(11) DEFAULT NULL,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artwork_comment`
--

LOCK TABLES `artwork_comment` WRITE;
/*!40000 ALTER TABLE `artwork_comment` DISABLE KEYS */;
INSERT INTO `artwork_comment` VALUES (1,0,3,'春天蕴含生机，桃花朵朵煞是美丽','2019-03-30 17:25:24',6),(2,0,2,'大自然中的生命果然很给力，有生机，有活力','2019-03-30 17:27:37',6);
/*!40000 ALTER TABLE `artwork_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artwork_media`
--

DROP TABLE IF EXISTS `artwork_media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artwork_media` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `artwork_id` int(11) DEFAULT NULL,
                                 `type` varchar(32) DEFAULT 'image',
                                 `url` varchar(255) DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artwork_media`
--

LOCK TABLES `artwork_media` WRITE;
/*!40000 ALTER TABLE `artwork_media` DISABLE KEYS */;
INSERT INTO `artwork_media` VALUES (1,3,'image','/upload/1.jpg'),(2,5,'image','/upload/2.jpg'),(3,6,'image','/upload/3.jpg'),(4,7,'image','/upload/4.jpg'),(5,8,'image','/upload/5.jpg'),(6,9,'image','/upload/6.jpg'),(7,10,'image','/upload/7.jpg'),(8,11,'image','/upload/8.jpg'),(9,12,'image','/upload/9.jpg'),(10,13,'image','/upload/10.jpg');
/*!40000 ALTER TABLE `artwork_media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `name` varchar(32) NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `type_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (5,'水彩'),(1,'油画'),(6,'漫画'),(3,'照片'),(4,'素描');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `name` varchar(32) NOT NULL,
                        `pwd` varchar(32) NOT NULL,
                        `auth` varchar(10) NOT NULL DEFAULT 'user',
                        `avatar` varchar(255) DEFAULT NULL,
                        `sex` int(11) DEFAULT '0',
                        `isArtist` tinyint(1) NOT NULL DEFAULT '0',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `user_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','4297f44b13955235245b2497399d7a93','admin',NULL,0,1),(2,'春花','e10adc3949ba59abbe56e057f20f883e','user',NULL,1,1),(3,'艺术家','4297f44b13955235245b2497399d7a93','user',NULL,0,1),(4,'艺术家二号','4297f44b13955235245b2497399d7a93','user',NULL,0,1),(5,'艺术家三号','4297f44b13955235245b2497399d7a93','user',NULL,0,1),(6,'艺术家四号','4297f44b13955235245b2497399d7a93','user',NULL,0,1),(7,'游客','4297f44b13955235245b2497399d7a93','user',NULL,0,0),(8,'依林','4297f44b13955235245b2497399d7a93','user',NULL,0,0),(11,'依','4297f44b13955235245b2497399d7a93','user',NULL,0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-27 16:24:26

