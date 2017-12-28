package com.hybrid.gungduk.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.hybrid.gungduk.dto.TestDto;

public class TestDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void getName(){
		
	
	}
}
