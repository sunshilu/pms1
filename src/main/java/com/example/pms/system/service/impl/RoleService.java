package com.example.pms.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pms.system.mapper.BaseMapper;
import com.example.pms.system.mapper.RoleMapper;
import com.example.pms.system.model.RoleModel;

@Service
public class RoleService<T> extends BaseService<T> {

	@Autowired
	private RoleMapper<T> roleMapper;

	@Override
	public BaseMapper<T> getMapper() {
		return roleMapper;
	}

}
