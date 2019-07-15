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
import com.example.pms.system.model.ProductModel;
import com.example.pms.system.service.impl.ProductService;
import com.example.pms.util.FmtEmpty;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService<ProductModel> productService;
	
	@ResponseBody
	@RequestMapping(value = "/search", produces = "application/json;charset=utf-8")
	public String search(ProductModel model) {
		String code=model.getCode();
		String name=model.getName();
		if(!FmtEmpty.isEmpty(code)){
			model.setCode("%"+code+"%");
		}
		if(!FmtEmpty.isEmpty(name)){
			model.setName("%"+name+"%");
		}
		List<ProductModel> list=productService.getList(model);
		String count=productService.getCount(model);
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
	public String add(ProductModel model){
		String code = model.getCode();
		if (FmtEmpty.isEmpty(productService.selectModel(code))) {
			if (FmtEmpty.isEmpty(productService.insert(model))) {
				return "2";
			}
			return "0";
		}
		return "1";
	}
	@ResponseBody
	@RequestMapping("/del")
	public String del(String code){
		if (!FmtEmpty.isEmpty(productService.selectModel(code))) {
			return productService.delModel(code) + "";
		}
		return "3";
	}
	@ResponseBody
	@RequestMapping(value="/initUpd",produces = "application/json;charset=utf-8")
	public String initUpd(String code){
		ProductModel model=productService.selectModel(code);
		return new JSONObject(model).toString();
	}
	@ResponseBody
	@RequestMapping(value="/upd")
	public String upd(ProductModel model){
		ProductModel um=productService.selectModel(model.getCode());
		if (!FmtEmpty.isEmpty(um)) {
			return productService.updModel(model) + "";
		}
		return "0";
	}

}
