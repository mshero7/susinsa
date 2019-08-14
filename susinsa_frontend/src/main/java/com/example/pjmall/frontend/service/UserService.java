package com.example.pjmall.frontend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.susinsa.dto.user.UserIdPwDTO;
import com.example.pjmall.frontend.dto.JSONResult;
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
	
	public List<UserVo> getList() {
		System.out.println("====1=====================================");
		UserList userList = 
				restTemplate.getForObject(BASE_URL + "/getlist", UserList.class);
		System.out.println("====2=====================================");
		System.out.println(userList.getData());
		return userList.getData();
	}
	
	public Boolean join(UserVo userVo) {
		HttpEntity<UserVo> entity = new HttpEntity<>(userVo); 
		 
		ResponseEntity<UserJoin> response = restTemplate
				.exchange(BASE_URL + "/join", HttpMethod.POST, entity, UserJoin.class);
		
		return response.getBody().getData();
	}

	public void delete(long user_no) {
		HttpEntity<Long> entity = new HttpEntity<>(user_no); 
		restTemplate.exchange(BASE_URL + "/delete/{user_no}",
				HttpMethod.DELETE, entity, UserDelete.class);
	}
	
	public static class UserJoin extends JSONResult<Boolean>{ }
	
	public static class UserIdPw extends JSONResult<UserIdPwDTO>{ }
	
	public static class UserList extends JSONResult<List<UserVo>>{ }

	public static class UserDelete extends JSONResult<Boolean>{ }
}
