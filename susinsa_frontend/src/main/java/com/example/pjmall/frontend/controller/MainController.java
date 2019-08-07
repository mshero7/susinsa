package com.example.pjmall.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pjmall.frontend.service.CategoryService;

@Controller
public class MainController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping( {"/", "/main"} )
	public String main(Model model) {
//		model.addAttribute("category_list", categoryService.getList());
		System.out.println(categoryService.getList());
		return "main/index";
	}
}
