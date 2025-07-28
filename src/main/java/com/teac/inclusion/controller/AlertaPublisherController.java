package com.teac.inclusion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alertas")
@RequiredArgsConstructor
public class AlertaPublisherController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping
    public ResponseEntity<?> enviarAlerta(@RequestBody String mensaje) {
        rabbitTemplate.convertAndSend("alertas.exchange", "alertas.routing.key", mensaje);
        return ResponseEntity.ok("Mensaje enviado a RabbitMQ");
    }
}


