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

//	@RequestMapping(value = "/kakaoLogin", produces = "application/json", method = { RequestMethod.GET,
//			RequestMethod.POST })
//	public void kakaoLogin(@RequestParam("code") String code) {
////		JsonNode node = service.getAccessTocken(code);
//		System.out.println("JSON 반환 : " + node.get("access_token"));
//		String accessTocken = node.get("access_token").asText();
////		JsonNode node2 = service.getKakaoUserInfo(accessTocken);
//
//		// Get id
//		String id = node2.path("id").asText();
//		String nickname = null;
//		String thumbnailImage = null;
//		String profileImage = null;
//		String email = null;
//
//		// 유저정보 카톡에서 가져오기 Get properties
//		JsonNode properties = node2.path("properties");
//		JsonNode kakao_account = node2.path("kakao_account");
//		
//		if (properties.isMissingNode()) {
//			// if "name" node is missing
//		} else {
//			nickname = properties.path("nickname").asText();
//			thumbnailImage = properties.path("thumbnail_image").asText();
//			profileImage = properties.path("profile_image").asText();
//
//			System.out.println("nickname : " + nickname);
//			System.out.println("thumbnailImage : " + thumbnailImage);
//			System.out.println("profileImage : " + profileImage);
//		}
//
//		if (kakao_account.isMissingNode()) {
//			// if "name" node is missing
//			System.out.println("없나봐 어쩌라고");
//		} else {
//			email = kakao_account.path("email").asText();
//
//			System.out.println("email : " + email);
//		}
//	}

	@ApiOperation(value = "login", notes = "id怨� pw媛� �씪移섑븯硫� �꽭�뀡�뿉 userLogInfo�씠�� �씠由꾩쑝濡� LoginDto媛믪쓣 ���옣�븳 �썑 1 諛섑솚/ �떎�뙣�떆 -1 諛섑솚")
	@RequestMapping(value = "/api/v1/login", method = RequestMethod.POST)
	public @ResponseBody String loginProcess(@RequestBody LoginDto logDtoReq, HttpSession session) {

		String encPw = logDao.getEncPw(logDtoReq.getId());
		String rawPw = logDtoReq.getPw();
		if (rawPw == null)
			return "fail";

		if (passwordEncoder.matches(rawPw, encPw)) {
			logDtoReq.setPw(encPw);
			session.setAttribute("userLogInfo", logDtoReq);
			LoginDto logInfo = (LoginDto) session.getAttribute("userLogInfo");
			String s = logInfo.getId();
			return s;
		}

		// String loginUser = logDao.loginCheck(logDtoReq);//loginUser null이면 불일치
		//
		// if(loginUser != null){
		// session.setAttribute("userLogInfo", logDtoReq);
		// LoginDto logInfo = (LoginDto) session.getAttribute("userLogInfo");
		// String s = logInfo.getId();
		// return s;//����
		// }
		return "fail";// ����
	}

	@ApiOperation(value = "logout", notes = "占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙 1占쏙옙환")
	@RequestMapping(value = "/api/v1/logout")
	public int logout(HttpSession session) {
		session.invalidate();
		// session.removeAttribute("userLogInfo");
		return 1;
	}
	/*
	 * �굹以묒뿉 �꽭�뀡 �븘�슂�븳 �럹�씠吏��뿉�꽌 session.getAttribute("userLogInfo");�궗�슜�빐�꽌
	 * LoginDto媛앹껜 �쟾�떖諛쏆쓬 if(session.getAttribute("userLogInfo") == null) : 濡쒓렇�씤�씠
	 * �븞�맂 �긽�깭 留� �솕硫대쭏�떎 session.getAttribute�븯湲� 洹�李��쑝硫� @SessionAttributes
	 * �꽭�뀡 �뿰�룞�븯湲�
	 */

}