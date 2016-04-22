package com.lynn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lynn.dao.meta.Product;
import com.lynn.service.ContentService;
//编辑，编辑提交
@Controller
public class EditController {
	@Autowired
	private ContentService contentService;
	//编辑
	@RequestMapping("/edit")
	public String edit(@RequestParam("id") Integer id,Model map){
		try{
			map.addAttribute("product", contentService.selectProduct(id));
		}catch(Exception e){
			e.printStackTrace();
		}
		return "edit";
	}
	
	//编辑提交
	@RequestMapping("/editSubmit")
	public String editSubmit(Product product,Model map){
		try{
			map.addAttribute("product",contentService.updateProduct(product));
		}catch(Exception e){
			e.printStackTrace();
			map.addAttribute("code",400);
			map.addAttribute("message","erorr");
			map.addAttribute("result",false);
		}
		map.addAttribute("code",200);
		map.addAttribute("message","success");
		map.addAttribute("result",true);
		return "editSubmit";
	}
}
