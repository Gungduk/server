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

@Api(value="AcheiveResponse", description="�떖�꽦瑜� API", basePath="/api/v1/acheive")
@RestController
public class AcheiveController {

	@Autowired
	AcheiveDao acheiveDao;
	
	@RequestMapping(value = "/api/v1/acheive", method = RequestMethod.POST)
	public @ResponseBody AcheiveDto acheive(@RequestParam String id){
		
		AcheiveDto acheiveDto = null;
		
		double GBCount = acheiveDao.count("kbk");
		double CGCount = acheiveDao.count("ckk");
		double DSCount = acheiveDao.count("dsk");
		double CDCount = acheiveDao.count("cdk");
		
		double GBYes = acheiveDao.yes(id, "kbk");
		double CGYes = acheiveDao.yes(id, "ckk");
		double DSYes = acheiveDao.yes(id, "dsk");
		double CDYes = acheiveDao.yes(id, "cdk");
		
		double GBacheive = GBYes / GBCount * (double)100;
		double CGacheive = CGYes / CGCount * (double)100;
		double DSacheive = DSYes / DSCount * (double)100;
		double CDacheive = CDYes / CDCount * (double)100;
		
		return acheiveDao.putData(GBacheive, CGacheive, DSacheive, CDacheive);
	}
	
	//�셿猷뚮맂 �섏뒪�듃�씠由� 由ъ뒪�듃
	 @RequestMapping(value = "/api/v1/successQst", method = RequestMethod.POST)
	 public @ResponseBody List<String> acheive(@RequestParam String id, String plcName){
	 	return acheiveDao.qstList(id, plcName);
	 }
}
