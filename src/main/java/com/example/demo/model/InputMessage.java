package com.example.demo.model;

import com.example.demo.dto.InputMessageDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
public class InputMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Long chat_id;
    private String from;
    private String text;

    public InputMessage(InputMessageDTO messageDTO){
        chat_id = messageDTO.getChat_id();
        from = messageDTO.getFrom();
        text = messageDTO.getText();
    }
}
