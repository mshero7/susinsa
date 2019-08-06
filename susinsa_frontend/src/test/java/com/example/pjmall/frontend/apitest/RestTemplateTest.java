package com.example.pjmall.frontend.apitest;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.example.pjmall.frontend.config.AppConfig;
import com.example.pjmall.frontend.config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class RestTemplateTest {
	private static final String BASE_API_URL = "http://localhost:8080/susinsa_backend/api";

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	@Test
	public void testDIUserService() {
		assertNotNull(restTemplate);
	}
	
	@Test
	public void test_getForObject() {
	    // parameter 세팅
	    MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	    map.add("str", "thisistest");
	 
	    // REST API 호출
	    String result = restTemplate.getForObject("http://localhost:8080/susinsa_backend/api/hello/",String.class);
	    System.out.println("------------------ TEST 결과 ------------------");
	    System.out.println(result);
	}
	@Test
	public void test_getProductList() {
	    // parameter 세팅
	    MultiValueMap<String, Integer> map = new LinkedMultiValueMap<String, Integer>();
	    map.add("product_no", 1);
	 
	    // REST API 호출
	    String result = restTemplate
	    		.getForObject("http://localhost:8080/susinsa_backend/api/product/get",String.class);
	    System.out.println("------------------ TEST 결과 ------------------");
	    System.out.println(result);
	}
	@Test
	public void test_getProduct() {
	    // parameter 세팅
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("product_no", 1);
	 
	    // REST API 호출
	    String result = restTemplate
	    		.getForObject("http://localhost:8080/susinsa_backend/api/product/get/product/{product_no}",String.class,params);
	    System.out.println("------------------ TEST 결과 ------------------");
	    System.out.println(result);
	}
}
