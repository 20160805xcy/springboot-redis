/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : wolf

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 21/12/2018 00:33:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_web
-- ----------------------------
DROP TABLE IF EXISTS `user_web`;
CREATE TABLE `user_web`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '秘密',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '聊天室用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_web
-- ----------------------------
INSERT INTO `user_web` VALUES (1, 'xcy', '123', '深圳');
INSERT INTO `user_web` VALUES (2, 'jerry', '123', '江西');
INSERT INTO `user_web` VALUES (3, 'jack', '123', '北京');

SET FOREIGN_KEY_CHECKS = 1;
