package com.hybrid.gungduk.handler;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.hybrid.gungduk.dao.QuestDao;
import com.hybrid.gungduk.dto.QuestDto;

@CrossOrigin(origins = "*")
public class SocketHandler extends TextWebSocketHandler implements InitializingBean{

	@Autowired
	QuestDao questDao;
	
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
    //클라이언트 연결 이후에 실행되는 메소드
    @Override
    public void afterConnectionEstablished(WebSocketSession session)throws Exception {
        sessionList.add(session);
        System.out.println("연결됨" + session.getId());
    }
    //클라이언트가 웹소켓서버로 메시지를 전송했을 때 실행되는 메소드
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(message.getPayload());
		double latitude = (Double) jsonObject.get("latitude");
		double longitude = (Double) jsonObject.get("longitude");
//		double latitude = (double) jsonObject.get("latitude");
//		double longitude = (double) jsonObject.get("longitude");
		String id = (String) jsonObject.get("id");		
		String json;
		JSONObject obj = new JSONObject();
		
		int status = questDao.statusCheck(id); //status가 1인 것의 개수
		if(status == 0){
			QuestDto dto = questDao.rangeQuest(latitude, longitude, id);
			
			obj.put("qstName", dto.getQstName());
			obj.put("info", dto.getInfo());
			obj.put("qst", dto.getQst());
			obj.put("answer", dto.getAnswer());
			obj.put("qstEx1", dto.getQstEx1());
			obj.put("qstEx2", dto.getQstEx2());
			obj.put("qstEx3", dto.getQstEx3());
			obj.put("imgUrl", dto.getImgUrl());
			json = obj.toJSONString();
			
		    questDao.changeStatus(dto, id);//status 1로 하기
		}else
			json = "";
		
        if (json.isEmpty()){
        	System.out.println("fail to send message!");
        }else{
        	session.sendMessage(new TextMessage(json));
        	System.out.println("send message!");
        }
    }
    
    //클라이언트가 연결을 끊었을 때 실행되는 메소드
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionList.remove(session);
        System.out.println(session.getId() + " 연결 끊김");
    }
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
	}
}
