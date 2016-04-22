package com.lynn.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lynn.dao.meta.User;
import com.lynn.service.ContentService;
import com.lynn.service.PersonService;
import com.lynn.service.TrxService;

//异步接口
@Controller
@RequestMapping(value = "/api")
public class ApiController {
	@Autowired
	private PersonService personService;	
	@Autowired
	private ContentService contentService;	
	@Autowired
	private TrxService trxService;
	
	//登录
	@RequestMapping(value = "/login")
	public String userLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, Model map,
			HttpSession session) {
		if (personService.login(userName, password)) {
			session.setAttribute("user", personService.getUser(userName));
			map.addAttribute("code",200);
			map.addAttribute("message","success");
			map.addAttribute("result",true);
			return "json";
		} else {
			map.addAttribute("code",201);
			map.addAttribute("message", "username or password error,please try again.");
			map.addAttribute("result",false);
			return "json";
		}
	}
	
	//删除商品
	@RequestMapping(value = "/delete")
	public String productDelete(@RequestParam("id") Integer id, Model map) {
		contentService.deleteByPrimaryKey(id);
		map.addAttribute("code",200);
		map.addAttribute("message","success");
		map.addAttribute("result",true);
				return "json";
	}
	
	//购买
	@RequestMapping(value = "/buy")
	public String productBuy(@RequestParam("id") Integer id, Model map,HttpSession session) {
		trxService.buy(id, ((User)session.getAttribute("user")).getId());
		map.addAttribute("code",200);
		map.addAttribute("message","comlpeted");
		map.addAttribute("result",true);
				return "json";
	}

}
