package com.hybrid.gungduk.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class IdPwSearchDao {

	@Autowired
	private SqlSession sqlSession;
	
	public String searchId(String phoneNum){
		return sqlSession.selectOne("search.searchId", phoneNum);
	}
	
	public String searchPw(String email){
		return sqlSession.selectOne("search.searchPw", email);
	}
}
