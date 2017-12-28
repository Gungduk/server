package com.hybrid.gungduk.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hybrid.gungduk.dao.TestDao;

@Service
public class TestService {

	@Autowired
	TestDao testDao;
	
	/*public Map<String, Object> getName(){
		return testDao.getName();
	}*/
}
