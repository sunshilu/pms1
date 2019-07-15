package com.example.pms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pms.system.mapper.BaseDataMapper;
import com.example.pms.system.mapper.BaseMapper;

@Service
public class BaseDataService<T> extends BaseService<T> {
	
	@Autowired
	public BaseDataMapper<T> baseDataMapper;

	@Override
	public BaseMapper getMapper() {
		return baseDataMapper;
	}

}
