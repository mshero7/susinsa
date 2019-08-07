package com.cafe24.susinsa.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.susinsa.dto.JSONResult;

import io.swagger.annotations.ApiOperation;

@RestController("helloAPIController")
@RequestMapping("/api/hello")
public class HelloController {
	
	// 1. 이미 가입한 고객인지 조사
	@ApiOperation(value="이름과 주민번호로 이미 가입한 고객인지 조회한다.")	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> checkJoinable() {
       return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("hi"));
	}
	
	// 1. 이미 가입한 고객인지 조사
	@ApiOperation(value="이름과 주민번호로 이미 가입한 고객인지 조회한다.")	
	@RequestMapping(value="/ex2", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> B() {
       return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("hi"));
	}
}