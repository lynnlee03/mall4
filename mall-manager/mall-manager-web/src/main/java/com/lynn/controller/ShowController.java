package com.lynn.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lynn.dao.meta.User;
import com.lynn.service.ContentService;
//首页
@Controller
public class ShowController {
	@Autowired
	private ContentService contentService;
	@RequestMapping("/")
	public String showIndex(Model map, HttpSession session) {
		//登录返回部分	
		try {
			if (session.getAttribute("user") != null) {
				map.addAttribute("productList",
						contentService.getProductList(((User)session.getAttribute("user")).getId()));
			} else {
				map.addAttribute("productList", contentService.getAllProductList());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}
