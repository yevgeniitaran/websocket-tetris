package com.etaran.tetris.controller;

import com.etaran.tetris.controller.dto.FieldDto;
import com.etaran.tetris.model.Field;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class FieldController {

    @MessageMapping("/tetris")
    @SendTo("/topic/game")
    public FieldDto getField() {
        Field field = new Field();
        return new FieldDto(field.toString());
    }

}