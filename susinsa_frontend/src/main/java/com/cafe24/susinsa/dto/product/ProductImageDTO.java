package com.cafe24.susinsa.dto.product;

import java.sql.Date;

public class ProductImageDTO {
	private long product_no;
	private String product_name;
	private int product_price;
	private boolean product_sale;
	private Date product_date;
	private String image_upload_name;


	public ProductImageDTO() {

	}


	@Override
	public String toString() {
		return "ProductImageDTO [product_no=" + product_no + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_sale=" + product_sale + ", product_date=" + product_date
				+ ", image_upload_name=" + image_upload_name + "]";
	}


	public long getProduct_no() {
		return product_no;
	}


	public void setProduct_no(long product_no) {
		this.product_no = product_no;
	}


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


	public boolean isProduct_sale() {
		return product_sale;
	}


	public void setProduct_sale(boolean product_sale) {
		this.product_sale = product_sale;
	}


	public Date getProduct_date() {
		return product_date;
	}


	public void setProduct_date(Date product_date) {
		this.product_date = product_date;
	}


	public String getImage_upload_name() {
		return image_upload_name;
	}


	public void setImage_upload_name(String image_upload_name) {
		this.image_upload_name = image_upload_name;
	}


	public ProductImageDTO(long product_no, String product_name, int product_price, boolean product_sale,
			Date product_date, String image_upload_name) {
		super();
		this.product_no = product_no;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_sale = product_sale;
		this.product_date = product_date;
		this.image_upload_name = image_upload_name;
	}
}
