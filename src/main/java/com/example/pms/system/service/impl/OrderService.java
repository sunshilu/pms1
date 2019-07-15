package com.example.pms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pms.system.mapper.BaseMapper;
import com.example.pms.system.mapper.OrderMapper;
import com.example.pms.system.model.OrderModel;

@Service
public class OrderService<T> extends BaseService<T> {
	@Autowired
	public OrderMapper<T> orderMapper;

	@Override
	public BaseMapper<T> getMapper() {
		return orderMapper;
	}

	public T selectModel(T model) {
		return orderMapper.selectModel2(model);
	}

}
