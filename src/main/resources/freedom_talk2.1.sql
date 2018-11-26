/*
 Navicat Premium Data Transfer

 Source Server         : loca
 Source Server Type    : MySQL
 Source Server Version : 50517
 Source Host           : localhost:3306
 Source Schema         : freedom_talk

 Target Server Type    : MySQL
 Target Server Version : 50517
 File Encoding         : 65001

 Date: 26/11/2018 16:32:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `customer_role_relation`;
CREATE TABLE `customer_role_relation`  (
  `role_id` int(11) NOT NULL,
  `cus_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`role_id`, `cus_id`) USING BTREE,
  INDEX `FK_customer_role_relation2`(`cus_id`) USING BTREE,
  CONSTRAINT `FK_customer_role_relation` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_customer_role_relation2` FOREIGN KEY (`cus_id`) REFERENCES `tb_customer` (`cus_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_relation`;
CREATE TABLE `role_permission_relation`  (
  `role_id` int(11) NOT NULL,
  `perm_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`, `perm_id`) USING BTREE,
  INDEX `FK_role_permission_relation2`(`perm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_permission_relation
-- ----------------------------
INSERT INTO `role_permission_relation` VALUES (2850, 1);
INSERT INTO `role_permission_relation` VALUES (2850, 2);

-- ----------------------------
-- Table structure for tb_announcement
-- ----------------------------
DROP TABLE IF EXISTS `tb_announcement`;
CREATE TABLE `tb_announcement`  (
  `acm_id` int(11) NOT NULL AUTO_INCREMENT,
  `acm_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isDelete` int(11) NOT NULL DEFAULT 1 COMMENT '1 不删除 0 删除',
  `acm_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`acm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_announcement
-- ----------------------------
INSERT INTO `tb_announcement` VALUES (1, '请各大版主注意,本坛严禁发布涉黄,涉毒,邪教等恶劣性的文章内容,一经发现,将作永久封号处理!!!', 0, '2018-11-13 10:55:22');

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category`  (
  `cate_id` int(11) NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isDelete` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`cate_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES (1, '体育', 1);
INSERT INTO `tb_category` VALUES (2, '社会', 1);
INSERT INTO `tb_category` VALUES (3, '经济', 1);
INSERT INTO `tb_category` VALUES (4, '法律', 1);
INSERT INTO `tb_category` VALUES (5, '科技', 1);

-- ----------------------------
-- Table structure for tb_chat
-- ----------------------------
DROP TABLE IF EXISTS `tb_chat`;
CREATE TABLE `tb_chat`  (
  `ch_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '其实这里应该存有两份聊天记录表,因为发送者删除聊天记录应只删除他自己的聊天记录,而不是接收者的聊天记录',
  `ch_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `from_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `to_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ch_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isDelete` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`ch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_chat
-- ----------------------------
INSERT INTO `tb_chat` VALUES (1, 'online???', 'da7dd3ba32eb430d8da4f6bbca63fb06', 'c53182bb063a4016ae22be6eeb72c8b7', '2018-11-26 14:04:32', 1);
INSERT INTO `tb_chat` VALUES (2, 'yes', 'c53182bb063a4016ae22be6eeb72c8b7', 'da7dd3ba32eb430d8da4f6bbca63fb06', '2018-11-26 14:21:06', 1);
INSERT INTO `tb_chat` VALUES (3, 'what', 'c53182bb063a4016ae22be6eeb72c8b7', 'da7dd3ba32eb430d8da4f6bbca63fb06', '2018-11-26 14:22:12', 1);

-- ----------------------------
-- Table structure for tb_collect
-- ----------------------------
DROP TABLE IF EXISTS `tb_collect`;
CREATE TABLE `tb_collect`  (
  `col_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note_id` int(11) NOT NULL,
  `isDelete` int(11) NOT NULL DEFAULT 1,
  `col_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`col_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_collect
-- ----------------------------
INSERT INTO `tb_collect` VALUES (2, 'c53182bb063a4016ae22be6eeb72c8b7', 2, 0, '2018-11-24 8:55:36');

-- ----------------------------
-- Table structure for tb_customer
-- ----------------------------
DROP TABLE IF EXISTS `tb_customer`;
CREATE TABLE `tb_customer`  (
  `cus_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cus_loginname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cus_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cus_email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cus_img` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cus_suggest` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cus_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cus_sex` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cus_birthdate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isUnuse` int(11) NOT NULL DEFAULT 1 COMMENT '1 不禁用 0 禁用',
  `isBm` int(11) NOT NULL DEFAULT 0 COMMENT '1 是版主 0 不是',
  `question_id` int(11) NOT NULL,
  `cus_answer` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cus_fans` int(11) NOT NULL DEFAULT 0,
  `cus_follow` int(11) NOT NULL DEFAULT 0,
  `cus_age` int(11) NULL DEFAULT NULL,
  `cus_type` int(11) NOT NULL DEFAULT 1 COMMENT '0 管理员 1 普通用户 2 版主',
  PRIMARY KEY (`cus_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_customer
-- ----------------------------
INSERT INTO `tb_customer` VALUES ('325cb30d5bbd45e3af82d3a2e0b875ae', 'ftAdmin', '714a4c3555b164001abe6b866535b6258b937b3e4bb16a0fb17d1af43e3fa7ac', '3021846201@qq.com', NULL, NULL, NULL, NULL, NULL, 1, 0, 1, 'admin', 0, 0, NULL, 0);
INSERT INTO `tb_customer` VALUES ('c53182bb063a4016ae22be6eeb72c8b7', 'liujing', '72451a6a700f6982e53bfc4b5edd166f8bbc16f611bcd93b3439813a3ad48584', '744273057@qq.com', '/img/img_ft1542973094078.jpg', 'you are so beautiful', 'my love', '女', '1999-11-30', 1, 1, 1, '刘菁', 0, 0, 19, 2);
INSERT INTO `tb_customer` VALUES ('da7dd3ba32eb430d8da4f6bbca63fb06', 'jaremo', '71fcf0b773f343ce1fd2884a2c93f45e9bae4aefae3c6ae4d4cb00570ba7ef57', '744273057@qq.com', '/img/heizeiwang2.jpg', '我是根据修改的准值!!!', 'LAO_k', '男', '2002-03-28', 0, 1, 2, 'jet', 0, 0, 16, 2);

-- ----------------------------
-- Table structure for tb_follow
-- ----------------------------
DROP TABLE IF EXISTS `tb_follow`;
CREATE TABLE `tb_follow`  (
  `fol_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `moderator_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`fol_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_follow
-- ----------------------------
INSERT INTO `tb_follow` VALUES (3, 'da7dd3ba32eb430d8da4f6bbca63fb06', 'c53182bb063a4016ae22be6eeb72c8b7');

-- ----------------------------
-- Table structure for tb_hail_fellow
-- ----------------------------
DROP TABLE IF EXISTS `tb_hail_fellow`;
CREATE TABLE `tb_hail_fellow`  (
  `hf_id` int(11) NOT NULL AUTO_INCREMENT,
  `from_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `to_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hf_remarks` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`hf_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_hail_fellow
-- ----------------------------
INSERT INTO `tb_hail_fellow` VALUES (3, 'c53182bb063a4016ae22be6eeb72c8b7', 'da7dd3ba32eb430d8da4f6bbca63fb06', '老公');
INSERT INTO `tb_hail_fellow` VALUES (4, 'da7dd3ba32eb430d8da4f6bbca63fb06', 'c53182bb063a4016ae22be6eeb72c8b7', NULL);

-- ----------------------------
-- Table structure for tb_leaveword
-- ----------------------------
DROP TABLE IF EXISTS `tb_leaveword`;
CREATE TABLE `tb_leaveword`  (
  `lw_id` int(20) NOT NULL AUTO_INCREMENT,
  `lw_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `from_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `to_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lw_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isStart` int(11) NOT NULL DEFAULT 1 COMMENT '1 开启 0 不开启',
  `isDelete` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`lw_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_leaveword
-- ----------------------------
INSERT INTO `tb_leaveword` VALUES (6, 'xxxx', 'gfrz', 'c53182bb063a4016ae22be6eeb72c8b7', '2018-11-21 18:56:21', 1, 1);
INSERT INTO `tb_leaveword` VALUES (7, 'xxxx', 'gfrz', 'ddbadc6ee5ef401db72b46d58fb54ea3', '2018-11-21 20:19:52', 1, 1);
INSERT INTO `tb_leaveword` VALUES (8, 'wozuiqinaiderena', 'da7dd3ba32eb430d8da4f6bbca63fb06', 'c53182bb063a4016ae22be6eeb72c8b7', '2018-11-25 9:58:36', 1, 1);
INSERT INTO `tb_leaveword` VALUES (9, 'xxxx', 'gfrz', '325cb30d5bbd45e3af82d3a2e0b875ae', '2018-11-26 15:06:53', 1, 1);

-- ----------------------------
-- Table structure for tb_login_question
-- ----------------------------
DROP TABLE IF EXISTS `tb_login_question`;
CREATE TABLE `tb_login_question`  (
  `que_id` int(11) NOT NULL AUTO_INCREMENT,
  `que_content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`que_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_login_question
-- ----------------------------
INSERT INTO `tb_login_question` VALUES (1, '你的真实姓名是?');
INSERT INTO `tb_login_question` VALUES (2, '你爸爸的姓名是?');
INSERT INTO `tb_login_question` VALUES (3, '你妈妈的姓名是?');
INSERT INTO `tb_login_question` VALUES (4, '你最喜欢的餐馆是?');

-- ----------------------------
-- Table structure for tb_lwreply
-- ----------------------------
DROP TABLE IF EXISTS `tb_lwreply`;
CREATE TABLE `tb_lwreply`  (
  `lwr_id` int(11) NOT NULL AUTO_INCREMENT,
  `leaveword_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `from_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `to_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lwr_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lwr_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isDelete` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`lwr_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_lwreply
-- ----------------------------
INSERT INTO `tb_lwreply` VALUES (3, '8', 'c53182bb063a4016ae22be6eeb72c8b7', 'da7dd3ba32eb430d8da4f6bbca63fb06', 'i know', '2018-11-25 10:00:00', 0);
INSERT INTO `tb_lwreply` VALUES (4, '8', 'c53182bb063a4016ae22be6eeb72c8b7', 'da7dd3ba32eb430d8da4f6bbca63fb06', 'i love you', '2018-11-25 10:01:00', 1);
INSERT INTO `tb_lwreply` VALUES (5, '8', 'c53182bb063a4016ae22be6eeb72c8b7', 'da7dd3ba32eb430d8da4f6bbca63fb06', 'forever', '2018-11-25 16:45:54', 1);
INSERT INTO `tb_lwreply` VALUES (6, '8', 'c53182bb063a4016ae22be6eeb72c8b7', 'c53182bb063a4016ae22be6eeb72c8b7', '自己回复自己', '2018-11-25 16:46:36', 0);

-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message`  (
  `msg_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `msg_content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isDelete` int(11) NOT NULL DEFAULT 1,
  `isRead` int(11) NOT NULL DEFAULT 0 COMMENT '0 未读 , 1 已读',
  `msg_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`msg_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_message
-- ----------------------------
INSERT INTO `tb_message` VALUES (3, 'c53182bb063a4016ae22be6eeb72c8b7', 'wozhongyinia', 1, 1, '2018-11-23 13:51:33');
INSERT INTO `tb_message` VALUES (4, 'c53182bb063a4016ae22be6eeb72c8b7', 'wohaoxihuni', 1, 1, '2018-11-23 13:52:00');

-- ----------------------------
-- Table structure for tb_note
-- ----------------------------
DROP TABLE IF EXISTS `tb_note`;
CREATE TABLE `tb_note`  (
  `note_id` int(11) NOT NULL AUTO_INCREMENT,
  `note_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `customer_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note_browserNum` int(11) NOT NULL DEFAULT 0,
  `note_commentNum` int(11) NOT NULL DEFAULT 0,
  `note_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note_category` int(11) NOT NULL,
  `note_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isDelete` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`note_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_note
-- ----------------------------
INSERT INTO `tb_note` VALUES (4, '法律在权力面前算什么', '2017年8月21日，本人接广安市中级人民法院通知去领取国家赔偿决定书。领完决定书后，就到中院信访室登记:预约本周院领导会见，准备反映法官涉嫌违法犯罪问题。刚登记完，就被法警不明不白殴打，致使身体多处受伤，鼻骨骨折。事后，@阿超_港媒视点 @改革报社重庆记者站 @北京师范大学招生办 @刘耘博士 等媒体、网民大量转发评论，均要求查清真相，严惩凶手。可是在“强权\"保护下，至今涉嫌违法犯罪的法官、打人的法警未受到法律处理。', 'c53182bb063a4016ae22be6eeb72c8b7', 520, 520, NULL, 2, '2018-11-25 19:07:56', 0);
INSERT INTO `tb_note` VALUES (5, '行政处罚百姓多敢怒不敢言', '在国内，整个行政处罚活动中，道路交通违法处罚可谓是一大亮点。也是其他处罚无可比拟的一种处罚。虽为小额，累积种类繁多数额之巨。尤为电子眼。这种小额处罚多为几十到两百之间。只有自己查询方知或在车辆年检时被告知。这种处罚没有当场做出，也没有被当场告知违法内容与听取被处罚者申辩。都是事后直接通知缴纳罚款。且不谈行政处罚法与处罚程序的正当性与否。面对这样的处罚，百姓多是按查询结果直接缴纳罚款不敢言语。因为，一是为这点小钱去申诉或诉讼费时费力，赢官司付出更多；二是这些管车的人得罪不起，怕事后报复，除非打算今后不再开车。因此，少有这类行政诉讼官司出现。不申辩、不诉，难道处罚真的都正确吗？非也。只是此类行政处罚，百姓多是敢怒不敢言。', 'c53182bb063a4016ae22be6eeb72c8b7', 530, 530, NULL, 2, '2018-11-25 19:10:56', 0);
INSERT INTO `tb_note` VALUES (6, '姚明是中国史上最伟大篮球运动员??', '伴随着大卫.斯特恩一声不太准确的“Yao Ming”，NBA历史上首位非美籍状元横空出世，振奋了国人，震惊了世界。NBA生涯最早期，姚明不被看好，“巴克利亲驴屁股”这事就是很好的说明，但姚明一直在努力，每天埋在训练馆，不断增加力量、磨炼技术、融入火箭队，成功用实力冲击、打破质疑。火箭队效力期间，场均上场32. 5分钟，得到19分9.2个篮板1.9盖帽，2003-2008赛季，连续6年入选全明星阵容，其身披的11号球衣永远的在火箭队退役，2017年入选篮球名人堂等荣誉。至今，姚明依然是亚洲人在NBA成就的最佳标杆，是所以球员努力的方向和榜样。', 'c53182bb063a4016ae22be6eeb72c8b7', 0, 0, NULL, 1, '2018-11-25 20:27:59', 1);

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission`  (
  `perm_id` int(11) NOT NULL AUTO_INCREMENT,
  `perm_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isDelete` int(11) NOT NULL DEFAULT 1,
  `perm_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `perm_sign` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`perm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------
INSERT INTO `tb_permission` VALUES (1, 'customer:add', 1, '/lendCus.do', 'cus_add');
INSERT INTO `tb_permission` VALUES (2, 'note:remove', 0, '/delNote.do', 'note_del');
INSERT INTO `tb_permission` VALUES (3, 'customer:update', 1, '/updateCus.do', 'cus_update');

-- ----------------------------
-- Table structure for tb_report_viewpoint
-- ----------------------------
DROP TABLE IF EXISTS `tb_report_viewpoint`;
CREATE TABLE `tb_report_viewpoint`  (
  `rvp_id` int(11) NOT NULL AUTO_INCREMENT,
  `note_id` int(11) NOT NULL,
  `from_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `to_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isDelete` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`rvp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isDelete` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES (4, 'Bm', 1);
INSERT INTO `tb_role` VALUES (2850, 'admin', 1);

-- ----------------------------
-- Table structure for tb_unleave_word
-- ----------------------------
DROP TABLE IF EXISTS `tb_unleave_word`;
CREATE TABLE `tb_unleave_word`  (
  `ulw_id` int(11) NOT NULL AUTO_INCREMENT,
  `from_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `to_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isDelete` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`ulw_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_unleave_word
-- ----------------------------
INSERT INTO `tb_unleave_word` VALUES (3, 'c53182bb063a4016ae22be6eeb72c8b7', 'da7dd3ba32eb430d8da4f6bbca63fb06', 0);

-- ----------------------------
-- Table structure for tb_viewpoint
-- ----------------------------
DROP TABLE IF EXISTS `tb_viewpoint`;
CREATE TABLE `tb_viewpoint`  (
  `vp_id` int(11) NOT NULL AUTO_INCREMENT,
  `vp_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `from_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vp_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isDelete` int(11) NOT NULL DEFAULT 1,
  `note_id` int(11) NOT NULL,
  PRIMARY KEY (`vp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_viewpoint
-- ----------------------------
INSERT INTO `tb_viewpoint` VALUES (2, '姚明v5', 'da7dd3ba32eb430d8da4f6bbca63fb06', '2018-11-25 21:22:22', 1, 6);
INSERT INTO `tb_viewpoint` VALUES (3, '姚明,热心公益,中国男篮的顶梁柱', 'c53182bb063a4016ae22be6eeb72c8b7', '2018-11-26 12:43:59', 1, 6);

-- ----------------------------
-- Table structure for tb_vpreply
-- ----------------------------
DROP TABLE IF EXISTS `tb_vpreply`;
CREATE TABLE `tb_vpreply`  (
  `vpr_id` int(11) NOT NULL AUTO_INCREMENT,
  `vpr_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `from_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `to_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vpr_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isDelete` int(11) NOT NULL DEFAULT 1,
  `viewpoint_id` int(11) NOT NULL,
  PRIMARY KEY (`vpr_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_vpreply
-- ----------------------------
INSERT INTO `tb_vpreply` VALUES (2, '真神', 'c53182bb063a4016ae22be6eeb72c8b7', 'da7dd3ba32eb430d8da4f6bbca63fb06', '2018-11-25 21:23:56', 1, 2);
INSERT INTO `tb_vpreply` VALUES (3, '真伟大', 'da7dd3ba32eb430d8da4f6bbca63fb06', 'c53182bb063a4016ae22be6eeb72c8b7', '2018-11-25 21:24:56', 1, 2);
INSERT INTO `tb_vpreply` VALUES (4, '姚明真的是好人', 'c53182bb063a4016ae22be6eeb72c8b7', 'c53182bb063a4016ae22be6eeb72c8b7', '2018-11-26 12:46:04', 1, 3);

SET FOREIGN_KEY_CHECKS = 1;
