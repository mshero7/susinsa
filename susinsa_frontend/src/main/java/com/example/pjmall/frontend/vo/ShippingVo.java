package com.example.pjmall.frontend.vo;

public class ShippingVo {
	public long shipping_no;
	public String shipping_zip1;
	public String shipping_zip2;
	public String shipping_zip3;
	public long shipping_user_no;
	public String enc_key;
	
	
	public String getEnc_key() {
		return enc_key;
	}

	public void setEnc_key(String enc_key) {
		this.enc_key = enc_key;
	}

	public ShippingVo() {
		
	}
	
	public long getShipping_no() {
		return shipping_no;
	}

	public void setShipping_no(long shipping_no) {
		this.shipping_no = shipping_no;
	}

	public String getShipping_zip1() {
		return shipping_zip1;
	}

	public void setShipping_zip1(String shipping_zip1) {
		this.shipping_zip1 = shipping_zip1;
	}

	public String getShipping_zip2() {
		return shipping_zip2;
	}

	public void setShipping_zip2(String shipping_zip2) {
		this.shipping_zip2 = shipping_zip2;
	}

	public String getShipping_zip3() {
		return shipping_zip3;
	}

	public void setShipping_zip3(String shipping_zip3) {
		this.shipping_zip3 = shipping_zip3;
	}

	public long getShipping_user_no() {
		return shipping_user_no;
	}

	public void setShipping_user_no(long shipping_user_no) {
		this.shipping_user_no = shipping_user_no;
	}

	public ShippingVo(long shipping_no, String shipping_zip1, String shipping_zip2, String shipping_zip3,
			long shipping_user_no, String enc_key) {
		super();
		this.shipping_no = shipping_no;
		this.shipping_zip1 = shipping_zip1;
		this.shipping_zip2 = shipping_zip2;
		this.shipping_zip3 = shipping_zip3;
		this.shipping_user_no = shipping_user_no;
		this.enc_key = enc_key;
	}

	@Override
	public String toString() {
		return "ShippingVo [shipping_no=" + shipping_no + ", shipping_zip1=" + shipping_zip1 + ", shipping_zip2="
				+ shipping_zip2 + ", shipping_zip3=" + shipping_zip3 + ", shipping_user_no=" + shipping_user_no
				+ ", enc_key=" + enc_key + "]";
	}


}
