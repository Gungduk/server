package com.hybrid.gungduk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.gungduk.dto.LoginDto;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@Api(value="Test", description="로그인테스트", basePath="/api/v1/test")
@RestController
public class SessionTestController {
   
   @RequestMapping(value="/api/v1/test")
   public String sessionTest(HttpServletRequest request, HttpServletResponse response){
      
      HttpSession session = request.getSession(false);
      
      if(session == null) System.out.println("로그인 되어있지 않음");
      else if(session.getAttribute("userLogInfo") == null) System.out.println("로그인 되어있지 않음");
      
      LoginDto logInfo = (LoginDto) session.getAttribute("userLogInfo"); 
      String s = logInfo.getId();
      
      return s;
   }
}