/*
Navicat MySQL Data Transfer

Source Server         : 3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : blog-admin

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2020-07-14 15:42:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(64) DEFAULT NULL COMMENT '部门名称',
  `state` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '部门状态（1：正常， 0：停用）',
  `sort` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序（数字越大，越排前）',
  `creator_id` int(11) unsigned NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `editor_id` int(11) unsigned DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `upper_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '上一级部门id',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='部门管理';

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '项目部', '1', '0', '1', '2020-07-13 09:43:38', null, null, '0', '0');
INSERT INTO `dept` VALUES ('2', '项目一部', '1', '0', '1', '2020-07-13 09:45:16', null, null, '1', '0');
INSERT INTO `dept` VALUES ('3', '项目一部一科', '1', '0', '1', '2020-07-13 09:45:46', null, null, '2', '0');

-- ----------------------------
-- Table structure for dept_copy
-- ----------------------------
DROP TABLE IF EXISTS `dept_copy`;
CREATE TABLE `dept_copy` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(64) DEFAULT NULL COMMENT '部门名称',
  `state` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '部门状态（1：正常， 0：停用）',
  `sort` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序（数字越大，越排前）',
  `creator_id` int(11) unsigned NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `editor_id` int(11) unsigned DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `upper_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '上一级部门id',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='部门管理';

-- ----------------------------
-- Records of dept_copy
-- ----------------------------
INSERT INTO `dept_copy` VALUES ('2', '财务部', '1', '0', '0', '0000-00-00 00:00:00', null, null, '0', '0');
INSERT INTO `dept_copy` VALUES ('3', '设计部', '1', '0', '0', '0000-00-00 00:00:00', null, null, '0', '0');
INSERT INTO `dept_copy` VALUES ('4', '工程部', '1', '0', '0', '0000-00-00 00:00:00', null, null, '0', '0');
INSERT INTO `dept_copy` VALUES ('5', '项目部', '1', '0', '0', '0000-00-00 00:00:00', null, null, '0', '0');
INSERT INTO `dept_copy` VALUES ('6', '销售部', '1', '0', '0', '0000-00-00 00:00:00', null, null, '0', '0');
INSERT INTO `dept_copy` VALUES ('7', '人力资源部', '1', '0', '0', '0000-00-00 00:00:00', null, null, '0', '0');
INSERT INTO `dept_copy` VALUES ('8', '项目一部', '1', '0', '0', '0000-00-00 00:00:00', null, null, '2', '0');
INSERT INTO `dept_copy` VALUES ('9', '项目二部', '1', '0', '0', '0000-00-00 00:00:00', null, null, '5', '0');
INSERT INTO `dept_copy` VALUES ('10', '财务部', '1', '0', '0', '0000-00-00 00:00:00', null, null, '8', '0');
INSERT INTO `dept_copy` VALUES ('11', '品质科', '1', '0', '0', '0000-00-00 00:00:00', null, null, '8', '0');
INSERT INTO `dept_copy` VALUES ('12', '会计', '1', '0', '0', '0000-00-00 00:00:00', null, null, '2', '0');
INSERT INTO `dept_copy` VALUES ('13', '某中心', '1', '0', '0', '0000-00-00 00:00:00', null, null, '1', '0');
INSERT INTO `dept_copy` VALUES ('14', '会计', '1', '0', '0', '0000-00-00 00:00:00', null, null, '10', '0');
INSERT INTO `dept_copy` VALUES ('15', '某科室', '1', '0', '0', '0000-00-00 00:00:00', null, null, '14', '0');
INSERT INTO `dept_copy` VALUES ('16', '通号研究院', '1', '0', '0', '0000-00-00 00:00:00', null, null, '1', '0');
INSERT INTO `dept_copy` VALUES ('17', '通信网络部', '1', '0', '0', '0000-00-00 00:00:00', null, null, '16', '0');
INSERT INTO `dept_copy` VALUES ('18', '测试父1', '1', '0', '0', '0000-00-00 00:00:00', null, null, '19', '0');
INSERT INTO `dept_copy` VALUES ('19', '测试父', '1', '0', '0', '0000-00-00 00:00:00', null, null, '1', '0');
INSERT INTO `dept_copy` VALUES ('20', '测试子1.1', '1', '0', '0', '0000-00-00 00:00:00', null, null, '18', '0');
INSERT INTO `dept_copy` VALUES ('21', '测试子1.2', '1', '0', '0', '0000-00-00 00:00:00', null, null, '18', '0');
INSERT INTO `dept_copy` VALUES ('22', '测试子1.3', '1', '0', '0', '0000-00-00 00:00:00', null, null, '18', '0');
INSERT INTO `dept_copy` VALUES ('23', '测试子2.1', '1', '0', '0', '0000-00-00 00:00:00', null, null, '19', '0');
INSERT INTO `dept_copy` VALUES ('24', '测试子2.2', '1', '0', '0', '0000-00-00 00:00:00', null, null, '19', '0');
INSERT INTO `dept_copy` VALUES ('25', 'qqq', '1', '0', '0', '0000-00-00 00:00:00', null, null, '1', '0');
INSERT INTO `dept_copy` VALUES ('26', '111', '1', '0', '0', '0000-00-00 00:00:00', null, null, '1', '0');
INSERT INTO `dept_copy` VALUES ('27', 'xixia', '1', '0', '0', '0000-00-00 00:00:00', null, null, '1', '0');
INSERT INTO `dept_copy` VALUES ('28', 'xixi ', '1', '0', '0', '0000-00-00 00:00:00', null, null, '27', '0');
INSERT INTO `dept_copy` VALUES ('29', '市场', '1', '0', '0', '0000-00-00 00:00:00', null, null, '7', '0');
INSERT INTO `dept_copy` VALUES ('30', '334', '1', '0', '0', '0000-00-00 00:00:00', null, null, '2', '0');
INSERT INTO `dept_copy` VALUES ('31', '项目一部', '1', '0', '0', '0000-00-00 00:00:00', null, null, '5', '0');
INSERT INTO `dept_copy` VALUES ('32', '推广科', '1', '0', '0', '0000-00-00 00:00:00', null, null, '9', '0');
INSERT INTO `dept_copy` VALUES ('33', '剪辑', '1', '0', '0', '0000-00-00 00:00:00', null, null, '3', '0');
INSERT INTO `dept_copy` VALUES ('34', '项目部', '1', '0', '1', '2020-07-08 16:47:17', null, null, '0', '0');

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '字典id',
  `group` varchar(255) NOT NULL COMMENT '字典名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '字典描述',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES ('1', 'test', '测试组', '0');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `job_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '岗位id',
  `job_name` varchar(64) NOT NULL COMMENT '岗位名称',
  `job_status` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '岗位状态（1：正常， 0：停用）',
  `sort_value` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序（数字越大，越排前）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `edit_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  `upper_id` int(11) unsigned NOT NULL COMMENT '上一级岗位id',
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='部门管理';

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('1', '公司', '1', '0', '2019-10-29 13:52:43', null, '0', '0');
INSERT INTO `job` VALUES ('2', '财务部', '1', '0', '2019-10-29 13:52:43', null, '0', '1');
INSERT INTO `job` VALUES ('3', '设计部', '1', '0', '2019-10-29 13:52:43', null, '0', '1');
INSERT INTO `job` VALUES ('4', '工程部', '1', '0', '2019-10-29 13:52:43', null, '0', '1');
INSERT INTO `job` VALUES ('5', '项目部', '1', '0', '2019-10-29 13:52:43', null, '0', '1');
INSERT INTO `job` VALUES ('6', '销售部', '1', '0', '2019-10-29 13:52:43', null, '0', '1');
INSERT INTO `job` VALUES ('7', '人力资源部', '1', '0', '2019-10-29 13:52:43', null, '0', '1');
INSERT INTO `job` VALUES ('8', '项目一部', '1', '0', '2019-10-29 13:52:43', null, '0', '5');
INSERT INTO `job` VALUES ('9', '项目二部', '1', '0', '2019-10-29 13:52:43', null, '0', '5');
INSERT INTO `job` VALUES ('10', '工艺科', '1', '0', '2019-10-29 13:52:43', null, '0', '8');
INSERT INTO `job` VALUES ('11', '品质科', '1', '0', '2019-10-29 13:52:43', null, '0', '8');
INSERT INTO `job` VALUES ('12', '系统科', '1', '0', '2019-10-29 13:52:43', null, '0', '9');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `user_id` int(11) unsigned DEFAULT NULL COMMENT '操作用户id',
  `name` varchar(255) DEFAULT NULL COMMENT '操作用户名',
  `type` int(11) DEFAULT NULL COMMENT '日志类型（1：用户登录，2：用户操作，3：用户登出）',
  `log` varchar(255) DEFAULT NULL COMMENT 'log信息',
  `url` varchar(255) DEFAULT NULL COMMENT '网址',
  `http_method` varchar(255) DEFAULT NULL COMMENT '请求方式',
  `method` varchar(255) DEFAULT NULL COMMENT '方法名',
  `params` text COMMENT '参数',
  `ip` varchar(255) DEFAULT NULL COMMENT 'IP地址',
  `agent` varchar(255) DEFAULT NULL COMMENT 'User-Agent',
  `os` varchar(255) DEFAULT NULL COMMENT '系统',
  `browser` varchar(255) DEFAULT NULL COMMENT '浏览器',
  `state` int(11) unsigned DEFAULT NULL COMMENT '任务状态 （1：成功，0：失败）',
  `error` text COMMENT '错误信息',
  `millis` bigint(20) DEFAULT NULL COMMENT '执行时间（单位：毫秒）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统日志';

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', null, 'admin', '1', '登录', 'http://localhost:8000/login', 'GET', 'com.fleet.consumer.controller.admin.user.LoginController.login()', '{ name: admin, pwd: 密码不能明文显示 }', '172.30.18.103', 'Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:78.0) Gecko/20100101 Firefox/78.0', 'Windows 7', 'Firefox 7', '1', null, '44', '2020-07-08 09:17:30');
INSERT INTO `log` VALUES ('2', null, 'admin', '1', '登录', 'http://localhost:8000/login', 'GET', 'com.fleet.consumer.controller.admin.user.LoginController.login()', '{ name: admin, pwd: 密码不能明文显示 }', '172.30.18.103', 'Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:78.0) Gecko/20100101 Firefox/78.0', 'Windows 7', 'Firefox 7', '1', null, '50', '2020-07-08 09:17:36');
INSERT INTO `log` VALUES ('3', null, 'admin', '1', '登录', 'http://localhost:8000/login', 'GET', 'com.fleet.consumer.controller.admin.user.LoginController.login()', '{ name: admin, pwd: 密码不能明文显示 }', '172.30.18.103', 'Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:78.0) Gecko/20100101 Firefox/78.0', 'Windows 7', 'Firefox 7', '1', null, '449', '2020-07-08 09:55:43');
INSERT INTO `log` VALUES ('4', null, 'admin', '1', '登录', 'http://localhost:8000/login', 'GET', 'com.fleet.consumer.controller.admin.user.LoginController.login()', '{ name: admin, pwd: 密码不能明文显示 }', '172.30.18.103', 'Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:78.0) Gecko/20100101 Firefox/78.0', 'Windows 7', 'Firefox 7', '1', null, '353', '2020-07-09 09:47:30');

-- ----------------------------
-- Table structure for mail_group
-- ----------------------------
DROP TABLE IF EXISTS `mail_group`;
CREATE TABLE `mail_group` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '邮箱组id',
  `name` varchar(126) NOT NULL COMMENT '邮箱组名称',
  `tos` text COMMENT '邮箱（多个邮箱之间用","隔开）',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='邮箱组信息';

-- ----------------------------
-- Records of mail_group
-- ----------------------------
INSERT INTO `mail_group` VALUES ('1', '资产台账数据修改提醒组', '785579683@qq.com', '0');
INSERT INTO `mail_group` VALUES ('2', '资产邮箱组', 'fleet@fleet.com,admin@fleet.com', '0');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `type` int(11) unsigned NOT NULL COMMENT '菜单类型（1：目录，2：菜单，3：权限标识）',
  `name` varchar(32) NOT NULL COMMENT '菜单名称',
  `icon` varchar(128) DEFAULT NULL COMMENT '菜单图标',
  `desc` varchar(128) DEFAULT NULL COMMENT '菜单描述',
  `href` varchar(255) DEFAULT NULL COMMENT '资源路径',
  `target` varchar(16) DEFAULT NULL COMMENT '打开方式（_self：相同框架，Top：当前页，_blank：新建窗口，Parent：父窗口）',
  `permit` varchar(255) DEFAULT NULL COMMENT '授权标识（多个之间用","隔开）',
  `sort` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序（数字越大，越排前）',
  `opened` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '是否公开菜单（1：是，无需分配就可以访问，0：否）',
  `enabled` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '是否启用（1：是，0：否）',
  `creator_id` int(11) unsigned NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `editor_id` int(11) unsigned DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `upper_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '上一级菜单id',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '1', '工具', null, null, null, null, null, '0', '1', '1', '1', '2020-07-13 10:58:52', null, null, '0', '0');

-- ----------------------------
-- Table structure for menu_copy
-- ----------------------------
DROP TABLE IF EXISTS `menu_copy`;
CREATE TABLE `menu_copy` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `type` int(11) unsigned NOT NULL COMMENT '菜单类型（1：目录，2：菜单，3：权限标识）',
  `name` varchar(32) NOT NULL COMMENT '菜单名称',
  `icon` varchar(128) DEFAULT NULL COMMENT '菜单图标',
  `desc` varchar(128) DEFAULT NULL COMMENT '菜单描述',
  `href` varchar(255) DEFAULT NULL COMMENT '资源路径',
  `target` varchar(16) DEFAULT NULL COMMENT '打开方式（_self：相同框架，Top：当前页，_blank：新建窗口，Parent：父窗口）',
  `permit` varchar(255) DEFAULT NULL COMMENT '授权标识（多个之间用","隔开）',
  `sort` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序（数字越大，越排前）',
  `opened` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '是否公开菜单（1：是，无需分配就可以访问，0：否）',
  `enabled` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '是否启用（1：是，0：否）',
  `creator_id` int(11) unsigned NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `editor_id` int(11) unsigned DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `upper_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '上一级菜单id',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of menu_copy
-- ----------------------------
INSERT INTO `menu_copy` VALUES ('1', '1', '综合管理', null, null, null, null, null, '4', '0', '1', '0', '2020-07-28 16:09:28', null, null, '0', '0');
INSERT INTO `menu_copy` VALUES ('2', '1', '项目管理', null, null, null, null, null, '3', '1', '1', '0', '2020-07-14 16:09:31', null, null, '0', '0');
INSERT INTO `menu_copy` VALUES ('3', '1', '人力资源', null, null, null, null, null, '2', '0', '1', '0', '2020-07-14 16:09:34', null, null, '0', '0');
INSERT INTO `menu_copy` VALUES ('4', '1', '系统管理', null, null, null, null, null, '1', '1', '1', '0', '0000-00-00 00:00:00', null, null, '0', '0');
INSERT INTO `menu_copy` VALUES ('5', '1', '工作流程', null, null, null, null, null, '0', '0', '1', '0', '0000-00-00 00:00:00', null, null, '1', '0');
INSERT INTO `menu_copy` VALUES ('6', '3', '人员管理', null, null, null, null, null, '0', '0', '1', '0', '0000-00-00 00:00:00', null, null, '3', '0');
INSERT INTO `menu_copy` VALUES ('7', '3', '人员信息', null, null, '/user/getList', null, 'a:b', '0', '0', '1', '0', '0000-00-00 00:00:00', null, null, '6', '0');

-- ----------------------------
-- Table structure for msg
-- ----------------------------
DROP TABLE IF EXISTS `msg`;
CREATE TABLE `msg` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `title` varchar(255) NOT NULL COMMENT '消息标题',
  `excerpt` varchar(255) DEFAULT NULL COMMENT '消息摘要',
  `url` varchar(255) DEFAULT NULL COMMENT '网址',
  `state` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '消息状态（0：未发布，1：已发布）',
  `creator_id` int(11) unsigned NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of msg
-- ----------------------------
INSERT INTO `msg` VALUES ('1', '测试', '测试', null, '0', '1', '2020-04-06 12:23:50', '0');
INSERT INTO `msg` VALUES ('2', '消息标题', '消息摘要', 'http://www.fleetsoft.com', '1', '1', '2020-07-13 11:35:43', '0');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permission_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限标识',
  `permission_name` varchar(32) NOT NULL COMMENT '权限名称',
  `permission_code` varchar(128) DEFAULT NULL COMMENT '权限代码（如果权限项是包容关系，使用层级关系）',
  `permission_order` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序（数字越大，越排前）',
  `upper_permission_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '上一级权限',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='权限管理';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '查看人员信息', null, '0', '0');
INSERT INTO `permission` VALUES ('2', '查看全部人员信息', 'user:getList', '0', '1');
INSERT INTO `permission` VALUES ('3', '查看部分人员信息', 'user:getList:{deptId:1}', '0', '2');

-- ----------------------------
-- Table structure for quartz_job
-- ----------------------------
DROP TABLE IF EXISTS `quartz_job`;
CREATE TABLE `quartz_job` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '定时器id',
  `job_name` varchar(64) NOT NULL COMMENT '定时器名称',
  `bean_name` varchar(64) NOT NULL COMMENT 'Bean名称',
  `method_name` varchar(64) NOT NULL COMMENT '方法名称',
  `param` varchar(128) DEFAULT NULL COMMENT '参数',
  `cron_expression` text NOT NULL COMMENT 'cron表达式',
  `enabled` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否启用（1：是，0：否）',
  `remark` text COMMENT '备注',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quartz_job
-- ----------------------------
INSERT INTO `quartz_job` VALUES ('1', '有参定时任务', 'testTask', 'run', 'test', '*/20 * * * * ?', '1', null, '0');
INSERT INTO `quartz_job` VALUES ('2', '无参定时任务', 'testTask1', 'run', null, '*/20 * * * * ?', '1', null, '0');

