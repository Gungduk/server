package com.hybrid.gungduk.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.UserDto;

public class RegistDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int registerCheck(String email){ //�ߺ��Ǵ� ���̵� �ִ��� üũ
	
		String rs = sqlSession.selectOne("register.registCheck", email);
		
		if(rs != null) return 0; //�̹� �����ϴ� ȸ��
		else return 1; //���� ������ ȸ�� ���̵�
	}
	
	public int register(UserDto regDtoReq){
		return sqlSession.insert("register.regist", regDtoReq);
	}
	
	public List<String> getQuest(){
		return sqlSession.selectList("register.getQuest");
	}
	
	public void insertQuest(String email){
		List<String> qst = getQuest();
		HashMap<String, String> map = new HashMap<String, String>();
		Iterator<String> iterator = qst.iterator();
		map.put("email", email);
		
		while(iterator.hasNext()){
			map.put("qstName", iterator.next());
			sqlSession.insert("register.insertQuest", map);
		}
	}
}
