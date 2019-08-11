package com.example.pjmall.frontend.vo;

import java.sql.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.cafe24.susinsa.validator.constraints.ValidGender;
import com.cafe24.susinsa.validator.constraints.ValidID;
import com.cafe24.susinsa.validator.constraints.ValidPassword;

/**
 * @author user
 *
 */
public class UserVo {
	private Long user_no;
	@NotEmpty(message = "아이디는 필수 입니다.")
	@ValidID
	private String user_id;

	@NotEmpty(message = "패스워드는 필수입니다.")
	@ValidPassword
	private String user_password;

	@NotEmpty(message = "이름을 입력하세요.")
	@Length(min=2, max=8)
	private String user_name;

	@ValidGender
	private String user_gender;
	
	@NotEmpty(message = "핸드폰번호를 입력하세요.")
	private String user_phone;
	
	private Date user_date;

	private String user_role = "ROLE_USER";
	
	private String enc_key;

	public UserVo(Long user_no, String user_id, String user_password, String user_name, String user_gender,
			String user_phone, Date user_date, String user_role, String enc_key) {
		super();
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_gender = user_gender;
		this.user_phone = user_phone;
		this.user_date = user_date;
		this.user_role = user_role;
		this.enc_key = enc_key;
	}

	public Long getUser_no() {
		return user_no;
	}

	public void setUser_no(Long user_no) {
		this.user_no = user_no;
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public Date getUser_date() {
		return user_date;
	}

	public void setUser_date(Date user_date) {
		this.user_date = user_date;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public String getEnc_key() {
		return enc_key;
	}

	public void setEnc_key(String enc_key) {
		this.enc_key = enc_key;
	}

	@Override
	public String toString() {
		return "UserVo [user_no=" + user_no + ", user_id=" + user_id + ", user_password=" + user_password
				+ ", user_name=" + user_name + ", user_gender=" + user_gender + ", user_phone=" + user_phone
				+ ", user_date=" + user_date + ", user_role=" + user_role + ", enc_key=" + enc_key + "]";
	}
	

	public UserVo() {
		
	}
}
