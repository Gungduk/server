package com.hybrid.gungduk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.gungduk.dao.LoginDao;
import com.hybrid.gungduk.dto.LoginDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="LoginResponse", description="로그인 API", basePath="/api/v1/login")
@RestController
public class LoginController {
	
	@Autowired
	LoginDao logDao;

	@ApiOperation(value = "login", notes = "email과 pw가 일치하면 세션에 userLogEmail이란 이름으로 email값을 저장한 후 1 반환/ 실패시 -1 반환")
    @RequestMapping(value="/api/v1/login", method=RequestMethod.POST)
    public @ResponseBody int loginProcess(@RequestBody LoginDto logDtoReq, HttpSession session){
	   
	   String loginUser = logDao.loginCheck(logDtoReq);
	   
	   if(loginUser != null){
		   session.setAttribute("userLogInfo", logDtoReq);
		   return 1;//성공
	   }
	   return -1;//실패
    }

	@ApiOperation(value = "logout", notes = "세션 모두 비우고 1반환")
    @RequestMapping(value="/api/v1/logout")
    public int logout(HttpSession session){
        session.invalidate();
        return 1;
    }
	/*
	 * 나중에 세션 필요한 페이지에서 session.getAttribute("userLogEmail");사용해서 LoginDto객체 전달받음
	 * if(session.getAttribute("userLogInfo") == null) : 로그인이 안된 상태
	 * 매 화면마다 session.getAttribute하기 귀찮으면 @SessionAttributes 세션 연동하기
	 * */
     
}