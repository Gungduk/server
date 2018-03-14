package com.hybrid.gungduk.dao;

import java.util.HashMap;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.QuestDto;

public class QuestDao {

	@Autowired
	private SqlSession sqlSession;
	
	public QuestDto show(String qstName){
		
		QuestDto dto = sqlSession.selectOne("quest.showQuest", qstName);
		return dto;
	}

	public void successQuest (String email, String qstName){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("qstName", qstName);
		
		sqlSession.update("quest.successQuest", map);
	}
}
