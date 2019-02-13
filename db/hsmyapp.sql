/*
 Navicat Premium Data Transfer

 Source Server         : hsmyapp
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : hsmyapp

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 13/02/2019 10:18:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `age` int(2) NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of demo
-- ----------------------------
INSERT INTO `demo` VALUES (20, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for hsmy_infoenum
-- ----------------------------
DROP TABLE IF EXISTS `hsmy_infoenum`;
CREATE TABLE `hsmy_infoenum`  (
  `infoenum` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '信息类型ID',
  `infodesc` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息描述',
  PRIMARY KEY (`infoenum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '信息分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hsmy_infoenum
-- ----------------------------
INSERT INTO `hsmy_infoenum` VALUES ('1000', '车位信息');

-- ----------------------------
-- Table structure for hsmy_infopub
-- ----------------------------
DROP TABLE IF EXISTS `hsmy_infopub`;
CREATE TABLE `hsmy_infopub`  (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `open_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `mobile_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `info_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '信息标题',
  `info_enum` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '信息类型ID',
  `info_data` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息有效时间',
  `info_desc` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息详情',
  `last_date` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1002 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '信息发布' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hsmy_infopub
-- ----------------------------
INSERT INTO `hsmy_infopub` VALUES (1000, '12', '15355031006', 'tedemo', '1000', '2018-12-24', '1111', '2018-12-24 00:00:00');
INSERT INTO `hsmy_infopub` VALUES (1001, '123', '15355030079', 'testdemo', '1000', '2018-12-24', '22222', '2018-12-24 08:08:08');

-- ----------------------------
-- Table structure for hsmy_reqlog
-- ----------------------------
DROP TABLE IF EXISTS `hsmy_reqlog`;
CREATE TABLE `hsmy_reqlog`  (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `login_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆名',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `class_name` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类名',
  `method` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `time` bigint(19) NULL DEFAULT NULL COMMENT '执行时长',
  `client_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户端ip',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `token_id` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'req token',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1131 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hsmy_reqlog
-- ----------------------------
INSERT INTO `hsmy_reqlog` VALUES (893, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"021FGX0y1bYbG90Vu02y14o31y1FGX0V\";', NULL, '127.0.0.1', '2018-12-16 18:53:51', 'default');
INSERT INTO `hsmy_reqlog` VALUES (894, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-16 18:53:51', 'default');
INSERT INTO `hsmy_reqlog` VALUES (895, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-16 18:53:51', 'default');
INSERT INTO `hsmy_reqlog` VALUES (896, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.getUser()', 'teamId:1;openId:\"null\";', NULL, '127.0.0.1', '2018-12-16 18:53:52', 'default');
INSERT INTO `hsmy_reqlog` VALUES (897, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"011ArRTz16R1zb0AgpUz1DByTz1ArRT2\";', NULL, '172.18.0.38', '2018-12-16 18:57:38', 'default');
INSERT INTO `hsmy_reqlog` VALUES (898, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0215DuvG0ZlVPd2YXxwG0bjPvG05Duv7\";', NULL, '172.18.0.38', '2018-12-16 18:58:01', 'default');
INSERT INTO `hsmy_reqlog` VALUES (899, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0810331u0z0b1i1DlKZt0JX21u00331H\";', NULL, '172.18.0.38', '2018-12-16 18:58:34', 'default');
INSERT INTO `hsmy_reqlog` VALUES (900, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001Fj7g4040vOK185pg40Nr9g40Fj7gU\";', NULL, '127.0.0.1', '2018-12-16 19:08:55', 'default');
INSERT INTO `hsmy_reqlog` VALUES (901, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001Fj7g4040vOK185pg40Nr9g40Fj7gU\";', NULL, '127.0.0.1', '2018-12-16 19:08:55', 'default');
INSERT INTO `hsmy_reqlog` VALUES (902, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001Fj7g4040vOK185pg40Nr9g40Fj7gU\";', NULL, '127.0.0.1', '2018-12-16 19:08:55', 'default');
INSERT INTO `hsmy_reqlog` VALUES (903, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"07114egs1jHo2m0YeZcs1Nzfgs114egT\";', NULL, '127.0.0.1', '2018-12-16 19:09:49', 'default');
INSERT INTO `hsmy_reqlog` VALUES (904, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-16 19:09:50', 'default');
INSERT INTO `hsmy_reqlog` VALUES (905, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-16 19:09:50', 'default');
INSERT INTO `hsmy_reqlog` VALUES (906, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.getUser()', 'teamId:1;openId:\"oMBNH4_mTCiej8hC9vsWF95IM5ro\";', NULL, '127.0.0.1', '2018-12-16 19:09:51', 'default');
INSERT INTO `hsmy_reqlog` VALUES (907, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071tUPSf2bJMrI07WcSf2ZdHSf2tUPSk\";', NULL, '127.0.0.1', '2018-12-16 19:13:15', 'default');
INSERT INTO `hsmy_reqlog` VALUES (908, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071tUPSf2bJMrI07WcSf2ZdHSf2tUPSk\";', NULL, '127.0.0.1', '2018-12-16 19:13:15', 'default');
INSERT INTO `hsmy_reqlog` VALUES (909, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071tUPSf2bJMrI07WcSf2ZdHSf2tUPSk\";', NULL, '127.0.0.1', '2018-12-16 19:13:15', 'default');
INSERT INTO `hsmy_reqlog` VALUES (910, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071OilJq0T7SQn1NnZHq0jR4Jq0OilJH\";', NULL, '127.0.0.1', '2018-12-16 19:15:50', 'default');
INSERT INTO `hsmy_reqlog` VALUES (911, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071OilJq0T7SQn1NnZHq0jR4Jq0OilJH\";', NULL, '127.0.0.1', '2018-12-16 19:15:50', 'default');
INSERT INTO `hsmy_reqlog` VALUES (912, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071OilJq0T7SQn1NnZHq0jR4Jq0OilJH\";', NULL, '127.0.0.1', '2018-12-16 19:15:50', 'default');
INSERT INTO `hsmy_reqlog` VALUES (913, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0619zRnI1PxzR10X3enI1rKKnI19zRns\";', NULL, '127.0.0.1', '2018-12-16 19:16:51', 'default');
INSERT INTO `hsmy_reqlog` VALUES (914, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-16 19:20:01', 'default');
INSERT INTO `hsmy_reqlog` VALUES (915, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-16 19:20:01', 'default');
INSERT INTO `hsmy_reqlog` VALUES (916, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-16 19:20:01', 'default');
INSERT INTO `hsmy_reqlog` VALUES (917, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-16 19:20:01', 'default');
INSERT INTO `hsmy_reqlog` VALUES (918, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081UjPM62sXexR06WTP62WCaN62UjPMB\";', NULL, '127.0.0.1', '2018-12-16 19:20:01', 'default');
INSERT INTO `hsmy_reqlog` VALUES (919, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081UjPM62sXexR06WTP62WCaN62UjPMB\";', NULL, '127.0.0.1', '2018-12-16 19:20:01', 'default');
INSERT INTO `hsmy_reqlog` VALUES (920, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081UjPM62sXexR06WTP62WCaN62UjPMB\";', NULL, '127.0.0.1', '2018-12-16 19:20:01', 'default');
INSERT INTO `hsmy_reqlog` VALUES (921, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.getUser()', 'teamId:1;openId:\"oMBNH4_mTCiej8hC9vsWF95IM5ro\";', NULL, '127.0.0.1', '2018-12-16 19:20:02', 'default');
INSERT INTO `hsmy_reqlog` VALUES (922, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001rgnE821mUjK0N5VE82UQAE82rgnEe\";', NULL, '127.0.0.1', '2018-12-23 16:19:55', 'default');
INSERT INTO `hsmy_reqlog` VALUES (923, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-23 16:19:55', 'default');
INSERT INTO `hsmy_reqlog` VALUES (924, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-23 16:19:55', 'default');
INSERT INTO `hsmy_reqlog` VALUES (925, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.getUser()', 'teamId:1;openId:\"oMBNH4_mTCiej8hC9vsWF95IM5ro\";', NULL, '127.0.0.1', '2018-12-23 16:19:56', 'default');
INSERT INTO `hsmy_reqlog` VALUES (926, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0611kCcd1nazdy0izu9d1eGGcd11kCcB\";', NULL, '127.0.0.1', '2018-12-23 16:27:51', 'default');
INSERT INTO `hsmy_reqlog` VALUES (927, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-23 16:27:52', 'default');
INSERT INTO `hsmy_reqlog` VALUES (928, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-23 16:27:52', 'default');
INSERT INTO `hsmy_reqlog` VALUES (929, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.getUser()', 'teamId:1;openId:\"oMBNH4_mTCiej8hC9vsWF95IM5ro\";', NULL, '127.0.0.1', '2018-12-23 16:27:52', 'default');
INSERT INTO `hsmy_reqlog` VALUES (930, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"021rHBR61go0PL1JB1U611hVR61rHBRg\";', NULL, '127.0.0.1', '2018-12-23 16:47:38', 'default');
INSERT INTO `hsmy_reqlog` VALUES (931, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-23 16:47:39', 'default');
INSERT INTO `hsmy_reqlog` VALUES (932, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-23 16:47:39', 'default');
INSERT INTO `hsmy_reqlog` VALUES (933, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.getUser()', 'teamId:1;openId:\"oMBNH4_mTCiej8hC9vsWF95IM5ro\";', NULL, '127.0.0.1', '2018-12-23 16:47:39', 'default');
INSERT INTO `hsmy_reqlog` VALUES (934, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081jVXDb2kJQhN0N1tFb2xDZDb2jVXD1\";', NULL, '127.0.0.1', '2018-12-23 16:54:48', 'default');
INSERT INTO `hsmy_reqlog` VALUES (935, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-23 16:54:49', 'default');
INSERT INTO `hsmy_reqlog` VALUES (936, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.findAll()', '', NULL, '127.0.0.1', '2018-12-23 16:54:49', 'default');
INSERT INTO `hsmy_reqlog` VALUES (937, NULL, NULL, NULL, 'com.hsmy.app.web.TeamController.getUser()', 'teamId:1;openId:\"oMBNH4_mTCiej8hC9vsWF95IM5ro\";', NULL, '127.0.0.1', '2018-12-23 16:54:49', 'default');
INSERT INTO `hsmy_reqlog` VALUES (938, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0014BG322osg1W0RaH222i8H3224BG3t\";', NULL, '127.0.0.1', '2018-12-23 16:57:21', 'default');
INSERT INTO `hsmy_reqlog` VALUES (939, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0014BG322osg1W0RaH222i8H3224BG3t\";', NULL, '127.0.0.1', '2018-12-23 16:57:21', 'default');
INSERT INTO `hsmy_reqlog` VALUES (940, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0014BG322osg1W0RaH222i8H3224BG3t\";', NULL, '127.0.0.1', '2018-12-23 16:57:21', 'default');
INSERT INTO `hsmy_reqlog` VALUES (941, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0117RMwo0iJutl1mUcxo0eyPwo07RMwi\";', NULL, '172.17.0.119', '2018-12-23 17:00:22', 'default');
INSERT INTO `hsmy_reqlog` VALUES (942, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"011rBazk1fRQrn0YESAk1PRdzk1rBazD\";', NULL, '172.17.0.119', '2018-12-23 17:02:05', 'default');
INSERT INTO `hsmy_reqlog` VALUES (943, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081yz2vG0kJ8Td2ihGtG0IT1vG0yz2vi\";', NULL, '172.17.0.119', '2018-12-23 17:22:07', 'default');
INSERT INTO `hsmy_reqlog` VALUES (944, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"021J86sX0FVHnU1c8GpX0Oa8sX0J86sh\";', NULL, '172.17.0.119', '2018-12-23 17:24:31', 'default');
INSERT INTO `hsmy_reqlog` VALUES (945, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001Vqia91NiX3O1iyc991mg5a91VqiaK\";', NULL, '172.17.0.119', '2018-12-23 17:25:32', 'default');
INSERT INTO `hsmy_reqlog` VALUES (946, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0017VDEj1EEdKv0MjUDj13yyEj17VDEq\";', NULL, '172.17.0.119', '2018-12-23 17:26:37', 'default');
INSERT INTO `hsmy_reqlog` VALUES (947, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071sZNMB1vL7Cd0FbGNB1sp3NB1sZNMe\";', NULL, '172.17.0.119', '2018-12-23 17:29:16', 'default');
INSERT INTO `hsmy_reqlog` VALUES (948, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '172.17.0.119', '2018-12-23 17:29:20', 'default');
INSERT INTO `hsmy_reqlog` VALUES (949, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081vLxFp0jlJBm1PVKDp0j5dFp0vLxFO\";', NULL, '172.17.0.119', '2018-12-23 17:30:33', 'default');
INSERT INTO `hsmy_reqlog` VALUES (950, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '172.17.0.119', '2018-12-23 17:30:37', 'default');
INSERT INTO `hsmy_reqlog` VALUES (951, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081WqALN11K7T81LYlMN1e6XLN1WqALp\";', NULL, '172.17.0.119', '2018-12-23 17:33:28', 'default');
INSERT INTO `hsmy_reqlog` VALUES (952, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '172.17.0.119', '2018-12-23 17:33:31', 'default');
INSERT INTO `hsmy_reqlog` VALUES (953, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001g2kfB0zmAIh2YxndB0KukfB0g2kfQ\";', NULL, '172.17.0.119', '2018-12-23 17:35:00', 'default');
INSERT INTO `hsmy_reqlog` VALUES (954, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '172.17.0.119', '2018-12-23 17:35:03', 'default');
INSERT INTO `hsmy_reqlog` VALUES (955, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"011X0Tzo0R2bIl1WH6Co0PkHzo0X0TzF\";', NULL, '172.17.0.119', '2018-12-23 17:35:15', 'default');
INSERT INTO `hsmy_reqlog` VALUES (956, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '172.17.0.119', '2018-12-23 17:35:17', 'default');
INSERT INTO `hsmy_reqlog` VALUES (957, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"011hHAxP0xfjQ42HO0xP0VPGxP0hHAxK\";', NULL, '172.17.0.119', '2018-12-23 17:37:33', 'default');
INSERT INTO `hsmy_reqlog` VALUES (958, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '172.17.0.119', '2018-12-23 17:37:35', 'default');
INSERT INTO `hsmy_reqlog` VALUES (959, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"061b2xhN1iRDw81b8yiN1ntrhN1b2xhI\";', NULL, '172.17.0.119', '2018-12-23 17:42:47', 'default');
INSERT INTO `hsmy_reqlog` VALUES (960, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '172.17.0.119', '2018-12-23 17:42:50', 'default');
INSERT INTO `hsmy_reqlog` VALUES (961, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"1\";', NULL, '172.17.0.118', '2018-12-23 17:44:37', 'default');
INSERT INTO `hsmy_reqlog` VALUES (962, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"2\";', NULL, '172.17.0.118', '2018-12-23 17:44:49', 'default');
INSERT INTO `hsmy_reqlog` VALUES (963, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '172.17.0.118', '2018-12-23 17:45:45', 'default');
INSERT INTO `hsmy_reqlog` VALUES (964, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081xp3Wv1xvSCg0iuAWv1za1Wv1xp3W1\";', NULL, '172.17.0.119', '2018-12-23 17:46:25', 'default');
INSERT INTO `hsmy_reqlog` VALUES (965, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '172.17.0.119', '2018-12-23 17:46:28', 'default');
INSERT INTO `hsmy_reqlog` VALUES (966, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '172.17.0.118', '2018-12-23 17:49:12', 'default');
INSERT INTO `hsmy_reqlog` VALUES (967, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '172.17.0.118', '2018-12-23 17:49:43', 'default');
INSERT INTO `hsmy_reqlog` VALUES (968, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001AReb91qoJ2O1XKpe91Xkmb91ARebe\";', NULL, '172.17.0.119', '2018-12-23 17:52:05', 'default');
INSERT INTO `hsmy_reqlog` VALUES (969, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '172.17.0.119', '2018-12-23 17:52:09', 'default');
INSERT INTO `hsmy_reqlog` VALUES (970, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"011EVIgw1PWZ8h0z9kiw1UUzgw1EVIgE\";', NULL, '172.17.0.119', '2018-12-23 17:53:10', 'default');
INSERT INTO `hsmy_reqlog` VALUES (971, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '172.17.0.119', '2018-12-23 17:53:19', 'default');
INSERT INTO `hsmy_reqlog` VALUES (972, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0712OFcq1lX75k0ONHcq1J8Ncq12OFc8\";', NULL, '172.17.0.119', '2018-12-23 17:54:57', 'default');
INSERT INTO `hsmy_reqlog` VALUES (973, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '172.17.0.119', '2018-12-23 17:54:59', 'default');
INSERT INTO `hsmy_reqlog` VALUES (974, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '172.17.0.118', '2018-12-23 17:59:23', 'default');
INSERT INTO `hsmy_reqlog` VALUES (975, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '192.168.0.100', '2018-12-23 20:18:38', 'default');
INSERT INTO `hsmy_reqlog` VALUES (976, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"021fdFWs1jlpEd0OmWWs1VstWs1fdFWa\";', NULL, '192.168.0.106', '2018-12-23 20:33:57', 'default');
INSERT INTO `hsmy_reqlog` VALUES (977, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 20:34:04', 'default');
INSERT INTO `hsmy_reqlog` VALUES (978, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"061ipijF1ZaNO70XGciF1mmpjF1ipijK\";', NULL, '192.168.0.106', '2018-12-23 20:48:14', 'default');
INSERT INTO `hsmy_reqlog` VALUES (979, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 20:48:16', 'default');
INSERT INTO `hsmy_reqlog` VALUES (980, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0715xh8307WWHJ1a1O730cXF8305xh8p\";', NULL, '192.168.0.106', '2018-12-23 20:49:40', 'default');
INSERT INTO `hsmy_reqlog` VALUES (981, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 20:49:45', 'default');
INSERT INTO `hsmy_reqlog` VALUES (982, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.join()', 'user:{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/bwPQic6M3kU3jFiasDX1eAwkHvdmOLrHqMtRsud5libKYNNGSBNNEiaExgvatibBicVnBa6wroLalDe0Uyb7StuDic4vw/132\",\"mobileNo\":\"15355030079\",\"nickName\":\"xlw\",\"openId\":\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\",\"roomNo\":\"2-602\"};', NULL, '192.168.0.106', '2018-12-23 20:53:21', 'default');
INSERT INTO `hsmy_reqlog` VALUES (983, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.join()', 'user:{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/bwPQic6M3kU3jFiasDX1eAwkHvdmOLrHqMtRsud5libKYNNGSBNNEiaExgvatibBicVnBa6wroLalDe0Uyb7StuDic4vw/132\",\"mobileNo\":\"15355030079\",\"nickName\":\"xlw\",\"openId\":\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\",\"roomNo\":\"2-602\"};', NULL, '192.168.0.106', '2018-12-23 20:54:15', 'default');
INSERT INTO `hsmy_reqlog` VALUES (984, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071OxEf60v0IKD1hEqg605qFf60OxEfY\";', NULL, '192.168.0.106', '2018-12-23 20:56:56', 'default');
INSERT INTO `hsmy_reqlog` VALUES (985, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 20:56:58', 'default');
INSERT INTO `hsmy_reqlog` VALUES (986, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 20:57:03', 'default');
INSERT INTO `hsmy_reqlog` VALUES (987, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 20:57:38', 'default');
INSERT INTO `hsmy_reqlog` VALUES (988, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.join()', 'user:{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/bwPQic6M3kU3jFiasDX1eAwkHvdmOLrHqMtRsud5libKYNNGSBNNEiaExgvatibBicVnBa6wroLalDe0Uyb7StuDic4vw/132\",\"mobileNo\":\"15355030079\",\"nickName\":\"xlw\",\"openId\":\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\",\"roomNo\":\"2-602\"};', NULL, '192.168.0.106', '2018-12-23 20:57:55', 'default');
INSERT INTO `hsmy_reqlog` VALUES (989, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.join()', 'user:{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/bwPQic6M3kU3jFiasDX1eAwkHvdmOLrHqMtRsud5libKYNNGSBNNEiaExgvatibBicVnBa6wroLalDe0Uyb7StuDic4vw/132\",\"mobileNo\":\"15355030079\",\"nickName\":\"xlw\",\"openId\":\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\",\"roomNo\":\"2-602\"};', NULL, '192.168.0.106', '2018-12-23 20:58:00', 'default');
INSERT INTO `hsmy_reqlog` VALUES (990, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.join()', 'user:{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/bwPQic6M3kU3jFiasDX1eAwkHvdmOLrHqMtRsud5libKYNNGSBNNEiaExgvatibBicVnBa6wroLalDe0Uyb7StuDic4vw/132\",\"mobileNo\":\"15355030079\",\"nickName\":\"xlw\",\"openId\":\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\",\"roomNo\":\"2-602\"};', NULL, '192.168.0.106', '2018-12-23 20:58:54', 'default');
INSERT INTO `hsmy_reqlog` VALUES (991, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"061cjFoo17epci0J87qo1TFKoo1cjFoB\";', NULL, '192.168.0.106', '2018-12-23 21:02:30', 'default');
INSERT INTO `hsmy_reqlog` VALUES (992, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 21:02:34', 'default');
INSERT INTO `hsmy_reqlog` VALUES (993, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.join()', 'user:{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/bwPQic6M3kU3jFiasDX1eAwkHvdmOLrHqMtRsud5libKYNNGSBNNEiaExgvatibBicVnBa6wroLalDe0Uyb7StuDic4vw/132\",\"mobileNo\":\"15355030079\",\"nickName\":\"xlw\",\"openId\":\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\",\"roomNo\":\"2-602\"};', NULL, '192.168.0.106', '2018-12-23 21:02:49', 'default');
INSERT INTO `hsmy_reqlog` VALUES (994, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001pAR5d0JlbsB17Qh4d01JL5d0pAR5s\";', NULL, '192.168.0.106', '2018-12-23 21:04:51', 'default');
INSERT INTO `hsmy_reqlog` VALUES (995, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 21:05:05', 'default');
INSERT INTO `hsmy_reqlog` VALUES (996, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.join()', 'user:{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/bwPQic6M3kU3jFiasDX1eAwkHvdmOLrHqMtRsud5libKYNNGSBNNEiaExgvatibBicVnBa6wroLalDe0Uyb7StuDic4vw/132\",\"mobileNo\":\"15355030079\",\"nickName\":\"xlw\",\"openId\":\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\",\"roomNo\":\"2-602\"};', NULL, '192.168.0.106', '2018-12-23 21:05:21', 'default');
INSERT INTO `hsmy_reqlog` VALUES (997, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.join()', 'user:{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/bwPQic6M3kU3jFiasDX1eAwkHvdmOLrHqMtRsud5libKYNNGSBNNEiaExgvatibBicVnBa6wroLalDe0Uyb7StuDic4vw/132\",\"mobileNo\":\"15355030079\",\"nickName\":\"xlw\",\"openId\":\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\",\"roomNo\":\"2-602\"};', NULL, '192.168.0.106', '2018-12-23 21:05:28', 'default');
INSERT INTO `hsmy_reqlog` VALUES (998, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 21:11:37', 'default');
INSERT INTO `hsmy_reqlog` VALUES (999, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"061wLyqK1zfMP30gPWmK1lTKqK1wLyqF\";', NULL, '192.168.0.106', '2018-12-23 21:13:12', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1000, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 21:13:14', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1001, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 21:14:06', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1002, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081f2l1Q1rC0621L6F1Q1XqC1Q1f2l1d\";', NULL, '192.168.0.106', '2018-12-23 21:17:28', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1003, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001xNih008VyBG1RfFe00Hvbh00xNihF\";', NULL, '192.168.0.106', '2018-12-23 21:22:18', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1004, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"011hDyLf0q1J5v1U98Mf0cVtLf0hDyLy\";', NULL, '192.168.0.106', '2018-12-23 21:23:04', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1005, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"021FcoGV1NDOHY08qbEV1TfzGV1FcoGg\";', NULL, '192.168.0.106', '2018-12-23 21:23:15', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1006, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"011MEFTj19keZm09TbUj1H4kTj1MEFT6\";', NULL, '192.168.0.106', '2018-12-23 21:23:25', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1007, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0216zus52vXulQ0dSxu52nYxs526zus9\";', NULL, '192.168.0.106', '2018-12-23 21:23:30', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1008, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"061d9pq82SIagK0mk9u82Cifq82d9pqN\";', NULL, '192.168.0.106', '2018-12-23 21:23:54', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1009, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071Qmki91MUsdO197xj91A4Ai91Qmkiv\";', NULL, '192.168.0.106', '2018-12-23 21:24:01', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1010, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081ioYEf1h8VMr01YkFf1iznFf1ioYEz\";', NULL, '192.168.0.106', '2018-12-23 21:24:07', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1011, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071l69F22W66yW0r99F22N4sF22l69Fv\";', NULL, '192.168.0.106', '2018-12-23 21:30:59', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1012, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"011Y8ULy1TlEna03w1My1lFFLy1Y8ULL\";', NULL, '192.168.0.106', '2018-12-23 21:31:45', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1013, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"061czfQk2RnTmE01MNQk2e3dQk2czfQr\";', NULL, '192.168.0.106', '2018-12-23 21:32:01', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1014, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081s3GGC1lBpk507SSCC1gyFGC1s3GGk\";', NULL, '192.168.0.106', '2018-12-23 21:32:34', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1015, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001kq1RT053MXZ1DAnST0W6QQT0kq1RZ\";', NULL, '192.168.0.106', '2018-12-23 21:32:44', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1016, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001sv1US005AVY1IVzRS03WcUS0sv1UG\";', NULL, '192.168.0.106', '2018-12-23 21:34:21', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1017, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001OkFxG1QYu300RNuxG1C3txG1OkFx1\";', NULL, '192.168.0.106', '2018-12-23 21:35:54', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1018, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071fdmwP1fUFxa1MZ8uP1iTawP1fdmw2\";', NULL, '192.168.0.106', '2018-12-23 21:39:51', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1019, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"15355030079\";', NULL, '192.168.0.106', '2018-12-23 21:40:01', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1020, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"011oJ3fa2NpwQL0pjVea2clZea2oJ3fJ\";', NULL, '192.168.0.106', '2018-12-23 21:43:25', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1021, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"15355030079\";', NULL, '192.168.0.106', '2018-12-23 21:43:35', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1022, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"021FNRWt0ZGF2i1EDUYt0v3TWt0FNRW3\";', NULL, '192.168.0.106', '2018-12-23 21:44:07', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1023, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"15355030079\";', NULL, '192.168.0.106', '2018-12-23 21:44:15', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1024, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"15355030079\";', NULL, '192.168.0.106', '2018-12-23 21:44:44', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1025, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"15355030079\";', NULL, '192.168.0.100', '2018-12-23 21:44:50', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1026, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"011fN8zl1X9cro01z4yl1TiVyl1fN8zJ\";', NULL, '192.168.0.106', '2018-12-23 21:45:09', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1027, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355030079\";', NULL, '192.168.0.106', '2018-12-23 21:45:16', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1028, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355030079\";', NULL, '192.168.0.100', '2018-12-23 21:46:18', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1029, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071HaiPU1zgfRX0erNQU1t91PU1HaiP5\";', NULL, '192.168.0.106', '2018-12-23 21:47:13', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1030, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355030079\";', NULL, '192.168.0.106', '2018-12-23 21:47:20', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1031, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355030079\";', NULL, '192.168.0.100', '2018-12-23 21:48:00', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1032, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0113Jt3w19bRMg0uwU1w1XzB3w13Jt30\";', NULL, '192.168.0.106', '2018-12-23 21:53:00', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1033, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0113Jt3w19bRMg0uwU1w1XzB3w13Jt30\";', NULL, '192.168.0.106', '2018-12-23 21:53:00', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1034, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0113Jt3w19bRMg0uwU1w1XzB3w13Jt30\";', NULL, '192.168.0.106', '2018-12-23 21:53:00', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1035, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355030079\";', NULL, '192.168.0.100', '2018-12-23 21:53:19', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1036, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071HyzqT1BuYu516o1rT1erRqT1Hyzqe\";', NULL, '192.168.0.106', '2018-12-23 21:57:05', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1037, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081CNUdK14GRK30av3gK1F1SdK1CNUdi\";', NULL, '192.168.0.106', '2018-12-23 22:00:25', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1038, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:00:29', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1039, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:00:35', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1040, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001PbEej1qzkjv0SXubj1DAPej1PbEed\";', NULL, '192.168.0.106', '2018-12-23 22:01:06', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1041, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:01:09', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1042, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081iwEc22nMI9W0n2Na225ANc22iwEcO\";', NULL, '192.168.0.106', '2018-12-23 22:01:50', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1043, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:01:52', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1044, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081RYr2W0zUj222EZ20W0XzD2W0RYr25\";', NULL, '192.168.0.106', '2018-12-23 22:02:31', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1045, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:02:33', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1046, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"061EeAhh0NuGpw1haKfh0ACPhh0EeAh8\";', NULL, '192.168.0.106', '2018-12-23 22:02:58', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1047, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:02:59', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1048, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0015pMe61FvF1L1208f613IAe615pMef\";', NULL, '192.168.0.106', '2018-12-23 22:03:32', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1049, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:03:34', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1050, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:03:49', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1051, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081FegT71aNrMM18p1S71mJbT71FegT0\";', NULL, '192.168.0.106', '2018-12-23 22:04:02', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1052, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:04:03', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1053, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081oSGtL03J4L92NX0xL0eHwtL0oSGtP\";', NULL, '192.168.0.106', '2018-12-23 22:05:02', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1054, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:05:04', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1055, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071GMMw32nVWiO0csWz32FOAw32GMMwo\";', NULL, '192.168.0.106', '2018-12-23 22:05:28', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1056, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:05:30', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1057, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"011BR5121Hcj6Q1COS121jbK021BR51h\";', NULL, '192.168.0.106', '2018-12-23 22:06:01', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1058, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:06:06', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1059, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"021fY1b31ceXcR1S7lb313gOa31fY1bm\";', NULL, '192.168.0.106', '2018-12-23 22:06:56', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1060, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:07:03', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1061, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001sOSp61xiHpL19eSs61ZJiq61sOSpq\";', NULL, '192.168.0.106', '2018-12-23 22:07:55', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1062, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:07:57', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1063, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"021uDAfn1M6S9q0SJfhn1Xfjfn1uDAfC\";', NULL, '192.168.0.106', '2018-12-23 22:09:49', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1064, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:09:51', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1065, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"011K7Tvs1prDjm0OPaus1twTvs1K7Tv9\";', NULL, '192.168.0.106', '2018-12-23 22:10:44', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1066, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.106', '2018-12-23 22:11:02', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1067, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '192.168.0.100', '2018-12-23 22:52:32', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1068, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '192.168.0.100', '2018-12-23 22:54:02', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1069, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 10:04:39', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1070, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 10:05:41', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1071, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 10:17:47', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1072, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 10:36:27', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1073, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 10:37:57', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1074, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 10:39:06', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1075, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 10:41:08', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1076, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355030079\";', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 10:41:39', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1077, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 10:54:48', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1078, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 11:14:09', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1079, NULL, NULL, NULL, 'com.hsmy.app.web.HsmyInfoController.selectUnfo()', '', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 20:48:45', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1080, NULL, NULL, NULL, 'com.hsmy.app.web.HsmyInfoController.selectUnfo()', '', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 20:53:01', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1081, NULL, NULL, NULL, 'com.hsmy.app.web.HsmyInfoController.selectUnfo()', '', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 20:53:08', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1082, NULL, NULL, NULL, 'com.hsmy.app.web.HsmyInfoController.selectUnfo()', '', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 20:58:30', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1083, NULL, NULL, NULL, 'com.hsmy.app.web.HsmyInfoController.selectUnfo()', '', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 21:12:18', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1084, NULL, NULL, NULL, 'com.hsmy.app.web.HsmyInfoController.selectUnfo()', '', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 21:17:50', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1085, NULL, NULL, NULL, 'com.hsmy.app.web.HsmyInfoController.selectUnfo()', '', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 21:22:22', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1086, NULL, NULL, NULL, 'com.hsmy.app.web.HsmyInfoController.selectUnfo()', '', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 21:34:48', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1087, NULL, NULL, NULL, 'com.hsmy.app.web.HsmyInfoController.selectUnfo()', '', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 21:35:25', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1088, NULL, NULL, NULL, 'com.hsmy.app.web.HsmyInfoController.selectUnfo()', '', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 21:40:20', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1089, NULL, NULL, NULL, 'com.hsmy.app.web.HsmyInfoController.selectUnfo()', '', NULL, '0:0:0:0:0:0:0:1', '2018-12-24 21:42:01', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1090, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"021UcT3N15qCk81R5E3N1NQK3N1UcT3q\";', NULL, '192.168.0.107', '2018-12-24 21:51:57', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1091, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.107', '2018-12-24 21:52:03', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1092, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"011eOP0z0e1U1e1JzV2z0BkJ0z0eOP0W\";', NULL, '192.168.0.107', '2018-12-24 21:53:07', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1093, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.107', '2018-12-24 21:53:13', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1094, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355030079\";', NULL, '192.168.0.107', '2018-12-24 21:53:31', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1095, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071KJgrD1pCOc60q9CqD1A57rD1KJgrV\";', NULL, '192.168.0.107', '2018-12-24 21:57:45', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1096, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.107', '2018-12-24 21:57:52', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1097, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355030079\";', NULL, '192.168.0.107', '2018-12-24 21:57:59', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1098, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"011GO2241wbGQR1Ojy1414Uh241GO22H\";', NULL, '192.168.0.107', '2018-12-24 22:04:13', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1099, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"061lbVML1ch7M614TyNL137kNL1lbVM9\";', NULL, '192.168.0.107', '2018-12-24 22:06:46', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1100, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0819FQJo0nPXUl1iPiHo0oHxJo09FQJL\";', NULL, '192.168.0.107', '2018-12-24 22:07:15', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1101, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001rgAf00PE3zG1d1xd00oDIf00rgAfp\";', NULL, '192.168.0.107', '2018-12-24 22:08:05', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1102, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.107', '2018-12-24 22:08:10', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1103, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15255030079\";', NULL, '192.168.0.107', '2018-12-24 22:08:19', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1104, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"061H6wm02RQOnU0H9Pk02wLSm02H6wmF\";', NULL, '192.168.0.107', '2018-12-24 22:08:51', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1105, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001hFZhy14oM8a0kG4iy1xT3iy1hFZhm\";', NULL, '192.168.0.107', '2018-12-24 22:09:35', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1106, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.107', '2018-12-24 22:09:45', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1107, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355030079\";', NULL, '192.168.0.107', '2018-12-24 22:09:53', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1108, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001dQgqi2YEgPB0KNkui214uqi2dQgqi\";', NULL, '192.168.0.107', '2018-12-24 22:11:30', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1109, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.107', '2018-12-24 22:11:32', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1110, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355030079\";', NULL, '192.168.0.107', '2018-12-24 22:11:44', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1111, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0117rjqG18NkU805qxpG1JytqG17rjqW\";', NULL, '192.168.0.107', '2018-12-24 22:13:16', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1112, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.107', '2018-12-24 22:13:21', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1113, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355030079\";', NULL, '192.168.0.107', '2018-12-24 22:13:28', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1114, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001yWCA12I1xBV0blkB12vURA12yWCAn\";', NULL, '192.168.0.107', '2018-12-24 22:16:00', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1115, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.107', '2018-12-24 22:16:05', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1116, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"13234354543\";', NULL, '192.168.0.107', '2018-12-24 22:16:15', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1117, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"001GHEjK0b4KK82cWRiK0VWDjK0GHEjc\";', NULL, '192.168.0.107', '2018-12-24 22:19:35', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1118, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"0119BACj0PihTp1CKHBj0GBICj09BACM\";', NULL, '192.168.0.107', '2018-12-24 22:19:49', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1119, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.107', '2018-12-24 22:19:54', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1120, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355030079\";', NULL, '192.168.0.107', '2018-12-24 22:20:01', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1121, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"081Pedu12fZivV0WVVt12tG6u12Pedub\";', NULL, '192.168.0.107', '2018-12-24 22:20:14', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1122, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\";', NULL, '192.168.0.107', '2018-12-24 22:20:17', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1123, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355030079\";', NULL, '192.168.0.107', '2018-12-24 22:20:25', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1124, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.join()', 'user:{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/bwPQic6M3kU3jFiasDX1eAwkHvdmOLrHqMtRsud5libKYNNGSBNNEiaExgvatibBicVnBa6wroLalDe0Uyb7StuDic4vw/132\",\"mobileNo\":\"15355030079\",\"nickName\":\"xlw\",\"openId\":\"oquGP4i9_AsHCB5m22J1Tgp2WzCk\",\"roomNo\":\"3-1-103\"};', NULL, '192.168.0.107', '2018-12-24 22:21:11', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1125, NULL, NULL, NULL, 'com.hsmy.app.web.HsmyInfoController.selectUnfo()', '', NULL, '0:0:0:0:0:0:0:1', '2019-01-28 21:41:29', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1126, NULL, NULL, NULL, 'com.hsmy.app.web.HsmyInfoController.selectUnfo()', '', NULL, '0:0:0:0:0:0:0:1', '2019-02-13 10:11:05', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1127, NULL, NULL, NULL, 'com.hsmy.app.web.WechatController.getOpenId()', 'jsCode:\"071zgmUC1Issn50FNdSC1oHZTC1zgmUJ\";', NULL, '0:0:0:0:0:0:0:1', '2019-02-13 10:12:58', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1128, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.getUser()', 'openId:\"oquGP4kWM4Zrfkz1Ymt2A7MlADVU\";', NULL, '0:0:0:0:0:0:0:1', '2019-02-13 10:13:00', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1129, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.sendMsg()', 'phoneno:\"15355031006\";', NULL, '0:0:0:0:0:0:0:1', '2019-02-13 10:13:21', 'default');
INSERT INTO `hsmy_reqlog` VALUES (1130, NULL, NULL, NULL, 'com.hsmy.app.web.LoginController.join()', 'user:{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epd2GNcwkicKj2CP58M0Ume6F8eodOa4BqRCt6qYEtJuvR8iaSS00PUtib02K7ouJtBA80CSFcBf6QXw/132\",\"mobileNo\":\"15355031006\",\"nickName\":\"先明\",\"openId\":\"oquGP4kWM4Zrfkz1Ymt2A7MlADVU\",\"roomNo\":\"2-602\"};', NULL, '0:0:0:0:0:0:0:1', '2019-02-13 10:13:34', 'default');

-- ----------------------------
-- Table structure for hsmy_syslog
-- ----------------------------
DROP TABLE IF EXISTS `hsmy_syslog`;
CREATE TABLE `hsmy_syslog`  (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `login_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆名',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `class_name` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类名',
  `method` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `time` bigint(19) NULL DEFAULT NULL COMMENT '执行时长',
  `client_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户端ip',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hsmy_user
-- ----------------------------
DROP TABLE IF EXISTS `hsmy_user`;
CREATE TABLE `hsmy_user`  (
  `open_id` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nick_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar_url` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `room_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`open_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hsmy_user
-- ----------------------------
INSERT INTO `hsmy_user` VALUES ('oquGP4i9_AsHCB5m22J1Tgp2WzCk', 'xlw', 'https://wx.qlogo.cn/mmopen/vi_32/bwPQic6M3kU3jFiasDX1eAwkHvdmOLrHqMtRsud5libKYNNGSBNNEiaExgvatibBicVnBa6wroLalDe0Uyb7StuDic4vw/132', '15355030079', '3-1-103');
INSERT INTO `hsmy_user` VALUES ('oquGP4kWM4Zrfkz1Ymt2A7MlADVU', '先明', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epd2GNcwkicKj2CP58M0Ume6F8eodOa4BqRCt6qYEtJuvR8iaSS00PUtib02K7ouJtBA80CSFcBf6QXw/132', '15355031006', '2-602');

-- ----------------------------
-- Table structure for meeting_room
-- ----------------------------
DROP TABLE IF EXISTS `meeting_room`;
CREATE TABLE `meeting_room`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `room_no` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `size` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `terminal_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vnedor` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `team_id` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of meeting_room
-- ----------------------------
INSERT INTO `meeting_room` VALUES (1, '182.207.96.163', '3201', '大', '21169', '视频', '思科', '1');
INSERT INTO `meeting_room` VALUES (2, '182.207.96.166', '3202', '中', '120706', '视频', '华为', '1');
INSERT INTO `meeting_room` VALUES (3, NULL, '3203', '小', NULL, '普通', NULL, '1');
INSERT INTO `meeting_room` VALUES (4, NULL, '3207', '小', NULL, '普通', NULL, '1');
INSERT INTO `meeting_room` VALUES (5, NULL, '3403', '小', NULL, '普通', NULL, '1');

-- ----------------------------
-- Table structure for mybatisdemo
-- ----------------------------
DROP TABLE IF EXISTS `mybatisdemo`;
CREATE TABLE `mybatisdemo`  (
  `id` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `team_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for participant
-- ----------------------------
DROP TABLE IF EXISTS `participant`;
CREATE TABLE `participant`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `schedule_id` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `open_id` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nick_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar_url` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `form_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of participant
-- ----------------------------
INSERT INTO `participant` VALUES (1, '2', 'oMBNH4_mTCiej8hC9vsWF95IM5ro', 'zxm', 'demo', '2018-12-03 00:00:00', 'the formId is a mock one');
INSERT INTO `participant` VALUES (2, '3', 'oMBNH4_mTCiej8hC9vsWF95IM5ro', 'zxm', 'demo', '2018-12-13 00:00:00', 'the formId is a mock one');
INSERT INTO `participant` VALUES (3, '4', 'oMBNH4z6eV6QNqpDpMW5GrY5rJLA', 'zxm', 'demo', '2018-12-15 00:00:00', 'the formId is a mock one');

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `meeting_room_id` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `start_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `end_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `creator_open_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_Nick_Name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_Avatar_Url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `repeat_mode` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES (2, 'dns', '1', '09:00', '12:00', '2018-12-03 00:00:00', 'oMBNH4_mTCiej8hC9vsWF95IM5ro', 'zxm', 'demo', 'N');
INSERT INTO `schedule` VALUES (3, '1', '4', '09:00', '12:00', '2018-12-13 00:00:00', 'oMBNH4_mTCiej8hC9vsWF95IM5ro', 'zxm', 'demo', 'N');
INSERT INTO `schedule` VALUES (4, '??', '1', '09:00', '12:00', '2018-12-15 00:00:00', 'oMBNH4z6eV6QNqpDpMW5GrY5rJLA', 'zxm', 'demo', 'N');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `id` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `team_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('1', '深研二部', '一个敏捷的团队', '123456');
INSERT INTO `team` VALUES ('2', '杭州三部', '财政团队', '123456');

-- ----------------------------
-- Table structure for team_user_mapping
-- ----------------------------
DROP TABLE IF EXISTS `team_user_mapping`;
CREATE TABLE `team_user_mapping`  (
  `team_id` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `user_id` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team_user_mapping
-- ----------------------------
INSERT INTO `team_user_mapping` VALUES ('2', '3');
INSERT INTO `team_user_mapping` VALUES ('1', '1');
INSERT INTO `team_user_mapping` VALUES ('1', '2');
INSERT INTO `team_user_mapping` VALUES ('1', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile_no` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `open_id` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nick_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar_url` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhaoxm', '111111', '111111', '普通', NULL);
INSERT INTO `user` VALUES (2, 'zhaoxm8', '122', 'oMBNH4_mTCiej8hC9vsWF95IM5ro', NULL, NULL);
INSERT INTO `user` VALUES (3, 'xxx', '123446577', 'oMBNH4z6eV6QNqpDpMW5GrY5rJLA', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
