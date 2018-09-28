package com.hybrid.gungduk.dao;

import java.util.HashMap;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.AcheiveDto;
import com.hybrid.gungduk.dto.LevelDto;
import com.hybrid.gungduk.dto.QuestDto;
import com.hybrid.gungduk.dto.RangeQuestDto;

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
	
	public QuestDto rangeQuest (double latitude, double longitude, String id){
		RangeQuestDto dto = new RangeQuestDto(latitude, longitude, id);
		
		return sqlSession.selectOne("quest.rangeQuest", dto);
	}
	
	public int statusCheck(String id){
		return sqlSession.selectOne("quest.status", id);
	}
	
	public void quitQuest (String id, String qstName){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("qstName", qstName);
		
		sqlSession.update("quest.quitQuest", map);
	}
	
	public void changeStatus (QuestDto questDto, String id){
		String qstName = questDto.getQstName();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("qstName", qstName);
		sqlSession.update("quest.changeStatus", map);
	}
	
	
	///////////레벨, 퍼센트
	public double countAllYes(String id){
		return sqlSession.selectOne("quest.countAllYes", id);
	}
	
	public void changeLevel(int level, String id){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("level", level);
		map.put("id", id);
		sqlSession.update("quest.changeLevel", map);
	}
	
	public LevelDto putLevel(int level, double percent){
		LevelDto levelDto = new LevelDto();
		
		levelDto.setLevel(level);
		levelDto.setPercentage(percent);
		
		return levelDto; 
	}
}
