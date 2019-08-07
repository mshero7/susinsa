package com.cafe24.susinsa.dto.user;

public class UserIdPwDTO {
	private String user_id;
	private String user_password;
	private String enc_key;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getEnc_key() {
		return enc_key;
	}
	public void setEnc_key(String enc_key) {
		this.enc_key = enc_key;
	}
	@Override
	public String toString() {
		return "UserIdPwDTO [user_id=" + user_id + ", user_password=" + user_password + ", enc_key=" + enc_key + "]";
	}
	public UserIdPwDTO(String user_id, String user_password, String enc_key) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.enc_key = enc_key;
	}
	
	
	public UserIdPwDTO() {
		
	}
	
}
