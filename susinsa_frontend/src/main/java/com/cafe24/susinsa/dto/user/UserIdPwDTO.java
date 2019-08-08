package com.cafe24.susinsa.dto.user;

public class UserIdPwDTO {
	private String user_id;
	private String user_password;
	private String user_name;
	private String user_role;
	
	public String getUser_name() {
		return user_name;
	}
	public void setUsre_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

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
	
	@Override
	public String toString() {
		return "UserIdPwDTO [user_id=" + user_id + ", user_password=" + user_password + ", user_role=" + user_role
				+ "]";
	}
	
	public UserIdPwDTO(String user_id, String user_password, String user_role) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_role = user_role;
	}
	
	public UserIdPwDTO() {
		
	}
	
}
