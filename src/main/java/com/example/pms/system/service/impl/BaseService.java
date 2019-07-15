package com.example.pms.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.pms.system.mapper.BaseMapper;
import com.example.pms.system.mapper.UserMapper;
import com.example.pms.system.model.UserModel;
import com.example.pms.system.service.IBaseService;
import com.example.pms.util.FmtEmpty;
import com.example.pms.util.MD5;

public abstract class BaseService<T> implements IBaseService<T> {

	
	public abstract BaseMapper<T> getMapper();

	@Override
	public List<T> getList(T model) {
		return getMapper().selectAll(model);
	}

	@Override
	public String getCount(T model) {
		return getMapper().selectCount(model) + "";
	}

	@Override
	public T selectModel(String code) {
		return getMapper().selectModel(code);
	}

	@Override
	public String insert(T model) {
		return getMapper().insert(model) + "";
	}

	@Override
	public String delModel(String code) {
		return getMapper().del(code) + "";
	}

	@Override
	public String updModel(T model) {
		return getMapper().upd(model) + "";
	}

}
