package com.hybrid.gungduk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.UserDto;

public class ModifyDao {

	@Autowired
	private SqlSession sqlSession;
	
	private UserDto dto;
	
	
	public List<UserDto> info(String id){
		return sqlSession.selectList("modify.info", id);
	}
	
	
	public void updateInfo(String id, String pw, String phoneNum, String email){
		dto = new UserDto(id, pw, phoneNum, email);

		sqlSession.update("modify.updateInfo",dto);
	}
}

