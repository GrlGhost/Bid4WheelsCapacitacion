package com.example.demo.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class InputMessageDTO {
    private Long chat_id;
    private String from;
    private String text;
}
