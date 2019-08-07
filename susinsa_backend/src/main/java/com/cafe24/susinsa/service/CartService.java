package com.cafe24.susinsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.susinsa.dto.cart.CartDTO;
import com.cafe24.susinsa.repository.CartDao;
import com.cafe24.susinsa.vo.CartVo;

@Service
public class CartService {
	@Autowired
	private CartDao dao;

	public Boolean add(long cart_count, long cart_user_no, long cart_opt_full_detail_no) {
		return dao.add(cart_count, cart_user_no, cart_opt_full_detail_no);
	}

	public Boolean delete(List<Long> cart_no_list) {
		return dao.delete(cart_no_list);
	}

	public Boolean modify(long cart_no, long cart_count) {
		return dao.modify(cart_no, cart_count);
	}

	public List<CartDTO> getlist(long cart_user_no) {
		return dao.getlist(cart_user_no);
	}

	public List<CartDTO> get_p_list(List<Long> cart_no_list) {
		return dao.get_p_list(cart_no_list);
	}

}