--<ScriptOptions statementTerminator=";"/>
--oas  --




DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(30) NOT NULL ,
  `permission_code` varchar(100) NOT NULL ,
  `permission_comment` varchar(100) NOT NULL ,
  `permission_created_datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `permission_created_name` int(11) DEFAULT NULL,
  `permission_updated_datetime` timestamp NULL DEFAULT '2018-12-25 00:00:00',
  `permission_updated_name` int(11) DEFAULT NULL,
  `is_visible` int(11) DEFAULT 1,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `permission` */

insert  into `permission`(`permission_id`,`permission_name`,`permission_code`,`permission_comment`,
`permission_created_datetime`,`permission_created_name`,`permission_updated_datetime`,
`permission_updated_name`,`is_visible`) 
values (1,'select','permission_1','123','2018-05-11 09:35:48',1,'2018-05-11 09:35:48',1,1);