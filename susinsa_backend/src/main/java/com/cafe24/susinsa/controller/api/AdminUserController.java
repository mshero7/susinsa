package com.cafe24.susinsa.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.susinsa.dto.JSONResult;
import com.cafe24.susinsa.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController("AdminUserAPIController")
@RequestMapping("/api/admin/user")
public class AdminUserController {
	/*
	 * 1. 카테고리 추가하기.
	 */

	@Autowired
	private UserService service;

	// 1. 회원 정보 삭제하기.
	@ApiOperation(value = "추가시키고 싶은 상품을 입력합니다.")
	@RequestMapping(value = "/delete/{user_no}", method = RequestMethod.DELETE)
	public ResponseEntity<JSONResult> productAdd(@PathVariable long user_no) {
		boolean result = service.delete(user_no);

		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}

}