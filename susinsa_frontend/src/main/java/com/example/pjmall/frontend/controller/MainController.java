package com.example.pjmall.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.pjmall.frontend.dto.JSONResult;
import com.example.pjmall.frontend.vo.CategoryVo;

@Controller
public class MainController {
	private static final String BASE_URL = "http://localhost:8080/susinsa_backend/api";
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping( {"/", "/main"} )
	public String main(Model model) {
		JSONResult<List<CategoryVo>> category_list = restTemplate.getForObject(BASE_URL + "/category/getlist", JSONResult.class);
		System.out.println(category_list.getData());
		
		model.addAttribute("category_list", category_list.getData());
		
		return "main/index";
	}
}
