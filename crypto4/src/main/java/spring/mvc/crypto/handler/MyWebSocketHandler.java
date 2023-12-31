package spring.mvc.crypto.handler;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.util.HtmlUtils;
import org.springframework.scheduling.annotation.Scheduled;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

import spring.mvc.crypto.model.dao.CryptoDao;
import spring.mvc.crypto.model.entity.CryptoCurrency;
import spring.mvc.crypto.service.CryptoService;


@Component("myWebSocketHandler")
public class MyWebSocketHandler extends TextWebSocketHandler {
	
	enum Prop {

		TYPE("type"), CONTENT("content");

		private String name;

		private Prop(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}
	
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final Set<WebSocketSession> sessions = new CopyOnWriteArraySet<>();
	private final Gson gson = new Gson();
    
	@Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //當連線建立時傳送的消息
    	logger.info("Server connection opened");
		sessions.add(session);
		JsonObject messageObject = getJsonMessage("response", "one-time message from server");
		logger.info("Server sends: {}", messageObject);
		session.sendMessage(new TextMessage(gson.toJson(messageObject)));
       
    }
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		logger.info("Server connection closed: {}", status);
		sessions.remove(session);
	}

    @Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	String request = message.getPayload();
		logger.info("Server received: {}", request);

		JsonObject messageObject = getJsonMessage("response",
				String.format("response from server to '%s'", HtmlUtils.htmlEscape(request)));
		logger.info("Server sends: {}", messageObject);
		session.sendMessage(new TextMessage(gson.toJson(messageObject)));
	}

    @Override
	public void handleTransportError(WebSocketSession session, Throwable exception) {
		logger.info("Server transport error: {}", exception.getMessage());
	}
    
    private void sendMessageToClient(WebSocketSession session, String message) throws IOException {
		JsonObject messageObject = getJsonMessage("response", message);
		session.sendMessage(new TextMessage(gson.toJson(messageObject)));
	}
    
    private void sendMessageToAllClients(String message) throws IOException {
		for (WebSocketSession session : sessions) {
			sendMessageToClient(session, message);
		}
	}
    
    private JsonObject getJsonMessage(String type, Object content) {
		JsonObject messageObject = new JsonObject();
		messageObject.addProperty(Prop.TYPE.getName(), type);
		messageObject.addProperty(Prop.CONTENT.getName(), content.toString());
		return messageObject;
	}
    
    /**
	 * 排程程式，從資料庫取出資料，傳送給前端
	 */
    @Autowired
    private CryptoDao cryptoDaoMysql;
    
    @Scheduled(fixedRate = 10 * 1000)
    public void sendPeriodicMessages()throws IOException{
    	List<CryptoCurrency> cryptoCurrencies = cryptoDaoMysql.findAllCryptos();
    }

    

    
}
