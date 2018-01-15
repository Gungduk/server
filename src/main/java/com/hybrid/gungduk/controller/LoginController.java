package com.hybrid.gungduk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.gungduk.dao.LoginDao;
import com.hybrid.gungduk.dto.LoginDto;

import io.swagger.annotations.Api;

@Api(value="LoginResponse", description="로그인 API", basePath="/api/v1/login")
@RestController
public class LoginController {
	
	@Autowired
	LoginDao logDao;

    @RequestMapping(value="/api/v1/login", method=RequestMethod.POST)
    public @ResponseBody int loginProcess(@RequestBody LoginDto logDtoReq, HttpSession session){
	   
	   String loginUser = logDao.loginCheck(logDtoReq);
	   
	   if(loginUser != null){
		   session.setAttribute("userLogEmail", loginUser);
		   return 1;//성공
	   }
	   return -1;//실패
   }
     
}