package com.example.pjmall.frontend.apitest;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {
	private static final String BASE_API_URL = "http://localhost:8080/susinsa_backend/api";
	
	@Test
	public void test_getForObject() {
		RestTemplate restTemplate = new RestTemplate();

		String result = restTemplate.getForObject(BASE_API_URL + "/user", String.class);
		System.out.println( result );
	}
}
