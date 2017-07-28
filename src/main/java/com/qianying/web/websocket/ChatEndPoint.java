package com.qianying.web.websocket;

import com.google.gson.Gson;
import com.qianying.support.vo.ChatInfo;
import org.springframework.web.socket.*;

import java.util.HashMap;
import java.util.Map;

public class ChatEndPoint implements WebSocketHandler{
    private static final Map<String,WebSocketSession> webSocketSessionMap=new HashMap<>();
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {

        if(!webSocketSessionMap.containsKey(webSocketSession.getId())){
            System.out.println("put session id "+webSocketSession.getId()+" to map");
            synchronized(webSocketSessionMap){
                webSocketSessionMap.put(webSocketSession.getId(),webSocketSession);
            }
        }
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        System.out.println("get message from session id "+webSocketSession.getId());
        System.out.println(webSocketMessage.getPayload());
        Gson g = new Gson();

        ChatInfo chatInfo = g.fromJson(webSocketMessage.getPayload().toString(), ChatInfo.class);

        System.out.println("send message to:");
        for(WebSocketSession _webSocketSession:webSocketSessionMap.values()){
            synchronized(webSocketSessionMap){
                System.out.print(_webSocketSession.getId()+",");
                _webSocketSession.sendMessage(new TextMessage(chatInfo.getMessage()));
            }
            System.out.println();
        }
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        if(webSocketSessionMap.containsKey(webSocketSession.getId())){
            synchronized(webSocketSessionMap){
                System.out.println("remove session id "+webSocketSession.getId()+" from map");
                webSocketSessionMap.remove(webSocketSession.getId());
            }

        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

}