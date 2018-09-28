package com.hybrid.gungduk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.gungduk.dao.LoginDao;
import com.hybrid.gungduk.dto.LoginDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Api(value="LoginResponse", description="로그인API", basePath="/api/v1/login")
@RestController
public class LoginController {
	
	@Autowired
	LoginDao logDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/kakaoLogin", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
	public String kakaoLogin(@RequestParam("code") String code) {
		System.out.println("code:" + code);
		return code;
	}

	@ApiOperation(value = "login", notes = "id怨� pw媛� �씪移섑븯硫� �꽭�뀡�뿉 userLogInfo�씠�� �씠由꾩쑝濡� LoginDto媛믪쓣 ���옣�븳 �썑 1 諛섑솚/ �떎�뙣�떆 -1 諛섑솚")
    @RequestMapping(value="/api/v1/login", method=RequestMethod.POST)
	public @ResponseBody String loginProcess(@RequestBody LoginDto logDtoReq, HttpSession session){

		String encPw = logDao.getEncPw(logDtoReq.getId());
		String rawPw = logDtoReq.getPw();
		if(rawPw == null) return "fail";
		
		if(passwordEncoder.matches(rawPw, encPw)){
			logDtoReq.setPw(encPw);
			session.setAttribute("userLogInfo", logDtoReq);
		    LoginDto logInfo = (LoginDto) session.getAttribute("userLogInfo"); 
		       String s = logInfo.getId();
		    return s;
		}
		
//	    String loginUser = logDao.loginCheck(logDtoReq);//loginUser null이면 불일치
//	   
//	    if(loginUser != null){
//		    session.setAttribute("userLogInfo", logDtoReq);
//		    LoginDto logInfo = (LoginDto) session.getAttribute("userLogInfo"); 
//		       String s = logInfo.getId();
//		    return s;//����
//	    }
	    return "fail";//����
    }

	@ApiOperation(value = "logout", notes = "占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙 1占쏙옙환")
    @RequestMapping(value="/api/v1/logout")
    public int logout(HttpSession session){
        session.invalidate();
		//session.removeAttribute("userLogInfo");
        return 1;
    }
	/*
	 * �굹以묒뿉 �꽭�뀡 �븘�슂�븳 �럹�씠吏��뿉�꽌 session.getAttribute("userLogInfo");�궗�슜�빐�꽌 LoginDto媛앹껜 �쟾�떖諛쏆쓬
	 * if(session.getAttribute("userLogInfo") == null) : 濡쒓렇�씤�씠 �븞�맂 �긽�깭
	 * 留� �솕硫대쭏�떎 session.getAttribute�븯湲� 洹�李��쑝硫� @SessionAttributes �꽭�뀡 �뿰�룞�븯湲�
	 * */
     
}