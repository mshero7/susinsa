package com.cafe24.susinsa.dto.user;

import org.hibernate.validator.constraints.NotEmpty;

import com.cafe24.susinsa.validator.constraints.ValidID;

public class UserCheckIdDTO {
	@NotEmpty(message = "아이디는 필수 입니다.")
	@ValidID
	public String user_id;
	public String enc_key;
	
	public UserCheckIdDTO() {
		
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getEnc_key() {
		return enc_key;
	}

	public void setEnc_key(String enc_key) {
		this.enc_key = enc_key;
	}

	@Override
	public String toString() {
		return "UserCheckIdDTO [user_id=" + user_id + ", enc_key=" + enc_key + "]";
	}
	

}
