/*
Navicat MySQL Data Transfer

Source Server         : wull
Source Server Version : 50644
Source Host           : localhost:3306
Source Database       : dobot

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2020-04-25 13:29:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for finishedstorage
-- ----------------------------
DROP TABLE IF EXISTS `finishedstorage`;
CREATE TABLE `finishedstorage` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of finishedstorage
-- ----------------------------
INSERT INTO `finishedstorage` VALUES ('1', '第一库位');
INSERT INTO `finishedstorage` VALUES ('2', '第二库位');
INSERT INTO `finishedstorage` VALUES ('3', '第三库位');
INSERT INTO `finishedstorage` VALUES ('4', '第四库位');
INSERT INTO `finishedstorage` VALUES ('5', '第五库位');
INSERT INTO `finishedstorage` VALUES ('6', '第六库位');
INSERT INTO `finishedstorage` VALUES ('7', '第七库位');
INSERT INTO `finishedstorage` VALUES ('8', '第八库位');

-- ----------------------------
-- Table structure for finishedstorage_order
-- ----------------------------
DROP TABLE IF EXISTS `finishedstorage_order`;
CREATE TABLE `finishedstorage_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `finishedstorage_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fi_or_fi` (`finishedstorage_id`) USING BTREE,
  KEY `fi_or_or` (`order_id`) USING BTREE,
  CONSTRAINT `fi_or_fi` FOREIGN KEY (`finishedstorage_id`) REFERENCES `finishedstorage` (`id`),
  CONSTRAINT `fi_or_or` FOREIGN KEY (`order_id`) REFERENCES `orderlist` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of finishedstorage_order
-- ----------------------------
INSERT INTO `finishedstorage_order` VALUES ('5', '2', '2');

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `nameZh` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES ('1', 'birds', '鸟');
INSERT INTO `image` VALUES ('2', 'flower', '花');

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '材料名称',
  `nameZh` varchar(32) NOT NULL COMMENT '材料中文名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('1', 'paper', '纸');
INSERT INTO `material` VALUES ('2', 'metal', '金属');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL,
  `path` varchar(64) DEFAULT NULL,
  `component` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `iconCls` varchar(64) DEFAULT NULL,
  `keepAlive` tinyint(1) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `props` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parentId` (`parentId`),
  CONSTRAINT `parent_id` FOREIGN KEY (`parentId`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '/', null, null, '所有', null, null, null, '1');
INSERT INTO `menu` VALUES ('2', '/', '/home', 'Home', '车间管理', null, null, '1', '1');
INSERT INTO `menu` VALUES ('3', '/', '/home', 'Home', '系统管理', null, null, '1', '1');
INSERT INTO `menu` VALUES ('4', '/', '/home', 'Home', '顾客页面', null, null, '1', '1');
INSERT INTO `menu` VALUES ('11', '/shop/rawStorage/**', '/shop/rawStorage', 'ShopRawStorage', '原料库管理', null, null, '2', '1');
INSERT INTO `menu` VALUES ('12', '/shop/finishedStorage/**', '/shop/finishedStorage', 'ShopFinishedStorage', '成品库管理', null, null, '2', '1');
INSERT INTO `menu` VALUES ('13', '/shop/orderList/**', '/shop/orderList', 'ShopOrderList', '订单管理', null, null, '2', '1');
INSERT INTO `menu` VALUES ('14', '/system/user/**', '/system/uer', 'SysUser', '人员管理', null, null, '3', '1');
INSERT INTO `menu` VALUES ('15', '/customer/orderList/**', '/customer/orderList', 'CusOrderList', '订单查询', null, null, '4', '1');
INSERT INTO `menu` VALUES ('16', '/customer/message/**', '/customer/message', 'CusMessage', '用户信息', null, null, '4', '1');

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `menu_role_menu` (`mid`),
  KEY `menu_role_role` (`rid`),
  CONSTRAINT `menu_role_menu` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`),
  CONSTRAINT `menu_role_role` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES ('1', '2', '1');
INSERT INTO `menu_role` VALUES ('2', '3', '1');
INSERT INTO `menu_role` VALUES ('3', '11', '1');
INSERT INTO `menu_role` VALUES ('4', '12', '1');
INSERT INTO `menu_role` VALUES ('5', '13', '1');
INSERT INTO `menu_role` VALUES ('6', '14', '1');
INSERT INTO `menu_role` VALUES ('7', '4', '2');
INSERT INTO `menu_role` VALUES ('8', '15', '2');
INSERT INTO `menu_role` VALUES ('9', '16', '2');

-- ----------------------------
-- Table structure for orderlist
-- ----------------------------
DROP TABLE IF EXISTS `orderlist`;
CREATE TABLE `orderlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ordertime` datetime NOT NULL,
  `finishedtime` datetime DEFAULT NULL,
  `image` varchar(32) NOT NULL,
  `material` varchar(32) NOT NULL,
  `state` varchar(32) NOT NULL DEFAULT '待加工',
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `or_os` (`state`) USING BTREE,
  KEY `order_customer` (`customer_id`),
  CONSTRAINT `order_customer` FOREIGN KEY (`customer_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderlist
-- ----------------------------
INSERT INTO `orderlist` VALUES ('1', '2020-04-21 17:10:28', '2020-04-23 17:37:26', '图片一', '纸质', '已完成', '2');
INSERT INTO `orderlist` VALUES ('2', '2020-04-22 17:40:37', null, '图片二', '金属', '待取货', '3');
INSERT INTO `orderlist` VALUES ('3', '2020-04-21 17:41:06', null, '图片一', '金属', '待加工', '4');

-- ----------------------------
-- Table structure for orderstate
-- ----------------------------
DROP TABLE IF EXISTS `orderstate`;
CREATE TABLE `orderstate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `nameZh` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderstate
-- ----------------------------
INSERT INTO `orderstate` VALUES ('1', 'wait for production', '待加工');
INSERT INTO `orderstate` VALUES ('2', 'producting', '加工中');
INSERT INTO `orderstate` VALUES ('3', 'wait for take', '待取货');
INSERT INTO `orderstate` VALUES ('4', 'finished', '已完成');

-- ----------------------------
-- Table structure for rawstorage
-- ----------------------------
DROP TABLE IF EXISTS `rawstorage`;
CREATE TABLE `rawstorage` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rawstorage
-- ----------------------------
INSERT INTO `rawstorage` VALUES ('1', '第一库位');
INSERT INTO `rawstorage` VALUES ('2', '第二库位');
INSERT INTO `rawstorage` VALUES ('3', '第三库位');
INSERT INTO `rawstorage` VALUES ('4', '第四库位');
INSERT INTO `rawstorage` VALUES ('5', '第五库位');
INSERT INTO `rawstorage` VALUES ('6', '第六库位');
INSERT INTO `rawstorage` VALUES ('7', '第七库位');
INSERT INTO `rawstorage` VALUES ('8', '第八库位');

-- ----------------------------
-- Table structure for rawstorage_material
-- ----------------------------
DROP TABLE IF EXISTS `rawstorage_material`;
CREATE TABLE `rawstorage_material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rawstorage_id` int(11) NOT NULL,
  `material_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ra_ma_ra` (`rawstorage_id`),
  KEY `ra_ma_ma` (`material_id`),
  CONSTRAINT `ra_ma_ma` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
  CONSTRAINT `ra_ma_ra` FOREIGN KEY (`rawstorage_id`) REFERENCES `rawstorage` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rawstorage_material
-- ----------------------------
INSERT INTO `rawstorage_material` VALUES ('1', '1', '1');
INSERT INTO `rawstorage_material` VALUES ('2', '2', '2');
INSERT INTO `rawstorage_material` VALUES ('3', '3', '1');
INSERT INTO `rawstorage_material` VALUES ('4', '4', '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `name` varchar(64) NOT NULL COMMENT '角色英文名称',
  `nameZh` varchar(64) NOT NULL COMMENT '角色中文名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'manager', '管理员');
INSERT INTO `role` VALUES ('2', 'customer', '顾客');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `telephone` varchar(16) DEFAULT NULL,
  `address` varchar(64) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `userface` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '管理员', '021-88888888', '18568887789', '上海宝山', '1', 'admin', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', '../../static/img/userface/admin.jpg', null);
INSERT INTO `user` VALUES ('2', '张三', '021-88888888', '18568123489', '上海静安', '1', 'zhangsan', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', '../../static/img/userface/default.jpg', null);
INSERT INTO `user` VALUES ('3', '李四', '021-88888888', '18568123666', '上海嘉定', '1', 'lisi', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', '../../static/img/userface/default.jpg', null);
INSERT INTO `user` VALUES ('4', '王五', '021-88888888', '18568123377', '上海浦东', '1', 'wangwu', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', '../../static/img/userface/default.jpg', null);
INSERT INTO `user` VALUES ('5', '赵六', '021-88888888', '18568128888', '北京', '1', 'zhaoliu', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', '../../static/img/userface/default.jpg', null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `user_role_role` (`role_id`),
  KEY `uer_role_user` (`user_id`),
  CONSTRAINT `uer_role_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_role_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');
