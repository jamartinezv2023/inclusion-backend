package com.teac.inclusion.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlertaListener {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @RabbitListener(queues = "alertas.queue")
    public void recibirAlerta(String mensaje) {
        simpMessagingTemplate.convertAndSend("/topic/alertas", mensaje);
    }
}