-- ----------------------------
-- Table structure for quartz_job_log
-- ----------------------------
DROP TABLE IF EXISTS `quartz_job_log`;
CREATE TABLE `quartz_job_log` (
  `job_log_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `job_id` int(11) unsigned NOT NULL COMMENT '定时器id',
  `job_name` varchar(64) NOT NULL COMMENT '定时器名称',
  `bean_name` varchar(64) NOT NULL COMMENT 'Bean名称',
  `method_name` varchar(64) NOT NULL COMMENT '方法名称',
  `param` varchar(128) DEFAULT NULL COMMENT '参数',
  `cron_expression` text NOT NULL COMMENT 'cron表达式',
  `state` int(11) NOT NULL COMMENT '任务状态 （1：成功，0：失败）',
  `error` text COMMENT '失败信息',
  `millis` bigint(20) NOT NULL COMMENT '执行时间（单位：毫秒）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of quartz_job_log
-- ----------------------------
INSERT INTO `quartz_job_log` VALUES ('1', '2', '测试', 'testTask1', 'run', null, '*/20 * * * * ?', '1', null, '0', '2020-07-14 15:42:40');
INSERT INTO `quartz_job_log` VALUES ('2', '1', '测试', 'testTask', 'run', 'test', '*/20 * * * * ?', '1', null, '0', '2020-07-14 15:42:40');
INSERT INTO `quartz_job_log` VALUES ('3', '1', '测试', 'testTask', 'run', 'test', '*/20 * * * * ?', '1', null, '1', '2020-07-14 15:42:40');
INSERT INTO `quartz_job_log` VALUES ('4', '2', '测试', 'testTask1', 'run', null, '*/20 * * * * ?', '1', null, '0', '2020-07-14 15:42:40');

-- ----------------------------
-- Table structure for recommendsps
-- ----------------------------
DROP TABLE IF EXISTS `recommendsps`;
CREATE TABLE `recommendsps` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `initiator` text COMMENT '拟稿人',
  `taskname` text COMMENT '审批节点',
  `definitionKey` text COMMENT '流程类型',
  `sps` text COMMENT '审批人',
  `spsName` varchar(255) DEFAULT NULL COMMENT '审批人姓名',
  `spsAssignes` varchar(255) DEFAULT NULL COMMENT '审批人角色',
  `variable` varchar(255) DEFAULT NULL COMMENT '变量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=852 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recommendsps
-- ----------------------------
INSERT INTO `recommendsps` VALUES ('1', '2871059', 'AM', 'wlsq1', '2871059', null, null, null);
INSERT INTO `recommendsps` VALUES ('2', '2871059', 'PM', 'wlsq1', '2813753', null, null, null);
INSERT INTO `recommendsps` VALUES ('3', '2871059', '工程负责人', 'wlsq1', '2871059', null, null, null);
INSERT INTO `recommendsps` VALUES ('4', '3122983', '工程负责人', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('5', '3122983', '申请人科长', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('6', '3122983', '专业PM', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('7', '3122983', '总工', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('8', '3122983', '项目经理', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('9', '3122983', '申请人部门经理', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('10', '3122983', '财务会计', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('11', '3122983', '财务部经理', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('12', '3122983', '事业部总经理', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('13', '3122983', '下单人', 'WLSQ1', '902', null, null, null);
INSERT INTO `recommendsps` VALUES ('14', '3122983', '申请人科长', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('15', '3122983', '总工', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('16', '3122983', '项目经理', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('17', '3122983', 'MPM', 'WLSQ2', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('18', '3122983', '申请人部门经理', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('19', '3122983', '经营管理部物控科长', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('20', '3122983', '经营管理部经理', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('21', '3122983', '财务部经理', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('22', '3122983', '事业部总经理', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('23', '3122983', '下单人', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('24', '3122983', '专业PM', 'WLSQ3', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('25', '3122983', '项目总工', 'WLSQ3', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('26', '3122983', '项目PM', 'WLSQ3', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('27', '3122983', 'PDM/DQA', 'WLSQ3', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('28', '3122983', '商务交付/MPM', 'WLSQ3', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('29', '3122983', '交付/物控科长', 'WLSQ3', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('30', '3122983', '部门经理/总工', 'WLSQ3', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('31', '3122983', '项目部经理', 'WLSQ3', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('32', '3122983', '经营管理部经理', 'WLSQ3', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('33', '3122983', '申请人部门经理', 'WLSQ3', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('34', '3122983', '财务部经理', 'WLSQ3', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('35', '3122983', '事业部总经理', 'WLSQ3', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('36', '3122983', '下单人', 'WLSQ3', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('37', '901', '工程负责人', 'WLSQ1', '', null, null, null);
INSERT INTO `recommendsps` VALUES ('38', '901', '申请人科长', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('39', '901', '专业PM', 'WLSQ1', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('40', '901', '总工', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('41', '901', '项目经理', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('42', '901', '申请人部门经理', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('43', '901', '财务会计', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('44', '901', '财务部经理', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('45', '901', '事业部总经理', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('46', '901', '下单人', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('47', '3122983', '经营管理部 物控科长', 'WLSQ2', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('48', '3122983', '经营管理部 经理', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('49', 'admin', '申请人科长', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('50', 'admin', '总工', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('51', 'admin', '项目经理', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('52', 'admin', 'MPM', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('53', 'admin', '申请人部门经理', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('54', 'admin', '经营管理部 物控科长', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('55', 'admin', '经营管理部 经理', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('56', 'admin', '财务部经理', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('57', 'admin', '事业部总经理', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('58', 'admin', '下单人', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('59', '3122983', '申请人', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('60', '3122983', '驳回', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('61', '3122983', '驳回', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('62', '901', '驳回', 'WLSQ2', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('63', '901', '申请人科长', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('64', '901', '总工', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('65', '901', '项目经理', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('66', '901', 'MPM', 'WLSQ2', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('67', '901', '申请人部门经理', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('68', '901', '经营管理部 物控科长', 'WLSQ2', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('69', '901', '经营管理部 经理', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('70', '901', '财务部经理', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('71', '901', '事业部总经理', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('72', '901', '下单人', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('73', '3122983', '驳回', 'WLSQ3', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('74', '3122983', '经营管理部 造价合约科', 'WLSQ3', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('75', '1421981', '驳回', 'WLSQ1', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('76', '1421981', '工程负责人', 'WLSQ1', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('77', '1421981', '申请人科长', 'WLSQ1', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('78', '1421981', '专业PM', 'WLSQ1', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('79', '1421981', '总工', 'WLSQ1', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('80', '1421981', '项目经理', 'WLSQ1', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('81', '1421981', '申请人部门经理', 'WLSQ1', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('82', '1421981', '财务会计', 'WLSQ1', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('83', '1421981', '财务部经理', 'WLSQ1', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('84', '1421981', '事业部总经理', 'WLSQ1', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('85', '1421981', '下单人', 'WLSQ1', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('86', '1421981', '驳回', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('87', '1421981', '申请人科长', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('88', '1421981', '总工', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('89', '1421981', '项目经理', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('90', '1421981', 'MPM', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('91', '1421981', '申请人部门经理', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('92', '1421981', '经营管理部 物控科长', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('93', '1421981', '经营管理部 经理', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('94', '1421981', '财务部经理', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('95', '1421981', '事业部总经理', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('96', '1421981', '下单人', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('97', 'admin', '驳回', 'WLSQ1', 'admin', null, null, null);
INSERT INTO `recommendsps` VALUES ('98', 'admin', '申请人科长', 'WLSQ1', '554191', null, null, null);
INSERT INTO `recommendsps` VALUES ('99', 'admin', '专业PM', 'WLSQ1', '2871059', null, null, null);
INSERT INTO `recommendsps` VALUES ('100', 'admin', '总工', 'WLSQ1', '2871059', null, null, null);
INSERT INTO `recommendsps` VALUES ('101', 'admin', '项目经理', 'WLSQ1', '2871059', null, null, null);
INSERT INTO `recommendsps` VALUES ('102', 'admin', '申请人部门经理', 'WLSQ1', '2871059', null, null, null);
INSERT INTO `recommendsps` VALUES ('103', 'admin', '财务会计', 'WLSQ1', '2871059', null, null, null);
INSERT INTO `recommendsps` VALUES ('104', 'admin', '财务部经理', 'WLSQ1', '2871059', null, null, null);
INSERT INTO `recommendsps` VALUES ('105', 'admin', '事业部总经理', 'WLSQ1', '2871059', null, null, null);
INSERT INTO `recommendsps` VALUES ('106', 'admin', '下单人', 'WLSQ1', '2813753', null, null, null);
INSERT INTO `recommendsps` VALUES ('107', '902', '驳回', 'WLSQ1', '902', null, null, null);
INSERT INTO `recommendsps` VALUES ('108', '902', '工程负责人', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('109', '902', '申请人科长', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('110', '902', '专业PM', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('111', '902', '总工', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('112', '902', '项目经理', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('113', '902', '申请人部门经理', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('114', '902', '财务会计', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('115', '902', '财务部经理', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('116', '902', '事业部总经理', 'WLSQ1', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('117', '902', '下单人', 'WLSQ1', '902', null, null, null);
INSERT INTO `recommendsps` VALUES ('118', '9986', '驳回', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('119', '9986', '工程负责人', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('120', '9986', '申请人科长', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('121', '9986', '专业PM', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('122', '9986', '总工', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('123', '9986', '项目经理', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('124', '9986', '申请人部门经理', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('125', '9986', '财务会计', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('126', '9986', '财务部经理', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('127', '9986', '事业部总经理', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('128', '9986', '下单人', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('129', '9986', '驳回', 'WLSQ2', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('130', '9986', '申请人科长', 'WLSQ2', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('131', '9986', '总工', 'WLSQ2', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('132', '9986', '项目经理', 'WLSQ2', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('133', '9986', 'MPM', 'WLSQ2', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('134', '9986', '申请人部门经理', 'WLSQ2', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('135', '9986', '经营管理部 物控科长', 'WLSQ2', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('136', '9986', '经营管理部 经理', 'WLSQ2', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('137', '9986', '财务部经理', 'WLSQ2', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('138', '9986', '事业部总经理', 'WLSQ2', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('139', '9986', '下单人', 'WLSQ2', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('140', '329325', '驳回', 'WLSQ1', '329325', null, null, null);
INSERT INTO `recommendsps` VALUES ('141', '329325', '工程负责人', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('142', '329325', '申请人科长', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('143', '329325', '专业PM', 'WLSQ1', '329325', null, null, null);
INSERT INTO `recommendsps` VALUES ('144', '329325', '总工', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('145', '329325', '项目经理', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('146', '329325', '申请人部门经理', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('147', '329325', '财务会计', 'WLSQ1', '329325', null, null, null);
INSERT INTO `recommendsps` VALUES ('148', '329325', '财务部经理', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('149', '329325', '事业部总经理', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('150', '329325', '下单人', 'WLSQ1', '2864323', null, null, null);
INSERT INTO `recommendsps` VALUES ('151', '1801033', '驳回', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('152', '1801033', '专业PM', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('153', '1801033', '项目总工', 'WLSQ3', '584223', null, null, null);
INSERT INTO `recommendsps` VALUES ('154', '1801033', '项目PM', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('155', '1801033', 'PDM/DQA', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('156', '1801033', '商务交付/MPM', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('157', '1801033', '交付/物控科长', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('158', '1801033', '经营管理部 造价合约科', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('159', '1801033', '部门经理/总工', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('160', '1801033', '项目部经理', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('161', '1801033', '经营管理部经理', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('162', '1801033', '申请人部门经理', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('163', '1801033', '财务部经理', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('164', '1801033', '事业部总经理', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('165', '1801033', '下单人', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('166', '3122983', '驳回', 'WLSQ4', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('167', '3122983', '申请人科长', 'WLSQ4', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('168', '3122983', '申请人部门经理', 'WLSQ4', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('169', '3122983', '财务会计', 'WLSQ4', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('170', '3122983', '财务部经理', 'WLSQ4', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('171', '3122983', '事业部总经理', 'WLSQ4', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('172', '3122983', '下单人', 'WLSQ4', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('173', 'admin', '工程负责人', 'WLSQ1', '554191', null, null, null);
INSERT INTO `recommendsps` VALUES ('174', '584223', '驳回', 'WLSQ3', '584223', null, null, null);
INSERT INTO `recommendsps` VALUES ('175', '584223', '专业PM', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('176', '584223', '项目总工', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('177', '584223', '项目PM', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('178', '584223', 'PDM/DQA', 'WLSQ3', '589499', null, null, null);
INSERT INTO `recommendsps` VALUES ('179', '584223', '商务交付/MPM', 'WLSQ3', '1034068', null, null, null);
INSERT INTO `recommendsps` VALUES ('180', '584223', '交付/物控科长', 'WLSQ3', '2614831', null, null, null);
INSERT INTO `recommendsps` VALUES ('181', '584223', '经营管理部 造价合约科', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('182', '584223', '部门经理/总工', 'WLSQ3', '589499', null, null, null);
INSERT INTO `recommendsps` VALUES ('183', '584223', '项目部经理', 'WLSQ3', '1034068', null, null, null);
INSERT INTO `recommendsps` VALUES ('184', '584223', '经营管理部经理', 'WLSQ3', '384284', null, null, null);
INSERT INTO `recommendsps` VALUES ('185', '584223', '申请人部门经理', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('186', '584223', '财务部经理', 'WLSQ3', '2614831', null, null, null);
INSERT INTO `recommendsps` VALUES ('187', '584223', '事业部总经理', 'WLSQ3', '584223', null, null, null);
INSERT INTO `recommendsps` VALUES ('188', '584223', '下单人', 'WLSQ3', '1211488', null, null, null);
INSERT INTO `recommendsps` VALUES ('189', '3175902', '驳回', 'WLSQ2', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('190', '3175902', '申请人科长', 'WLSQ2', 'admin', null, null, null);
INSERT INTO `recommendsps` VALUES ('191', '3175902', '总工', 'WLSQ2', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('192', '3175902', '项目经理', 'WLSQ2', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('193', '3175902', 'MPM', 'WLSQ2', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('194', '3175902', '申请人部门经理', 'WLSQ2', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('195', '3175902', '经营管理部 物控科长', 'WLSQ2', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('196', '3175902', '经营管理部 经理', 'WLSQ2', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('197', '3175902', '财务部经理', 'WLSQ2', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('198', '3175902', '事业部总经理', 'WLSQ2', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('199', '3175902', '下单人', 'WLSQ2', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('200', '329325', '驳回', 'WLSQ4', '329325', null, null, null);
INSERT INTO `recommendsps` VALUES ('201', '329325', '申请人科长', 'WLSQ4', '329325', null, null, null);
INSERT INTO `recommendsps` VALUES ('202', '329325', '申请人部门经理', 'WLSQ4', '329325', null, null, null);
INSERT INTO `recommendsps` VALUES ('203', '329325', '财务会计', 'WLSQ4', '329325', null, null, null);
INSERT INTO `recommendsps` VALUES ('204', '329325', '财务部经理', 'WLSQ4', '329325', null, null, null);
INSERT INTO `recommendsps` VALUES ('205', '329325', '事业部总经理', 'WLSQ4', '329325', null, null, null);
INSERT INTO `recommendsps` VALUES ('206', '329325', '下单人', 'WLSQ4', '329325', null, null, null);
INSERT INTO `recommendsps` VALUES ('207', '902', '驳回', 'WLSQ4', '902', null, null, null);
INSERT INTO `recommendsps` VALUES ('208', '902', '申请人科长', 'WLSQ4', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('209', '902', '申请人部门经理', 'WLSQ4', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('210', '902', '财务会计', 'WLSQ4', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('211', '902', '财务部经理', 'WLSQ4', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('212', '902', '事业部总经理', 'WLSQ4', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('213', '902', '下单人', 'WLSQ4', '902', null, null, null);
INSERT INTO `recommendsps` VALUES ('214', '1421981', '驳回', 'WLSQ4', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('215', '1421981', '申请人科长', 'WLSQ4', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('216', '1421981', '申请人部门经理', 'WLSQ4', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('217', '1421981', '财务会计', 'WLSQ4', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('218', '1421981', '财务部经理', 'WLSQ4', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('219', '1421981', '事业部总经理', 'WLSQ4', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('220', '1421981', '下单人', 'WLSQ4', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('221', '901', '驳回', 'WLSQ4', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('222', '901', '申请人科长', 'WLSQ4', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('223', '901', '申请人部门经理', 'WLSQ4', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('224', '901', '财务会计', 'WLSQ4', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('225', '901', '财务部经理', 'WLSQ4', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('226', '901', '事业部总经理', 'WLSQ4', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('227', '901', '下单人', 'WLSQ4', '901', null, null, null);
INSERT INTO `recommendsps` VALUES ('228', '1034068', '驳回', 'WLSQ3', '1034068', null, null, null);
INSERT INTO `recommendsps` VALUES ('229', '1034068', '专业PM', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('230', '1034068', '项目总工', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('231', '1034068', '项目PM', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('232', '1034068', 'PDM/DQA', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('233', '1034068', '商务交付/MPM', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('234', '1034068', '交付/物控科长', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('235', '1034068', '经营管理部 造价合约科', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('236', '1034068', '部门经理/总工', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('237', '1034068', '项目部经理', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('238', '1034068', '经营管理部经理', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('239', '1034068', '申请人部门经理', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('240', '1034068', '财务部经理', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('241', '1034068', '事业部总经理', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('242', '1034068', '下单人', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('243', '1421981', '驳回', 'WLSQ3', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('244', '1421981', '专业PM', 'WLSQ3', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('245', '1421981', '项目总工', 'WLSQ3', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('246', '1421981', '项目PM', 'WLSQ3', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('247', '1421981', 'PDM/DQA', 'WLSQ3', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('248', '1421981', '商务交付/MPM', 'WLSQ3', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('249', '1421981', '交付/物控科长', 'WLSQ3', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('250', '1421981', '经营管理部 造价合约科', 'WLSQ3', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('251', '1421981', '部门经理/总工', 'WLSQ3', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('252', '1421981', '项目部经理', 'WLSQ3', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('253', '1421981', '经营管理部经理', 'WLSQ3', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('254', '1421981', '申请人部门经理', 'WLSQ3', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('255', '1421981', '财务部经理', 'WLSQ3', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('256', '1421981', '事业部总经理', 'WLSQ3', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('257', '1421981', '下单人', 'WLSQ3', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('258', '2412950', '驳回', 'WLSQ2', '2412950', null, null, null);
INSERT INTO `recommendsps` VALUES ('259', '2412950', '申请人科长', 'WLSQ2', '525683', null, null, null);
INSERT INTO `recommendsps` VALUES ('260', '2412950', '总工', 'WLSQ2', '525683', null, null, null);
INSERT INTO `recommendsps` VALUES ('261', '2412950', '项目经理', 'WLSQ2', '525683', null, null, null);
INSERT INTO `recommendsps` VALUES ('262', '2412950', 'MPM', 'WLSQ2', '208248', null, null, null);
INSERT INTO `recommendsps` VALUES ('263', '2412950', '申请人部门经理', 'WLSQ2', '525683', null, null, null);
INSERT INTO `recommendsps` VALUES ('264', '2412950', '经营管理部 物控科长', 'WLSQ2', '2614831', null, null, null);
INSERT INTO `recommendsps` VALUES ('265', '2412950', '经营管理部 经理', 'WLSQ2', '2412950', null, null, null);
INSERT INTO `recommendsps` VALUES ('266', '2412950', '财务部经理', 'WLSQ2', '208248', null, null, null);
INSERT INTO `recommendsps` VALUES ('267', '2412950', '事业部总经理', 'WLSQ2', '2412950', null, null, null);
INSERT INTO `recommendsps` VALUES ('268', '2412950', '下单人', 'WLSQ2', '2412950', null, null, null);
INSERT INTO `recommendsps` VALUES ('269', '3175902', '驳回', 'WLSQ4', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('270', '3175902', '申请人科长', 'WLSQ4', 'admin', null, null, null);
INSERT INTO `recommendsps` VALUES ('271', '3175902', '申请人部门经理', 'WLSQ4', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('272', '3175902', '财务会计', 'WLSQ4', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('273', '3175902', '财务部经理', 'WLSQ4', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('274', '3175902', '事业部总经理', 'WLSQ4', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('275', '3175902', '下单人', 'WLSQ4', '3175902', null, null, null);
INSERT INTO `recommendsps` VALUES ('276', '35465', '驳回', 'WLSQ1', '35465', null, null, null);
INSERT INTO `recommendsps` VALUES ('277', '35465', '工程负责人', 'WLSQ1', '35465', null, null, null);
INSERT INTO `recommendsps` VALUES ('278', '35465', '申请人科长', 'WLSQ1', '395472', null, null, null);
INSERT INTO `recommendsps` VALUES ('279', '35465', '专业PM', 'WLSQ1', '2058107', null, null, null);
INSERT INTO `recommendsps` VALUES ('280', '35465', '总工', 'WLSQ1', '2058107', null, null, null);
INSERT INTO `recommendsps` VALUES ('281', '35465', '项目经理', 'WLSQ1', '2058107', null, null, null);
INSERT INTO `recommendsps` VALUES ('282', '35465', '申请人部门经理', 'WLSQ1', '395472', null, null, null);
INSERT INTO `recommendsps` VALUES ('283', '35465', '财务会计', 'WLSQ1', '35465', null, null, null);
INSERT INTO `recommendsps` VALUES ('284', '35465', '财务部经理', 'WLSQ1', '395472', null, null, null);
INSERT INTO `recommendsps` VALUES ('285', '35465', '事业部总经理', 'WLSQ1', '35465', null, null, null);
INSERT INTO `recommendsps` VALUES ('286', '35465', '下单人', 'WLSQ1', '35465', null, null, null);
INSERT INTO `recommendsps` VALUES ('287', '35465', '驳回', 'WLSQ2', '35465', null, null, null);
INSERT INTO `recommendsps` VALUES ('288', '35465', '申请人科长', 'WLSQ2', '531557', null, null, null);
INSERT INTO `recommendsps` VALUES ('289', '35465', '总工', 'WLSQ2', '2517495', null, null, null);
INSERT INTO `recommendsps` VALUES ('290', '35465', '项目经理', 'WLSQ2', '2058107', null, null, null);
INSERT INTO `recommendsps` VALUES ('291', '35465', 'MPM', 'WLSQ2', '395472', null, null, null);
INSERT INTO `recommendsps` VALUES ('292', '35465', '申请人部门经理', 'WLSQ2', '2517495', null, null, null);
INSERT INTO `recommendsps` VALUES ('293', '35465', '经营管理部 物控科长', 'WLSQ2', '2614831', null, null, null);
INSERT INTO `recommendsps` VALUES ('294', '35465', '经营管理部 经理', 'WLSQ2', '384284', null, null, null);
INSERT INTO `recommendsps` VALUES ('295', '35465', '财务部经理', 'WLSQ2', '339831', null, null, null);
INSERT INTO `recommendsps` VALUES ('296', '35465', '事业部总经理', 'WLSQ2', '4177', null, null, null);
INSERT INTO `recommendsps` VALUES ('297', '35465', '下单人', 'WLSQ2', '1673938', null, null, null);
INSERT INTO `recommendsps` VALUES ('298', 'admin', '驳回', 'WLSQ2', 'admin', null, null, null);
INSERT INTO `recommendsps` VALUES ('299', '2900962', '驳回', 'WLSQ2', '2900962', null, null, null);
INSERT INTO `recommendsps` VALUES ('300', '2900962', '申请人科长', 'WLSQ2', '2900962', null, null, null);
INSERT INTO `recommendsps` VALUES ('301', '2900962', '总工', 'WLSQ2', '2900962', null, null, null);
INSERT INTO `recommendsps` VALUES ('302', '2900962', '项目经理', 'WLSQ2', '2900962', null, null, null);
INSERT INTO `recommendsps` VALUES ('303', '2900962', 'MPM', 'WLSQ2', '2900962', null, null, null);
INSERT INTO `recommendsps` VALUES ('304', '2900962', '申请人部门经理', 'WLSQ2', '2900962', null, null, null);
INSERT INTO `recommendsps` VALUES ('305', '2900962', '经营管理部 物控科长', 'WLSQ2', '2900962', null, null, null);
INSERT INTO `recommendsps` VALUES ('306', '2900962', '经营管理部 经理', 'WLSQ2', '2900962', null, null, null);
INSERT INTO `recommendsps` VALUES ('307', '2900962', '财务部经理', 'WLSQ2', '2900962', null, null, null);
INSERT INTO `recommendsps` VALUES ('308', '2900962', '事业部总经理', 'WLSQ2', '2900962', null, null, null);
INSERT INTO `recommendsps` VALUES ('309', '2900962', '下单人', 'WLSQ2', '2900962', null, null, null);
INSERT INTO `recommendsps` VALUES ('310', 'admin', '物控工程师', 'unproductiveInWpo', 'admin', '超级管理员', '物控工程师', null);
INSERT INTO `recommendsps` VALUES ('311', 'admin', '仓库主管', 'unproductiveInWpo', 'admin', '超级管理员', '*权限：[仓库管理]', null);
INSERT INTO `recommendsps` VALUES ('312', '3122983', '物控', 'WLSQ2', '3122983', null, null, null);
INSERT INTO `recommendsps` VALUES ('313', '1370145', '驳回', 'WLSQ2', '1370145', null, null, null);
INSERT INTO `recommendsps` VALUES ('314', '1370145', '项目经理', 'WLSQ2', '2412950', null, null, null);
INSERT INTO `recommendsps` VALUES ('315', '1370145', 'MPM', 'WLSQ2', '208248', null, null, null);
INSERT INTO `recommendsps` VALUES ('316', '1370145', '申请人部门经理', 'WLSQ2', '525683', null, null, null);
INSERT INTO `recommendsps` VALUES ('317', '1370145', '经营管理部 物控科长', 'WLSQ2', '2614831', null, null, null);
INSERT INTO `recommendsps` VALUES ('318', '1370145', '经营管理部 经理', 'WLSQ2', '208248', null, null, null);
INSERT INTO `recommendsps` VALUES ('319', '1370145', '财务部经理', 'WLSQ2', '208248', null, null, null);
INSERT INTO `recommendsps` VALUES ('320', '1370145', '事业部总经理', 'WLSQ2', '525683', null, null, null);
INSERT INTO `recommendsps` VALUES ('321', '1370145', '下单人', 'WLSQ2', '1673938', null, null, null);
INSERT INTO `recommendsps` VALUES ('322', '1421981', '物控', 'WLSQ2', '1421981', null, null, null);
INSERT INTO `recommendsps` VALUES ('323', '1211488', '驳回', 'WLSQ3', '1211488', null, null, null);
INSERT INTO `recommendsps` VALUES ('324', '1211488', '专业PM', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('325', '1211488', '项目总工', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('326', '1211488', '项目PM', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('327', '1211488', 'PDM/DQA', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('328', '1211488', '商务交付/MPM', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('329', '1211488', '交付/物控科长', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('330', '1211488', '经营管理部 造价合约科', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('331', '1211488', '部门经理/总工', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('332', '1211488', '项目部经理', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('333', '1211488', '经营管理部经理', 'WLSQ3', '584223', null, null, null);
INSERT INTO `recommendsps` VALUES ('334', '1211488', '申请人部门经理', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('335', '1211488', '财务部经理', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('336', '1211488', '事业部总经理', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('337', '1211488', '下单人', 'WLSQ3', '1801033', null, null, null);
INSERT INTO `recommendsps` VALUES ('338', '35465', '物控', 'WLSQ2', '1673938', null, null, null);
INSERT INTO `recommendsps` VALUES ('339', 'admin', '物控工程师', 'wmsUnproductiveInWpo', '329325', '张军平', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('340', 'admin', '仓库主管', 'wmsUnproductiveInWpo', '1421981', '谢龙举', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('341', 'admin', '物控工程师', 'wmsUnproductiveInYpo', 'admin', '超级管理员', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('342', 'admin', '仓库主管', 'wmsUnproductiveInYpo', 'admin', '超级管理员', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('343', 'admin', '财务会计', 'wmsUnproductiveInYpo', 'admin', '超级管理员', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('344', 'admin', '输单员', 'wmsUnproductiveInYpo', 'admin', '超级管理员', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('345', 'admin', '施工队长', 'unproductiveOutProject', 'test1234', '测试', '施工队长', null);
INSERT INTO `recommendsps` VALUES ('346', 'admin', '工程负责人', 'unproductiveOutProject', 'test1234', '测试', '工程负责人', null);
INSERT INTO `recommendsps` VALUES ('347', 'admin', '物资管理员', 'unproductiveOutProject', 'test1234', '测试', '物资管理员', null);
INSERT INTO `recommendsps` VALUES ('348', 'admin', '物控工程师', 'wmsTransfer2T0', 'admin', '超级管理员', '物控工程师', '{转出仓库管理=wms:warehouse:2, 转入仓库管理=wms:warehouse:7}');
INSERT INTO `recommendsps` VALUES ('349', 'admin', '仓库主管', 'wmsTransfer2T0', 'admin', '超级管理员', '*权限：[转出仓库管理]', '{转出仓库管理=wms:warehouse:2, 转入仓库管理=wms:warehouse:7}');
INSERT INTO `recommendsps` VALUES ('350', 'admin', '财务会计', 'wmsTransfer2T0', 'admin', '超级管理员', '财务会计', '{转出仓库管理=wms:warehouse:2, 转入仓库管理=wms:warehouse:7}');
INSERT INTO `recommendsps` VALUES ('351', 'admin', '输单员', 'wmsTransfer2T0', 'admin', '超级管理员', '输单员', '{转出仓库管理=wms:warehouse:2, 转入仓库管理=wms:warehouse:7}');
INSERT INTO `recommendsps` VALUES ('352', '1421981', '物控工程师', 'wmsUnproductiveInYpo', '1421981', '谢龙举', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('353', '1421981', '仓库主管', 'wmsUnproductiveInYpo', '1421981', '谢龙举', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('354', '1421981', '财务会计', 'wmsUnproductiveInYpo', '1421981', '谢龙举', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('355', '1421981', '输单员', 'wmsUnproductiveInYpo', '1421981', '谢龙举', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('356', 'admin', '申请人主管', 'wmsCostOut', 'admin', '超级管理员', '物控工程师', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('357', 'admin', '项目经理', 'wmsCostOut', 'admin', '超级管理员', '项目经理', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('358', 'admin', '仓库主管', 'wmsCostOut', 'admin', '超级管理员', '*角色：[仓库地区]仓库管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('359', 'admin', '输单员', 'wmsCostOut', 'admin', '超级管理员', '输单员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('360', 'admin', '施工队长', 'wmsUnproductiveOut', 'admin', '超级管理员', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('361', 'admin', '工程负责人', 'wmsUnproductiveOut', 'admin', '超级管理员', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('362', 'admin', '物资管理员', 'wmsUnproductiveOut', 'admin', '超级管理员', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('363', 'admin', '物控工程师', 'wmsListOutStockPo', 'admin', '超级管理员', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('364', 'admin', '申请人主管', 'wmsListOutStockPo', 'admin', '超级管理员', '申请人主管', '');
INSERT INTO `recommendsps` VALUES ('365', 'admin', '财务会计', 'wmsListOutStockPo', 'admin', '超级管理员', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('366', 'admin', '物资管理员', 'wmsListOutStockPo', 'admin', '超级管理员', '*权限：物资管理员', '');
INSERT INTO `recommendsps` VALUES ('367', 'admin', '输单员', 'wmsListOutStockPo', 'admin', '超级管理员', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('368', 'admin', '输单员', 'wmsPoReceive103', 'admin', '超级管理员', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('369', 'admin', 'IQC品质负责人', 'wmsPoStore105', 'admin', '超级管理员', 'IQC品质负责人', '');
INSERT INTO `recommendsps` VALUES ('370', 'admin', '输单员', 'wmsPoStore105', 'admin', '超级管理员', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('371', 'admin', '物控/商务', 'wmsVoucherReturn124', 'admin', '超级管理员', '物控/商务', '');
INSERT INTO `recommendsps` VALUES ('372', 'admin', '采购', 'wmsVoucherReturn124', 'admin', '超级管理员', '采购', '');
INSERT INTO `recommendsps` VALUES ('373', 'admin', '仓库主管', 'wmsVoucherReturn124', 'admin', '超级管理员', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('374', 'admin', '输单员', 'wmsVoucherReturn124', 'admin', '超级管理员', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('375', 'admin', '物控工程师', 'wmsTransfer0T0', 'admin', '超级管理员', '物控工程师', '{转出仓库管理=wms:warehouse:D036, 转入仓库管理=wms:warehouse:0050}');
INSERT INTO `recommendsps` VALUES ('376', 'admin', '仓库主管', 'wmsTransfer0T0', 'admin', '超级管理员', '*权限：[转出仓库管理]', '{转出仓库管理=wms:warehouse:D036, 转入仓库管理=wms:warehouse:0050}');
INSERT INTO `recommendsps` VALUES ('377', 'admin', '财务会计', 'wmsTransfer0T0', 'admin', '超级管理员', '财务会计', '{转出仓库管理=wms:warehouse:D036, 转入仓库管理=wms:warehouse:0050}');
INSERT INTO `recommendsps` VALUES ('378', 'admin', '输单员', 'wmsTransfer0T0', 'admin', '超级管理员', '输单员', '{转出仓库管理=wms:warehouse:D036, 转入仓库管理=wms:warehouse:0050}');
INSERT INTO `recommendsps` VALUES ('379', '2864323', '驳回', 'WLSQ1', '2864323', null, null, null);
INSERT INTO `recommendsps` VALUES ('380', '2864323', '工程负责人', 'WLSQ1', 'admin', null, null, null);
INSERT INTO `recommendsps` VALUES ('381', '2864323', '申请人科长', 'WLSQ1', '9986', null, null, null);
INSERT INTO `recommendsps` VALUES ('382', '2864323', '专业PM', 'WLSQ1', 'admin', null, null, null);
INSERT INTO `recommendsps` VALUES ('383', '2864323', '总工', 'WLSQ1', '282194', null, null, null);
INSERT INTO `recommendsps` VALUES ('384', '2864323', '项目经理', 'WLSQ1', '1027755', null, null, null);
INSERT INTO `recommendsps` VALUES ('385', '2864323', '申请人部门经理', 'WLSQ1', '543387', null, null, null);
INSERT INTO `recommendsps` VALUES ('386', '2864323', '财务会计', 'WLSQ1', '2898665', null, null, null);
INSERT INTO `recommendsps` VALUES ('387', '2864323', '财务部经理', 'WLSQ1', '339831', null, null, null);
INSERT INTO `recommendsps` VALUES ('388', '2864323', '事业部总经理', 'WLSQ1', '4177', null, null, null);
INSERT INTO `recommendsps` VALUES ('389', '2864323', '下单人', 'WLSQ1', '2864323', null, null, null);
INSERT INTO `recommendsps` VALUES ('390', 'admin', '物控/商务', 'wmsPoReturn161', 'admin', '超级管理员', '物控/商务', '');
INSERT INTO `recommendsps` VALUES ('391', 'admin', '采购', 'wmsPoReturn161', 'admin', '超级管理员', '采购', '');
INSERT INTO `recommendsps` VALUES ('392', 'admin', '仓库主管', 'wmsPoReturn161', 'admin', '超级管理员', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('393', 'admin', '输单员', 'wmsPoReturn161', 'admin', '超级管理员', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('394', 'admin', '物控', 'wmsCostTransfer', 'admin', '超级管理员', '物控', '');
INSERT INTO `recommendsps` VALUES ('395', 'admin', '申请人主管', 'wmsCostTransfer', 'admin', '超级管理员', '申请人主管', '');
INSERT INTO `recommendsps` VALUES ('396', 'admin', '转入仓库仓管员', 'wmsCostTransfer', 'admin', '超级管理员', '*权限：转入仓库仓管员', '');
INSERT INTO `recommendsps` VALUES ('397', 'admin', '输单员', 'wmsCostTransfer', 'admin', '超级管理员', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('398', 'admin', '施工队长', 'wmsBackInStore', 'admin', '超级管理员', '施工队长', '');
INSERT INTO `recommendsps` VALUES ('399', 'admin', '工程负责人', 'wmsBackInStore', 'admin', '超级管理员', '工程负责人', '');
INSERT INTO `recommendsps` VALUES ('400', 'admin', '物资管理员', 'wmsBackInStore', 'admin', '超级管理员', '*角色：[仓库地区]物资管理员', '');
INSERT INTO `recommendsps` VALUES ('401', 'admin', '品质', 'wmsCostBack', 'admin', '超级管理员', '品质', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('402', 'admin', '申请人主管', 'wmsCostBack', 'admin', '超级管理员', '申请人主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('403', 'admin', '物控/商务', 'wmsCostBack', 'admin', '超级管理员', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('404', 'admin', '财务', 'wmsCostBack', 'admin', '超级管理员', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('405', 'admin', '仓库主管', 'wmsCostBack', 'admin', '超级管理员', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('406', 'admin', '仓管员', 'wmsCostBack', 'admin', '超级管理员', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('407', 'admin', '输单员', 'wmsCostBack', 'admin', '超级管理员', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('408', '329325', '物控工程师', 'wmsUnproductiveInYpo', '329325', '张军平', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('409', '329325', '仓库主管', 'wmsUnproductiveInYpo', '329325', '张军平', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('410', '329325', '财务会计', 'wmsUnproductiveInYpo', '329325', '张军平', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('411', '329325', '输单员', 'wmsUnproductiveInYpo', '329325', '张军平', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('412', '702116', '填写申请单', 'wmsPoReceive103', '702116', '洪雪敏', '${initiator}', '');
INSERT INTO `recommendsps` VALUES ('413', '702116', '输单员', 'wmsPoReceive103', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('414', '1421981', '输单员', 'wmsPoReceive103', '1421981', '谢龙举', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('415', '1421981', 'IQC品质负责人', 'wmsPoStore105', '1421981', '谢龙举', 'IQC品质负责人', '');
INSERT INTO `recommendsps` VALUES ('416', '1421981', '输单员', 'wmsPoStore105', '1421981', '谢龙举', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('417', '702116', 'IQC品质负责人', 'wmsPoStore105', '1843641', '蒋万小', 'IQC品质负责人', '');
INSERT INTO `recommendsps` VALUES ('418', '702116', '输单员', 'wmsPoStore105', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('419', '702116', '物控/商务', 'wmsPoReturn161', '1673938', '桂云霞', '物控/商务', '');
INSERT INTO `recommendsps` VALUES ('420', '702116', '采购', 'wmsPoReturn161', '49703', '尹倩', '采购', '');
INSERT INTO `recommendsps` VALUES ('421', '702116', '仓库主管', 'wmsPoReturn161', '254613', '荆顺昌', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('422', '702116', '输单员', 'wmsPoReturn161', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('423', '1042059', '物控工程师', 'wmsUnproductiveInYpo', '329325', '张军平', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('424', '1042059', '仓库主管', 'wmsUnproductiveInYpo', '254613', '荆顺昌', '仓库主管', '');
INSERT INTO `recommendsps` VALUES ('425', '1042059', '财务会计', 'wmsUnproductiveInYpo', '340140', '赵丽君', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('426', '1042059', '输单员', 'wmsUnproductiveInYpo', 'admin', '超级管理员', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('427', '2903447', '物控工程师', 'wmsUnproductiveInYpo', '329325', '张军平', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('428', '2903447', '仓库主管', 'wmsUnproductiveInYpo', '254613', '荆顺昌', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('429', '2903447', '财务会计', 'wmsUnproductiveInYpo', '2898665', '柴新燕', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('430', '2903447', '输单员', 'wmsUnproductiveInYpo', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('431', '2897608', '物控工程师', 'wmsUnproductiveInYpo', '329325', '张军平', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('432', '2897608', '仓库主管', 'wmsUnproductiveInYpo', '254613', '荆顺昌', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('433', '2897608', '财务会计', 'wmsUnproductiveInYpo', '2898665', '柴新燕', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('434', '2897608', '输单员', 'wmsUnproductiveInYpo', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('435', '1421981', '物控工程师', 'wmsUnproductiveInWpo', '1421981', '谢龙举', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('436', '1421981', '仓库主管', 'wmsUnproductiveInWpo', '1421981', '谢龙举', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('437', '1421981', '施工队长', 'wmsUnproductiveOut', '1421981', '谢龙举', '施工队长', '{仓库地区=济宁}');
INSERT INTO `recommendsps` VALUES ('438', '1421981', '工程负责人', 'wmsUnproductiveOut', '1421981', '谢龙举', '工程负责人', '{仓库地区=济宁}');
INSERT INTO `recommendsps` VALUES ('439', '1421981', '物资管理员', 'wmsUnproductiveOut', '1421981', '谢龙举', '*角色：[仓库地区]物资管理员', '{仓库地区=济宁}');
INSERT INTO `recommendsps` VALUES ('440', '1421981', '调出工程负责人', 'wmsTransfer0T0', '1421981', '谢龙举', '调出工程负责人', '{转出仓库管理=wms:warehouse:D033, 转入仓库管理=wms:warehouse:D035}');
INSERT INTO `recommendsps` VALUES ('441', '1421981', '调入工程负责人', 'wmsTransfer0T0', '1421981', '谢龙举', '调入工程负责人', '{转出仓库管理=wms:warehouse:D033, 转入仓库管理=wms:warehouse:D035}');
INSERT INTO `recommendsps` VALUES ('442', '1421981', '仓库主管', 'wmsTransfer0T0', '1421981', '谢龙举', '*权限：仓库主管', '{转出仓库管理=wms:warehouse:D033, 转入仓库管理=wms:warehouse:D035}');
INSERT INTO `recommendsps` VALUES ('443', '1421981', '接收仓库负责人', 'wmsTransfer0T0', '1421981', '谢龙举', '*权限：[转入仓库管理]', '{转出仓库管理=wms:warehouse:D033, 转入仓库管理=wms:warehouse:D035}');
INSERT INTO `recommendsps` VALUES ('444', '1421981', '物控/商务', 'wmsVoucherReturn124', '1421981', '谢龙举', '物控/商务', '');
INSERT INTO `recommendsps` VALUES ('445', '1421981', '采购', 'wmsVoucherReturn124', '1421981', '谢龙举', '采购', '');
INSERT INTO `recommendsps` VALUES ('446', '1421981', '仓库主管', 'wmsVoucherReturn124', '1421981', '谢龙举', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('447', '1421981', '输单员', 'wmsVoucherReturn124', '1421981', '谢龙举', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('448', '1421981', '申请人主管', 'wmsCostOut', '1421981', '谢龙举', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('449', '1421981', '项目经理', 'wmsCostOut', '1421981', '谢龙举', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('450', '1421981', '仓库主管', 'wmsCostOut', '1421981', '谢龙举', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('451', '1421981', '输单员', 'wmsCostOut', '1421981', '谢龙举', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('452', '702116', '物控/商务', 'wmsVoucherReturn124', '1673938', '桂云霞', '物控/商务', '');
INSERT INTO `recommendsps` VALUES ('453', '702116', '采购', 'wmsVoucherReturn124', '49703', '尹倩', '采购', '');
INSERT INTO `recommendsps` VALUES ('454', '702116', '仓库主管', 'wmsVoucherReturn124', '254613', '荆顺昌', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('455', '702116', '输单员', 'wmsVoucherReturn124', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('456', '702116', '申请人主管', 'wmsCostOut', '702116', '洪雪敏', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('457', '702116', '项目经理', 'wmsCostOut', '702116', '洪雪敏', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('458', '702116', '仓库主管', 'wmsCostOut', '702116', '洪雪敏', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('459', '702116', '输单员', 'wmsCostOut', '702116', '洪雪敏', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('460', '702116', '品质', 'wmsCostBack', '702116', '洪雪敏', '品质', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('461', '702116', '申请人主管', 'wmsCostBack', '702116', '洪雪敏', '申请人主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('462', '702116', '物控/商务', 'wmsCostBack', '702116', '洪雪敏', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('463', '702116', '财务', 'wmsCostBack', '702116', '洪雪敏', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('464', '702116', '仓库主管', 'wmsCostBack', '702116', '洪雪敏', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('465', '702116', '仓管员', 'wmsCostBack', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('466', '702116', '输单员', 'wmsCostBack', '702116', '洪雪敏', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('467', '1421981', '物控/商务', 'wmsCostOut', '1421981', '谢龙举', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('468', '1421981', '财务', 'wmsCostOut', '1421981', '谢龙举', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('469', '1421981', '仓管员', 'wmsCostOut', '1421981', '谢龙举', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('470', '1421981', '领料人', 'wmsCostOut', '1421981', '谢龙举', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('471', '1421981', '保密员', 'wmsCostOut', '', '', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('472', '1421981', '物控工程师', 'wmsListOutStockPo', '1421981', '谢龙举', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('473', '1421981', '申请人主管', 'wmsListOutStockPo', '1421981', '谢龙举', '申请人主管', '');
INSERT INTO `recommendsps` VALUES ('474', '1421981', '财务会计', 'wmsListOutStockPo', '1421981', '谢龙举', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('475', '1421981', '物资管理员', 'wmsListOutStockPo', '1421981', '谢龙举', '*权限：物资管理员', '');
INSERT INTO `recommendsps` VALUES ('476', '1421981', '输单员', 'wmsListOutStockPo', '1421981', '谢龙举', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('477', '1421981', '施工队长', 'wmsBackInStore', '1421981', '谢龙举', '施工队长', '');
INSERT INTO `recommendsps` VALUES ('478', '1421981', '工程负责人', 'wmsBackInStore', '1421981', '谢龙举', '工程负责人', '');
INSERT INTO `recommendsps` VALUES ('479', '1421981', '物资管理员', 'wmsBackInStore', '2903447', '韩龙龙', '*角色：[仓库地区]物资管理员', '');
INSERT INTO `recommendsps` VALUES ('480', '2770857', '物控工程师', 'wmsUnproductiveInWpo', '329325', '张军平', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('481', '2770857', '仓库主管', 'wmsUnproductiveInWpo', '254613', '荆顺昌', '*权限：仓库管理', '');
INSERT INTO `recommendsps` VALUES ('482', '2770857', '物控工程师', 'wmsUnproductiveInYpo', '329325', '张军平', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('483', '2770857', '仓库主管', 'wmsUnproductiveInYpo', '254613', '荆顺昌', '*权限：仓库管理', '');
INSERT INTO `recommendsps` VALUES ('484', '2770857', '财务会计', 'wmsUnproductiveInYpo', '1421981', '谢龙举', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('485', '2770857', '输单员', 'wmsUnproductiveInYpo', '2903447', '韩龙龙', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('486', '1421981', '施工队长', 'wmsTransfer0T2', '1421981', '谢龙举', '物控工程师', '{转出仓库管理=wms:warehouse:D035, 转入仓库管理=wms:warehouse:weixiu}');
INSERT INTO `recommendsps` VALUES ('487', '1421981', '工程主管', 'wmsTransfer0T2', '1421981', '谢龙举', '工程主管', '{转出仓库管理=wms:warehouse:D035, 转入仓库管理=wms:warehouse:weixiu}');
INSERT INTO `recommendsps` VALUES ('488', '1421981', '仓库主管', 'wmsTransfer0T2', '1421981', '谢龙举', '*权限：仓库主管', '{转出仓库管理=wms:warehouse:D035, 转入仓库管理=wms:warehouse:weixiu}');
INSERT INTO `recommendsps` VALUES ('489', '1421981', '物控工程师', 'wmsTransfer0T2', '1421981', '谢龙举', '物控工程师', '{转出仓库管理=wms:warehouse:D035, 转入仓库管理=wms:warehouse:weixiu}');
INSERT INTO `recommendsps` VALUES ('490', '1421981', '接收仓库负责人', 'wmsTransfer0T2', '1421981', '谢龙举', '*权限：[转入仓库管理]', '{转出仓库管理=wms:warehouse:D035, 转入仓库管理=wms:warehouse:weixiu}');
INSERT INTO `recommendsps` VALUES ('491', '1421981', '专业工程师', 'wmsTransfer2T3', '1421981', '谢龙举', '专业工程师', '{转出仓库管理=wms:warehouse:weixiu, 转入仓库管理=wms:warehouse:baofei}');
INSERT INTO `recommendsps` VALUES ('492', '1421981', '工程经理', 'wmsTransfer2T3', '1421981', '谢龙举', '工程经理', '{转出仓库管理=wms:warehouse:weixiu, 转入仓库管理=wms:warehouse:baofei}');
INSERT INTO `recommendsps` VALUES ('493', '1421981', '仓库主管', 'wmsTransfer2T3', '1421981', '谢龙举', '*权限：仓库主管', '{转出仓库管理=wms:warehouse:weixiu, 转入仓库管理=wms:warehouse:baofei}');
INSERT INTO `recommendsps` VALUES ('494', '1421981', '物控工程师', 'wmsTransfer2T3', '1421981', '谢龙举', '物控工程师', '{转出仓库管理=wms:warehouse:weixiu, 转入仓库管理=wms:warehouse:baofei}');
INSERT INTO `recommendsps` VALUES ('495', '1421981', '接收仓库负责人', 'wmsTransfer2T3', '1421981', '谢龙举', '*权限:[转入仓库管理]', '{转出仓库管理=wms:warehouse:weixiu, 转入仓库管理=wms:warehouse:baofei}');
INSERT INTO `recommendsps` VALUES ('496', '1421981', '物控', 'wmsCostTransfer', '1421981', '谢龙举', '物控', '');
INSERT INTO `recommendsps` VALUES ('497', '1421981', '申请人主管', 'wmsCostTransfer', '1421981', '谢龙举', '申请人主管', '');
INSERT INTO `recommendsps` VALUES ('498', '1421981', '转入仓库仓管员', 'wmsCostTransfer', '1421981', '谢龙举', '*权限：转入仓库仓管员', '');
INSERT INTO `recommendsps` VALUES ('499', '1421981', '输单员', 'wmsCostTransfer', '1421981', '谢龙举', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('500', '2903447', '物控工程师', 'wmsUnproductiveInWpo', '329325', '张军平', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('501', '2903447', '仓库主管', 'wmsUnproductiveInWpo', '254613', '荆顺昌', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('502', '2903447', '填写申请单', 'wmsUnproductiveInWpo', '2903447', '韩龙龙', '${initiator}', '');
INSERT INTO `recommendsps` VALUES ('503', '2866153', '输单员', 'wmsPoReceive103', '2866153', '赵洪达', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('504', '2866153', '物控工程师', 'wmsUnproductiveInYpo', '2866153', '赵洪达', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('505', '2866153', '仓库主管', 'wmsUnproductiveInYpo', '2866153', '赵洪达', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('506', '2866153', '财务会计', 'wmsUnproductiveInYpo', '2866153', '赵洪达', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('507', '2866153', '输单员', 'wmsUnproductiveInYpo', '2866153', '赵洪达', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('508', '1421981', '物控/商务', 'wmsPoReturn161', '1421981', '谢龙举', '物控/商务', '');
INSERT INTO `recommendsps` VALUES ('509', '1421981', '采购', 'wmsPoReturn161', '1421981', '谢龙举', '采购', '');
INSERT INTO `recommendsps` VALUES ('510', '1421981', '仓库主管', 'wmsPoReturn161', '1421981', '谢龙举', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('511', '1421981', '输单员', 'wmsPoReturn161', '1421981', '谢龙举', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('512', '2003391', '申请人主管', 'wmsCostOut', '1576887', '尹鹏', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('513', '2003391', '项目经理', 'wmsCostOut', '457308', '王嵩昊', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('514', '2003391', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('515', '2003391', '物控/商务', 'wmsCostOut', '1673938', '桂云霞', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('516', '2003391', '财务', 'wmsCostOut', '2473734', '侯茜婕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('517', '2003391', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('518', '2003391', '领料人', 'wmsCostOut', '2003391', '吴志威', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('519', '2003391', '保密员', 'wmsCostOut', '', '', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('520', '2003391', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('521', '2598895', '输单员', 'wmsPoReceive103', '2598895', '覃泰盛', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('522', '2903447', '施工队长', 'wmsUnproductiveOut', '2864323', '赵增新', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('523', '2903447', '工程负责人', 'wmsUnproductiveOut', '254613', '荆顺昌', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('524', '2903447', '物资管理员', 'wmsUnproductiveOut', '1330047', '缪军', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('525', '1421981', '品质', 'wmsCostBack', '1421981', '谢龙举', '品质', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('526', '1421981', '申请人主管', 'wmsCostBack', '1421981', '谢龙举', '申请人主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('527', '1421981', '物控/商务', 'wmsCostBack', '1421981', '谢龙举', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('528', '1421981', '财务', 'wmsCostBack', '1421981', '谢龙举', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('529', '1421981', '仓库主管', 'wmsCostBack', '1421981', '谢龙举', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('530', '1421981', '仓管员', 'wmsCostBack', '1421981', '谢龙举', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('531', '1421981', '输单员', 'wmsCostBack', '1421981', '谢龙举', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('532', '329325', '施工队长', 'wmsUnproductiveOut', '329325', '张军平', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('533', '329325', '工程负责人', 'wmsUnproductiveOut', '329325', '张军平', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('534', '329325', '物资管理员', 'wmsUnproductiveOut', '329325', '张军平', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('535', '329325', '物控工程师', 'wmsUnproductiveInWpo', '329325', '张军平', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('536', '329325', '仓库主管', 'wmsUnproductiveInWpo', '329325', '张军平', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('537', '2903447', '施工队长', 'wmsBackInStore', '2903447', '韩龙龙', '施工队长', '');
INSERT INTO `recommendsps` VALUES ('538', '2903447', '工程负责人', 'wmsBackInStore', '2903447', '韩龙龙', '工程负责人', '');
INSERT INTO `recommendsps` VALUES ('539', '2903447', '物资管理员', 'wmsBackInStore', '2903447', '韩龙龙', '*角色：[仓库地区]物资管理员', '');
INSERT INTO `recommendsps` VALUES ('540', '2903447', '调出工程负责人', 'wmsTransfer0T0', '329325', '张军平', '调出工程负责人', '{转出仓库管理=wms:warehouse:D033, 转入仓库管理=wms:warehouse:D036}');
INSERT INTO `recommendsps` VALUES ('541', '2903447', '调入工程负责人', 'wmsTransfer0T0', '2767053', '宫瑞祥', '调入工程负责人', '{转出仓库管理=wms:warehouse:D033, 转入仓库管理=wms:warehouse:D036}');
INSERT INTO `recommendsps` VALUES ('542', '2903447', '仓库主管', 'wmsTransfer0T0', '254613', '荆顺昌', '*权限：仓库主管', '{转出仓库管理=wms:warehouse:D033, 转入仓库管理=wms:warehouse:D036}');
INSERT INTO `recommendsps` VALUES ('543', '2903447', '接收仓库负责人', 'wmsTransfer0T0', '2897608', '李进', '*权限：[转入仓库管理]', '{转出仓库管理=wms:warehouse:D033, 转入仓库管理=wms:warehouse:D036}');
INSERT INTO `recommendsps` VALUES ('544', '1042059', '物控工程师', 'wmsUnproductiveInWpo', '702116', '洪雪敏', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('545', '1042059', '仓库主管', 'wmsUnproductiveInWpo', '702116', '洪雪敏', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('546', '1330047', '物控工程师', 'wmsUnproductiveInYpo', '329325', '张军平', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('547', '1330047', '仓库主管', 'wmsUnproductiveInYpo', '254613', '荆顺昌', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('548', '1330047', '财务会计', 'wmsUnproductiveInYpo', '2473734', '侯茜婕', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('549', '1330047', '输单员', 'wmsUnproductiveInYpo', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('550', '254613', '输单员', 'wmsPoReceive103', '254613', '荆顺昌', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('551', '254613', 'IQC品质负责人', 'wmsPoStore105', '254613', '荆顺昌', 'IQC品质负责人', '');
INSERT INTO `recommendsps` VALUES ('552', '254613', '输单员', 'wmsPoStore105', '254613', '荆顺昌', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('553', '2003391', '品质', 'wmsCostBack', '2394215', '雷敬', '品质', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('554', '2003391', '申请人主管', 'wmsCostBack', '1576887', '尹鹏', '申请人主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('555', '2003391', '物控/商务', 'wmsCostBack', '1673938', '桂云霞', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('556', '2003391', '财务', 'wmsCostBack', '2898665', '柴新燕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('557', '2003391', '仓库主管', 'wmsCostBack', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('558', '2003391', '仓管员', 'wmsCostBack', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('559', '2003391', '输单员', 'wmsCostBack', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('560', '702116', '物控', 'wmsCostTransfer', '1200437', '路丽萍', '物控', '');
INSERT INTO `recommendsps` VALUES ('561', '702116', '申请人主管', 'wmsCostTransfer', '254613', '荆顺昌', '申请人主管', '');
INSERT INTO `recommendsps` VALUES ('562', '702116', '转入仓库仓管员', 'wmsCostTransfer', '2897608', '李进', '*权限：[转入仓库管理]', '');
INSERT INTO `recommendsps` VALUES ('563', '702116', '输单员', 'wmsCostTransfer', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('564', '329325', '调出工程负责人', 'wmsTransfer0T0', '329325', '张军平', '调出工程负责人', '{转出仓库管理=wms:warehouse:D033, 转入仓库管理=wms:warehouse:D034}');
INSERT INTO `recommendsps` VALUES ('565', '329325', '调入工程负责人', 'wmsTransfer0T0', '329325', '张军平', '调入工程负责人', '{转出仓库管理=wms:warehouse:D033, 转入仓库管理=wms:warehouse:D034}');
INSERT INTO `recommendsps` VALUES ('566', '329325', '仓库主管', 'wmsTransfer0T0', '329325', '张军平', '*权限：仓库主管', '{转出仓库管理=wms:warehouse:D033, 转入仓库管理=wms:warehouse:D034}');
INSERT INTO `recommendsps` VALUES ('567', '329325', '接收仓库负责人', 'wmsTransfer0T0', '329325', '张军平', '*权限：[转入仓库管理]', '{转出仓库管理=wms:warehouse:D033, 转入仓库管理=wms:warehouse:D034}');
INSERT INTO `recommendsps` VALUES ('568', '2903447', '输单员', 'wmsPoReceive103', '702116', '洪雪敏', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('569', '702116', '物控/商务', 'wmsCostOut', '702116', '洪雪敏', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('570', '702116', '财务', 'wmsCostOut', '702116', '洪雪敏', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('571', '702116', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('572', '702116', '领料人', 'wmsCostOut', '702116', '洪雪敏', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('573', '702116', '保密员', 'wmsCostOut', '702116', '洪雪敏', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('574', '2339746', '申请人主管', 'wmsCostOut', '2748672', '赵波', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('575', '2339746', '项目经理', 'wmsCostOut', '457308', '王嵩昊', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('576', '2339746', '物控/商务', 'wmsCostOut', '1200437', '路丽萍', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('577', '2339746', '财务', 'wmsCostOut', '2898665', '柴新燕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('578', '2339746', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('579', '2339746', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('580', '2339746', '领料人', 'wmsCostOut', '2711637', '罗曙', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('581', '2339746', '保密员', 'wmsCostOut', '', '', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('582', '2339746', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('583', '2598895', '施工队长', 'wmsUnproductiveOut', '329325', '张军平', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('584', '2598895', '工程负责人', 'wmsUnproductiveOut', '254613', '荆顺昌', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('585', '2598895', '物资管理员', 'wmsUnproductiveOut', '1330047', '缪军', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('586', '3115994', '申请人主管', 'wmsCostOut', '1200437', '路丽萍', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('587', '3115994', '项目经理', 'wmsCostOut', '2887794', '董振忠', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('588', '3115994', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('589', '3115994', '物控/商务', 'wmsCostOut', '3115994', '彭艳红', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('590', '3115994', '财务', 'wmsCostOut', '2898665', '柴新燕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('591', '3115994', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('592', '3115994', '领料人', 'wmsCostOut', '2336568', '李志强', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('593', '3115994', '保密员', 'wmsCostOut', '', '', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('594', '3115994', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('595', '2567018', '申请人主管', 'wmsCostOut', '1815686', '吴洪文', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('596', '2567018', '项目经理', 'wmsCostOut', '66006', '左晓兵', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('597', '2567018', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('598', '2567018', '物控/商务', 'wmsCostOut', '1673938', '桂云霞', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('599', '2567018', '财务', 'wmsCostOut', '2898665', '柴新燕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('600', '2567018', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('601', '2567018', '领料人', 'wmsCostOut', '2056227', '任海涛', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('602', '2567018', '保密员', 'wmsCostOut', '2455205', '陈小红', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('603', '2567018', '输单员', 'wmsCostOut', '2898665', '柴新燕', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('604', '2034722', '申请人主管', 'wmsCostOut', '202473', '谭新艳', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('605', '2034722', '项目经理', 'wmsCostOut', '457308', '王嵩昊', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('606', '2034722', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('607', '2034722', '物控/商务', 'wmsCostOut', '1673938', '桂云霞', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('608', '2034722', '财务', 'wmsCostOut', '2898665', '柴新燕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('609', '2034722', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('610', '2034722', '领料人', 'wmsCostOut', '2003391', '吴志威', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('611', '2034722', '保密员', 'wmsCostOut', '', '', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('612', '2034722', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('613', '3134906', '驳回', 'WLSQ2', '3134906', null, null, null);
INSERT INTO `recommendsps` VALUES ('614', '3134906', '申请人科长', 'WLSQ2', '2058107', null, null, null);
INSERT INTO `recommendsps` VALUES ('615', '3134906', '总工', 'WLSQ2', '2964551', null, null, null);
INSERT INTO `recommendsps` VALUES ('616', '3134906', '项目经理', 'WLSQ2', '2707235', null, null, null);
INSERT INTO `recommendsps` VALUES ('617', '3134906', '申请人部门经理', 'WLSQ2', '66006', null, null, null);
INSERT INTO `recommendsps` VALUES ('618', '3134906', '物控', 'WLSQ2', '1826801', null, null, null);
INSERT INTO `recommendsps` VALUES ('619', '3134906', '经营管理部 物控科长', 'WLSQ2', '2614831', null, null, null);
INSERT INTO `recommendsps` VALUES ('620', '3134906', '经营管理部 经理', 'WLSQ2', '384284', null, null, null);
INSERT INTO `recommendsps` VALUES ('621', '3134906', '财务部经理', 'WLSQ2', '339831', null, null, null);
INSERT INTO `recommendsps` VALUES ('622', '3134906', '事业部总经理', 'WLSQ2', '4177', null, null, null);
INSERT INTO `recommendsps` VALUES ('623', '3134906', '下单人', 'WLSQ2', '3134906', null, null, null);
INSERT INTO `recommendsps` VALUES ('624', '1330047', '施工队长', 'wmsUnproductiveOut', '2640265', '张恒', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('625', '1330047', '工程负责人', 'wmsUnproductiveOut', '1037492', '张海柱', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('626', '1330047', '物资管理员', 'wmsUnproductiveOut', '1330047', '缪军', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('627', '1107068', '施工队长', 'wmsUnproductiveOut', '2640265', '张恒', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('628', '1107068', '工程负责人', 'wmsUnproductiveOut', '2640265', '张恒', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('629', '1107068', '物资管理员', 'wmsUnproductiveOut', '2903447', '韩龙龙', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('630', '1882561', '物控工程师', 'wmsListOutStockPo', '2864323', '赵增新', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('631', '1882561', '申请人主管', 'wmsListOutStockPo', '579966', '刘阳', '申请人主管', '');
INSERT INTO `recommendsps` VALUES ('632', '1882561', '财务会计', 'wmsListOutStockPo', '2898665', '柴新燕', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('633', '1882561', '物资管理员', 'wmsListOutStockPo', '2903447', '韩龙龙', '*权限：物资管理员', '');
INSERT INTO `recommendsps` VALUES ('634', '1882561', '输单员', 'wmsListOutStockPo', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('635', '1061247', '申请人主管', 'wmsCostOut', '579966', '刘阳', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('636', '1061247', '项目经理', 'wmsCostOut', '2715702', '刘建章', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('637', '1061247', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('638', '1061247', '物控/商务', 'wmsCostOut', '1673938', '桂云霞', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('639', '1061247', '财务', 'wmsCostOut', '2473734', '侯茜婕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('640', '1061247', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('641', '1061247', '领料人', 'wmsCostOut', '1061247', '刘根荣', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('642', '1061247', '保密员', 'wmsCostOut', '', '', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('643', '1061247', '输单员', 'wmsCostOut', '2898665', '柴新燕', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('644', '2653083', '申请人主管', 'wmsCostOut', '2665593', '顾倍铭', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('645', '2653083', '项目经理', 'wmsCostOut', '457308', '王嵩昊', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('646', '2653083', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('647', '2653083', '物控/商务', 'wmsCostOut', '1200437', '路丽萍', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('648', '2653083', '财务', 'wmsCostOut', '2898665', '柴新燕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('649', '2653083', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('650', '2653083', '领料人', 'wmsCostOut', '2653083', '陈付', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('651', '2653083', '保密员', 'wmsCostOut', '2455205', '陈小红', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('652', '2653083', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('653', '1767302', '申请人主管', 'wmsCostOut', '579966', '刘阳', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('654', '1767302', '项目经理', 'wmsCostOut', '202473', '谭新艳', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('655', '1767302', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('656', '1767302', '物控/商务', 'wmsCostOut', '1673938', '桂云霞', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('657', '1767302', '财务', 'wmsCostOut', '2898665', '柴新燕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('658', '1767302', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('659', '1767302', '领料人', 'wmsCostOut', '423899', '王玉林', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('660', '1767302', '保密员', 'wmsCostOut', '2455205', '陈小红', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('661', '1767302', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('662', '395472', '申请人主管', 'wmsCostOut', '1815686', '吴洪文', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('663', '395472', '项目经理', 'wmsCostOut', '2065909', '潘园园', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('664', '395472', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('665', '395472', '物控/商务', 'wmsCostOut', '1673938', '桂云霞', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('666', '395472', '财务', 'wmsCostOut', '2473734', '侯茜婕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('667', '395472', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('668', '395472', '领料人', 'wmsCostOut', '395472', '肖凡', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('669', '395472', '保密员', 'wmsCostOut', '', '', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('670', '395472', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('671', '1200437', '申请人主管', 'wmsCostOut', '2614831', '李昕', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('672', '1200437', '项目经理', 'wmsCostOut', '457308', '王嵩昊', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('673', '1200437', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('674', '1200437', '物控/商务', 'wmsCostOut', '1200437', '路丽萍', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('675', '1200437', '财务', 'wmsCostOut', '2473734', '侯茜婕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('676', '1200437', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('677', '1200437', '领料人', 'wmsCostOut', '1200437', '路丽萍', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('678', '1200437', '保密员', 'wmsCostOut', '', '', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('679', '1200437', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('680', '2715702', '申请人主管', 'wmsCostOut', '66006', '左晓兵', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('681', '2715702', '项目经理', 'wmsCostOut', '457308', '王嵩昊', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('682', '2715702', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('683', '2715702', '物控/商务', 'wmsCostOut', '1200437', '路丽萍', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('684', '2715702', '财务', 'wmsCostOut', '2898665', '柴新燕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('685', '2715702', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('686', '2715702', '领料人', 'wmsCostOut', '2640265', '张恒', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('687', '2715702', '保密员', 'wmsCostOut', '2455205', '陈小红', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('688', '2715702', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('689', '2583957', '申请人主管', 'wmsCostOut', '525683', '陈国芳', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('690', '2583957', '项目经理', 'wmsCostOut', '2583957', '徐栋', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('691', '2583957', '物控/商务', 'wmsCostOut', '1673938', '桂云霞', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('692', '2583957', '财务', 'wmsCostOut', '2473734', '侯茜婕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('693', '2583957', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('694', '2583957', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('695', '2583957', '领料人', 'wmsCostOut', '2583957', '徐栋', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('696', '2583957', '保密员', 'wmsCostOut', '', '', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('697', '2583957', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('698', '385345', '申请人主管', 'wmsCostOut', '1815686', '吴洪文', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('699', '385345', '项目经理', 'wmsCostOut', '2065909', '潘园园', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('700', '385345', '物控/商务', 'wmsCostOut', '1673938', '桂云霞', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('701', '385345', '财务', 'wmsCostOut', '2473734', '侯茜婕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('702', '385345', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('703', '385345', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('704', '385345', '领料人', 'wmsCostOut', '395472', '肖凡', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('705', '385345', '保密员', 'wmsCostOut', '2455205', '陈小红', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('706', '385345', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('707', '1832690', '申请人主管', 'wmsCostOut', '525683', '陈国芳', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('708', '1832690', '项目经理', 'wmsCostOut', '525683', '陈国芳', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('709', '1832690', '物控/商务', 'wmsCostOut', '1673938', '桂云霞', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('710', '1832690', '财务', 'wmsCostOut', '2473734', '侯茜婕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('711', '1832690', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('712', '1832690', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('713', '1832690', '领料人', 'wmsCostOut', '208248', '张芬菊', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('714', '1832690', '保密员', 'wmsCostOut', '', '', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('715', '1832690', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('716', '3181944', '施工队长', 'wmsUnproductiveOut', '2640265', '张恒', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('717', '3181944', '工程负责人', 'wmsUnproductiveOut', '3181944', '马艳明', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('718', '3181944', '物资管理员', 'wmsUnproductiveOut', '2903447', '韩龙龙', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('719', '1150899', '物控工程师', 'wmsListOutStockPo', '329325', '张军平', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('720', '1150899', '申请人主管', 'wmsListOutStockPo', '1147941', '熊永琴', '申请人主管', '');
INSERT INTO `recommendsps` VALUES ('721', '1150899', '财务会计', 'wmsListOutStockPo', '2898665', '柴新燕', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('722', '1150899', '物资管理员', 'wmsListOutStockPo', '2903447', '韩龙龙', '*权限：[仓库管理]', '');
INSERT INTO `recommendsps` VALUES ('723', '1150899', '输单员', 'wmsListOutStockPo', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('724', '702116', '施工队长', 'wmsUnproductiveOut', '702116', '洪雪敏', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('725', '702116', '工程负责人', 'wmsUnproductiveOut', '254613', '荆顺昌', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('726', '702116', '物资管理员', 'wmsUnproductiveOut', '2903447', '韩龙龙', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('727', '702116', '退货人', 'wmsPoReturn161', '702116', '洪雪敏', '退货人', '');
INSERT INTO `recommendsps` VALUES ('728', '320023', '申请人主管', 'wmsCostOut', '2034722', '陈勇', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('729', '320023', '项目经理', 'wmsCostOut', '457308', '王嵩昊', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('730', '320023', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('731', '320023', '物控/商务', 'wmsCostOut', '1673938', '桂云霞', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('732', '320023', '财务', 'wmsCostOut', '2898665', '柴新燕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('733', '320023', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('734', '320023', '领料人', 'wmsCostOut', '2003391', '吴志威', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('735', '320023', '保密员', 'wmsCostOut', '', '', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('736', '320023', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('737', '2640265', '施工队长', 'wmsUnproductiveOut', '2640265', '张恒', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('738', '2640265', '工程负责人', 'wmsUnproductiveOut', '2640265', '张恒', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('739', '2640265', '物资管理员', 'wmsUnproductiveOut', '2903447', '韩龙龙', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('740', '1649048', '施工队长', 'wmsUnproductiveOut', '1037492', '张海柱', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('741', '1649048', '工程负责人', 'wmsUnproductiveOut', '1649048', '黄建文', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('742', '1649048', '物资管理员', 'wmsUnproductiveOut', '2903447', '韩龙龙', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('743', '1448877', '施工队长', 'wmsUnproductiveOut', '1448877', '魏二强', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('744', '1448877', '工程负责人', 'wmsUnproductiveOut', '1448877', '魏二强', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('745', '1448877', '物资管理员', 'wmsUnproductiveOut', '2903447', '韩龙龙', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('746', '2933965', '施工队长', 'wmsUnproductiveOut', '2933965', '田继强', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('747', '2933965', '工程负责人', 'wmsUnproductiveOut', '2933965', '田继强', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('748', '2933965', '物资管理员', 'wmsUnproductiveOut', '2903447', '韩龙龙', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('749', '1319343', '施工队长', 'wmsUnproductiveOut', '468376', '高林', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('750', '1319343', '工程负责人', 'wmsUnproductiveOut', '468376', '高林', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('751', '1319343', '物资管理员', 'wmsUnproductiveOut', '2903447', '韩龙龙', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('752', '2845515', '施工队长', 'wmsUnproductiveOut', '2845515', '陆剑伟', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('753', '2845515', '工程负责人', 'wmsUnproductiveOut', '2845515', '陆剑伟', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('754', '2845515', '物资管理员', 'wmsUnproductiveOut', '2903447', '韩龙龙', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('755', '2661604', '物控工程师', 'wmsUnproductiveInYpo', '329325', '张军平', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('756', '2661604', '仓库主管', 'wmsUnproductiveInYpo', '254613', '荆顺昌', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('757', '2661604', '财务会计', 'wmsUnproductiveInYpo', '2898665', '柴新燕', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('758', '2661604', '输单员', 'wmsUnproductiveInYpo', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('759', '1767302', '物控工程师', 'wmsListOutStockPo', '329325', '张军平', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('760', '1767302', '申请人主管', 'wmsListOutStockPo', '579966', '刘阳', '申请人主管', '');
INSERT INTO `recommendsps` VALUES ('761', '1767302', '财务会计', 'wmsListOutStockPo', '2898665', '柴新燕', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('762', '1767302', '物资管理员', 'wmsListOutStockPo', '2903447', '韩龙龙', '*权限：[仓库管理]', '');
INSERT INTO `recommendsps` VALUES ('763', '1767302', '输单员', 'wmsListOutStockPo', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('764', '267339', '施工队长', 'wmsUnproductiveOut', '2640265', '张恒', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('765', '267339', '工程负责人', 'wmsUnproductiveOut', '267339', '宁强', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('766', '267339', '物资管理员', 'wmsUnproductiveOut', '1330047', '缪军', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('767', '1034068', '申请人主管', 'wmsCostOut', '2058107', '岳波', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('768', '1034068', '项目经理', 'wmsCostOut', '2707235', '杨显泽', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('769', '1034068', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('770', '1034068', '物控/商务', 'wmsCostOut', '1673938', '桂云霞', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('771', '1034068', '财务', 'wmsCostOut', '2898665', '柴新燕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('772', '1034068', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('773', '1034068', '领料人', 'wmsCostOut', '3134906', '齐敏', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('774', '1034068', '保密员', 'wmsCostOut', '2455205', '陈小红', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('775', '1034068', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('776', '1911511', '施工队长', 'wmsUnproductiveOut', '2640265', '张恒', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('777', '1911511', '工程负责人', 'wmsUnproductiveOut', '1911511', '张正茂', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('778', '1911511', '物资管理员', 'wmsUnproductiveOut', '2903447', '韩龙龙', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('779', '3134906', '申请人主管', 'wmsCostOut', '2058107', '岳波', '科室:[申请人科室],主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('780', '3134906', '项目经理', 'wmsCostOut', '2707235', '杨显泽', '项目经理', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('781', '3134906', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('782', '3134906', '物控/商务', 'wmsCostOut', '1673938', '桂云霞', '物控/商务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('783', '3134906', '财务', 'wmsCostOut', '2898665', '柴新燕', '财务', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('784', '3134906', '仓管员', 'wmsCostOut', '702116', '洪雪敏', '*角色：[仓库地区]物资管理员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('785', '3134906', '领料人', 'wmsCostOut', '3134906', '齐敏', '领料人', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('786', '3134906', '保密员', 'wmsCostOut', '', '', '+保密员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('787', '3134906', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=宝龙}');
INSERT INTO `recommendsps` VALUES ('788', '2566021', '物控工程师', 'wmsListOutStockPo', '2811588', '卢扬', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('789', '2566021', '申请人主管', 'wmsListOutStockPo', '2058107', '岳波', '申请人主管', '');
INSERT INTO `recommendsps` VALUES ('790', '2566021', '财务会计', 'wmsListOutStockPo', '2898665', '柴新燕', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('791', '2566021', '物资管理员', 'wmsListOutStockPo', '2903447', '韩龙龙', '*权限：[仓库管理]', '');
INSERT INTO `recommendsps` VALUES ('792', '2566021', '输单员', 'wmsListOutStockPo', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('793', '2864333', '施工队长', 'wmsUnproductiveOut', '2640265', '张恒', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('794', '2864333', '工程负责人', 'wmsUnproductiveOut', '1037492', '张海柱', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('795', '2864333', '物资管理员', 'wmsUnproductiveOut', '1330047', '缪军', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('796', '2864325', '施工队长', 'wmsUnproductiveOut', '2640265', '张恒', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('797', '2864325', '工程负责人', 'wmsUnproductiveOut', '1037492', '张海柱', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('798', '2864325', '物资管理员', 'wmsUnproductiveOut', '1330047', '缪军', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('799', '2868001', '施工队长', 'wmsUnproductiveOut', '2640265', '张恒', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('800', '2868001', '工程负责人', 'wmsUnproductiveOut', '1037492', '张海柱', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('801', '2868001', '物资管理员', 'wmsUnproductiveOut', '1330047', '缪军', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('802', '2864317', '施工队长', 'wmsUnproductiveOut', '2640265', '张恒', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('803', '2864317', '工程负责人', 'wmsUnproductiveOut', '1037492', '张海柱', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('804', '2864317', '物资管理员', 'wmsUnproductiveOut', '1330047', '缪军', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('805', '2715677', '施工队长', 'wmsUnproductiveOut', '2715677', '熊德军', '施工队长', '{仓库地区=济宁}');
INSERT INTO `recommendsps` VALUES ('806', '2715677', '工程负责人', 'wmsUnproductiveOut', '2653084', '陈龙威', '工程负责人', '{仓库地区=济宁}');
INSERT INTO `recommendsps` VALUES ('807', '2715677', '物资管理员', 'wmsUnproductiveOut', '2661604', '杨良飞', '*角色：[仓库地区]物资管理员', '{仓库地区=济宁}');
INSERT INTO `recommendsps` VALUES ('808', '213807', '物控工程师', 'wmsListOutStockPo', '2864323', '赵增新', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('809', '213807', '申请人主管', 'wmsListOutStockPo', '202473', '谭新艳', '申请人主管', '');
INSERT INTO `recommendsps` VALUES ('810', '213807', '财务会计', 'wmsListOutStockPo', '2898665', '柴新燕', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('811', '213807', '物资管理员', 'wmsListOutStockPo', '2903447', '韩龙龙', '*权限：[仓库管理]', '');
INSERT INTO `recommendsps` VALUES ('812', '213807', '输单员', 'wmsListOutStockPo', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('813', '1042059', 'IQC品质负责人', 'wmsPoStore105', '1843641', '蒋万小', 'IQC品质负责人', '');
INSERT INTO `recommendsps` VALUES ('814', '1042059', '输单员', 'wmsPoStore105', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('815', '1890979', '物控工程师', 'wmsListOutStockPo', '329325', '张军平', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('816', '1890979', '申请人主管', 'wmsListOutStockPo', '1576887', '尹鹏', '申请人主管', '');
INSERT INTO `recommendsps` VALUES ('817', '1890979', '财务会计', 'wmsListOutStockPo', '2898665', '柴新燕', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('818', '1890979', '物资管理员', 'wmsListOutStockPo', '2903447', '韩龙龙', '*权限：[仓库管理]', '');
INSERT INTO `recommendsps` VALUES ('819', '1890979', '输单员', 'wmsListOutStockPo', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('820', '267339', '施工队长', 'wmsBackInStore', '2640265', '张恒', '施工队长', '');
INSERT INTO `recommendsps` VALUES ('821', '267339', '工程负责人', 'wmsBackInStore', '267339', '宁强', '工程负责人', '');
INSERT INTO `recommendsps` VALUES ('822', '267339', '物资管理员', 'wmsBackInStore', '2903447', '韩龙龙', '*角色：[仓库地区]物资管理员', '');
INSERT INTO `recommendsps` VALUES ('823', '1448877', '物控工程师', 'wmsListOutStockPo', '1495730', '解亚娜', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('824', '1448877', '申请人主管', 'wmsListOutStockPo', '210164', '胡风美', '申请人主管', '');
INSERT INTO `recommendsps` VALUES ('825', '1448877', '财务会计', 'wmsListOutStockPo', '2898665', '柴新燕', '财务会计', '');
INSERT INTO `recommendsps` VALUES ('826', '1448877', '物资管理员', 'wmsListOutStockPo', '2903447', '韩龙龙', '*权限：[仓库管理]', '');
INSERT INTO `recommendsps` VALUES ('827', '1448877', '输单员', 'wmsListOutStockPo', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('828', '2339746', '施工队长', 'wmsUnproductiveOut', '2711637', '罗曙', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('829', '2339746', '工程负责人', 'wmsUnproductiveOut', '3236821', '冯胜', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('830', '2339746', '物资管理员', 'wmsUnproductiveOut', '2903447', '韩龙龙', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('831', '1042059', '输单员', 'wmsPoReceive103', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('832', '1330047', '物控工程师', 'wmsUnproductiveInWpo', '329325', '张军平', '物控工程师', '');
INSERT INTO `recommendsps` VALUES ('833', '1330047', '仓库主管', 'wmsUnproductiveInWpo', '254613', '荆顺昌', '*权限：仓库主管', '');
INSERT INTO `recommendsps` VALUES ('834', '2715677', '申请人主管', 'wmsCostOut', '2653084', '陈龙威', '科室:[申请人科室],主管', '{仓库地区=济宁}');
INSERT INTO `recommendsps` VALUES ('835', '2715677', '项目经理', 'wmsCostOut', '2191365', '杨东禹', '项目经理', '{仓库地区=济宁}');
INSERT INTO `recommendsps` VALUES ('836', '2715677', '仓库主管', 'wmsCostOut', '254613', '荆顺昌', '*权限：仓库主管', '{仓库地区=济宁}');
INSERT INTO `recommendsps` VALUES ('837', '2715677', '物控/商务', 'wmsCostOut', '1200437', '路丽萍', '物控/商务', '{仓库地区=济宁}');
INSERT INTO `recommendsps` VALUES ('838', '2715677', '财务', 'wmsCostOut', '2898665', '柴新燕', '财务', '{仓库地区=济宁}');
INSERT INTO `recommendsps` VALUES ('839', '2715677', '仓管员', 'wmsCostOut', '2770857', '刘志', '*角色：[仓库地区]物资管理员', '{仓库地区=济宁}');
INSERT INTO `recommendsps` VALUES ('840', '2715677', '领料人', 'wmsCostOut', '2654946', '张飞', '领料人', '{仓库地区=济宁}');
INSERT INTO `recommendsps` VALUES ('841', '2715677', '保密员', 'wmsCostOut', '', '', '+保密员', '{仓库地区=济宁}');
INSERT INTO `recommendsps` VALUES ('842', '2715677', '输单员', 'wmsCostOut', '622124', '杨晓霜', '*权限：输单员', '{仓库地区=济宁}');
INSERT INTO `recommendsps` VALUES ('843', '2871246', '施工队长', 'wmsUnproductiveOut', '2640265', '张恒', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('844', '2871246', '工程负责人', 'wmsUnproductiveOut', '1037492', '张海柱', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('845', '2871246', '物资管理员', 'wmsUnproductiveOut', '1330047', '缪军', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('846', '2715665', '施工队长', 'wmsUnproductiveOut', '2640265', '张恒', '施工队长', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('847', '2715665', '工程负责人', 'wmsUnproductiveOut', '1037492', '张海柱', '工程负责人', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('848', '2715665', '物资管理员', 'wmsUnproductiveOut', '2903447', '韩龙龙', '*角色：[仓库地区]物资管理员', '{仓库地区=坪山}');
INSERT INTO `recommendsps` VALUES ('849', '2897608', '输单员', 'wmsPoReceive103', '622124', '杨晓霜', '*权限：输单员', '');
INSERT INTO `recommendsps` VALUES ('850', '2897608', 'IQC品质负责人', 'wmsPoStore105', '2941366', '马骁杰', 'IQC品质负责人', '');
INSERT INTO `recommendsps` VALUES ('851', '2897608', '输单员', 'wmsPoStore105', '622124', '杨晓霜', '*权限：输单员', '');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(255) NOT NULL COMMENT '角色名称',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序（数字越大，越排前）',
  `upper_id` int(11) unsigned NOT NULL COMMENT '上一级角色id',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '0', '0', '0');
INSERT INTO `role` VALUES ('2', '综合管理员', '4', '1', '0');
INSERT INTO `role` VALUES ('3', '项目管理员', '3', '1', '0');
INSERT INTO `role` VALUES ('4', '人力资源管理员', '2', '1', '0');
INSERT INTO `role` VALUES ('5', '系统管理员', '1', '1', '0');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色对应菜单id',
  `role_id` int(11) unsigned NOT NULL COMMENT '角色id',
  `menu_id` int(11) unsigned NOT NULL COMMENT '菜单id',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_role_menu` (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for to
-- ----------------------------
DROP TABLE IF EXISTS `to`;
CREATE TABLE `to` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '消息接收id',
  `msg_id` int(11) unsigned DEFAULT NULL COMMENT '消息id',
  `to` int(11) unsigned NOT NULL COMMENT '消息接收人',
  `read_state` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '消息阅读状态（0：未读，1：已读）',
  `read_time` datetime DEFAULT NULL COMMENT '阅读时间',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_user_msg` (`id`,`to`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of to
-- ----------------------------
INSERT INTO `to` VALUES ('1', '2', '1', '0', null, '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(64) NOT NULL COMMENT '用户名（登录使用）',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '昵称（不做登录使用）',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `pwd` varchar(64) NOT NULL COMMENT '密码',
  `pwd_salt` varchar(32) NOT NULL COMMENT '密码加盐',
  `state` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '用户状态（0：禁用，1：正常，2：锁定）',
  `reg_time` datetime NOT NULL COMMENT '注册时间',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '管理员', null, '9ace391f1e037ac72fbee071ddad2c73', '42d4f30c26c381816122db6fccbd5623', '1', '2019-08-01 08:53:41', '0');

-- ----------------------------
-- Table structure for user_dept
-- ----------------------------
DROP TABLE IF EXISTS `user_dept`;
CREATE TABLE `user_dept` (
  `user_id` int(11) unsigned NOT NULL COMMENT '用户id',
  `dept_id` int(11) unsigned NOT NULL COMMENT '部门id',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  UNIQUE KEY `uni_user_role` (`user_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of user_dept
-- ----------------------------
INSERT INTO `user_dept` VALUES ('1', '12', '0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) unsigned NOT NULL COMMENT '用户标识',
  `role_id` int(11) unsigned NOT NULL COMMENT '角色标识',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  UNIQUE KEY `uni_user_role` (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '0');

-- ----------------------------
-- Table structure for value
-- ----------------------------
DROP TABLE IF EXISTS `value`;
CREATE TABLE `value` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '字典值id',
  `dict_id` int(11) unsigned NOT NULL COMMENT '字典id',
  `code` varchar(128) NOT NULL COMMENT '字典标签',
  `value` varchar(128) NOT NULL COMMENT '字典值',
  `remark` varchar(128) DEFAULT NULL COMMENT '字典值描述',
  `sort` int(11) unsigned DEFAULT '1' COMMENT '排序（数字越大，越排前）',
  `is_default` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否是默认值（1：是，0：否）',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of value
-- ----------------------------
INSERT INTO `value` VALUES ('1', '1', 'code1', '值1', '值1', '1', '0', '0');
INSERT INTO `value` VALUES ('2', '1', 'code2', '值2', '值2', '1', '1', '0');
