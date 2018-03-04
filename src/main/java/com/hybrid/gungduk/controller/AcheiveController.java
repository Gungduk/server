package com.hybrid.gungduk.controller;

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
		
		double GBCount = acheiveDao.count("경복궁");
		double CGCount = acheiveDao.count("창경궁");
		double DSCount = acheiveDao.count("덕수궁");
		double CDCount = acheiveDao.count("창덕궁");
		
		double GBYes = acheiveDao.yes(email, "경복궁");
		double CGYes = acheiveDao.yes(email, "창경궁");
		double DSYes = acheiveDao.yes(email, "덕수궁");
		double CDYes = acheiveDao.yes(email, "창덕궁");
		
		double GBacheive = GBYes / GBCount * (double)100;
		double CGacheive = CGYes / CGCount * (double)100;
		double DSacheive = DSYes / DSCount * (double)100;
		double CDacheive = CDYes / CDCount * (double)100;
		
		return acheiveDao.putData(GBacheive, CGacheive, DSacheive, CDacheive);
	}
	
}
