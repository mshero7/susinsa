package com.cafe24.susinsa.dto.product;

public class ProductImageDTO {
	private String product_name;
	private int product_price;
	private String image_upload_name;

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getImage_upload_name() {
		return image_upload_name;
	}

	public void setImage_upload_name(String image_upload_name) {
		this.image_upload_name = image_upload_name;
	}

	public ProductImageDTO() {

	}
}
