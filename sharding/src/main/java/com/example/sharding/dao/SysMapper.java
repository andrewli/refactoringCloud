package com.example.sharding.dao;

import com.example.sharding.model.Sys;

public interface SysMapper {
	
	Long add(Sys sys);

	Sys findByUuid(Long uuid);

	Long total();
	
}
