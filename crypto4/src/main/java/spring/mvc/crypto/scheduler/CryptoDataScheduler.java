package spring.mvc.crypto.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import spring.mvc.crypto.model.entity.CryptoCurrency;
import spring.mvc.crypto.service.CryptoService;
import spring.mvc.crypto.service.WebSocketService;

//這個排程任務使用了 @Scheduled 標註，
//每5分鐘執行一次，爬蟲加密貨幣數據並通過 WebSocket 傳送給前端
public class CryptoDataScheduler {
	
	
	
	@Autowired
	private final CryptoService cryptoService;
    private final WebSocketService webSocketService;

    public CryptoDataScheduler(CryptoService cryptoService, WebSocketService webSocketService) {
        this.cryptoService = cryptoService;
        this.webSocketService = webSocketService;
    }

    @Scheduled(fixedRate = 300000)  // 每5分鐘執行一次
    public void crawlCryptoDataAndSendToWebSocket() {
        //List<CryptoCurrency> cryptoCurrencies = cryptoService.crawlCryptoData();
        //webSocketService.sendCryptoData(cryptoCurrencies);
    }
	
	
}
