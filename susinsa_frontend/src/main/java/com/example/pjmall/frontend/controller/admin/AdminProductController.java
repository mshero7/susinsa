package com.example.pjmall.frontend.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.susinsa.dto.product.ProductImageDTO;
import com.example.pjmall.frontend.service.CategoryService;
import com.example.pjmall.frontend.service.ProductService;
import com.example.pjmall.frontend.vo.CategoryVo;

@Controller
@RequestMapping( "/admin/product"  )
public class AdminProductController {
	private static final String BASE_URL = "/admin/product/";
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping( "" )
	public String main(Model model) {
		List<ProductImageDTO> product_list = productService.getList();
		model.addAttribute("product_list",product_list);
		System.out.println(product_list);
		
		return BASE_URL+"index";
	}
	
	@GetMapping( "/add" )
	public String add(Model model) {
		List<CategoryVo> category_list = categoryService.getList();
		model.addAttribute("category_list", category_list);
		
		return BASE_URL+"add";
	}
}