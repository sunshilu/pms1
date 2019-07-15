package com.example.pms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pms.system.mapper.BaseMapper;
import com.example.pms.system.mapper.RootMapper;
import com.example.pms.system.model.RootModel;

@Service
public class RootService<T> extends BaseService<T> {
	
	@Autowired
	public RootMapper<T> rootMapper;

	@Override
	public BaseMapper<T> getMapper() {
		return rootMapper;
	}
	public T selectModel(T model) {
		return getMapper().selectModel2(model);
	}

}
