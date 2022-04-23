package com.example.sharding.dao;

import com.example.sharding.model.VehicleRecord;

public interface VehicleRecordMapper {
	
	void add(VehicleRecord vehicleRecord);

	VehicleRecord findByUuId(Long uuid);

	Long total();
	
}
