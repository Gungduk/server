package com.hybrid.gungduk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hybrid.gungduk.dao.TestDao;


@Controller
@RequestMapping("/api/v1/test")
public class TestController {
	
	@Autowired
	TestDao testDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public void getName(Model model){
		testDao.getName();
		
	}
}
