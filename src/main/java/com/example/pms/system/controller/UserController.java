package com.example.pms.system.controller;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pms.system.model.UserModel;
import com.example.pms.system.service.impl.UserService;
import com.example.pms.util.FmtEmpty;
import com.example.pms.util.FormatPOI;
import com.example.pms.util.MD5;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService<UserModel> userService;
	
	@ResponseBody
	@RequestMapping(value = "/search", produces = "application/json;charset=utf-8")
	public String search(UserModel model) {
		String code=model.getCode();
		String name=model.getName();
		if(!FmtEmpty.isEmpty(code)){
			model.setCode("%"+code+"%");
		}
		if(!FmtEmpty.isEmpty(name)){
			model.setName("%"+name+"%");
		}
		System.out.println(model);
		List<UserModel> list=userService.getList(model);
		String count=userService.getCount(model);
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
	public String add(UserModel model){
		String code = model.getCode();
		String password=model.getPassword();
		String parentCode=model.getParentCode();
		model.setPassword(MD5.encode(password));
		if (FmtEmpty.isEmpty(userService.selectModel(code))) {
			if (FmtEmpty.isEmpty(userService.insert(model))) {
				return "2";
			}
			return "0";
		}
		return "1";
	}
	@ResponseBody
	@RequestMapping(value = "/searchParent", produces = "application/json;charset=utf-8")
	public String searchParent(UserModel model){
		Map<String,UserModel> map=getParent(model);
		return new JSONObject(map).toString();
	}
	@ResponseBody
	@RequestMapping("/del")
	public String del(String code){
		if (!FmtEmpty.isEmpty(userService.selectModel(code))) {
			return userService.delModel(code) + "";
		}
		return "3";
	}
	@ResponseBody
	@RequestMapping(value="/initUpd",produces = "application/json;charset=utf-8")
	public String initUpd(String code){
		UserModel model=userService.selectModel(code);
		UserModel um=new UserModel();
		um.setRoleCode(model.getRoleCode());
		Map<String,UserModel> map=getParent(um);
		Map<String,Object> m=new HashMap<>();
		m.put("model", model);
		m.put("parent", map);
		return new JSONObject(m).toString();
	}
	@ResponseBody
	@RequestMapping(value="/upd")
	public String upd(UserModel model){
		UserModel um=userService.selectModel(model.getCode());
		if (!FmtEmpty.isEmpty(um)) {
			String password=model.getPassword();
			if(!password.equals(um.getPassword())) {
				model.setPassword(MD5.encode(password));
			}
			return userService.updModel(model) + "";
		}
		return "0";
	}
	public Map<String, UserModel> getParent(UserModel model) {
		List<UserModel> list=userService.getList(model);
		Map<String,UserModel> map=new HashMap<>();
		for(UserModel um:list) {
			String parentCode=um.getParentCode();
			if(parentCode.equals("00")) {
				um.setParentName("无");
			}
			map.put(parentCode, um);
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value="/export")
	public void export(UserModel model,HttpServletResponse response) throws Exception {
		List<UserModel> dataList=userService.getList(model);
		List<String> propList=Arrays.asList("id","code","password","name","roleCode","parentCode");
		List<String> fieldName=Arrays.asList("id","账号","密码","姓名","角色编号","上级编号");
		
		Workbook wb=FormatPOI.exportExcel(dataList, propList, fieldName);
		
//		1.设置响应的头文件，回自动识别文件内容
		response.setContentType("multipart/form-data");
//		2.设置Content-Disposition
		response.setHeader("Content-Disposition", "attachment;filename=test.xls");
//		3.输出流
		OutputStream out=response.getOutputStream();
		wb.write(out);
		wb.close();
		out.close();
	}
}
