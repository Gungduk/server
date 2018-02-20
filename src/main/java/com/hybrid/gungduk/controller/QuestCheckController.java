package com.hybrid.gungduk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.gungduk.dao.QuestDao;
import com.hybrid.gungduk.dto.LotateDto;
import com.hybrid.gungduk.dto.QuestDto;
import com.hybrid.gungduk.dto.SuccDto;
import com.hybrid.gungduk.dto.UserDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Api(value="questResponse", description="����Ʈ API", basePath="/api/v1/quest")
@RestController
public class QuestCheckController {
	
	@Autowired
	QuestDao questDao;
	
	@ApiOperation(value = "showQuest", notes = "�ش� ����Ʈ�� ���� ����ֱ�")
	@RequestMapping(value = "/api/v1/quest", method = RequestMethod.POST)
	public @ResponseBody QuestDto showQuest(@RequestBody LotateDto lotateDtoReq){
		
		Double latitude = lotateDtoReq.getLatitude();
		Double logitude = lotateDtoReq.getLogitude();
		
		lotateDtoReq.setMaxLati(latitude+0.00006);
		lotateDtoReq.setMaxLogi(logitude+0.00006);
		lotateDtoReq.setMinLati(latitude-0.00006);
		lotateDtoReq.setMinLogi(logitude-0.00006);
		
		QuestDto rs = questDao.show(lotateDtoReq);
		return rs;
	} 
	
//	@ApiOperation(value = "answerCheck", notes = "����ڰ� ������ ���Ⱑ ���̶� �´��� Ȯ��")
//	@RequestMapping(value = "/api/v1/quest/submit", method = RequestMethod.POST)
//	public @ResponseBody int checkAnswer(@RequestBody PlcDto plcDtoReq){
//		String input = plcDtoReq.getInput();
//		String answer = questDao.checkAnswer(plcDtoReq);
//		
//		if(input.equals(answer))
//			return 1;//������ ��� -> /api/v1/quest/submit/success ����
//		else
//			return -1;//Ʋ���� ��� -> ��
//	}
//	
//	@ApiOperation(value = "correct", notes = "�����ϰ��")
//	@RequestMapping(value = "/api/v1/quest/submit/success", method = RequestMethod.POST)
//	public @ResponseBody int questSuccess(@RequestBody SuccDto succDtoReq){
//		
//		int rs = questDao.checkSucc(succDtoReq);
//		return rs;
//	}
} 
		
		
		
		

