package com.example.pjmall.frontend.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.susinsa.dto.cart.CartDTO;
import com.example.pjmall.frontend.service.CartService;
import com.example.pjmall.frontend.service.UserService;
import com.example.pjmall.frontend.vo.UserVo;

@Controller
@RequestMapping( "/admin/user"  )
public class AdminUserController {
	private static final String BASE_URL = "/admin/user/";
	
	@Autowired
	UserService userService;
	
	@Autowired
	CartService cartService;
	
	@GetMapping( "" )
	public String main(Model model) {
		List<UserVo> user_list = userService.getList();
		
		model.addAttribute("user_list", user_list);
		
		return BASE_URL+"index";
	}
	
	@GetMapping( "/cartlist" )
	public void cartlist(@RequestParam long user_no, Model model) {
		List<CartDTO> cart_list = cartService.getList(user_no);
		model.addAttribute("cart_list", cart_list);
	}

	@DeleteMapping( "/delete/{user_no}" )
	public String delete(@PathVariable long user_no) {
		userService.delete(user_no);
		return BASE_URL+"index";
	}
}