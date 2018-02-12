package com.hybrid.gungduk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.gungduk.dao.AcheiveDao;
import com.hybrid.gungduk.dto.AcheiveDto;

import io.swagger.annotations.Api;

@Api(value="AcheiveResponse", description="´Þ¼º·ü API", basePath="/api/v1/acheive")
@RestController
public class AcheiveController {

	@Autowired
	AcheiveDao acheiveDao;
	
	@RequestMapping(value = "/api/v1/acheive", method = RequestMethod.POST)
	public @ResponseBody AcheiveDto acheive(@RequestParam String email){
		
		AcheiveDto acheiveDto = null;
		
		double GBCount = acheiveDao.count("°æº¹±Ã");//°æº¹
		double CGCount = acheiveDao.count("Ã¢°æ±Ã");//Ã¢°æ
		double DSCount = acheiveDao.count("´ö¼ö±Ã");//´ö¼ö
		double CDCount = acheiveDao.count("Ã¢´ö±Ã");//Ã¢´ö
		
		double GBYes = acheiveDao.yes(email, "°æº¹±Ã");
		double CGYes = acheiveDao.yes(email, "Ã¢°æ±Ã");
		double DSYes = acheiveDao.yes(email, "´ö¼ö±Ã");
		double CDYes = acheiveDao.yes(email, "Ã¢´ö±Ã");
		
		double GBacheive = GBYes / GBCount * (double)100;
		double CGacheive = CGYes / CGCount * (double)100;
		double DSacheive = DSYes / DSCount * (double)100;
		double CDacheive = CDYes / CDCount * (double)100;
		
		return acheiveDao.putData(GBacheive, CGacheive, DSacheive, CDacheive);
	}
	
}
