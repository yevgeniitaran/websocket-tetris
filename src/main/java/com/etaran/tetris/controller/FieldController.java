package com.etaran.tetris.controller;

import com.etaran.tetris.controller.dto.ActionDto;
import com.etaran.tetris.controller.dto.FieldDto;
import com.etaran.tetris.service.FieldService;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Configuration
@EnableScheduling
@Controller
public class FieldController {

    private final FieldService fieldService;
    private final SimpMessagingTemplate template;

    public FieldController(FieldService fieldService, SimpMessagingTemplate template) {
        this.fieldService = fieldService;
        this.template = template;
    }

    @Scheduled(fixedRate = 1000)
    public void fieldTick() {
        fieldService.tick();
        this.template.convertAndSend("/topic/game", new FieldDto(fieldService.getField().toString()));
    }

    @MessageMapping("/tetris")
    public void performAction(ActionDto actionDto) {
        fieldService.performAction(actionDto.getAction());
        this.template.convertAndSend("/topic/game", new FieldDto(fieldService.getField().toString()));
    }

}