package be.ucm.jds.BL.Entity.websocket;

import be.ucm.jds.BL.Entity.Utilisateur;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class WebSocketChatMessage implements Serializable {
    private String sender;
    private String content;
    private MessageType type;
    private LocalDateTime date;
    private Boolean reply;
//    private File files;
    private Utilisateur user;

    public WebSocketChatMessage(String content) {
        this.content = content;
    }

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}