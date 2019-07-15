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
import com.example.pms.system.model.RootModel;
import com.example.pms.system.service.impl.CommunicationService;
import com.example.pms.util.FmtEmpty;

@Controller
@RequestMapping("/communication")
public class CommunicationController {
	@Autowired
	private CommunicationService<CommunicationModel> communicationService;

	@ResponseBody
	@RequestMapping(value = "/search", produces = "application/json;charset=utf-8")
	public String search(CommunicationModel model) {
		String userCode=model.getUserCode();
		String customerCode=model.getCustomerCode();
		if(!FmtEmpty.isEmpty(userCode)){
			model.setUserCode("%"+userCode+"%");
		}
		if(!FmtEmpty.isEmpty(customerCode)){
			model.setCustomerCode("%"+customerCode+"%");
		}
		List<CommunicationModel> list=communicationService.getList(model);
		String count=communicationService.getCount(model);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("data", list);
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		return new JSONObject(map).toString();

	}
	@ResponseBody
	@RequestMapping(value = "/add", produces = "application/json;charset=utf-8")
	public String add(CommunicationModel model){
		if (FmtEmpty.isEmpty(communicationService.selectModel(model))) {
			if (FmtEmpty.isEmpty(communicationService.insert(model))) {
				return "2";
			}
			return "0";
		}
		return "1";
	}
	@ResponseBody
	@RequestMapping("/del")
	public String del(String code){
		if (!FmtEmpty.isEmpty(communicationService.selectModel(code))) {
			return communicationService.delModel(code) + "";
		}
		return "3";
	}
	@ResponseBody
	@RequestMapping(value="/initUpd",produces = "application/json;charset=utf-8")
	public String initUpd(String code){
		CommunicationModel model=communicationService.selectModel(code);
		return new JSONObject(model).toString();
	}
	@ResponseBody
	@RequestMapping(value="/upd")
	public String upd(CommunicationModel model){
		String userCode=model.getUserCode();
		String customerCode=model.getCustomerCode();
		CommunicationModel um=new CommunicationModel();
		um.setUserCode(userCode);
		um.setCustomerCode(customerCode);
		if (!FmtEmpty.isEmpty(communicationService.selectModel(um))) {
			return communicationService.updModel(model) + "";
		}
		return "0";
	}

}
