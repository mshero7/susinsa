package com.cafe24.susinsa.dto.user;

public class UserLoginDTO {
	private String client_id; 
	private String client_password;
	private String enc_key;
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getClient_password() {
		return client_password;
	}
	public void setClient_password(String client_password) {
		this.client_password = client_password;
	}
	public String getEnc_key() {
		return enc_key;
	}
	public void setEnc_key(String enc_key) {
		this.enc_key = enc_key;
	}
	@Override
	public String toString() {
		return "UserLoginDTO [client_id=" + client_id + ", client_password=" + client_password + ", enc_key=" + enc_key
				+ "]";
	}
	public UserLoginDTO(String client_id, String client_password, String enc_key) {
		super();
		this.client_id = client_id;
		this.client_password = client_password;
		this.enc_key = enc_key;
	}
	
	
	public UserLoginDTO	() {
		
	}
}
