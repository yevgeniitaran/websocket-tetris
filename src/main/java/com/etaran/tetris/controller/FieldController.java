package com.etaran.tetris.controller;

import com.etaran.tetris.controller.dto.FieldDto;
import com.etaran.tetris.service.FieldService;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class FieldController {

    private final FieldService fieldService;
    private final SimpMessagingTemplate template;

    public FieldController(FieldService fieldService, SimpMessagingTemplate template) {
        this.fieldService = fieldService;
        this.template = template;
    }

    @Scheduled(fixedRate = 1000)
    @MessageMapping("/tetris")
    public void getField() {
        fieldService.tick();
        this.template.convertAndSend("/topic/game", new FieldDto(fieldService.getField().toString()));
    }

}