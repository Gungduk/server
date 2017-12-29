package com.hybrid.gungduk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class TestDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<String> getName(){
		List<String> names = sqlSession.selectList("test.getName");
		System.out.println(names);
	
		return names;
	}
}
