package com.lynn.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lynn.dao.meta.User;
import com.lynn.service.ContentService;
//商品信息展示
@Controller
public class ShowProductController {
	@Autowired
	private ContentService contentService;
	@RequestMapping("/show")
	public String showProductList(Integer id, Model map, HttpSession session) {
		try {
			//用户已登录，返回对应的商品
			if (session.getAttribute("user") != null) {
				map.addAttribute("product",
						contentService.getProduct(id, ((User)session.getAttribute("user")).getId()));
			} else {
				map.addAttribute("product", contentService.selectProduct(id));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return "show";
	}
}
