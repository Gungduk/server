package com.hybrid.gungduk.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.SendMailDto;
import com.hybrid.gungduk.dto.UserDto;

public class EmailDao {

	@Autowired
	private SqlSession sqlSession;
	
	private SendMailDto dto;
	
	public String searchEmail(String id){
		return sqlSession.selectOne("email.searchEmail", id);
	}
	
	public void updatePw(String pw, String id){
		dto = new SendMailDto(id, pw);
		sqlSession.update("email.updatePw", dto);
	}
}
