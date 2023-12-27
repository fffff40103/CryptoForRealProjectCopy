

/*
WebSocket 控制器:
你可能還需要一個用於 WebSocket 通信的控制器，
可以在 controller 包中創建一個 WebSocketController.java 類：
*/

/*
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/crypto-updates")
    @SendTo("/topic/cryptoUpdates")
    public String handleCryptoUpdates
    
}
*/