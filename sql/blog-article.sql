/*
Navicat MySQL Data Transfer

Source Server         : 3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : blog-article

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2020-03-27 17:08:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `article_title` varchar(255) NOT NULL COMMENT '文章标题',
  `article_cover` varchar(255) DEFAULT NULL COMMENT '文章封面',
  `tag_id` int(11) unsigned NOT NULL COMMENT '分类/标签id',
  `article_content` text COMMENT '文章内容',
  `article_tags` varchar(255) DEFAULT NULL COMMENT '文章标签（多个用,隔开）',
  `top` int(11) unsigned DEFAULT '0' COMMENT '是否置顶（1：是，0：否）',
  `recommend` int(11) unsigned DEFAULT '0' COMMENT '是否首页推荐（1：是，0：否）',
  `article_state` int(11) unsigned NOT NULL COMMENT '文章状态（1：公布，2：私密，3：草稿，4：收回）',
  `sort_value` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '排序（数字越大，越排前）',
  `creator_id` int(11) unsigned NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `editor_id` int(11) unsigned DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('25', '测试1', null, '1', null, null, '0', '1', '1', '1', '1', '2020-02-25 13:58:49', null, null, '0');
INSERT INTO `article` VALUES ('26', '测试1', null, '1', null, null, '0', '0', '1', '1', '1', '2020-02-25 14:21:16', null, null, '0');
INSERT INTO `article` VALUES ('27', '测试1', null, '1', null, null, '0', '0', '1', '1', '1', '2020-02-25 14:26:45', null, null, '0');
INSERT INTO `article` VALUES ('28', '测试1', null, '1', null, null, '0', '0', '1', '1', '1', '2020-02-25 14:30:20', null, null, '0');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `tag_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '分类/标签id',
  `tag_type` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '类型（1：分类，2：标签）',
  `tag` varchar(128) NOT NULL COMMENT '分类/标签',
  `sort_value` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '排序（数字越大，越排前）',
  `upper_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '上一级分类/标签id',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='分类/标签';

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('1', '1', '心情日记', '1', '0', '0');
INSERT INTO `tag` VALUES ('2', '1', '技术分享', '1', '0', '0');
INSERT INTO `tag` VALUES ('3', '1', '作品展示', '1', '0', '0');
INSERT INTO `tag` VALUES ('4', '1', '美图欣赏', '1', '0', '0');
