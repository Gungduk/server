package com.hybrid.gungduk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.gungduk.dao.QuestDao;
import com.hybrid.gungduk.dto.PlcDto;
import com.hybrid.gungduk.dto.QuestDto;
import com.hybrid.gungduk.dto.SuccDto;
import com.hybrid.gungduk.dto.UserDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="questResponse", description="퀘스트 API", basePath="/api/v1/quest")
@RestController
public class QuestCheckController {
	
	@Autowired
	QuestDao questDao;
	
	@ApiOperation(value = "showQuest", notes = "해당 퀘스트의 정보 띄워주기")
	@RequestMapping(value = "/api/v1/quest", method = RequestMethod.POST)
	public @ResponseBody QuestDto showQuest(@RequestBody PlcDto plcDtoReq){
		
		QuestDto rs = questDao.show(plcDtoReq);
		return rs;
	} 
	
	@ApiOperation(value = "answerCheck", notes = "사용자가 선택한 보기가 답이랑 맞는지 확인")
	@RequestMapping(value = "/api/v1/quest/submit", method = RequestMethod.POST)
	public @ResponseBody int checkAnswer(@RequestBody PlcDto plcDtoReq){
		String input = plcDtoReq.getInput();
		String answer = questDao.checkAnswer(plcDtoReq);
		
		if(input.equals(answer))
			return 1;//정답일 경우 -> /api/v1/quest/submit/success 실행
		else
			return -1;//틀렸을 경우 -> 끝
	}
	
	@ApiOperation(value = "correct", notes = "정답일경우")
	@RequestMapping(value = "/api/v1/quest/submit/success", method = RequestMethod.POST)
	public @ResponseBody int questSuccess(@RequestBody SuccDto succDtoReq){
		
		int rs = questDao.checkSucc(succDtoReq);
		return rs;
	}
} 
		
		
		
		

