package com.example.pjmall.frontend.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cafe24.susinsa.dto.user.UserIdPwDTO;
import com.example.pjmall.frontend.service.UserService;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
		UserIdPwDTO userVo = userService.get(user_id);
		
		SecurityUser securityUser = new SecurityUser();
		
		if(userVo != null) {
			securityUser.setName(userVo.getUser_name());
			securityUser.setUsername(userVo.getUser_id());
			securityUser.setPassword(userVo.getUser_password());
			securityUser.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(userVo.getUser_role())));
		}	
		
		return securityUser;
	}	
}
