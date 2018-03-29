package com.hybrid.gungduk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import com.hybrid.gungduk.dao.QuestDao;
import com.hybrid.gungduk.dto.QuestDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Api(value="questResponse", description="퀘스트API", basePath="/api/v1/quest")
@RestController
public class QuestCheckController {
	
	@Autowired
	QuestDao questDao;
	
	@ApiOperation(value = "showQuest", notes = "해당 퀘스트의 정보 띄워주기")
	@RequestMapping(value = "/api/v1/showQuest", method = RequestMethod.GET)
	public @ResponseBody QuestDto showQuest(@RequestParam String qstNum){
		
		QuestDto rs = questDao.show(qstNum);
		return rs;
	} 

	@ApiOperation(value = "finishQuest", notes = "해당 퀘스트의 yesOrNo 업데이트")
	@RequestMapping(value = "/api/v1/finishQuest", method = RequestMethod.POST)
	public @ResponseBody void finishQuest(@RequestParam String id, String qstName){
		
		questDao.finishQuest(id, qstName);
	} 


} 
		
		
		
		

