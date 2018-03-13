package com.hybrid.gungduk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.LotateDto;
import com.hybrid.gungduk.dto.QuestDto;
import com.hybrid.gungduk.dto.SuccDto;
import com.hybrid.gungduk.dto.UserDto;

public class QuestDao {

	@Autowired
	private SqlSession sqlSession;
	
	private QuestDto dto;
	
	public QuestDto show(String qstName){
		
		QuestDto dto = sqlSession.selectOne("quest.showQuest", qstName);
		return dto;
	}
//	
//	public String checkAnswer(PlcDto plcDtoReq){
//		String answer = sqlSession.selectOne("quest.checkAnswer", plcDtoReq);
//		return answer;
//	}
//	
//	public int checkSucc(SuccDto sucDtoReq){
//		String yesOrNo = sqlSession.selectOne("quest.checkSucc", sucDtoReq);
//		if(yesOrNo != null)
//			return 2;//������
//		else 
//			return sqlSession.insert("quest.createSucc", sucDtoReq);//�������� ������ �������
//	}
}
