package com.example.demo.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class InputMessage {

    private Long chat_id;
    private String from;
    private String text;
}
