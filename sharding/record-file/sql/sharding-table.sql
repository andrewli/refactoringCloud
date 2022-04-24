CREATE DATABASE `smartzone` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

-- 业务大类：按照业务大类进行分表

-- 人脸照片
DELIMITER $$
create procedure sp_create_tab()
begin
set @str = " (
   `uuid` bigint(64) NOT NULL COMMENT '主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8; ";
set @j = 0;
while @j < 10 do
set @table = concat('face_',@j);
set @sql_t = concat("CREATE TABLE ",@table,@str);
prepare sql_t from @sql_t;
execute sql_t;
set @j = @j + 1;
end while;
end  $$

DELIMITER ;
call sp_create_tab();
DROP PROCEDURE IF EXISTS sp_create_tab;

-- 日志文件
DELIMITER $$
create procedure sp_create_tab()
begin
set @str = " (
   `uuid` bigint(64) NOT NULL COMMENT '主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8; ";
set @j = 0;
while @j < 10 do
set @table = concat('log_',@j);
set @sql_t = concat("CREATE TABLE ",@table,@str);
prepare sql_t from @sql_t;
execute sql_t;
set @j = @j + 1;
end while;
end  $$

DELIMITER ;
call sp_create_tab();
DROP PROCEDURE IF EXISTS sp_create_tab;

-- 系统资源：附件、视频、图标、压缩包等
DELIMITER $$
create procedure sp_create_tab()
begin
set @str = " (
   `uuid` bigint(64) NOT NULL COMMENT '主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8; ";
set @j = 0;
while @j < 5 do
set @table = concat('sys_',@j);
set @sql_t = concat("CREATE TABLE ",@table,@str);
prepare sql_t from @sql_t;
execute sql_t;
set @j = @j + 1;
end while;
end  $$

DELIMITER ;
call sp_create_tab();
DROP PROCEDURE IF EXISTS sp_create_tab;

-- 门禁通行记录
DELIMITER $$
create procedure sp_create_tab()
begin
set @str = " (
   `uuid` bigint(64) NOT NULL COMMENT '主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8; ";
set @j = 0;
while @j < 10 do
set @table = concat('access_record_',@j);
set @sql_t = concat("CREATE TABLE ",@table,@str);
prepare sql_t from @sql_t;
execute sql_t;
set @j = @j + 1;
end while;
end  $$

DELIMITER ;
call sp_create_tab();
DROP PROCEDURE IF EXISTS sp_create_tab;

-- 车辆通行记录
DELIMITER $$
create procedure sp_create_tab()
begin
set @str = " (
   `uuid` bigint(64) NOT NULL COMMENT '主键',
  `sys_url` varchar(255) DEFAULT NULL COMMENT '系统url',
  `original_url` varchar(255) NOT NULL COMMENT 'ossurl',
  `is_delete` int(1) DEFAULT '0' COMMENT '0:未删除 1：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8; ";
set @j = 0;
while @j < 10 do
set @table = concat('vehicle_record_',@j);
set @sql_t = concat("CREATE TABLE ",@table,@str);
prepare sql_t from @sql_t;
execute sql_t;
set @j = @j + 1;
end while;
end  $$

DELIMITER ;
call sp_create_tab();
DROP PROCEDURE IF EXISTS sp_create_tab;
