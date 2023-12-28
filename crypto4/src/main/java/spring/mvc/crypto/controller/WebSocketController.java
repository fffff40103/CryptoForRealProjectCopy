package spring.mvc.crypto.controller;

import org.springframework.stereotype.Controller;

/*
 * 用來處理從客戶端傳送過來的請求，
 * @MessageMapping("/crypto-updates")這段是客換端發送請求時傳送過來的網址
 * @SendTo("/topic/cryptoUpdates")當server接收到請求時，會透過這個網址發送response回去給客戶端
 * */
@Controller
public class WebSocketController {
		
	    /*
	    @MessageMapping("/crypto-updates")
	    @SendTo("/topic/cryptoUpdates")
	    public String handleCryptoUpdates
		*/
}