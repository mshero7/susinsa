package com.cafe24.susinsa.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.susinsa.dto.product.ProductDTO;
import com.cafe24.susinsa.dto.product.ProductImageDTO;
import com.cafe24.susinsa.vo.ImageVo;
import com.cafe24.susinsa.vo.OptDetailVo;
import com.cafe24.susinsa.vo.OptFullDetailVo;
import com.cafe24.susinsa.vo.OptVo;
import com.cafe24.susinsa.vo.ProductVo;

@Repository
public class ProductDao {
	private static final String NAMESPACE = "product";
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<ProductVo> getList() {
		List<ProductVo> list = sqlSession.selectList(NAMESPACE + ".getList");
		
		return list;
	}


	public boolean delete(long product_no) {
		int result = sqlSession.delete(NAMESPACE + ".delete", product_no);
		return result > 0;
	}

	public ProductDTO getProduct(long product_no) {
		ProductDTO result = sqlSession.selectOne(NAMESPACE + ".getProduct", product_no);
		return result;
	}

	public List<ProductImageDTO> getProductList() {
		List<ProductImageDTO> result = sqlSession.selectList(NAMESPACE + ".getProductList");
		return result;
	}

	public List<ProductDTO> getProductByBrandNo(long brand_no) {
		List<ProductDTO> result = sqlSession.selectList(NAMESPACE + ".getProductListByBrandNo", brand_no);
		return result;
	}

	public boolean add(HashMap<String, Object> productMap) {
		int result = sqlSession.insert(NAMESPACE + ".add", productMap);
		return result > 0;
	}


	public boolean addProduct(ProductVo vo) {
		int result = sqlSession.insert(NAMESPACE + ".addProduct", vo);
		
		return result > 0;
	}


	public boolean addProductImage(long productNo, ArrayList<ImageVo> list_image) {
		HashMap <String, Object> map = new HashMap<String, Object>();
		map.put("productNo", productNo);
		map.put("list_image", list_image);
		int result = sqlSession.insert(NAMESPACE + ".addProductImage", map);
		
		return result > 0;
	}


	public boolean addProductOpt(ArrayList<OptVo> list_opt) {
		HashMap <String, Object> map = new HashMap<String, Object>();
		map.put("list_opt",list_opt);
		int result = sqlSession.insert(NAMESPACE + ".addProductOpt", map);
		
		return result > 0;
	}


	public boolean addProductOptDetail(ArrayList<OptDetailVo> list_opt_detail) {
		HashMap <String, Object> map = new HashMap<String, Object>();
		map.put("list_opt_detail",list_opt_detail);
		int result = sqlSession.insert(NAMESPACE + ".addProductOptDetail", map);
		
		return result > 0;
	}


	public boolean addProductOptFullDetail(ArrayList<OptFullDetailVo> list_opt_full_detail) {
		HashMap <String, Object> map = new HashMap<String, Object>();
		map.put("list_opt_full_detail",list_opt_full_detail);
		int result = sqlSession.insert(NAMESPACE + ".addProductOptFullDetail", map);
		
		return result > 0;
	}
}
