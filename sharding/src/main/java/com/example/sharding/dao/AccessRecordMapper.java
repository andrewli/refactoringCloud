package com.example.sharding.dao;

import com.example.sharding.model.AccessRecord;

public interface AccessRecordMapper {

	Long add(AccessRecord accessRecord);

	AccessRecord  findByUuid(Long uuid);

	Long total();
	
}
