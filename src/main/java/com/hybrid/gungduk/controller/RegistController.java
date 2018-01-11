package com.hybrid.gungduk.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.gungduk.dao.RegistDao;
import com.hybrid.gungduk.dto.UserDto;

@Controller
@RequestMapping(value = "/api/v1/regist", method = RequestMethod.POST)
public class RegistController {
	
	@Autowired
	RegistDao regDao;
	
	@ResponseBody
	public int regist(@RequestBody UserDto regDtoReq){

		String email = regDtoReq.getEmail();
		
		int rs = regDao.registerCheck(email);
		if(rs == 0) 
			return -1; //이미 존재하는 회원임
		else if(rs == 1)
			rs = regDao.register(regDtoReq);//성공하면 1
		return rs;
	}
	
}
