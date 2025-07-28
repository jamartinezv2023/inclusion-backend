package com.teac.inclusion.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import static com.teac.inclusion.config.RabbitMQConfig.QUEUE;

@Component
@RequiredArgsConstructor
public class AlertaWebSocketListener {

    private final SimpMessagingTemplate messagingTemplate;

    @RabbitListener(queues = QUEUE)
    public void recibirAlerta(String mensaje) {
        messagingTemplate.convertAndSend("/topic/alertas", mensaje);
    }
}
