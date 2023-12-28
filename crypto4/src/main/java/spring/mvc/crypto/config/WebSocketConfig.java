package spring.mvc.crypto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration//一個spring的配置項
@EnableWebSocket//標註讓websocket支持
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    	//這是websocket的端點，可以與websocket建立連線
        registry.addHandler(new MyWebSocketHandler(), "/websocket")
                .setAllowedOrigins("*"); // 允許所有源進行連線，可以根據實際情況修改

        // 你也可以添加其他的WebSocket配置，例如拦截器等
    }
}
