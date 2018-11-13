/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.30 : Database - crm_itek
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crm_itek` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `crm_itek`;

/*Table structure for table `t_cus_dev_plan` */

DROP TABLE IF EXISTS `t_cus_dev_plan`;

CREATE TABLE `t_cus_dev_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saleChanceId` int(11) DEFAULT NULL,
  `planItem` varchar(100) DEFAULT NULL,
  `planDate` date DEFAULT NULL,
  `exeAffect` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `t_cus_dev_plan` */

LOCK TABLES `t_cus_dev_plan` WRITE;

insert  into `t_cus_dev_plan`(`id`,`saleChanceId`,`planItem`,`planDate`,`exeAffect`) values (17,1,'做软件开发','2016-09-29','很好'),(18,1,'	 做软件开发','2017-09-02','一般'),(20,2,'合肥宏晶OA系统的开发','2016-09-19','左鹏带着，效果做的很好');

UNLOCK TABLES;

/*Table structure for table `t_customer` */

DROP TABLE IF EXISTS `t_customer`;

CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `khno` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `area` varchar(20) DEFAULT NULL,
  `cusManager` varchar(20) DEFAULT NULL,
  `level` varchar(30) DEFAULT NULL,
  `myd` varchar(30) DEFAULT NULL,
  `xyd` varchar(30) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `postCode` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `webSite` varchar(20) DEFAULT NULL,
  `yyzzzch` varchar(50) DEFAULT NULL,
  `fr` varchar(20) DEFAULT NULL,
  `zczj` varchar(20) DEFAULT NULL,
  `nyye` varchar(20) DEFAULT NULL,
  `khyh` varchar(50) DEFAULT NULL,
  `khzh` varchar(50) DEFAULT NULL,
  `dsdjh` varchar(50) DEFAULT NULL,
  `gsdjh` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer` */

LOCK TABLES `t_customer` WRITE;

insert  into `t_customer`(`id`,`khno`,`name`,`area`,`cusManager`,`level`,`myd`,`xyd`,`address`,`postCode`,`phone`,`fax`,`webSite`,`yyzzzch`,`fr`,`zczj`,`nyye`,`khyh`,`khzh`,`dsdjh`,`gsdjh`,`state`) values (21,'KH20160905050721','客户名称','南京','周林','一般客户','☆☆☆☆','☆☆☆','客户地址','1245787','110','5615348','www.baidu.com','123456','法人','100','200','中国农业银行','6228212290065474910','987654','987654321',0),(22,'KH20160909034618','宏晶','北京','周林','优秀客户','☆☆','☆☆','合肥','222222','18956873456','0551-345234','www.baidu.com','','姚','','22','范德萨发的','6228212290065474910','','',0),(23,'KH20160910013745','焦元涛','广州','周林','希望客户','☆','☆☆☆☆','客户地址Test','237200','123456','654321','www.2345.com','','张三','2222','22222','华夏','123445555','11111','11111',0);

UNLOCK TABLES;

/*Table structure for table `t_customer_contact` */

DROP TABLE IF EXISTS `t_customer_contact`;

