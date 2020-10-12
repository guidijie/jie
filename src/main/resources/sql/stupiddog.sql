/*
 Navicat Premium Data Transfer

 Source Server         : mybati
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : stupiddog

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 12/10/2020 10:43:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `price` double NOT NULL COMMENT '价格',
  `preferential` double NULL DEFAULT NULL COMMENT '商品优惠价格',
  `grade` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程等级(入门，进阶，大师)',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程介绍',
  `details` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程详细介绍',
  `directory` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程目录',
  `creationtime` datetime(0) NULL DEFAULT NULL COMMENT '商品添加时间',
  `modifytime` datetime(0) NULL DEFAULT NULL COMMENT '商品修改时间',
  `imagePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES (1, '手绘时装插画', 0, 0, '入门', '绘画小白也能做设计？一步步教你人物手绘！</br></br>独立完成精美插画，不再是梦！</br></br>专业名师一步步教你掌握时装手绘基础，让零基础的你也可以学会设计。', '犹太青年圭多（罗伯托·贝尼尼）邂逅美丽的女教师多拉（尼可莱塔·布拉斯基），他彬彬有礼的向多拉鞠躬：“早安！公主！”。历经诸多令人啼笑皆非的周折后，天遂人愿，两人幸福美满的生活在一起。 然而好景不长，法西斯政权下，圭多和儿子被强行送往犹太人集中营。多拉虽没有犹太血统，毅然同行，与丈夫儿子分开关押在一个集中营里。聪明乐天的圭多哄骗儿子这只是一场游戏，奖品就是一辆大坦克，儿子快乐、天真的生活在纳粹的阴霾之中。尽管集中营的生活艰苦寂寞，圭多仍然带给他人很多快乐，他还趁机在纳粹的广播里问候妻子：“早安！公主！” 法西斯政权即将倾覆，纳粹的集中营很快就要接受最后的清理，圭多编给儿子的游戏该怎么结束？他们一家能否平安的度过这黑暗的年代呢？', '01-基础理论－认识素描（一）</br>02-基础理论－认识素描（二）</br>03-基础理论－认识素描（三）</br>04-基础理论－点线面</br>05-基础透视（一）</br>06-基础透视（二）</br>07-几何－平面几何（一）</br>08-几何－平面几何（二）</br>09-平面几何－圆的透视与变形（一）</br>10-平面几何－圆的透视与变形（二）</br>11-立体几何－平面几何体（一）</br>12-立体几何－平面几何体（二）</br>13-立体几何－平面几何体（三）</br>14-立体几何－曲面几何体（一）</br>15-立体几何－曲面几何体（二）</br>16-立体几何－曲面几何体（三）</br>17-明暗光影</br>', '2020-05-26 07:54:37', '2020-05-26 07:54:39', '\\images\\goodsImage\\6_1.jpg');
INSERT INTO `t_goods` VALUES (2, '轻松学素描', 600, 600, '进阶', '理论不再枯燥，基础也可以很有趣~</br></br> 为大家带来轻松学素描课程，让零基础入门不再乏味！ </br></br>就让我们抛开传统刻板的素描教学，跟着老师一起欢乐学素描。', '犹太青年圭多（罗伯托·贝尼尼）邂逅美丽的女教师多拉（尼可莱塔·布拉斯基），他彬彬有礼的向多拉鞠躬：“早安！公主！”。历经诸多令人啼笑皆非的周折后，天遂人愿，两人幸福美满的生活在一起。 然而好景不长，法西斯政权下，圭多和儿子被强行送往犹太人集中营。多拉虽没有犹太血统，毅然同行，与丈夫儿子分开关押在一个集中营里。聪明乐天的圭多哄骗儿子这只是一场游戏，奖品就是一辆大坦克，儿子快乐、天真的生活在纳粹的阴霾之中。尽管集中营的生活艰苦寂寞，圭多仍然带给他人很多快乐，他还趁机在纳粹的广播里问候妻子：“早安！公主！” 法西斯政权即将倾覆，纳粹的集中营很快就要接受最后的清理，圭多编给儿子的游戏该怎么结束？他们一家能否平安的度过这黑暗的年代呢？', '01-基础理论－认识素描（一）</br>02-基础理论－认识素描（二）</br>03-基础理论－认识素描（三）</br>04-基础理论－点线面</br>05-基础透视（一）</br>06-基础透视（二）</br>07-几何－平面几何（一）</br>08-几何－平面几何（二）</br>09-平面几何－圆的透视与变形（一）</br>10-平面几何－圆的透视与变形（二）</br>11-立体几何－平面几何体（一）</br>12-立体几何－平面几何体（二）</br>13-立体几何－平面几何体（三）</br>14-立体几何－曲面几何体（一）</br>15-立体几何－曲面几何体（二）</br>16-立体几何－曲面几何体（三）</br>17-明暗光影</br>', '2020-05-26 07:54:37', '2020-05-26 07:54:39', '\\images\\goodsImage\\4_1.jpg');
INSERT INTO `t_goods` VALUES (3, '轻松学油画', 1600, 720, '大师', '适合零基础想要学习油画的同学。</br></br>通过学习可以掌握油画技法；完成5副主题画作，5副大师作品临摹。', '犹太青年圭多（罗伯托·贝尼尼）邂逅美丽的女教师多拉（尼可莱塔·布拉斯基），他彬彬有礼的向多拉鞠躬：“早安！公主！”。历经诸多令人啼笑皆非的周折后，天遂人愿，两人幸福美满的生活在一起。 然而好景不长，法西斯政权下，圭多和儿子被强行送往犹太人集中营。多拉虽没有犹太血统，毅然同行，与丈夫儿子分开关押在一个集中营里。聪明乐天的圭多哄骗儿子这只是一场游戏，奖品就是一辆大坦克，儿子快乐、天真的生活在纳粹的阴霾之中。尽管集中营的生活艰苦寂寞，圭多仍然带给他人很多快乐，他还趁机在纳粹的广播里问候妻子：“早安！公主！” 法西斯政权即将倾覆，纳粹的集中营很快就要接受最后的清理，圭多编给儿子的游戏该怎么结束？他们一家能否平安的度过这黑暗的年代呢？', '01-基础理论－认识素描（一）</br>02-基础理论－认识素描（二）</br>03-基础理论－认识素描（三）</br>04-基础理论－点线面</br>05-基础透视（一）</br>06-基础透视（二）</br>07-几何－平面几何（一）</br>08-几何－平面几何（二）</br>09-平面几何－圆的透视与变形（一）</br>10-平面几何－圆的透视与变形（二）</br>11-立体几何－平面几何体（一）</br>12-立体几何－平面几何体（二）</br>13-立体几何－平面几何体（三）</br>14-立体几何－曲面几何体（一）</br>15-立体几何－曲面几何体（二）</br>16-立体几何－曲面几何体（三）</br>17-明暗光影</br>', '2020-05-26 07:54:37', '2020-05-26 07:54:39', '\\images\\goodsImage\\3_1.jpg');
INSERT INTO `t_goods` VALUES (4, '产品UI设计师从入门到精通', 400, 400, '入门', '绘画小白也能做设计？一步步教你人物手绘！ </br></br>独立完成精美插画，不再是梦！ </br></br>专业名师一步步教你掌握时装手绘基础，让零基础的你也可以学会设计。', '犹太青年圭多（罗伯托·贝尼尼）邂逅美丽的女教师多拉（尼可莱塔·布拉斯基），他彬彬有礼的向多拉鞠躬：“早安！公主！”。历经诸多令人啼笑皆非的周折后，天遂人愿，两人幸福美满的生活在一起。 然而好景不长，法西斯政权下，圭多和儿子被强行送往犹太人集中营。多拉虽没有犹太血统，毅然同行，与丈夫儿子分开关押在一个集中营里。聪明乐天的圭多哄骗儿子这只是一场游戏，奖品就是一辆大坦克，儿子快乐、天真的生活在纳粹的阴霾之中。尽管集中营的生活艰苦寂寞，圭多仍然带给他人很多快乐，他还趁机在纳粹的广播里问候妻子：“早安！公主！” 法西斯政权即将倾覆，纳粹的集中营很快就要接受最后的清理，圭多编给儿子的游戏该怎么结束？他们一家能否平安的度过这黑暗的年代呢？', '01-基础理论－认识素描（一）</br>02-基础理论－认识素描（二）</br>03-基础理论－认识素描（三）</br>04-基础理论－点线面</br>05-基础透视（一）</br>06-基础透视（二）</br>07-几何－平面几何（一）</br>08-几何－平面几何（二）</br>09-平面几何－圆的透视与变形（一）</br>10-平面几何－圆的透视与变形（二）</br>11-立体几何－平面几何体（一）</br>12-立体几何－平面几何体（二）</br>13-立体几何－平面几何体（三）</br>14-立体几何－曲面几何体（一）</br>15-立体几何－曲面几何体（二）</br>16-立体几何－曲面几何体（三）</br>17-明暗光影</br>', '2020-05-26 09:01:28', '2020-05-26 09:01:31', '\\images\\goodsImage\\1_1.jpg');
INSERT INTO `t_goods` VALUES (5, 'UI设计+UE交互 ', 600, 600, '大师', '绘画小白也能做设计？一步步教你人物手绘！ </br></br>独立完成精美插画，不再是梦！ </br></br>专业名师一步步教你掌握时装手绘基础，让零基础的你也可以学会设计', '犹太青年圭多（罗伯托·贝尼尼）邂逅美丽的女教师多拉（尼可莱塔·布拉斯基），他彬彬有礼的向多拉鞠躬：“早安！公主！”。历经诸多令人啼笑皆非的周折后，天遂人愿，两人幸福美满的生活在一起。 然而好景不长，法西斯政权下，圭多和儿子被强行送往犹太人集中营。多拉虽没有犹太血统，毅然同行，与丈夫儿子分开关押在一个集中营里。聪明乐天的圭多哄骗儿子这只是一场游戏，奖品就是一辆大坦克，儿子快乐、天真的生活在纳粹的阴霾之中。尽管集中营的生活艰苦寂寞，圭多仍然带给他人很多快乐，他还趁机在纳粹的广播里问候妻子：“早安！公主！” 法西斯政权即将倾覆，纳粹的集中营很快就要接受最后的清理，圭多编给儿子的游戏该怎么结束？他们一家能否平安的度过这黑暗的年代呢？', '01-基础理论－认识素描（一）</br>02-基础理论－认识素描（二）</br>03-基础理论－认识素描（三）</br>04-基础理论－点线面</br>05-基础透视（一）</br>06-基础透视（二）</br>07-几何－平面几何（一）</br>08-几何－平面几何（二）</br>09-平面几何－圆的透视与变形（一）</br>10-平面几何－圆的透视与变形（二）</br>11-立体几何－平面几何体（一）</br>12-立体几何－平面几何体（二）</br>13-立体几何－平面几何体（三）</br>14-立体几何－曲面几何体（一）</br>15-立体几何－曲面几何体（二）</br>16-立体几何－曲面几何体（三）</br>17-明暗光影</br>', '2020-05-26 09:03:40', '2020-05-26 09:03:42', '\\images\\goodsImage\\5_1.jpg');
INSERT INTO `t_goods` VALUES (6, '日系二次元动漫绘画课堂', 900, 300, '进阶', '你是否想动动手指轻轻勾勒，画出那些每每忆起都或心潮澎湃或心生欢喜的角色，</br></br>却又连模仿都嫌生涩呢？</br></br>不要惊慌~ 看看你想画的TA有没有收录在本课中，手把手教你画出最生动的TA！', '犹太青年圭多（罗伯托·贝尼尼）邂逅美丽的女教师多拉（尼可莱塔·布拉斯基），他彬彬有礼的向多拉鞠躬：“早安！公主！”。历经诸多令人啼笑皆非的周折后，天遂人愿，两人幸福美满的生活在一起。 然而好景不长，法西斯政权下，圭多和儿子被强行送往犹太人集中营。多拉虽没有犹太血统，毅然同行，与丈夫儿子分开关押在一个集中营里。聪明乐天的圭多哄骗儿子这只是一场游戏，奖品就是一辆大坦克，儿子快乐、天真的生活在纳粹的阴霾之中。尽管集中营的生活艰苦寂寞，圭多仍然带给他人很多快乐，他还趁机在纳粹的广播里问候妻子：“早安！公主！” 法西斯政权即将倾覆，纳粹的集中营很快就要接受最后的清理，圭多编给儿子的游戏该怎么结束？他们一家能否平安的度过这黑暗的年代呢？', '01-基础理论－认识素描（一）</br>02-基础理论－认识素描（二）</br>03-基础理论－认识素描（三）</br>04-基础理论－点线面</br>05-基础透视（一）</br>06-基础透视（二）</br>07-几何－平面几何（一）</br>08-几何－平面几何（二）</br>09-平面几何－圆的透视与变形（一）</br>10-平面几何－圆的透视与变形（二）</br>11-立体几何－平面几何体（一）</br>12-立体几何－平面几何体（二）</br>13-立体几何－平面几何体（三）</br>14-立体几何－曲面几何体（一）</br>15-立体几何－曲面几何体（二）</br>16-立体几何－曲面几何体（三）</br>17-明暗光影</br', '2020-05-26 12:10:06', '2020-05-26 12:10:08', '\\images\\goodsImage\\2_1.jpg');

-- ----------------------------
-- Table structure for t_goods_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_cart`;
CREATE TABLE `t_goods_cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车表ID',
  `goods_id` int(11) NOT NULL COMMENT '商品ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `buy_count` int(11) NOT NULL DEFAULT 1 COMMENT '商品数量',
  `creationtime` datetime(0) NULL DEFAULT NULL COMMENT '购物车商品添加时间',
  `modifytime` datetime(0) NULL DEFAULT NULL COMMENT '商品修改时间购物车',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods_cart
-- ----------------------------
INSERT INTO `t_goods_cart` VALUES (3, 5, 3, 1, '2020-06-21 14:03:53', '2020-06-21 14:03:53');
INSERT INTO `t_goods_cart` VALUES (13, 6, 3, 1, '2020-06-26 14:09:30', '2020-06-26 14:09:30');
INSERT INTO `t_goods_cart` VALUES (22, 2, 2, 1, '2020-09-15 15:29:59', '2020-09-15 15:29:59');

-- ----------------------------
-- Table structure for t_goods_id_type
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_id_type`;
CREATE TABLE `t_goods_id_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品与类型关联表',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `goods_type_id` int(11) NOT NULL COMMENT '商品类型id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods_id_type
-- ----------------------------
INSERT INTO `t_goods_id_type` VALUES (1, 1, 101);
INSERT INTO `t_goods_id_type` VALUES (2, 2, 101);
INSERT INTO `t_goods_id_type` VALUES (3, 3, 101);
INSERT INTO `t_goods_id_type` VALUES (4, 4, 102);
INSERT INTO `t_goods_id_type` VALUES (5, 5, 102);
INSERT INTO `t_goods_id_type` VALUES (6, 6, 101);

-- ----------------------------
-- Table structure for t_goods_type
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_type`;
CREATE TABLE `t_goods_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品类型id',
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品类型名称',
  `creationtime` datetime(0) NOT NULL COMMENT '商品类型创建时间',
  `modifytime` datetime(0) NOT NULL COMMENT '商品类型修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods_type
-- ----------------------------
INSERT INTO `t_goods_type` VALUES (101, '绘画', '2020-05-26 07:42:09', '2020-05-26 07:42:22');
INSERT INTO `t_goods_type` VALUES (102, '平面设计', '2020-05-26 07:42:50', '2020-05-26 07:42:55');
INSERT INTO `t_goods_type` VALUES (103, '写字', '2020-09-19 04:37:36', '2020-09-19 04:56:37');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `order_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态',
  `total_amount` double(255, 2) NULL DEFAULT NULL COMMENT '总金额',
  `creationtime` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modifytime` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20200731122208 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (20200731121026, 2, '已完成', 600.00, '2020-07-31 04:10:27', '2020-07-31 04:10:27');
INSERT INTO `t_order` VALUES (20200831220917, 23, '已取消', 700.00, '2020-08-31 14:09:17', '2020-08-31 14:09:17');
INSERT INTO `t_order` VALUES (20200831220936, 23, '已完成', 700.00, '2020-08-31 14:09:37', '2020-08-31 14:09:37');
INSERT INTO `t_order` VALUES (20200909211405, 26, '已完成', 900.00, '2020-09-09 13:14:05', '2020-09-09 13:14:05');
INSERT INTO `t_order` VALUES (20200915235035, 2, '已取消', 600.00, '2020-09-15 15:50:36', '2020-09-15 15:50:36');
INSERT INTO `t_order` VALUES (20200915235042, 2, '未付款', 600.00, '2020-09-15 15:50:42', '2020-09-15 15:50:42');

-- ----------------------------
-- Table structure for t_order_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_order_goods`;
CREATE TABLE `t_order_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单商品表id',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单id',
  `goods_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_goods
-- ----------------------------
INSERT INTO `t_order_goods` VALUES (84, 20200705191958, 5);
INSERT INTO `t_order_goods` VALUES (85, 20200705191958, 3);
INSERT INTO `t_order_goods` VALUES (86, 20200705191958, 4);
INSERT INTO `t_order_goods` VALUES (87, 20200728204844, 1);
INSERT INTO `t_order_goods` VALUES (88, 20200728212309, 3);
INSERT INTO `t_order_goods` VALUES (89, 20200728212309, 4);
INSERT INTO `t_order_goods` VALUES (90, 20200728212309, 1);
INSERT INTO `t_order_goods` VALUES (91, 20200728212323, 3);
INSERT INTO `t_order_goods` VALUES (92, 20200728212506, 3);
INSERT INTO `t_order_goods` VALUES (95, 20200731121026, 5);
INSERT INTO `t_order_goods` VALUES (98, 20200831220917, 4);
INSERT INTO `t_order_goods` VALUES (99, 20200831220917, 6);
INSERT INTO `t_order_goods` VALUES (100, 20200831220936, 4);
INSERT INTO `t_order_goods` VALUES (101, 20200831220936, 6);
INSERT INTO `t_order_goods` VALUES (104, 20200909211405, 5);
INSERT INTO `t_order_goods` VALUES (105, 20200909211405, 6);
INSERT INTO `t_order_goods` VALUES (107, 20200915235035, 2);
INSERT INTO `t_order_goods` VALUES (108, 20200915235042, 2);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '超级管理员');
INSERT INTO `t_role` VALUES (2, '普通用户');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登录名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `creationtime` datetime(0) NOT NULL COMMENT '用户创建时间',
  `modifytime` datetime(0) NOT NULL COMMENT '用户修改时间',
  `mask` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户盐',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (2, 'jie', '3557779c073bd30575322b03c983a7eb', '2020-06-10 09:24:10', '2020-08-12 03:08:03', 'd064d418-3f42-4dce-b51e-02fe21275242', 2);
INSERT INTO `t_user` VALUES (22, 'zhangsan', '3806fa1e2133a16a6bb397c74a7ffb6e', '2020-08-01 16:42:59', '2020-08-01 16:42:59', 'a984b650-f9d1-4343-8415-185604957731', 2);
INSERT INTO `t_user` VALUES (23, 'huang', 'd8e7a02e91b108b0ebfc8ecc5ee579b6', '2020-08-31 14:07:31', '2020-08-31 14:07:31', 'b8991a65-aa3c-4f33-8381-0c7e84fdc44c', 2);
INSERT INTO `t_user` VALUES (24, '231315', 'c6ec6bbc9a73d21fc9111d4396987a56', '2020-09-03 12:38:23', '2020-09-03 12:38:23', '54e98bb6-1d83-441e-a30e-00405aa82e7a', 2);
INSERT INTO `t_user` VALUES (26, 'lll', 'b3b871f4368df7af4a0c094986ea7013', '2020-09-09 13:13:12', '2020-09-09 13:13:12', 'ebb4f293-ce20-4294-ae15-c01c0d55e087', 2);
INSERT INTO `t_user` VALUES (27, 'hhhh', '9e34f58200b24aec21cb185c4bf5a324', '2020-09-09 13:32:26', '2020-09-09 13:32:26', '59153f39-ea05-4b33-b935-e18916e4cc3a', 2);
INSERT INTO `t_user` VALUES (28, 'qweasd', '03db9bb96041ac159e71814460ae8d92', '2020-09-09 13:32:35', '2020-09-09 13:32:35', '658b48ac-df1e-463a-88a3-bbc8bb916c17', 2);
INSERT INTO `t_user` VALUES (29, 'qweqw', '391ad8b383b87dc1e85d062123fa141e', '2020-09-09 13:32:44', '2020-09-09 13:32:44', '65818635-62c1-4aa3-8560-bec292680eb7', 2);
INSERT INTO `t_user` VALUES (30, 'asdas%20', 'af7db93b03becbe610f0624623f7cf47', '2020-09-09 13:32:54', '2020-09-09 13:32:54', 'c64cb168-d050-440b-bc14-ccff852bea1c', 2);
INSERT INTO `t_user` VALUES (31, 'qweasdfc', 'f6a1fb6fc32b48ad686cbd35bb6f2db2', '2020-09-09 13:33:03', '2020-09-09 13:33:03', '6884bf66-19d9-4142-965b-84f03ff89a06', 2);
INSERT INTO `t_user` VALUES (32, 'qwefdv', 'e743f5723fa5e56864f090d3a1fb1fe2', '2020-09-09 13:33:15', '2020-09-09 13:33:15', '134c4ad2-4439-4908-b6c3-e91675067ad5', 2);
INSERT INTO `t_user` VALUES (33, 'xxxx1', 'a74c5e0d761053f492b997859502fa43', '2020-09-09 13:33:26', '2020-09-09 13:33:26', '764a7f5f-af37-4418-acad-1b4665159a80', 2);
INSERT INTO `t_user` VALUES (34, '1234', '423bb114e7eb203792231c9138526723', '2020-09-09 13:34:33', '2020-09-09 13:34:33', '82c59fc7-7fe6-4b44-8295-a7c4feee7621', 2);
INSERT INTO `t_user` VALUES (35, '12345', '9f8b28f0e01f67c7b3fec7e8b42210e2', '2020-09-09 13:34:51', '2020-09-09 13:34:51', 'd656bfde-a22f-449b-ba2e-e3a0afc023c9', 2);
INSERT INTO `t_user` VALUES (36, 'zzz', '121dcf4b1ea67cbf33943ccac1e2bc84', '2020-09-09 13:35:03', '2020-09-09 13:35:03', '1b7610ee-7835-45d0-9ab1-02534daac4ca', 2);
INSERT INTO `t_user` VALUES (37, 'zzzz', '295f6557b4c51e06d5d439695a023cd6', '2020-09-09 13:35:12', '2020-09-09 13:35:12', 'ce6202a7-ab36-43b0-909d-20028bcd68e8', 2);
INSERT INTO `t_user` VALUES (38, 'zzzzz', '4a62ea77d10e406bbd813077f5a63e5b', '2020-09-09 13:35:25', '2020-09-09 13:35:25', '067ff148-53f3-481d-81a5-853500ac7605', 2);
INSERT INTO `t_user` VALUES (40, '00000', '4edf4974cd0bab3ae51e9492d6c57e42', '2020-09-09 13:59:14', '2020-09-11 02:22:48', '5e0cf7de-0ff1-44c7-982b-8561d726ca3b', 2);
INSERT INTO `t_user` VALUES (41, 'hhhhwww', '56c7e3579d00bd9d8409eeddb83eaf2c', '2020-09-09 13:59:28', '2020-09-09 13:59:28', '8223e2fe-6df7-4241-9a19-94fe70f782ed', 2);
INSERT INTO `t_user` VALUES (43, 'wsxxsad', '6e86a8ffb5e1cf1a7e063ffb06e4aa20', '2020-09-09 14:00:11', '2020-09-09 14:00:11', '81e00957-80c0-49ff-8c6c-c31143cde274', 2);

-- ----------------------------
-- Table structure for t_user_course
-- ----------------------------
DROP TABLE IF EXISTS `t_user_course`;
CREATE TABLE `t_user_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户课程id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `goods_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_course
-- ----------------------------
INSERT INTO `t_user_course` VALUES (14, 2, 4);
INSERT INTO `t_user_course` VALUES (15, 2, 1);
INSERT INTO `t_user_course` VALUES (16, 2, 5);
INSERT INTO `t_user_course` VALUES (17, 23, 4);
INSERT INTO `t_user_course` VALUES (18, 23, 6);
INSERT INTO `t_user_course` VALUES (19, 26, 6);
INSERT INTO `t_user_course` VALUES (20, 26, 5);

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户信息表ID',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `money` double NULL DEFAULT 100000000 COMMENT '用户余额',
  `imagePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别(1为男0为女)',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `individuality_signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `creationtime` datetime(0) NULL DEFAULT NULL COMMENT '用户信息创建时间',
  `modifytime` datetime(0) NULL DEFAULT NULL COMMENT '用户信息修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
INSERT INTO `t_user_info` VALUES (1, 2, '老王', 99994120, '\\images\\userImages\\tou1.jpg', '32165478@qq.com', '2020-08-02 00:00:00', 0, '1921685454', '你最棒', '2020-06-24 09:27:01', '2020-09-12 12:59:58');
INSERT INTO `t_user_info` VALUES (7, 22, 'stupiddog', 100000000, '\\images\\userImages\\93b87f82-e079-46d6-b40e-e25825daf424.jpg', '', '2020-08-01 16:42:59', 1, '', '生活不止眼前的苟且', '2020-08-01 16:42:59', '2020-09-13 14:29:39');
INSERT INTO `t_user_info` VALUES (8, 23, 'dxasda', 99999300, '\\images\\userImages\\moren.jpg', '36851345@11.com', '2020-08-31 00:00:00', 0, '15345321', 'sadasdasdasd', '2020-08-31 14:07:32', '2020-08-31 14:10:25');
INSERT INTO `t_user_info` VALUES (9, 24, 'stupiddog', 100000000, '\\images\\userImages\\moren.jpg', '', '2020-09-03 12:38:23', 1, '', '生活不止眼前的苟且', '2020-09-03 12:38:23', '2020-09-03 12:38:23');
INSERT INTO `t_user_info` VALUES (11, 26, 'stupiddog', 99999100, '\\images\\userImages\\moren.jpg', '', '2020-09-09 13:13:12', 1, '', '生活不止眼前的苟且', '2020-09-09 13:13:12', '2020-09-09 13:13:12');
INSERT INTO `t_user_info` VALUES (12, 27, 'stupiddog', 100000000, '\\images\\userImages\\moren.jpg', '', '2020-09-09 13:32:26', 1, '', '生活不止眼前的苟且', '2020-09-09 13:32:26', '2020-09-09 13:32:26');
INSERT INTO `t_user_info` VALUES (13, 28, 'stupiddog', 100000000, '\\images\\userImages\\moren.jpg', '', '2020-09-09 13:32:35', 1, '', '生活不止眼前的苟且', '2020-09-09 13:32:35', '2020-09-09 13:32:35');
INSERT INTO `t_user_info` VALUES (14, 29, 'stupiddog', 100000000, '\\images\\userImages\\moren.jpg', '', '2020-09-09 13:32:44', 1, '', '生活不止眼前的苟且', '2020-09-09 13:32:44', '2020-09-09 13:32:44');
INSERT INTO `t_user_info` VALUES (15, 30, 'stupiddog', 100000000, '\\images\\userImages\\moren.jpg', '', '2020-09-09 13:32:54', 1, '', '生活不止眼前的苟且', '2020-09-09 13:32:54', '2020-09-09 13:32:54');
INSERT INTO `t_user_info` VALUES (16, 31, 'stupiddog', 100000000, '\\images\\userImages\\moren.jpg', '', '2020-09-09 13:33:03', 1, '', '生活不止眼前的苟且', '2020-09-09 13:33:03', '2020-09-09 13:33:03');
INSERT INTO `t_user_info` VALUES (17, 32, 'stupiddog', 100000000, '\\images\\userImages\\moren.jpg', '', '2020-09-09 13:33:15', 1, '', '生活不止眼前的苟且', '2020-09-09 13:33:15', '2020-09-09 13:33:15');
INSERT INTO `t_user_info` VALUES (18, 33, 'stupiddog', 100000000, '\\images\\userImages\\moren.jpg', '', '2020-09-09 13:33:26', 1, '', '生活不止眼前的苟且', '2020-09-09 13:33:26', '2020-09-09 13:33:26');
INSERT INTO `t_user_info` VALUES (19, 34, 'stupiddog', 100000000, '\\images\\userImages\\moren.jpg', '', '2020-09-09 13:34:33', 1, '', '生活不止眼前的苟且', '2020-09-09 13:34:33', '2020-09-09 13:34:33');
INSERT INTO `t_user_info` VALUES (20, 35, 'stupiddog', 100000000, '\\images\\userImages\\moren.jpg', '', '2020-09-09 13:34:51', 1, '', '生活不止眼前的苟且', '2020-09-09 13:34:51', '2020-09-09 13:34:51');
INSERT INTO `t_user_info` VALUES (21, 36, 'stupiddog', 100000000, '\\images\\userImages\\moren.jpg', '', '2020-09-09 13:35:03', 1, '', '生活不止眼前的苟且', '2020-09-09 13:35:03', '2020-09-09 13:35:03');
INSERT INTO `t_user_info` VALUES (22, 37, 'stupiddog', 100000000, '\\images\\userImages\\db7ca0bf-0e4b-478c-ab68-fb780767c34d.jpg', '', '2020-09-09 13:35:12', 1, '', '生活不止眼前的苟且', '2020-09-09 13:35:12', '2020-09-13 04:44:54');
INSERT INTO `t_user_info` VALUES (23, 38, 'stupiddog', 100000000, '\\images\\userImages\\moren.jpg', '', '2020-09-09 13:35:25', 1, '', '生活不止眼前的苟且', '2020-09-09 13:35:25', '2020-09-09 13:35:25');
INSERT INTO `t_user_info` VALUES (25, 40, '啊啊', 100000000, '\\images\\userImages\\moren.jpg', '12312@qq.con', '2020-09-01 16:00:00', 1, '156456485', '生活不止眼前的苟且', '2020-09-09 13:59:14', '2020-09-11 09:21:58');
INSERT INTO `t_user_info` VALUES (26, 41, 'stupiddog', 100000000, '\\images\\userImages\\moren.jpg', '', '2020-09-09 13:59:28', 1, '', '生活不止眼前的苟且', '2020-09-09 13:59:28', '2020-09-09 13:59:28');
INSERT INTO `t_user_info` VALUES (28, 43, 'stupiddog', 100000000, '\\images\\userImages\\moren.jpg', '', '2020-09-09 14:00:11', 1, '', '生活不止眼前的苟且', '2020-09-09 14:00:11', '2020-09-09 14:00:11');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 2, 1);
INSERT INTO `t_user_role` VALUES (2, 22, 2);
INSERT INTO `t_user_role` VALUES (3, 23, 2);
INSERT INTO `t_user_role` VALUES (4, 24, 2);
INSERT INTO `t_user_role` VALUES (6, 26, 2);
INSERT INTO `t_user_role` VALUES (7, 27, 2);
INSERT INTO `t_user_role` VALUES (8, 28, 2);
INSERT INTO `t_user_role` VALUES (9, 29, 2);
INSERT INTO `t_user_role` VALUES (10, 30, 2);
INSERT INTO `t_user_role` VALUES (11, 31, 2);
INSERT INTO `t_user_role` VALUES (12, 32, 2);
INSERT INTO `t_user_role` VALUES (13, 33, 2);
INSERT INTO `t_user_role` VALUES (14, 34, 2);
INSERT INTO `t_user_role` VALUES (15, 35, 2);
INSERT INTO `t_user_role` VALUES (16, 36, 2);
INSERT INTO `t_user_role` VALUES (17, 37, 2);
INSERT INTO `t_user_role` VALUES (18, 38, 2);
INSERT INTO `t_user_role` VALUES (20, 40, 2);
INSERT INTO `t_user_role` VALUES (21, 41, 2);
INSERT INTO `t_user_role` VALUES (23, 43, 2);

SET FOREIGN_KEY_CHECKS = 1;
