--util_file edit by weigion.wu

DROP TABLE IF EXISTS `util_document`;

CREATE TABLE util_document (
  document_id INT(11) NOT NULL AUTO_INCREMENT,
  document_title VARCHAR(50) NOT NULL,
  document_name VARCHAR(300) NOT NULL,
  document_comment VARCHAR(300) DEFAULT NULL,
  document_created_datetime TIMESTAMP  NULL comment '创建时间',
  document_created_name VARCHAR(20) NOT NULL comment '创建人',
  document_updated_datetime TIMESTAMP  NOT NULL  default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP 
	comment '修改时间',
  document_updated_name VARCHAR(20) NOT NULL comment '修改人',
  document_isValid tinyint(1) NOT NULL,
  PRIMARY KEY (document_id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

--插入--
INSERT INTO `util_document` VALUES ('1','accountInfo','1.jpg','ww','2018-05-11 09:22:03','1','2018-05-11 09:22:03','2','1');
INSERT INTO `util_document` VALUES ('2','positionInfo','1.jpg','ww','2018-05-11 09:22:03','1','2018-05-11 09:22:03','2','1');
INSERT INTO `util_document` VALUES ('3','departmentInfo','1.jpg','ww','2018-05-11 09:22:03','1','2018-05-11 09:22:03','2','1');
INSERT INTO `util_document` VALUES ('5','weigion1','1.jpg','ww','2018-05-11 09:22:03','1','2018-05-11 09:22:03','2','1');
INSERT INTO `util_document` VALUES ('6','weigion2','1.jpg','ww','2018-05-11 09:22:03','1','2018-05-11 09:22:03','2','1');