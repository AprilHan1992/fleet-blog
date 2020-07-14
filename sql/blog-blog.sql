/*
Navicat MySQL Data Transfer

Source Server         : 3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : blog-blog

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2020-07-14 15:42:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(255) NOT NULL COMMENT '文章标题',
  `cover` varchar(255) DEFAULT NULL COMMENT '文章封面',
  `tag_id` int(11) unsigned NOT NULL COMMENT '分类/标签id',
  `tags` varchar(255) DEFAULT NULL COMMENT '文章标签（多个用,隔开）',
  `content` text COMMENT '文章内容',
  `top` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否置顶（1：是，0：否）',
  `rcmd` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否首页推荐（1：是，0：否）',
  `state` int(11) unsigned NOT NULL COMMENT '文章状态（1：公布，2：私密，3：草稿，4：收回）',
  `sort` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '排序（数字越大，越排前）',
  `creator_id` int(11) unsigned NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `editor_id` int(11) unsigned DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '测试文章标题', null, '1', '测试，文章', '测试文章内容', '0', '0', '1', '1', '1', '2020-07-13 09:58:57', null, null, '0');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '分类/标签id',
  `type` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '类型（1：分类，2：标签）',
  `tag` varchar(128) NOT NULL COMMENT '分类/标签',
  `sort` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '排序（数字越大，越排前）',
  `upper_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '上一级分类/标签id',
  `deleted` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='分类/标签';

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('1', '1', '心情日记', '1', '0', '0');
INSERT INTO `tag` VALUES ('2', '1', '技术分享', '1', '0', '0');
INSERT INTO `tag` VALUES ('3', '1', '作品展示', '1', '0', '0');
INSERT INTO `tag` VALUES ('4', '1', '美图欣赏', '1', '0', '0');
INSERT INTO `tag` VALUES ('5', '2', '测试', '0', '0', '0');
