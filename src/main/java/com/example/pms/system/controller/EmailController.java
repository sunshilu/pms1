package com.example.pms.system.controller;

import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pms.util.FmtMail;

@Controller
@RequestMapping("email")
public class EmailController {
	
	@ResponseBody
	@RequestMapping("send")
	public String send(String subject,String content) throws MessagingException {
	        String[] to = { "1677565998@qq.com" };// 收件人
	        String from = "1677565998@qq.com";// 发件人
	        String pass = "qccfmbrpabtlecje";
	        //主机
	        String hostSend = "smtp.qq.com";
	        //端口
	        String portSend = "587";
	        FmtMail ms = new FmtMail(to, from, pass, hostSend, portSend);
	        ms.send(subject, content);
			return "0";
	}

}
