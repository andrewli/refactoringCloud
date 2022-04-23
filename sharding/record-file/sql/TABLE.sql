CREATE DATABASE `smartzone` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

-- 业务大类：按照业务大类进行分表

-- 人脸照片
CREATE TABLE `face_0` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(64) NOT NULL COMMENT '关联主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `face_1` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(64) NOT NULL COMMENT '关联主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `face_2` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(64) NOT NULL COMMENT '关联主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 门禁通行记录
CREATE TABLE `access_record_0` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(64) NOT NULL COMMENT '关联主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `access_record_1` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(64) NOT NULL COMMENT '关联主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `access_record_2` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(64) NOT NULL COMMENT '关联主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 车辆通行记录
CREATE TABLE `vehicle_record_0` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(64) NOT NULL COMMENT '关联主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `vehicle_record_1` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(64) NOT NULL COMMENT '关联主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `vehicle_record_2` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(64) NOT NULL COMMENT '关联主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--  日志文件
CREATE TABLE `log_0` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(64) NOT NULL COMMENT '关联主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `log_1` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(64) NOT NULL COMMENT '关联主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `log_2` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(64) NOT NULL COMMENT '关联主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 系统资源存储：附件、视频、图标、压缩包等
CREATE TABLE `sys_0` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(64) NOT NULL COMMENT '关联主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_1` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(64) NOT NULL COMMENT '关联主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_2` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(64) NOT NULL COMMENT '关联主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;