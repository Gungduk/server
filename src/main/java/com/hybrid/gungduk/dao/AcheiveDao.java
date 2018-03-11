package com.hybrid.gungduk.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.AcheiveDto;

public class AcheiveDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public double count(String plcName){
		return sqlSession.selectOne("acheive.countAll", plcName);
	}
	
	public double yes(String email, String plcName){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("plcName", plcName);
		return sqlSession.selectOne("acheive.countYes", map);
	}
	
	public AcheiveDto putData(double GBacheive, double CGacheive, double DSacheive, double CDacheive){
		AcheiveDto acheiveDto = new AcheiveDto();
		
		acheiveDto.setGyeongbok(GBacheive);
		acheiveDto.setChanggyeong(CGacheive);
		acheiveDto.setDeoksu(DSacheive);
		acheiveDto.setChangdeok(CDacheive);
		
		return acheiveDto;
	}
	
	//퀘스트 완료 목록 
	public List<String> qstList(String email, String plcName){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("plcName", plcName);
		return sqlSession.selectList("acheive.successQst", map);
	}
}
