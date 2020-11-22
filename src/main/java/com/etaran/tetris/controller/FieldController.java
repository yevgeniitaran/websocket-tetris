package com.etaran.tetris.controller;

import com.etaran.tetris.controller.dto.FieldDto;
import com.etaran.tetris.model.Field;
import com.etaran.tetris.service.FieldService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class FieldController {

    private final FieldService fieldService;

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @MessageMapping("/tetris")
    @SendTo("/topic/game")
    public FieldDto getField() {
        fieldService.tick();
        return new FieldDto(fieldService.getField().toString());
    }

}