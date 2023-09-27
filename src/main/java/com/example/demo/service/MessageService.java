package com.example.demo.service;

import com.example.demo.dto.InputMessageDTO;
import com.example.demo.model.InputMessage;

public interface MessageService {
    InputMessage save(InputMessageDTO message);
}
