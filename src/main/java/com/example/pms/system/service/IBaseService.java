package com.example.pms.system.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.example.pms.system.model.MenuModel;
import com.example.pms.system.model.UserModel;

public interface IBaseService<T> {
	
	List<T> getList(T model);

	String getCount(T model);

	String insert(T model);

	String delModel(String code);

	String updModel(T model);

	T selectModel(String code);
}
