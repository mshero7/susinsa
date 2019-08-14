package com.cafe24.susinsa.controller.api;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
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
import com.cafe24.susinsa.dto.product.ProductDTO;
import com.cafe24.susinsa.service.UserService;
import com.cafe24.susinsa.vo.ImageVo;
import com.cafe24.susinsa.vo.OptDetailVo;
import com.cafe24.susinsa.vo.OptFullDetailVo;
import com.cafe24.susinsa.vo.OptVo;
import com.cafe24.susinsa.vo.ProductVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class AdminUserControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private UserService service;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
//	@Rollback(true)
//	@After
//	public void clear() {}
	
	@Test
	public void testDIProductService() {
		assertNotNull(service);
	}
	
	/*
	 * 3. 상품삭제 테스트
	 * */
	@Test
	public void testDelete() throws Exception {
		ResultActions resultActions;
		
		long user_no = 2L;
		
		resultActions =
				mockMvc
				.perform(delete("/api/admin/user/delete/{user_no}", user_no)
						.contentType(MediaType.APPLICATION_JSON));
		
		resultActions
				.andExpect(status().isOk())
				.andDo(print());
	}
}