package com.teac.inclusion.websocket;

import com.teac.inclusion.model.Message;
import com.teac.inclusion.model.WebSocketMessage;
import com.teac.inclusion.repository.WebSocketMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class SocketRoleController {

    @Autowired
    private WebSocketMessageRepository messageRepository;

    @MessageMapping("/roles/send")
    @SendTo("/topic/roles")
    public Message handleRoleMessage(Message message) {
        // Guardar en BD
        messageRepository.save(WebSocketMessage.builder()
                .sender(message.getFrom())
                .content(message.getContent())
                .timestamp(LocalDateTime.now())
                .build());

        message.setContent("Servidor recibió: " + message.getContent());
        return message;
    }
}



