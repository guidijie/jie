/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : stupiddog

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 28/08/2020 13:56:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `price` double NOT NULL COMMENT '价格',
  `preferential` double NULL DEFAULT NULL COMMENT '商品优惠价格',
  `grade` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程等级(入门，进阶，大师)',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程介绍',
  `details` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程详细介绍',
  `directory` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程目录',
  `creationtime` datetime(0) NULL DEFAULT NULL COMMENT '商品添加时间',
  `modifytime` datetime(0) NULL DEFAULT NULL COMMENT '商品修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES (1, '手绘时装插画', 0, 0, '入门', '绘画小白也能做设计？一步步教你人物手绘！</br></br>独立完成精美插画，不再是梦！</br></br>专业名师一步步教你掌握时装手绘基础，让零基础的你也可以学会设计。', '犹太青年圭多（罗伯托·贝尼尼）邂逅美丽的女教师多拉（尼可莱塔·布拉斯基），他彬彬有礼的向多拉鞠躬：“早安！公主！”。历经诸多令人啼笑皆非的周折后，天遂人愿，两人幸福美满的生活在一起。 然而好景不长，法西斯政权下，圭多和儿子被强行送往犹太人集中营。多拉虽没有犹太血统，毅然同行，与丈夫儿子分开关押在一个集中营里。聪明乐天的圭多哄骗儿子这只是一场游戏，奖品就是一辆大坦克，儿子快乐、天真的生活在纳粹的阴霾之中。尽管集中营的生活艰苦寂寞，圭多仍然带给他人很多快乐，他还趁机在纳粹的广播里问候妻子：“早安！公主！” 法西斯政权即将倾覆，纳粹的集中营很快就要接受最后的清理，圭多编给儿子的游戏该怎么结束？他们一家能否平安的度过这黑暗的年代呢？', '01-基础理论－认识素描（一）</br>02-基础理论－认识素描（二）</br>03-基础理论－认识素描（三）</br>04-基础理论－点线面</br>05-基础透视（一）</br>06-基础透视（二）</br>07-几何－平面几何（一）</br>08-几何－平面几何（二）</br>09-平面几何－圆的透视与变形（一）</br>10-平面几何－圆的透视与变形（二）</br>11-立体几何－平面几何体（一）</br>12-立体几何－平面几何体（二）</br>13-立体几何－平面几何体（三）</br>14-立体几何－曲面几何体（一）</br>15-立体几何－曲面几何体（二）</br>16-立体几何－曲面几何体（三）</br>17-明暗光影</br>', '2020-05-26 07:54:37', '2020-05-26 07:54:39');
