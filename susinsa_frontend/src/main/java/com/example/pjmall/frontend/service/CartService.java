package com.example.pjmall.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.susinsa.dto.cart.CartDTO;
import com.example.pjmall.frontend.dto.JSONResult;
import com.example.pjmall.frontend.vo.CategoryVo;

@Service
public class CartService {
	private static final String BASE_URL = "http://localhost:8080/susinsa_backend/api/cart";
	
	@Autowired
	private RestTemplate restTemplate;

	public List<CartDTO> getList(long user_no) {
		System.out.println("1========================================");
		Cart_List category_list = restTemplate.getForObject(BASE_URL + "/get/list", Cart_List.class, user_no);
		System.out.println("2========================================");
		System.out.println(category_list.getData());
		return category_list.getData();
	}

	public static class Cart_List extends JSONResult<List<CartDTO>> {
		
	}
}
