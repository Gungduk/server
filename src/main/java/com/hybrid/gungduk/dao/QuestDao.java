package com.hybrid.gungduk.dao;

import java.util.HashMap;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.QuestDto;

public class QuestDao {

	@Autowired
	private SqlSession sqlSession;
	
	public QuestDto show(String qstNum){
		
		QuestDto dto = sqlSession.selectOne("quest.showQuest", qstNum);
		return dto;
	}

	public void successQuest (String id, String qstNum){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("qstNum", qstNum);
		
		sqlSession.update("quest.successQuest", map);
	}
}
