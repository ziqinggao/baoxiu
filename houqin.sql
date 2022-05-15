/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : houqin

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 15/05/2022 14:11:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `ip` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip',
  `login_name` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录人',
  `msg` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作',
  `reason` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原因',
  `login_time` datetime NULL DEFAULT NULL,
  `del_flag` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES ('02e3c03bb3c44d6e9106e0c5b1feb8f9', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 12:17:08', 0);
INSERT INTO `login_log` VALUES ('041ac30b09724fc092eb7dc85da83795', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-15 11:28:20', 0);
INSERT INTO `login_log` VALUES ('04643a64377f4ea1a4f5b51b896f2db9', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-14 19:25:48', 0);
INSERT INTO `login_log` VALUES ('06f6ff9e1b554fd9adb4868f894e0d53', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-14 19:25:00', 0);
INSERT INTO `login_log` VALUES ('0cfb480bd569407bab9483a9c3281d63', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-14 19:20:33', 0);
INSERT INTO `login_log` VALUES ('0f9f167237ae42cebe521eeec2f61896', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-15 01:46:22', 0);
INSERT INTO `login_log` VALUES ('19a145c05ffc4dfe9cc0711dbfeb5f73', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 11:49:13', 0);
INSERT INTO `login_log` VALUES ('1e4a07e7da7d48d4a9daeb148a767de4', '172.18.0.16', 'MD5', '退出登录', NULL, '2022-05-15 03:02:22', 0);
INSERT INTO `login_log` VALUES ('1e9fc34029594d3b944b08fc861f656b', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 13:35:07', 0);
INSERT INTO `login_log` VALUES ('2057ee3d0b284ac1b0bb726a403fb905', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-14 19:20:37', 0);
INSERT INTO `login_log` VALUES ('26341e5a8ca64c0ea14e579fd6c1f53b', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-15 01:46:15', 0);
INSERT INTO `login_log` VALUES ('2c7cffff09564cb29b5013cf5043774a', '172.18.0.16', 'yuangong1', '退出登录', NULL, '2022-05-14 19:23:33', 0);
INSERT INTO `login_log` VALUES ('2d0962219b4148d7917d22d9a8088d08', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-15 01:46:11', 0);
INSERT INTO `login_log` VALUES ('2f2aea902aeb4e4599ed1a1c8a93253f', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-15 13:08:28', 0);
INSERT INTO `login_log` VALUES ('33894e27c1674c319723be9da08adabf', '172.18.0.16', 'weixiu1', '登录成功', NULL, '2022-05-14 19:24:19', 0);
INSERT INTO `login_log` VALUES ('33d078c2b912455c801d2ef9ac6951eb', '172.18.0.16', 'yuangong1', '登录成功', NULL, '2022-05-14 19:25:21', 0);
INSERT INTO `login_log` VALUES ('3661d8c7b349461f85ffb074c9ce9890', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-14 23:04:40', 0);
INSERT INTO `login_log` VALUES ('377da11b549a44c5a25dba97a82536e0', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 11:51:11', 0);
INSERT INTO `login_log` VALUES ('3913cda3e132489b877574ef3fd162a9', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-14 19:14:57', 0);
INSERT INTO `login_log` VALUES ('395745965a1046acb17c9cde8ea0eee4', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 02:46:45', 0);
INSERT INTO `login_log` VALUES ('39ef067ec6394f498d3a89bfd9960f3d', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-15 02:07:37', 0);
INSERT INTO `login_log` VALUES ('3e67d795ab51483aab2ac4ed38cada9f', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 02:42:47', 0);
INSERT INTO `login_log` VALUES ('41adf51412b642999ca34ad517bdb340', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-15 02:05:32', 0);
INSERT INTO `login_log` VALUES ('452df8e8960a4e0bb71ac4aac98f042e', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 12:28:15', 0);
INSERT INTO `login_log` VALUES ('453455dd70d14bef8d6b55e5def4756d', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 12:34:00', 0);
INSERT INTO `login_log` VALUES ('486f1f4991084b90b871de58aa99abfb', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 02:39:52', 0);
INSERT INTO `login_log` VALUES ('4aa218d35a534e189d9795e64b6f6992', '172.18.0.16', 'yuangong1', '登录成功', NULL, '2022-05-15 12:37:39', 0);
INSERT INTO `login_log` VALUES ('4d3e6b73bca34dbc88de983bcdac4ad6', '172.18.0.16', 'guanli1', '退出登录', NULL, '2022-05-14 19:24:15', 0);
INSERT INTO `login_log` VALUES ('4fbb50e25e544f7a8a388bf27c68a46d', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-14 19:23:37', 0);
INSERT INTO `login_log` VALUES ('52627feb1d614f8e964055a29e78bedc', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 02:09:20', 0);
INSERT INTO `login_log` VALUES ('575bcff0e8154a29a41279fc7e92bbc3', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 02:46:46', 0);
INSERT INTO `login_log` VALUES ('5c1ed147ec3948a4b956aa3afb7bc0cd', '172.18.0.16', 'MD5', '退出登录', NULL, '2022-05-15 02:35:21', 0);
INSERT INTO `login_log` VALUES ('5dea9206772849aa815897b06e5d9a6f', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 02:03:25', 0);
INSERT INTO `login_log` VALUES ('62ebca4a018d4a828549e48f7b03a989', '172.18.0.16', 'MD5', '登录失败', '密码不正确', '2022-05-15 01:59:41', 0);
INSERT INTO `login_log` VALUES ('637caa4bb7fc4fd1b42123c5b5558d2b', '172.18.0.16', 'guanli1', '退出登录', NULL, '2022-05-14 23:04:35', 0);
INSERT INTO `login_log` VALUES ('6784f724f6fd4f66b2f631c2c8a414c4', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-15 12:15:27', 0);
INSERT INTO `login_log` VALUES ('694c17e6931e40cda951445505786fcf', '172.18.0.16', 'guanli1', '退出登录', NULL, '2022-05-14 19:22:44', 0);
INSERT INTO `login_log` VALUES ('72ee17a96e2e4659b8205f79863c2b63', '172.18.0.16', 'yuangong1', '登录失败', '密码不正确', '2022-05-15 02:35:26', 0);
INSERT INTO `login_log` VALUES ('795f265d7e3246d19404120f2bb5fe5d', '172.18.0.16', 'MD5', '登录失败', '密码不正确', '2022-05-15 01:59:35', 0);
INSERT INTO `login_log` VALUES ('7b46de5955aa491b9423959c2cb766dd', '172.18.0.16', 'yuangong1', '登录失败', '密码不正确', '2022-05-14 19:22:57', 0);
INSERT INTO `login_log` VALUES ('8135b04bf2e64b06bc6ae575bf99944e', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-15 01:47:17', 0);
INSERT INTO `login_log` VALUES ('834b560e806f426b84ea049515a09cd9', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-15 13:23:49', 0);
INSERT INTO `login_log` VALUES ('8c5b13b7972b43ae98dcdf39692492cf', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-14 23:04:32', 0);
INSERT INTO `login_log` VALUES ('8c83995b5ec1483899d816e7bc8f89ec', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 12:15:34', 0);
INSERT INTO `login_log` VALUES ('90791ef0601945bb877e1392f295f933', '172.18.0.16', 'guanli1', '退出登录', NULL, '2022-05-14 19:25:15', 0);
INSERT INTO `login_log` VALUES ('994e3a83f9b148d8b5766d99d0c22430', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 11:57:43', 0);
INSERT INTO `login_log` VALUES ('995beed1556c47e786bb5482d651e3d9', '172.18.0.16', 'yuangong1', '退出登录', NULL, '2022-05-14 19:25:44', 0);
INSERT INTO `login_log` VALUES ('9c4e687e9d4041afab1dc9da13745ade', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-15 11:51:05', 0);
INSERT INTO `login_log` VALUES ('9e45bb9c5db549068c1dc08fe45b32ec', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 02:42:48', 0);
INSERT INTO `login_log` VALUES ('a565c4aa79f14ef9905605ee566aaa13', '172.18.0.16', 'weixiu1', '退出登录', NULL, '2022-05-14 19:24:50', 0);
INSERT INTO `login_log` VALUES ('a631f05dac734ba0935148061567a62c', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-15 14:08:31', 0);
INSERT INTO `login_log` VALUES ('ab11cb654518405397a25cf17f24762b', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 02:03:26', 0);
INSERT INTO `login_log` VALUES ('ac3a50c629854948b8cde17fcb8410c5', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 02:20:07', 0);
INSERT INTO `login_log` VALUES ('ac445e3488ec47aab2eedb7020b199aa', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-15 13:25:51', 0);
INSERT INTO `login_log` VALUES ('acfb9b219caa41d281f46a6d9f221b57', '172.18.0.16', 'yuangong1', '登录失败', '密码不正确', '2022-05-15 12:37:36', 0);
INSERT INTO `login_log` VALUES ('b15159a6a58e40c0a1aca38fbe1a63a7', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-15 01:54:30', 0);
INSERT INTO `login_log` VALUES ('b497a7e5306d4463b81d10ff3fe5940b', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-15 11:51:04', 0);
INSERT INTO `login_log` VALUES ('b58dccf82bd9468f859761a983c07937', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 02:34:42', 0);
INSERT INTO `login_log` VALUES ('b72d788ae39d4b1f9f1d2ca4bc8d66ec', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-15 01:54:31', 0);
INSERT INTO `login_log` VALUES ('b77f36a17acc4107b5d97bc8f78cfa53', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-15 14:08:27', 0);
INSERT INTO `login_log` VALUES ('b8f7c55f58aa4c18bb50a398792cd18f', '172.18.0.16', 'yuangong1', '登录失败', '密码不正确', '2022-05-14 19:22:51', 0);
INSERT INTO `login_log` VALUES ('ba31618105dd47d4bc7e6abb6d823512', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 01:59:46', 0);
INSERT INTO `login_log` VALUES ('bece3d3f81df47fd826bf21c2ab9faa3', '172.18.0.16', 'yuangong1', '登录成功', NULL, '2022-05-14 19:23:04', 0);
INSERT INTO `login_log` VALUES ('c302b4ea18e5490680c77f29eea0c522', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 13:19:39', 0);
INSERT INTO `login_log` VALUES ('c40dd54690364e0d83b68515f1db9dc9', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-15 02:05:33', 0);
INSERT INTO `login_log` VALUES ('c455d46cb96044ca9e6dde057c4c392e', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-15 01:47:18', 0);
INSERT INTO `login_log` VALUES ('cdd636a7307e4b3f9e477d5d6a5680dd', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 02:22:12', 0);
INSERT INTO `login_log` VALUES ('d34d7d587b09498c811db6c9e4bfbe86', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-14 19:15:02', 0);
INSERT INTO `login_log` VALUES ('d49f8d16305949b3b2e30a30570c5a5c', '172.18.0.16', 'MD5', '退出登录', NULL, '2022-05-15 12:37:30', 0);
INSERT INTO `login_log` VALUES ('d798da4a6f3d4bb39115a19cc018cf49', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 12:37:16', 0);
INSERT INTO `login_log` VALUES ('dcc3afacac26438bb302b6b76b4e8e06', '172.18.0.16', 'MD5', '登录成功', NULL, '2022-05-15 12:17:09', 0);
INSERT INTO `login_log` VALUES ('dde5968d38ea49248ce8677889495cc6', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-14 23:04:38', 0);
INSERT INTO `login_log` VALUES ('e1292c2131bf4296b1d5b867132839ae', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-15 01:46:07', 0);
INSERT INTO `login_log` VALUES ('e24e86dec59349798811e909c52d6d1e', '172.18.0.16', 'MD5', '登录失败', '密码不正确', '2022-05-15 13:22:28', 0);
INSERT INTO `login_log` VALUES ('e409518ab7264372b41267517b334b8d', '172.18.0.16', 'MD5', '登录失败', '密码不正确', '2022-05-15 01:59:36', 0);
INSERT INTO `login_log` VALUES ('e661f0c5b9304edda41832d4134917e0', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-15 12:15:26', 0);
INSERT INTO `login_log` VALUES ('f70e27dea43248c8bddfdf839aa251a4', '172.18.0.16', 'guanli1', '登录失败', '密码不正确', '2022-05-15 01:46:06', 0);
INSERT INTO `login_log` VALUES ('fdc91e1cf09f4a04ad2d239b1bf5f53c', '172.18.0.16', 'guanli1', '登录成功', NULL, '2022-05-15 03:02:26', 0);

-- ----------------------------
-- Table structure for operation_log
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `user_name` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录人',
  `action` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作',
  `msg` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原因',
  `action_time` datetime NULL DEFAULT NULL,
  `del_flag` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of operation_log
-- ----------------------------
INSERT INTO `operation_log` VALUES ('14237920746f4d43a8f44b828923b516', '员工1', '评价', '评价了编号为：WX40539的维修单；维修人员是：维修1', '2022-05-14 19:25:39', 0);
INSERT INTO `operation_log` VALUES ('7322347d704241c982a40c2495c49e3b', '管理员', '驳回', '管理员驳回了WX57992', '2022-05-14 19:26:28', 0);
INSERT INTO `operation_log` VALUES ('7ca27093cce34c4cb2894b6c1d795337', '员工1', '报修', '员工1报修了电脑坏了', '2022-05-14 19:23:25', 0);
INSERT INTO `operation_log` VALUES ('a4c970e7b42649f8a7d58910e5fe9dd9', 'MD5测试', '修改密码', 'MD5测试修改用户：MD5测试的密码', '2022-05-15 13:35:15', 0);
INSERT INTO `operation_log` VALUES ('a9b2595c222646c7bbc5bea8d5a5c0ed', '管理员', '修改密码', '管理员修改用户：管理员的密码', '2022-05-14 23:12:28', 0);
INSERT INTO `operation_log` VALUES ('af15652643dc44178d442666f4fcebc3', '管理员', '添加', '管理员添加了用户：MD5测试', '2022-05-15 01:55:12', 0);
INSERT INTO `operation_log` VALUES ('b3c9d09d24d7436090b4a2af549e1610', '管理员', '添加', '管理员添加了工具：灯泡', '2022-05-14 19:22:28', 0);
INSERT INTO `operation_log` VALUES ('b56a7d589b7d456ca78ecffb228a52c9', '管理员', '添加', '管理员添加了用户：员工1', '2022-05-14 19:21:05', 0);
INSERT INTO `operation_log` VALUES ('cf891b6d076c4fd485be851280a620f2', '维修1', '维修', '维修1维修了WX40539;使用工具 : 灯泡;消耗数量为：2', '2022-05-14 19:24:42', 0);
INSERT INTO `operation_log` VALUES ('f1b1723582e2497dacb82ac1939ad08b', '管理员', '报修', '管理员报修了测试02', '2022-05-14 19:26:20', 0);
INSERT INTO `operation_log` VALUES ('f1bd32290a5b47cf9b3a1a617ec71171', '管理员', '添加', '管理员添加了用户：维修1', '2022-05-14 19:21:37', 0);
INSERT INTO `operation_log` VALUES ('f6c9a994474c472e89f87bd38f9763c8', '管理员', '通过审核', '管理员审核通过WX40539', '2022-05-14 19:23:54', 0);

-- ----------------------------
-- Table structure for sys_maintain
-- ----------------------------
DROP TABLE IF EXISTS `sys_maintain`;
CREATE TABLE `sys_maintain`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `number` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `place` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地点',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '类型',
  `satus` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '状态',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '问题',
  `handle_time` datetime NULL DEFAULT NULL COMMENT '处理时间',
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修工名',
  `userid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工人id',
  `username2` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '普通员工',
  `userid2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报修人id',
  `score` int(11) NULL DEFAULT NULL COMMENT '评分',
  `evaluate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论',
  `remark2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修备注',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toolname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toolid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `amount` int(11) NULL DEFAULT NULL,
  `del_flag` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '维修表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_maintain
-- ----------------------------
INSERT INTO `sys_maintain` VALUES ('9a48afb283774aa39f8092f2936372de', 'WX40539', '一楼', 2, '2', '2022-05-14 19:23:25', '电脑坏了', '2022-05-14 19:24:36', '维修1', '00d13dfe455f48c2b1e4f2d5f8fd267d', '员工1', 'c66129724ae74c1a97b7e21087d8d419', 10, '好的', '维修完毕', 'http://localhost:8088/image/180c25c2338543e38510d89796ab1937.png', '灯泡', '6fcb8af330664c0dbb56c0797d1127b8', 2, 0);
INSERT INTO `sys_maintain` VALUES ('de9260533ac14500a225c8745b671fee', 'WX57992', '二楼', 2, '3', '2022-05-14 19:26:20', '测试02', NULL, '维修1', '00d13dfe455f48c2b1e4f2d5f8fd267d', '管理员', '2', NULL, NULL, NULL, '', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for sys_tool
-- ----------------------------
DROP TABLE IF EXISTS `sys_tool`;
CREATE TABLE `sys_tool`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `amount` int(11) NULL DEFAULT NULL COMMENT '数量',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工具名',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flag` tinyint(4) NOT NULL,
  `money` int(11) NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工具表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_tool
-- ----------------------------
INSERT INTO `sys_tool` VALUES ('6fcb8af330664c0dbb56c0797d1127b8', 8, '灯泡', '2022-05-14 19:22:28', '测试信息', 0, 2, 'http://localhost:8088/image/698645c71ac14b45b97548233db08675.png');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `user_name` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `login_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `sex` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `role_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `locked` tinyint(4) NULL DEFAULT NULL COMMENT '是否锁定',
  `create_date` datetime NULL DEFAULT NULL,
  `del_flag` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('00d13dfe455f48c2b1e4f2d5f8fd267d', '维修1', 'weixiu1', '1', '15103441202', '男', 25, '维修工', 0, '2022-05-14 19:21:37', 0);
INSERT INTO `user` VALUES ('2', '管理员', 'guanli1', '1', '17330982374', '男', 22, '管理员', 0, '2022-04-30 23:50:43', 0);
INSERT INTO `user` VALUES ('6c7e9602859e4ee887566e73a3d48b31', 'MD5测试', 'MD5', '2', '17330982374', '男', 25, '员工', 0, '2022-05-15 01:55:12', 0);
INSERT INTO `user` VALUES ('c66129724ae74c1a97b7e21087d8d419', '员工1', 'yuangong1', '1', '15103661040', '男', 22, '员工', 0, '2022-05-14 19:21:05', 0);

SET FOREIGN_KEY_CHECKS = 1;
