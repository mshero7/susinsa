package com.example.pjmall.frontend.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.susinsa.dto.user.UserIdPwDTO;
import com.example.pjmall.frontend.dto.JSONResult;
import com.example.pjmall.frontend.service.CategoryService.Category_List;
import com.example.pjmall.frontend.vo.UserVo;

@Service
public class UserService {
	private static final String BASE_URL = "http://localhost:8080/susinsa_backend/api/user";
		
	
	@Autowired
	private RestTemplate restTemplate;

	public UserIdPwDTO get(String userId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("user_id", userId);
		
		UserIdPw userIdPw = 
				restTemplate.getForObject(BASE_URL + "/get?user_id={user_id}", UserIdPw.class, params);
		
		return userIdPw.getData();
	}
	
	public Boolean join(UserVo userVo) {
//		MappingJacksonValue value = new MappingJacksonValue(userVo);
		
		HttpEntity<UserVo> entity = new HttpEntity<>(userVo); 
		 
		ResponseEntity<UserJoin> response = restTemplate
				.exchange(BASE_URL + "/join", HttpMethod.POST, entity, UserJoin.class);
		
		return response.getBody().getData();
	}
	
	public static class UserJoin extends JSONResult<Boolean>{ }
	
	public static class UserIdPw extends JSONResult<UserIdPwDTO>{ }
	
	
}
