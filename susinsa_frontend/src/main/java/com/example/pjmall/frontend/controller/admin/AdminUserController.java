package com.example.pjmall.frontend.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pjmall.frontend.service.UserService;
import com.example.pjmall.frontend.vo.UserVo;

@Controller
@RequestMapping( "/admin/user"  )
public class AdminUserController {
	private static final String BASE_URL = "/admin/user/";
	
	@Autowired
	UserService service;
	
	@GetMapping( "" )
	public String main(Model model) {
		List<UserVo> user_list = service.getList();
		model.addAttribute("user_list", user_list);
		return BASE_URL+"index";
	}
	
}