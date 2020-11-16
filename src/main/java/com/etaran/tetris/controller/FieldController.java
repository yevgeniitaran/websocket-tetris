package com.etaran.tetris.controller;

import com.etaran.tetris.controller.dto.FieldDto;
import com.etaran.tetris.controller.dto.Message;
import com.etaran.tetris.controller.dto.OutputMessage;
import com.etaran.tetris.model.Field;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FieldController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage greeting(Message message) throws Exception {
//        Field field = new Field();
//        FieldDto fieldDto = new FieldDto(field.getFieldId());
//        Thread.sleep(1000); // simulated delay
//        return fieldDto;
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

}