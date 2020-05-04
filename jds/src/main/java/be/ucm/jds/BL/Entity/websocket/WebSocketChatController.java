package be.ucm.jds.BL.Entity.websocket;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WebSocketChatController {

    @MessageMapping("/send/message")
    @SendTo("/chat")
    public WebSocketChatMessage sendMessage(@Payload WebSocketChatMessage webSocketChatMessage) {
        System.out.println(webSocketChatMessage.getContent());
        return webSocketChatMessage;
    }
}
