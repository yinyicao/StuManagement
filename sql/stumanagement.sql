/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : stumanagement

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-01-07 21:07:20
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for table_institute
-- ----------------------------
DROP TABLE IF EXISTS `table_institute`;
CREATE TABLE `table_institute` (
  `id`               int(11)      NOT NULL AUTO_INCREMENT
  COMMENT '表id',
  `instituteId`      int(20)      NOT NULL
  COMMENT '学院代码',
  `instituteName`    varchar(50)  NOT NULL
  COMMENT '学院名',
  `instituteExplain` varchar(255) NOT NULL
  COMMENT '学院说明',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of table_institute
-- ----------------------------
INSERT INTO `table_institute`
VALUES ('1', '10001', '应用技术学院', '应用技术学院简介');
INSERT INTO `table_institute`
VALUES ('2', '10002', '计算机学院', '计算机学院简介');
INSERT INTO `table_institute`
VALUES ('3', '10003', '知识产权学院 ', '知识产权学院简介');
INSERT INTO `table_institute`
VALUES ('4', '10004', '汽车工程学院', '汽车工程学院简介');
INSERT INTO `table_institute`
VALUES ('5', '10005', '机械工程学院', '机械工程学院简介');
INSERT INTO `table_institute`
VALUES ('6', '10006', '理学院', '理学院简介');

-- ----------------------------
-- Table structure for table_student
-- ----------------------------
DROP TABLE IF EXISTS `table_student`;
CREATE TABLE `table_student` (
  `id`                  int(11)      NOT NULL AUTO_INCREMENT
  COMMENT '表id',
  `stu_id`              varchar(20)  NOT NULL
  COMMENT '学号',
  `stu_name`            varchar(50)  NOT NULL,
  `stu_age`             int(11)      NOT NULL,
  `stu_gender`          char(1)      NOT NULL
  COMMENT '性别（男，女）',
  `stu_institute`       int(20)      NOT NULL
  COMMENT '学院',
  `stu_enterScore`      int(11)      NOT NULL
  COMMENT '入学成绩',
  `stu_politicalStatus` varchar(50)  NOT NULL,
  `stu_homeplace`       varchar(255) NOT NULL
  COMMENT '籍贯',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 50
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of table_student
-- ----------------------------
INSERT INTO `table_student`
VALUES ('3', '91621310103', '卫天宇 ', '22', '男', '10003', '89', '预备党员', '重庆沙坪坝');
INSERT INTO `table_student`
VALUES ('4', '91621310104', '王迎曼', '23', '女', '10004', '90', '共青团员', '浙江杭州');
INSERT INTO `table_student`
VALUES ('5', '91621310105', '蒋朝海', '21', '男', '10005', '90', '中共党员', '北京朝阳区');
INSERT INTO `table_student`
VALUES ('6', '91621310106', '秦筠', '20', '女', '10006', '99', '预备党员', '北京朝阳区');
INSERT INTO `table_student`
VALUES ('7', '91621310107', '孙效富', '19', '男', '10005', '88', '共青团员', '宁夏回族自治区');
INSERT INTO `table_student`
VALUES ('8', '91621310108', '施光萍', '23', '女', '10003', '98', '中共党员', '重庆梁平');
INSERT INTO `table_student`
VALUES ('9', '91621310109', '吕凯军', '22', '男', '10004', '86', '预备党员', '重庆长寿');
INSERT INTO `table_student`
VALUES ('10', '91621310110', '褚文倩', '20', '女', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('11', '91621310111', '吴高伟', '22', '男', '10004', '88', '中共党员', '云南昆明');
INSERT INTO `table_student`
VALUES ('12', '91621310112', '施思', '21', '女', '10002', '100', '共青团员', '广东汕尾');
INSERT INTO `table_student`
VALUES ('13', '91621310113', '周仁波', '20', '男', '10002', '78', '共青团员', '广东惠州');
INSERT INTO `table_student`
VALUES ('14', '91621310114', '罗倩', '22', '女', '10004', '88', '共青团员', '湖北武汉');
INSERT INTO `table_student`
VALUES ('15', '91621310115', '孔轮', '22', '男', '10002', '99', '中共党员', '重庆万州');
INSERT INTO `table_student`
VALUES ('16', '91621310116', '孔程悦', '22', '女', '10002', '99', '中共党员', '重庆万州');
INSERT INTO `table_student`
VALUES ('17', '91621310117', '陈凌旋 ', '20', '女', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('18', '91621310118', '沈乐之 ', '20', '女', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('19', '91621310119', '蒋桂兰 ', '20', '女', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('20', '91621310120', '朱小珍 ', '20', '女', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('21', '91621310121', '姜琦', '20', '女', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('22', '91621310122', '房勤 ', '20', '女', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('23', '91621310123', '金玉晶 ', '20', '女', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('24', '91621310124', '习雪萍 ', '20', '女', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('25', '91621310125', '钱燕 ', '20', '女', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('26', '91621310126', '许倩 ', '20', '女', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('27', '91621310127', '吴婷 ', '20', '女', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('28', '91621310128', '褚启波 ', '20', '男', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('29', '91621310129', '郑政 ', '20', '男', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('30', '91621310130', '尤有 ', '20', '男', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('31', '91621310131', '赵哲 ', '20', '男', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('32', '91621310132', '严奇', '20', '男', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('33', '91621310133', '冯胜东 ', '20', '男', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('34', '91621310134', '陶宏涛 ', '20', '男', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('35', '91621310135', '钱大发 ', '20', '男', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('37', '91621310137', '蒋翰 ', '20', '男', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('38', '91621310138', '吕绍 ', '20', '男', '10001', '99', '共青团员', '重庆万州');
INSERT INTO `table_student`
VALUES ('48', '20180622', '大笨蛋', '1', '男', '10002', '100', '群众', '重庆江津');
INSERT INTO `table_student`
VALUES ('49', '91621310139', '张成', '22', '男', '10001', '78', '中共党员', '四川成都');

-- ----------------------------
-- Table structure for table_user
-- ----------------------------
DROP TABLE IF EXISTS `table_user`;
CREATE TABLE `table_user` (
  `userID`   int(11)      NOT NULL,
  `userName` varchar(50)  NOT NULL,
  `passWord` varchar(255) NOT NULL,
  `userRole` tinyint(4)   NOT NULL DEFAULT '0'
  COMMENT '0表示普通用户，1表示管理员',
  PRIMARY KEY (`userID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of table_user
-- ----------------------------
INSERT INTO `table_user`
VALUES ('1', 'admin', '123', '1');
INSERT INTO `table_user`
VALUES ('2', 'user', '123', '0');

-- ----------------------------
-- View structure for view_studentinfo
-- ----------------------------
DROP VIEW IF EXISTS `view_studentinfo`;
CREATE ALGORITHM = UNDEFINED
  DEFINER = `root`@`localhost`
  SQL SECURITY DEFINER VIEW `view_studentinfo` AS
  select `a`.`stu_id`              AS `stu_id`,
         `a`.`stu_name`            AS `stu_name`,
         `a`.`stu_age`             AS `stu_age`,
         `a`.`stu_politicalStatus` AS `stu_politicalStatus`,
         `a`.`stu_homeplace`       AS `stu_homeplace`,
         `a`.`stu_gender`          AS `stu_gender`,
         `b`.`instituteName`       AS `stu_instituteName`,
         `b`.`instituteExplain`    AS `stu_instituteExplain`,
         `a`.`stu_enterScore`      AS `stu_enterScore`
  from (`table_student` `a` join `table_institute` `b` on ((`a`.`stu_institute` = `b`.`instituteId`)));
