
DROP TABLE `de_info_ta`;

CREATE TABLE `de_info_ta` (
	`DEPA_NUMBER` INT NOT NULL AUTO_INCREMENT,
	`DEPA_NAME` VARCHAR(40),
	`DEPA_FATHER_NUMBER` VARCHAR(40),
	`DEPA_CHILD_NUMBER` VARCHAR(40),
	`DEPA_LEVEL` VARCHAR(8),
	`DEPA_EMAIL` VARCHAR(40),
	`DEPA_COMMENT` VARCHAR(40),
	`DEPA_CREATE_NAME` VARCHAR(40),
	`DEPA_CREATE_DATETIME` DATETIME,
	`DEPA_UPDATED_NAME` VARCHAR(40),
	`DEPA_UPDATED_DATETIME` DATETIME,
	PRIMARY KEY (`DEPA_NUMBER`)
)ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

insert into `de_info_ta` values('1','开发部','5','6','2','2818694679@qq.com',null,'ft',null,'ft',null);

