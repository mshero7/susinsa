package com.example.pjmall.frontend.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.susinsa.dto.product.ProductDTO;
import com.example.pjmall.frontend.service.CategoryService;
import com.example.pjmall.frontend.service.ProductService;
import com.example.pjmall.frontend.vo.CategoryVo;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping( {"/"} )
	public String main(Model model) {
		List<CategoryVo> category_list = categoryService.getList();
		model.addAttribute("category_list", category_list);
		return "product/index";
	}
	
	@RequestMapping( {"/get/{product_no}"} )
	public String details(@PathVariable long product_no, Model model) {
		List<CategoryVo> category_list = categoryService.getList();
		
		ProductDTO product = productService.getProductNo(product_no);
		System.out.println(product);
		model.addAttribute("category_list", category_list);
		model.addAttribute("product", product);
		
		return "product/detail";
	}
}
