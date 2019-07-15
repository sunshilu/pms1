package com.example.pms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pms.system.mapper.BaseMapper;
import com.example.pms.system.mapper.CommunicationMapper;
import com.example.pms.system.model.CommunicationModel;
@Service
public class CommunicationService<T> extends BaseService<T>{
	@Autowired
	public CommunicationMapper<T> communicationMapper;
	

	@Override
	public BaseMapper<T> getMapper() {
		return communicationMapper;
	}


	public T selectModel(T model) {
		return communicationMapper.selectModel2(model);
	}
	

}
