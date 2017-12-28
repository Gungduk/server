package com.hybrid.gungduk.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.gungduk.dao.IDao;


@Controller
@RequestMapping("/api/v1/test")
public class TestController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public Model getName(Model model){
		
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("names", dao.getName());
	
		
		return model;
	}
}
