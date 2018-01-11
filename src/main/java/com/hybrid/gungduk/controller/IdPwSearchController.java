package com.hybrid.gungduk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.gungduk.dao.IdPwSearchDao;

@Controller
public class IdPwSearchController {

	@Autowired
	IdPwSearchDao idPwSearchDao;
	
	@RequestMapping(value = "/api/v1/searchId", method = RequestMethod.POST)
	public @ResponseBody String searchId(@RequestParam String phoneNum){
		return idPwSearchDao.searchId(phoneNum);
	}
	
	@RequestMapping(value = "/api/v1/searchPw", method = RequestMethod.POST)
	public @ResponseBody String searchPw(@RequestParam String email){
		return idPwSearchDao.searchPw(email);
	}
}
