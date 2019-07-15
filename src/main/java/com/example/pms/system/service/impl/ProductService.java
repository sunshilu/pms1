package com.example.pms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pms.system.mapper.BaseMapper;
import com.example.pms.system.mapper.ProductMapper;

@Service
public class ProductService<T> extends BaseService<T> {
	@Autowired
	public ProductMapper<T> productMapper;

	@Override
	public BaseMapper<T> getMapper() {
		return productMapper;
	}

}
