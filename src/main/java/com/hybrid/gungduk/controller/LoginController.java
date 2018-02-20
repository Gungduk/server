package com.hybrid.gungduk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.gungduk.dao.LoginDao;
import com.hybrid.gungduk.dto.LoginDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Api(value="LoginResponse", description="�α��� API", basePath="/api/v1/login")
@RestController
public class LoginController {
	
	@Autowired
	LoginDao logDao;

	@ApiOperation(value = "login", notes = "email�� pw�� ��ġ�ϸ� ���ǿ� userLogInfo�̶� �̸����� LoginDto���� ������ �� 1 ��ȯ/ ���н� -1 ��ȯ")
    @RequestMapping(value="/api/v1/login", method=RequestMethod.POST)
    public @ResponseBody int loginProcess(@RequestBody LoginDto logDtoReq, HttpSession session){
	   
	   String loginUser = logDao.loginCheck(logDtoReq);
	   
	   if(loginUser != null){
		   session.setAttribute("userLogInfo", logDtoReq);
		   return 1;//����
	   }
	   return -1;//����
    }

	@ApiOperation(value = "logout", notes = "���� ��� ���� 1��ȯ")
    @RequestMapping(value="/api/v1/logout")
    public int logout(HttpSession session){
        session.invalidate();
		//session.removeAttribute("userLogInfo");
        return 1;
    }
	/*
	 * ���߿� ���� �ʿ��� ���������� session.getAttribute("userLogInfo");����ؼ� LoginDto��ü ���޹���
	 * if(session.getAttribute("userLogInfo") == null) : �α����� �ȵ� ����
	 * �� ȭ�鸶�� session.getAttribute�ϱ� �������� @SessionAttributes ���� �����ϱ�
	 * */
     
}