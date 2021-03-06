package com.cafe24.susinsa.controller.api;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.susinsa.config.AppConfig;
import com.cafe24.susinsa.config.WebConfig;
import com.cafe24.susinsa.dto.user.UserLoginDTO;
import com.cafe24.susinsa.service.UserService;
import com.cafe24.susinsa.vo.UserVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class UserControllerTest {
	// SALT
	private static final String CORRECT_ENC_KEY = "aa";
	private static final String WRONG_ENC_KEY = "bb";
	
	/*
	 * 1. 이미 가입한 회원인지 조사
	 * 2. 이미 가입된 아이디인지 조사
	 * 
	 * */
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private UserService userService;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testDIUserService() {
		assertNotNull(userService);
	}
	
	// 1. 이미 가입한 이력이 있는 고객인지 조사
	// 이름과 주민번호로 이미 가입한 고객인지 조회한다.
	// 가입하지 않은 이름과 주민번호로 테스트해보고 true가 나온다면 가입이 가능한것이다.
	@Test
	public void testJoinable() throws Exception {
		ResultActions resultActions; 
		
		resultActions = mockMvc
				.perform(get("/api/user/join/check")
				.param("user_name", "문상수")
				.param("user_phone", "010-2526-7336")
				.param("user_enc_key", CORRECT_ENC_KEY)
				.contentType(MediaType.APPLICATION_JSON));
		
		// 무조건 OK가 나고 데이터베이스에 갔다와야 알수있는거아닐까
		resultActions.andExpect(status().isOk())
//		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(true)));
	}
	
//	 2. 이미 가입된 아이디인지 조사
//	 이미 다른 고객이 사용중인 아이디인지 조회한다.
//	 가입하지 않은 아이디로 테스트 해보고 false가 나온다면 사용이 가능한것이다.
	@Test
	public void testUserCheckId() throws Exception {
		ResultActions resultActions;
		
		resultActions = mockMvc
				.perform(get("/api/user/join/check/id")
				.param("user_id", "test@naver.com")
				.param("enc_key", CORRECT_ENC_KEY)
				.contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
//		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(false)));
	}
	
	// 3. 회원가입
	@Test
	public void testUserJoin() throws Exception {
		ResultActions resultActions;
		UserVo vo = new UserVo();
		
		// Normal User's Join Data
		resultActions = mockMvc
			.perform(post("/api/user/join")
				.param("user_id", "test@naver.com")
				.param("user_password", "Rmeofhek12!@")
				.param("user_name", "문상수")
				.param("user_gender", "M")
				.param("user_phone", "010-2526-7336")
				.param("user_date", "")
				.param("user_role", "ROLE_USER")
				.param("enc_key", CORRECT_ENC_KEY)
			.contentType(MediaType.APPLICATION_JSON));
			
		resultActions
			.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.result", is("success")))
			.andExpect(jsonPath("$.data", is(true)));;
		
			
//		// 2. 아이디를 이메일양식에 맞추지 않았을때
//		vo.setNo(2L);
//		vo.setId("test1234__naver.com");
//		vo.setPassword("dkfrhf12!@");
//		vo.setName("문상수");
//		vo.setGender("M");
//		vo.setPhone("010-2526-7336");
//		vo.setJoinDate(null);
//		vo.setenc_key(CORRECT_ENC_KEY);
//		
//		resultActions = mockMvc
//				.perform(post("/api/user/join")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(new Gson().toJson(vo)));
//				
//		resultActions.andExpect(status().isOk())
//			.andDo(print())
//			.andExpect(status().isBadRequest());
	}
	
	// 4. 로그인
	@Test
	public void testUserLogin() throws Exception {
		UserLoginDTO dto = new UserLoginDTO();
		
		dto.setUser_id("test@naver.com");
		dto.setUser_password("test12!@");
		
		ResultActions resultActions = 
				mockMvc
					.perform(get("/api/user/login")
					.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(dto)));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")));
	}
	
	// 5. 정보 가져오기
	@Test
	public void testUserGet() throws Exception {
		String user_id = "test@naver.com";
		
		ResultActions resultActions = 
				mockMvc
					.perform(get("/api/user/get")
					.param("user_id", user_id)
					.contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")));
	}

	// 6. 전체 회원정보 가져오기
	@Test
	public void testUserGetList() throws Exception {
		
		ResultActions resultActions = 
				mockMvc
					.perform(get("/api/user/getlist")
					.contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")));
	}
	// 5. 회원정보 수정
//	@Test
//	public void testUserUpdateInfo() throws Exception {
//		ResultActions resultActions = mockMvc
//				.perform(get("/api/user/check/Id").contentType(MediaType.APPLICATION_JSON));
//		
//		resultActions.andExpect(status().isOk())
//		.andDo(print())
//		.andExpect(jsonPath("$.result", is("success")))
//		.andExpect(jsonPath("$.data[0].email", is("test")));
//	}
//	
//	// 6. 회원탈퇴
//	@Test
//	public void testUserWithdrawal() throws Exception {
//		ResultActions resultActions = mockMvc
//				.perform(delete("/api/user/check/Id").contentType(MediaType.APPLICATION_JSON));
//		
//		resultActions.andExpect(status().isOk())
//		.andDo(print())
//		.andExpect(jsonPath("$.result", is("success")))
//		.andExpect(jsonPath("$.data[0].email", is("test")));
//	}
	
//	// 7. 로그아웃
//	// 구현 예정..
//	@Test
//	public void testUserLogout() throws Exception {
//		ResultActions resultActions = mockMvc
//				.perform(get("/api/user/withdrawal/{Id}").contentType(MediaType.APPLICATION_JSON));
//		
//		resultActions.andExpect(status().isOk())
//		.andDo(print())
//		.andExpect(jsonPath("$.result", is("success")))
//		.andExpect(jsonPath("$.data[0].email", is("test")));
//	}
}