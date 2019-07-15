package com.example.pms.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pms.system.model.RoleModel;
import com.example.pms.system.model.UserModel;
import com.example.pms.system.service.impl.RoleService;
import com.example.pms.util.FmtEmpty;
import com.example.pms.util.MD5;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService<RoleModel> roleService;

	@ResponseBody
	@RequestMapping(value = "/search", produces = "application/json;charset=utf-8")
	public String search(RoleModel rm1) {
		String code=rm1.getCode();
		String name=rm1.getName();
		if(!FmtEmpty.isEmpty(code)){
			rm1.setCode("%"+code+"%");
		}
		if(!FmtEmpty.isEmpty(name)){
			rm1.setName("%"+name+"%");
		}
		System.out.println(rm1);
		List<RoleModel> list=roleService.getList(rm1);
		String count=roleService.getCount(rm1);
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
	public String add(RoleModel model){
		String code = model.getCode();
		if (FmtEmpty.isEmpty(roleService.selectModel(code))) {
			if (FmtEmpty.isEmpty(roleService.insert(model))) {
				return "2";
			}
			return "0";
		}
		return "1";
	}
	@ResponseBody
	@RequestMapping("/del")
	public String del(String code){
		if (!FmtEmpty.isEmpty(roleService.selectModel(code))) {
			return roleService.delModel(code) + "";
		}
		return "3";
	}
	@ResponseBody
	@RequestMapping(value="/initUpd",produces = "application/json;charset=utf-8")
	public String initUpd(String code){
		RoleModel model=roleService.selectModel(code);
		return new JSONObject(model).toString();
	}
	@ResponseBody
	@RequestMapping(value="/upd")
	public String upd(RoleModel model){
		RoleModel um=roleService.selectModel(model.getCode());
		if (!FmtEmpty.isEmpty(um)) {
			return roleService.updModel(model) + "";
		}
		return "0";
	}
}
