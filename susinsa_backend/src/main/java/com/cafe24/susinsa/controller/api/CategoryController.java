package com.cafe24.susinsa.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.susinsa.dto.JSONResult;
import com.cafe24.susinsa.service.CategoryService;
import com.cafe24.susinsa.vo.CategoryVo;
import com.cafe24.susinsa.vo.ShippingVo;

import io.swagger.annotations.ApiOperation;

@RestController("categoryAPIController")
@RequestMapping("/api/category")
public class CategoryController {
	
	/*
	 * 1. 정렬된 카테고리 리스트 가져오기
	 */
	@Autowired
	private CategoryService categoryService;
	
	// 1. 회원의 작성한 배송지를 추가한다.
	@ApiOperation(value="정렬된 카테고리 리스트 가져오기")	
	@RequestMapping(value="/getlist", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> getList() {
		List<CategoryVo> list = categoryService.getList();
		
       return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}

}