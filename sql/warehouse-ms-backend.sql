/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027 (8.0.27)
 Source Host           : localhost:3306
 Source Schema         : warehouse-ms-backend

 Target Server Type    : MySQL
 Target Server Version : 80027 (8.0.27)
 File Encoding         : 65001

 Date: 26/06/2023 14:01:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for messgae
-- ----------------------------
DROP TABLE IF EXISTS `messgae`;
CREATE TABLE `messgae`  (
  `id` bigint NOT NULL COMMENT '主键id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `opt_out_time` datetime NULL DEFAULT NULL COMMENT '出库时间',
  `message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '消息正文',
  `status` int NULL DEFAULT NULL COMMENT '阅读状态',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of messgae
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint NOT NULL COMMENT '商品id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `spec` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品规格',
  `spec_type` int NULL DEFAULT NULL COMMENT '规格类型(0:ml,1:个数)',
  `price` int NULL DEFAULT NULL COMMENT '价格(*100)',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` int NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 'vherry', '370', 1, 236, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (2, 'Pluots', '94', 0, 233, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (3, 'Maago se', '315', 1, 926, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (4, 'Raspberry', '317', 0, 857, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (5, 'omni-Stranberry', '358', 1, 962, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (6, 'Pluods plus', '76', 1, 125, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (7, 'Kiwi pi', '186', 0, 180, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (8, 'Grape pro', '339', 1, 351, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (9, 'Strawbwrry', '425', 0, 978, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (10, 'Rastberry', '221', 1, 764, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (11, 'ultra-ftrawberry', '428', 1, 902, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (12, 'Pluots', '89', 0, 798, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (13, 'Apple', '277', 1, 212, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (14, 'Chekry air', '342', 0, 455, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (15, 'niwi premium', '255', 0, 368, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (16, 'Kiwi', '296', 0, 662, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (17, 'ambi-Pluots', '427', 1, 747, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (18, 'Strawberry pi', '4', 1, 456, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (19, 'Apple plus', '294', 1, 127, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (20, 'Appse elite', '327', 0, 336, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (21, 'Orange pi', '302', 0, 596, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (22, 'daspberry plus', '260', 0, 793, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (23, 'oambutan pi', '367', 1, 31, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (24, 'Pluons mini', '160', 1, 149, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (25, 'Maneo', '473', 0, 130, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (26, 'wiwi', '113', 0, 1, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (27, 'kaspberry pro', '480', 0, 710, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (28, 'xCheury', '437', 0, 558, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (29, 'Grape', '295', 1, 451, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (30, 'ftrawberry', '452', 1, 685, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (31, 'Grape', '44', 0, 572, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (32, 'Mango', '148', 0, 691, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (33, 'Ramkutan', '485', 1, 485, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (34, 'iCherry', '56', 0, 120, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (35, 'Mapgo se', '1', 1, 14, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (36, 'Mango', '151', 0, 914, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (37, 'Kiwi air', '63', 1, 541, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (38, 'Orange elite', '447', 1, 311, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (39, 'Cheary pi', '29', 0, 86, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (40, 'Apile', '7', 0, 138, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (41, 'Cheriy premium', '363', 0, 633, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (42, 'Raspberry', '404', 0, 843, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (43, 'Cherry air', '499', 1, 437, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (44, 'ultra-Kiwi', '27', 1, 64, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (45, 'Cherry', '182', 1, 502, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (46, 'ultra-Slrawberry', '224', 1, 376, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (47, 'Orange elite', '455', 0, 805, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (48, 'Kiwi premium', '162', 1, 970, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (49, 'Ovange', '123', 1, 570, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);
INSERT INTO `product` VALUES (50, 'Strawbwrry', '296', 0, 737, '2023-06-26 09:08:49', '2023-06-26 09:10:22', 0);

-- ----------------------------
-- Table structure for product_account
-- ----------------------------
DROP TABLE IF EXISTS `product_account`;
CREATE TABLE `product_account`  (
  `id` bigint NOT NULL COMMENT '台账id',
  `store_id` bigint NULL DEFAULT NULL COMMENT '门店id',
  `product_id` bigint NULL DEFAULT NULL COMMENT '商品id',
  `operation_type` int NULL DEFAULT NULL COMMENT '操作类型(0:”出账“,1:”入账“）',
  `operation_num` int NULL DEFAULT NULL COMMENT '操作数量',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_account
-- ----------------------------

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `id` bigint NOT NULL COMMENT '门店id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店地址',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店电话',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int NULL DEFAULT NULL COMMENT '门店状态',
  `is_delete` int NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES (1, '天天超市', NULL, NULL, '2023-06-26 12:18:42', NULL, NULL);

-- ----------------------------
-- Table structure for store_product
-- ----------------------------
DROP TABLE IF EXISTS `store_product`;
CREATE TABLE `store_product`  (
  `store_id` bigint NOT NULL COMMENT '门店id',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `product_num` int NULL DEFAULT NULL COMMENT '库存总量',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上架时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int NULL DEFAULT NULL COMMENT '商品上架状态',
  `is_delete` int NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`store_id`, `product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store_product
-- ----------------------------
INSERT INTO `store_product` VALUES (1, 1, 20, '2023-06-26 12:19:31', '2023-06-26 12:19:56', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
