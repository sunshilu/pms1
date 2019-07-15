package com.example.pms.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pms.system.model.BaseModel;
import com.example.pms.system.model.UserModel;
import com.example.pms.system.service.impl.BaseDataService;
import com.example.pms.util.FmtEmpty;
import com.example.pms.util.MD5;

@Controller
@RequestMapping("/baseData")
public class BaseController {
	@Autowired
	private BaseDataService<BaseModel> baseDataService;
	
	@ResponseBody
	@RequestMapping(value = "/search", produces = "application/json;charset=utf-8")
	public String search(BaseModel model) {
		String code=model.getCode();
		String name=model.getName();
		if(!FmtEmpty.isEmpty(code)){
			model.setCode("%"+code+"%");
		}
		if(!FmtEmpty.isEmpty(name)){
			model.setName("%"+name+"%");
		}
		System.out.println(model);
		List<BaseModel> list=baseDataService.getList(model);
		String count=baseDataService.getCount(model);
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
	public String add(BaseModel model){
		String code = model.getCode();
		if (FmtEmpty.isEmpty(baseDataService.selectModel(code))) {
			if (FmtEmpty.isEmpty(baseDataService.insert(model))) {
				return "2";
			}
			return "0";
		}
		return "1";
	}
	@ResponseBody
	@RequestMapping("/del")
	public String del(String code){
		if (!FmtEmpty.isEmpty(baseDataService.selectModel(code))) {
			return baseDataService.delModel(code) + "";
		}
		return "3";
	}
	@ResponseBody
	@RequestMapping(value="/initUpd",produces = "application/json;charset=utf-8")
	public String initUpd(String code){
		BaseModel model=baseDataService.selectModel(code);
		return new JSONObject(model).toString();
	}
	@ResponseBody
	@RequestMapping(value="/upd")
	public String upd(BaseModel model){
		System.out.println("baseModel----------"+model);
		BaseModel um=baseDataService.selectModel(model.getCode());
		if (!FmtEmpty.isEmpty(um)) {
			return baseDataService.updModel(model) + "";
		}
		return "0";
	}

}
