package com.example.pms.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pms.system.mapper.BaseMapper;
import com.example.pms.system.mapper.RootMapper;
import com.example.pms.system.mapper.UserMapper;
import com.example.pms.system.model.MenuModel;
import com.example.pms.system.model.RootModel;
import com.example.pms.system.model.UserModel;
import com.example.pms.util.FmtEmpty;
import com.example.pms.util.MD5;

@Service
public class UserService<T> extends BaseService<T> {
	@Autowired
	public UserMapper<T> userMapper;
	@Override
	public BaseMapper<T> getMapper() {
		return userMapper;
	}
}
