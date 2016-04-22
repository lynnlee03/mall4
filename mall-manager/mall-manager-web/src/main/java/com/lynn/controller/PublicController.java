package com.lynn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lynn.dao.meta.Product;
import com.lynn.service.ContentService;

//发布，发布提交
@Controller
public class PublicController {	
	@Autowired
	private ContentService contentService;
	//发布
	@RequestMapping("/public")
	public String public1(){
		return "public";
	}	
	//发布提交
	@RequestMapping("/publicSubmit")
	public String pubSubmit(Product product,Model map){
		try{
			map.addAttribute("product", contentService.insertProduct(product));
		}catch(Exception e){
			e.printStackTrace();
			map.addAttribute("code",400);
			map.addAttribute("message","erorr");
			map.addAttribute("result",false);
		}
		map.addAttribute("code",200);
		map.addAttribute("message","success");
		map.addAttribute("result",true);
		return "publicSubmit";
	}	
}