CREATE TABLE `t_customer_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cusId` int(11) DEFAULT NULL,
  `contactTime` date DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `overview` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer_contact` */

LOCK TABLES `t_customer_contact` WRITE;

insert  into `t_customer_contact`(`id`,`cusId`,`contactTime`,`address`,`overview`) values (1,21,'2016-09-16','合肥宏晶信息','java学习'),(2,21,'2016-09-22','天源迪科信息技术有限公司','电信行业软件开发');

UNLOCK TABLES;

/*Table structure for table `t_customer_linkman` */

DROP TABLE IF EXISTS `t_customer_linkman`;

CREATE TABLE `t_customer_linkman` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cusId` int(11) DEFAULT NULL,
  `linkName` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `zhiwei` varchar(50) DEFAULT NULL,
  `officePhone` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer_linkman` */

LOCK TABLES `t_customer_linkman` WRITE;

insert  into `t_customer_linkman`(`id`,`cusId`,`linkName`,`sex`,`zhiwei`,`officePhone`,`phone`) values (12,21,'周杰伦','男','明星','05515614987','18326889654'),(13,21,'蔡依林','女','模特','05645615769','18326887158'),(14,22,'姚','男','职员','0551-23432432','18957683456');

UNLOCK TABLES;

/*Table structure for table `t_customer_loss` */

DROP TABLE IF EXISTS `t_customer_loss`;

CREATE TABLE `t_customer_loss` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cusNo` varchar(40) DEFAULT NULL,
  `cusName` varchar(20) DEFAULT NULL,
  `cusManager` varchar(20) DEFAULT NULL,
  `lastOrderTime` date DEFAULT NULL,
  `confirmLossTime` date DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `lossreason` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer_loss` */

LOCK TABLES `t_customer_loss` WRITE;

insert  into `t_customer_loss`(`id`,`cusNo`,`cusName`,`cusManager`,`lastOrderTime`,`confirmLossTime`,`state`,`lossreason`) values (1,'1','科大讯飞','周林','2016-08-08','2016-09-08',1,'长得丑');

UNLOCK TABLES;

/*Table structure for table `t_customer_order` */

DROP TABLE IF EXISTS `t_customer_order`;

CREATE TABLE `t_customer_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cusId` int(11) DEFAULT NULL,
  `orderNo` varchar(40) DEFAULT NULL,
  `orderDate` date DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer_order` */

LOCK TABLES `t_customer_order` WRITE;

insert  into `t_customer_order`(`id`,`cusId`,`orderNo`,`orderDate`,`address`,`state`) values (1,0,'001','2016-12-12','合肥市高新区',1);

UNLOCK TABLES;

/*Table structure for table `t_customer_reprieve` */

DROP TABLE IF EXISTS `t_customer_reprieve`;

CREATE TABLE `t_customer_reprieve` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lossId` int(11) DEFAULT NULL,
  `measure` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer_reprieve` */

LOCK TABLES `t_customer_reprieve` WRITE;

insert  into `t_customer_reprieve`(`id`,`lossId`,`measure`) values (2,1,'1111');

UNLOCK TABLES;

/*Table structure for table `t_customer_service` */

DROP TABLE IF EXISTS `t_customer_service`;

CREATE TABLE `t_customer_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serveType` varchar(30) DEFAULT NULL,
  `overview` varchar(500) DEFAULT NULL,
  `customer` varchar(30) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `servicerequest` varchar(500) DEFAULT NULL,
  `createPeople` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `assigner` varchar(100) DEFAULT NULL,
  `assignTime` datetime DEFAULT NULL,
  `serviceProce` varchar(500) DEFAULT NULL,
  `serviceProcePeople` varchar(20) DEFAULT NULL,
  `serviceProceTime` datetime DEFAULT NULL,
  `serviceProceResult` varchar(500) DEFAULT NULL,
  `myd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer_service` */

LOCK TABLES `t_customer_service` WRITE;

insert  into `t_customer_service`(`id`,`serveType`,`overview`,`customer`,`state`,`servicerequest`,`createPeople`,`createTime`,`assigner`,`assignTime`,`serviceProce`,`serviceProcePeople`,`serviceProceTime`,`serviceProceResult`,`myd`) values (19,'投诉','概要Test','客户Test','已归档','服务请求Test','张宇','2016-09-09 00:00:00','周林','2016-09-09 00:00:00','服务处理Test',NULL,'2016-09-09 00:00:00','成功','☆☆☆☆☆'),(20,'建议','概要Demo','客户Demo','已归档','服务请求Demo','张宇','2016-09-09 00:00:00','周林','2016-09-09 00:00:00','服务请求Demo','张宇','2016-09-09 00:00:00','失败了','☆'),(21,'建议','概要001','客户001','已归档','服务请求001','张宇','2016-09-09 00:00:00','周林','2016-09-09 00:00:00','服务处理001','张宇','2016-09-09 00:00:00','成功','☆☆☆☆☆');

UNLOCK TABLES;

/*Table structure for table `t_datadic` */

