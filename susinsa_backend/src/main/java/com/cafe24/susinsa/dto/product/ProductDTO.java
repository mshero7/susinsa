package com.cafe24.susinsa.dto.product;

import java.util.ArrayList;
import java.util.Date;

import com.cafe24.susinsa.vo.ImageVo;
import com.cafe24.susinsa.vo.OptDetailVo;
import com.cafe24.susinsa.vo.OptFullDetailVo;
import com.cafe24.susinsa.vo.OptVo;
import com.cafe24.susinsa.vo.ProductVo;

public class ProductDTO {

	// PRODUCT
	private ProductVo productVo;

	public long product_no;
	public String product_name;
	public int product_price;
	public boolean product_sale;
	public Date product_date;
	public int product_weight;
	public long product_brand_no;
	public long product_category_no;

	// OPT
	private ArrayList<OptVo> list_opt;

	// OPT_DETAIL
	private ArrayList<OptDetailVo> list_opt_detail;

	// OPT_FULL_DETAIL
	private ArrayList<OptFullDetailVo> list_opt_full_detail;

	// IMAGE
	private ArrayList<ImageVo> list_image;

	public ProductVo getProductVo() {
		return productVo;
	}

	public void setProductVo(ProductVo productVo) {
		this.productVo = productVo;
	}

	public ArrayList<OptVo> getList_opt() {
		return list_opt;
	}

	public void setList_opt(ArrayList<OptVo> list_opt) {
		this.list_opt = list_opt;
	}

	public ArrayList<OptDetailVo> getList_opt_detail() {
		return list_opt_detail;
	}

	public void setList_opt_detail(ArrayList<OptDetailVo> list_opt_detail) {
		this.list_opt_detail = list_opt_detail;
	}

	public ArrayList<OptFullDetailVo> getList_opt_full_detail() {
		return list_opt_full_detail;
	}

	public void setList_opt_full_detail(ArrayList<OptFullDetailVo> list_opt_full_detail) {
		this.list_opt_full_detail = list_opt_full_detail;
	}

	public ArrayList<ImageVo> getList_image() {
		return list_image;
	}

	public void setList_image(ArrayList<ImageVo> list_image) {
		this.list_image = list_image;
	}

	@Override
	public String toString() {
		return "ProductDTO [productVo=" + productVo + ", list_opt=" + list_opt + ", list_opt_detail=" + list_opt_detail
				+ ", list_opt_full_detail=" + list_opt_full_detail + ", list_image=" + list_image + "]";
	}

	public ProductDTO(ProductVo productVo, ArrayList<OptVo> list_opt, ArrayList<OptDetailVo> list_opt_detail,
			ArrayList<OptFullDetailVo> list_opt_full_detail, ArrayList<ImageVo> list_image) {
		super();
		this.productVo = productVo;
		this.list_opt = list_opt;
		this.list_opt_detail = list_opt_detail;
		this.list_opt_full_detail = list_opt_full_detail;
		this.list_image = list_image;
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

	public int getProduct_weight() {
		return product_weight;
	}

	public void setProduct_weight(int product_weight) {
		this.product_weight = product_weight;
	}

	public long getProduct_brand_no() {
		return product_brand_no;
	}

	public void setProduct_brand_no(long product_brand_no) {
		this.product_brand_no = product_brand_no;
	}

	public long getProduct_category_no() {
		return product_category_no;
	}

	public void setProduct_category_no(long product_category_no) {
		this.product_category_no = product_category_no;
	}

	public ProductDTO() {

	}
}
