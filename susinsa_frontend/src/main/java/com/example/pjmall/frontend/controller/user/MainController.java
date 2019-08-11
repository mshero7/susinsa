package com.example.pjmall.frontend.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.susinsa.dto.product.ProductImageDTO;
import com.example.pjmall.frontend.service.CategoryService;
import com.example.pjmall.frontend.service.ProductService;
import com.example.pjmall.frontend.vo.CategoryVo;

@Controller
public class MainController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping( {"/", "/main"} )
	public String main(Model model) {
		List<CategoryVo> category_list = categoryService.getList();
		List<ProductImageDTO> product_list = productService.getList();
		System.out.println(product_list);
		model.addAttribute("category_list", category_list);
		model.addAttribute("product_list", product_list);
		
		return "main/index";
	}
}
