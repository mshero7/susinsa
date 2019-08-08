package com.example.pjmall.frontend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pjmall.frontend.service.UserService;
import com.example.pjmall.frontend.vo.UserVo;

@Controller
@RequestMapping( "/user"  )
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping( "/login" )
	public String login() {
		return "user/login";
	}
	
	@GetMapping( "/join" )
	public String join(@ModelAttribute @Valid UserVo userVo, BindingResult result) {
		return "user/join";
	}
	
	@PostMapping( "/join" )
	public String join(@ModelAttribute @Valid UserVo userVo,
			Model model, BindingResult result) {
		if( result.hasErrors() ) {
			model.addAllAttributes(result.getModel());
			return "/user/join";
		}
		userService.join(userVo);
		
		return "user/join";
	}
	
}
