-- ----------------------------
-- Table structure for `sm_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sm_menu`;
CREATE TABLE `sm_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(100) NOT NULL COMMENT '菜单名',
  `menu_sort_id` int(11) NOT NULL COMMENT '菜单排序号',
  `menu_level` int(11) NOT NULL COMMENT '菜单等级',
  `menu_parentid` int(11) NOT NULL COMMENT '菜单父Id',
  `menu_url` varchar(100) DEFAULT NULL COMMENT '菜单url',
  `menu_isvariable` int(11) NOT NULL DEFAULT '1' COMMENT '菜单状态',
  `menu_comment` varchar(1000) DEFAULT NULL COMMENT '菜单备注',
  `menu_created_datetime` timestamp NULL DEFAULT NULL COMMENT '菜单创建时间',
  `menu_created_name` varchar(50) NOT NULL COMMENT '菜单创建人',
  `menu_updated_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '菜单修改时间',
  `menu_updated_name` varchar(50) NOT NULL COMMENT '菜单修改人',
  `menu_default1` varchar(20) DEFAULT NULL,
  `menu_default2` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_menu
-- ----------------------------
INSERT INTO `sm_menu` VALUES ('1', '系统管理', '1', '0', '0', '/', '1', 'root', '2018-05-11 09:22:03', 'admin', '2018-06-05 10:01:19', 'admin', null, null);
INSERT INTO `sm_menu` VALUES ('2', '菜单管理', '1', '1', '1', 'menu_list', '1', 'menu', '2018-05-11 09:22:03', 'admin', '2018-06-05 16:09:09', 'admin', null, null);
INSERT INTO `sm_menu` VALUES ('3', '职位管理', '2', '1', '1', 'positionList', '1', 'position', '2018-05-23 09:12:52', 'admin', '2018-06-05 16:09:10', 'admin', null, null);
INSERT INTO `sm_menu` VALUES ('4', '部门管理', '3', '1', '1', 'departmentList', '1', 'department', '2018-05-22 17:23:25', 'admin', '2018-06-05 16:09:11', 'admin', null, null);
INSERT INTO `sm_menu` VALUES ('5', '权限管理', '4', '1', '1', 'permissionvoList', '1', 'permission', '2018-05-29 10:51:43', 'admin', '2018-06-05 16:09:12', 'admin', null, null);
INSERT INTO `sm_menu` VALUES ('6', '邮箱管理', '5', '1', '1', 'sendemailList', '1', 'sendemail', '2018-05-29 22:11:22', 'admin', '2018-06-05 16:09:13', 'admin', null, null);
INSERT INTO `sm_menu` VALUES ('7', '参数管理', '6', '1', '1', 'parameterList', '1', 'parameter', '2018-05-29 11:22:11', 'admin', '2018-06-05 16:09:13', 'admin', null, null);
INSERT INTO `sm_menu` VALUES ('8', '角色管理', '7', '1', '1', 'roleList', '1', 'role', '2018-06-05 09:49:10', 'admin', '2018-06-05 16:09:14', 'admin', null, null);
INSERT INTO `sm_menu` VALUES ('9', '文件管理', '8', '1', '1', 'documentList', '1', 'document', '2018-05-29 11:22:11', 'admin', '2018-06-05 16:09:35', 'admin', null, null);
