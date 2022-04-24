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
