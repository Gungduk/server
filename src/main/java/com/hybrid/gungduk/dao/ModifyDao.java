package com.hybrid.gungduk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class ModifyDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Object> info(){
		return sqlSession.selectList("modify.info");
	}
	
	public void updateInfo(){
		sqlSession.update("modify.updateInfo");
	}
}
