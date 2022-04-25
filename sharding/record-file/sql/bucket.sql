-- oss bucket 详情
DROP TABLE IF EXISTS `oss_bucket`;
CREATE TABLE `oss_bucket` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_name` varchar(255) DEFAULT NULL COMMENT 'oss账号名称',
  `store_type` int(1) DEFAULT NULL COMMENT '业务存储类别\r\n0：人脸照片\r\n1：门禁通行记录\r\n2：车辆通行记录\r\n3：日志\r\n4：系统资源',
  `bucket_name` varchar(255) DEFAULT NULL,
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='oss bucket 详情';

-- ----------------------------
-- Records of oss_bucket
-- ----------------------------
INSERT INTO `oss_bucket` VALUES (1005207031541761, 'smartzonedev', 0, 'hxqdev001', 0, '2022-04-23 21:49:55', '2022-04-23 21:49:55');
INSERT INTO `oss_bucket` VALUES (1005207031541762, 'smartzonedev', 0, 'hxqdev002', 0, '2022-04-23 21:50:11', '2022-04-23 21:50:11');
INSERT INTO `oss_bucket` VALUES (1005207031541763, 'smartzonedev', 0, 'hxqdev003', 0, '2022-04-23 21:50:13', '2022-04-23 21:50:13');
INSERT INTO `oss_bucket` VALUES (1005207031541764, 'smartzonedev', 0, 'hxqdev004', 0, '2022-04-23 21:50:15', '2022-04-23 21:50:15');
INSERT INTO `oss_bucket` VALUES (1005207031541765, 'smartzonedev', 0, 'hxqdev005', 0, '2022-04-23 21:50:17', '2022-04-23 21:50:17');
INSERT INTO `oss_bucket` VALUES (1005207031541766, 'smartzonedev', 1, 'hxqdev101', 0, '2022-04-25 17:35:29', '2022-04-25 17:35:29');
INSERT INTO `oss_bucket` VALUES (1005207031541767, 'smartzonedev', 1, 'hxqdev102', 0, '2022-04-25 17:35:30', '2022-04-25 17:35:30');
INSERT INTO `oss_bucket` VALUES (1005207031541768, 'smartzonedev', 1, 'hxqdev103', 0, '2022-04-25 17:35:31', '2022-04-25 17:35:31');
INSERT INTO `oss_bucket` VALUES (1005207031541769, 'smartzonedev', 1, 'hxqdev104', 0, '2022-04-25 17:35:32', '2022-04-25 17:35:32');
INSERT INTO `oss_bucket` VALUES (1005207031541770, 'smartzonedev', 1, 'hxqdev105', 0, '2022-04-25 17:35:32', '2022-04-25 17:35:32');
INSERT INTO `oss_bucket` VALUES (1005207031541771, 'smartzonedev', 2, 'hxqdev201', 0, '2022-04-25 19:08:16', '2022-04-25 19:08:16');
INSERT INTO `oss_bucket` VALUES (1005207031541772, 'smartzonedev', 2, 'hxqdev202', 0, '2022-04-25 19:08:16', '2022-04-25 19:08:16');
INSERT INTO `oss_bucket` VALUES (1005207031541773, 'smartzonedev', 2, 'hxqdev203', 0, '2022-04-25 19:08:18', '2022-04-25 19:08:18');
INSERT INTO `oss_bucket` VALUES (1005207031541774, 'smartzonedev', 2, 'hxqdev204', 0, '2022-04-25 19:08:19', '2022-04-25 19:08:19');
INSERT INTO `oss_bucket` VALUES (1005207031541775, 'smartzonedev', 2, 'hxqdev205', 0, '2022-04-25 19:08:53', '2022-04-25 19:08:53');
INSERT INTO `oss_bucket` VALUES (1005207031541776, 'smartzonedev', 3, 'hxqdev301', 0, '2022-04-25 19:09:10', '2022-04-25 19:09:10');
INSERT INTO `oss_bucket` VALUES (1005207031541777, 'smartzonedev', 3, 'hxqdev302', 0, '2022-04-25 19:09:11', '2022-04-25 19:09:11');
INSERT INTO `oss_bucket` VALUES (1005207031541778, 'smartzonedev', 3, 'hxqdev303', 0, '2022-04-25 19:09:12', '2022-04-25 19:09:12');
INSERT INTO `oss_bucket` VALUES (1005207031541779, 'smartzonedev', 3, 'hxqdev304', 0, '2022-04-25 19:09:14', '2022-04-25 19:09:14');
INSERT INTO `oss_bucket` VALUES (1005207031541780, 'smartzonedev', 3, 'hxqdev305', 0, '2022-04-25 19:09:15', '2022-04-25 19:09:15');
INSERT INTO `oss_bucket` VALUES (1005207031541781, 'smartzonedev', 4, 'hxqdev401', 0, '2022-04-25 19:09:34', '2022-04-25 19:09:34');
INSERT INTO `oss_bucket` VALUES (1005207031541782, 'smartzonedev', 4, 'hxqdev402', 0, '2022-04-25 19:09:35', '2022-04-25 19:09:35');
INSERT INTO `oss_bucket` VALUES (1005207031541783, 'smartzonedev', 4, 'hxqdev403', 0, '2022-04-25 19:09:36', '2022-04-25 19:09:36');