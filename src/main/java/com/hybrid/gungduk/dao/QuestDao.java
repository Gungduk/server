package com.hybrid.gungduk.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.LotateDto;
import com.hybrid.gungduk.dto.QuestDto;

public class QuestDao {

	@Autowired
	private SqlSession sqlSession;
	
	public QuestDto show(LotateDto lotateDtoReq){
		QuestDto result = sqlSession.selectOne("quest.showQuest", lotateDtoReq);
		return result;
	}

	public void successQuest (String email, String qstName){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("qstName", qstName);
		
		sqlSession.update("quest.successQuest", map);
	}
}
