package com.lynn.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//登录，退出
@Controller
public class LogController {
	//登录
	@RequestMapping("/login")
	public String logIn(){
		return "login";
	}
	//退出后跳转登录
	@RequestMapping("/logout")
	public String logOut(HttpSession session){
		session.invalidate();
		return "redirect:login";
	}
}