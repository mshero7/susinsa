package com.example.pjmall.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.pjmall.frontend.dto.JSONResult;
import com.example.pjmall.frontend.vo.ProductVo;

@Service
public class ProductService {
	private static final String BASE_URL = "http://localhost:8080/susinsa_backend/api/product";
		
	@Autowired
	private RestTemplate restTemplate;

	public List<ProductVo> getList() {
		Product_List product_list = restTemplate.getForObject(BASE_URL + "/getlist", Product_List.class);
		
		return product_list.getData();
	}
	public static class Product_List extends JSONResult<List<ProductVo>>{
		
	}
}
