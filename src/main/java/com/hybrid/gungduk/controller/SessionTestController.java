package com.hybrid.gungduk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hybrid.gungduk.dto.LoginDto;

@Controller
public class SessionTestController {
	
	@RequestMapping(value="/api/v1/test")
	public int sessionTest(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession(false);
		
		if(session == null) System.out.println("로그인 되어있지 않음");
		else if(session.getAttribute("userLogInfo") == null) System.out.println("로그인 되어있지 않음");
		
		LoginDto logInfo = (LoginDto) session.getAttribute("userLogInfo");
		String s = logInfo.getEmail();
		s += logInfo.getPw();
		System.out.println(s);
		System.out.println("완료!!!!!!!!!!!!");
		return 1;
	}
}
