package com.cafe24.susinsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.susinsa.dto.user.UserCheckDTO;
import com.cafe24.susinsa.dto.user.UserCheckIdDTO;
import com.cafe24.susinsa.dto.user.UserIdPwDTO;
import com.cafe24.susinsa.dto.user.UserLoginDTO;
import com.cafe24.susinsa.repository.UserDao;
import com.cafe24.susinsa.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public Boolean joinable(UserCheckDTO dto) {
		return userDao.joinable(dto);
	}

	public Boolean existId(UserCheckIdDTO dto) {
		return userDao.existId(dto);
	}

	public Boolean join(UserVo userVo) {
		return userDao.join(userVo);
	}

	public Boolean login(UserLoginDTO dto) {
		return userDao.login(dto);
	}

	public UserIdPwDTO get(String user_id) {
		return userDao.get(user_id);
	}

	public List<UserVo> getlist() {
		return userDao.getlist();
	}

	public boolean delete(long user_no) {
		return userDao.delete(user_no);
	}
}