package com.example.pms.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pms.system.model.MenuModel;
import com.example.pms.system.model.RootModel;
import com.example.pms.system.model.UserModel;
import com.example.pms.system.service.impl.RootService;
import com.example.pms.system.service.impl.UserService;
import com.example.pms.util.FmtEmpty;

@Controller
@RequestMapping("/loginAndReg")
public class LogAndRegController {
	@Autowired
	private UserService<UserModel> userService;
	@Autowired
	private RootService<RootModel> rootService;

	@RequestMapping("/login")
	private String login(UserModel um,HttpSession session,Model model) {
		String msg;
		String view = null;
		System.out.println(um);
		UserModel um1 =userService.selectModel(um.getCode());
		if (!FmtEmpty.isEmpty(um1)) {
				if (um1.getPassword().trim().equals(um.getPassword().trim())) {
					session.setAttribute("userCode", um1);
					model.addAttribute("menu",getMenu(um1));
					view="/WEB-INF/jsp/main";
					msg="登录成功！";
				}else {
					view="/web/jsp/failed";
					msg="密码错误！";
				}
				
		}else {
			view="/web/jsp/failed";
			msg="账号不存在";
		}
		System.out.println("msg"+msg);
		model.addAttribute("msg",msg);
		return view;
	}
	public List<MenuModel> getMenu(UserModel um1) {
		String roleCode=um1.getRoleCode();
		if(FmtEmpty.isEmpty(roleCode)) {
			return null;
		}
		RootModel rm=new RootModel();
		rm.setRoleCode(roleCode);
		rm.setOrderBy("menu_code");
		List<RootModel> list=rootService.getList(rm);
		List<MenuModel> list2=new ArrayList<>();
		for(RootModel rm1:list) {
			if(rm1.getMenuModel().getParentCode().equals("00")) {
				list2.add(rm1.getMenuModel());
				continue;
			}
			for(MenuModel mm:list2) {
				if(rm1.getMenuModel().getParentCode().equals(mm.getCode())) {
					mm.getChild().add(rm1.getMenuModel());
				}
			}
		}
		System.out.println(list2);
		return list2;
	}
	
	@RequestMapping("/loginOut")
	private String loginOut(UserModel userCode,HttpSession session) {
		session.removeAttribute("userCode");
		return "/web/jsp/login";
	}
}
