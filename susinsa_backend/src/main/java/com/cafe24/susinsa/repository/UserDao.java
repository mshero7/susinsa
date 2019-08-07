package com.cafe24.susinsa.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.susinsa.dto.user.UserCheckDTO;
import com.cafe24.susinsa.dto.user.UserCheckIdDTO;
import com.cafe24.susinsa.dto.user.UserIdPwDTO;
import com.cafe24.susinsa.dto.user.UserLoginDTO;
import com.cafe24.susinsa.vo.UserVo;

@Repository
public class UserDao {
	public static final String ENC_KEY = "aa";
	public static final String NAMESPACE = "user";
	@Autowired
	private SqlSession sqlSession;
	
	public Boolean joinable(UserCheckDTO dto) {
		dto.setEnc_key(ENC_KEY);
		// 아이디가 존재하면 true
		int result = sqlSession.selectOne(NAMESPACE + ".existUserCheck", dto);
		return !(result > 0);
	}

	public Boolean existId(UserCheckIdDTO dto) {
		dto.setEnc_key(ENC_KEY);
		int result = sqlSession.selectOne(NAMESPACE + ".existId", dto);
		return !(result > 0);
	}

	public Boolean join(UserVo userVo) {
		userVo.setEnc_key(ENC_KEY);
		int result = sqlSession.insert(NAMESPACE + ".join", userVo);
		return result > 0;
	}

	public Boolean login(UserLoginDTO dto) {
		dto.setEnc_key(ENC_KEY);
		int result = sqlSession.selectOne(NAMESPACE + ".login", dto);
		return result > 0;
		
	}

	public UserIdPwDTO get(Map<String, String> params) {
		
		return null;
	}

}