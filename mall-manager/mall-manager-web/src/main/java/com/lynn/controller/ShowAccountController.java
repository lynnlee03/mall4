package com.lynn.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lynn.dao.meta.User;
import com.lynn.service.TrxService;
//财务
@Controller
public class ShowAccountController {
	@Autowired
	private TrxService trxService;
	@RequestMapping("/account")
	public String showAccount(Model map, HttpSession session) {
		map.addAttribute("buyList", 
				trxService.getBuyList(((User)session.getAttribute("user")).getId()));
		return "account";
	}
}
