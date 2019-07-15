package com.example.pms.system.mapper;

import java.util.List;

import com.example.pms.system.model.UserModel;

public interface BaseMapper<T> {
	T selectModel(String code);

	List<T> selectAll(T um1);

	int selectCount(T um1);

	int insert(T model);

	int del(String code);

	int upd(T model);

	T selectModel2(T model);
}
