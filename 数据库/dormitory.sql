/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : dormitory

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2019-06-07 16:45:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `Admin_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Admin_Username` varchar(30) NOT NULL,
  `Admin_Password` varchar(30) NOT NULL,
  `Admin_Name` varchar(30) NOT NULL,
  `Admin_Sex` varchar(10) DEFAULT NULL,
  `Admin_Tel` varchar(30) DEFAULT '',
  PRIMARY KEY (`Admin_ID`),
  UNIQUE KEY `Admin_Username` (`Admin_Username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'lxt', '1', '陆轩韬', '男', '12345678');
INSERT INTO `admin` VALUES ('2', 'lxt2', '1', '陆轩韬2', '女', '87654321');

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building` (
  `Building_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Building_Name` varchar(30) NOT NULL,
  `Building_Type` varchar(30) NOT NULL,
  PRIMARY KEY (`Building_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES ('1', '第五宿舍楼', '男生宿舍');
INSERT INTO `building` VALUES ('2', '第六宿舍楼', '男生宿舍');
INSERT INTO `building` VALUES ('3', '第七宿舍楼', '男生宿舍');
INSERT INTO `building` VALUES ('4', '第八宿舍楼', '女生宿舍');
INSERT INTO `building` VALUES ('5', '第九宿舍楼', '女生宿舍');
INSERT INTO `building` VALUES ('7', '测试楼2', '男生宿舍');

-- ----------------------------
-- Table structure for dormitory
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory` (
  `Dormitory_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Dormitory_Name` varchar(30) NOT NULL,
  `Dormitory_Size` int(11) NOT NULL,
  `Dormitory_Now` int(10) unsigned zerofill NOT NULL DEFAULT '0000000000',
  PRIMARY KEY (`Dormitory_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dormitory
-- ----------------------------
INSERT INTO `dormitory` VALUES ('1', '5101寝室', '4', '0000000004');
INSERT INTO `dormitory` VALUES ('2', '5102寝室', '4', '0000000004');
INSERT INTO `dormitory` VALUES ('3', '5201寝室', '8', '0000000002');
INSERT INTO `dormitory` VALUES ('4', '5202寝室', '8', '0000000002');
INSERT INTO `dormitory` VALUES ('5', '6101寝室', '4', '0000000001');
INSERT INTO `dormitory` VALUES ('6', '6102寝室', '4', '0000000003');
INSERT INTO `dormitory` VALUES ('7', '6201寝室', '8', '0000000002');
INSERT INTO `dormitory` VALUES ('8', '6202寝室', '8', '0000000002');
INSERT INTO `dormitory` VALUES ('9', '7101寝室', '4', '0000000001');
INSERT INTO `dormitory` VALUES ('10', '7102寝室', '4', '0000000001');
INSERT INTO `dormitory` VALUES ('11', '7201寝室', '8', '0000000001');
INSERT INTO `dormitory` VALUES ('12', '7202寝室', '8', '0000000004');
INSERT INTO `dormitory` VALUES ('13', '8101寝室', '4', '0000000002');
INSERT INTO `dormitory` VALUES ('14', '8102寝室', '4', '0000000001');
INSERT INTO `dormitory` VALUES ('15', '8201寝室', '8', '0000000001');
INSERT INTO `dormitory` VALUES ('16', '8202寝室', '8', '0000000002');
INSERT INTO `dormitory` VALUES ('17', '9101寝室', '4', '0000000004');
INSERT INTO `dormitory` VALUES ('18', '9102寝室', '4', '0000000004');
INSERT INTO `dormitory` VALUES ('19', '9201寝室', '8', '0000000005');
INSERT INTO `dormitory` VALUES ('20', '9202寝室', '8', '0000000005');
INSERT INTO `dormitory` VALUES ('21', '1103', '4', '0000000001');

-- ----------------------------
-- Table structure for dor_bui
-- ----------------------------
DROP TABLE IF EXISTS `dor_bui`;
CREATE TABLE `dor_bui` (
  `DB_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DB_DormitoryID` int(11) NOT NULL,
  `DB_BuildingID` int(11) NOT NULL,
  PRIMARY KEY (`DB_ID`),
  KEY `DB_DormitoryID` (`DB_DormitoryID`),
  KEY `DB_BuildingID` (`DB_BuildingID`),
  CONSTRAINT `dor_bui_ibfk_1` FOREIGN KEY (`DB_DormitoryID`) REFERENCES `dormitory` (`Dormitory_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dor_bui_ibfk_2` FOREIGN KEY (`DB_BuildingID`) REFERENCES `building` (`Building_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dor_bui
-- ----------------------------
INSERT INTO `dor_bui` VALUES ('1', '1', '1');
INSERT INTO `dor_bui` VALUES ('2', '2', '1');
INSERT INTO `dor_bui` VALUES ('3', '3', '1');
INSERT INTO `dor_bui` VALUES ('5', '4', '1');
INSERT INTO `dor_bui` VALUES ('6', '5', '2');
INSERT INTO `dor_bui` VALUES ('10', '6', '2');
INSERT INTO `dor_bui` VALUES ('11', '7', '2');
INSERT INTO `dor_bui` VALUES ('12', '8', '2');
INSERT INTO `dor_bui` VALUES ('13', '9', '3');
INSERT INTO `dor_bui` VALUES ('14', '10', '3');
INSERT INTO `dor_bui` VALUES ('15', '11', '3');
INSERT INTO `dor_bui` VALUES ('16', '12', '3');
INSERT INTO `dor_bui` VALUES ('17', '13', '4');
INSERT INTO `dor_bui` VALUES ('18', '14', '4');
INSERT INTO `dor_bui` VALUES ('19', '15', '4');
INSERT INTO `dor_bui` VALUES ('20', '16', '4');
INSERT INTO `dor_bui` VALUES ('21', '17', '5');
INSERT INTO `dor_bui` VALUES ('22', '18', '5');
INSERT INTO `dor_bui` VALUES ('23', '19', '5');
INSERT INTO `dor_bui` VALUES ('24', '20', '5');
INSERT INTO `dor_bui` VALUES ('25', '21', '7');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `Log_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Log_StudentID` int(11) NOT NULL,
  `Log_Date` varchar(30) NOT NULL,
  `Log_Reason` varchar(255) NOT NULL,
  `Log_TeacherID` int(11) DEFAULT NULL,
  PRIMARY KEY (`Log_ID`),
  KEY `absence_ibfk_1` (`Log_StudentID`),
  KEY `Log_TeacherID` (`Log_TeacherID`),
  CONSTRAINT `log_ibfk_1` FOREIGN KEY (`Log_StudentID`) REFERENCES `student` (`Student_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `log_ibfk_2` FOREIGN KEY (`Log_TeacherID`) REFERENCES `teacher` (`Teacher_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', '8', '2019-05-20', '回家', '1');
INSERT INTO `log` VALUES ('2', '9', '2019-05-21', '外出旅游', '2');
INSERT INTO `log` VALUES ('12', '14', '2019-05-26', '约会', '1');
INSERT INTO `log` VALUES ('13', '57', '2019-05-26', '无故', '10');
INSERT INTO `log` VALUES ('15', '10', '2019-05-28', '', '1');
INSERT INTO `log` VALUES ('16', '10', '2019-05-28', '', '1');
INSERT INTO `log` VALUES ('17', '10', '2019-05-28', '', '1');
INSERT INTO `log` VALUES ('18', '8', '2019-05-28', '回家', '1');
INSERT INTO `log` VALUES ('19', '8', '2019-05-23', '外出旅游', '1');
INSERT INTO `log` VALUES ('20', '8', '2019-05-22', '约会', '1');
INSERT INTO `log` VALUES ('21', '8', '2019-05-21', '无故', '1');
INSERT INTO `log` VALUES ('22', '8', '2019-05-19', '无故', '1');
INSERT INTO `log` VALUES ('23', '8', '2019-06-07', '', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Student_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Student_Username` varchar(30) NOT NULL,
  `Student_Password` varchar(30) NOT NULL,
  `Student_Name` varchar(30) NOT NULL,
  `Student_Dept` varchar(30) DEFAULT NULL,
  `Student_Tel` varchar(30) DEFAULT NULL,
  `Student_Sex` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Student_ID`),
  UNIQUE KEY `Student_Username` (`Student_Username`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('8', 'lxt', '1', '陆轩韬', '软件工程', '13971337720', '男');
INSERT INTO `student` VALUES ('9', 'lxt2', '1', '徐涵宇', '软件工程', '18968279587', '男');
INSERT INTO `student` VALUES ('10', 'lxt3', '1', '张三', '计算机', '18600020361', '男');
INSERT INTO `student` VALUES ('11', 'lxt4', '1', '李四', '计算机', '13729971341', '男');
INSERT INTO `student` VALUES ('12', 'lxt5', '1', '陈龙', '计算机', '13161853001', '男');
INSERT INTO `student` VALUES ('13', 'lxt6', '1', '李易峰', '计算机', '13049774079', '男');
INSERT INTO `student` VALUES ('14', 'lxt7', '1', '吴亦凡', '计算机', '13147409635', '男');
INSERT INTO `student` VALUES ('15', 'lxt8', '1', '胡歌', '物理', '13839831670', '男');
INSERT INTO `student` VALUES ('16', 'lxt9', '1', '周杰伦', '化学', '15186792277', '男');
INSERT INTO `student` VALUES ('17', 'lxt10', '1', '黄晓明', '生物', '18714930947', '男');
INSERT INTO `student` VALUES ('18', 'lxt11', '1', '鹿晗', '马克思', '13385433654', '男');
INSERT INTO `student` VALUES ('19', 'lxt12', '1', '周杰伦', '马克思', '13020377222', '男');
INSERT INTO `student` VALUES ('20', 'lxt13', '1', '黄晓明', '马克思', '15710615660', '男');
INSERT INTO `student` VALUES ('21', 'lxt14', '1', '吴六甲', '马克思', '13752796106', '男');
INSERT INTO `student` VALUES ('22', 'lxt15', '1', '王乙二', '马克思', '13594487525', '男');
INSERT INTO `student` VALUES ('23', 'lxt16', '1', '王乙二', '马克思', '13009505537', '男');
INSERT INTO `student` VALUES ('24', 'lxt17', '1', '李丁三', '马克思', '13661736978', '男');
INSERT INTO `student` VALUES ('25', 'lxt18', '1', '李一十', '马克思', '13207740762', '男');
INSERT INTO `student` VALUES ('26', 'lxt19', '1', '钱丁五', '物理', '18674278111', '男');
INSERT INTO `student` VALUES ('27', 'lxt20', '1', '赵六十', '化学', '13424349769', '男');
INSERT INTO `student` VALUES ('28', 'lxt21', '1', '吴九甲', '生物', '13385433654', '男');
INSERT INTO `student` VALUES ('29', 'lxt22', '1', '郑十丁', '物理', '13020377222', '男');
INSERT INTO `student` VALUES ('30', 'lxt23', '1', '郑十丁', '化学', '15710615660', '男');
INSERT INTO `student` VALUES ('31', 'lxt24', '1', '周十九', '生物', '13752796106', '男');
INSERT INTO `student` VALUES ('32', 'lxt25', '1', '周十九', '物理', '13594487525', '男');
INSERT INTO `student` VALUES ('33', 'lxt26', '1', '孙十二', '化学', '13009505537', '男');
INSERT INTO `student` VALUES ('34', 'lxt27', '1', '赵九十', '生物', '13661736978', '男');
INSERT INTO `student` VALUES ('35', 'lxt28', '1', '孙九二', '软件工程', '13207740762', '女');
INSERT INTO `student` VALUES ('36', 'lxt29', '1', '王四六', '软件工程', '18674278111', '女');
INSERT INTO `student` VALUES ('37', 'lxt30', '1', '王四六', '软件工程', '13424349769', '女');
INSERT INTO `student` VALUES ('38', 'lxt31', '1', '王三乙', '软件工程', '18926640791', '女');
INSERT INTO `student` VALUES ('39', 'lxt32', '1', '孙三甲', '软件工程', '18992320684', '女');
INSERT INTO `student` VALUES ('40', 'lxt33', '1', '吴丁六', '软件工程', '18676029904', '女');
INSERT INTO `student` VALUES ('41', 'lxt34', '1', '赵甲', '历史', '13475709814', '女');
INSERT INTO `student` VALUES ('42', 'lxt35', '1', '周七八', '历史', '13535729041', '女');
INSERT INTO `student` VALUES ('43', 'lxt36', '1', '钱四丙', '历史', '13023792586', '女');
INSERT INTO `student` VALUES ('44', 'lxt37', '1', '周五一', '历史', '13998460171', '女');
INSERT INTO `student` VALUES ('45', 'lxt38', '1', '孙一四', '历史', '13230166383', '女');
INSERT INTO `student` VALUES ('46', 'lxt39', '1', '孙一四', '历史', '13034354604', '女');
INSERT INTO `student` VALUES ('47', 'lxt40', '1', '孙一四', '医学', '13937889172', '女');
INSERT INTO `student` VALUES ('48', 'lxt41', '1', '孙三丁', '医学', '13386811334', '女');
INSERT INTO `student` VALUES ('49', 'lxt42', '1', '吴八三', '医学', '13294524699', '女');
INSERT INTO `student` VALUES ('50', 'lxt43', '1', '钱五', '医学', '18602186832', '女');
INSERT INTO `student` VALUES ('51', 'lxt44', '1', '周四九', '医学', '13517154222', '女');
INSERT INTO `student` VALUES ('52', 'lxt45', '1', '吴甲', '医学', '13096427150', '女');
INSERT INTO `student` VALUES ('53', 'lxt46', '1', '赵七四', '教育', '15716832397', '女');
INSERT INTO `student` VALUES ('54', 'lxt47', '1', '周四六', '教育', '13016966169', '女');
INSERT INTO `student` VALUES ('55', 'lxt48', '1', '吴八六', '教育', '13582586655', '女');
INSERT INTO `student` VALUES ('56', 'lxt49', '1', '吴八六', '心理', '13745692839', '女');
INSERT INTO `student` VALUES ('57', 'lxt50', '1', '郑七十', '心理', '13547600405', '女');
INSERT INTO `student` VALUES ('66', 'lxt123', '1', 'lxt5', '', '', '男');
INSERT INTO `student` VALUES ('70', 'lxt300', '1', '陆轩韬200', '', '', '男');
INSERT INTO `student` VALUES ('71', 'lxt3004', '1', '陆轩韬300', '', '', '男');

-- ----------------------------
-- Table structure for stu_dor
-- ----------------------------
DROP TABLE IF EXISTS `stu_dor`;
CREATE TABLE `stu_dor` (
  `SD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SD_StudentID` int(11) NOT NULL,
  `SD_DormitoryID` int(11) NOT NULL,
  `SD_State` varchar(30) NOT NULL,
  `SD_Date` varchar(30) NOT NULL,
  PRIMARY KEY (`SD_ID`),
  KEY `SD_StudentID` (`SD_StudentID`),
  KEY `SD_DormitoryID` (`SD_DormitoryID`),
  CONSTRAINT `stu_dor_ibfk_1` FOREIGN KEY (`SD_StudentID`) REFERENCES `student` (`Student_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stu_dor_ibfk_2` FOREIGN KEY (`SD_DormitoryID`) REFERENCES `dormitory` (`Dormitory_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of stu_dor
-- ----------------------------
INSERT INTO `stu_dor` VALUES ('1', '8', '1', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('2', '9', '1', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('3', '10', '1', '入住', '2019-05-21');
INSERT INTO `stu_dor` VALUES ('4', '11', '1', '入住', '2019-05-22');
INSERT INTO `stu_dor` VALUES ('9', '12', '2', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('10', '13', '2', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('11', '14', '2', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('24', '15', '2', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('25', '16', '3', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('26', '17', '3', '入住', '2019-05-21');
INSERT INTO `stu_dor` VALUES ('27', '18', '4', '入住', '2019-05-22');
INSERT INTO `stu_dor` VALUES ('28', '19', '4', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('29', '20', '5', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('30', '21', '6', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('31', '22', '6', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('32', '23', '6', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('33', '24', '7', '入住', '2019-05-21');
INSERT INTO `stu_dor` VALUES ('34', '25', '7', '入住', '2019-05-22');
INSERT INTO `stu_dor` VALUES ('35', '26', '8', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('36', '27', '8', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('37', '28', '9', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('38', '29', '10', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('39', '30', '11', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('40', '31', '12', '入住', '2019-05-21');
INSERT INTO `stu_dor` VALUES ('41', '32', '12', '入住', '2019-05-22');
INSERT INTO `stu_dor` VALUES ('42', '33', '12', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('43', '34', '12', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('44', '35', '13', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('45', '36', '13', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('46', '37', '14', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('47', '38', '15', '入住', '2019-05-21');
INSERT INTO `stu_dor` VALUES ('48', '39', '16', '入住', '2019-05-22');
INSERT INTO `stu_dor` VALUES ('49', '40', '16', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('50', '41', '17', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('51', '42', '17', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('52', '43', '17', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('53', '44', '18', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('54', '45', '18', '入住', '2019-05-21');
INSERT INTO `stu_dor` VALUES ('55', '46', '18', '入住', '2019-05-22');
INSERT INTO `stu_dor` VALUES ('56', '47', '18', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('57', '48', '19', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('58', '49', '19', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('59', '50', '19', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('60', '51', '19', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('61', '52', '19', '入住', '2019-05-21');
INSERT INTO `stu_dor` VALUES ('62', '53', '20', '入住', '2019-05-22');
INSERT INTO `stu_dor` VALUES ('63', '54', '20', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('64', '55', '20', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('65', '56', '20', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('66', '57', '20', '入住', '2019-05-23');
INSERT INTO `stu_dor` VALUES ('71', '70', '21', '入住', '2019-06-07');
INSERT INTO `stu_dor` VALUES ('72', '71', '20', '迁出', '2019-06-07');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `Teacher_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Teacher_Username` varchar(30) NOT NULL,
  `Teacher_Password` varchar(30) NOT NULL,
  `Teacher_Name` varchar(30) NOT NULL,
  `Teacher_Sex` varchar(10) DEFAULT NULL,
  `Teacher_Tel` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Teacher_ID`),
  UNIQUE KEY `Teacher_Username` (`Teacher_Username`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'lxt', '1', '陆幼利老师', '男', '12345678');
INSERT INTO `teacher` VALUES ('2', 'lxt2', '1', '窦亮老师', '女', '87654321');
INSERT INTO `teacher` VALUES ('3', 'lxt3', '1', '徐飞老师', '男', '32132133');
INSERT INTO `teacher` VALUES ('4', 'lxt4', '1', '谢顶奎老师', '男', '11111111');
INSERT INTO `teacher` VALUES ('5', 'lxt5', '1', '兰曼老师', '女', '22222222');
INSERT INTO `teacher` VALUES ('6', 'lxt6', '1', '吴苑斌老师', '男', '33333333');
INSERT INTO `teacher` VALUES ('7', 'lxt7', '1', '王峰老师', '男', '44444444');
INSERT INTO `teacher` VALUES ('8', 'lxt8', '1', '杨静老师', '女', '55555555');
INSERT INTO `teacher` VALUES ('9', 'lxt9', '1', '杨燕老师', '女', '66666666');
INSERT INTO `teacher` VALUES ('10', 'lxt10', '1', '肖春芸老师', '女', '77777777');
INSERT INTO `teacher` VALUES ('12', 'lxt100', '1', '测试老师', '男', '');

-- ----------------------------
-- Table structure for tea_bui
-- ----------------------------
DROP TABLE IF EXISTS `tea_bui`;
CREATE TABLE `tea_bui` (
  `TB_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TB_TeacherID` int(11) NOT NULL,
  `TB_BuildingID` int(11) NOT NULL,
  PRIMARY KEY (`TB_ID`),
  KEY `tea_bui_ibfk_1` (`TB_TeacherID`),
  KEY `tea_bui_ibfk_2` (`TB_BuildingID`),
  CONSTRAINT `tea_bui_ibfk_1` FOREIGN KEY (`TB_TeacherID`) REFERENCES `teacher` (`Teacher_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tea_bui_ibfk_2` FOREIGN KEY (`TB_BuildingID`) REFERENCES `building` (`Building_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tea_bui
-- ----------------------------
INSERT INTO `tea_bui` VALUES ('1', '1', '1');
INSERT INTO `tea_bui` VALUES ('2', '2', '1');
INSERT INTO `tea_bui` VALUES ('3', '3', '2');
INSERT INTO `tea_bui` VALUES ('5', '4', '2');
INSERT INTO `tea_bui` VALUES ('6', '5', '3');
INSERT INTO `tea_bui` VALUES ('8', '6', '3');
INSERT INTO `tea_bui` VALUES ('9', '7', '4');
INSERT INTO `tea_bui` VALUES ('10', '8', '4');
INSERT INTO `tea_bui` VALUES ('11', '9', '5');
INSERT INTO `tea_bui` VALUES ('12', '10', '5');
INSERT INTO `tea_bui` VALUES ('14', '3', '7');
INSERT INTO `tea_bui` VALUES ('15', '2', '7');

-- ----------------------------
-- View structure for dor_bui_view
-- ----------------------------
DROP VIEW IF EXISTS `dor_bui_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `dor_bui_view` AS select `dormitory`.`Dormitory_ID` AS `Dormitory_ID`,`dormitory`.`Dormitory_Name` AS `Dormitory_Name`,`dormitory`.`Dormitory_Size` AS `Dormitory_Size`,`dormitory`.`Dormitory_Now` AS `Dormitory_Now`,`building`.`Building_ID` AS `Building_ID`,`building`.`Building_Name` AS `Building_Name`,`building`.`Building_Type` AS `Building_Type`,`dor_bui`.`DB_ID` AS `DB_ID`,`dor_bui`.`DB_DormitoryID` AS `DB_DormitoryID`,`dor_bui`.`DB_BuildingID` AS `DB_BuildingID` from ((`dormitory` join `building`) join `dor_bui`) where ((`dormitory`.`Dormitory_ID` = `dor_bui`.`DB_DormitoryID`) and (`building`.`Building_ID` = `dor_bui`.`DB_BuildingID`)) ;

-- ----------------------------
-- View structure for stu_dor_view
-- ----------------------------
DROP VIEW IF EXISTS `stu_dor_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stu_dor_view` AS select `student`.`Student_ID` AS `Student_ID`,`student`.`Student_Username` AS `Student_Username`,`student`.`Student_Password` AS `Student_Password`,`student`.`Student_Name` AS `Student_Name`,`student`.`Student_Dept` AS `Student_Dept`,`student`.`Student_Tel` AS `Student_Tel`,`student`.`Student_Sex` AS `Student_Sex`,`stu_dor`.`SD_ID` AS `SD_ID`,`stu_dor`.`SD_StudentID` AS `SD_StudentID`,`stu_dor`.`SD_DormitoryID` AS `SD_DormitoryID`,`stu_dor`.`SD_State` AS `SD_State`,`stu_dor`.`SD_Date` AS `SD_Date`,`dormitory`.`Dormitory_ID` AS `Dormitory_ID`,`dormitory`.`Dormitory_Name` AS `Dormitory_Name`,`dormitory`.`Dormitory_Size` AS `Dormitory_Size`,`dormitory`.`Dormitory_Now` AS `Dormitory_Now` from ((`student` join `stu_dor`) join `dormitory`) where ((`stu_dor`.`SD_StudentID` = `student`.`Student_ID`) and (`stu_dor`.`SD_DormitoryID` = `dormitory`.`Dormitory_ID`)) ;
DROP TRIGGER IF EXISTS `stu_dor_insert_after_trigger`;
DELIMITER ;;
CREATE TRIGGER `stu_dor_insert_after_trigger` AFTER INSERT ON `stu_dor` FOR EACH ROW BEGIN
update dormitory set Dormitory_Now=Dormitory_Now+1 where Dormitory_ID=new.SD_DormitoryID;
end
;;
DELIMITER ;