INSERT INTO `t_goods` VALUES (2, '轻松学素描', 600, 600, '进阶', '理论不再枯燥，基础也可以很有趣~</br></br> 为大家带来轻松学素描课程，让零基础入门不再乏味！ </br></br>就让我们抛开传统刻板的素描教学，跟着老师一起欢乐学素描。', '犹太青年圭多（罗伯托·贝尼尼）邂逅美丽的女教师多拉（尼可莱塔·布拉斯基），他彬彬有礼的向多拉鞠躬：“早安！公主！”。历经诸多令人啼笑皆非的周折后，天遂人愿，两人幸福美满的生活在一起。 然而好景不长，法西斯政权下，圭多和儿子被强行送往犹太人集中营。多拉虽没有犹太血统，毅然同行，与丈夫儿子分开关押在一个集中营里。聪明乐天的圭多哄骗儿子这只是一场游戏，奖品就是一辆大坦克，儿子快乐、天真的生活在纳粹的阴霾之中。尽管集中营的生活艰苦寂寞，圭多仍然带给他人很多快乐，他还趁机在纳粹的广播里问候妻子：“早安！公主！” 法西斯政权即将倾覆，纳粹的集中营很快就要接受最后的清理，圭多编给儿子的游戏该怎么结束？他们一家能否平安的度过这黑暗的年代呢？', '01-基础理论－认识素描（一）</br>02-基础理论－认识素描（二）</br>03-基础理论－认识素描（三）</br>04-基础理论－点线面</br>05-基础透视（一）</br>06-基础透视（二）</br>07-几何－平面几何（一）</br>08-几何－平面几何（二）</br>09-平面几何－圆的透视与变形（一）</br>10-平面几何－圆的透视与变形（二）</br>11-立体几何－平面几何体（一）</br>12-立体几何－平面几何体（二）</br>13-立体几何－平面几何体（三）</br>14-立体几何－曲面几何体（一）</br>15-立体几何－曲面几何体（二）</br>16-立体几何－曲面几何体（三）</br>17-明暗光影</br>', '2020-05-26 07:54:37', '2020-05-26 07:54:39');
INSERT INTO `t_goods` VALUES (3, '轻松学油画', 1600, 720, '大师', '适合零基础想要学习油画的同学。</br></br>通过学习可以掌握油画技法；完成5副主题画作，5副大师作品临摹。', '犹太青年圭多（罗伯托·贝尼尼）邂逅美丽的女教师多拉（尼可莱塔·布拉斯基），他彬彬有礼的向多拉鞠躬：“早安！公主！”。历经诸多令人啼笑皆非的周折后，天遂人愿，两人幸福美满的生活在一起。 然而好景不长，法西斯政权下，圭多和儿子被强行送往犹太人集中营。多拉虽没有犹太血统，毅然同行，与丈夫儿子分开关押在一个集中营里。聪明乐天的圭多哄骗儿子这只是一场游戏，奖品就是一辆大坦克，儿子快乐、天真的生活在纳粹的阴霾之中。尽管集中营的生活艰苦寂寞，圭多仍然带给他人很多快乐，他还趁机在纳粹的广播里问候妻子：“早安！公主！” 法西斯政权即将倾覆，纳粹的集中营很快就要接受最后的清理，圭多编给儿子的游戏该怎么结束？他们一家能否平安的度过这黑暗的年代呢？', '01-基础理论－认识素描（一）</br>02-基础理论－认识素描（二）</br>03-基础理论－认识素描（三）</br>04-基础理论－点线面</br>05-基础透视（一）</br>06-基础透视（二）</br>07-几何－平面几何（一）</br>08-几何－平面几何（二）</br>09-平面几何－圆的透视与变形（一）</br>10-平面几何－圆的透视与变形（二）</br>11-立体几何－平面几何体（一）</br>12-立体几何－平面几何体（二）</br>13-立体几何－平面几何体（三）</br>14-立体几何－曲面几何体（一）</br>15-立体几何－曲面几何体（二）</br>16-立体几何－曲面几何体（三）</br>17-明暗光影</br>', '2020-05-26 07:54:37', '2020-05-26 07:54:39');
INSERT INTO `t_goods` VALUES (4, '产品UI设计师从入门到精通', 400, 400, '入门', '绘画小白也能做设计？一步步教你人物手绘！ </br></br>独立完成精美插画，不再是梦！ </br></br>专业名师一步步教你掌握时装手绘基础，让零基础的你也可以学会设计。', '犹太青年圭多（罗伯托·贝尼尼）邂逅美丽的女教师多拉（尼可莱塔·布拉斯基），他彬彬有礼的向多拉鞠躬：“早安！公主！”。历经诸多令人啼笑皆非的周折后，天遂人愿，两人幸福美满的生活在一起。 然而好景不长，法西斯政权下，圭多和儿子被强行送往犹太人集中营。多拉虽没有犹太血统，毅然同行，与丈夫儿子分开关押在一个集中营里。聪明乐天的圭多哄骗儿子这只是一场游戏，奖品就是一辆大坦克，儿子快乐、天真的生活在纳粹的阴霾之中。尽管集中营的生活艰苦寂寞，圭多仍然带给他人很多快乐，他还趁机在纳粹的广播里问候妻子：“早安！公主！” 法西斯政权即将倾覆，纳粹的集中营很快就要接受最后的清理，圭多编给儿子的游戏该怎么结束？他们一家能否平安的度过这黑暗的年代呢？', '01-基础理论－认识素描（一）</br>02-基础理论－认识素描（二）</br>03-基础理论－认识素描（三）</br>04-基础理论－点线面</br>05-基础透视（一）</br>06-基础透视（二）</br>07-几何－平面几何（一）</br>08-几何－平面几何（二）</br>09-平面几何－圆的透视与变形（一）</br>10-平面几何－圆的透视与变形（二）</br>11-立体几何－平面几何体（一）</br>12-立体几何－平面几何体（二）</br>13-立体几何－平面几何体（三）</br>14-立体几何－曲面几何体（一）</br>15-立体几何－曲面几何体（二）</br>16-立体几何－曲面几何体（三）</br>17-明暗光影</br>', '2020-05-26 09:01:28', '2020-05-26 09:01:31');
INSERT INTO `t_goods` VALUES (5, 'UI设计+UE交互 ', 600, 600, '大师', '绘画小白也能做设计？一步步教你人物手绘！ </br></br>独立完成精美插画，不再是梦！ </br></br>专业名师一步步教你掌握时装手绘基础，让零基础的你也可以学会设计', '犹太青年圭多（罗伯托·贝尼尼）邂逅美丽的女教师多拉（尼可莱塔·布拉斯基），他彬彬有礼的向多拉鞠躬：“早安！公主！”。历经诸多令人啼笑皆非的周折后，天遂人愿，两人幸福美满的生活在一起。 然而好景不长，法西斯政权下，圭多和儿子被强行送往犹太人集中营。多拉虽没有犹太血统，毅然同行，与丈夫儿子分开关押在一个集中营里。聪明乐天的圭多哄骗儿子这只是一场游戏，奖品就是一辆大坦克，儿子快乐、天真的生活在纳粹的阴霾之中。尽管集中营的生活艰苦寂寞，圭多仍然带给他人很多快乐，他还趁机在纳粹的广播里问候妻子：“早安！公主！” 法西斯政权即将倾覆，纳粹的集中营很快就要接受最后的清理，圭多编给儿子的游戏该怎么结束？他们一家能否平安的度过这黑暗的年代呢？', '01-基础理论－认识素描（一）</br>02-基础理论－认识素描（二）</br>03-基础理论－认识素描（三）</br>04-基础理论－点线面</br>05-基础透视（一）</br>06-基础透视（二）</br>07-几何－平面几何（一）</br>08-几何－平面几何（二）</br>09-平面几何－圆的透视与变形（一）</br>10-平面几何－圆的透视与变形（二）</br>11-立体几何－平面几何体（一）</br>12-立体几何－平面几何体（二）</br>13-立体几何－平面几何体（三）</br>14-立体几何－曲面几何体（一）</br>15-立体几何－曲面几何体（二）</br>16-立体几何－曲面几何体（三）</br>17-明暗光影</br>', '2020-05-26 09:03:40', '2020-05-26 09:03:42');
INSERT INTO `t_goods` VALUES (6, '日系二次元动漫绘画课堂', 900, 300, '进阶', '你是否想动动手指轻轻勾勒，画出那些每每忆起都或心潮澎湃或心生欢喜的角色，</br></br>却又连模仿都嫌生涩呢？</br></br>不要惊慌~ 看看你想画的TA有没有收录在本课中，手把手教你画出最生动的TA！', '犹太青年圭多（罗伯托·贝尼尼）邂逅美丽的女教师多拉（尼可莱塔·布拉斯基），他彬彬有礼的向多拉鞠躬：“早安！公主！”。历经诸多令人啼笑皆非的周折后，天遂人愿，两人幸福美满的生活在一起。 然而好景不长，法西斯政权下，圭多和儿子被强行送往犹太人集中营。多拉虽没有犹太血统，毅然同行，与丈夫儿子分开关押在一个集中营里。聪明乐天的圭多哄骗儿子这只是一场游戏，奖品就是一辆大坦克，儿子快乐、天真的生活在纳粹的阴霾之中。尽管集中营的生活艰苦寂寞，圭多仍然带给他人很多快乐，他还趁机在纳粹的广播里问候妻子：“早安！公主！” 法西斯政权即将倾覆，纳粹的集中营很快就要接受最后的清理，圭多编给儿子的游戏该怎么结束？他们一家能否平安的度过这黑暗的年代呢？', '01-基础理论－认识素描（一）</br>02-基础理论－认识素描（二）</br>03-基础理论－认识素描（三）</br>04-基础理论－点线面</br>05-基础透视（一）</br>06-基础透视（二）</br>07-几何－平面几何（一）</br>08-几何－平面几何（二）</br>09-平面几何－圆的透视与变形（一）</br>10-平面几何－圆的透视与变形（二）</br>11-立体几何－平面几何体（一）</br>12-立体几何－平面几何体（二）</br>13-立体几何－平面几何体（三）</br>14-立体几何－曲面几何体（一）</br>15-立体几何－曲面几何体（二）</br>16-立体几何－曲面几何体（三）</br>17-明暗光影</br', '2020-05-26 12:10:06', '2020-05-26 12:10:08');

