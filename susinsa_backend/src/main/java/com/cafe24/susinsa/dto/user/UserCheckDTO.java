package com.cafe24.susinsa.dto.user;

import org.hibernate.validator.constraints.NotEmpty;

public class UserCheckDTO {
	@NotEmpty(message = "이름을 입력하세요.")
	public String user_name;
	@NotEmpty(message = "핸드폰번호를 입력하세요.")
	public String user_phone;
	public String enc_key;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getEnc_key() {
		return enc_key;
	}
	public void setEnc_key(String enc_key) {
		this.enc_key = enc_key;
	}
	@Override
	public String toString() {
		return "UserCheckDTO [user_name=" + user_name + ", user_phone=" + user_phone + ", enc_key=" + enc_key + "]";
	}
	public UserCheckDTO() {
		
	}
}
