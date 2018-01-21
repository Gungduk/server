package com.hybrid.gungduk.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.LoginDto;

public class LoginDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public String loginCheck(LoginDto logDtoReq){ 
		//일치하는 회원이 있는지 확인하고 email 반환
		return sqlSession.selectOne("login.checkInfo", logDtoReq);
	}
}
