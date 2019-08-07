package com.cafe24.susinsa.dto.user;

public class UserGetDTO {
	public String user_id;
	public String enc_key;
	
	public UserGetDTO() {
		
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
		return "UserGetDTO [user_id=" + user_id + ", enc_key=" + enc_key + "]";
	}

	public UserGetDTO(String user_id, String enc_key) {
		super();
		this.user_id = user_id;
		this.enc_key = enc_key;
	}

}
