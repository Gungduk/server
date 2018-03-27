package com.hybrid.gungduk.handler;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.hybrid.gungduk.dao.QuestDao;


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
		int latitude = (int) jsonObject.get("latitude");
		int longitude = (int) jsonObject.get("longitude");
		
		//TextMessage msg = questDao.rangeQuest(latitude, longitude);
        if (session.isOpen()){
        	try{
        			session.sendMessage(msg);
        	}catch (Exception ignored){
        			System.out.println("fail to send message!");
        	}
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
