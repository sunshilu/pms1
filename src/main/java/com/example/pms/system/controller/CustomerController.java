package com.example.pms.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pms.system.model.CustomerModel;
import com.example.pms.system.model.UserModel;
import com.example.pms.system.service.impl.CustomerService;
import com.example.pms.util.FmtEmpty;
import com.example.pms.util.MD5;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService<CustomerModel> customerService;
	
	@ResponseBody
	@RequestMapping(value = "/search", produces = "application/json;charset=utf-8")
	public String search(CustomerModel model) {
		String code=model.getCode();
		String name=model.getName();
		if(!FmtEmpty.isEmpty(code)){
			model.setCode("%"+code+"%");
		}
		if(!FmtEmpty.isEmpty(name)){
			model.setName("%"+name+"%");
		}
		List<CustomerModel> list=customerService.getList(model);
		String count=customerService.getCount(model);
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
	public String add(CustomerModel model){
		String code = model.getCode();
		if (FmtEmpty.isEmpty(customerService.selectModel(code))) {
			if (FmtEmpty.isEmpty(customerService.insert(model))) {
				return "2";
			}
			return "0";
		}
		return "1";
	}
	@ResponseBody
	@RequestMapping("/del")
	public String del(String code){
		if (!FmtEmpty.isEmpty(customerService.selectModel(code))) {
			return customerService.delModel(code) + "";
		}
		return "3";
	}
	@ResponseBody
	@RequestMapping(value="/initUpd",produces = "application/json;charset=utf-8")
	public String initUpd(String code){
		CustomerModel model=customerService.selectModel(code);
		return new JSONObject(model).toString();
	}
	@ResponseBody
	@RequestMapping(value="/upd")
	public String upd(CustomerModel model){
		CustomerModel um=customerService.selectModel(model.getCode());
		if (!FmtEmpty.isEmpty(um)) {
			return customerService.updModel(model) + "";
		}
		return "0";
	}

}
