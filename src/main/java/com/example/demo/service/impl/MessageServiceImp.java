package com.example.demo.service.impl;

import com.example.demo.dto.InputMessageDTO;
import com.example.demo.model.InputMessage;
import com.example.demo.repository.MessageRepository;
import com.example.demo.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class MessageServiceImp implements MessageService {
    private final MessageRepository messageRepository;

    public MessageServiceImp(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public InputMessage save(InputMessageDTO message) {
        return messageRepository.save(new InputMessage(message));
    }
}
