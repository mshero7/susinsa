package com.cafe24.susinsa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping( {"/user"} )
	public String main() {
		return "main/index";
	}
}
