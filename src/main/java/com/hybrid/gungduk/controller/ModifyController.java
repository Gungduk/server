package com.hybrid.gungduk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.gungduk.dao.ModifyDao;

@CrossOrigin(origins = "*")
@Controller
public class ModifyController {

	@Autowired
	ModifyDao modifyDao;
	
	@RequestMapping(value = "/api/v1/modifyInfo", method = RequestMethod.POST)
	public @ResponseBody List<Object> modifyInfo(@RequestParam String email){
		return modifyDao.info(email);
	}
	
	@RequestMapping(value = "/api/v1/updateInfo", method = RequestMethod.POST)
	public @ResponseBody void updateInfo(@RequestParam String email, String pw, String phoneNum){
		modifyDao.updateInfo(email, pw, phoneNum);
	}
}
