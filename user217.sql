/*
 Navicat Premium Data Transfer

 Source Server         : try
 Source Server Type    : MySQL
 Source Server Version : 80036 (8.0.36)
 Source Host           : localhost:3306
 Source Schema         : mawaru

 Target Server Type    : MySQL
 Target Server Version : 80036 (8.0.36)
 File Encoding         : 65001

 Date: 30/12/2024 09:37:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user217
-- ----------------------------
DROP TABLE IF EXISTS `user217`;
CREATE TABLE `user217`  (
  `userLoveId` int NOT NULL,
  PRIMARY KEY (`userLoveId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user217
-- ----------------------------
INSERT INTO `user217` VALUES (-2052775934);
INSERT INTO `user217` VALUES (-1998249983);
INSERT INTO `user217` VALUES (-1897586686);
INSERT INTO `user217` VALUES (-1817894910);
INSERT INTO `user217` VALUES (-1713057791);
INSERT INTO `user217` VALUES (-1654349822);
INSERT INTO `user217` VALUES (-949735423);
INSERT INTO `user217` VALUES (-832233471);
INSERT INTO `user217` VALUES (-802873342);
INSERT INTO `user217` VALUES (233058305);
INSERT INTO `user217` VALUES (614735874);

SET FOREIGN_KEY_CHECKS = 1;
