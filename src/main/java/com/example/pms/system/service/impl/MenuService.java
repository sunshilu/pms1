package com.example.pms.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pms.system.mapper.BaseMapper;
import com.example.pms.system.mapper.MenuMapper;
import com.example.pms.system.model.MenuModel;

@Service
public class MenuService<T> extends BaseService<T> {
	@Autowired
	public MenuMapper<T> menuMapper;

	@Override
	public BaseMapper getMapper() {
		return menuMapper;
	}

	public List<MenuModel> getList2(MenuModel model) {
		return menuMapper.selectAll2(model);
	}

}
