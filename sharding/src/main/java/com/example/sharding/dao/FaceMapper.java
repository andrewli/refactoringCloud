package com.example.sharding.dao;

import com.example.sharding.model.Face;

public interface FaceMapper {

	Long add(Face face);

	Face findByUuid(Long uuid);

	Long total();
	
}
