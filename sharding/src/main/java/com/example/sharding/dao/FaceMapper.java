package com.example.sharding.dao;

import com.example.sharding.model.Face;

public interface FaceMapper {

	Long add(Face face);

	Face findById(Long id);
	
}
