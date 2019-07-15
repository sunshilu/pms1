package com.example.pms.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pms.system.model.CommunicationModel;
import com.example.pms.system.model.OrderModel;
import com.example.pms.system.service.impl.OrderService;
import com.example.pms.util.FmtEmpty;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService<OrderModel> orderService;

	@ResponseBody
	@RequestMapping(value = "/search", produces = "application/json;charset=utf-8")
	public String search(OrderModel model) {
		String userCode=model.getUserCode();
		String customerCode=model.getCustomerCode();
		if(!FmtEmpty.isEmpty(userCode)){
			model.setUserCode("%"+userCode+"%");
		}
		if(!FmtEmpty.isEmpty(customerCode)){
			model.setCustomerCode("%"+customerCode+"%");
		}
		List<OrderModel> list=orderService.getList(model);
		String count=orderService.getCount(model);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("data", list);
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		System.out.println("返回的数据"+list);
		return new JSONObject(map).toString();

	}
	@ResponseBody
	@RequestMapping(value = "/add", produces = "application/json;charset=utf-8")
	public String add(OrderModel model){
		if (FmtEmpty.isEmpty(orderService.selectModel(model))) {
			if (FmtEmpty.isEmpty(orderService.insert(model))) {
				return "2";
			}
			return "0";
		}
		return "1";
	}
	@ResponseBody
	@RequestMapping("/del")
	public String del(String code){
		if (!FmtEmpty.isEmpty(orderService.selectModel(code))) {
			return orderService.delModel(code) + "";
		}
		return "3";
	}
	@ResponseBody
	@RequestMapping(value="/initUpd",produces = "application/json;charset=utf-8")
	public String initUpd(String code){
		OrderModel model=orderService.selectModel(code);
		return new JSONObject(model).toString();
	}
	@ResponseBody
	@RequestMapping(value="/upd")
	public String upd(OrderModel model){
		if (!FmtEmpty.isEmpty(orderService.selectModel(model))) {
			return orderService.updModel(model) + "";
		}
		return "0";
	}

}
