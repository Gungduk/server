package com.hybrid.gungduk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.gungduk.dao.IdPwSearchDao;

@Controller
@RequestMapping(value = "/api/v1/idPwSearch", method = RequestMethod.POST)
public class IdPwSearchController {

	@Autowired
	IdPwSearchDao idPwSearchDao;
	
	public @ResponseBody String searchId(@RequestParam String phoneNum){
		return idPwSearchDao.searchId(phoneNum);
	}
	
	public @ResponseBody String searchPw(@RequestParam String email){
		return idPwSearchDao.searchPw(email);
	}
}
