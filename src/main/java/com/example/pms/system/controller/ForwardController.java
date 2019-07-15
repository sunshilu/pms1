package com.example.pms.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/unit")
public class ForwardController {
	
	@RequestMapping("/forward")
	public String forward(String url) {
		System.out.println(url);
		return url;
	}
}
