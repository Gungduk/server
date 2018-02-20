package com.hybrid.gungduk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hybrid.gungduk.dto.LoginDto;

@CrossOrigin(origins = "*")
@Controller
public class SessionTestController {
	
	@RequestMapping(value="/api/v1/test")
	public int sessionTest(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession(false);
		
		if(session == null) System.out.println("�α��� �Ǿ����� ����");
		else if(session.getAttribute("userLogInfo") == null) System.out.println("�α��� �Ǿ����� ����");
		
		LoginDto logInfo = (LoginDto) session.getAttribute("userLogInfo");
		String s = logInfo.getEmail();
		s += logInfo.getPw();
		System.out.println(s);
		System.out.println("�Ϸ�!!!!!!!!!!!!");
		return 1;
	}
}
