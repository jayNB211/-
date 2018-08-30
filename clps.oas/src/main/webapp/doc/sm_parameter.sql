
DROP TABLE IF EXISTS parameter;


create table PARAMETER(
	parameter_id 				int AUTO_INCREMENT,	
	parameter_name 				VARCHAR(60) NOT null,	
	parameter_conent 			varchar(100) NOT NULL,	
	parameter_spuelId 			int DEFAULT 0,	
	parameter__comment 			varchar(1000),	
	parameter_created_datetime	timestamp NULL DEFAULT NULL COMMENT '参数创建时间',	
	parameter_created_name 		varchar(50) NOT NULL,
	parameter__updated_datetime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '参数修改时间',
	parameter_updated_name 		varchar(50) NOT NULL,
	parameter_isvariable 		int NOT NULL,
	user_default1 				varchar(60),
	user_default2 				varchar(60),
	PRIMARY KEY (parameter_id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO PARAMETER(parameter_name,parameter_conent,parameter_spuelId,parameter__comment,
parameter_created_datetime,parameter_created_name,parameter__updated_datetime,parameter_updated_name,
parameter_isvariable,user_default1,user_default2
) VALUES("pageSize","10",0,"Page maximum capacity",'2018-05-7 10:30:03',"admin",'2018-5-7 10:30:03',"admin",1,"111","111");

INSERT INTO PARAMETER(parameter_name,parameter_conent,parameter_spuelId,parameter__comment,
parameter_created_datetime,parameter_created_name,parameter__updated_datetime,parameter_updated_name,
parameter_isvariable,user_default1,user_default2
) VALUES("fileSaveRootPath","/doc/excelTemplate",0,"Upload path",'2018-05-7 10:30:03',"admin",'2018-5-7 10:30:03',"admin",1,"111","111");