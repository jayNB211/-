DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `account_id` int(12) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(60) NOT NULL,
  `account_real_name` varchar(60) NOT NULL,
  `account_pass` varchar(60) NOT NULL,
  `account_mail` varchar(60) NOT NULL,
  `account_address` varchar(100) NOT NULL,
  `account_phone` varchar(50) NOT NULL,
  `account_role_id` int(12) DEFAULT NULL,
  `account_position_id` int(12) DEFAULT NULL,
  `account_company_id` int(12) DEFAULT NULL,
  `account_created_datetime` timestamp NOT NULL,
  `account_created_name` varchar(50) NOT NULL,
  `account_updated_datetime` timestamp NOT NULL,
  `account_updated_name` varchar(50) NOT NULL,
  `account_isValid` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_name` (`account_name`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `account` */

insert  into `account`(`account_id`,`account_name`,`account_real_name`,`account_pass`,`account_mail`,`account_address`,`account_phone`,`account_role_id`,`account_position_id`,`account_company_id`,`account_created_datetime`,`account_created_name`,`account_updated_datetime`,`account_updated_name`,`account_isValid`) values (1,'jhx1','金宏潇1','1','123@qq.com','金陵科技学院','123213',1,1,1,'2018-06-05 14:43:42','admin','2018-06-05 14:43:42','admin',1),(2,'jhx2','金宏潇2','12','123@qq.com','金陵科技学院','21123',1,1,1,'2018-06-04 16:46:01','jhx1','2018-06-04 16:46:01','jhx1',1),(3,'jhx3','金宏潇3','123','123@qq.com','金陵科技学院','12321',1,2,1,'2018-06-04 16:46:20','jhx1','2018-06-04 16:46:20','jhx1',1),(4,'jhx4','金宏潇4','1234','213@qq.com','金陵科技学院','321312312',1,1,1,'2018-06-05 14:34:34','admin','2018-06-05 11:24:42','admin',1),(5,'jhx5','金宏潇5','12345','213@qq.com','金陵科技学院','2312',1,1,1,'2018-06-05 11:26:37','admin','2018-06-05 11:26:37','admin',1),(6,'jhx6','金宏潇6','123456','213@qq.com','金陵科技学院','2312',1,1,1,'2018-06-05 11:27:02','admin','2018-06-05 11:27:02','admin',1),(7,'jhx7','金宏潇','1234567','12312@qq.com','金陵科技学院','21312',1,1,1,'2018-06-05 14:34:39','admin','2018-06-05 11:29:07','admin',1),(8,'jhx8','金宏潇8','888','2213@qq.com','金陵科技学院','21312',1,1,1,'2018-06-05 11:37:27','admin','2018-06-05 11:37:27','admin',1),(9,'jhx9','金宏潇9','999','12321@qq.com','金陵科技学院','12312321',1,1,1,'2018-06-05 11:39:56','admin','2018-06-05 11:39:56','admin',1),(10,'jhx10','金宏潇10','10','312@qq.com','金陵科技学院','312',1,1,1,'2018-06-05 14:08:27','admin','2018-06-05 14:08:27','admin',1),(11,'jhx11','金宏潇11','11','123@qq.com','金陵科技学院','3123',1,1,1,'2018-06-05 14:09:53','admin','2018-06-05 14:09:53','admin',1),(12,'jhx12','金宏潇12','12','213@qq.com','金陵科技学院','123',1,1,1,'2018-06-05 14:16:59','admin','2018-06-05 14:16:59','admin',1),(13,'jhx13','金宏潇','13','123@qq.com','金陵科技学院','12',1,1,1,'2018-06-05 14:22:09','admin','2018-06-05 14:22:09','admin',1),(14,'jhx14','金宏潇14','141412','213@qq.com','金陵科技学院','312313212',1,1,1,'2018-06-05 14:26:45','admin','2018-06-05 14:26:45','admin',1),(15,'jhx15','金宏潇15','15','123@qq.com','金陵科技学院','1321312',1,1,1,'2018-06-05 14:31:50','admin','2018-06-05 14:31:50','admin',1);