package com.example.pms.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pms.system.model.MenuModel;
import com.example.pms.system.model.RoleModel;
import com.example.pms.system.service.impl.MenuService;
import com.example.pms.util.FmtEmpty;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService<MenuModel> menuService;

	@ResponseBody
	@RequestMapping(value = "/search", produces = "application/json;charset=utf-8")
	public String search(MenuModel model) {
		String code=model.getCode();
		String name=model.getName();
		if(!FmtEmpty.isEmpty(code)){
			model.setCode("%"+code+"%");
		}
		if(!FmtEmpty.isEmpty(name)){
			model.setName("%"+name+"%");
		}
		System.out.println(model);
		List<MenuModel> list=menuService.getList(model);
		String count=menuService.getCount(model);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("data", list);
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		System.out.println(map);
		return new JSONObject(map).toString();

	}
	@ResponseBody
	@RequestMapping(value = "/search2", produces = "application/json;charset=utf-8")
	public String search2(MenuModel model) {
		String code=model.getCode();
		String name=model.getName();
		if(!FmtEmpty.isEmpty(code)){
			model.setCode("%"+code+"%");
		}
		if(!FmtEmpty.isEmpty(name)){
			model.setName("%"+name+"%");
		}
		System.out.println(model);
		List<MenuModel> list=menuService.getList2(model);
		String count=menuService.getCount(model);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("data", list);
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		System.out.println(map);
		return new JSONObject(map).toString();

	}
	@ResponseBody
	@RequestMapping(value = "/add", produces = "application/json;charset=utf-8")
	public String add(MenuModel model){
		String code = model.getCode();
		if (FmtEmpty.isEmpty(menuService.selectModel(code))) {
			if (FmtEmpty.isEmpty(menuService.insert(model))) {
				return "2";
			}
			return "0";
		}
		return "1";
	}
	@ResponseBody
	@RequestMapping("/del")
	public String del(String code){
		if (!FmtEmpty.isEmpty(menuService.selectModel(code))) {
			return menuService.delModel(code) + "";
		}
		return "3";
	}
	@ResponseBody
	@RequestMapping(value="/initUpd",produces = "application/json;charset=utf-8")
	public String initUpd(String code){
		MenuModel model=menuService.selectModel(code);
		return new JSONObject(model).toString();
	}
	@ResponseBody
	@RequestMapping(value="/upd")
	public String upd(MenuModel model){
		MenuModel um=menuService.selectModel(model.getCode());
		if (!FmtEmpty.isEmpty(um)) {
			return menuService.updModel(model) + "";
		}
		return "0";
	}

}
