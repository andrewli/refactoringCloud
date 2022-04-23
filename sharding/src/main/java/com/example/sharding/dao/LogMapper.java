package com.example.sharding.dao;

import com.example.sharding.model.Log;

public interface LogMapper {
	
	Long add(Log log);

	Log findByUuid(Long uuid);

	Long total();
	
}
