package com.example.pms.system.mapper;

import java.util.List;

import com.example.pms.system.model.MenuModel;

public interface MenuMapper<T> extends BaseMapper<T> {

	List<MenuModel> selectAll2(MenuModel model);

}
