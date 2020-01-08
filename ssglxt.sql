/*
 Navicat Premium Data Transfer

 Source Server         : pxxyca
 Source Server Type    : MySQL
 Source Server Version : 50022
 Source Host           : localhost:3306
 Source Schema         : ssglxt

 Target Server Type    : MySQL
 Target Server Version : 50022
 File Encoding         : 65001

 Date: 08/06/2019 16:46:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ssglxt_admin
-- ----------------------------
DROP TABLE IF EXISTS `ssglxt_admin`;
CREATE TABLE `ssglxt_admin`  (
  `admin_id` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `admin_jobNumber` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_sex` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_age` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_jobBuilding` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_creat_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_modify_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_role` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`admin_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ssglxt_admin
-- ----------------------------
INSERT INTO `ssglxt_admin` VALUES ('06da972b-354e-4e2f-a3a9-57d73ea42170', '003', '哈拿', '男', '50', '3号楼', '1879371511', '江西南昌', '000000', '2019-05-31 17:40:15', '2019-05-31 17:40:15', '2');
INSERT INTO `ssglxt_admin` VALUES ('458d45a4-28c5-419a-99ee-d5a8d81b40af', '002', '忽忽', '女', '54', '2号楼', '182482135435', '江西南昌', '000000', '2019-05-31 17:39:29', '2019-05-31 17:39:29', '2');
INSERT INTO `ssglxt_admin` VALUES ('4b55d266-e82a-47bd-8617-642757c1bf2b', '001', '王王', '女', '50', '1号楼', '177471837593', '江西南昌', '000000', '2019-05-31 17:38:55', '2019-05-31 17:38:55', '2');

-- ----------------------------
-- Table structure for ssglxt_bed
-- ----------------------------
DROP TABLE IF EXISTS `ssglxt_bed`;
CREATE TABLE `ssglxt_bed`  (
  `bed_id` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `bed_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bed_status` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bed_buildingName` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bed_dormitoryName` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bed_studentId` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bed_creat_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bed_modify_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`bed_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ssglxt_bed
-- ----------------------------
INSERT INTO `ssglxt_bed` VALUES ('11959d5d-4f0d-419d-ac21-259e150b5f3e', '02', NULL, '5号楼', '501', NULL, '2019-05-31 17:24:19', '2019-05-31 17:24:19');
INSERT INTO `ssglxt_bed` VALUES ('13267605-8d27-4353-a94c-a384bd6e126a', '01', NULL, '2号楼', '201', NULL, '2019-05-31 17:23:27', '2019-05-31 17:23:27');
INSERT INTO `ssglxt_bed` VALUES ('2cdf3ba8-c780-4322-a12d-46cefbca3afc', '01', NULL, '3号楼', '301', NULL, '2019-05-31 17:23:40', '2019-05-31 17:23:40');
INSERT INTO `ssglxt_bed` VALUES ('40ca038b-599f-4721-a749-3a286c7b1a7c', '02', NULL, '1号楼', '102', NULL, '2019-05-31 17:23:19', '2019-05-31 17:23:19');
INSERT INTO `ssglxt_bed` VALUES ('5be38e61-39c3-4db8-bb3f-407cd1f6e43a', '02', NULL, '3号楼', '301', NULL, '2019-05-31 17:23:47', '2019-05-31 17:23:47');
INSERT INTO `ssglxt_bed` VALUES ('75a59f0e-fb83-4802-97ee-19d2525cd69f', '02', NULL, '4号楼', '401', NULL, '2019-05-31 17:24:09', '2019-05-31 17:24:09');
INSERT INTO `ssglxt_bed` VALUES ('c3ab96b6-c36e-4975-9a48-e26b7d665a8f', '01', NULL, '4号楼', '401', NULL, '2019-05-31 17:24:00', '2019-05-31 17:24:00');
INSERT INTO `ssglxt_bed` VALUES ('dc9a37b7-9d6a-441b-80f2-7a87ee013290', '01', NULL, '1号楼', '102', NULL, '2019-05-31 17:23:13', '2019-05-31 17:23:13');
INSERT INTO `ssglxt_bed` VALUES ('e604ba7c-6451-4097-a859-3a798f142a36', '02', NULL, '1号楼', '101', NULL, '2019-05-31 17:22:07', '2019-05-31 17:22:07');
INSERT INTO `ssglxt_bed` VALUES ('e6f5d5ed-2c2f-4be0-989c-8d08b31d37d1', '02', NULL, '2号楼', '201', NULL, '2019-05-31 17:23:34', '2019-05-31 17:23:34');
INSERT INTO `ssglxt_bed` VALUES ('eed8b978-794e-4462-b284-c17297cb23ec', '01', NULL, '1号楼', '101', NULL, '2019-05-31 17:21:43', '2019-05-31 17:21:43');
INSERT INTO `ssglxt_bed` VALUES ('f7142953-3c18-4ece-8ad1-e78388941389', '01', NULL, '5号楼', '501', NULL, '2019-05-31 17:24:14', '2019-05-31 17:24:14');

-- ----------------------------
-- Table structure for ssglxt_break
-- ----------------------------
DROP TABLE IF EXISTS `ssglxt_break`;
CREATE TABLE `ssglxt_break`  (
  `break_id` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `break_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `break_time` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `break_studentId` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `break_creat_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `break_modify_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`break_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ssglxt_break
-- ----------------------------
INSERT INTO `ssglxt_break` VALUES ('009c004d-be72-4a3f-a444-df6e98d0aa51', '晚归', '2019 - 5 - 15', '2019002', '2019-05-31 17:35:06', '2019-05-31 17:35:06');
INSERT INTO `ssglxt_break` VALUES ('7494d854-bad7-4ea9-abf3-15ef74b7ee90', '晚归', '2019 - 5 - 17', '2019001', '2019-05-31 17:34:16', '2019-05-31 17:35:53');
INSERT INTO `ssglxt_break` VALUES ('b5277a86-48f0-4d3c-b7bf-7b7f9a267f97', '晚归', '2019 - 5 - 14', '2019002', '2019-05-31 17:34:40', '2019-05-31 17:34:40');

-- ----------------------------
-- Table structure for ssglxt_dormitory
-- ----------------------------
DROP TABLE IF EXISTS `ssglxt_dormitory`;
CREATE TABLE `ssglxt_dormitory`  (
  `dormitory_id` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `dormitory_buildingName` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormitory_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormitory_scale` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormitory_liveStatus` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormitory_studentId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormitory_creat_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormitory_modify_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`dormitory_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ssglxt_dormitory
-- ----------------------------
INSERT INTO `ssglxt_dormitory` VALUES ('29107350-8f3d-42e3-ab83-1ad2406fa774', '1号楼', '102', '2人', NULL, NULL, '2019-05-31 17:21:23', '2019-05-31 17:22:18');
INSERT INTO `ssglxt_dormitory` VALUES ('660ffd15-b426-4aff-8c27-b41498ef1c11', '3号楼', '301', '2人', NULL, NULL, '2019-05-31 17:20:35', '2019-05-31 17:22:38');
INSERT INTO `ssglxt_dormitory` VALUES ('755aeba4-6c23-4241-a545-26b5036c60d3', '1号楼', '101', '2人', NULL, NULL, '2019-05-31 17:20:06', '2019-05-31 17:22:52');
INSERT INTO `ssglxt_dormitory` VALUES ('994e06cd-1b44-45e3-ac62-677cbf11b82d', '5号楼', '501', '2人', NULL, NULL, '2019-05-31 17:20:57', '2019-05-31 17:22:24');
INSERT INTO `ssglxt_dormitory` VALUES ('e70e51b3-0b49-4041-b700-902f78b246c1', '2号楼', '201', '2人', NULL, NULL, '2019-05-31 17:20:21', '2019-05-31 17:22:45');
INSERT INTO `ssglxt_dormitory` VALUES ('ffa50017-5bf7-47db-9b53-4fe491f6da5a', '4号楼', '401', '2人', NULL, NULL, '2019-05-31 17:20:47', '2019-05-31 17:22:30');

-- ----------------------------
-- Table structure for ssglxt_dormitorybuilding
-- ----------------------------
DROP TABLE IF EXISTS `ssglxt_dormitorybuilding`;
CREATE TABLE `ssglxt_dormitorybuilding`  (
  `dormitoryBuilding_id` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `dormitoryBuilding_buildingName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormitoryBuilding_roomNumber` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormitoryBuilding_liveSex` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormitoryBuilding_creat_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormitoryBuilding_modify_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`dormitoryBuilding_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ssglxt_dormitorybuilding
-- ----------------------------
INSERT INTO `ssglxt_dormitorybuilding` VALUES ('0e70c256-4ee4-49c0-98da-12379dd71754', '2号楼', '15', '男', '2019-05-31 17:10:15', '2019-05-31 17:11:32');
INSERT INTO `ssglxt_dormitorybuilding` VALUES ('1d3a2164-3e2c-41a0-82b2-7d191bcaa924', '4号楼', '20', '女', '2019-05-31 17:10:42', '2019-05-31 17:11:26');
INSERT INTO `ssglxt_dormitorybuilding` VALUES ('4f4e2185-40b4-4493-ab98-efd3703ec3d2', '5号楼', '12', '男', '2019-05-31 17:10:55', '2019-05-31 17:11:09');
INSERT INTO `ssglxt_dormitorybuilding` VALUES ('a0c9c5ae-d2f3-4d0f-8542-6c31a95d78e9', '3号楼', '30', '女', '2019-05-31 17:10:28', '2019-05-31 17:11:29');
INSERT INTO `ssglxt_dormitorybuilding` VALUES ('e7e0f8e5-7526-4f1d-a37d-484b54f1a649', '1号楼', '20', '男', '2019-05-31 17:10:03', '2019-05-31 17:11:34');

-- ----------------------------
-- Table structure for ssglxt_repair
-- ----------------------------
DROP TABLE IF EXISTS `ssglxt_repair`;
CREATE TABLE `ssglxt_repair`  (
  `repair_id` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `repair_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `repair_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `repair_studentId` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `repair_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `repair_creat_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `repair_modify_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`repair_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ssglxt_repair
-- ----------------------------
INSERT INTO `ssglxt_repair` VALUES ('0cc826f9-60f6-4b11-a774-871ef8c99004', '桌子', '损坏', '2019001', '待处理', '2019-05-31 17:36:31', '2019-04-28 17:44:02');
INSERT INTO `ssglxt_repair` VALUES ('9dcb4e19-2763-4b6f-abc8-2d9cff9124fe', '桌子', '损坏', '2019001', '待处理', '2019-05-31 17:45:57', '2019-05-31 17:46:34');
INSERT INTO `ssglxt_repair` VALUES ('d8a1f87a-771f-42a7-a332-3d2b60b853da', '椅子', '损坏', '2019001', '已处理', '2019-05-31 17:37:02', '2019-04-30 17:37:19');

-- ----------------------------
-- Table structure for ssglxt_student
-- ----------------------------
DROP TABLE IF EXISTS `ssglxt_student`;
CREATE TABLE `ssglxt_student`  (
  `student_id` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `student_studentId` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_sex` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_IDNUMBER` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_faculty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_phone` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_buildingName` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_dormitoryName` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_bedName` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_checkIn_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_changeSleep_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_retireSleep` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_retireSleep_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_creat_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_modify_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_role` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`student_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ssglxt_student
-- ----------------------------
INSERT INTO `ssglxt_student` VALUES ('2152c1dc-4641-4c43-bfba-5da2389d1671', '2019004', '张七', '男', '273847837598439684', '文学院', '汉语言', '一班', '184897419751893', '江西南昌', '2号楼', '201', '01', '2019 - 5 - 31', NULL, NULL, NULL, '000000', '2019-05-31 17:33:10', '2019-05-31 17:33:10', '1');
INSERT INTO `ssglxt_student` VALUES ('7b0be179-d81a-46af-bb99-ec9aef4a1ccb', '2019003', '李无', '男', '7579275891913', '计算机院', '软件工程', '一班', '2957923752794', '江西萍乡', '2号楼', '201', '02', '2018 - 9 - 1', NULL, NULL, NULL, '000000', '2019-05-31 17:31:46', '2019-05-31 17:31:46', '1');
INSERT INTO `ssglxt_student` VALUES ('c85d6e6d-7a51-43d7-a519-dfdbee9b903f', '2019001', '张三', '男', '675845728758545', '计算机院', '计算机技术', '一班', '238538757133', '江西南昌', '1号楼', '102', '02', '2018 - 9 - 1', NULL, NULL, NULL, '000000', '2019-05-31 17:26:51', '2019-05-31 17:29:59', '1');
INSERT INTO `ssglxt_student` VALUES ('d41e99b1-d1e2-4ac3-936f-10d1f7c2bae0', '2019002', '李四', '男', '2897572872975', '文学院', '汉语言', '一班', '2775872949113', '江西南昌', '1号楼', '102', '01', '2018 - 9 - 1', NULL, NULL, NULL, '000000', '2019-05-31 17:29:27', '2019-05-31 17:29:49', '1');

-- ----------------------------
-- Table structure for ssglxt_superadmin
-- ----------------------------
DROP TABLE IF EXISTS `ssglxt_superadmin`;
CREATE TABLE `ssglxt_superadmin`  (
  `superAdmin_id` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `superAdmin_jobNumber` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `superAdmin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `superAdmin_creat_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `superAdmin_modify_time` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `superAdmin_role` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `superAdmin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`superAdmin_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ssglxt_superadmin
-- ----------------------------
INSERT INTO `ssglxt_superadmin` VALUES ('1', '001', '1', NULL, NULL, '3', '超级管理员');

SET FOREIGN_KEY_CHECKS = 1;
