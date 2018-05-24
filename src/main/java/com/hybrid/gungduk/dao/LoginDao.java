package com.hybrid.gungduk.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.LoginDto;

public class LoginDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public String loginCheck(LoginDto logDtoReq){ 
		//��ġ�ϴ� ȸ���� �ִ��� Ȯ���ϰ� id ��ȯ
		return sqlSession.selectOne("login.checkInfo", logDtoReq);
	}
	
	public String getEncPw(String id){
		return sqlSession.selectOne("login.encPw", id);
	}
}
