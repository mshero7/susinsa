package com.example.pjmall.frontend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.susinsa.dto.product.ProductDTO;
import com.example.pjmall.frontend.dto.JSONResult;
import com.example.pjmall.frontend.vo.ProductVo;

@Service
public class ProductService {
	private static final String BASE_URL = "http://localhost:8080/susinsa_backend/api/product";
		
	@Autowired
	private RestTemplate restTemplate;

	public List<ProductVo> getList() {
		Product_List product_list = restTemplate.getForObject(BASE_URL + "/get", Product_List.class);
		System.out.println(product_list.getData());
		return product_list.getData();
		
		
	}
	
	public ProductDTO getProductNo(long product_no) {
		Map<String,Long> params = new HashMap<String,Long>();
		params.put("product_no", product_no);
		Product_ProductNo product = restTemplate.getForObject(BASE_URL + "/get/{product_no}", Product_ProductNo.class, params);
		return product.getData();
	}
	
	public static class Product_List extends JSONResult<List<ProductVo>>{
		
	}
	
	public static class Product_ProductNo extends JSONResult<ProductDTO>{
		
	}
}