-- ----------------------------
-- Table structure for t_goods_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_cart`;
CREATE TABLE `t_goods_cart`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '购物车表ID',
  `goods_id` int(0) NOT NULL COMMENT '商品ID',
  `user_id` int(0) NOT NULL COMMENT '用户ID',
  `buy_count` int(0) NOT NULL DEFAULT 1 COMMENT '商品数量',
  `creationtime` datetime(0) NULL DEFAULT NULL COMMENT '购物车商品添加时间',
  `modifytime` datetime(0) NULL DEFAULT NULL COMMENT '商品修改时间购物车',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods_cart
-- ----------------------------
INSERT INTO `t_goods_cart` VALUES (3, 5, 3, 1, '2020-06-21 14:03:53', '2020-06-21 14:03:53');
INSERT INTO `t_goods_cart` VALUES (13, 6, 3, 1, '2020-06-26 14:09:30', '2020-06-26 14:09:30');
INSERT INTO `t_goods_cart` VALUES (16, 2, 2, 1, '2020-07-31 04:22:04', '2020-07-31 04:22:04');
INSERT INTO `t_goods_cart` VALUES (17, 6, 2, 1, '2020-07-31 11:39:56', '2020-07-31 11:39:56');

-- ----------------------------
-- Table structure for t_goods_id_type
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_id_type`;
CREATE TABLE `t_goods_id_type`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品与类型关联表',
  `goods_id` int(0) NOT NULL COMMENT '商品id',
  `goods_type_id` int(0) NOT NULL COMMENT '商品类型id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
