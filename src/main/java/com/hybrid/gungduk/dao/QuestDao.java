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

	public void finishQuest (String id, String qstName){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("qstName", qstName);
		
		sqlSession.update("quest.finishQuest", map);
	}
	
	public QuestDto rangeQuest (int latitude, int longitude){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("latitude", latitude);
		map.put("longitude", longitude);
		
		return sqlSession.selectOne("quest.rangeQuest", map);
	}
}
