package com.hybrid.gungduk.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.gungduk.dao.AcheiveDao;
import com.hybrid.gungduk.dto.AcheiveDto;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")

@Api(value="AcheiveResponse", description="달성률 API", basePath="/api/v1/acheive")
@RestController
public class AcheiveController {

	@Autowired
	AcheiveDao acheiveDao;
	
	@RequestMapping(value = "/api/v1/acheive", method = RequestMethod.POST)
	public @ResponseBody AcheiveDto acheive(@RequestParam String email){
		
		AcheiveDto acheiveDto = null;
		
		double GBCount = acheiveDao.count("kbk");
		double CGCount = acheiveDao.count("ckk");
		double DSCount = acheiveDao.count("dsk");
		double CDCount = acheiveDao.count("cdk");
		
		double GBYes = acheiveDao.yes(email, "kbk");
		double CGYes = acheiveDao.yes(email, "ckk");
		double DSYes = acheiveDao.yes(email, "dsk");
		double CDYes = acheiveDao.yes(email, "cdk");
		
		double GBacheive = GBYes / GBCount * (double)100;
		double CGacheive = CGYes / CGCount * (double)100;
		double DSacheive = DSYes / DSCount * (double)100;
		double CDacheive = CDYes / CDCount * (double)100;
		
		return acheiveDao.putData(GBacheive, CGacheive, DSacheive, CDacheive);
	}
	
	//완료된 퀘스트이름 리스트
	 @RequestMapping(value = "/api/v1/successQst", method = RequestMethod.POST)
	 public @ResponseBody List<String> acheive(@RequestParam String email, String plcName){
	 	return acheiveDao.qstList(email, plcName);
	 }
}
