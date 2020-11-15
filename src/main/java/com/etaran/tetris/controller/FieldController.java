package com.etaran.tetris.controller;

import com.etaran.tetris.controller.dto.FieldDto;
import com.etaran.tetris.model.Field;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class FieldController {

    @MessageMapping("/hello")
    @SendTo("/field/id")
    public FieldDto greeting() throws Exception {
        Field field = new Field();
        FieldDto fieldDto = new FieldDto(field.getFieldId());
        Thread.sleep(1000); // simulated delay
        return fieldDto;
    }

}