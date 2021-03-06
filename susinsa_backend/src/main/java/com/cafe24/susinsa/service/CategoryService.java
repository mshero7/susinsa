package com.cafe24.susinsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.susinsa.repository.CategoryDao;
import com.cafe24.susinsa.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao dao;
		
	public Boolean add(CategoryVo vo) {
		return dao.add(vo);
	}

	public Boolean update(CategoryVo vo) {
		return dao.update(vo);
	}

	public Boolean delete(CategoryVo vo) {
		return dao.delete(vo);
	}

	public List<CategoryVo> getList() {
		return dao.getList();
	}
}
