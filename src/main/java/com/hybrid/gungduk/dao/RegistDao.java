package com.hybrid.gungduk.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.UserDto;

public class RegistDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int registerCheck(String email){ //중복되는 아이디 있는지 체크
	
		String rs = sqlSession.selectOne("register.registCheck", email);
		
		if(rs != null) return 0; //이미 존재하는 회원
		else return 1; //가입 가능한 회원 아이디
	}
	
	public int register(UserDto regDtoReq){
		return sqlSession.insert("register.regist", regDtoReq);
	}
}