DROP TABLE IF EXISTS `t_datadic`;

CREATE TABLE `t_datadic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataDicName` varchar(50) DEFAULT NULL,
  `dataDicValue` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_datadic` (`dataDicValue`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `t_datadic` */

LOCK TABLES `t_datadic` WRITE;

insert  into `t_datadic`(`id`,`dataDicName`,`dataDicValue`) values (1,'德玛西亚','德玛西亚之力盖伦'),(2,'德玛西亚','暗夜猎手维恩'),(3,'诺克萨斯','不祥之刃卡特琳娜'),(4,'诺克萨斯','诺克萨斯之手德莱厄斯'),(6,'德玛西亚','德邦总管赵信'),(7,'诺克萨斯','黑暗之女安妮'),(8,'客户等级','优秀客户'),(9,'客户等级','一般客户'),(10,'客户等级','希望客户'),(11,'服务类型','咨询'),(12,'服务类型','建议'),(13,'服务类型','投诉');

UNLOCK TABLES;

/*Table structure for table `t_order_details` */

DROP TABLE IF EXISTS `t_order_details`;

CREATE TABLE `t_order_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) DEFAULT NULL,
  `goodsName` varchar(100) DEFAULT NULL,
  `goodsNum` int(11) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `sum` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_order_details` */

LOCK TABLES `t_order_details` WRITE;

UNLOCK TABLES;

/*Table structure for table `t_product` */

DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
  `id` double DEFAULT NULL,
  `productName` varchar(300) DEFAULT NULL,
  `model` varchar(150) DEFAULT NULL,
  `unit` varchar(60) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `store` double DEFAULT NULL,
  `remark` varchar(3000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_product` */

LOCK TABLES `t_product` WRITE;

insert  into `t_product`(`id`,`productName`,`model`,`unit`,`price`,`store`,`remark`) values (1,'联想ThinkPad','E430','1',5000,25,'联想IBM笔记本电脑');

UNLOCK TABLES;

/*Table structure for table `t_sale_chance` */

DROP TABLE IF EXISTS `t_sale_chance`;

CREATE TABLE `t_sale_chance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chanceSource` varchar(300) DEFAULT NULL,
  `customerName` varchar(100) DEFAULT NULL,
  `cgjl` int(11) DEFAULT NULL,
  `overview` varchar(300) DEFAULT NULL,
  `linkMan` varchar(100) DEFAULT NULL,
  `linkPhone` varchar(100) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `createMan` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `assignMan` varchar(100) DEFAULT NULL,
  `assignTime` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `devResult` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_sale_chance` */

LOCK TABLES `t_sale_chance` WRITE;

insert  into `t_sale_chance`(`id`,`chanceSource`,`customerName`,`cgjl`,`overview`,`linkMan`,`linkPhone`,`description`,`createMan`,`createTime`,`assignMan`,`assignTime`,`state`,`devResult`) values (1,'新安人才网','科大讯',80,'牛逼的公司','张三','18326893198','合肥的','张宇','2016-08-28 00:00:00','用户001','2016-08-30 16:29:00',1,2),(2,'新安人才网','安徽超远',90,'左鹏是牛逼的高级软件工程师','左鹏','18156989654','跟他好好学习java知识','张宇','2016-09-02 13:28:00','用户001','2016-09-02 13:30:00',1,2),(3,'黄岛介绍','合肥宏晶信息',90,'概要Test','姚双帅','15555555555','机会描述Test','张宇','2016-09-10 13:32:00','周林','2016-09-10 13:33:00',1,NULL);

UNLOCK TABLES;

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userName` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `trueName` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(40) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `roleName` varchar(50) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

LOCK TABLES `t_user` WRITE;

insert  into `t_user`(`id`,`userName`,`password`,`trueName`,`email`,`phone`,`roleName`) values (1,'admin','pass','张宇','729235023@qq.com','18326893198','系统管理员'),(2,'dear','5201314','周林','1183267312@qq.com','18326887158','客户经理'),(5,'user001','1234','用户001','001@163.com','110','销售主管');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
