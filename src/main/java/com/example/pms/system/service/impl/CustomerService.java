package com.example.pms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pms.system.mapper.BaseMapper;
import com.example.pms.system.mapper.CustomerMapper;

@Service
public class CustomerService<T> extends BaseService<T> {
	@Autowired
	public CustomerMapper<T> customerMapper;

	@Override
	public BaseMapper<T> getMapper() {
		return customerMapper;
	}

}
