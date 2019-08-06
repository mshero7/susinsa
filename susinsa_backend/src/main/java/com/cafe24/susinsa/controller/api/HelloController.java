package com.cafe24.susinsa.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.susinsa.dto.JSONResult;
import com.cafe24.susinsa.dto.user.UserCheckDTO;
import com.cafe24.susinsa.dto.user.UserCheckIdDTO;
import com.cafe24.susinsa.dto.user.UserLoginDTO;
import com.cafe24.susinsa.service.UserService;
import com.cafe24.susinsa.vo.UserVo;

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