-- Table structure for t_goods_images
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_images`;
CREATE TABLE `t_goods_images`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品图片id',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片url',
  `goods_id` int(0) NOT NULL COMMENT '商品id',
  `creationtime` datetime(0) NOT NULL COMMENT '商品图片添加时间',
  `modifytime` datetime(0) NOT NULL COMMENT '商品图片修改时间',
  `alt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods_images
-- ----------------------------
INSERT INTO `t_goods_images` VALUES (1, '\\images\\goodsImage\\1_1.jpg', 4, '2020-05-26 09:30:33', '2020-05-26 09:30:35', NULL);
INSERT INTO `t_goods_images` VALUES (2, '\\images\\goodsImage\\2_1.jpg', 6, '2020-05-26 09:31:22', '2020-05-26 09:31:24', NULL);
INSERT INTO `t_goods_images` VALUES (3, '\\images\\goodsImage\\3_1.jpg', 3, '2020-05-26 09:31:22', '2020-05-26 09:31:24', NULL);
INSERT INTO `t_goods_images` VALUES (4, '\\images\\goodsImage\\4_1.jpg', 2, '2020-05-26 09:31:22', '2020-05-26 09:31:24', NULL);
INSERT INTO `t_goods_images` VALUES (5, '\\images\\goodsImage\\6_1.jpg', 1, '2020-05-26 09:31:22', '2020-05-26 09:31:24', NULL);
INSERT INTO `t_goods_images` VALUES (6, '\\images\\goodsImage\\5_1.jpg', 5, '2020-05-26 09:31:22', '2020-05-26 09:31:24', NULL);

