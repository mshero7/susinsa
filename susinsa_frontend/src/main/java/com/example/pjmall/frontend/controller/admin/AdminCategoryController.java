package com.example.pjmall.frontend.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/admin/category"  )
public class AdminCategoryController {
	private static final String BASE_URL = "/admin/category/";
	
	@GetMapping( "" )
	public String main() {
		return BASE_URL+"index";
	}
	
}