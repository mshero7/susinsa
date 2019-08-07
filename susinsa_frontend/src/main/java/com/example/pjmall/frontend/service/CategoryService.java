package com.example.pjmall.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.pjmall.frontend.dto.JSONResult;
import com.example.pjmall.frontend.vo.CategoryVo;

@Service
public class CategoryService {
	private static final String BASE_URL = "http://localhost:8080/susinsa_backend/api/category";
	
	@Autowired
	private RestTemplate restTemplate;

	public List<CategoryVo> getList() {
		Category_List category_list = restTemplate.getForObject(BASE_URL + "/getlist", Category_List.class);
		
		return category_list.getData();
	}

	public static class Category_List extends JSONResult<List<CategoryVo>> {
		
	}
}
