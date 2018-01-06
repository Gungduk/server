package com.hybrid.gungduk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.gungduk.dao.RegDao;
import com.hybrid.gungduk.dto.RegDto;

@Controller
@RequestMapping(value = "/api/v1/regist")
public class RegController {
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public RegDto regist(@RequestBody RegDto regDtoReq, HttpSession session){
		String email = regDtoReq.getEmail();
		String pw = regDtoReq.getPw();
		String phoneNum = regDtoReq.getPhoneNum();
		if(email ==null || email.equals("") || pw ==null || pw.equals("") || phoneNum ==null || phoneNum.equals("")){
			session.setAttribute("messageType", "오류메시지");
			session.setAttribute("messageContent", "모든 내용을 입력하세요");
			return regDtoReq;
		}
		int result = new RegDao().register(email, pw, phoneNum);
		if(result == 1){
			session.setAttribute("messageType", "성공메시지");
			session.setAttribute("messageContent", "회원가입에 성공했습니다.");
			return regDtoReq;
		}else{
			session.setAttribute("messageType", "오류메시지");
			session.setAttribute("messageContent", "이미 존재하는 회원입니다.");
			return regDtoReq;
		}
	}
	
}
