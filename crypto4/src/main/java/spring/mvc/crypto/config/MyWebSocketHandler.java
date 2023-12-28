package spring.mvc.crypto.config;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

//實現自己websocket處理器的地方
public class MyWebSocketHandler implements WebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //當連線建立時傳送的消息
    	System.out.println("WebSocket連線已建立");
        // 可以在這裡進行一些初始化操作
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        //接收到消息時的處理
    	System.out.println("接收到消息：" + message.getPayload());
        // 在這裡處理接收到的消息
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        //連線錯誤時的處理
    	System.out.println("連線出現錯誤");
        // 可以在這裡處理連線錯誤
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        //連線關閉時的處理
    	System.out.println("WebSocket連線已關閉");
        // 可以在這裡進行一些清理操作
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
