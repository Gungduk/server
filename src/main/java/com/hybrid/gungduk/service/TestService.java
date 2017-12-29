package com.hybrid.gungduk.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hybrid.gungduk.dao.TestDao;

@Service
public class TestService {

	@Autowired
	TestDao testDao;
	
	
}
