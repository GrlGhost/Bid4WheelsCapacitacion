package com.example.demo.controller;

import com.example.demo.model.InputMessage;
import com.example.demo.model.OutputMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/private/{chat_id}")
    public void sendPositions(@PathVariable("chat_id") Long chat_id, @Payload InputMessage message){
        System.out.println("entro por aca");

        simpMessagingTemplate.convertAndSend("/topic/messages/"+chat_id,
                new OutputMessage(message.getFrom(), message.getText()) );
    }

}