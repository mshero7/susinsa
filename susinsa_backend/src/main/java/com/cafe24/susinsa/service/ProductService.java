package com.cafe24.susinsa.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.susinsa.dto.product.ProductDTO;
import com.cafe24.susinsa.dto.product.ProductImageDTO;
import com.cafe24.susinsa.repository.ProductDao;
import com.cafe24.susinsa.vo.ProductVo;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;

	public List<ProductVo> getList() {
		return dao.getList();
	}

	public boolean add(ProductDTO dto) {
		ProductVo vo = dto.getProductVo();
		
		boolean result1 = dao.addProduct(vo);
		boolean result2 = dao.addProductImage(vo.getProduct_no(), dto.getList_image());
		boolean result3 = dao.addProductOpt(dto.getList_opt());
		boolean result4 = dao.addProductOptDetail(dto.getList_opt_detail());
		boolean result5 = dao.addProductOptFullDetail(dto.getList_opt_full_detail());
		
		return result1 && result2 && result3 && result4 && result5;
	}

	public boolean delete(long product_no) {
		return dao.delete(product_no);
	}

	public ProductDTO getProduct(long product_no) {
		return dao.getProduct(product_no);
	}

	public List<ProductImageDTO> getProductList() {
		return dao.getProductList();
	}

	public List<ProductDTO> getProductByBrandNo(long brand_no) {
		return dao.getProductByBrandNo(brand_no);
	}
}
