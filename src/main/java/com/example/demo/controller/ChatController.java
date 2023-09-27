package com.example.demo.controller;

import com.example.demo.dto.InputMessageDTO;
import com.example.demo.model.OutputMessage;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    private final MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/private")
    public void sendPositions(@Payload InputMessageDTO message){
        messageService.save(message);
        simpMessagingTemplate.convertAndSend("/topic/messages/"+message.getChat_id(),
                new OutputMessage(message.getFrom(), message.getText()) );
    }

}