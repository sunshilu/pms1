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
import com.example.pms.system.model.RootModel;
import com.example.pms.system.service.impl.RootService;
import com.example.pms.util.FmtEmpty;

@Controller
@RequestMapping("/root")
public class RootController {
	@Autowired
	private RootService<RootModel> rootService;

	@ResponseBody
	@RequestMapping(value = "/search", produces = "application/json;charset=utf-8")
	public String search(RootModel model) {
		String roleCode=model.getRoleCode();
		String menuCode=model.getMenuCode();
		if(!FmtEmpty.isEmpty(roleCode)){
			model.setRoleCode("%"+roleCode+"%");
		}
		if(!FmtEmpty.isEmpty(menuCode)){
			model.setMenuCode("%"+menuCode+"%");
		}
		System.out.println(model);
		List<RootModel> list=rootService.getList(model);
		String count=rootService.getCount(model);
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
	public String add(RootModel model){
		if (FmtEmpty.isEmpty(rootService.selectModel(model))) {
			if (FmtEmpty.isEmpty(rootService.insert(model))) {
				return "2";
			}
			return "0";
		}
		return "1";
	}
	@ResponseBody
	@RequestMapping("/del")
	public String del(String code){
		if (!FmtEmpty.isEmpty(rootService.selectModel(code))) {
			return rootService.delModel(code) + "";
		}
		return "3";
	}
	@ResponseBody
	@RequestMapping(value="/initUpd",produces = "application/json;charset=utf-8")
	public String initUpd(String code){
		RootModel model=rootService.selectModel(code);
		return new JSONObject(model).toString();
	}
	@ResponseBody
	@RequestMapping(value="/upd")
	public String upd(RootModel model){
		RootModel um=rootService.selectModel(model);
		if (!FmtEmpty.isEmpty(um)) {
			return rootService.updModel(model) + "";
		}
		return "0";
	}

}
