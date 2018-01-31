package com.hybrid.gungduk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.UserDto;

public class ModifyDao {

	@Autowired
	private SqlSession sqlSession;
	
	private UserDto dto;
	
	
	public List<Object> info(String email){
		return sqlSession.selectList("modify.info");
	}
	
	
	public void updateInfo(String email, String pw, String phoneNum){
		dto = new UserDto(email, pw, phoneNum);

		sqlSession.update("orm.mybatis.MemberMapper.update",dto);
	}
}
