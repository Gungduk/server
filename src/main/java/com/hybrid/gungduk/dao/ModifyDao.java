package com.hybrid.gungduk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.UserDto;

public class ModifyDao {

	@Autowired
	private SqlSession sqlSession;
	
	private UserDto dto;
	
	public String validate(String id){
		return sqlSession.selectOne("modify.validate", id);
	}
	
	public List<UserDto> info(String id){
		return sqlSession.selectList("modify.info", id);
	}
	
	
	public void updateInfo(String id, String pw, String phoneNum, String email){
		int level = 0;
		dto = new UserDto(id, pw, phoneNum, email, level);

		sqlSession.update("modify.updateInfo",dto);
	}
}