-- ----------------------------
-- Table structure for t_goods_type
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_type`;
CREATE TABLE `t_goods_type`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品类型id',
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品类型名称',
  `creationtime` datetime(0) NOT NULL COMMENT '商品类型创建时间',
  `modifytime` datetime(0) NOT NULL COMMENT '商品类型修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods_type
-- ----------------------------
INSERT INTO `t_goods_type` VALUES (101, '绘画', '2020-05-26 07:42:09', '2020-05-26 07:42:22');
INSERT INTO `t_goods_type` VALUES (102, '平面设计', '2020-05-26 07:42:50', '2020-05-26 07:42:55');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `order_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态',
  `total_amount` double(255, 2) NULL DEFAULT NULL COMMENT '总金额',
  `creationtime` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modifytime` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20200702220111379 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (20200731121026, 2, '已完成', 600.00, '2020-07-31 04:10:27', '2020-07-31 04:10:27');
INSERT INTO `t_order` VALUES (20200731122208, 2, '未付款', 600.00, '2020-07-31 04:22:08', '2020-07-31 04:22:08');

-- ----------------------------
-- Table structure for t_order_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_order_goods`;
CREATE TABLE `t_order_goods`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '订单商品表id',
  `order_id` bigint(0) NULL DEFAULT NULL COMMENT '订单id',
  `goods_id` int(0) NULL DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 98 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `t_order_goods` VALUES (96, 20200731122208, 2);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登录名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `creationtime` datetime(0) NOT NULL COMMENT '用户创建时间',
  `modifytime` datetime(0) NOT NULL COMMENT '用户修改时间',
  `mask` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户盐',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (2, 'jie', '3557779c073bd30575322b03c983a7eb', '2020-06-10 09:24:10', '2020-08-12 03:08:03', 'd064d418-3f42-4dce-b51e-02fe21275242');
INSERT INTO `t_user` VALUES (3, 'lisi', 'fbc91da9833e2d64499c1cfd87fd3f0a', '2020-06-10 09:30:15', '2020-06-10 09:30:15', '737f695e-13e9-4b78-986a-d3aea08c4c65');
INSERT INTO `t_user` VALUES (19, 'youmingjie', 'c18523debf9d99c08effec695c672f92', '2020-06-30 14:10:19', '2020-06-30 14:10:19', '6aea42f3-21ce-4d96-a9df-796c2af5d6f0');
INSERT INTO `t_user` VALUES (20, 'jiangjiang', 'd234dc7711a097be6ea1b7536aa578f1', '2020-07-04 10:56:03', '2020-07-04 10:56:03', '9479755e-494a-4449-bf0e-d96c479866bc');
INSERT INTO `t_user` VALUES (21, 'AAA', '55ca3e30c439d8966b6848ab32840f8e', '2020-07-28 08:20:57', '2020-07-28 08:20:57', '4581f2b0-c6f5-4217-8b36-d60647402a48');
INSERT INTO `t_user` VALUES (22, 'zhangsan', '3806fa1e2133a16a6bb397c74a7ffb6e', '2020-08-01 16:42:59', '2020-08-01 16:42:59', 'a984b650-f9d1-4343-8415-185604957731');

-- ----------------------------
-- Table structure for t_user_course
-- ----------------------------
DROP TABLE IF EXISTS `t_user_course`;
CREATE TABLE `t_user_course`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户课程id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `goods_id` int(0) NULL DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_course
-- ----------------------------
INSERT INTO `t_user_course` VALUES (14, 2, 4);
INSERT INTO `t_user_course` VALUES (15, 2, 1);
INSERT INTO `t_user_course` VALUES (16, 2, 5);

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户信息表ID',
  `user_id` int(0) NOT NULL COMMENT '用户id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `money` double NULL DEFAULT 100000000 COMMENT '用户余额',
  `imagePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  `sex` int(0) NULL DEFAULT NULL COMMENT '性别(1为男0为女)',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `individuality_signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `creationtime` datetime(0) NULL DEFAULT NULL COMMENT '用户信息创建时间',
  `modifytime` datetime(0) NULL DEFAULT NULL COMMENT '用户信息修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
INSERT INTO `t_user_info` VALUES (1, 2, '你来啦', 99994120, '\\images\\userImages\\tou1.jpg', '32165478@qq.com', '2020-08-02 00:00:00', 0, '1921685454', '你最棒', '2020-06-24 09:27:01', '2020-08-01 17:17:23');
INSERT INTO `t_user_info` VALUES (7, 22, 'stupiddog', 100000000, '\\images\\userImages\\moren.jpg', '', '2020-08-01 16:42:59', 1, '', '生活不止眼前的苟且', '2020-08-01 16:42:59', '2020-08-01 16:42:59');

SET FOREIGN_KEY_CHECKS = 1;
