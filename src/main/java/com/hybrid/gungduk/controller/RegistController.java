package com.hybrid.gungduk.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.gungduk.dao.RegistDao;
import com.hybrid.gungduk.dto.UserDto;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@Api(value="RegistResponse", description="회원가입 API", basePath="/api/v1/regist")
@RestController
public class RegistController {
	
	@Autowired
	RegistDao regDao;
	
	@RequestMapping(value = "/api/v1/regist", method = RequestMethod.POST)
	public @ResponseBody int regist(@RequestBody UserDto regDtoReq){

		String id = regDtoReq.getId();
		
		int rs = regDao.registerCheck(id);
		if(rs == 0){ 
			return -1; //이미 존재하는 회원임
		}else if(rs == 1){
			rs = regDao.register(regDtoReq);//성공하면 1
			regDao.insertQuest(id);
		}
		return rs;
	}
	
}
